package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentAgreementEditItemPage extends ProductManagerPage {

    @FindBy(name = "backLink")
    private WebElement backToPricelist;

    @FindBy(xpath = "//*[@id='page-content-container']/div/div[1]/div")
    private WebElement verifySuccessMessage;

    @Override
    public String getExpectedUrl() {
        return "/products/agreementItems/edit";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Edit Item";
    }

    public AgentAgreementEditItemPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void verifySuccessAlert()
    {
      verifySuccessMessage.isDisplayed();
    }

    public AgreementPricelistItemPage navigateBackToPricelistItems()
    {
        waitUntillElementIsClickableAndClick(backToPricelist);
        return new AgreementPricelistItemPage();
    }

}
