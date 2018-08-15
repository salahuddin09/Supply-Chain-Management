/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.ui;

import com.vaadin.terminal.StreamResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Window;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.scm.bl.ReportManager;
import org.scm.model.Store;

/**
 *
 * @author Personal
 */
public class StoreReport_orig extends Window{
    public StoreReport_orig() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException {
        scsreport();
    }
     public void scsreport() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, JRException {  
   
final ReportManager db =new ReportManager();
//final JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("Store.jasper"));
final HashMap jasperParameter = new HashMap();
final JasperReport report = JasperCompileManager.compileReport("Store.jrxml");
final JasperPrint jasperPrint = JasperFillManager.fillReport(report,jasperParameter, db.DBConnectionForReport());
JasperExportManager.exportReportToPdfFile(jasperPrint, "store_report.pdf");       
        /*Store store =new Store();
        map.put("Store_ID",store.getStore_ID());
        map.put("Store_Location",store.getStore_Location());
        map.put("Store_Description",store.getStore_Description());
        map.put("Product_ID",store.getProduct_ID());
        map.put("Product_Count",store.getProduct_Count());
        map.put("Product_Storage_Threshold",store.getProduct_Storage_Threshold());
         
         try {
          //  FileOutputStream of = new FileOutputStream("TokenReport.pdf");
         //   JasperRunManager.runReportToPdfStream(getClass().getClassLoader().getResourceAsStream("/Store.jasper"), of, map, db.DBConnectionForReport());

            StreamResource.StreamSource source = new StreamResource.StreamSource() 
            {

                public InputStream getStream() {
                    byte[] b = null;
                    try {
                        try {
                            b = JasperRunManager.runReportToPdf(report, map, db.DBConnectionForReport());
                        } catch (SQLException ex) {
                            Logger.getLogger(StoreReport.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(StoreReport.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(StoreReport.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(StoreReport.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (JRException ex) {
                          ex.printStackTrace();
               
                    }
                  
                    return new ByteArrayInputStream(b);
                }
            };
          Embedded e = new Embedded();
        e.setSizeFull();
        e.setType(Embedded.TYPE_BROWSER);
           StreamResource resource = new StreamResource(source, "myreport.pdf", getApplication());
           resource.getStream().setParameter("Content-Disposition","Store.jasper");
            resource.setMIMEType("application/pdf");
            e.setSource(resource);
            getContent().setSizeFull();
            setCaption("Exemplo PDF");
            setWidth("800");
            setHeight("600");
            center();
            setResizable(true);
            addComponent(e);
           getApplication().getMainWindow().open(resource, "_new");
           // getApplication().getMainWindow().open(resource);
//getApplication().addResource(resource);
        } catch (Exception ex) {
            ex.printStackTrace();
        
        }
         * */
         
     }
}
