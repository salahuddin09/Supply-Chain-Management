/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.ui;

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
public class ProductReport {
      public ProductReport() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException, DocumentException, FileNotFoundException, IOException {
        scsreport();
    }
// final ByteArrayOutputStream os = new ByteArrayOutputStream();

    public void scsreport() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException, DocumentException, FileNotFoundException, IOException {
       final ByteArrayOutputStream os = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A5.rotate());
       // final String RESULT = "E:/mystorereport.pdf";
        PdfWriter.getInstance(document, os);
        //PdfWriter.getInstance(document, os);
        
        
        // headers and footers must be added before the document is opened
HeaderFooter footer = new HeaderFooter(new Phrase("Page no: "), true);
footer.setBorder(Rectangle.NO_BORDER);
footer.setAlignment(Element.ALIGN_CENTER);
document.setFooter(footer);
 
HeaderFooter header = new HeaderFooter(new Paragraph("SUPPLY CHAIN SYSTEM PRODUCT REPORT"), false);
header.setBorder(Rectangle.NO_BORDER);
header.setAlignment(Element.ALIGN_CENTER);
document.setHeader(header);

        document.open();
        document.add(new Paragraph(" "));
        //Specify the number of colums
        PdfPTable datatable = new PdfPTable(8);
      PdfPCell cell = new PdfPCell(new Paragraph("No"));
      datatable.addCell(cell);
      datatable.addCell("Name");
      datatable.addCell("Description");
      datatable.addCell("Unit");
      datatable.addCell("Weight");
      datatable.addCell("Cost");
      datatable.addCell("Prior Year Sale");
      datatable.addCell("Current Year Sale");
      //Here Specify the column width of the table
      int headerwidths[] = {5, 12, 12, 12, 12, 12,12,12};
      datatable.setWidths(headerwidths);
      datatable.setWidthPercentage(100);
      datatable.getDefaultCell().setPadding(8);
      datatable.setHeaderRows(1);
      datatable.getDefaultCell().setBorderWidth(1);


        ReportManager re = new ReportManager();
        Connection con = re.DBConnectionForReport();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM product ORDER BY Product_ID");
        while (rs.next()) {
            datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            datatable.addCell(rs.getString("Product_ID"));
            datatable.addCell(rs.getString("Product_Name"));
            datatable.addCell(rs.getString("Product_Description"));
            datatable.addCell(rs.getString("Product_Unit"));
            datatable.addCell(rs.getString("Product_Weight"));
            datatable.addCell(rs.getString("Product_Cost"));
            datatable.addCell(rs.getString("Product_Prior_Year_Sales_Goal"));
            datatable.addCell(rs.getString("Product_Current_Year_Sales_Goal"));
            
            
          //  document.setPageSize(PageSize.A5);
          //  document.setMargins(36, 72, 108, 180);
          //  document.setMarginMirroring(true);
         //   document.setMarginMirroringTopBottom(true);
        }
        stm.close();
        con.close();
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(datatable);
        document.close();
         
       Panel window = new Panel();
((VerticalLayout) window.getContent()).setSizeFull();
                //window.setResizable(true);
               window.setCaption("Exemplo PDF");
               window.setWidth("800");
               window.setHeight("600");
             //  window.center();
StreamSource s = new StreamResource.StreamSource() {

@Override
        public InputStream getStream() {
    return new ByteArrayInputStream(os.toByteArray());
}
        /*    try {
        File f = new File("E:/mystorereport.pdf");
            FileInputStream fis = new FileInputStream(f);
            return fis;
            } catch (Exception e) {
            e.printStackTrace();
            return null;
            }
        }*/
        };
MainWindow main =new MainWindow();
StreamResource r = new StreamResource(s, "myproductreport.pdf",main);

Embedded e = new Embedded();
e.setSizeFull();
e.setType(Embedded.TYPE_BROWSER);
r.setMIMEType("application/pdf");
e.setSource(r);
window.addComponent(e);
Window win =new Window();
win.addComponent(window);
FileOutputStream fos = new FileOutputStream("F:/product.pdf");
fos.write(os.toByteArray());
fos.close();
//main.getMainWindow().open(r, "C:/mystorereport.pdf");
//main.addWindow(window);
}

}
