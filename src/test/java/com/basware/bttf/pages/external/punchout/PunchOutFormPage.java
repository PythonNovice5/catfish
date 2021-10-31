package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PunchOutFormPage extends ExternalPage {
    public PunchOutFormPage()
    {
        PageFactory.initElements( driver , this );
    }
    @FindBy(xpath = "//input[@name='useAngular' and @value='true']")
    public WebElement Angular;

    @FindBy(id = "GRAILS")
    public WebElement Grails;

    @FindBy(id="submit")
    public WebElement SubmitBtn;

    @FindBy(name = "viewNames")
    public WebElement ViewName;

    @FindBy(name ="buyerUserId")
    public WebElement buyerUserID;

    @FindBy(name="sharedSecret")
    public WebElement sharedSecret;

    @FindBy(name="buyerOrgShortName")
    public WebElement OrgID;

    @FindBy(name = "punchInAction")
    public WebElement actionField;

    @FindBy(name = "punchInSearchTerms")
    public WebElement punchInSearchTerms;

    @FindBy(id="overrideMenuData")
    public WebElement overrideMenuDataCheckBox;

    @FindBy(id = "overrideSuborgData")
    public WebElement overrideMenuSubOrgData;

    @FindBy(id = "punchInSubOrgData")
    public  WebElement punchInSubOrgData;

    @Override
    public String getExpectedUrl() {
        return "https://jupiter-buyers.procserveonline.com/punchout-test-tool";
    }

    @Override
    public String getExpectedTitle() {
        return "Punchout Test Tool";
    }

    public PunchOutFormPage selectFrameworkValue(String valueOfFramework) {
        waitUntillElementIsClickableAndClick(Angular);
        return new PunchOutFormPage();
    }

    public ProductManagerPage clickButton(String btn){
        switch(btn){
            case "Submit":
                waitUntillElementIsClickableAndClick(SubmitBtn);
                break;
            case "SubmitForEDITAction":
                waitUntillElementIsClickableAndClick(SubmitBtn);
                return new ShoppingBasketPage();
            case "SubmitForSearchItem":
                waitUntillElementIsClickableAndClick(SubmitBtn);
                return new MarketplaceSearchResultsPage();

        }
        return new MarketplaceLandingPage();
    }

    public PunchOutFormPage enterInto(String value, String elem) throws Exception{

        switch(elem){
            case "Actions":
                enterValueIntoElement(value,"actionField");
                return new PunchOutFormPage();
            case "SearchTerms":
                enterValueIntoElement(value,"punchInSearchTerms");
                return new PunchOutFormPage();
        }
        waitUntilDisplayed(ViewName);
        ViewName.sendKeys(value);
        return new PunchOutFormPage();
    }

    public PunchOutFormPage store_view_details() throws Exception{
        waitUntilDisplayed(ViewName);
        props.set("BuyerUserID",getAttributeValueOfWebElement(buyerUserID,"value"));
        props.set("SharedSecret",getAttributeValueOfWebElement(sharedSecret,"value"));
        props.set("OrgID",getAttributeValueOfWebElement(OrgID,"value"));
        return new PunchOutFormPage();
    }

    public void overRideOciFields()
    {
        waitUntillElementIsClickableAndClick(overrideMenuDataCheckBox);
        waitUntillElementIsClickableAndClick(overrideMenuSubOrgData);
    }

    public void overRideSubOrgData() throws Exception
    {
        waitUntillElementIsClickableAndClick(overrideMenuSubOrgData);
        enterValueIntoElement("[ { \"Name\": \"test - en\", \"OrgId\": \"PROC-en\", \"SiteId\": \"site1\", \"Language\": \"FI,EN,DA\", \"ClassViewName\": \"POTT view\", \"CurrentOrg\": true,\"OrganizationCode\":\"BW01\"}, { \"Name\": \"test - fi\", \"OrgId\": \"PROC-fi\", \"SiteId\": \"site1\", \"Language\": \"en,fi,da\", \"ClassViewName\": \"POTT view\", \"CurrentOrg\": false, \"OrganizationCode\":\"BW00\"} ]","punchInSubOrgData");

    }

}
