package com.basware.bttf.pages.shopping.freetextrequisitions;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeTextRequisitionsManagementPage extends ShoppingPage {

    @FindBy(linkText = "Raise a Free Text Requisition")
    private WebElement raiseFreeTextRequisition;

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/shopping/ftrManagement";
    }

    @Override
    public String getExpectedTitle() {
        return "FTR: My FTRs";
    }
    public FreeTextRequisitionsManagementPage()
    {
        PageFactory.initElements(driver,this);
    }

    public FTREditPage clickOnRaiseFreeTextRequisition()
    {
        raiseFreeTextRequisition.click();
        return new FTREditPage();
    }
}
