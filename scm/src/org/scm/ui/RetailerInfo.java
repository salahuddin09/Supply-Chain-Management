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
import org.scm.bl.RetailerManager;
import org.scm.model.Retailer;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.scm.bl.ReportManager;

public class RetailerInfo extends Window {

    public RetailerInfo() {

        scsretailer();

    }

    public void scsretailer() {

        setCaption("Retailer Information");
        center();

        final TabSheet tabsheet = new TabSheet();
        final AbsoluteLayout abslout1 = new AbsoluteLayout();
        final GridLayout grid1 = new GridLayout(2, 5);
        final VerticalLayout vertical = new VerticalLayout();
        final Label lbretailerid = new Label("Retailer ID");
        final Label lbretailername = new Label("Retailer Name");
        final Label lbretaileraddress = new Label("Retailer Address");
        final Label lbretailercontact = new Label("Retailer Contact No");
        final Label lbretaileremail = new Label("Retailer Email");
        final TextField txtretailerid = new TextField();
        final TextField txtretailername = new TextField();
        final TextField txtretaileraddress = new TextField();
        final TextField txtretailercontact = new TextField();
        final TextField txtretaileremail = new TextField();
        final ComboBox co = new ComboBox();
        final Button savebtn = new Button("SAVE");
        final Button deletebtn = new Button("DELETE");
        final Button refreshbtn = new Button("REFRESH");
        final Button updatebtn = new Button("UPDATE");
        final Label addtab = new Label("Insert Retailer");
        final Label deletetab = new Label("Delete Retailer");
        final Label searchtab = new Label("Search Retailer");
        final Label updatetab = new Label("Update Retailer");

        tabsheet.addTab(addtab, "ADD");
        tabsheet.addTab(deletetab, "DELETE");
        tabsheet.addTab(searchtab, "SEARCH");
        tabsheet.addTab(updatetab, "UPDATE");
        tabsheet.setSelectedTab(updatetab);
        grid1.addComponent(lbretailerid);
        grid1.addComponent(txtretailerid);
        grid1.addComponent(lbretailername);
        grid1.addComponent(txtretailername);
        grid1.addComponent(lbretaileraddress);
        grid1.addComponent(txtretaileraddress);
        grid1.addComponent(lbretailercontact);
        grid1.addComponent(txtretailercontact);
        grid1.addComponent(lbretaileremail);
        grid1.addComponent(txtretaileremail);
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
  final Table table = new Table("ALL Retailer");
        tabsheet.addListener(new TabSheet.SelectedTabChangeListener() {

            public void selectedTabChange(SelectedTabChangeEvent event) {
                final TabSheet source = (TabSheet) event.getSource();
                if (source == tabsheet) {
                    if (source.getSelectedTab() == addtab) {
                        lbretailerid.setVisible(false);
                        txtretailerid.setVisible(false);
                        lbretailername.setVisible(true);
                        txtretailername.setVisible(true);
                        lbretaileraddress.setVisible(true);
                        txtretaileraddress.setVisible(true);
                        lbretailercontact.setVisible(true);
                        txtretailercontact.setVisible(true);
                        lbretaileremail.setVisible(true);
                        txtretaileremail.setVisible(true);
                        savebtn.setEnabled(true);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false);  
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                    if (source.getSelectedTab() == deletetab) {
                        lbretailerid.setVisible(true);
                        txtretailerid.setVisible(true);
                        lbretailername.setVisible(false);
                        txtretailername.setVisible(false);
                        lbretaileraddress.setVisible(false);
                        txtretaileraddress.setVisible(false);
                        lbretailercontact.setVisible(false);
                        txtretailercontact.setVisible(false);
                        lbretaileremail.setVisible(false);
                        txtretaileremail.setVisible(false);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(true);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false); 
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                    if (source.getSelectedTab() == searchtab) {
                        vertical.addComponent(co);
                        try {

                            RetailerManager re = new RetailerManager();
                            ReportManager db = new ReportManager();
                            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(db.driver, db.url + db.dbName, db.userName, db.password, 2, 2);
                          
                            FreeformQuery FreeFormQuery = new FreeformQuery(re.selectRetailer, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Retailer_Name");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                            Item item = co.getItem(co.getValue());
                                            String retailerID = item.getItemProperty("Retailer_ID").toString();
                                            String retailerName = item.getItemProperty("Retailer_Name").toString();
                                            String retailerAddress = item.getItemProperty("Retailer_Address").toString();
                                            String retailerContact = item.getItemProperty("Retailer_Contact_No").toString();
                                            String retailerEmail = item.getItemProperty("Retailer_Email").toString();
                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);

                                            table.addContainerProperty("Retailer ID", String.class, null);
                                            table.addContainerProperty("Retailer Name", String.class, null);
                                            table.addContainerProperty("Retailer Address", String.class, null);
                                            table.addContainerProperty("Retailer Contact No", String.class, null);
                                            table.addContainerProperty("Retailer Email", String.class, null);

                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(retailerID), new String(retailerName), new String(retailerAddress), new String(retailerContact), new String(retailerEmail)}, new String(retailerID));
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
                        } catch (Exception ex) {
                            getWindow().showNotification(
                                    "ERROR!!! In searching Data...");
                        }
                        vertical.setVisible(true);
                        grid1.setVisible(false);
                    }
                    if (source.getSelectedTab() == updatetab) {
                        lbretailerid.setVisible(true);
                        txtretailerid.setVisible(true);
                        lbretailername.setVisible(true);
                        txtretailername.setVisible(true);
                        lbretaileraddress.setVisible(true);
                        txtretaileraddress.setVisible(true);
                        lbretailercontact.setVisible(true);
                        txtretailercontact.setVisible(true);
                        lbretaileremail.setVisible(true);
                        txtretaileremail.setVisible(true);
                        savebtn.setEnabled(false);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(true); 
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                }
            }
        });
        savebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                RetailerManager retailerManager;
                if (event.getSource() == savebtn) {
                    try {
                        retailerManager = new RetailerManager();
                        Retailer retailer = new Retailer();
                        retailer.setRetailer_Name(txtretailername.getValue().toString());
                        retailer.setRetailer_Address(txtretaileraddress.getValue().toString());
                        retailer.setRetailer_Contact_No(txtretailercontact.getValue().toString());
                        retailer.setRetailer_Email(txtretaileremail.getValue().toString());
                        retailerManager.insertNewRetailer(retailer);
                        txtretailerid.setValue("");
                        txtretailername.setValue("");
                        txtretaileraddress.setValue("");
                        txtretailercontact.setValue("");
                        txtretaileremail.setValue("");
                        getWindow().showNotification("Your data saved successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification("ERROR!!! In submitting Data...");
                    }

                }
            }
        });

        deletebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                RetailerManager retailerManager;
                if (event.getSource() == deletebtn) {
                    try {
                        retailerManager = new RetailerManager();
                        Retailer retailer = new Retailer();
                        retailer.setRetailer_ID(Integer.valueOf(txtretailerid.getValue().toString()));
                        retailerManager.deleteNewRetailer(retailer);
                        txtretailerid.setValue("");
                        getWindow().showNotification("Your data deleted successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
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

                    txtretailerid.setValue("");
                    txtretailername.setValue("");
                    txtretaileraddress.setValue("");
                    txtretailercontact.setValue("");
                    txtretaileremail.setValue("");
                    getWindow().showNotification("Your data refreshed successfully...!");
                }
            }
        });
        updatebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                RetailerManager retailerManager;
                if (event.getSource() == updatebtn) {
                    try {
                        retailerManager = new RetailerManager();
                        Retailer retailer = new Retailer();
                        retailer.setRetailer_ID(Integer.valueOf(txtretailerid.getValue().toString()));
                        retailer.setRetailer_Name(txtretailername.getValue().toString());
                        retailer.setRetailer_Address(txtretaileraddress.getValue().toString());
                        retailer.setRetailer_Contact_No(txtretailercontact.getValue().toString());
                        retailer.setRetailer_Email(txtretaileremail.getValue().toString());
                        retailerManager.updateNewRetailer(retailer);
                        txtretailerid.setValue("");
                        txtretailername.setValue("");
                        txtretaileraddress.setValue("");
                        txtretailercontact.setValue("");
                        txtretaileremail.setValue("");
                        getWindow().showNotification("Your data updated successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(RetailerInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification("ERROR!!! In updating Data...");
                    }


                }
            }
        });
    }
}
