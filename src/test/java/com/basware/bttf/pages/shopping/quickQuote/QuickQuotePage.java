package com.basware.bttf.pages.shopping.quickQuote;

import com.basware.bttf.pages.shopping.SelectSupplierForQuickQuotePage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickQuotePage extends ShoppingPage {


    @Override
    public String getExpectedUrl() {

        return getBaseUrl() + "/rfq/rfq/dashboard";
    }

    public QuickQuotePage()
    {
        PageFactory.initElements( driver , this );
    }

    @FindBy(id="iconClass__OPEN")
    public WebElement sentButton;

    @Override
    public String getExpectedTitle() {
        return "Quick Quote Dashboard";
    }

    public CreateRfqPage clickCreateNewRfqButton(){
        WebElement creatNewButton = driver.findElement(By.id("itemTitle_NEW"));
        waitUntillElementIsClickableAndClick(creatNewButton);
        return new CreateRfqPage();
    }

    public RfqDirectoryPage clickOnDraft(){
        WebElement draftButton = driver.findElement(By.id("iconClass__DRAFT"));
        draftButton.click();
        return new RfqDirectoryPage();

    }

    public RfqDirectoryPage clickOnSent(){
        waitUntillElementIsClickableAndClick(sentButton);
        return new RfqDirectoryPage();
    }

    public RfqDirectoryPage clickOnAwardRfqs(){
        WebElement awardRfqsButton = driver.findElement(By.id("itemTitle_READY"));
        awardRfqsButton.click();
        return new RfqDirectoryPage();
    }

    public RfqDirectoryPage clickOnCheckOut(){
        WebElement checkOut = driver.findElement(By.id("iconClass__AWARDED"));
        checkOut.click();
        return new RfqDirectoryPage();
    }


}
