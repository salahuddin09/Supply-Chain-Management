package org.scm.bl;

public class SalesList {
    private int product_ID;
    private String product_Name;
    private int order_count;
    private int total_sales;
    

    /**
     * @return the product_Name
     */
    public String getProduct_Name() {
        return product_Name;
    }

    /**
     * @param product_Name the product_Name to set
     */
    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    /**
     * @return the order_count
     */
    public int getOrder_count() {
        return order_count;
    }

    /**
     * @param order_count the order_count to set
     */
    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    /**
     * @return the total_sales
     */
    public int getTotal_sales() {
        return total_sales;
    }

    /**
     * @param total_sales the total_sales to set
     */
    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
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
    
}
