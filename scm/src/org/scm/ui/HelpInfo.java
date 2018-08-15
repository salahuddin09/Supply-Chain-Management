/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

/**
 *
 * @author ASUS
 */
public class HelpInfo extends Window{
    public HelpInfo() {

        scshelp();

    }

    public void scshelp() {

        setCaption("Help Information");
        center();
        getContent().setSizeFull();
        setHeight("1500px");
        setWidth("830px");
        Panel panel = new Panel("User Manual");
                panel.setWidth("800px");
                 panel.setHeight("800px");
 panel.addComponent(new Label("Only three type of user can access"
                         + "the information of Supply Chain System."
                         +"They are 'ADMIN','RETAILER','PURCHASE "
                         + "MANAGER'.'ADMIN' can access all info "
                         + "for monitoring whole system."));
 panel.addComponent(new Label("'RETAILER' can access retailer menu for"
                         + "controlling retailer information. Also"
                         + "acccess product menu for controlling "
                         + "product data. And access Sales menu for"
                         +"checking total product sales and total"
                         + " count of orders."));
 panel.addComponent(new Label( "'PURCHASE_MANAGER' can access supplier"
                         +  "menu for controlling supplier data. "
                         + " Also access Supplier Information menu"
                         + "for controlling order and delivery "
                         + "information."));
 panel.addComponent(new Label( "EVERY USER can able to generate pdf" 
                         +"report.It has auto stock checking system"
                         +"which checks the stock every one hour.If"
                         +"any product finish,it's order information"
                         +"sended to Supplier's Email.Then Supplier"
                         +"have delivered finished product to the "
                         +"retailer."));
                 addComponent(panel);
    }
}
