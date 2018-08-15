package org.scm.model;

import java.util.Date;

public class Delivery {
   private int delivery_Number;
   private int order_Number;
   private Date order_Fulfillment_Date;
   private int supplier_ID;
   private String order_Status;

   /**
    * @return the delivery_Number
    */
   public int getDelivery_Number() {
       return delivery_Number;
   }

   /**
    * @param delivery_Number the delivery_Number to set
    */
   public void setDelivery_Number(int delivery_Number) {
       this.delivery_Number = delivery_Number;
   }
   /**
    * @return the supplier_ID
    */
   public int getSupplier_ID() {
       return supplier_ID;
   }

   /**
    * @param supplier_ID the supplier_ID to set
    */
   public void setSupplier_ID(int supplier_ID) {
       this.supplier_ID = supplier_ID;
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
     * @return the order_Fulfillment_Date
     */
    public Date getOrder_Fulfillment_Date() {
        return order_Fulfillment_Date;
    }

    /**
     * @param order_Fulfillment_Date the order_Fulfillment_Date to set
     */
    public void setOrder_Fulfillment_Date(Date order_Fulfillment_Date) {
        this.order_Fulfillment_Date = order_Fulfillment_Date;
    }

    /**
     * @return the order_Status
     */
    public String getOrder_Status() {
        return order_Status;
    }

    /**
     * @param order_Status the order_Status to set
     */
    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }
}
