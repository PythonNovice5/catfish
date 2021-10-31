package com.basware.bttf.pages.product_manager.supplier.agreements_supplier;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.supplier_delegation.BaswareUkDashBoardPage;
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
    @FindBy( linkText="Start date" )
    public WebElement manageAgreementsDropDownSortStartDate;
    @FindBy( linkText="Expiration Date" )
    public WebElement manageAgreementsDropDownSortExpiryDate;
    @FindBy( linkText="Last modified" )
    public WebElement manageAgreementsDropDownSortLastModified;

    // Filters
    @FindBy( linkText="All" )
    public WebElement manageAgreementsFilterAll;
    @FindBy( linkText = "Organisation agreements")
    public WebElement manageAgreementsFilterOrganisationAgreements;
    @FindBy( linkText = "Punchout agreements")
    public WebElement manageAgreementsFilterPunchoutAgreements;
    @FindBy( linkText = "Shared agreements")
    public WebElement manageAgreementsFilterSharedAgreements;
    @FindBy( linkText = "Awaiting response")
    public WebElement manageAgreementsFilterAwaitingResponse;
    @FindBy( linkText = "Awaiting approval")
    public WebElement manageAgreementsFilterAwaitingApproval;
    @FindBy( linkText = "Expiring soon")
    public WebElement manageAgreementsFilterExpiringSoon;
    @FindBy( linkText = "Expired")
    public WebElement manageAgreementsFilterExpired;
    @FindBy( linkText = "Active")
    public WebElement manageAgreementsFilterActive;
    @FindBy( linkText = "New")
    public WebElement manageAgreementsFilterNew;

    @FindBy( xpath="//*[@id='pagable-content']/div[2]/div[1]/div/div[1]/div[2]/a/span")
    public WebElement iconManageAgreement;

    @FindBy(name ="btn-search")
    public WebElement Search;

    @FindBy(name="keywords")
    public WebElement SearchBox;

    @FindBy(xpath = "//div/a[contains(@href,'publishAgreement')]//span")
    public WebElement ManageAgreement;

    @FindBy(linkText = "Exit supplier")
    private WebElement exitSupplier;

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

    public SupplierManageAgreementPage clickIconManageAgreement()
    {
        iconManageAgreement.click();
        return new SupplierManageAgreementPage();
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

    public ProductManagerPage clickAgmntDirButtons(String btnValue) throws Exception {
        pauseFor(2000);
        getWebElementNamed(btnValue).click();
        switch (btnValue) {
            case "Search":
                return new PublishAgreementsPage();
            case "ManageAgreement":
                return new SupplierManageAgreementPage();
        }
        return null;
    }

    public void searchAgreement(String value) {
        directoryInputSearch.sendKeys(value);
        clickButtonSearch();

    }

    public BaswareUkDashBoardPage exitFromSupplier()
    {
        waitUntillElementIsClickableAndClick(exitSupplier);
        return new BaswareUkDashBoardPage();
    }
}
