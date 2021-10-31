package com.basware.bttf.pages.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class ViewQuotePage extends QuotesDirectoryPage {

    @FindBy(id = "editLines[0].quantity")
    public WebElement QuoteQuantity;

    @FindBy(css = "[name='alertMessageDetail']")
    public WebElement SuccessMsg;

    @FindBy(id="editLines[0].unitOfMeasureauto")
    public WebElement UnitOfQuantity;

    @FindBy(id="editLines[0].price")
    public WebElement UnitPrice;

    @FindBy(id="showQuoteAction")
    public WebElement quoteButton;

    @FindBy(css="[name='createLineAction']")
    public WebElement addProductDetailsPlus;

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/quote/view";
    }

    @Override
    public String getExpectedTitle() {
        return "View RFQ";
    }

    public ViewQuotePage(){
        PageFactory.initElements(driver,this);
    }

    public void clickQuote(){
        waitUntilDisplayed(quoteButton);
        quoteButton.click();
    }

    public void clickWatch(){
        WebElement watchButton = driver.findElement(By.id("watchAction"));
        watchButton.click();
    }

    public void clickClose(){
        WebElement closeButton = driver.findElement(By.id("Close"));
        closeButton.click();
    }

    public void clickSend(){
        pauseFor(3000);
        WebElement sendButton = driver.findElement(By.id("sendAction"));
        sendButton.click();
        pauseFor(2000);
    }

    public void clickAdd(){
        WebElement addButton = driver.findElement(By.id("addLineAction"));
        addButton.click();
    }

    public void clickOnThis(String elemName) throws Exception{

        waitUntillElementIsClickableAndClick( getWebElementNamed(elemName));

    }

    public void selectDeliverCost(String value){
        WebElement deliveryCost = driver.findElement(By.id("deliveryIncluded"));
        deliveryCost.click();
        new Select(deliveryCost).selectByVisibleText(value);
    }

     public void enterQuoteQuantity(String value){
        waitUntilDisplayed(QuoteQuantity);
        QuoteQuantity.sendKeys(value);
    }

    public void enterOrderUnit(String value){
        waitUntilDisplayed(UnitOfQuantity);
        UnitOfQuantity.sendKeys(value);
    }

    public void enterUnitPrice(String value) throws Exception {
        waitUntilDisplayed(UnitPrice);
        UnitPrice.sendKeys(value);
        enterValueIntoElement(value,"UnitPrice");
    }

    public void validateMessage() throws Exception{
        pauseFor(1000);
        waitUntilDisplayed(SuccessMsg);
        assertEquals("Your quote has been sent.",getTextOfWebElement(SuccessMsg));
    }
}
