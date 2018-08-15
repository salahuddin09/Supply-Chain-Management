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
import org.scm.bl.ProductlineManager;
import org.scm.bl.ReportManager;
import org.scm.model.Productline;
/**
 *
 * @author Personal
 */
public class ProductLineInfo extends Window{
    public ProductLineInfo() {

        scsretailer();

    }

    public void scsretailer() {

        setCaption("ProductLine  Information");
        center();

        final TabSheet tabsheet = new TabSheet();
        final AbsoluteLayout abslout1 = new AbsoluteLayout();
        final GridLayout grid1 = new GridLayout(2, 5);
        final VerticalLayout vertical = new VerticalLayout();
        final Label lbproductineid = new Label("ProductLine ID");
        final Label lbordernumber = new Label("Order Number");
        final Label lbproductid = new Label("Product ID");
        final Label lbproductquantity = new Label("Product Quantity");
        final Label lbproductprice = new Label("Product Price");
        final TextField txtproductlineid = new TextField();
        final TextField txtordernumber = new TextField();
        final TextField txtproductid  = new TextField();
        final TextField txtproductquantity = new TextField();
        final TextField txtproductprice = new TextField();
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
        grid1.addComponent(lbproductineid);
        grid1.addComponent(txtproductlineid);
        grid1.addComponent(lbordernumber);
        grid1.addComponent(txtordernumber);
        grid1.addComponent(lbproductid);
        grid1.addComponent(txtproductid);
        grid1.addComponent(lbproductquantity);
        grid1.addComponent(txtproductquantity);
        grid1.addComponent(lbproductprice);
        grid1.addComponent(txtproductprice);
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
                        lbproductineid.setVisible(false);
                        txtproductlineid.setVisible(false);
                        lbordernumber.setVisible(true);
                        txtordernumber.setVisible(true);
                        lbproductid.setVisible(true);
                        txtproductid.setVisible(true);
                        lbproductquantity.setVisible(true);
                        txtproductquantity.setVisible(true);
                        lbproductprice.setVisible(true);
                        txtproductprice.setVisible(true);
                        savebtn.setEnabled(true);
                        deletebtn.setEnabled(false);
                        refreshbtn.setEnabled(true);
                        updatebtn.setEnabled(false);  
                        vertical.setVisible(false);
                        grid1.setVisible(true);
                    }
                    if (source.getSelectedTab() == deletetab) {
                        lbproductineid.setVisible(true);
                        txtproductlineid.setVisible(true);
                        lbordernumber.setVisible(false);
                        txtordernumber.setVisible(false);
                        lbproductid.setVisible(false);
                        txtproductid.setVisible(false);
                        lbproductquantity.setVisible(false);
                        txtproductquantity.setVisible(false);
                        lbproductprice.setVisible(false);
                        txtproductprice.setVisible(false);
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
                          
                            FreeformQuery FreeFormQuery = new FreeformQuery(re.selectProductline, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Productline_ID");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                            Item item = co.getItem(co.getValue());
                                            String productlineID = item.getItemProperty("Productline_ID").toString();
                                            String orderNumber = item.getItemProperty("Order_Number").toString();
                                            String productID = item.getItemProperty("Product_ID").toString();
                                            String productQuantity = item.getItemProperty("Product_Quantity").toString();
                                            String productPrice = item.getItemProperty("Product_Price").toString();
                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);

                                            table.addContainerProperty("Productline ID", String.class, null);
                                            table.addContainerProperty("Order Number", String.class, null);
                                            table.addContainerProperty("Product ID", String.class, null);
                                            table.addContainerProperty("Product Quantity", String.class, null);
                                            table.addContainerProperty("Product Price", String.class, null);

                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(productlineID), new String(orderNumber), new String(productID), new String(productQuantity), new String(productPrice)}, new String(productlineID));
                                            vertical.addComponent(table);
                                            getWindow().showNotification("Showing your desired productline information");
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
                        lbproductineid.setVisible(true);
                        txtproductlineid.setVisible(true);
                        lbordernumber.setVisible(true);
                        txtordernumber.setVisible(true);
                        lbproductid.setVisible(true);
                        txtproductid.setVisible(true);
                        lbproductquantity.setVisible(true);
                        txtproductquantity.setVisible(true);
                        lbproductprice.setVisible(true);
                        txtproductprice.setVisible(true);
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
                ProductlineManager productlineManager;
                if (event.getSource() == savebtn) {
                    try {
                        productlineManager = new ProductlineManager();
                        Productline productline = new Productline();
                        productline.setOrder_Number(Integer.valueOf(txtordernumber.getValue().toString()));
                        productline.setProduct_ID(Integer.valueOf(txtproductid.getValue().toString()));
                        productline.setProduct_Quantity(Integer.valueOf(txtproductquantity.getValue().toString()));
                        productline.setProduct_Price(Integer.valueOf(txtproductprice.getValue().toString()));
                        productlineManager.insertNewProductline(productline);
                        txtproductlineid.setValue("");
                        txtordernumber.setValue("");
                        txtproductid.setValue("");
                        txtproductquantity.setValue("");
                        txtproductprice.setValue("");
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
                 ProductlineManager productlineManager;
                if (event.getSource() == deletebtn) {
                    try {
                       productlineManager = new ProductlineManager();
                        Productline productline = new Productline();
                        productline.setProductline_ID(Integer.valueOf(txtproductlineid.getValue().toString()));
                        productlineManager.deleteNewProductline(productline);
                        txtproductlineid.setValue("");
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

                    txtproductlineid.setValue("");
                    txtordernumber.setValue("");
                    txtproductid.setValue("");
                    txtproductquantity.setValue("");
                    txtproductprice.setValue("");
                    getWindow().showNotification("Your data refreshed successfully...!");
                }
            }
        });
        updatebtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
               ProductlineManager productlineManager;
                if (event.getSource() == updatebtn) {
                    try {
                         productlineManager = new ProductlineManager();
                        Productline productline = new Productline();
                        productline.setProductline_ID(Integer.valueOf(txtproductlineid.getValue().toString()));
                         productline.setOrder_Number(Integer.valueOf(txtordernumber.getValue().toString()));
                        productline.setProduct_ID(Integer.valueOf(txtproductid.getValue().toString()));
                        productline.setProduct_Quantity(Integer.valueOf(txtproductquantity.getValue().toString()));
                       productline.setProduct_Price(Integer.valueOf(txtproductprice.getValue().toString()));
                        productlineManager.updateNewProductline(productline);
                        txtproductlineid.setValue("");
                        txtordernumber.setValue("");
                        txtproductid.setValue("");
                        txtproductquantity.setValue("");
                        txtproductprice.setValue("");
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
