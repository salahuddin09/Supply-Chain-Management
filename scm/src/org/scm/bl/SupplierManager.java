package org.scm.bl;

import java.sql.SQLException;
import java.util.List;
import org.scm.db.ScsDAO;
import org.scm.model.Supplier;

public class SupplierManager extends ScsDAO{
    
    public SupplierManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    }
    
    public boolean insertNewSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.insertSupplier(supplier);
    }
    public boolean deleteNewSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.deleteSupplier(supplier);
    }
    public boolean updateNewSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.updateSupplier(supplier);
    }
    public List selectNewSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.selectSupplier(supplier);
    }
}

