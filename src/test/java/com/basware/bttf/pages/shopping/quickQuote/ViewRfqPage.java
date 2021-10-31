package com.basware.bttf.pages.shopping.quickQuote;

import com.basware.bttf.pages.quotes.ViewQuotePage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import javax.swing.text.View;

public class ViewRfqPage extends ShoppingPage {
    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/rfq/view/";
    }

    @Override
    public String getExpectedTitle() {
        return "View RFQ";
    }

    @FindBy(name="awardAction")
    private WebElement awardButton;

    @FindBy(name="alertMessageDetail")
    public WebElement alertSuccessMsg;

    @FindBy(name = "addToBasketAction")
    public WebElement addBtn;


    public ViewRfqPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickAward(){
        waitUntilDisplayed(awardButton);
        awardButton.click();
    }

    public void awardRfq(){
        pauseFor(3000);
        WebElement awardButtonInPopUp = driver.findElement(By.id("modalConfirmOk"));
        awardButtonInPopUp.click();
    }

    public void successfulMessage() throws Exception{
          pauseFor(1000);
//        WebElement awardMesssage = driver.findElement(By.name("alertMessageDetail"));
        Assert.assertEquals("The RFQ has been awarded. Please check out.",getTextOfWebElement(alertSuccessMsg));
    }

    public void addRfqItem(){
//        WebElement addButton = driver.findElement(By.name("addToBasketAction"));
        waitUntillElementIsClickableAndClick(addBtn);
        pauseFor(3000);
    }

    public void confirmAddItem(){
        WebElement addBasketButton = driver.findElement(By.id("modalConfirmOk"));
        addBasketButton.click();
        pauseFor(3000);
    }


    public void clickClose(){
        WebElement closeAlert = driver.findElement(By.name("closeAlertButton"));
        closeAlert.click();
    }

}
