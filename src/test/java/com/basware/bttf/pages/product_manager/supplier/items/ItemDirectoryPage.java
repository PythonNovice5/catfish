package com.basware.bttf.pages.product_manager.supplier.items;
// Created by Julian Sheppard on 21/06/2017

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemDirectoryPage extends ProductManagerDirectoryPage
{
    protected static Logger LOGGER = Logger.getLogger( ItemDirectoryPage.class.getName() );

    // Page title area fields
    @FindBy( id="manageProductsTitle" )
    public WebElement PageTitle;

    // Page search bar fields
    @FindBy( id="keywords" )
    public WebElement SearchKeywords;

    @FindBy( id="removeSearchButton" )
    public WebElement SearchClearButton;

    @FindBy( name="btn-search" )
    public WebElement SearchButton;

    // Buttons
    @FindBy( id="btn-publish-updates" )
    public WebElement PublishUpdatesButton;

    @FindBy( name="btn-createProduct" )
    public WebElement CreateButton;

    // Order By
    @FindBy( name="btn-sortBy" )
    public WebElement OrderByDropdown;

    @FindBy( name="relevance" )
    public WebElement OrderByRelevance;

    @FindBy( name="name" )
    public WebElement OrderByName;

    @FindBy( name="newest" )
    public WebElement OrderByNewest;

    @FindBy( name="oldest" )
    public WebElement OrderByOldest;

    // Results displayed summary
    @FindBy( id="resultsShown_1" )
    public WebElement ResultsShownTop;

    @FindBy( id="resultsShown_2" )
    public WebElement ResultsShownBottom;

    // Pagination
    @FindBy( xpath="//*[@name='previousPage_1' or @id='previousPage_1']" )
    public WebElement PreviousPageTopButton;

    @FindBy( xpath="//*[@name='previousPage_2' or @id='previousPage_2']" )
    public WebElement PreviousPageBottomButton;

    @FindBy( xpath="//*[@name='nextPage_1' or @id='nextPage_1']" )
    public WebElement NextPageTopButton;

    @FindBy( xpath="//*[@name='nextPage_2' or @id='nextPage_2']" )
    public WebElement NextPageBottomButton;

    // Per page
    @FindBy( name="btn-filter" )
    public WebElement PerPageDropdown;

    @FindBy( name="25-results-per-page" )
    public WebElement PerPage25;

    @FindBy( name="50-results-per-page" )
    public WebElement PerPage50;

    @FindBy( name="100-results-per-page" )
    public WebElement PerPage100;

    // Filters
    @FindBy( name="ALL" )
    public WebElement AllFilter;

    @FindBy(name="STANDARD")
    public WebElement StandardFilter;

    @FindBy( name="DELIVERY" )
    public WebElement DeliveryFilter;

    @FindBy( name="PUNCHOUT" )
    public WebElement PunchoutFilter;

    @FindBy( name="SUPPLIER_CONTRACT" )
    public WebElement ContractFilter;

    @FindBy( name="UNPUBLISHED" )
    public WebElement NewFilter;

    @FindBy( name="USED" )
    public WebElement UnpublishedFilter;

    @FindBy( name="PUBLISHED" )
    public WebElement PublishedFilter;

    @FindBy( name="CHANGED" )
    public WebElement UpdatedFilter;

    @FindBy( name="ARCHIVABLE" )
    public WebElement WithdrawnFilter;

    @FindBy( name="IMAGE" )
    public WebElement WithImageFilter;

    @FindBy( name="NO_IMAGE" )
    public WebElement WithoutImageFilter;

    @FindBy( name="TEMPLATE" )
    public WebElement WithTemplateFilter;

    @FindBy( name="NO_TEMPLATE" )
    public WebElement WithoutTemplateFilter;


    // Item Details
    @FindBy( xpath="//a[starts-with(@name,'name_')]" )
    public List<WebElement> ItemNames;

    @FindBy( name="image_0" )
    public WebElement FirstItemImage;

    @FindBy( name="name_0" )
    public WebElement FirstItemName;

    @FindBy( id="itemTypeLabel_0" )
    public WebElement FirstItemItemTypeLabel;

    @FindBy( id="itemTypeData_0" )
    public WebElement FirstItemItemType;

    @FindBy( id="descriptionLabel_0" )
    public WebElement FirstItemDescriptionLabel;

    @FindBy( id="descriptionData_0" )
    public WebElement FirstItemDescription;

    @FindBy( id="statusLabel_0" )
    public WebElement FirstItemStatusLabel;

    @FindBy( id="statusData_0" )
    public WebElement FirstItemStatus;

    @FindBy( id="supplierItemIDLabel_0" )
    public WebElement FirstItemItemIDLabel;

    @FindBy( id="supplierItemIDData_0" )
    public WebElement FirstItemItemID;

    @FindBy( xpath="//button[@name='btn-sortBy']/span" )
    public WebElement SortFilterValue ;

    @FindBy( xpath="//button[@name='btn-filter']//span" )
    public WebElement SortPerPageValue;

    public ItemDirectoryPage()

    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl() { return getBaseUrl() + "/products/manageProducts"; }

    public String getExpectedTitle()
    {
        return "Product Manager: Items";
    }


    @Override
    protected void initSortByItems() {

    }

    @Override
    protected void initFilterItems() {

    }

    // (JS)
    public void clickOnFilter(String filterName) throws Exception
    {
        waitUntillElementIsClickableAndClick( getWebElementNamed( filterName ) );
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
        return;
    }

    // Clicks the button.  (Use only when not moving to another page.)
    public void clickButton( String buttonName ) throws Exception
    {
        clickWebElement(getWebElementNamed( buttonName ));
    }

    public EditItemPage clickFirstItemName() throws Exception
    {
        waitUntilDisplayed( FirstItemName );
        FirstItemName.click();
        return new EditItemPage();
    }

    public EditItemPage clickFirstItemImage() throws Exception
    {
        waitUntilDisplayed( FirstItemImage );
        FirstItemImage.click();
        return new EditItemPage();
    }

    public CreateItemPage clickButtonCreate()
    {
        CreateButton.click();
        return new CreateItemPage();
    }

    // Use this to click a button or link that causes the same page be re-loaded
    public ItemDirectoryPage clickPageReloadingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "Search": element = SearchButton; break;
            case "SearchClear": element = SearchClearButton; break;
            case "PublishUpdates": element = PublishUpdatesButton; break;
            case "PreviousPageTop": element = PreviousPageTopButton; break;
            case "PreviousPageBottom": element = PreviousPageBottomButton; break;
            case "NextPageTop": element = NextPageTopButton; break;
            case "NextPageBottom": element = NextPageBottomButton; break;
            // filters:
            case "All": element = AllFilter; break;
            case "Standard": element = StandardFilter; break;
            case "Delivery": element = DeliveryFilter; break;
            case "Punchout": element = PunchoutFilter; break;
            case "Contract": element = ContractFilter; break;
            case "New": element = NewFilter; break;
            case "Unpublished": element = UnpublishedFilter; break;
            case "Published": element = PublishedFilter; break;
            case "Updated": element = UpdatedFilter; break;
            case "Withdrawn": element = WithdrawnFilter; break;
            case "WithImage": element = WithImageFilter; break;
            case "WithoutImage": element = WithoutImageFilter; break;
            case "WithTemplate": element = WithTemplateFilter; break;
            case "WithoutTemplate": element = WithoutTemplateFilter; break;

            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        return new ItemDirectoryPage();
    }

    // (JS)
    public ItemDirectoryPage selectOrderBy( String dropdownOption ) throws RuntimeException
    {
        clickWebElement(OrderByDropdown);
        WebElement optionElement;
        switch( dropdownOption )
        {
            case "Relevance"  : optionElement = OrderByRelevance; break;
            case "Name"  : optionElement = OrderByName; break;
            case "Newest"  : optionElement = OrderByNewest; break;
            case "Oldest"  : optionElement = OrderByOldest; break;
            default: throw new RuntimeException( "Couldn't find a matching Order by dropdown option" );
        }
        waitUntillElementIsClickableAndClick( optionElement );
        return new ItemDirectoryPage();
    }

    // (JS)
    public ItemDirectoryPage selectPerPage( String dropdownOption ) throws RuntimeException
    {
        clickWebElement(PerPageDropdown);
        WebElement optionElement;
        switch( dropdownOption )
        {
            case "25"  : optionElement = PerPage25; break;
            case "50"  : optionElement = PerPage50; break;
            case "100" : optionElement = PerPage100; break;
            default: throw new RuntimeException( "Couldn't find a matching Per Page dropdown option" );
        }
        clickWebElement( optionElement );
        return new ItemDirectoryPage();
    }


    // (JS)
    public long extractFilterCount( String elementName ) throws Exception
    {
        String regex = "\\S+\\s+\\((\\d+)\\)";
        Pattern pattern = Pattern.compile( regex );
        Matcher matcher = pattern.matcher(getElementValue(elementName));
        matcher.find();
        return NumberFormat.getInstance().parse( matcher.group( 1 ) ).longValue();
    }

    // (JS)
    public boolean areCountsAreConsistent() throws Exception
    {
        long AllCount = extractFilterCount("AllFilter");
        if(AllCount != (extractFilterCount("StandardFilter")
                + extractFilterCount("DeliveryFilter")
                + extractFilterCount("PunchoutFilter")
                + extractFilterCount("ContractFilter") ) )
            return false;
        if(AllCount != (extractFilterCount("NewFilter")
                + extractFilterCount("UnpublishedFilter")
                + extractFilterCount("PublishedFilter")
                + extractFilterCount("UpdatedFilter")
                + extractFilterCount("WithdrawnFilter") ) )
            return false;
        if(AllCount != (extractFilterCount("WithImageFilter")
                + extractFilterCount("WithoutImageFilter") ) )
            return false;
        if(AllCount != (extractFilterCount("WithTemplateFilter")
                + extractFilterCount("WithoutTemplateFilter") ) )
            return false;
        return true;
    }

    // Enters the item name and repeatedly Searches until an item is found or timeout occurs
    public ItemDirectoryPage searchForItemUntilFoundOrTimeout( String itemName ) throws Exception
    {
        int timeToRetrySearch = timeToRetrySearch();        // constant from AbstractPage
        String resultsShownTop;
        enterValueIntoElement( itemName, "SearchKeywords");
        long startSecs = (new Date().getTime())/1000;
        long timeNowSecs = (new Date().getTime())/1000;
        while( (timeNowSecs - startSecs) < timeToRetrySearch )
        {
            clickButton( "SearchButton");
            waitUntilPageDocumentIsCompleted();
            resultsShownTop = getElementValue("ResultsShownTop");
            if( ! resultsShownTop.contentEquals("0-0 / 0") )
            {
                LOGGER.debug( "Item Directory page ... Search for " + itemName + " found an item after " + (timeNowSecs - startSecs) + " seconds" + "\n" );
                return new ItemDirectoryPage();
            }
            Thread.sleep(500 );
            timeNowSecs = (new Date().getTime())/1000;
        }
        throw new Exception( "Timed out without finding the item" );
    }

    public ItemDirectoryPage verifyAlertMsg(String msg) throws Exception{
        verifyMessage(msg);
        return new ItemDirectoryPage();
    }

}