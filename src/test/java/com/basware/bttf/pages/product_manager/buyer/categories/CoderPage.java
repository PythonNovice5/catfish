package com.basware.bttf.pages.product_manager.buyer.categories;

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.product_manager.ProductManagerDashboardPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoderPage extends ProductManagerDashboardPage {

    protected static Logger LOGGER = Logger.getLogger(LoggedInPage.class.getName());

    @FindBy( xpath="//input[@value='Save']")
    public WebElement Save;

    @FindBy(xpath="//form[@name='buyerClassifiationForm']//div//input[@name='ranges[0].from']")
    public WebElement From;

    @FindBy(xpath="//form[@name='buyerClassifiationForm']//div//input[@name='ranges[0].to']")
    public WebElement To;

    @FindBy(xpath="//form[@name='buyerClassifiationForm']//div//input[@name='ranges[0].code']")
    public WebElement Code;

    @FindBy(xpath="//form[@name='buyerClassifiationForm']//div//textarea[@name='ranges[0].description']")
    public WebElement Description;

    public CoderPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String getExpectedTitle() {
        return "Coder";
    }

    public String getExpectedUrl() {
        return getBaseUrl() + "/products/buyerCoder/manage";
    }

    public CoderPage clearCoderData() throws Exception
        {
            clearAllData();
            return new CoderPage();
        }

    // Clears and sets the text or value of the element
    public void enterValueIntoElement( String value, String elementName ) throws Exception
    {
        setValueOfWebElement(getWebElementNamed(elementName), value );
    }

    public void clickSave(String element) throws Exception
    {
        getWebElementNamed(element).click();
    }

    public String getValue(String element) throws Exception
    {
        String value = getWebElementNamed(element).getAttribute("value");
        return value;

    }

}
