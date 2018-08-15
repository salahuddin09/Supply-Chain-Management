package org.scm.bl;

import com.lowagie.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import org.scm.db.ScsDAO;
import org.scm.model.Product;
import org.scm.model.Store;
import org.scm.utilities.SendMail;

public class StckThresholdManager extends ScsDAO implements Runnable {

    public StckThresholdManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        super();
    }

    public void run() {
        try {
           // Thread.sleep(60000 * 60);//1 hour
            Thread.sleep(5000*60);// 5 minutes
            System.out.println("Thread is successfully running...");
            List<Product> listOfProducts = this.showListOfProducts();
            for (Product p : listOfProducts) {
                List<Store> storeForTheProduct = this.getStock();
                try {
                    this.checkProductStatus(storeForTheProduct);
                } catch (JRException ex) {
                    Logger.getLogger(StckThresholdManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(StckThresholdManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(StckThresholdManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(StckThresholdManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private void checkProductStatus(List<Store> store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, JRException, DocumentException, FileNotFoundException, IOException {

        for (Store s : store) {
            if (s.getProduct_Count() <= s.getProduct_Storage_Threshold()) {
              
                FinishedProduct finish = new FinishedProduct();
                finish.scsreport();
                SendMail.sendMessage();
                System.out.println("Mail Sending Currently OFF Mode.");
            }
        }


    }
}
