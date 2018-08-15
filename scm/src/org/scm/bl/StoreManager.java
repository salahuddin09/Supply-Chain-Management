package org.scm.bl;

import java.sql.SQLException;

import org.scm.db.ScsDAO;
import org.scm.model.Store;

public class StoreManager extends ScsDAO{
	 public StoreManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
	        
	    }
	    
	    public boolean insertNewStore(Store store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.insertStore(store);
	    }
	    public boolean deleteNewStore(Store store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.deleteStore(store);
	    }
	    public boolean updateNewStore(Store store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.updateStore(store);
	    }
	    
}
