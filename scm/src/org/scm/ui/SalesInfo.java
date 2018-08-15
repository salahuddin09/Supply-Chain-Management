/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.scm.bl.SalesList;
import org.scm.bl.StoreMan;

/**
 *
 * @author Personal
 */
public class SalesInfo extends Window{
    public SalesInfo() {
        scssales();
    }
 public void scssales() {
      setCaption("Sales Information");
        center();
        setModal(false);
        getContent().setSizeFull();
        setHeight("900px");
        setWidth("500px");
        final VerticalLayout vertical = new VerticalLayout();
       Label lbproductID =new Label("Insert Product ID To Show Total Sales ::");
       final TextField txtproductID =new TextField();
       final Button btnSales = new Button("Click");
       btnSales.setDescription("Click this button for your product update, sales by supplier");
        vertical.addComponent(lbproductID);
        vertical.addComponent(txtproductID);
        vertical.addComponent(btnSales);
       btnSales.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == btnSales) {
                    try {
                        SalesList product = new SalesList();
                        product.setProduct_ID(Integer.valueOf(txtproductID.getValue().toString()));
                        StoreMan sale = new StoreMan();
                        List<SalesList> salesList=sale.getListOfSales(product);
         getWindow().showNotification("Showing your product sales information.");            
                        txtproductID.setValue("");
                         final Table table = new Table("ALL SALES");
                         table.setStyleName("iso3166");
                         table.setPageLength(5);
                         table.setSizeFull();
                         table.setSelectable(true);
                         table.setMultiSelect(false);
                         table.setImmediate(true);
                         table.setColumnReorderingAllowed(true);
                         table.setColumnCollapsingAllowed(true);
                                            table.addContainerProperty("Product Name", String.class, null);
                                            table.addContainerProperty("Count Of Orders",Integer.class, null);
                                            table.addContainerProperty("Total Sales Of Products", Integer.class, null);
                      for(SalesList sal:salesList){
                        table.addItem(new Object[]{new String(sal.getProduct_Name()),new Integer(sal.getOrder_count()),new Integer(sal.getTotal_sales())}, new Integer(sal.getProduct_ID()));
                        }                            
                        vertical.addComponent(table);           
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SalesInfo.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(SalesInfo.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(SalesInfo.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(SalesInfo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                }
                }
        });
                             vertical.setVisible(true);
                             addComponent(vertical);
                           
 }
}  
                                
                          
                                                                          
