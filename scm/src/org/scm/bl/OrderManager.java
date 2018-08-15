package org.scm.bl;

import java.sql.SQLException;

import org.scm.db.ScsDAO;
import org.scm.model.Order;

public class OrderManager extends ScsDAO{
	public OrderManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
    }
    
    public boolean insertNewOrder(Order order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.insertOrder(order);
    }
    public boolean deleteNewOrder(Order order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.deleteOrder(order);
    }
    public boolean updateNewOrder(Order order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.updateOrder(order);
    }
    
}
