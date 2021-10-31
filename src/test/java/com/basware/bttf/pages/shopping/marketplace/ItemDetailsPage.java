package com.basware.bttf.pages.shopping.marketplace;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.quickQuote.CreateRfqPage;
import com.basware.bttf.pages.shopping.quickQuote.RfqDirectoryPage;
import com.basware.bttf.util.generator.model.Item;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemDetailsPage extends ShoppingPage
{
    // Page title area fields
    @FindBy( name="homeButtonIcon" )
    public WebElement HomeIcon;

    @FindBy(xpath="//span[@id='otherOptionsLabel']")
    public WebElement OtherOptions;

    @FindBy(id="Size_0")
    public WebElement SizeS;

    @FindBy(id="Size_1")
    public WebElement SizeM;

    @FindBy(id="Size_2")
    public WebElement SizeL;

    @FindBy(id="Color_0")
    public WebElement ColorB;

    @FindBy(id="Color_1")
    public WebElement ColorR;

    @FindBy(xpath = "//label[@id='dimension_0']//..//..//select")
    public WebElement SelectColor;

    @FindBy(xpath = "//label[@id='dimension_1']//..//..//select")
    public WebElement SelectSize;

    @FindBy( name="homeButtonText" )
    public WebElement HomeText;

    @FindBy(xpath = "//a[normalize-space(text())='Back to Search Results']")
    public WebElement BackLink;

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

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement ListsText;

    @FindBy( name="itemComparisonButtonIcon" )
    public WebElement CompareIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement CompareText;

    @FindBy( name="itemComparisonButtonIcon" )
    public WebElement CompareCount;

    @FindBy( name="basketButtonIcon" )
    public WebElement BasketIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement BasketText;

    @FindBy( name="itemCount" )
    public WebElement BasketCount;

    @FindBy(xpath = "//span[contains(@id,'mat-badge-content-')]")
    public WebElement ItemsInTheBasket;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='total']" )
    public WebElement BasketValue;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='amount']" )
    public WebElement BasketAmount;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='currency']" )
    public WebElement BasketCurrency;

    @FindBy( name="alertMessageDetail" )
    public WebElement alertMessageText;

    // Left hand column elements
    @FindBy( xpath="//span[@id='stage_prev-stage']/i")
    public WebElement MainImagePreviousButton;

    @FindBy( xpath="//img[starts-with(@name,'main_image_')]" )
    public List<WebElement> MainImages;

    @FindBy( id="displayPic" )
    public WebElement FirstMainImage;

    @FindBy( name="main_image_1" )
    public WebElement SecondMainImage;

    @FindBy( xpath="//span[@id='stage_next-stage']/i")
    public WebElement MainImageNextButton;

    @FindBy( id="navigation_prev-navigation" )
    public WebElement CarouselPreviousButton;

    @FindBy( xpath="//img[starts-with(@name,'navigation_image_')]" )
    public List<WebElement> CarouselImages;

    @FindBy( name="navigation_image_0" )
    public WebElement FirstCarouselImage;

    @FindBy( id="navigation_next-navigation" )
    public WebElement CarouselNextButton;

    @FindBy( id="lbl_itemAttributes" )
    public WebElement ItemAttributesTitle;

    @FindBy( id="lbl_attrName_0" )
    public WebElement ItemManufacturerNameLabel;

    @FindBy( id="lbl_attrValue_0" )
    public WebElement FirstItemAttributeValue;

    @FindBy( xpath="//th[starts-with(@id,'attrName_1_')]" )
    public List<WebElement> AddInfoNames;

    @FindBy( id="attrName_1_0" )
    public WebElement FirstAddInfoName;

    @FindBy(xpath = "//div[normalize-space(text())='My lists']/..//a")
    public WebElement firstList;

    @FindBy( id="lbl_attrName_1" )
    public WebElement SecondItemAttributeName;

    @FindBy( xpath="//td[starts-with(@id,'attrValue_1_')]" )
    public List<WebElement> AddInfoValues;

    @FindBy( id="lbl_attrValue_0" )
    public WebElement FirstAddInfoValue;

    @FindBy( id="lbl_attrValue_1" )
    public WebElement SecondItemAttributeValue;

    @FindBy( xpath="//td[starts-with(@id,'pdf_icon_')]" )
    public List<WebElement> LinkedMediaIcon;

    @FindBy( xpath="//td[starts-with(@name,'linked_media_')]" )
    public List<WebElement> LinkedMediaName;

    // Main details
    @FindBy( id="lbl_displayName" )
    public WebElement ItemName;

    @FindBy( id="lbl_supplierName" )
    public WebElement Supplier;

    @FindBy( id="lbl_itemId" )
    public WebElement ItemIdLabel;

    @FindBy( id="lbl_sku" )
    public WebElement ItemId;

    @FindBy( id="lbl_uom" )
    public WebElement OrderUnitLabel;

    @FindBy( id="lbl_uomValue" )
    public WebElement OrderUnit;

    @FindBy( id="lbl_purchaseIncrement" )
    public WebElement IncrementLabel;

    @FindBy( id="lbl_purchaseIncrementValue" )
    public WebElement Increment;

    @FindBy( id="lbl_priceBreaks" )
    public WebElement PriceBreaksLabel;

    @FindBy(id="lbl_productQuantity_0" )
    public List<WebElement> PriceBreakQuantity;

    @FindBy( id="lbl_productQuantity_0" )
    public WebElement FirstPriceBreakQuantity;

    @FindBy( id="lbl_productQuantity_1" )
    public WebElement SecondPriceBreakQuantity;

    @FindBy( id="lbl_productQuantity_0" )
    public List<WebElement> PriceBreakValues;

    @FindBy( xpath="//div[@id='lbl_priceBreakRow_0']//div//pmmp-currency-view" )
    public WebElement FirstPriceBreakValue;

    @FindBy( id="priceAmount_1" )
    public WebElement SecondPriceBreakValue;

    @FindBy( id="lbl_contractRef" )
    public WebElement ContractReferenceLabel;

    @FindBy( id="lbl_contractRef_val" )
    public WebElement ContractReference;

    @FindBy( id="deliveryLabel" )
    public WebElement DeliveryLabel;

    @FindBy( id="deliveryData" )
    public WebElement Delivery;

    @FindBy( id="quantityLabel_0" )
    public WebElement QuantityLabel;

    @FindBy( name="input_quantity" )
    public WebElement Quantity;


    @FindBy( id="btn_addToCart" )
    public WebElement AddToBasketButton;

    @FindBy( xpath="//span[starts-with(@name,'updateButton_')]/input" )
    public WebElement UpdateBasketQtyButton;

    @FindBy( xpath="//a[starts-with(@name,'removeButton_')]" )
    public WebElement RemoveFromBasketButton;

    @FindBy( id="minQuantityIncrementLabel_0" )
    public WebElement MinIncrLabel;

    @FindBy( id="minQuantityIncrementData_0" )
    public WebElement MinIncr;

    @FindBy( id="lnk_lists" )
    public WebElement AddToListButton;

    @FindBy( id="lnk_compare" )
    public WebElement AddToComparisonButton;


    @FindBy( id="lbl_description" )
    public WebElement DescriptionLabel;

    @FindBy( id="lbl_descriptionVal" )
    public WebElement Description;


    // Modal Select List Pop-up area
    @FindBy( id="modal_title" )
    public WebElement ModalTitle;

    @FindBy( id="closeModalButton" )
    public WebElement ModalCloseButton;

    @FindBy( xpath="//div[@id='shoppingListModal']//a[starts-with(@name,'list_')]" )
    public List<WebElement> ModalLists;

    @FindBy( id="userList_0" )
    public WebElement ModalFirstList;

    @FindBy( name="list_1" )
    public WebElement ModalSecondList;

    @FindBy( id="cancelModalButton" )
    public WebElement ModalCancelButton;

    @FindBy(xpath = "//*[@id='itemDetail_fullScreen']/div/div[2]/div/div/div[3]/div/div[1]")
    public WebElement stockInformation;

    @FindBy(id="lnk_lists")
    public WebElement selectSuppliersButton;

    @FindBy(id="btn_getQuotes")
    private WebElement getQuotesButton;



    protected static Logger LOGGER = Logger.getLogger( ItemDetailsPage.class );

    public ItemDetailsPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return getBaseUrl() + "/ui/shopping/itemview"; }

    public String getExpectedTitle()
    {
        return ": Item Details";
    }

    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "FirstAddInfoName": return getTextOfWebElement( AddInfoNames.get(0) );
            case "FirstAddInfoValue": return getTextOfWebElement( AddInfoValues.get(0) );
            case "SecondAddInfoName": return getTextOfWebElement( AddInfoNames.get(1) );
            case "SecondAddInfoValue": return getTextOfWebElement( AddInfoValues.get(1) );
            case "Quantity": return getAttributeValueOfWebElement( Quantity, "value" );
            default: return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    public MarketplaceLandingPage clickHomeBreadcrumb() throws Exception
    {
        waitUntilDisplayed( HomeText );
        scrollToElement( HomeText );  // click sometimes doesn't work if the element is scrolled out of sight
        HomeText.click();
        return new MarketplaceLandingPage();
    }

    public ShoppingListsPage clickListsButton() throws Exception
    {
        waitUntilDisplayed( ListsIcon );
        scrollToElement( ListsIcon );  // click sometimes doesn't work if the element is scrolled out of sight
        ListsIcon.click();
        waitUntillElementIsClickableAndClick(firstList);
        return new ShoppingListsPage();
    }

    public ItemComparisonPage clickCompareButton() throws Exception
    {
        waitUntilDisplayed( CompareIcon );
        waitUntillElementIsClickableAndClick(CompareIcon);
        return new ItemComparisonPage();
    }

    public ShoppingBasketPage clickBasketButton() throws Exception
    {
        waitUntilDisplayed( ItemsInTheBasket );
        scrollToElement( BasketIcon );  // click sometimes doesn't work if the element is scrolled out of sight
        BasketIcon.click();
        return new ShoppingBasketPage();
    }

    // Clicks the button.  (Use only when no page load or reload.)
    public void clickButton( String buttonName ) throws Exception
    {
        waitUntillElementIsClickableAndClick(getWebElementNamed( buttonName ));

    }

    public CreateRfqPage clickgetQuotes(){
        waitUntillElementIsClickableAndClick(getQuotesButton);
        return new CreateRfqPage();
    }

    public MarketplaceItemDirectoryPage selectSup(){
        waitUntillElementIsClickableAndClick(selectSuppliersButton);
        return  new MarketplaceItemDirectoryPage();
    }


    public MarketplaceSearchResultsPage clickBackToSearchResults() throws Exception
    {
        waitUntilDisplayed( BackLink );
        scrollToElement( BackLink );  // click sometimes doesn't work if the element is scrolled out of sight
        BackLink.click();
        return new MarketplaceSearchResultsPage();
    }

    public ShoppingListsPage clickBackToLists() throws Exception
    {
        waitUntilDisplayed( BackLink );
        scrollToElement( BackLink );  // click sometimes doesn't work if the element is scrolled out of sight
        BackLink.click();
        return new ShoppingListsPage();
    }

    // Clicks the link.  (Use only when no page load or reload.)
    public void clickLink( String linkName ) throws Exception
    {
//        waitUntilStale(getWebElementNamed(linkName));
        waitUntillElementIsClickableAndClick(getWebElementNamed(linkName));
    }

    public void clickListLink( String listElementName, String text ) throws Exception
    {
        switch( listElementName )
        {
            case "Modal lists": getElementByTextFromListOfElements( ModalLists, text ).click(); break;
            default: throw new Exception("List not recognised");
        }
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    public void selectItemAttribute(String dropdownOption,String dropDownName) throws Exception
    {
        selectDropdownOptionByText(getWebElementNamed(dropDownName),dropdownOption);

    }

    public void verifyStockDetails()
    {
        waitUntilDisplayed(stockInformation);
        stockInformation.isDisplayed();
    }

    public CreateRfqPage clickOnGetQuotes()
    {
        waitUntillElementIsClickableAndClick(getQuotesButton);
        return new CreateRfqPage();
    }



}
