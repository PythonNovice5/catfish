package com.basware.bttf.pages.shopping.marketplace;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.external.ShoppingBasketPageJupiter;
import com.basware.bttf.pages.por.MyQuotesPage;
import com.basware.bttf.pages.por.ViewPriceOnRequestPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.NumberFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MarketplaceSearchResultsPageJupiter extends ShoppingPage
{
    // Page title area fields
    @FindBy( id="letterbox_0" )
    public WebElement itemsInListView;

    @FindBy( xpath="//span[text()='home']" )
    public WebElement HomeIcon;

    @FindBy(id="thumbnail-button")
    public WebElement itemsInThumbnailView;

    @FindBy(id="tableView_0")
    public WebElement itemsInTableView;

    @FindBy(id="letter-box-button")
    public WebElement ShowAsListButton;

    @FindBy(id="thumbnail-button")
    public WebElement ShowAsThumbnailButton;

    @FindBy(id="table-button")
    public WebElement ShowAsTableButton;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement ViewAsContainer;

    @FindBy(xpath = "//div[normalize-space(text())='My lists']/..//a")
    public WebElement firstList;

    @FindBy( xpath="//a[normalize-space(text())='Home']")
    public WebElement HomeText;

    @FindBy(xpath="//img[@name='5c9b32596330ec210cb17a2f']")
    public WebElement ContainerImage;

    @FindBy(xpath = "//div[contains(@class,'page-title')]")
    public WebElement PageTitle;

    @FindBy( name="rfqButtonIcon" )
    public WebElement QuotesIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement QuotesText;

    @FindBy( name="rfqBadge" )
    public WebElement QuotesCount;

    @FindBy( name="itemFavouritesButtonIcon" )
    public WebElement ListsIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']|//a[@id='starIcon_0']")
    public WebElement ListsText;

    @FindBy( name="itemComparisonButtonIcon" )
    public WebElement CompareIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container'] |//a[@id='compareButton_0']")
    public WebElement CompareText;

    @FindBy(name="itemComparisonButtonIcon")
    public WebElement CompareCount;

    @FindBy( name="basketButtonIcon" )
    public WebElement BasketIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement BasketText;

//    @FindBy( name="itemCount" )
//    public WebElement BasketCount;

    @FindBy(xpath="//a[@id='basket']//span[contains(@class,'mat-badge-content')]")
    public WebElement BasketCount;

    @FindBy(css="[id='lbl_basketSummaryPrice'] [name='amount']")
    public WebElement BasketValue;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='amount']" )
    public WebElement BasketAmount;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='currency']" )
    public WebElement BasketCurrency;

    // Page search bar fields
    @FindBy( xpath="//button[@text='Categories']" )       // >>>>>>>>>>>>>> needs improving!
    public WebElement SearchCategoriesButton;

    @FindBy( id="keywords" )
    public WebElement SearchKeywords;

    @FindBy( id="removeSearchButton" )
    public WebElement SearchClearButton;

    @FindBy( xpath = "//button[contains(text(),'Search')]" )
    public WebElement SearchButton;

    @FindBy( className="expired-items-option")
    public WebElement ShowExpiredItemsFilter;

    @FindBy( className="match-keywords-option" )
    public WebElement MatchAllKeywordsFilter;

    // Order by
    @FindBy( id="orderByLabel" )
    public WebElement OrderByLabel;

    @FindBy( id="orderByButton" )
    public WebElement OrderBy;

    @FindBy( name="RELEVANCE" )
    public WebElement OrderByRelevance;

    @FindBy( name="NEWEST" )
    public WebElement OrderByDateNtoO;

    @FindBy( name="OLDEST" )
    public WebElement OrderByDateOtoN;

    @FindBy( name="PRICE_ASC" )
    public WebElement OrderByPriceLtoH;

    @FindBy( name="PRICE_DESC" )
    public WebElement OrderByPriceHtoL;

    @FindBy( name="NAME_ASC" )
    public WebElement OrderByNameAtoZ;

    @FindBy( name="NAME_DESC" )
    public WebElement OrderByNameZtoA;

    @FindBy( name="SKU_ASC" )
    public WebElement OrderByItemIDAtoZ;

    @FindBy( name="SKU_DESC" )
    public WebElement OrderByItemIDZtoA;

    // Results displayed summary and Pagination
    @FindBy( id="resultsShown_1" )
    public WebElement ResultsShownTop;

    @FindBy( id="resultsShown_2" )
    public WebElement ResultsShownBottom;

    @FindBy( xpath="//*[@name='previousPage_1' or @id='previousPage_1']" )
    public WebElement PreviousPageTopButton;

    @FindBy( xpath="//*[@name='previousPage_2' or @id='previousPage_2']" )
    public WebElement PreviousPageBottomButton;

    @FindBy( xpath="//*[@name='nextPage_1' or @id='nextPage_1']" )
    public WebElement NextPageTopButton;

    @FindBy( xpath="//*[@name='nextPage_2' or @id='nextPage_2']" )
    public WebElement NextPageBottomButton;

    @FindBy( name="perPageLabel_1" )
    public WebElement PerPageLabelTop;

    @FindBy( name="perPageLabel_2" )
    public WebElement PerPageLabelBottom;

    @FindBy( name="perPageButton_1" )
    public WebElement PerPageDropdownTop;

    @FindBy( name="perPageButton_2" )
    public WebElement PerPageDropdownBottom;

    @FindBy( name="perPage_25_1" )
    public WebElement PerPage25Top;

    @FindBy( name="perPage_50_1" )
    public WebElement PerPage50Top;

    @FindBy( name="perPage_100_1" )
    public WebElement PerPage100Top;

    // Filters
    @FindBy( id="lbl_filters" )
    public WebElement FiltersTitle;

    @FindBy( id="lnk_clear" )
    public WebElement ClearFilters;

    @FindBy( id="lbl_priceRange" )
    public WebElement PriceFiltersTitle;

    @FindBy( id="txt_minPrice" )
    public WebElement MinPrice;

    @FindBy( id="priceFiltersToLabel" )
    public WebElement PriceFiltersToLabel;

    @FindBy( id="txt_maxPrice" )
    public WebElement MaxPrice;

    @FindBy( id="btn_go" )
    public WebElement PriceFiltersGoButton;

    @FindBy( xpath="//*[@id=\"ContractReference_filter-container\"]//div/span" )
    public WebElement ContractReferenceFilterTitle;

    @FindBy( xpath="//*[@name=\"attributeFilterOption_0_0\" and contains(@id,'ContractReference')]//label/span" )
    public WebElement FirstContractReferenceFilter;

    @FindBy( xpath="//*[@id=\"Manufacturername_filter-container\"]//div/span" )
    public WebElement ManufacturerNameFilterTitle;

    @FindBy(xpath="//*[@name=\"attributeFilterOption_1_0\" and contains(@id,'Manufacturername')]//label/span" )
    public WebElement FirstManufacturerNameFilter;

    @FindBy( xpath="//*[@id=\"Supplier_filter-container\"]//div/span" )
    public WebElement SupplierFilterTitle;

    @FindBy( name="attributeFilterOption_2_0" )
    public WebElement FirstSupplierFilter;

    @FindBy( id="lbl_categories" )
    public WebElement CategoriesFilterTitle;

    @FindBy( name="categoriesFilterOption_all" )
    public WebElement AllCategoriesFilter;

    @FindBy( xpath="//a[starts-with(@name,'categoriesFilterOption_')]" )
    public List<WebElement> CategoriesFilters;

    // Item Details
    @FindBy( xpath="//a[starts-with(@name,'name_')]" )
    public List<WebElement> ItemNames;

    @FindBy( id="image_0" )
    public WebElement FirstItemImage;

    @FindBy( id="name_0" )
    public WebElement FirstItemName;

    @FindBy( id="supplierNameLabel_0" )
    public WebElement FirstItemSupplierNameLabel;

    @FindBy( id="supplierNameDetails_0" )
    public WebElement FirstItemSupplierName;

    @FindBy(name="get-view-button")
    public WebElement FirstItemView;

    @FindBy( id="supplierItemIDLabel_0" )
    public WebElement FirstItemItemIDLabel;

    @FindBy( id="supplierItemIDDetails_0" )
    public WebElement FirstItemItemID;

    @FindBy( id="contractReferenceLabel_0" )
    public WebElement FirstItemContractReferenceLabel;

    @FindBy( id="contractReferenceDetails_0" )
    public WebElement FirstItemContractReference;

    @FindBy(id="lbl_manuName")
    public WebElement FirstItemManufacturerName;

    @FindBy( id="descriptionLabel_0" )
    public WebElement FirstItemDescriptionLabel;

    @FindBy( id="descriptionDetails_0" )
    public WebElement FirstItemDescription;

    @FindBy( id="priceDetails_0" )
    public WebElement FirstItemPriceCurrencyUnit;

    @FindBy(name="amount")
    public WebElement FirstItemPrice;

    @FindBy( id="quantityLabel_0" )
    public WebElement FirstItemQuantityLabel;

    @FindBy( xpath="//input[@name='quantity']" )
    public WebElement FirstItemQuantity;

    @FindBy( name="add-basket-button" )
    public WebElement FirstItemAddToBasketButton;

    @FindBy( xpath="//span[contains(@name,'updateButton_')]/input" )
    public WebElement FirstItemUpdateBasketQtyButton;

    @FindBy( xpath="//a[contains(@name,'removeButton_')]" )
    public WebElement FirstItemRemoveFromBasketButton;

    @FindBy( id="minQuantityUomLabel_0" )
    public WebElement FirstItemMinIncrLabel;

    @FindBy( id="minQuantityIncrementData_0" )
    public WebElement FirstItemMinIncr;

    @FindBy(id="starIcon_0")
    public WebElement FirstItemAddToListButton;

    //    @FindBy( xpath="//span[contains(@name,'compareButton_')]" )
    //a[text()='Compare']
    @FindBy( xpath="//a[normalize-space(text())='Compare']" )
    public WebElement FirstItemAddToComparisonButton;

    @FindBy( name="name_1" )
    public WebElement SecondItemName;

    // Modal Select List Pop-up area
    @FindBy( id="mat-dialog-title-3" )
    public WebElement ModalTitle;

    @FindBy( id="closeModalButton" )
    public WebElement ModalCloseButton;

    @FindBy( xpath="//div[@id='shoppingListModal']//a[contains(@name,'list_')]" )
    public List<WebElement> ModalLists;

    @FindBy( id="userList_0" )
    public WebElement ModalFirstList;

    @FindBy( name="list_1" )
    public WebElement ModalSecondList;

    @FindBy( id="cancelModalButton" )
    public WebElement ModalCancelButton;

    //Content tags
    @FindBy (id ="attributeFilterLabel_0")
    private  WebElement contenTagSection;

    @FindBy (id="resultsShown_1")
    public WebElement contentTagResults;

    @FindBy(xpath = "//*[@id='attribute-filter']/ul/ul[1]/li/a")
    public WebElement contentTag;

    @FindBy(name = "get-quotes-button")
    public WebElement GetQuote;

    @FindBy(xpath = "//span[normalize-space(text())='Price On Request']")
    public WebElement PriceOnRequestStatus;

    @FindBy(xpath = "//input[@title='Your reference']")
    public WebElement YourReference;

    @FindBy(xpath ="//textarea[@title='Description']")
    public WebElement QuoteDescription;

    @FindBy(xpath ="//button[normalize-space(text())='Send']")
    public WebElement Send;

    @FindBy(xpath="//label[contains(text(),'Expiration Time')]//..//select")
    public WebElement ExpirationTime;

    @FindBy(xpath = "//*[contains(@class,'toast-success')]")
    public WebElement SuccessMessage;

    @FindBy(xpath = "//a[text()='here']")
    public WebElement here;

    @FindBy(id = "txt_quantity_0")
    public WebElement CatfishLabel1;

    @FindBy(id = "txtArr_1")
    public WebElement CatfishLabel2;

    @FindBy(id = "btn_submit")
    public WebElement AddInformation;

    @FindBy(xpath="//h4[@class='modal-title' and contains(text(),'Additional information')]")
    public WebElement AdditionalInformation;

    @FindBy(xpath = "//div[contains(@class,'mat-dialog-title') and contains(text(),'Item Options')]")
    public WebElement ItemOptions;

    @FindBy(xpath = "//span[@name='amount']")
    public WebElement priceWithoutTax;

    @FindBy(xpath = "//span[@title='Including tax']")
    public WebElement priceIncludingTax;

    @FindBy(xpath = "//a[contains(text(),'catfishcontenttag')]")
    public WebElement contentTagCheckBox;

    protected static Logger LOGGER = Logger.getLogger( MarketplaceSearchResultsPageJupiter.class );

    public MarketplaceSearchResultsPageJupiter()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return "https://jupiter-buyers.procserveonline.com" + "/ui/shopping/marketplace/index";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Search Results";
    }

    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "FirstItemQuantity": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "First Contract Reference": return getTextOfWebElement(FirstContractReferenceFilter);
            case "First Manufacturer Name": return getTextOfWebElement(FirstManufacturerNameFilter);
            case "First Supplier": return getTextOfWebElement(FirstSupplierFilter);
            case "All Categories": return getTextOfWebElement(AllCategoriesFilter);
            case "First CategoriesFilter": return getTextOfWebElement(CategoriesFilters.get(1));
            case "First CategoriesSubFilter": return getTextOfWebElement(CategoriesFilters.get(2));
            case "TaxPercent": return calculateTax();
            case "First Item price":return getTextOfWebElement(FirstItemPrice);
            case "ContainerImage": return getAttributeValueOfWebElement(ContainerImage,"name");
            case "First Item Manufacturer Name": return getTextOfWebElement(FirstItemManufacturerName);
            case "First Item Contract Reference":return getTextOfWebElement(FirstItemContractReference);
            case "ShowAsListButtonText": hoverToElement(ShowAsListButton);return getTextOfWebElement(ViewAsContainer);
            case "ShowAsThumbnailButtonText": hoverToElement(ShowAsThumbnailButton);return getTextOfWebElement(ViewAsContainer);
            case "ShowAsTableButtonText": hoverToElement(ShowAsTableButton);return getTextOfWebElement(ViewAsContainer);
            default: return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    private String extractCountFromBasket(String basketText) throws RuntimeException
    {
        String count = "";
        Pattern pattern = Pattern.compile( ".*Items: (\\d*).*" );
        Matcher matcher = pattern.matcher( basketText );
        matcher.find();
        try
        {
            count = "Items: " + NumberFormat.getInstance().parse(matcher.group(1)).toString();
        }
        catch (Exception exception)
        {
            count = "";
        }
        return count;
    }

    public ProductManagerPage clickView(){
        waitUntillElementIsClickableAndClick(FirstItemView);
        return new ItemDetailsPage();

    }

    private String calculateTax() throws Exception{

        double priceIncludingTaxValue = Double.parseDouble(getTextOfWebElement(priceIncludingTax).replaceAll("[^0-9]",""));
        double priceWithoutTaxValue = Double.parseDouble(getTextOfWebElement(priceWithoutTax).replaceAll("[^0-9]",""));
        double taxValue = ((priceIncludingTaxValue - priceWithoutTaxValue)/priceWithoutTaxValue)*100;
        taxValue = Math.round(taxValue);
        int tax = (int)taxValue;
        String taxPer = Integer.toString(tax);
        LOGGER.debug("Tax percentage found as - " + taxPer + "%");
        return taxPer;
    }

    public ShoppingListsPage clickListsButton() throws Exception
    {
        waitUntillElementIsClickableAndClick(ListsIcon);
//        pauseFor(1000);
        waitUntillElementIsClickableAndClick(firstList);
        return new ShoppingListsPage();
    }

    public MyQuotesPage clickQuotesButton() throws Exception
    {
        waitUntillElementIsClickableAndClick(QuotesIcon);
        return new MyQuotesPage();
    }

    public ShoppingBasketPageJupiter clickBasketButton() throws Exception
    {
        waitUntillElementIsClickableAndClick( BasketIcon);
        return new ShoppingBasketPageJupiter();
    }

    public void verifyValue(String eValue) throws Exception{
        String referVal = " ";
        switch(eValue){
            case "First Item Contract Reference":
                eValue=getTextOfWebElement(FirstItemContractReference);
                referVal = props.get("CR1").replaceAll("[\\[\\](){}]","").replaceAll("[0123456789]","").trim();
                break;
            case "First Item Manufacturer Name":
                eValue=getTextOfWebElement(FirstItemManufacturerName);
                referVal = props.get("M1").replaceAll("[\\[\\](){}]","").replaceAll("[0123456789]","").trim();
                break;
            case "First Item Supplier Name":
                eValue=getTextOfWebElement(FirstItemManufacturerName);
                referVal = props.get("M1").replaceAll("[\\[\\](){}]","").replaceAll("[0123456789]","").trim();
                break;
        }
        LOGGER.debug(referVal+" does not contain "+eValue);
        assertTrue("Contract reference mismatch found ..",eValue.contains(referVal));
    }



    // Use this to click a button or link that causes the same page be re-loaded
    public ProductManagerPage clickPageReloadingElement(String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "Search": element = SearchButton; break;
            case "SearchClear": element = SearchClearButton; break;
            case "PreviousPageTop": element = PreviousPageTopButton; break;
            case "NextPageTop": element = NextPageTopButton; break;
            case "PreviousPageBottom": element = PreviousPageBottomButton; break;
            case "NextPageBottom": element = NextPageBottomButton; break;
            // first item buttons:
            case "first item AddToBasket": element = FirstItemAddToBasketButton; break;
            case "first item UpdateBasketQty": element = FirstItemUpdateBasketQtyButton; break;
            case "first item RemoveFromBasket": element = FirstItemRemoveFromBasketButton; break;
            // filters:
            case "Clear Filters": element = ClearFilters; break;
            case "Show Expired Items": element = ShowExpiredItemsFilter; break;
            case "Match all keywords": element = MatchAllKeywordsFilter; break;
            case "Price Go": element = PriceFiltersGoButton; break;
            case "First Contract Reference": element = FirstContractReferenceFilter;
                props.set("CR1",getTextOfWebElement(FirstContractReferenceFilter)); break;
            case "First Manufacturer Name": element = FirstManufacturerNameFilter;
                props.set("M1",getTextOfWebElement(FirstManufacturerNameFilter)); break;
            case "First Supplier": element = FirstSupplierFilter;
                props.set("S1",getTextOfWebElement(FirstSupplierFilter)); break;
            case "All Categories": element = AllCategoriesFilter; break;
            case "First CategoriesFilter": element = CategoriesFilters.get(1); break;
            case "First CategoriesSubFilter": element = CategoriesFilters.get(2); break;
            case "Get Quote": element  = GetQuote;break;
            case "Send":element=Send;break;
            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        waitUntillElementIsClickableAndClick(element);
        waitUntilAnyAJAXIsCompleted();
        return new MarketplaceSearchResultsPage();
    }

    // Use this to click a button or link that causes the same page be refreshed
    public void clickPageRefreshingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // first item buttons:
            case "first item AddToBasket": element = FirstItemAddToBasketButton; break;
            case "first item UpdateBasketQty": element = FirstItemUpdateBasketQtyButton; break;
            case "first item RemoveFromBasket": element = FirstItemRemoveFromBasketButton; break;

            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        pauseFor(1000);
        waitUntilPageDocumentIsCompleted();
    }


    // Clicks the button.  (Use only when no page load or reload.)
    public void clickButton( String buttonName ) throws Exception
    {
        clickWebElement(getWebElementNamed( buttonName ));
    }

    public ItemDetailsPage clickFirstItemNameLink() throws Exception
    {
        waitUntilDisplayed( FirstItemName );
        scrollToElement( FirstItemName );
        FirstItemName.click();
        return new ItemDetailsPage();
    }

    public void verifyFirstSupId(String actualSupId)
    {
        pauseFor(2000);
        assertEquals(FirstItemItemID.getText(),actualSupId);
    }

    // Clicks the link.  (Use only when no page load or reload.)
    public ProductManagerPage clickLink(String linkName ) throws Exception
    {
        switch (linkName){
            case "here":
                pauseFor(2000);
                clickWebElement(getWebElementNamed(linkName));
                return new ViewPriceOnRequestPage();
        }
        clickWebElement(getWebElementNamed( linkName ));
        return null;
    }

    public ItemComparisonPage clickOnElement(String value) throws Exception{
//        waitUntilNoModalPopup();
        waitUntillElementIsClickableAndClick(CompareIcon);
        return new ItemComparisonPage();
    }

    public void clickListLink( String listElementName, String text ) throws Exception
    {
        LOGGER.debug( "ModalLists: " + ModalLists.size() + "\n" );
        switch( listElementName )
        {
            case "Modal lists": getElementByTextFromListOfElements( ModalLists, text ).click(); break;
            default: throw new Exception("List not recognised");
        }
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    public MarketplaceSearchResultsPage selectOption(String dropdownName, String dropdownOption ) throws Exception
    {
        selectDropdownOptionByText(getWebElementNamed(dropdownName),dropdownOption);

        return new MarketplaceSearchResultsPage();
    }

    public MarketplaceSearchResultsPage selectPerPage(String dropdownOption ) throws RuntimeException
    {
        clickWebElement(PerPageDropdownTop);
        WebElement optionElement;
        switch( dropdownOption )
        {
            case "25"  : optionElement = PerPage25Top; break;
            case "50"  : optionElement = PerPage50Top; break;
            case "100" : optionElement = PerPage100Top; break;
            default: throw new RuntimeException("No case statement matching: " + dropdownOption);
        }
        clickWebElement( optionElement );
        return new MarketplaceSearchResultsPage();
    }

    public void contentTagSection(){
        contenTagSection.isDisplayed();
    }


    private String contentTagActualText;

    public void contentTagInMarketPlace()

    {
        contentTag.isDisplayed();
        contentTagActualText = contentTag.getText();
    }

    public void clickOnContentTag(String contentTagName )
    {
        contentTagCheckBox.click();
    }

    public void verifyContentTagResults()
    {
        String actualContentTagResults = contentTagResults.getText();
        String actualNumberOfResults[] = actualContentTagResults.split("/");
        String actualContentTagNumber =  contentTagActualText.substring(contentTagActualText.indexOf("(")+1,contentTagActualText.indexOf(")"));
        assertEquals(actualNumberOfResults[1].trim(),actualContentTagNumber);

    }

    public String getFirstItemUpdatedPrice() throws Exception{

        return getTextOfWebElement(FirstItemPrice);
    }

    public String verifyFirstItem(String elem) throws Exception{
        getWebElementNamed(elem);
        return null;
    }

//    public void hoverMyElem() throws Exception{
//        hoverToElement(QuotesIcon);
//        LOGGER.debug("Waiting here ...");
//        LOGGER.debug(getTextOfWebElement(quotesTextAfterHover));
//        pauseFor(20000);
//    }

    public WebElement getWebElement(String elem) throws Exception{

        return getWebElementNamed(elem);

    }

}
