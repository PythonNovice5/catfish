package com.basware.bttf.pages.por;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class ViewPriceOnRequestPage extends ShoppingPage {

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/por/view";
    }

    @Override
    public String getExpectedTitle() {
        return "View price on request";
    }

    public ViewPriceOnRequestPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy( name="withdrawAction" )
    public WebElement Withdraw;

    @FindBy( id="modalConfirmOk" )
    public WebElement ConfirmWithdraw;

    @FindBy( xpath="//a[normalize-space(text())='Back to My quotes']")
    public WebElement BacktoMyquotes;

    @FindBy( name="awardAction" )
    public WebElement AcceptQuote;

    @FindBy( id="modalConfirmOk" )
    public WebElement ConfirmAccept;

    public ProductManagerPage clickButton(String btn) throws Exception{
        switch (btn){
            case "Withdraw":
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
                break;
            case "ConfirmWithdraw":
                btn = "ConfirmWithdraw";
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
                break;
            case "BacktoMyquotes":
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
                return new MyQuotesPage();
            case "AcceptQuote":
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
//                pauseFor(2000);
                waitUntillElementIsClickableAndClick(ConfirmAccept);
        }

        return new ViewPriceOnRequestPage();
    }

    public void verifyAlertMessage(String alert) throws Exception{
//        pauseFor(10000);
        verifyMessage(alert);
    }
}
