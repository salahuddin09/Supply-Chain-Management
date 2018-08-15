package org.scm.model;

/**
*
* @author Personal
*/
public class Store {
   private int store_ID;
   private String store_Location;
   private String store_Description;
   /*change db table */
   private int product_ID;
   private int product_Count;
   private int product_Storage_Threshold;
   
   /**
    * @return the store_ID
    */
   public int getStore_ID() {
       return store_ID;
   }

   /**
    * @param store_ID the store_ID to set
    */
   public void setStore_ID(int store_ID) {
       this.store_ID = store_ID;
   }

   /**
    * @return the store_Location
    */
   public String getStore_Location() {
       return store_Location;
   }

   /**
    * @param store_Location the store_Location to set
    */
   public void setStore_Location(String store_Location) {
       this.store_Location = store_Location;
   }

   /**
    * @return the store_Description
    */
   public String getStore_Description() {
       return store_Description;
   }

   /**
    * @param store_Description the store_Description to set
    */
   public void setStore_Description(String store_Description) {
       this.store_Description = store_Description;
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
    * @return the product_Count
    */
   public int getProduct_Count() {
       return product_Count;
   }

   /**
    * @param product_Count the product_Count to set
    */
   public void setProduct_Count(int product_Count) {
       this.product_Count = product_Count;
   }

   /**
    * @return the product_Storage_Threshold
    */
   public int getProduct_Storage_Threshold() {
       return product_Storage_Threshold;
   }

   /**
    * @param product_Storage_Threshold the product_Storage_Threshold to set
    */
   public void setProduct_Storage_Threshold(int product_Storage_Threshold) {
       this.product_Storage_Threshold = product_Storage_Threshold;
   }
}
