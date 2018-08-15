package org.scm.ui;

import com.lowagie.text.DocumentException;
import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Window;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import org.scm.bl.StckThresholdManager;
import org.scm.utilities.SendMail;

public class MainWindow extends Application {

    @Override
    public void init() {
        StckThresholdManager stckThresholdManager = null;
        try {
            stckThresholdManager = new StckThresholdManager();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread stckThresholdMangerThrd = new Thread(stckThresholdManager);
          stckThresholdMangerThrd.start();
         System.out.println("Running Ok............");
        System.out.println("Currently SCS running in Thread OFF MODE.");
        final VerticalLayout mainlayout = new VerticalLayout();
        final VerticalLayout loginlayout = new VerticalLayout();
        mainlayout.setVisible(false);
        loginlayout.setVisible(true);

        final LoginForm loginForm = new LoginForm();


        loginlayout.setHeight("500px");
        loginlayout.setWidth("500px");



        final Window mainWindow = new Window("Supply Chain Management");



        final MenuBar menuBar = new MenuBar();

        final MenuBar.MenuItem retailer = menuBar.addItem("RETAILERS", null, null);
        final MenuBar.MenuItem product = menuBar.addItem("PRODUCT", null, null);
        final MenuBar.MenuItem sales = menuBar.addItem("SALES", null, null);
        final MenuBar.MenuItem stocks = menuBar.addItem("STOCKS", null, null);
        final MenuBar.MenuItem suppliers = menuBar.addItem("SUPPLIERS", null, null);
        final MenuBar.MenuItem supplyinfo = menuBar.addItem("SUPPLY INFORMATION", null, null);
        MenuBar.MenuItem orderdetails =
                supplyinfo.addItem("ORDER DETAILS", null, null);
        MenuBar.MenuItem deliverydetails =
                supplyinfo.addItem("DELIVERY DETAILS", null, null);
        MenuBar.MenuItem productlinedetails =
                supplyinfo.addItem("PRODUCTLINE DETAILS", null, null);
        final MenuBar.MenuItem reports = menuBar.addItem("REPORTS", null, null);
       // MenuBar.MenuItem report =  reports.addItem("PRINT", null, null);
        menuBar.setVisible(true);
        retailer.addItem("Retailers information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                RetailerInfo retailerinfo = new RetailerInfo();
                mainWindow.addWindow(retailerinfo);
            }
        });

        product.addItem("Products Information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                ProductInfo productinfo = new ProductInfo();
                mainWindow.addWindow(productinfo);
            }
        });

        sales.addItem("Sales information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                SalesInfo salesInfo = new SalesInfo();
                mainWindow.addWindow(salesInfo);
            }
        });

        stocks.addItem("Store Information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                StoreInfo storeinfo = new StoreInfo();
                mainWindow.addWindow(storeinfo);
            }
        });

        suppliers.addItem("Suppliers Information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                SupplierInfo supplierinfo = new SupplierInfo();
                mainWindow.addWindow(supplierinfo);
            }
        });

        orderdetails.addItem("Orders Information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                OrderInfo orderinfo = new OrderInfo();
                mainWindow.addWindow(orderinfo);
            }
        });

        deliverydetails.addItem("Delivery Information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                DeliveryInfo deliveryInfo = new DeliveryInfo();
                mainWindow.addWindow(deliveryInfo);
            }
        });
        productlinedetails.addItem("Productline Information", new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                ProductLineInfo productlineInfo = new ProductLineInfo();
                mainWindow.addWindow(productlineInfo);
            }
        });
       reports.addItem("STORE REPORTS", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                try {
                    StoreReport re = new StoreReport();
                    SendMail.sendMessage();
                    re.scsreport();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        reports.addItem("PRODUCT REPORTS", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                try {
                    ProductReport re = new ProductReport();
                    re.scsreport();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       reports.addItem("ORDER REPORTS", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                try {
                    OrderReport re = new OrderReport();
                    re.scsreport();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        reports.addItem("DELIVERY REPORTS", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                try {
                    DeliveryReport re = new DeliveryReport();
                    re.scsreport();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        reports.addItem("SUPPLIER REPORTS", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                try {
                    SupplierReport re = new SupplierReport();
                    re.scsreport();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        reports.addItem("RETAILER REPORTS", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                try {
                    RetailerReport re = new RetailerReport();
                    re.scsreport();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        final MenuBar.MenuItem logout = menuBar.addItem("LOG OUT", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {

                getMainWindow().getApplication().close();
              //  setLogoutURL("/scm/logout.html");
            }
        });
        final MenuBar.MenuItem help = menuBar.addItem("HELP", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
                HelpInfo help = new HelpInfo();
                mainWindow.addWindow(help);
            }
        });
        final MenuBar.MenuItem about = menuBar.addItem("ABOUT", null, new Command() {

            public void menuSelected(MenuBar.MenuItem selectedItem) {
            }
        });



        loginForm.addListener(new LoginListener() {

            public void onLogin(LoginEvent event) {

                Object adminName = "admin";
                Object adminPassword = "12345";
                Object retailerName = "retailer";
                Object retailerPassword = "12345";
                Object purchaseName = "purchasemanager";
                Object purchasePassword = "12345";
                Object userName = event.getLoginParameter("username");
                Object password = event.getLoginParameter("password");


                if (adminName.equals(userName) && adminPassword.equals(password)) {

                    //showNotification("You are logged in");

                    loginlayout.setVisible(false);
                    mainlayout.setVisible(true);
                } else if (retailerName.equals(userName) && retailerPassword.equals(password)) {
                    loginlayout.setVisible(false);
                    mainlayout.setVisible(true);
                    retailer.setEnabled(true);
                    product.setEnabled(true);
                    sales.setEnabled(true);
                    stocks.setEnabled(true);
                    suppliers.setEnabled(false);
                    supplyinfo.setEnabled(false);
                    reports.setEnabled(false);
                    logout.setEnabled(true);
                } else if (purchaseName.equals(userName) && purchasePassword.equals(password)) {
                    loginlayout.setVisible(false);
                    mainlayout.setVisible(true);
                    retailer.setEnabled(false);
                    product.setEnabled(false);
                    sales.setEnabled(false);
                    stocks.setEnabled(false);
                    suppliers.setEnabled(true);
                    supplyinfo.setEnabled(true);
                     reports.setEnabled(false);
                    logout.setEnabled(true);


                } else {
                    loginlayout.setVisible(true);
                    mainlayout.setVisible(false);
                    //showNotification("Logging failed");  
                }
            }
        });
        setTheme("mythemes");
        // mainWindow.setTheme("reindeer");//default
        //mainWindow.setTheme("runo");//new
        //mainWindow.setStyleName("");

        Embedded theImage = new Embedded("", new ThemeResource("colorview01.gif"));
        theImage.setType(Embedded.TYPE_IMAGE);
        Label lbTitle = new Label("Supply Chain Management");
        Label lbTitleDescription = new Label("For Non Stop Supply Activities of Retail Store");
        lbTitleDescription.setStyleName("mystyle1");
        Label gap = new Label();
        Label gap2 = new Label();
        gap.setHeight("1em");
        lbTitle.setStyleName("mystyle");
        mainWindow.addComponent(lbTitle);
        gap2.setHeight("1em");
       // mainWindow.addComponent(gap2);
        mainWindow.addComponent(lbTitleDescription);
        mainWindow.addComponent(gap);
        mainlayout.addComponent(menuBar);
        loginlayout.addComponent(loginForm);
        mainlayout.addComponent(theImage);
        mainWindow.setStyleName("styles.css");
        mainWindow.addComponent(mainlayout);
        mainWindow.addComponent(loginlayout);
        mainWindow.getContent().setSizeFull();
        setMainWindow(mainWindow);
    }
}
