package org.scm.model;

/**
*
* @author Personal
*/
public class Productline {
   private int productline_ID;
   /*change db table */
   private int order_Number;
   private int product_ID;
   private int product_Quantity;
   private int product_Price;

   /**
    * @return the product line_Name
    */
   public int getProductline_ID() {
       return productline_ID;
   }

   /**
    * @param productline_Name the product line_Name to set
    */
   public void setProductline_ID(int productline_ID) {
       this.productline_ID = productline_ID;
   }
   
   /**
    * @return the order_Number
    */
   public int getOrder_Number() {
       return order_Number;
   }

   /**
    * @param order_Number the order_Number to set
    */
   public void setOrder_Number(int order_Number) {
       this.order_Number = order_Number;
   }

   /**
    * @return the product_ID
    */
   public int getProduct_ID() {
       return product_ID;
   }

   /**
    * @param product_ID the product_ID to set
    */
   public void setProduct_ID(int product_ID) {
       this.product_ID = product_ID;
   }

   /**
    * @return the product_Quantity
    */
   public int getProduct_Quantity() {
       return product_Quantity;
   }

   /**
    * @param product_Quantity the product_Quantity to set
    */
   public void setProduct_Quantity(int product_Quantity) {
       this.product_Quantity = product_Quantity;
   }

   /**
    * @return the product_Price
    */
   public int getProduct_Price() {
       return product_Price;
   }

   /**
    * @param product_Price the product_Price to set
    */
   public void setProduct_Price(int product_Price) {
       this.product_Price = product_Price;
   }
}
