package com.basware.bttf.pages.shopping;
// Created by Julian Sheppard on 21/04/2017

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.freetextrequisitions.FreeTextRequisitionsManagementPage;
import com.basware.bttf.pages.shopping.notifications.ShoppingNotificationsPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import com.basware.bttf.pages.shopping.quickQuote.QuickQuotePage;
import com.basware.bttf.pages.shopping.requestforquotation.RFQManagementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public abstract class ShoppingPage extends ProductManagerPage
{
    // Submenu items
    @FindBy( name="SHOPPING_NOTIFICATIONS")
    public WebElement submenuNotifications;

    @FindBy( id="SHOPPING_MARKETPLACE")
    public WebElement submenuMarketplace;

    @FindBy( name="SHOPPING_RFQ")
    public WebElement submenuRequestForQuotation;

    @FindBy( id="SHOPPING_FTR")
    public WebElement submenuFreeTextRequisitions;

    @FindBy(id = "SHOPPING_RFQ2")
    public WebElement submenuQuickQuote;

    @FindBy(id="keywords")
    private WebElement searchKeywords;

    @FindBy(name="btn-search")
    private  WebElement searchButton;

    //span[text()='Request for Quotation']
//    @FindBy(xpath = "//span[text()='Request for Quotation']")
    @FindBy(id="SHOPPING_RFQ")
    public WebElement requestForQuotation;

    public ShoppingNotificationsPage clickSubMenuNotifications()
    {
        submenuNotifications.click();
        return new ShoppingNotificationsPage();
    }

    public RFQManagementPage clickSubMenuRequestForQuotation(){
        requestForQuotation.click();
        return new RFQManagementPage();
    }

    public MarketplaceLandingPage clickSubMenuMarketplace()
    {
        waitUntillElementIsClickableAndClick(submenuMarketplace);
        return new MarketplaceLandingPage();
    }

    public QuickQuotePage clickSubMenuQuickQuotation()
    {
        waitUntillElementIsClickableAndClick(submenuQuickQuote);
        return new QuickQuotePage();
    }

    public FreeTextRequisitionsManagementPage clickSubMenuFreeTextRequisitions()
    {
        submenuFreeTextRequisitions.click();
        return new FreeTextRequisitionsManagementPage();
    }

    public void searchSupplier(String supplierOrg)
    {
        searchKeywords.sendKeys(supplierOrg);
        searchButton.click();
    }

    // Functionality to add days to the current date and return the date
    protected String addDaysTocurrentDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        return sdf.format(c.getTime());
    }

    // Functionality to find time passed based to the current hour
    protected String currentHour() {
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(currentTime);
        if (time.startsWith("0")){
            return time.substring(1, 2);
        }
        return time.substring(0, 2);
    }

}
