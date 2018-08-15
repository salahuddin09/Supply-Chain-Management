package org.scm.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.scm.db.ScsDAO;
import org.scm.model.Product;
import org.scm.model.Store;


public class StoreMan extends ScsDAO {

    public StoreMan() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public List<Product> getListOfProducts() throws SQLException {
        List<Product> listOfProducts = new ArrayList<Product>();
        listOfProducts = showListOfProducts();
        return listOfProducts;
    }

    public List<Store> getListOfStocks() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       // List<Store> storeFinishedProducts = new ArrayList<Store>();
        Product p = new Product();
      //  storeFinishedProducts = getStock(null,p);
       return super.getStock();
    }

    public List getListOfSales(SalesList product) throws SQLException {
        
        return super.showListOfSales(product);
    }
}
