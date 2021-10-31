package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.SupplierManageAgreementPage;
import com.basware.bttf.util.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class PublishAgreementsPage extends ProductManagerDirectoryPage<PublishAgreementsPage>
{
    protected static Logger LOGGER = Logger.getLogger( PublishAgreementsPage.class.getName() );

    // Dropdowns
    @FindBy( linkText="Relevance" )
    public WebElement manageAgreementsDropDownSortRelevance;
    @FindBy( linkText="Name" )
    public WebElement manageAgreementsDropDownSortName;
    @FindBy( linkText="Agreement Owner" )
    public WebElement manageAgreementOwnerDropDownSortSupplier;
    @FindBy( linkText="Start Date" )
    public WebElement manageAgreementsDropDownSortStartDate;
    @FindBy( linkText="Expiry Date" )
    public WebElement manageAgreementsDropDownSortExpiryDate;
    @FindBy( linkText="Last Modified" )
    public WebElement manageAgreementsDropDownSortLastModified;

    // Filters
    @FindBy( linkText="All" )
    public WebElement manageAgreementsFilterAll;
    @FindBy( linkText = "Organisation Agreements")
    public WebElement manageAgreementsFilterOrganisationAgreements;
    @FindBy( linkText = "Punchout Agreements")
    public WebElement manageAgreementsFilterPunchoutAgreements;
    @FindBy( linkText = "Shared Agreements")
    public WebElement manageAgreementsFilterSharedAgreements;
    @FindBy( linkText = "Awaiting Response")
    public WebElement manageAgreementsFilterAwaitingResponse;
    @FindBy( linkText = "Awaiting Approval")
    public WebElement manageAgreementsFilterAwaitingApproval;
    @FindBy( linkText = "Expiring Soon")
    public WebElement manageAgreementsFilterExpiringSoon;
    @FindBy( linkText = "Expired")
    public WebElement manageAgreementsFilterExpired;
    @FindBy( linkText = "Active")
    public WebElement manageAgreementsFilterActive;
    @FindBy( linkText = "New")
    public WebElement manageAgreementsFilterNew;

    @FindBy( xpath=".//*[@id='pagable-content']/div[2]/div[2]/div/div[1]/div[2]/a/span")
    public WebElement iconManageAgreement;

    @FindBy ( linkText = "< Back to Agreement Directory")
    public WebElement backToAgreementDirectory;

    @FindBy(name ="btn-search")
    public WebElement Search;

    @FindBy(name="keywords")
    public WebElement SearchBox;

    @FindBy(xpath = "//div/a[contains(@href,'publishAgreement')]//span")
    public WebElement ManageAgreement;

    public PublishAgreementsPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/publish";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Agreements (Suppliers)";
    }

    public void clickIconManageAgreement()
    {
        iconManageAgreement.click();
    }

    public void clickLinkBackToAgreementDirectory()
    {
        backToAgreementDirectory.click();
    }



    @Override
    protected void initSortByItems()
    {
        setSortByItems(new HashMap<String,WebElement>(){{
            put("Relevance",manageAgreementsDropDownSortRelevance);
            put("Name",manageAgreementsDropDownSortName);
            put("Agreement Owner",manageAgreementOwnerDropDownSortSupplier);
            put("Start Date",manageAgreementsDropDownSortStartDate);
            put("Expiry Date", manageAgreementsDropDownSortExpiryDate);
            put("Last Modified",manageAgreementsDropDownSortLastModified);

        }});
    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(new HashMap<String,WebElement>(){{
            put("All",manageAgreementsFilterAll);
            put("Organisation Agreements",manageAgreementsFilterOrganisationAgreements);
            put("Punchout Agreements",manageAgreementsFilterPunchoutAgreements);
            put("Shared Agreements",manageAgreementsFilterSharedAgreements);
            put("Awaiting Response",manageAgreementsFilterAwaitingResponse);
            put("Awaiting Approval",manageAgreementsFilterAwaitingApproval);
            put("Expiring Soon",manageAgreementsFilterExpiringSoon);
            put("Expired",manageAgreementsFilterExpired);
            put("Active",manageAgreementsFilterActive);
            put("New",manageAgreementsFilterNew);
        }});
    }

    public void enterValueIntoField( String value, String fieldName ) throws InterruptedException
    {
        switch (fieldName)
        {
            case "SearchBox":
                SearchBox.sendKeys(props.get(TestConstants.ORG_AGREEMENT_NAME));
                break;
        }

    }

    public ProductManagerPage clickAgmntDirButtons(String btnValue) throws Exception{
        pauseFor(2000);
        getWebElementNamed(btnValue).click();
        switch (btnValue){
            case "Search":
                return new PublishAgreementsPage();
            case "ManageAgreement":
                return new SupplierManageAgreementPage();
        }
        return null;
    }
}
