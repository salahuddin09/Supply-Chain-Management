/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.bl;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vaadin.terminal.StreamResource;
import com.vaadin.terminal.StreamResource.StreamSource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.sf.jasperreports.engine.JRException;
import org.scm.bl.ReportManager;

/**
 *
 * @author Personal
 */
public class FinishedProduct {
    public FinishedProduct() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException, DocumentException, FileNotFoundException, IOException {
        scsreport();
    }
     public void scsreport() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException, DocumentException, FileNotFoundException, IOException {
       final ByteArrayOutputStream os = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A5.rotate());
     
        PdfWriter.getInstance(document, os);
     
        // headers and footers must be added before the document is opened
HeaderFooter footer = new HeaderFooter(new Phrase("Page no: "), true);
footer.setBorder(Rectangle.NO_BORDER);
footer.setAlignment(Element.ALIGN_CENTER);
document.setFooter(footer);
 
HeaderFooter header = new HeaderFooter(new Paragraph("SUPPLY CHAIN SYSTEM FINISHED PRODUCT REPORT"), false);
header.setBorder(Rectangle.NO_BORDER);
header.setAlignment(Element.ALIGN_CENTER);
document.setHeader(header);

        document.open();
        document.add(new Paragraph(" "));
        //Specify the number of colums
        PdfPTable datatable = new PdfPTable(6);
      PdfPCell cell = new PdfPCell(new Paragraph("No"));
      datatable.addCell(cell);
      datatable.addCell("Product Name");
      datatable.addCell("Product Description");
      datatable.addCell("Product Unit");
      datatable.addCell("Product Weight");
      datatable.addCell("Store Location");
     
      //Here Specify the column width of the table
      int headerwidths[] = {5, 12, 12, 12, 12,12};
      datatable.setWidths(headerwidths);
      datatable.setWidthPercentage(100);
      datatable.getDefaultCell().setPadding(6);
      datatable.setHeaderRows(1);
      datatable.getDefaultCell().setBorderWidth(1);


        ReportManager re = new ReportManager();
        Connection con = re.DBConnectionForReport();
        Statement stm = con.createStatement();
ResultSet rs = stm.executeQuery("SELECT s.Product_ID,p.Product_Name,p.Product_Description,p.Product_Unit,p.Product_Weight,s.Store_Location FROM store s,product p where s.Product_Count<s.Product_Storage_Threshold AND p.Product_ID=s.Product_ID;");
        while (rs.next()) {
            datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            datatable.addCell(rs.getString("Product_ID"));
            datatable.addCell(rs.getString("Product_Name"));
            datatable.addCell(rs.getString("Product_Description"));
            datatable.addCell(rs.getString("Product_Unit"));
            datatable.addCell(rs.getString("Product_Weight"));
            datatable.addCell(rs.getString("Store_Location"));
          
        }
        stm.close();
        con.close();
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(datatable);
        document.close();
         
StreamSource s = new StreamResource.StreamSource() {

@Override
        public InputStream getStream() {
    return new ByteArrayInputStream(os.toByteArray());
}
        };

FileOutputStream fos = new FileOutputStream("F:/finishedproduct.pdf");
fos.write(os.toByteArray());
fos.close();

}

}
