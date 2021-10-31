package com.basware.bttf.pages.product_manager.buyer.groups;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class GroupDirectoryPage extends ProductManagerDirectoryPage<GroupDirectoryPage>
{
    protected static Logger LOGGER = Logger.getLogger( GroupDirectoryPage.class.getName() );

    // Dropdowns
    @FindBy( linkText="Relevance" )
    public WebElement manageAgreementsDropDownSortRelevance;
    @FindBy( linkText="Name" )
    public WebElement manageAgreementsDropDownSortName;
    @FindBy( linkText="Last modified" )
    public WebElement manageAgreementsDropDownSortLastModified;

    // Filters
    @FindBy( linkText="All" )
    public WebElement manageAgreementsFilterAll;
    @FindBy ( linkText = "Community only")
    public WebElement manageCommunityOnlyFilter;
    @FindBy (linkText = "My groups only")
    public WebElement manageGroupOnlyFilter;
    @FindBy (linkText = "Membership only")
    public WebElement manageMemeberShipOnlyFilter;
    @FindBy (linkText = "Invited only")
    public WebElement manageInvitedOnlyFilter;
    @FindBy (linkText = "Rejected only")
    public WebElement manageRejectedOnlyFilter;

    @FindBy (id = "keywords" )
    public  WebElement searchInput;

    @FindBy( name = "btn-search")
    private WebElement searchButton;

    @FindBy(css = "a.btn.margin-left-10.btn-icon span.glyphicon.glyphicon-eye-open")
    private  WebElement viewIcon;

    @FindBy(css = "a.btn.margin-left-10.btn-icon span.glyphicon.glyphicon-ok")
    private WebElement acceptButton;

    @FindBy(xpath = "//span[@title='Manage']")
    private WebElement manageCog;


    public GroupDirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/manageGroups";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Groups";
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(new HashMap<String,WebElement>()
        {{
            put("Relevance",manageAgreementsDropDownSortRelevance);
            put("Name",manageAgreementsDropDownSortName);
            put("Last modified",manageAgreementsDropDownSortLastModified);
        }});

    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(new HashMap<String,WebElement>()
    {{
        put("All", manageAgreementsFilterAll);
        put("Community only", manageCommunityOnlyFilter);
        put("My group only", manageGroupOnlyFilter);
        put("Membership only", manageMemeberShipOnlyFilter);
        put("Invited only", manageInvitedOnlyFilter);
        put("Rejected only", manageRejectedOnlyFilter);
    }});
    }
    public ProductManagerPage clickOnButton(String button)
    {
        ProductManagerPage page = null;

        switch(button){
            case "create":
                WebElement createGroupButton = driver.findElement(By.linkText("Create"));
                createGroupButton.click();
                page =  new CreateGroupPage();
            case "manage cog":
                waitUntillElementIsClickableAndClick(manageCog);
                page = new ManageGroupsPage();
        }
        return page;

    }

    public void clickOnSearch()
    {
        waitUntillElementIsClickableAndClick(searchButton);
    }

    public ViewGroupAgreementsPage clickOnViewGroupAgreements()
    {
//        pauseFor(2000);
        waitUntillElementIsClickableAndClick(viewIcon);
        return new ViewGroupAgreementsPage();
    }

    public void acceptGroup()
    {
        waitUntillElementIsClickableAndClick(acceptButton);
//        acceptButton.click();
    }

    public void searchSharedGroup(String value)
    {
        directoryInputSearch.sendKeys(value);
        clickButtonSearch();
    }
}
