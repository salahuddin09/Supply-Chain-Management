/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.bl;

import java.sql.SQLException;
import java.util.List;
import org.scm.db.ScsDAO;
import org.scm.model.Product;


public class ProductManager extends ScsDAO{
    
    public ProductManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
    }
    
    public boolean insertNewProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.insertProduct(product);
    }
    public boolean deleteNewProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.deleteProduct(product);
    }
    public boolean updateNewProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.updateProduct(product);
    }
    public List selectNewProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.selectProduct(product);
    }
    
}
