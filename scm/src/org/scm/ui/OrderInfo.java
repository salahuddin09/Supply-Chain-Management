package org.scm.ui;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.scm.bl.OrderManager;
import org.scm.model.Order;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.scm.bl.ReportManager;

public class OrderInfo extends Window{
	
	public OrderInfo() {
		scsproduct();
	}
	public void scsproduct() {
		
		setCaption("Orders Information");
		//center();
		
		final TabSheet tabsheet = new TabSheet();		
		final AbsoluteLayout abslout1 = new AbsoluteLayout();
		final GridLayout grid1 = new GridLayout(2, 7);
                final VerticalLayout vertical = new VerticalLayout();
		final Label lbordernumber = new Label("Order Number");
		final Label lbplacementdate = new Label("Placement Date");
		final Label lbproductid = new Label("Product ID");
                final Label lbproductquantity = new Label("Product Quantity");
		final Label lbsupplierid = new Label("Supplier ID");
                final Label lbretailerid = new Label("Retailer ID");
		final Label lborderstatus = new Label("Order Status");
		final TextField txtordernumber= new TextField();
		final TextField txtplacementdate = new TextField();
		final TextField txtproductid = new TextField();
                final TextField txtproductquantity = new TextField();
		final TextField txtsupplierid = new TextField();
                final TextField txtretailerid= new TextField();
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
		grid1.addComponent(lbordernumber);
		grid1.addComponent(txtordernumber);
		grid1.addComponent(lbplacementdate);
		grid1.addComponent(txtplacementdate);
		grid1.addComponent(lbproductid);
		grid1.addComponent(txtproductid);
                grid1.addComponent(lbproductquantity);
		grid1.addComponent(txtproductquantity);
		grid1.addComponent(lbsupplierid);
		grid1.addComponent(txtsupplierid);
                grid1.addComponent(lbretailerid);
		grid1.addComponent(txtretailerid);
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
                setWidth("500px");
                setHeight("900px");
                addComponent(tabsheet);
                 addComponent(vertical);
		addComponent(grid1);
		addComponent(abslout1);
                 final Table table = new Table("ALL Order");
		tabsheet.addListener(new TabSheet.SelectedTabChangeListener() {

			public void selectedTabChange(SelectedTabChangeEvent event) {
				final TabSheet source = (TabSheet) event.getSource();
				if (source == tabsheet) {
					if (source.getSelectedTab() == addtab) {
						lbordernumber.setVisible(false);
						txtordernumber.setVisible(false);
						lbplacementdate.setVisible(true);
						txtplacementdate.setVisible(true);
						lbproductid.setVisible(true);
						txtproductid.setVisible(true);
                                                lbproductquantity.setVisible(true);
						txtproductquantity.setVisible(true);
						lbsupplierid.setVisible(true);
						txtsupplierid.setVisible(true);
                                                lbretailerid.setVisible(true);
						txtretailerid.setVisible(true);
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
						lbordernumber.setVisible(true);
						txtordernumber.setVisible(true);
						lbplacementdate.setVisible(false);
						txtplacementdate.setVisible(false);
						lbproductid.setVisible(false);
						txtproductid.setVisible(false);
                                                lbproductquantity.setVisible(false);
						txtproductquantity.setVisible(false);
						lbsupplierid.setVisible(false);
						txtsupplierid.setVisible(false);
                                                lbretailerid.setVisible(false);
						txtretailerid.setVisible(false);
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
						lbordernumber.setVisible(true);
						txtordernumber.setVisible(true);
						lbplacementdate.setVisible(true);
						txtplacementdate.setVisible(true);
						lbproductid.setVisible(true);
						txtproductid.setVisible(true);
                                                lbproductquantity.setVisible(true);
						txtproductquantity.setVisible(true);
						lbsupplierid.setVisible(true);
						txtsupplierid.setVisible(true);
                                                lbretailerid.setVisible(true);
						txtretailerid.setVisible(true);
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

                            OrderManager order = new OrderManager();
                            ReportManager db = new ReportManager();
                            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(db.driver, db.url + db.dbName, db.userName, db.password, 2, 2);
                           
                            FreeformQuery FreeFormQuery = new FreeformQuery(order.selectOrder, connectionPool);
                            SQLContainer container = new SQLContainer(FreeFormQuery);
                            co.setContainerDataSource(container);
                            co.setItemCaptionPropertyId("Order_Number");
                            co.setNullSelectionAllowed(false);
                            co.setImmediate(true);

                            co.addListener(
                                    new Property.ValueChangeListener() {

                                        public void valueChange(ValueChangeEvent event) {
                                            Item item = co.getItem(co.getValue());
                                            String orderNumber = item.getItemProperty("Order_Number").toString();
                                            String placementDate = item.getItemProperty("Order_Placement_Date").toString();
                                            String productID = item.getItemProperty("Product_ID").toString();
                                             String productQuantity = item.getItemProperty("Product_Quantity").toString();
                                            String supplierID= item.getItemProperty("Supplier_ID").toString();
                                            String retailerID = item.getItemProperty("Retailer_ID").toString();
                                             String orderStatus = item.getItemProperty("Order_Status").toString();
                                            table.setStyleName("iso3166");
                                            table.setPageLength(6);
                                            table.setSizeFull();
                                            table.setSelectable(true);
                                            table.setMultiSelect(false);
                                            table.setImmediate(true);
                                            table.setColumnReorderingAllowed(true);
                                            table.setColumnCollapsingAllowed(true);

                                            table.addContainerProperty("Order Number", String.class, null);
                                            table.addContainerProperty("Order Placement Date", String.class, null);
                                            table.addContainerProperty("Product ID", String.class, null);
                                            table.addContainerProperty("Product Quantity", String.class, null);
                                            table.addContainerProperty("Supplier ID", String.class, null);
                                            table.addContainerProperty("Retailer ID", String.class, null);
                                            table.addContainerProperty("Order Status", String.class, null);

                                            /* Add a few items in the table. */
                                            table.addItem(new Object[]{new String(orderNumber), new String(placementDate), new String(productID), new String(productQuantity), new String(supplierID), new String(retailerID), new String(orderStatus)}, new String(orderNumber));
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
				}
			}
		});
		savebtn.addListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				if (event.getSource() == savebtn) {
					OrderManager orderManager;
					try {
						orderManager = new OrderManager();
						Order order = new Order();
						SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				
						Date date1 = null;
			            date1 = sdf1.parse(txtplacementdate.getValue().toString());
			                        order.setOrder_Placement_Date(date1);
                       			        order.setProduct_ID(Integer.valueOf((txtproductid.getValue().toString())));
                                                order.setProduct_Quantity(Integer.valueOf((txtproductquantity.getValue().toString())));
						order.setSupplier_ID(Integer.valueOf(txtsupplierid.getValue().toString()));
                                                order.setRetailer_ID(Integer.valueOf((txtretailerid.getValue().toString())));
						order.setOrder_Status(txtorderstatus.getValue().toString());
						orderManager.insertNewOrder(order);
						txtplacementdate.setValue("");
						txtproductid.setValue("");
                                                txtproductquantity.setValue("");
						txtretailerid.setValue("");
						txtsupplierid.setValue("");
						txtorderstatus.setValue("");
						getWindow().showNotification(
								"Your data saved successfully...!");
					} catch (ClassNotFoundException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
								Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
								Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
								Level.SEVERE, null, ex);
					} catch (SQLException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
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
					OrderManager orderManager;
					try {
						orderManager = new OrderManager();
						Order order = new Order();
						order.setOrder_Number(Integer.valueOf(txtordernumber.getValue().toString()));
						orderManager.deleteNewOrder(order);
						txtordernumber.setValue("");
					getWindow().showNotification("Your data deleted successfully...!");
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(OrderInfo.class.getName()).log(
							Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
					Logger.getLogger(OrderInfo.class.getName()).log(
							Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(OrderInfo.class.getName()).log(
							Level.SEVERE, null, ex);
				} catch (SQLException ex) {
					Logger.getLogger(OrderInfo.class.getName()).log(
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
					txtordernumber.setValue("");
					txtplacementdate.setValue("");
					txtproductid.setValue("");
                                        txtproductquantity.setValue("");
					txtretailerid.setValue("");
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
					OrderManager orderManager;
					try {
						orderManager = new OrderManager();
						Order order = new Order();
						
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
						Date date1 = null;
			            date1 = (Date)sdf1.parse(txtplacementdate.getValue().toString());
			            
                                                order.setOrder_Number(Integer.valueOf(txtordernumber.getValue().toString()));
                                                order.setOrder_Placement_Date(date1);
                                                order.setProduct_ID(Integer.valueOf((txtproductid.getValue().toString())));
                                                order.setProduct_Quantity(Integer.valueOf((txtproductquantity.getValue().toString())));
						order.setSupplier_ID(Integer.valueOf(txtsupplierid.getValue().toString()));
                                                order.setRetailer_ID(Integer.valueOf((txtretailerid.getValue().toString())));
						order.setOrder_Status(txtorderstatus.getValue().toString());
						orderManager.updateNewOrder(order);
						txtordernumber.setValue("");
						txtplacementdate.setValue("");
						txtproductid.setValue("");
                                                txtproductquantity.setValue("");
						txtretailerid.setValue("");
						txtsupplierid.setValue("");
						txtorderstatus.setValue("");
						getWindow().showNotification(
								"Your data updated successfully...!");
					} catch (ClassNotFoundException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
								Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
								Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
								Level.SEVERE, null, ex);
					} catch (SQLException ex) {
						Logger.getLogger(OrderInfo.class.getName()).log(
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