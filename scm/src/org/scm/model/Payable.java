package org.scm.model;

import java.util.Date;

/**
 *
 * @author Personal
 */
public class Payable {
    private int payment_ID;
    private Date payment_Date;
    private double total_Payment_Amount;
    private int product_ID;
    private int supplier_ID;
    private int company_ID;

    /**
     * @return the payment_ID
     */
    public int getPayment_ID() {
        return payment_ID;
    }

    /**
     * @param payment_ID the payment_ID to set
     */
    public void setPayment_ID(int payment_ID) {
        this.payment_ID = payment_ID;
    }

    /**
     * @return the payment_Date
     */
    public Date getPayment_Date() {
        return payment_Date;
    }

    /**
     * @param payment_Date the payment_Date to set
     */
    public void setPayment_Date(Date payment_Date) {
        this.payment_Date = payment_Date;
    }

    /**
     * @return the total_Payment_Amount
     */
    public double getTotal_Payment_Amount() {
        return total_Payment_Amount;
    }

    /**
     * @param total_Payment_Amount the total_Payment_Amount to set
     */
    public void setTotal_Payment_Amount(double total_Payment_Amount) {
        this.total_Payment_Amount = total_Payment_Amount;
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
     * @return the company_ID
     */
    public int getCompany_ID() {
        return company_ID;
    }

    /**
     * @param company_ID the company_ID to set
     */
    public void setCompany_ID(int company_ID) {
        this.company_ID = company_ID;
    }
}
