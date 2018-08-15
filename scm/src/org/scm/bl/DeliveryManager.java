/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.bl;

import java.sql.SQLException;
import org.scm.db.ScsDAO;
import org.scm.model.Delivery;

/**
 *
 * @author Personal
 */
public class DeliveryManager extends ScsDAO{
    public DeliveryManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
    }
    
    public boolean insertNewDelivery(Delivery delivery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.insertDelivery(delivery);
    }
    public boolean deleteNewDelivery(Delivery delivery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.deleteDelivery(delivery);
    }
    public boolean updateNewDelivery(Delivery delivery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.updateDelivery(delivery);
    }
}
