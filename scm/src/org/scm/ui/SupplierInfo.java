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
import org.scm.bl.SupplierManager;
import org.scm.model.Supplier;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Select;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import org.scm.bl.ReportManager;

public class SupplierInfo extends Window {

    public SupplierInfo()  {
            scssupplier();
    }
    public void scssupplier()  {
        setCaption("Supplier Information");
        center();

        final TabSheet tabsheet = new TabSheet();
        final VerticalLayout ver = new VerticalLayout();
        final VerticalLayout vertical = new VerticalLayout();
        final AbsoluteLayout absolute = new AbsoluteLayout();
        final GridLayout grid = new GridLayout(2, 5);
        
        
         
        final Label lbsupplierid = new Label("Supplier ID");
        final Label lbsuppliername = new Label("Supplier Name");
        final Label lbsupplieraddress = new Label("Supplier Address");
        final Label lbsuppliercontact = new Label("Supplier Contact No");
        final Label lbsupplieremail = new Label("Supplier Email");
        final TextField txtsupplierid = new TextField();
        final TextField txtsuppliername = new TextField();
        final TextField txtsupplieraddress = new TextField();
        final TextField txtsuppliercontact = new TextField();
        final TextField txtsupplieremail = new TextField();
         final ComboBox co = new ComboBox();
        final Button savebtn = new Button("SAVE");
        final Button deletebtn = new Button("DELETE");
        final Button refreshbtn = new Button("REFRESH");
        final Button updatebtn = new Button("UPDATE");
        
        final Label addtab = new Label("Insert Supplier");
        final Label deletetab = new Label("Delete Supplier");
        final Label searchtab = new Label("Search Supplier");
        final Label updatetab = new Label("Update Supplier");
      
          
        tabsheet.addTab(addtab, "ADD");
        tabsheet.addTab(deletetab, "DELETE");
        tabsheet.addTab(searchtab, "SEARCH");
        tabsheet.addTab(updatetab, "UPDATE");
        
        
        grid.addComponent(lbsupplierid);
        grid.addComponent(txtsupplierid);
        grid.addComponent(lbsuppliername);
        grid.addComponent(txtsuppliername);
        grid.addComponent(lbsupplieraddress);
        grid.addComponent(txtsupplieraddress);
        grid.addComponent(lbsuppliercontact);
        grid.addComponent(txtsuppliercontact);
        grid.addComponent(lbsupplieremail);
        grid.addComponent(txtsupplieremail);
        
        absolute.addComponent(savebtn, "left: 0px; bottom: 0px;");
        absolute.addComponent(deletebtn, "left: 69px; bottom: 0px;");
        absolute.addComponent(refreshbtn, "left: 150px; bottom: 0px;");
        absolute.addComponent(updatebtn, "left: 235px; bottom: 0px;");
        
        grid.setSpacing(true);
        absolute.setWidth("400px");
        absolute.setHeight("150px");
        tabsheet.setSelectedTab(updatetab);
        
        addComponent(tabsheet);
        addComponent(vertical);
        addComponent(grid);
        addComponent(absolute);
        
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
                      
                        lbsupplierid.setVisible(false);
                        txtsupplierid.setVisible(false);
                        lbsuppliername.setVisible(true);
                        txtsuppliername.setVisible(true);
                        lbsupplieraddress.setVisible(true);
                        txtsupplieraddress.setVisible(true);
                        lbsuppliercontact.setVisible(true);
                        txtsuppliercontact.setVisible(true);
                        lbsupplieremail.setVisible(true);
                        txtsupplieremail.setVisible(true);
                        savebtn.setEnabled(true);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false);  
                        grid.setVisible(true);
                         vertical.setVisible(false);
                    }
                    if (source.getSelectedTab() == deletetab) {
                        lbsupplierid.setVisible(true);
                        txtsupplierid.setVisible(true);
                        lbsuppliername.setVisible(false);
                        txtsuppliername.setVisible(false);
                        lbsupplieraddress.setVisible(false);
                        txtsupplieraddress.setVisible(false);
                        lbsuppliercontact.setVisible(false);
                        txtsuppliercontact.setVisible(false);
                        lbsupplieremail.setVisible(false);
                        txtsupplieremail.setVisible(false);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(true);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false); 
                        grid.setVisible(true);
                         vertical.setVisible(false);
                    }
                    if (source.getSelectedTab() == searchtab) {

                      vertical.addComponent(co);
                        try {

                            SupplierManager su = new SupplierManager();
                            ReportManager db = new ReportManager();
                            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(db.driver, db.url + db.dbName, db.userName, db.password, 2, 2);
                            
                            FreeformQuery FreeFormQuery = new FreeformQuery(su.selectSupplier, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Supplier_Name");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                            Item item = co.getItem(co.getValue());
                                            String supplierID = item.getItemProperty("Supplier_ID").toString();
                                            String supplierName = item.getItemProperty("Supplier_Name").toString();
                                            String supplierAddress = item.getItemProperty("Supplier_Address").toString();
                                            String supplierContact = item.getItemProperty("Supplier_Contact_No").toString();
                                            String supplierEmail = item.getItemProperty("Supplier_Email").toString();
                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);        
                                            table.addContainerProperty("Supplier ID", Integer.class, null);
                                            table.addContainerProperty("Supplier Name", String.class, null);
                                            table.addContainerProperty("Supplier Address", String.class, null);
                                            table.addContainerProperty("Supplier Contact No", String.class, null);
                                            table.addContainerProperty("Supplier Email", String.class, null);
                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(supplierID), new String(supplierName), new String(supplierAddress), new String(supplierContact), new String(supplierEmail)}, new String(supplierID));
                                           vertical.addComponent(table);
                                            getWindow().showNotification("Showing your desired product information");
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
                        vertical.setVisible(true);
                        grid.setVisible(false);
                    }
                    if (source.getSelectedTab() == updatetab) {
                        
                        lbsupplierid.setVisible(true);
                        txtsupplierid.setVisible(true);
                        lbsuppliername.setVisible(true);
                        txtsuppliername.setVisible(true);
                        lbsupplieraddress.setVisible(true);
                        txtsupplieraddress.setVisible(true);
                        lbsuppliercontact.setVisible(true);
                        txtsuppliercontact.setVisible(true);
                        lbsupplieremail.setVisible(true);
                        txtsupplieremail.setVisible(true);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(true); 
                       vertical.setVisible(false);
                        grid.setVisible(true);
                    }
                }
            }
        });
        savebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                SupplierManager supplierManager;
                if (event.getSource() == savebtn) {
                    try {
                        supplierManager = new SupplierManager();
                        Supplier supplier = new Supplier();
                        supplier.setSupplier_Name(txtsuppliername.getValue().toString());
                        supplier.setSupplier_Address(txtsupplieraddress.getValue().toString());
                        supplier.setSupplier_Contact_No(txtsuppliercontact.getValue().toString());
                        supplier.setSupplier_Email(txtsupplieremail.getValue().toString());
                        supplierManager.insertNewSupplier(supplier);
                        txtsupplierid.setValue("");
                        txtsuppliername.setValue("");
                        txtsupplieraddress.setValue("");
                        txtsuppliercontact.setValue("");
                        txtsupplieremail.setValue("");
                        getWindow().showNotification("Your data saved successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification("ERROR!!! In submitting Data...");
                    }

                }
            }
        });

        deletebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                SupplierManager supplierManager;
                if (event.getSource() == deletebtn) {
                    try {
                        supplierManager = new SupplierManager();
                        Supplier supplier = new Supplier();
                        supplier.setSupplier_ID(Integer.valueOf(txtsupplierid.getValue().toString()));
                        supplierManager.deleteNewSupplier(supplier);
                        txtsupplierid.setValue("");
                        getWindow().showNotification("Your data deleted successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification("ERROR!!! In Deleting Data...");
                    }


                }
            }
        });

        refreshbtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == refreshbtn) {

                    txtsupplierid.setValue("");
                    txtsuppliername.setValue("");
                    txtsupplieraddress.setValue("");
                    txtsuppliercontact.setValue("");
                    txtsupplieremail.setValue("");
                    getWindow().showNotification("Your data refreshed successfully...!");
                }
            }
        });
   
        updatebtn.addListener(new Button.ClickListener() {

            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            public void buttonClick(ClickEvent event) {
                SupplierManager supplierManager;
                if (event.getSource() == updatebtn) {
                    try {
                        supplierManager = new SupplierManager();
                        Supplier supplier = new Supplier();
                        supplier.setSupplier_ID(Integer.valueOf(txtsupplierid.getValue().toString()));
                        supplier.setSupplier_Name(txtsuppliername.getValue().toString());
                        supplier.setSupplier_Address(txtsupplieraddress.getValue().toString());
                        supplier.setSupplier_Contact_No(txtsuppliercontact.getValue().toString());
                        supplier.setSupplier_Email(txtsupplieremail.getValue().toString());
                        supplierManager.updateNewSupplier(supplier);
                        txtsupplierid.setValue("");
                        txtsuppliername.setValue("");
                        txtsupplieraddress.setValue("");
                        txtsuppliercontact.setValue("");
                        txtsupplieremail.setValue("");
                        getWindow().showNotification("Your data updated successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupplierInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification("ERROR!!! In updating Data...");
                    }
                }
            }
        });
    }
    
}
