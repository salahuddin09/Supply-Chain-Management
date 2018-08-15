package org.scm.model;

import java.util.Date;

/**
 *
 * @author Personal
 */
public class Receivable {
    private int receive_Number;
    private Date receive_Date;
    private double total_Receive_Amount;
    private int order_Number;
    private int product_ID;
    private int retailer_ID;
    private int customer_ID;
    /**
     * @return the receive_Number
     */
    public int getReceive_Number() {
        return receive_Number;
    }

    /**
     * @param receive_Number the receive_Number to set
     */
    public void setReceive_Number(int receive_Number) {
        this.receive_Number = receive_Number;
    }

    /**
     * @return the receive_Date
     */
    public Date getReceive_Date() {
        return receive_Date;
    }

    /**
     * @param receive_Date the receive_Date to set
     */
    public void setReceive_Date(Date receive_Date) {
        this.receive_Date = receive_Date;
    }

    /**
     * @return the total_Receive_Amount
     */
    public double getTotal_Receive_Amount() {
        return total_Receive_Amount;
    }

    /**
     * @param total_Receive_Amount the total_Receive_Amount to set
     */
    public void setTotal_Receive_Amount(double total_Receive_Amount) {
        this.total_Receive_Amount = total_Receive_Amount;
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
     * @return the customer_ID
     */
    public int getCustomer_ID() {
        return customer_ID;
    }

    /**
     * @param customer_ID the customer_ID to set
     */
    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }
}
