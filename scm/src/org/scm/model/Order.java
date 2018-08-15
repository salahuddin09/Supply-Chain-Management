package org.scm.model;

import java.util.Date;

/**
 *
 * @author Personal
 */
public class Order {
    private int order_Number;
    private Date order_Placement_Date;
    private int product_ID;
    private int product_Quantity;
    private int retailer_ID;
    private int supplier_ID;
    private String order_Status;

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
     * @return the order_Placement_Date
     */
    public Date getOrder_Placement_Date() {
        return order_Placement_Date;
    }

    /**
     * @param order_Placement_Date the order_Placement_Date to set
     */
    public void setOrder_Placement_Date(Date order_Placement_Date) {
        this.order_Placement_Date = order_Placement_Date;
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

    /**
     * @return the retailer_ID
     */
    public int getRetailer_ID() {
        return retailer_ID;
    }

    /**
     * @param retailer_ID the retailer_ID to set
     */
    public void setRetailer_ID(int retailer_ID) {
        this.retailer_ID = retailer_ID;
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

   
}
