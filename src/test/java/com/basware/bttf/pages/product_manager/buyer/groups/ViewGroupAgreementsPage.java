package com.basware.bttf.pages.product_manager.buyer.groups;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class ViewGroupAgreementsPage extends ProductManagerPage {

    @FindBy(id = "resultsShown_1")
    private WebElement resultsOnPage;

    public ViewGroupAgreementsPage()
    {
        PageFactory.initElements(driver,this);
    }
    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/products/viewGroupAgreements/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: View Group Agreements";
    }

    public void verifyAgreementNumber() throws Exception
    {
        driver.navigate().refresh();
        assertEquals("1-1 / 1",getTextOfWebElement(resultsOnPage));

    }
}
