package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.util.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class AgreementDirectoryPage extends ProductManagerDirectoryPage<AgreementDirectoryPage>
{
    protected static Logger LOGGER = Logger.getLogger( AgreementDirectoryPage.class.getName() );


    // Dropdowns
    @FindBy( linkText="Relevance" )
    public WebElement manageAgreementsDropDownSortRelevance;
    @FindBy( linkText="Name" )
    public WebElement manageAgreementsDropDownSortName;
    @FindBy( linkText="Supplier" )
    public WebElement manageAgreementsDropDownSortSupplier;
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
    @FindBy( linkText = "Draft")
    public WebElement manageAgreementsFilterDraft;
    @FindBy( linkText = "Awaiting response")
    public WebElement manageAgreementsFilterAwaitingResponse;
    @FindBy( linkText = "Awaiting approval")
    public WebElement manageAgreementsFilterAwaitingApproval;
    @FindBy( linkText = "Expiring Soon")
    public WebElement manageAgreementsFilterExpiringSoon;
    @FindBy( linkText = "Expired")
    public WebElement manageAgreementsFilterExpired;
    @FindBy( linkText = "Active")
    public WebElement manageAgreementsFilterActive;
    @FindBy( linkText = "Archived")
    public WebElement manageAgreementsFilterArchived;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-cog']")
    public WebElement manageAgreementCog;

    public AgreementDirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/manageAgreements";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Agreements";
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(new HashMap<String,WebElement>(){{
            put("Relevance",manageAgreementsDropDownSortRelevance);
            put("Name",manageAgreementsDropDownSortName);
            put("Supplier",manageAgreementsDropDownSortSupplier);
            put("Start Date",manageAgreementsDropDownSortStartDate);
            put("Expiry Date", manageAgreementsDropDownSortExpiryDate);
            put("Last modified",manageAgreementsDropDownSortLastModified);

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
            put("Draft",manageAgreementsFilterDraft);
            put("Awaiting Response",manageAgreementsFilterAwaitingResponse);
            put("Awaiting Approval",manageAgreementsFilterAwaitingApproval);
            put("Expiring Soon",manageAgreementsFilterExpiringSoon);
            put("Expired",manageAgreementsFilterExpired);
            put("Active",manageAgreementsFilterActive);
            put("Archived",manageAgreementsFilterArchived);
        }});
    }

    // Filters

    public ManageAgreementPage clickManageCog()
    {
        manageAgreementCog.click();
        return new ManageAgreementPage();
    }

    public void searchRecentAgreement()
    {
        directoryInputSearch.sendKeys(props.get(TestConstants.ORG_AGREEMENT_NAME ));
        clickButtonSearch();
    }

    public void searchAgreement(String agreement)
    {
        directoryInputSearch.sendKeys(agreement);
        clickButtonSearch();

    }
}
