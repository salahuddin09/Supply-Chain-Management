/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.bl;

import java.sql.SQLException;
import java.util.List;
import org.scm.db.ScsDAO;
import org.scm.model.Product;
import org.scm.model.Productline;

/**
 *
 * @author Personal
 */
public class ProductlineManager extends ScsDAO{
     public ProductlineManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
    }
    
    public boolean insertNewProductline(Productline productLine) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.insertProductline(productLine);
    }
    public boolean deleteNewProductline(Productline productLine) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.deleteProductline(productLine);
    }
    public boolean updateNewProductline(Productline productLine) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.updateProductline(productLine);
    }
    public List selectNewProductline() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.selectProductline();
    }
    
}
