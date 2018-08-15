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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.scm.bl.ProductManager;
import org.scm.bl.ReportManager;
import org.scm.model.Product;

public class ProductInfo extends Window {

        public ProductInfo() {

        scsproduct();

    }

    public void scsproduct() {

        setCaption("Products Information");
        center();

        final TabSheet tabsheet = new TabSheet();
        final AbsoluteLayout absolute = new AbsoluteLayout();
        final GridLayout grid = new GridLayout(2, 7);
        final VerticalLayout vertical = new VerticalLayout();
        final Label lbProductId = new Label("Product ID");
        final Label lbProductName = new Label("Product Name");
        final Label lbProductDescription = new Label("Product Description");
        final Label lbProductUnit = new Label("Product Unit");
        final Label lbProductWeight = new Label("Product Weight");
        final Label lbProductCost = new Label("Product Cost");
        final Label lbPrior = new Label("Product Prior Year Sales Goal");
        final Label lbCurrent = new Label("Product Current Year Sales Goal");
        final TextField txtProductID = new TextField();
        final TextField txtProductName = new TextField();
        final TextField txtProductDescription = new TextField();
        final TextField txtProductUnit = new TextField();
        final TextField txtProductWeight = new TextField();
        final TextField txtProductCost = new TextField();
        final TextField txtPrior = new TextField();
        final TextField txtCurrent = new TextField();
        
        final ComboBox co = new ComboBox();
        final Button saveBtn = new Button("SAVE");
        final Button deleteBtn = new Button("DELETE");
        final Button refreshBtn = new Button("REFRESH");
        final Button updateBtn = new Button("UPDATE");
        final Label addtab = new Label("Insert Products");
        final Label deletetab = new Label("Delete Products");
        final Label searchtab = new Label("Search Products");
        final Label updatetab = new Label("Update Products");

        tabsheet.addTab(addtab, "ADD");
        tabsheet.addTab(deletetab, "DELETE");
        tabsheet.addTab(searchtab, "SEARCH");
        tabsheet.addTab(updatetab, "UPDATE");
        grid.addComponent(lbProductId);
        grid.addComponent(txtProductID);
        grid.addComponent(lbProductName);
        grid.addComponent(txtProductName);
        grid.addComponent(lbProductDescription);
        grid.addComponent(txtProductDescription);
        grid.addComponent(lbProductUnit);
        grid.addComponent(txtProductUnit);
        grid.addComponent(lbProductWeight);
        grid.addComponent(txtProductWeight);
        grid.addComponent(lbProductCost);
        grid.addComponent(txtProductCost);
        grid.addComponent(lbPrior);
        grid.addComponent(txtPrior);
        grid.addComponent(lbCurrent);
        grid.addComponent(txtCurrent);
        absolute.addComponent(saveBtn, "left: 0px; bottom: 0px;");
        absolute.addComponent(deleteBtn, "left: 69px; bottom: 0px;");
        absolute.addComponent(refreshBtn, "left: 150px; bottom: 0px;");
        absolute.addComponent(updateBtn, "left: 235px; bottom: 0px;");
        grid.setSpacing(true);
        tabsheet.setSelectedTab(updatetab);
        absolute.setWidth("400px");
        absolute.setHeight("150px");
        addComponent(tabsheet);
        addComponent(vertical);
        addComponent(grid);
        addComponent(absolute);
        setModal(false);
         getContent().setSizeFull();
        setHeight("900px");
        setWidth("500px");
         final Table table = new Table("ALL Product");
        tabsheet.addListener(new TabSheet.SelectedTabChangeListener() {

            public void selectedTabChange(SelectedTabChangeEvent event) {
                final TabSheet source = (TabSheet) event.getSource();
                if (source == tabsheet) {
                    if (source.getSelectedTab() == addtab) {
                        lbProductId.setVisible(false);
                        txtProductID.setVisible(false);
                        lbProductName.setVisible(true);
                        txtProductName.setVisible(true);
                        lbProductDescription.setVisible(true);
                        txtProductDescription.setVisible(true);
                        lbProductUnit.setVisible(true);
                        txtProductUnit.setVisible(true);
                        lbProductWeight.setVisible(true);
                        txtProductWeight.setVisible(true);
                        lbProductCost.setVisible(true);
                        txtProductCost.setVisible(true);
                        lbPrior.setVisible(true);
                        txtPrior.setVisible(true);
                        lbCurrent.setVisible(true);
                        txtCurrent.setVisible(true);
                        saveBtn.setEnabled(true);
                        deleteBtn.setEnabled(false);
                        refreshBtn.setEnabled(true);
                        updateBtn.setEnabled(false);  
                        grid.setVisible(true);
                        vertical.setVisible(false);
                    }
                    if (source.getSelectedTab() == deletetab) {
                        lbProductId.setVisible(true);
                        txtProductID.setVisible(true);
                        lbProductName.setVisible(false);
                        txtProductName.setVisible(false);
                        lbProductDescription.setVisible(false);
                        txtProductDescription.setVisible(false);
                        lbProductUnit.setVisible(false);
                        txtProductUnit.setVisible(false);
                        lbProductWeight.setVisible(false);
                        txtProductWeight.setVisible(false);
                        lbProductCost.setVisible(false);
                        txtProductCost.setVisible(false);
                        lbPrior.setVisible(false);
                        txtPrior.setVisible(false);
                        lbCurrent.setVisible(false);
                        txtCurrent.setVisible(false);
                        saveBtn.setEnabled(false);
                        deleteBtn.setEnabled(true);
                        refreshBtn.setEnabled(true);
                        updateBtn.setEnabled(false); 
                        grid.setVisible(true);
                        vertical.setVisible(false);
                    }
                    if (source.getSelectedTab() == updatetab) {
                        lbProductId.setVisible(true);
                        txtProductID.setVisible(true);
                        lbProductName.setVisible(true);
                        txtProductName.setVisible(true);
                        lbProductDescription.setVisible(true);
                        txtProductDescription.setVisible(true);
                        lbProductUnit.setVisible(true);
                        txtProductUnit.setVisible(true);
                        lbProductWeight.setVisible(true);
                        txtProductWeight.setVisible(true);
                        lbProductCost.setVisible(true);
                        txtProductCost.setVisible(true);
                        lbPrior.setVisible(true);
                        txtPrior.setVisible(true);
                        lbCurrent.setVisible(true);
                        txtCurrent.setVisible(true);
                        saveBtn.setEnabled(false);
                        deleteBtn.setEnabled(false);
                        refreshBtn.setEnabled(true);
                        updateBtn.setEnabled(true); 
                        grid.setVisible(true);
                        vertical.setVisible(false);
                    }
                    if (source.getSelectedTab() == searchtab) {

                      vertical.addComponent(co);
                        try {

                            ProductManager pro = new ProductManager();
                            ReportManager db = new ReportManager();
                            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(db.driver, db.url + db.dbName, db.userName, db.password, 2, 2);
                             
                            FreeformQuery FreeFormQuery = new FreeformQuery(pro.selectProduct, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Product_Name");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                          
                                            Item item = co.getItem(co.getValue());
                                            String productID = item.getItemProperty("Product_ID").toString();
                                            String productName = item.getItemProperty("Product_Name").toString();
                                            String productDescription = item.getItemProperty("Product_Description").toString();
                                            String productUnit = item.getItemProperty("Product_Unit").toString();
                                            String productWeight = item.getItemProperty("Product_Weight").toString();
                                            String productCost = item.getItemProperty("Product_Cost").toString();
                                            String productPrior = item.getItemProperty("Product_Prior_Year_Sales_Goal").toString();
                                            String productCurrent = item.getItemProperty("Product_Current_Year_Sales_Goal").toString();
                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);
                                           
                                            table.addContainerProperty("Product ID", String.class, null);
                                            table.addContainerProperty("Name", String.class, null);
                                            table.addContainerProperty("Description", String.class, null);
                                            table.addContainerProperty("Unit", String.class, null);
                                            table.addContainerProperty("Weight", String.class, null);
                                            table.addContainerProperty("Cost", String.class, null);
                                            table.addContainerProperty("Prior Year Sale Goal", String.class, null);
                                            table.addContainerProperty("Current Year Sale Goal", String.class, null);
                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(productID), new String(productName), new String(productDescription), new String(productUnit), new String(productWeight), new String(productCost), new String(productPrior),new String(productCurrent)}, new String(productID));
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
                }
            }
        });
         
        saveBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == saveBtn) {
                    ProductManager productManager;
                    try {
                        productManager = new ProductManager();
                        Product product = new Product();
                        product.setProduct_Name(txtProductName.getValue().toString());
                        product.setProduct_Description(txtProductDescription.getValue().toString());
                        product.setProduct_Unit(txtProductUnit.getValue().toString());
                        product.setProduct_Weight(Double.valueOf(txtProductWeight.getValue().toString()));
                        product.setProduct_Cost(Double.valueOf(txtProductCost.getValue().toString()));
                        product.setProduct_Prior_Year_Sale_Goal(txtPrior.getValue().toString());
                        product.setProduct_Current_Year_Sale_Goal(txtCurrent.getValue().toString());
                        productManager.insertNewProduct(product);
                        txtProductName.setValue("");
                        txtProductDescription.setValue("");
                        txtProductUnit.setValue("");
                        txtProductWeight.setValue("");
                        txtProductCost.setValue("");
                        txtPrior.setValue("");
                        txtCurrent.setValue("");
                        getWindow().showNotification(
                                "Your data saved successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification(
                                "ERROR!!! In submitting Data...");
                    }

                }
            }
        });

        deleteBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == deleteBtn) {
                    ProductManager productManager;
                    try {
                        productManager = new ProductManager();
                        Product product = new Product();
                        product.setProduct_ID(Integer.valueOf(txtProductID.getValue().toString()));
                        productManager.deleteNewProduct(product);
                        txtProductID.setValue("");
                        getWindow().showNotification(
                                "Your data deleted successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        getWindow().showNotification(
                                "ERROR!!! In deleting Data...");
                    }

                }
            }
        });

        refreshBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == refreshBtn) {
                    txtProductID.setValue("");
                    txtProductName.setValue("");
                    txtProductDescription.setValue("");
                    txtProductUnit.setValue("");
                    txtProductWeight.setValue("");
                    txtProductCost.setValue("");
                    txtPrior.setValue("");
                    txtCurrent.setValue("");
                    getWindow().showNotification(
                            "Your data refreshed successfully...!");
                }
            }
        });
        updateBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                if (event.getSource() == updateBtn) {
                    ProductManager productManager;
                    try {
                        productManager = new ProductManager();
                        Product product = new Product();
                        product.setProduct_ID(Integer.valueOf(txtProductID.getValue().toString()));
                        product.setProduct_Name(txtProductName.getValue().toString());
                        product.setProduct_Description(txtProductDescription.getValue().toString());
                        product.setProduct_Unit(txtProductUnit.getValue().toString());
                        product.setProduct_Weight(Double.valueOf(txtProductWeight.getValue().toString()));
                        product.setProduct_Cost(Double.valueOf(txtProductCost.getValue().toString()));
                        product.setProduct_Prior_Year_Sale_Goal(txtPrior.getValue().toString());
                        product.setProduct_Current_Year_Sale_Goal(txtCurrent.getValue().toString());
                        productManager.updateNewProduct(product);
                        txtProductID.setValue("");
                        txtProductName.setValue("");
                        txtProductDescription.setValue("");
                        txtProductUnit.setValue("");
                        txtProductWeight.setValue("");
                        txtProductCost.setValue("");
                        txtPrior.setValue("");
                        txtCurrent.setValue("");
                        getWindow().showNotification(
                                "Your data updated successfully...!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
                                Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductInfo.class.getName()).log(
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