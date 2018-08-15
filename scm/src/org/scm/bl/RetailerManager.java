package org.scm.bl;

import java.sql.SQLException;

import org.scm.db.ScsDAO;
import org.scm.model.Retailer;

public class RetailerManager extends ScsDAO{
	
	    public RetailerManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
	        
	    }
	    
	    public boolean insertNewRetailer(Retailer retailer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.insertRetailer(retailer);
	    }
	    public boolean deleteNewRetailer(Retailer retailer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.deleteRetailer(retailer);
	    }
	    public boolean updateNewRetailer(Retailer retailer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.updateRetailer(retailer);
	    }
	    public boolean selectNewRetailer() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.selectRetailer();
	    }
}
