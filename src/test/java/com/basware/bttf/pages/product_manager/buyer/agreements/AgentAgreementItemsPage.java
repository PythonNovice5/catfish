package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListDirectoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentAgreementItemsPage extends PriceListDirectoryPage {

   @FindBy(linkText = "Create")
   public WebElement createButton;

   @FindBy(linkText = "Done")
   public WebElement doneButton;

    public AgentAgreementItemsPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/agreementItems/index";
    }

    @Override
   public String getExpectedTitle()
    {
        return "Product Manager: Agreement Price List Items";
    }

    public AgentAgreementCreateItemPage clickOnCreateButton()
    {
       waitUntillElementIsClickableAndClick(createButton);
       return new AgentAgreementCreateItemPage();
    }

    public ManageAgreementPage clickOnDoneButton()
    {
        waitUntillElementIsClickableAndClick(doneButton);
        return new ManageAgreementPage();
    }
}
