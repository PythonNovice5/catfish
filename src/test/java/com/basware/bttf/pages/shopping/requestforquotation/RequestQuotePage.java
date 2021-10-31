package com.basware.bttf.pages.shopping.requestforquotation;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestQuotePage extends ShoppingPage {
    public RequestQuotePage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/shopping/rfqEdit/edit/";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ: Request a Quote";
    }

    @FindBy(id="description")
    public WebElement YourReferenceQuote;

    @FindBy(id="targetDeliveryDate")
    public WebElement QuoteTargetDeliveryDate;

    @FindBy(id="expiryDate")
    public WebElement QuoteExpirationDate;

    @FindBy(id="expiryTime")
    public WebElement QuoteExpirationTime;

    @FindBy(id="specialInstructions")
    public WebElement QuoteSpeicalInstructions;

    @FindBy(xpath="//input[@value='Add line item']")
    public WebElement AddLineItem;

    @FindBy(xpath="//input[@value='Add supplier']")
    public WebElement AddSupplier;

    @FindBy(xpath="//input[@value='Publish']")
    public WebElement PublishButton;

    @FindBy(id="lvp")
    public WebElement lvpCheckBox;

    public ShoppingPage clickButton(String btn){
        switch(btn){
            case "Add line item":
                AddLineItem.click();
                return new LineItemsPage();
            case "Add supplier":
                AddSupplier.click();
                return new RFQSuppliersPage();
            case "Publish":
                scrollToElement(PublishButton);
                waitUntillElementIsClickableAndClick(PublishButton);
                return new ManageRequestForQuotePage();
            case "lvp checkbox":
                scrollToElement(lvpCheckBox);
                waitUntillElementIsClickableAndClick(lvpCheckBox);
                return new RequestQuotePage();
        }
        return null;
    }

}
