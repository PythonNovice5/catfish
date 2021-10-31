package com.basware.bttf.pages.shopping.marketplace;
// Created by Julian Sheppard on 15/03/2018

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.steps.bdd.glue.shopping.marketplace.MarketPlaceSearchResultsSteps;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ItemComparisonPage extends ShoppingPage
{
    // Page title area fields
    @FindBy( xpath="//span[text()='home']" )
    public WebElement HomeIcon;

    @FindBy(xpath = "//*[@id='basket']//*[contains(@id,'mat-badge')]")
    public WebElement BasketCount;

    @FindBy( xpath="//a[normalize-space(text())='Home']")
    public WebElement HomeText;

    @FindBy( name="backLinkButton" )
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

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='total']" )
    public WebElement BasketValue;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='amount']" )
    public WebElement BasketAmount;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='currency']" )
    public WebElement BasketCurrency;

    @FindBy(id="lnk_backToSearchResults")
    public WebElement BackToSearchResults;

    // Item Details
    @FindBy( xpath="//a[starts-with(@id,\"lnk_itemName_\")] " )
    public List<WebElement> ItemNames;

    @FindBy( id="lnk_itemName_0")
    public WebElement FirstItemName;

    @FindBy(xpath="//*[@id='lbl_description_val_readMore_0']//*[@title]")
    public WebElement FirstItemDesc;

    @FindBy( id="lnk_itemName_1")
    public WebElement SecondItemName;

    @FindBy(xpath="//td[normalize-space(text())='Item ID']")
    public WebElement ItemIDLabel;

    @FindBy(xpath = "//*[@id='lbl_itemId_0']//div")
    public WebElement ItemID;

    @FindBy(xpath="//td[normalize-space(text())='Manufacturer part ID']")
    public WebElement ManfPartIDLabel;

    @FindBy(xpath = "//*[@id='lbl_manufacturerPartIdVal_0']")
    public WebElement ManfPartID;

    @FindBy(xpath = "//*[@id='lbl_productQuantity_0_0']")
    public WebElement PriceBreakNumber;

    @FindBy(xpath = "//*[@id='lbl_deliveryPrice_0_0']")
    public WebElement Delivery;

    @FindBy(xpath = "//*[contains(@id,'btn_addToBasket_')]")
    public List<WebElement> AddToBasket;

    @FindBy(id="lbl_noItemToCompare")
    public WebElement NoItemsToCompare;

    @FindBy(xpath = "//a[starts-with(@id,'lnk_itemName_')]")
    public List<WebElement> ItemsToCompare;

    @FindBy(xpath = "//*[@id='lbl_displayAttr_MAN_NAME_val_0']")
    public WebElement ManfName;

    @FindBy(xpath = "//*[@id='lbl_displayAttr_MAN_PART_ID_val_0']")
    public WebElement ManProdID;

    @FindBy(id = "lbl_description_val")
    public WebElement Desc;

    @FindBy(xpath="//td[normalize-space(text())='Comparison Price']")
    public WebElement ComparisonPriceLable;

    @FindBy(xpath = "//*[@id='lbl_comparisonPrice']//..//span[contains(@class,'inserted')]")
    public WebElement ComparisonPrice;

    @FindBy(xpath="//td[normalize-space(text())='Price Breaks']")
    public WebElement PriceBreakLabel;

    @FindBy(xpath="//td[normalize-space(text())='Delivery']")
    public WebElement DeliveryLabel;

    @FindBy(xpath="//td[normalize-space(text())='Manufacturer name']")
    public WebElement ManfNameLabel;

    @FindBy(xpath="//div[@class='table-body-only']//td[normalize-space(text())='Manufacturer product ID']")
    public WebElement ManProdIDLabel;

    @FindBy(xpath="//div[@class='table-body-only']//td[normalize-space(text())='Description']")
    public WebElement DescLabel;

    @FindBy(xpath="//div[@class='table-headers-only']//*[contains(text(),'Add to basket')]")
    public WebElement AddToBasketButton;

    @FindBy(xpath="//div[@class='table-headers-only']//input[@title='Quantity']")
    public WebElement ItemQntyField;

    @FindBy(xpath="//div[@class='table-headers-only']//*[@id='txt_quantity_0']")
    public WebElement ItemQnty;

    @FindBy(xpath="//*[@id='lbl_supplierName']//div")
    public WebElement Supplier;

    @FindBy(xpath="//*[contains(text(),'close')]")
    public WebElement ItemRemoveCross;

    @FindBy(xpath="//div[@class='table-headers-only']//small[normalize-space(text())='Min:']")
    public WebElement MinLabel;

    @FindBy(xpath="//div[@class='table-headers-only']//small[normalize-space(text())='Incr:']")
    public WebElement IncrLabel;

    @FindBy(xpath="//div[@class='table-headers-only']//small[normalize-space(text())='Unit:']")
    public WebElement UnitLabel;


    @FindBy(id="btn_addToBasket_1")
    public WebElement addSecondItemToBasket;




    protected static Logger LOGGER = Logger.getLogger( ItemComparisonPage.class );

    public ItemComparisonPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/shopping/itemcompare/index";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Compare";      // <<<<<<<<<<<<<<<<<<<<<<< TEMPORARY UNTIL PAGE TITLE IS CORRECTED
    }

    public MarketplaceSearchResultsPage clickLink(String value) throws Exception{
        waitUntillElementIsClickableAndClick(getWebElementNamed("BackToSearchResults"));
        return new MarketplaceSearchResultsPage();
    }

    public ItemComparisonPage removeAllItems() throws Exception{
        int NumberOfItems= ItemsToCompare.size();
//        try {
//            NoItemsToCompare.isDisplayed();
//        }
//        catch (NoSuchElementException n){
//
//        }
//        while(!NoItemsToCompare.isDisplayed()){
        while(NumberOfItems>0){
            LOGGER.debug("Removing elements from Item Comparison Page - Item Number: "+ NumberOfItems);
            hoverToElement(ItemRemoveCross);
            waitUntillElementIsClickableAndClick(ItemRemoveCross);
            NumberOfItems = NumberOfItems -1;
        }
        Assert.assertTrue("Expected info message was not found!",getTextOfWebElement(NoItemsToCompare).contains("No item to compare"));
        LOGGER.debug("All Items removed from Comaprison page successfully!!");
        return new ItemComparisonPage();
    }

    public ItemComparisonPage clickBtn(int i){
        ItemID.click();
        waitUntillElementIsClickableAndClick(AddToBasket.get(i));
        return new ItemComparisonPage();
    }

    public ItemComparisonPage addSecondItem(){
        waitUntillElementIsClickableAndClick(addSecondItemToBasket);
        return new ItemComparisonPage();
    }

    public ProductManagerPage clickBtn(String value) throws Exception{
        waitUntillElementIsClickableAndClick(getWebElementNamed(value));
        return new ShoppingBasketPage();
    }

}
