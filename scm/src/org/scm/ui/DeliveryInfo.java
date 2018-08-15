/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.ui;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.scm.bl.DeliveryManager;
import org.scm.bl.ReportManager;
import org.scm.model.Delivery;

/**
 *
 * @author Personal
 */
public class DeliveryInfo extends Window {

    public DeliveryInfo() {
        scsproduct();
    }

    public void scsproduct() {

        setCaption("Delivery Information");
        center();

        final TabSheet tabsheet = new TabSheet();
        final AbsoluteLayout abslout1 = new AbsoluteLayout();
        final GridLayout grid1 = new GridLayout(2, 5);
        final VerticalLayout vertical = new VerticalLayout();
        final Label lbdeliverynumber = new Label("Delivery Number");
        final Label lbordernumber = new Label("Order Number");
        final Label lbfulfillmentdate = new Label("Order Fulfillment Date");
        final Label lbsupplierid = new Label("Supplier ID");
        final Label lborderstatus = new Label("Order Status");
        final TextField txtdeliverynumber = new TextField();
        final TextField txtordernumber = new TextField();
        final TextField txtfulfillmentdate = new TextField();
        final TextField txtsupplierid = new TextField();
        final TextField txtorderstatus = new TextField();
        final ComboBox co = new ComboBox();
        final Button savebtn = new Button("SAVE");
        final Button deletebtn = new Button("DELETE");
        final Button refreshbtn = new Button("REFRESH");
        final Button updatebtn = new Button("UPDATE");
        final Label addtab = new Label("Insert Order");
        final Label deletetab = new Label("Delete Order");
        final Label searchtab = new Label("Search Order");
        final Label updatetab = new Label("Update Order");

        tabsheet.addTab(addtab, "ADD");
        tabsheet.addTab(deletetab, "DELETE");
        tabsheet.addTab(searchtab, "SEARCH");
        tabsheet.addTab(updatetab, "UPDATE");
        tabsheet.setSelectedTab(updatetab);
        grid1.addComponent(lbdeliverynumber);
        grid1.addComponent(txtdeliverynumber);
        grid1.addComponent(lbordernumber);
        grid1.addComponent(txtordernumber);
        grid1.addComponent(lbfulfillmentdate);
        grid1.addComponent(txtfulfillmentdate);
        grid1.addComponent(lbsupplierid);
        grid1.addComponent(txtsupplierid);
        grid1.addComponent(lborderstatus);
        grid1.addComponent(txtorderstatus);
        abslout1.addComponent(savebtn, "left: 0px; bottom: 0px;");
        abslout1.addComponent(deletebtn, "left: 69px; bottom: 0px;");
        abslout1.addComponent(refreshbtn, "left: 150px; bottom: 0px;");
        abslout1.addComponent(updatebtn, "left: 235px; bottom: 0px;");
        grid1.setSpacing(true);
        abslout1.setWidth("400px");
        abslout1.setHeight("150px");
        setModal(false);
        getContent().setSizeFull();
        setHeight("900px");
        setWidth("500px");
        addComponent(tabsheet);
        addComponent(vertical);
        addComponent(grid1);
        addComponent(abslout1);
 final Table table = new Table("ALL Delivery");
        tabsheet.addListener(new TabSheet.SelectedTabChangeListener() {

            public void selectedTabChange(SelectedTabChangeEvent event) {
                final TabSheet source = (TabSheet) event.getSource();
                if (source == tabsheet) {
                    if (source.getSelectedTab() == addtab) {
                        lbdeliverynumber.setVisible(false);
                        txtdeliverynumber.setVisible(false);
                        lbordernumber.setVisible(true);
                        txtordernumber.setVisible(true);
                        lbfulfillmentdate.setVisible(true);
                        txtfulfillmentdate.setVisible(true);
                        lbsupplierid.setVisible(true);
                        txtsupplierid.setVisible(true);
                        lborderstatus.setVisible(true);
                        txtorderstatus.setVisible(true);
                        savebtn.setEnabled(true);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false);
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                    if (source.getSelectedTab() == deletetab) {
                        lbdeliverynumber.setVisible(true);
                        txtdeliverynumber.setVisible(true);
                        lbordernumber.setVisible(false);
                        txtordernumber.setVisible(false);
                        lbfulfillmentdate.setVisible(false);
                        txtfulfillmentdate.setVisible(false);
                        lbsupplierid.setVisible(false);
                        txtsupplierid.setVisible(false);
                        lborderstatus.setVisible(false);
                        txtorderstatus.setVisible(false);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(true);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false);
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                    if (source.getSelectedTab() == updatetab) {
                        lbdeliverynumber.setVisible(true);
                        txtdeliverynumber.setVisible(true);
                        lbordernumber.setVisible(true);
                        txtordernumber.setVisible(true);
                        lbfulfillmentdate.setVisible(true);
                        txtfulfillmentdate.setVisible(true);
                        lbsupplierid.setVisible(true);
                        txtsupplierid.setVisible(true);
                        lborderstatus.setVisible(true);
                        txtorderstatus.setVisible(true);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(true);
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                    if (source.getSelectedTab() == searchtab) {
                        vertical.addComponent(co);
                        try {

                            DeliveryManager delivery = new DeliveryManager();
                            ReportManager db = new ReportManager();
                            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(db.driver, db.url + db.dbName, db.userName, db.password, 2, 2);
                           
                            FreeformQuery FreeFormQuery = new FreeformQuery(delivery.selectDelivery, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Delivery_Number");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                            Item item = co.getItem(co.getValue());
                                            String deliveryNumber = item.getItemProperty("Delivery_Number").toString();
                                            String orderNumber = item.getItemProperty("Order_Number").toString();
                                            String fullfillmentDate = item.getItemProperty("Order_Fulfillment_Date").toString();

                                            String supplierID = item.getItemProperty("Supplier_ID").toString();

                                            String orderStatus = item.getItemProperty("Order_Status").toString();
                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);

                                            table.addContainerProperty("Delivery Number", String.class, null);
                                            table.addContainerProperty("Order Number", String.class, null);
                                            table.addContainerProperty("Order Fulfillment Date", String.class, null);
                                            table.addContainerProperty("Supplier ID", String.class, null);
                                            table.addContainerProperty("Order Status", String.class, null);

                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(deliveryNumber), new String(orderNumber), new String(fullfillmentDate), new String(supplierID), new String(orderStatus)}, new String(deliveryNumber));
                                            vertical.addComponent(table);
                                            getWindow().showNotification("Showing your desired product information");

                                        }
                                    });
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DeliveryInfo.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(DeliveryInfo.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(DeliveryInfo.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (Exception ex) {
                            getWindow().showNotification(
                                    "ERROR!!! In searching Data...");
                        }
                        vertical.setVisible(true);
                        grid1.setVisible(false);
                    }
                }
            }
        });
        savebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == savebtn) {
                    DeliveryManager deliveryManager;
                    try {
                        deliveryManager = new DeliveryManager();
                        Delivery delivery = new Delivery();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

                        Date date1 = null;
                        date1 = sdf1.parse(txtfulfillmentdate.getValue().toString());
                        delivery.setOrder_Number(Integer.valueOf((txtordernumber.getValue().toString())));
                        delivery.setOrder_Fulfillment_Date(date1);
                        delivery.setSupplier_ID(Integer.valueOf(txtsupplierid.getValue().toString()));
                        delivery.setOrder_Status(txtorderstatus.getValue().toString());
                        deliveryManager.insertNewDelivery(delivery);
                        txtordernumber.setValue("");
                        txtfulfillmentdate.setValue("");
                        txtsupplierid.setValue("");
                        txtorderstatus.setValue("");
                        getWindow().showNotification(
                                "Your data saved successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification(
                                "ERROR!!! In submitting Data...");
                    }
                }
            }
        });

        deletebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == deletebtn) {
                    DeliveryManager deliveryManager;
                    try {
                        deliveryManager = new DeliveryManager();
                        Delivery delivery = new Delivery();
                        delivery.setDelivery_Number(Integer.valueOf(txtdeliverynumber.getValue().toString()));
                        deliveryManager.deleteNewDelivery(delivery);
                        txtdeliverynumber.setValue("");
                        getWindow().showNotification("Your data deleted successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification(
                                "ERROR!!! In deleting Data...");
                    }

                }
            }
        });

        refreshbtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == refreshbtn) {
                    txtdeliverynumber.setValue("");
                    txtordernumber.setValue("");
                    txtfulfillmentdate.setValue("");
                    txtsupplierid.setValue("");
                    txtorderstatus.setValue("");
                    getWindow().showNotification(
                            "Your data refreshed successfully...!");
                }
            }
        });
        updatebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == updatebtn) {

                    DeliveryManager deliveryManager;
                    try {
                        deliveryManager = new DeliveryManager();
                        Delivery delivery = new Delivery();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

                        Date date1 = null;
                        date1 = sdf1.parse(txtfulfillmentdate.getValue().toString());
                        delivery.setDelivery_Number(Integer.valueOf((txtdeliverynumber.getValue().toString())));
                        delivery.setOrder_Number(Integer.valueOf((txtordernumber.getValue().toString())));
                        delivery.setOrder_Fulfillment_Date(date1);
                        delivery.setSupplier_ID(Integer.valueOf(txtsupplierid.getValue().toString()));
                        delivery.setOrder_Status(txtorderstatus.getValue().toString());
                        deliveryManager.updateNewDelivery(delivery);
                        txtdeliverynumber.setValue("");
                        txtordernumber.setValue("");
                        txtfulfillmentdate.setValue("");
                        txtsupplierid.setValue("");
                        txtorderstatus.setValue("");
                        getWindow().showNotification(
                                "Your data updated successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DeliveryInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification(
                                "ERROR!!! In updating Data...");
                    }
                }
            }
        });

    }
}
