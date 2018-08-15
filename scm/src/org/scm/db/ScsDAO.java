package org.scm.db;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.scm.bl.SalesList;
import org.scm.model.Company;
import org.scm.model.Customer;
import org.scm.model.Delivery;
import org.scm.model.Employee;
import org.scm.model.Login;
import org.scm.model.Order;
import org.scm.model.Payable;
import org.scm.model.Product;
import org.scm.model.Productline;
import org.scm.model.Receivable;
import org.scm.model.Retailer;
import org.scm.model.Store;
import org.scm.model.Supplier;


public class ScsDAO extends ScsDBConnection {

    public String insertEmployee = "INSERT INTO employee(Employee_Name,Employee_Address,Employee_Contact_No,Employee_Email) VALUES(?,?,?,?)";
    public String deleteEmployee = "DELETE FROM employee WHERE Employee_ID =?;";
    public String updateEmployee = "UPDATE employee SET  Employee_Name= ?,Employee_Address = ?,Employee_Contact_No = ?,Employee_Email = ? where Employee_ID = ?;";
    public String insertCompany = "INSERT INTO company(Company_Name,Company_Address,Company_Contact_No,Company_Email) VALUES(?,?,?,?)";
    public String deleteCompany = "DELETE FROM company WHERE Company_ID =?;";
    public String updateCompany = "UPDATE company SET  Company_Name= ?,Company_Address = ?,Company_Contact_No = ?,Company_Email = ? where Company_ID = ?;";
    public String insertCustomer = "INSERT INTO customer(Customer_Name,Customer_Address,Customer_Contact_No,Customer_Email) VALUES(?,?,?,?)";
    public String deleteCustomer = "DELETE FROM customer WHERE Customer_ID =?;";
    public String updateCustomer = "UPDATE customer SET  Customer_Name= ?,Customer_Address = ?,Customer_Contact_No = ?,Customer_Email = ? where Customer_ID = ?;";
    public String insertSupplier = "INSERT INTO supplier(Supplier_Name,Supplier_Address,Supplier_Contact_No,Supplier_Email) VALUES(?,?,?,?)";
    public String deleteSupplier = "DELETE FROM supplier WHERE Supplier_ID =?;";
    public String updateSupplier = "UPDATE supplier SET  Supplier_Name= ?,Supplier_Address = ?,Supplier_Contact_No = ?,Supplier_Email = ? where Supplier_ID = ?;";
    public String insertOrder = "INSERT INTO scs.order(Order_Placement_Date,Product_ID,Product_Quantity,Supplier_ID,Retailer_ID,Order_Status) VALUES(?,?,?,?,?,?)";
    public String deleteOrder = "DELETE FROM scs.order WHERE Order_Number =?;";
    public String updateOrder = "UPDATE scs.order SET  Order_Placement_Date= ?,Product_ID = ?,Product_Quantity = ?,Supplier_ID = ?,Retailer_ID =? ,Order_Status = ? where Order_Number = ?;";
    public String insertPayable = "INSERT INTO accounts_payable(Payment_Date,Total_Payment_Amount,Product_ID,Supplier_ID,Company_ID) VALUES(?,?,?,?,?)";
    public String deletePayable = "DELETE FROM accounts_payable WHERE Payment_ID =?;";
    public String updatePayable = "UPDATE accounts_payable SET  Payment_Date= ?,Total_Payment_Amount = ?,Product_ID = ?,Supplier_ID  = ?,Company_ID = ? where Payment_ID = ?;";
    public String insertProduct = "INSERT INTO product(Product_Name,Product_Description,Product_Unit,Product_Weight,Product_Cost,Product_Prior_Year_Sales_Goal,Product_Current_Year_Sales_Goal) VALUES(?,?,?,?,?,?,?)";
    public String deleteProduct = "DELETE FROM product WHERE Product_ID =?;";
    public String updateProduct = "UPDATE product SET  Product_Name = ?,Product_Description = ?,Product_Unit = ?,Product_Weight = ?,Product_Cost = ?,Product_Prior_Year_Sales_Goal = ?,Product_Current_Year_Sales_Goal = ? where Product_ID = ?;";
    public String insertProductline = "INSERT INTO productline(Order_Number,Product_ID,Product_Quantity,Product_Price) VALUES(?,?,?,?)";
    public String deleteProductline = "DELETE FROM productline WHERE Productline_ID =?;";
    public String updateProductline = "UPDATE productline SET  Order_Number = ?,Product_ID = ?,Product_Quantity = ?,Product_Price = ? where Productline_ID = ?;";
    public String insertReceivable = "INSERT INTO accounts_receivable(Receive_Date,Total_Receive_Amount,Order_Number,Product_ID,Retailer_ID,Customer_ID) VALUES(?,?,?,?,?,?)";
    public String deleteReceivable = "DELETE FROM accounts_receivable WHERE Receive_Number =?;";
    public String updateReceivable = "UPDATE accounts_receivable SET  Receive_Date= ?,Total_Receive_Amount = ?,Order_Number = ?,Product_ID = ?,Retailer_ID = ?,Customer_ID = ? where Receive_Number = ?;";
    public String insertStore = "INSERT INTO store(Store_Location,Store_Description,Product_ID,Product_Count,Product_Storage_Threshold) VALUES(?,?,?,?,?)";
    public String deleteStore = "DELETE FROM store WHERE Store_ID =?;";
    public String updateStore = "UPDATE store SET  Store_Location= ?,Store_Description = ?,Product_ID = ?,Product_Count = ?,Product_Storage_Threshold = ? where Store_ID = ?;";
    public String insertRetailer = "INSERT INTO retailer(Retailer_Name,Retailer_Address,Retailer_Contact_No,Retailer_Email) VALUES(?,?,?,?)";
    public String deleteRetailer = "DELETE FROM retailer WHERE Retailer_ID =?;";
    public String updateRetailer = "UPDATE retailer SET  Retailer_Name = ?,Retailer_Address= ?,Retailer_Contact_No = ?,Retailer_Email = ? where Retailer_ID = ?;";
    public String insertDelivery = "INSERT INTO delivery(Order_Number,Order_Fulfillment_Date,Supplier_ID,Order_Status) VALUES(?,?,?,?)";
    public String deleteDelivery = "DELETE FROM delivery WHERE Delivery_Number =?;";
    public String updateDelivery = "UPDATE delivery SET  Order_Number= ?,Order_Fulfillment_Date = ?,Supplier_ID =? ,Order_Status = ? where Delivery_Number = ?;";
    public String selectEmployee = "SELECT Employee_ID,Employee_Address,Employee_Contact_No,Employee_Email FROM employee WHERE Employee_Name=?;";
    public String selectCompany = "SELECT * FROM company";
    public String selectCustomer = "SELECT * FROM customer";
    public String selectSupplier = "SELECT * FROM supplier;";
    public String selectOrder = "SELECT * FROM scs.order";//
    public String selectPayable = "SELECT * FROM payable";
    public String selectProduct = "SELECT * FROM product";
    public String selectProductline = "SELECT * FROM productline";
    public String selectReceivable = "SELECT * FROM receivable";
    public String selectStore = "SELECT * FROM store";//
    public String selectDelivery = "SELECT * FROM delivery";//
    public String selectLogin = "SELECT * FROM login where Login_Name=? and Login_Password=?;";
    public String selectRetailer = "SELECT * FROM retailer";//
    public String salessql = "SELECT p.Product_Name AS Product_Name,Count(pl.Order_Number) AS Order_Count,Sum(pl.Product_Price) AS Total_Sales from product p,productline pl where p.Product_ID =?;";
    
    
    public ScsDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        super();
    }

	protected List<Login> selectLogin() throws SQLException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Login log = new Login();
		Statement st = (Statement) getConnection().createStatement();

		ResultSet rs = st.executeQuery(selectLogin);
		while (rs.next()) {
			log.setLogin_Name(rs.getString("Login_Name"));
			log.setLogin_Password(rs.getString("Login_Password"));
			return (List<Login>) log;
		}
		return (List<Login>) log;
	}
    
    
    protected boolean insertEmployee(Employee employee) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertEmployee);
            st.setString(1, employee.getEmployee_Name());
            st.setString(2, employee.getEmployee_Address());
            st.setString(3, employee.getEmployee_Contact_No());
            st.setString(4, employee.getEmployee_Email());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (SQLException excp) {
            getConnection().rollback();

        } finally {
            getConnection().close();
        }
        // st.close();  

        return status;
    }

    protected boolean deleteEmployee(Employee employee) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteEmployee);
            st.setInt(1, employee.getEmployee_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //  st.close();

        return status;
    }

    protected boolean selectEmployee() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectEmployee);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 5) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateEmployee);
            st.setString(1, employee.getEmployee_Name());
            st.setString(2, employee.getEmployee_Address());
            st.setString(3, employee.getEmployee_Contact_No());
            st.setString(4, employee.getEmployee_Email());
            st.setInt(5, employee.getEmployee_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().commit();
        } finally {
            getConnection().close();
        }
        // st.close();

        return status;
    }

    protected boolean insertCompany(Company company) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertCompany);


            st.setString(1, company.getCompany_Name());
            st.setString(2, company.getCompany_Address());
            st.setString(3, company.getCompany_Contact_No());
            st.setString(4, company.getCompany_Email());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deleteCompany(Company company) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteCompany);
            st.setInt(1, company.getCompany_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().close();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean selectCompany() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectCompany);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 5) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateCompany(Company company) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateCompany);

            st.setString(1, company.getCompany_Address());
            st.setString(2, company.getCompany_Contact_No());
            st.setString(3, company.getCompany_Email());
            st.setInt(4, company.getCompany_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertCustomer(Customer customer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertCustomer);


            st.setString(1, customer.getCustomer_Name());
            st.setString(2, customer.getCustomer_Address());
            st.setString(3, customer.getCustomer_Contact_No());
            st.setString(4, customer.getCustomer_Email());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deleteCustomer(Customer customer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteCustomer);
            st.setInt(1, customer.getCustomer_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean selectCustomer() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectCustomer);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 5) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateCustomer);
            st.setString(1, customer.getCustomer_Name());
            st.setString(2, customer.getCustomer_Address());
            st.setString(3, customer.getCustomer_Contact_No());
            st.setString(4, customer.getCustomer_Email());
            st.setInt(5, customer.getCustomer_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertSupplier);


            st.setString(1, supplier.getSupplier_Name());
            st.setString(2, supplier.getSupplier_Address());
            st.setString(3, supplier.getSupplier_Contact_No());
            st.setString(4, supplier.getSupplier_Email());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deleteSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteSupplier);
            st.setInt(1, supplier.getSupplier_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected List selectSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
         List listOfSupplier = new ArrayList();
      try{  
             getConnection().setAutoCommit(false);
        PreparedStatement st = getConnection().prepareStatement(selectSupplier);
                st.setString(1, supplier.getSupplier_Name());
                 //st.setString(1,"rony");
        ResultSet rs = st.executeQuery();
    
        while (rs.next()) {
            listOfSupplier.add(rs.getInt(1));
            listOfSupplier.add(rs.getString(2));
            listOfSupplier.add(rs.getString(3));
            listOfSupplier.add(rs.getString(4));
        }
        //System.out.println(listOfSupplier);
        getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        return listOfSupplier;
    }
    protected boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateSupplier);
            st.setString(1, supplier.getSupplier_Name());
            st.setString(2, supplier.getSupplier_Address());
            st.setString(3, supplier.getSupplier_Contact_No());
            st.setString(4, supplier.getSupplier_Email());
            st.setInt(5, supplier.getSupplier_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertOrder(Order order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertOrder);
            
            long ts1 = order.getOrder_Placement_Date().getTime();
            
            st.setTimestamp(1, new Timestamp(ts1));
            st.setInt(2, order.getProduct_ID());
            st.setInt(3, order.getProduct_Quantity());
            st.setInt(4, order.getSupplier_ID());
            st.setInt(5, order.getRetailer_ID());
            st.setString(6, order.getOrder_Status());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (SQLException excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        return status;
    }

    protected boolean deleteOrder(Order order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteOrder);
            st.setInt(1, order.getOrder_Number());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        // st.close();

        return status;
    }

    protected boolean selectOrder() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectOrder);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 6) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateOrder(Order order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateOrder);
            
            long ts1 = order.getOrder_Placement_Date().getTime();
            st.setTimestamp(1, new Timestamp(ts1));
            st.setInt(2,order.getProduct_ID());
            st.setInt(3, order.getProduct_Quantity());
            st.setInt(4, order.getSupplier_ID());
            st.setInt(5, order.getRetailer_ID());
            st.setString(6, order.getOrder_Status());
            st.setInt(7, order.getOrder_Number());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertPayable(Payable payable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertPayable);


            long ts4 = payable.getPayment_Date().getTime();

            st.setTimestamp(1, new Timestamp(ts4));
            st.setDouble(2, payable.getTotal_Payment_Amount());
            st.setInt(3, payable.getProduct_ID());
            st.setInt(4, payable.getCompany_ID());
            st.setInt(5, payable.getSupplier_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deletePayable(Payable payable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deletePayable);
            st.setInt(1, payable.getPayment_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();
        return status;
    }

    protected boolean selectPayable() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectPayable);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 6) ? true : false;
        st.close();

        return status;
    }

    protected boolean updatePayable(Payable payable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updatePayable);
            st.setInt(1, payable.getSupplier_ID());
            //   st.setString(2, payable.getPayment_Date());
            st.setDouble(3, payable.getTotal_Payment_Amount());
            st.setInt(4, payable.getProduct_ID());
            st.setInt(5, payable.getCompany_ID());
            st.setInt(6, payable.getPayment_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertProduct);

            st.setString(1, product.getProduct_Name());
            st.setString(2, product.getProduct_Description());
            st.setString(3, product.getProduct_Unit());
            st.setDouble(4, product.getProduct_Weight());
            st.setDouble(5, product.getProduct_Cost());
            st.setString(6, product.getProduct_Prior_Year_Sale_Goal());
            st.setString(7, product.getProduct_Current_Year_Sale_Goal());
            // st.setInt(6, product.getProduct_Line_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        // st.close();

        return status;
    }

    protected boolean deleteProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteProduct);
            st.setInt(1, product.getProduct_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected List<Product> selectProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       // boolean status = false;
        List listOfProduct = new ArrayList<Product>();
        try{
        //Statement st = (Statement) getConnection().createStatement();
        PreparedStatement st = getConnection().prepareStatement(selectProduct);
           st.setString(1, product.getProduct_Name());
        ResultSet rs = st.executeQuery();
     
        while(rs.next()) {  
           listOfProduct.add(rs.getInt("Product_ID"));
           listOfProduct.add(rs.getString("Product_Description"));
           listOfProduct.add(rs.getString("Product_Unit"));
           listOfProduct.add(rs.getDouble("Product_Weight"));
           listOfProduct.add(rs.getDouble("Product_Cost"));
           listOfProduct.add(rs.getString("Product_Prior_Year_Sale_Goal"));
           listOfProduct.add(rs.getString("Product_Current_Year_Sale_Goal"));
             }
        getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        return listOfProduct;
    }

    protected boolean updateProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateProduct);

            st.setString(1, product.getProduct_Name());
            st.setString(2, product.getProduct_Description());
            st.setString(3, product.getProduct_Unit());
            st.setDouble(4, product.getProduct_Weight());
            st.setString(5, product.getProduct_Prior_Year_Sale_Goal());
            st.setString(6, product.getProduct_Current_Year_Sale_Goal());
            st.setDouble(7, product.getProduct_Cost());
            // st.setInt(6, product.getProduct_Line_Name());
            st.setInt(8, product.getProduct_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertProductline(Productline productline) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertProductline);

            st.setInt(1, productline.getOrder_Number());
            st.setInt(2, productline.getProduct_ID());
            st.setInt(3, productline.getProduct_Quantity());
            st.setInt(4, productline.getProduct_Price());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deleteProductline(Productline productline) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteProductline);
            st.setInt(1, productline.getProductline_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected List selectProductline() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       // boolean status = false;
List td=new ArrayList();
        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectProductline);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
       // status = ((rs.getMetaData().getColumnCount()) >= 5) ? true : false;
        st.close();

        return td;
    }

    protected boolean updateProductline(Productline productline) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateProductline);
            st.setInt(1, productline.getOrder_Number());
            st.setInt(2, productline.getProduct_ID());
            st.setInt(3, productline.getProduct_Quantity());
            st.setInt(4, productline.getProduct_Price());
            st.setInt(5, productline.getProductline_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertReceivable(Receivable receivable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertReceivable);


            long ts = receivable.getReceive_Date().getTime();
            st.setTimestamp(1, new Timestamp(ts));
            st.setDouble(2, receivable.getTotal_Receive_Amount());
            st.setInt(3, receivable.getOrder_Number());
            st.setInt(4, receivable.getProduct_ID());
            st.setInt(5, receivable.getRetailer_ID());
            st.setInt(6, receivable.getCustomer_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        // st.close();

        return status;
    }

    protected boolean deleteReceivable(Receivable receivable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteReceivable);
            st.setInt(1, receivable.getReceive_Number());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean selectreceivable() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectReceivable);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 7) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateReceivable(Receivable receivable) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateReceivable);

            long ts = receivable.getReceive_Date().getTime();
            st.setTimestamp(1, new Timestamp(ts));
            st.setDouble(2, receivable.getTotal_Receive_Amount());
            st.setInt(3, receivable.getOrder_Number());
            st.setInt(4, receivable.getProduct_ID());
            st.setInt(5, receivable.getRetailer_ID());
            st.setInt(6, receivable.getCustomer_ID());
            st.setInt(7, receivable.getReceive_Number());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertStore(Store store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertStore);


            st.setString(1, store.getStore_Location());
            st.setString(2, store.getStore_Description());
            st.setInt(3, store.getProduct_ID());
            st.setInt(4, store.getProduct_Count());
            st.setInt(5, store.getProduct_Storage_Threshold());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deleteStore(Store store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteStore);
            st.setInt(1, store.getStore_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean selectStore() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectStore);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 6) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateStore(Store store) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateStore);

            st.setString(1, store.getStore_Location());
            st.setString(2, store.getStore_Description());
            st.setInt(3, store.getProduct_ID());
            st.setInt(4, store.getProduct_Count());
            st.setInt(5, store.getProduct_Storage_Threshold());
            st.setInt(6, store.getStore_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertRetailer(Retailer retailer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertRetailer);

            st.setString(1, retailer.getRetailer_Name());
            st.setString(2, retailer.getRetailer_Address());
            st.setString(3, retailer.getRetailer_Contact_No());
            st.setString(4, retailer.getRetailer_Email());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean deleteRetailer(Retailer retailer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteRetailer);
            st.setInt(1, retailer.getRetailer_ID());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean selectRetailer() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectRetailer);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 5) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateRetailer(Retailer retailer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateRetailer);
            st.setString(1, retailer.getRetailer_Name());
            st.setString(2, retailer.getRetailer_Address());
            st.setString(3, retailer.getRetailer_Contact_No());
            st.setString(4, retailer.getRetailer_Email());
            st.setInt(5, retailer.getRetailer_ID());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected boolean insertDelivery(Delivery delivery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(insertDelivery);

            long ts1 = delivery.getOrder_Fulfillment_Date().getTime();
             st.setInt(1, delivery.getOrder_Number());
            st.setTimestamp(2, new Timestamp(ts1));
            st.setInt(3, delivery.getSupplier_ID());
            st.setString(4, delivery.getOrder_Status());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (SQLException excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        return status;
    }

    protected boolean deleteDelivery(Delivery delivery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(deleteDelivery);
            st.setInt(1, delivery.getDelivery_Number());
            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        // st.close();

        return status;
    }

    protected boolean selectDelivery() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;

        Statement st = (Statement) getConnection().createStatement();

        ResultSet rs = st.executeQuery(selectDelivery);
        int columns = rs.getMetaData().getColumnCount();
        StringBuilder message = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                message.append(rs.getString(i) + " ");
            }
            message.append("\n");
        }
        System.out.println(message);
        status = ((rs.getMetaData().getColumnCount()) >= 6) ? true : false;
        st.close();

        return status;
    }

    protected boolean updateDelivery(Delivery delivery) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean status = false;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(updateDelivery);
            long ts1 = delivery.getOrder_Fulfillment_Date().getTime();
            st.setInt(1, delivery.getOrder_Number());
            st.setTimestamp(2, new Timestamp(ts1));
            st.setInt(3, delivery.getSupplier_ID());
            st.setString(4, delivery.getOrder_Status());
            st.setInt(5, delivery.getDelivery_Number());

            status = (st.executeUpdate() >= 1) ? true : false;
            getConnection().commit();
        } catch (Exception excp) {
            getConnection().rollback();
        } finally {
            getConnection().close();
        }
        //st.close();

        return status;
    }

    protected List<Product> showListOfProducts() throws SQLException {
        List<Product> listOfProducts = new ArrayList<Product>();
            try{
        PreparedStatement st = getConnection().prepareStatement("SELECT * FROM product");

        ResultSet rs = st.executeQuery();
      
        while (rs.next()) {
            
              Product  product = new Product();
                product.setProduct_ID(rs.getInt("Product_ID"));
                product.setProduct_Name(rs.getString("Product_Name"));
                product.setProduct_Description(rs.getString("Product_Description"));
                product.setProduct_Unit(rs.getString("Product_Unit"));
                product.setProduct_Weight(rs.getDouble("Product_Weight"));
                product.setProduct_Cost(rs.getDouble("Product_Cost"));
                product.setProduct_Prior_Year_Sale_Goal(rs.getString("Product_Prior_Year_Sales_Goal"));
                product.setProduct_Current_Year_Sale_Goal(rs.getString("Product_Current_Year_Sales_Goal"));
                listOfProducts.add(product);
       
        }
            }catch(Exception ex){
                System.out.println("exception in list of products");
                ex.printStackTrace();
            }finally{
                return listOfProducts;
            }
       // st.close(); 
    }

    protected List<Product> showListOfProductsByProduct_ID(int productid) throws SQLException {
       
        List<Product> allProducts = new ArrayList<Product>();
        try {
            String selectlist = "SELECT * FROM product where Product_ID = ?";
                Product product2 = null;
            PreparedStatement st = getConnection().prepareStatement(selectlist);
            st.setInt(1, product2.getProduct_ID());
            ResultSet rs = st.executeQuery(selectlist);
            while (rs.next()) {
                Product product =new Product();
                product.setProduct_ID(rs.getInt("Product_ID"));
                product.setProduct_Name(rs.getString("Product_Name"));
                product.setProduct_Description(rs.getString("Product_Description"));
                product.setProduct_Unit(rs.getString("Product_Unit"));
                product.setProduct_Weight(rs.getDouble("Product_Weight"));
                product.setProduct_Cost(rs.getDouble("Product_Cost"));
                product.setProduct_Prior_Year_Sale_Goal(rs.getString("Product_Prior_Year_Sales_Goal"));
                product.setProduct_Current_Year_Sale_Goal(rs.getString("Product_Current_Year_Sales_Goal"));
                allProducts.add(product);
            }
        } catch (Exception excp) {
        } finally {
            getConnection().close();
        }
        return allProducts;
    }

    protected List<Store> getStock() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Store store2;
        List<Store> storeFinishedProducts = new ArrayList<Store>();
        try {

            String selectSQL = "SELECT * FROM store";
            // String selectSQL = "SELECT * FROM store";
            PreparedStatement st = getConnection().prepareStatement(selectSQL);
          //  st.setInt(1, store.getStore_ID());
           // st.setInt(2, product.getProduct_ID());


            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                store2 = new Store();
                store2.setStore_ID(rs.getInt("Store_ID"));
                store2.setStore_Location(rs.getString("Store_Location"));
                store2.setStore_Description(rs.getString("Store_Description"));
                store2.setProduct_ID(rs.getInt("Product_ID"));
                store2.setProduct_Count(rs.getInt("Product_Count"));
                store2.setProduct_Storage_Threshold(rs.getInt("Product_Storage_Threshold"));
                storeFinishedProducts.add(store2);
            }


        } catch (Exception excp) {
            excp.printStackTrace();
            System.out.println("Exception ocurred in getstock...");
        } finally {
             return storeFinishedProducts;
            //getConnection().close();
        }
       
    }

    protected List<SalesList> showListOfSales(SalesList product) throws SQLException {
        List<SalesList> sales = new ArrayList<SalesList>();
        try {
           PreparedStatement st =  getConnection().prepareStatement(salessql); 
            st.setInt(1, product.getProduct_ID());
            ResultSet rs = st.executeQuery();        
            while (rs.next()) {
                SalesList salesList = new SalesList();
            	salesList.setProduct_Name(rs.getString("p.Product_Name"));
            	salesList.setOrder_count(rs.getInt("Order_Count"));
                salesList.setTotal_sales(rs.getInt("Total_Sales"));
                sales.add(salesList);
            }
        } catch (Exception excp) {
            excp.printStackTrace();
            System.out.println("Sorry Exception occured......");
        } finally {
           return sales; 
        } 
    }

    protected void dropDBConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        getConnection().close();
    }
}
