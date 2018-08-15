package org.scm.ui;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.scm.bl.StoreManager;
import org.scm.model.Store;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.scm.bl.ReportManager;

public class StoreInfo extends Window {
    
    public StoreInfo() {
        scsproduct();
    }
    public void scsproduct() {  
        
        setCaption("Store Information");
        center();
        
       final TabSheet tabsheet = new TabSheet();
       final AbsoluteLayout absolute = new AbsoluteLayout();
       final GridLayout grid = new GridLayout(2, 7);
       final VerticalLayout ver = new VerticalLayout();
       final Label lbstoreid = new Label("Store ID");
       final Label lbstorelocation = new Label("Store Location");
       final Label lbstoredescription = new Label("Store Description");
       final Label lbproductid = new Label("Product ID");
       final Label lbproductcount = new Label("Product Count");
       final Label lbproductstoragethreshold = new Label("Product Storage Threshold");
       final TextField txtstoreid = new TextField();
       final TextField txtstorelocation = new TextField();
       final TextField txtstoredescription = new TextField();
       final TextField txtproductid = new TextField();
       final TextField txtproductcount = new TextField();
       final TextField txtproductstoragethreshold = new TextField();
       final ComboBox co = new ComboBox();
       final Button savebtn = new Button("SAVE");
       final Button deletebtn = new Button("DELETE");
       final Button refreshbtn = new Button("REFRESH");
       final Button updatebtn = new Button("UPDATE");
       final Label addtab = new Label("Insert Store");
       final Label deletetab = new Label("Delete Store");
       final Label searchtab = new Label("Search Store");
       final Label updatetab = new Label("Update Store");
        
       
        tabsheet.addTab(addtab, "ADD");
        tabsheet.addTab(deletetab, "DELETE");
        tabsheet.addTab(searchtab, "SEARCH");
        tabsheet.addTab(updatetab, "UPDATE");
        tabsheet.setSelectedTab(updatetab);
        
        grid.addComponent(lbstoreid);
        grid.addComponent(txtstoreid);
        grid.addComponent(lbstorelocation);
        grid.addComponent(txtstorelocation);
        grid.addComponent(lbstoredescription);
        grid.addComponent(txtstoredescription);
        grid.addComponent(lbproductid);
        grid.addComponent(txtproductid);
        grid.addComponent(lbproductcount);
        grid.addComponent(txtproductcount);
        grid.addComponent(lbproductstoragethreshold);
        grid.addComponent(txtproductstoragethreshold);
        
        absolute.addComponent(savebtn, "left: 0px; bottom: 0px;");
        absolute.addComponent(deletebtn, "left: 69px; bottom: 0px;");
        absolute.addComponent(refreshbtn, "left: 150px; bottom: 0px;");
        absolute.addComponent(updatebtn, "left: 235px; bottom: 0px;");
        
        addComponent(tabsheet);
        addComponent(ver);
        addComponent(grid);
        addComponent(absolute);
        
        grid.setSpacing(true);
        absolute.setWidth("400px");
        absolute.setHeight("150px");
        
        setModal(false);
        getContent().setSizeFull();
        setHeight("900px");
        setWidth("500px");
         final Table table = new Table("ALL Supplier");
        tabsheet.addListener(new TabSheet.SelectedTabChangeListener() {
            
            public void selectedTabChange(SelectedTabChangeEvent event) {
                final TabSheet source = (TabSheet) event.getSource();
                if (source == tabsheet) {
                    if (source.getSelectedTab() == addtab) {
                        lbstoreid.setVisible(false);
                        txtstoreid.setVisible(false);
                        lbstorelocation.setVisible(true);
                        txtstorelocation.setVisible(true);
                        lbstoredescription.setVisible(true);
                        txtstoredescription.setVisible(true);
                        lbproductid.setVisible(true);
                        txtproductid.setVisible(true);
                        lbproductcount.setVisible(true);
                        txtproductcount.setVisible(true);
                        lbproductstoragethreshold.setVisible(true);
                        txtproductstoragethreshold.setVisible(true);
                        savebtn.setEnabled(true);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false);  
                        grid.setVisible(true);
                        grid.setVisible(true);
                        ver.setVisible(false);
                    }
                    if (source.getSelectedTab() == deletetab) {
                        lbstoreid.setVisible(true);
                        txtstoreid.setVisible(true);
                        lbstorelocation.setVisible(false);
                        txtstorelocation.setVisible(false);
                        lbstoredescription.setVisible(false);
                        txtstoredescription.setVisible(false);
                        lbproductid.setVisible(false);
                        txtproductid.setVisible(false);
                        lbproductcount.setVisible(false);
                        txtproductcount.setVisible(false);
                        lbproductstoragethreshold.setVisible(false);
                        txtproductstoragethreshold.setVisible(false);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(true);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false); 
                        grid.setVisible(true);
                        grid.setVisible(true);
                        ver.setVisible(false);
                    }
                    if (source.getSelectedTab() == updatetab) {
                        lbstoreid.setVisible(true);
                        txtstoreid.setVisible(true);
                        lbstorelocation.setVisible(true);
                        txtstorelocation.setVisible(true);
                        lbstoredescription.setVisible(true);
                        txtstoredescription.setVisible(true);
                        lbproductid.setVisible(true);
                        txtproductid.setVisible(true);
                        lbproductcount.setVisible(true);
                        txtproductcount.setVisible(true);
                        lbproductstoragethreshold.setVisible(true);
                        txtproductstoragethreshold.setVisible(true);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(true); 
                        grid.setVisible(true);
                        grid.setVisible(true);
                        ver.setVisible(false);
                    }
                    if (source.getSelectedTab() == searchtab) {

                        ver.addComponent(co);
                        try {

                            StoreManager st = new StoreManager();
                            ReportManager db = new ReportManager();
                            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(db.driver, db.url + db.dbName, db.userName, db.password, 2, 2);
                           
                            FreeformQuery FreeFormQuery = new FreeformQuery(st.selectStore, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Store_Location");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                            Item item = co.getItem(co.getValue());
                                            String storeID = item.getItemProperty("Store_ID").toString();
                                            String storeLocation = item.getItemProperty("Store_Location").toString();
                                            String storeDescription = item.getItemProperty("Store_Description").toString();
                                            String productID = item.getItemProperty("Product_ID").toString();
                                            String productCount = item.getItemProperty("Product_Count").toString();
                                            String productStorageThreshold = item.getItemProperty("Product_Storage_Threshold").toString();

                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);
                                            table.addContainerProperty("Store ID", String.class, null);
                                            table.addContainerProperty("Store Location", String.class, null);
                                            table.addContainerProperty("Store Description", String.class, null);
                                            table.addContainerProperty("Product ID", String.class, null);
                                            table.addContainerProperty("Product Count", String.class, null);
                                            table.addContainerProperty("Product Storage Threshold", String.class, null);
                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(storeID), new String(storeLocation), new String(storeDescription), new String(productID), new String(productCount), new String(productStorageThreshold)}, new String(storeID));
                                            ver.addComponent(table);
                                            getWindow().showNotification("Showing your desired stock information");
                                        }
                                    });
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(StoreInfo.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(StoreInfo.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(StoreInfo.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }catch (Exception ex) {
                        getWindow().showNotification(
                                "ERROR!!! In searching Data...");
                    }
                        ver.setVisible(true);
                        grid.setVisible(false);
                    }
                }
            }
        });
        savebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == savebtn) {
                    StoreManager storeManager;
                    try {
                        storeManager = new StoreManager();
                        Store store = new Store();
                        store.setStore_Location(txtstorelocation.getValue().toString());
                        store.setStore_Description(txtstoredescription.getValue().toString());
                        store.setProduct_ID(Integer.valueOf(txtproductid.getValue().toString()));
                        store.setProduct_Count(Integer.valueOf(txtproductcount.getValue().toString()));
                        store.setProduct_Storage_Threshold(Integer.valueOf(txtproductstoragethreshold.getValue().toString()));

                        storeManager.insertNewStore(store);
                        txtstorelocation.setValue("");
                        txtstoredescription.setValue("");
                        txtproductid.setValue("");
                        txtproductcount.setValue("");
                        txtproductstoragethreshold.setValue("");
                        getWindow().showNotification(
                                "Your data saved successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
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
                    StoreManager storeManager;
                    try {
                        storeManager = new StoreManager();
                        Store store = new Store();
                        store.setStore_ID(Integer.valueOf(txtstoreid.getValue().toString()));
                        storeManager.deleteNewStore(store);
                        txtstoreid.setValue("");
                        getWindow().showNotification("Your data deleted successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
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
                    txtstoreid.setValue("");
                    txtstorelocation.setValue("");
                    txtstoredescription.setValue("");
                    txtproductid.setValue("");
                    txtproductcount.setValue("");
                    txtproductstoragethreshold.setValue("");
                    getWindow().showNotification(
                            "Your data refreshed successfully...!");
                }
            }
        });
        updatebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == updatebtn) {
                    StoreManager storeManager;
                    try {
                        storeManager = new StoreManager();
                        Store store = new Store();
                        store.setStore_ID(Integer.valueOf(txtstoreid.getValue().toString()));
                        store.setStore_Location(txtstorelocation.getValue().toString());
                        store.setStore_Description(txtstoredescription.getValue().toString());
                        store.setProduct_ID(Integer.valueOf(txtproductid.getValue().toString()));
                        store.setProduct_Count(Integer.valueOf(txtproductcount.getValue().toString()));
                        store.setProduct_Storage_Threshold(Integer.valueOf(txtproductstoragethreshold.getValue().toString()));

                        storeManager.updateNewStore(store);
                        txtstoreid.setValue("");
                        txtstorelocation.setValue("");
                        txtstoredescription.setValue("");
                        txtproductid.setValue("");
                        txtproductcount.setValue("");
                        txtproductstoragethreshold.setValue("");
                        getWindow().showNotification(
                                "Your data updated successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(StoreInfo.class.getName()).log(
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
