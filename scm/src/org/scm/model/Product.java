package org.scm.model;

/**
*
* @author Personal
*/
public class Product {
   private int product_ID;
   private String product_Name;
   private String product_Description;
   private String product_Unit;
   private double product_Weight;
   private double product_Cost;
   private String product_Prior_Year_Sale_Goal;
   private String product_Current_Year_Sale_Goal;
  // private String product_Line_ID;

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
    * @return the product_Description
    */
   public String getProduct_Description() {
       return product_Description;
   }

   /**
    * @param product_Description the product_Description to set
    */
   public void setProduct_Description(String product_Description) {
       this.product_Description = product_Description;
   }

   /**
    * @return the product_Finish
    */
   public String getProduct_Unit() {
       return product_Unit;
   }

   /**
    * @param product_Finish the product_Finish to set
    */
   public void setProduct_Unit(String product_Unit) {
       this.product_Unit = product_Unit;
   }

   /**
    * @return the product_cost
    */
   public double getProduct_Cost() {
       return product_Cost;
   }

   /**
    * @param product_cost the product_cost to set
    */
   public void setProduct_Cost(double product_Cost) {
       this.product_Cost = product_Cost;
   }

   /**
    * @return the product_Prior_Year_Sale_Goal
    */
   public String getProduct_Prior_Year_Sale_Goal() {
       return product_Prior_Year_Sale_Goal;
   }

   /**
    * @param product_Prior_Year_Sale_Goal the product_Prior_Year_Sale_Goal to set
    */
   public void setProduct_Prior_Year_Sale_Goal(String product_Prior_Year_Sale_Goal) {
       this.product_Prior_Year_Sale_Goal = product_Prior_Year_Sale_Goal;
   }

   /**
    * @return the product_Current_Year_Sale_Goal
    */
   public String getProduct_Current_Year_Sale_Goal() {
       return product_Current_Year_Sale_Goal;
   }

   /**
    * @param product_Current_Year_Sale_Goal the product_Current_Year_Sale_Goal to set
    */
   public void setProduct_Current_Year_Sale_Goal(String product_Current_Year_Sale_Goal) {
       this.product_Current_Year_Sale_Goal = product_Current_Year_Sale_Goal;
   }

   /**
    * @return the product_Weight
    */
   public double getProduct_Weight() {
       return product_Weight;
   }

   /**
    * @param product_Weight the product_Weight to set
    */
   public void setProduct_Weight(double product_Weight) {
       this.product_Weight = product_Weight;
   }

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
    * @return the product_Line_ID
    */
 //  public String getProduct_Line_ID() {
 //      return product_Line_Name;
 //  }

   /**
    * @param product_Line_Name the product_Line_ID to set
    */
 //  public void setProduct_Line_Name(String product_Line_ID) {
 //      this.product_Line_ID = product_Line_ID;
  // }
}
