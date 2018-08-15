/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.scm.bl.StckThresholdManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Main extends StckThresholdManager {
    
    public Main() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        super();
    }
    
    public static void main(String args[]){
        try {
            Main main = new Main();
          //  Employee employee = new Employee();
          //  employee.setEmployee_Address("chittagong");
          //  employee.setEmployee_Contact_No("024512454");
          //  employee.setEmployee_Email("Rana@gmail.com");
          //  employee.setEmployee_ID(0001);
          //  employee.setEmployee_Name("rana");              
          // boolean status = main.insertEmployee(employee);
           // boolean status = main.deleteEmployee(employee);
          //  boolean status = main.selectEmployee();
          //  boolean status = main.updateEmployee(employee);*/
           
       /*     Supplier supplier = new Supplier();
       
            supplier.setSupplier_Name("rony");
            supplier.setSupplier_Address("Raozan");
            supplier.setSupplier_Contact_No("01829248343");
            supplier.setSupplier_Email("salahuddincse09@gmail.com");
             supplier.setSupplier_ID(1);
             boolean status = main.insertSupplier(supplier);*/
            //boolean status = main.deleteSupplier(supplier);
         //  boolean status = main.selectSupplier();
          //  boolean status = main.updateSupplier(supplier);
        
        /*    Customer customer = new Customer();
        
            customer.setCustomer_Name("Faisal");
            customer.setCustomer_Email("faisla@gmail.com");
            customer.setCustomer_Contact_No("018191919");
           customer.setCustomer_Address("Rauzan");
      
      boolean status =   main.insertCustomer(customer);*/
            
     /*    Order order = new Order();
            
           String placement_Date = "12-03-2012";
            String fulfillment_Date = "14-03-2012";
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = sdf1.parse(placement_Date);
                date2 = sdf2.parse(fulfillment_Date);
                 order.setCustomer_ID(0001);
                order.setOrder_Placement_Date(date1);
            order.setOrder_Fulfillment_Date(date2);
            boolean status2 = main.insertOrder(order);
            System.out.println(status2);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }*/
           
            
    //  boolean status = main.selectOrder();
    /*    Receivable receivable = new Receivable();
        String receive_Date = "14-03-2012";
            SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
            Date date3 = null;
 
            try {
                date3 = sdf3.parse(receive_Date);
                receivable.setReceive_Date(date3);
                receivable.setTotal_Receive_Amount(20000);
                receivable.setOrder_Number(1);
                receivable.setProduct_ID(1);
                receivable.setRetailer_ID(1);
                receivable.setCustomer_ID(1);
            boolean status2 = main.insertReceivable(receivable);
            System.out.println(status2);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }*/
         /*  Company company =new Company();
           company.setCompany_Name("BSRM");
           company.setCompany_Address("Chittagong");
           company.setCompany_Contact_No("05435123");
           company.setCompany_Email("BSRM@outlook.com");
           boolean status =main.insertCompany(company);*/
       /*    Product product =new Product();
            product.setProduct_Description("Teletalk");
            product.setProduct_Unit("pack");
            product.setProduct_Weight(250);
            product.setProduct_Cost(12);
            product.setProduct_Prior_Year_Sale_Goal("1500 pack");
            product.setProduct_Current_Year_Sale_Goal("2000 pack");
            product.setProduct_ID(1);
            boolean status = main.insertProduct(product);*/
         /*   Retailer retailer =new Retailer();
            retailer.setRetailer_Name("Rahim");
            retailer.setRetailer_Address("CTG");
            retailer.setRetailer_Contact_No("6232");
            retailer.setRetailer_Email("Rahim_ctg@gmail.com");
            boolean status = main.insertRetailer(retailer);*/
           /* Productline productline =new Productline();
            productline.setOrder_Number(1);
            productline.setProduct_ID(1);
            productline.setProduct_Price(15);
            productline.setProduct_Quantity(25);
            boolean status = main.insertProductline(productline);*/
        /*   Store store = new Store();
           store.setStore_Location("Chittagong");
           store.setStore_Description("Pran Warehouse");
           store.setProduct_ID(1);
           store.setProduct_Count(200);
           store.setProduct_Storage_Threshold(10);
         boolean status = main.insertStore(store);*/
         
      
       /*     Payable payable = new Payable();
            String payable_Date = "14-03-2012";
            SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy");
            Date date3 = null;
 
            try {
                date3 = sdf4.parse(payable_Date);
                payable.setPayment_Date(date3);
                payable.setTotal_Payment_Amount(25000);
                payable.setProduct_ID(1);
                payable.setCompany_ID(1);
                payable.setSupplier_ID(1);
            boolean status2 = main.insertPayable(payable);
            System.out.println(status2);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }*/
            
      //      Thread thread = new Thread();
            
       //     thread.start();
            
         //   try{
         //       Thread.sleep(36000);// 36 seconds
                //Thread.sleep(3600000);//1 hour
          //  Store store =new Store();
         //   store.setStore_ID(1);
          //  boolean status = main.selectStock(store);
             //     System.out.println(status);
         //   }catch(InterruptedException e){
                
         //   }
           // System.out.println(status);
            main.dropDBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
