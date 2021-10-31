package com.basware.bttf.pages.external;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.external.punchout.PunchOutTestToolCheckOutPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.catalogue_shopping.RequisitionPage;
import com.basware.bttf.pages.shopping.marketplace.EditBasketItemPage;
import com.basware.bttf.pages.shopping.marketplace.ItemComparisonPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPageJupiter;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPageJupiter;

import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ShoppingBasketPageJupiter extends ShoppingPage
{
    // Page title area fields
//    @FindBy( xpath="//span[text()='You have no items in your shopping basket.']")
    @FindBy(xpath="//span[normalize-space(text())='You have no items in your shopping basket']|//span[normalize-space(text())='You have no items in your shopping basket.']")
    public WebElement HeaderAlertMessage;

    @FindBy( xpath="//span[contains(text(),'Supplier Total:')]//..//span[@name='currency']" )
    public List<WebElement> SummarySupplierShoppingBasketTotalCurrencys;

    @FindBy(xpath = "//*[@id='basket']//*[contains(@id,'mat-badge')]")
    public WebElement BasketCount;

    @FindBy(xpath = "//div[@class='item-price']//..//span[@name='amount']")
    public WebElement FirstItemPriceWithoutTax;

    @FindBy( name="closeAlertButton" )
    public WebElement HeaderAlertMessageClose;

    @FindBy( xpath="//span[text()='home']" )
    public WebElement HomeIcon;

    @FindBy(xpath="//a[normalize-space(text())='Home']")
    public WebElement HomeText;

    @FindBy(xpath = "//a[normalize-space(text())='Back to Search Results']")
    public WebElement BackLink;

    @FindBy(xpath = "//div[contains(@class,'page-title')]")
    public WebElement PageTitle;

//    @FindBy( name="emptyBasketButton" )
//    public WebElement EmptyBasketButton;

    @FindBy(xpath="//button[normalize-space(text())='Clear Basket']")
    public WebElement EmptyBasketButton;

    @FindBy( xpath = "//button[normalize-space(text())='Checkout']")
    public WebElement CheckoutButton;

    // Supplier headers
    @FindBy( xpath="//div[starts-with(@id,'supplier')]//div[starts-with(@id,'lbl_supplier_name_')]" )
    public List<WebElement> SupplierNames;

    @FindBy( id="lbl_supplier_name_0" )
    public WebElement FirstSupplierName;

    @FindBy( xpath="//*[@id='basket_total']//*[@name='amount']" )
    public WebElement FirstSupplierAmount;

    @FindBy( xpath="//*[@id='basket_total']//*[@name='currency']" )
    public WebElement FirstSupplierCurrency;

    // Item Details
    @FindBy( xpath="//a[@id='lbl_title']" )
    public List<WebElement> ItemNames;

    @FindBy( xpath="//div[@id='standardValues_0']//img[@id='basketItem_displayImage']" )
    public WebElement FirstItemImage;

    @FindBy( xpath="//div[@id='standardValues_0']//a[@id='lbl_title']" )
    public WebElement FirstItemName;

    @FindBy( xpath="//div[@id='standardValues_0']//div[@id='lbl_supplierPartId']" )
    public WebElement FirstItemItemIDLabel;

    @FindBy( id="lbl_supplierPartId_acc" )
    public WebElement FirstItemItemID;

    @FindBy( xpath="//span[starts-with(@id,'priceLabel_')]" )
    public WebElement FirstItemPriceLabel;

    @FindBy(css = "[id='lbl_basketItem_price']")
    public WebElement FirstItemPrice;

    @FindBy( xpath="//span[starts-with(@id,'priceDetails_')]" )
    public WebElement FirstItemPriceCurrencyUnit;

    @FindBy( xpath="//span[starts-with(@id,'contractReferenceLabel_')]" )
    public WebElement FirstItemContractReferenceLabel;

    @FindBy( xpath="//span[starts-with(@id,'contractReferenceDetails_')]" )
    public WebElement FirstItemContractReference;

    @FindBy( xpath="//span[starts-with(@id,'descriptionLabel_')]" )
    public WebElement FirstItemDescriptionLabel;

    @FindBy( xpath="//span[starts-with(@id,'descriptionDetails_')]" )
    public WebElement FirstItemDescription;

    @FindBy( xpath="//div[@class='basketItem-row']/div/div[2]/div[2]//span[@name='amount']" )
    public WebElement FirstItemItemTotalAmount;

    @FindBy( xpath="//div[@class='basketItem-row']/div/div[2]/div[2]//span[@name='currency']" )
    public WebElement FirstItemItemTotalCurrency;

    @FindBy( xpath="//label[starts-with(@id,'quantityLabel_')]" )
    public WebElement FirstItemQuantityLabel;

    @FindBy( xpath="//input[@name='quantity']" )
    public WebElement FirstItemQuantity;

    //    @FindBy( xpath="//button[@title=\"Update quantity\"]" ) locator changed 21-3-2021
    @FindBy(id="btn_updateQuantity")
    public WebElement FirstItemUpdateBasketQtyButton;

    @FindBy( xpath="//button[@title=\"Remove from basket\"]" )
    public WebElement FirstItemRemoveFromBasketButton;

    // Delivery Group fields
    @FindBy( xpath="//span[starts-with(@id,'deliveryGroupLabel_')]" )
    public List<WebElement> DeliveryGroupLabels;

    @FindBy( name="itemComparisonButtonIcon" )
    public WebElement CompareIcon;

    @FindBy( xpath="//span[starts-with(@id,'deliveryGroupLabel_')]" )
    public WebElement FirstDeliveryGroupLabel;

    @FindBy( xpath="//span[starts-with(@id,'deliveryGroupDeliveryItemType_')]" )
    public WebElement FirstDeliveryGroupType;

    @FindBy( xpath="//span[starts-with(@id,'deliveryGroupDeliveryNetTotal_')]" )
    public WebElement FirstDeliveryGroupAmount;

    // Summary fields
    @FindBy( id="summaryLabel" )
    public WebElement SummaryTitle;

    @FindBy( id="summaryTotalLabel" )
    public WebElement SummaryTotalLabel;

    @FindBy(css="[id='summary_total']")
    public WebElement SummaryTotalAmount;

    @FindBy( name="currency" )
    public WebElement SummaryTotalAmountCurrency;

    @FindBy( xpath="//span[starts-with(@id,'summarySupplierName_')]" )
    public List<WebElement> SummarySupplierNames;

    @FindBy( xpath="//span[contains(text(),'Supplier Total:')]//..//span[@name='amount']" )
    public List<WebElement> SummarySupplierItemTotalAmounts;

    @FindBy( xpath="//span[starts-with(@id,'summarySupplierItemTotalDetail_')]/span[@name='currency']" )
    public List<WebElement> SummarySupplierItemTotalCurrencys;

    @FindBy( xpath="//span[starts-with(@id,'summarySupplierDeliveryTotalDetail_')]/span[@name='amount']" )
    public List<WebElement> SummarySupplierDeliveryTotalAmounts;

    @FindBy( xpath="//span[starts-with(@id,'summarySupplierDeliveryTotalDetail_')]/span[@name='currency']" )
    public List<WebElement> SummarySupplierDeliveryTotalCurrencys;

    @FindBy( xpath="//span[starts-with(@id,'summarySupplierShoppingBasketTotalDetail_')]/span[@name='amount']" )
    public List<WebElement> SummarySupplierShoppingBasketTotalAmounts;

    @FindBy(id="lbl_supplierPartId")
    public WebElement PORItem;

    @FindBy(xpath="//span[text()='CatFishSupIDNew1234']//..//..//..//..//..//input[@name='quantity']")
    public WebElement CatfishITEMLatestforTestingQuantity;

    @FindBy(id="lbl_supplierPartId_acc")
    public WebElement ItemID;

    // Modal Confirmation
    // WARNING! driver.findElement(By.name()) does not work in modal pop-up (chromedriver bug) - use By.id or By.xpath
    @FindBy( id="app-dialog-confirm" )
    public WebElement ModalEmptyBasketOKButton;

    @FindBy( xpath="//div[@id='empyBasketConfirmation']//div[@class='modal-footer']/button" )
    public WebElement ModalEmptyBasketCancelButton;

    @FindBy( xpath="//strong[text()='CatfishITEMLatestforTesting']//..//..//..//..//..//..//button[starts-with(@id,'updateButton_')]" )
    public WebElement UpdateCatfishItemQuantity;

    @FindBy( xpath="//strong[text()='CatfishITEMLatestforTesting']//..//..//..//..//..//..//input[contains(@id,'quantity_')]" )
    public WebElement CatfishItemQuantity;

    @FindBy( xpath="//strong[text()='CatfishITEMLatestforTesting']//..//..//..//..//..//..//span[@title='Remove']" )
    public WebElement RemoveCatfishItem;

    @FindBy(xpath = "//div//strong[text()='Item is unavailable']//..//..//..//span[@title='Remove']")
    public WebElement RemoveUnavailableItem;

    @FindBy(id="lbl_customization")
    public WebElement customisationButton;

    @FindBy(id="templateFields")
    public WebElement templateFields;

    //Checkout form
    @FindBy(id = "txt_question_0")
    public WebElement firstQuestionInput;

    @FindBy(id= "txt_question_1" )
    public WebElement secondQuestionInput;

    @FindBy(id= "txt_question_2")
    public WebElement thirdQuestionInput;

    @FindBy(xpath= "//*[contains(@aria-label,'20, ')]")
    public WebElement selectDate;

    @FindBy(id = "btn_submit")
    public WebElement submitCheckoutForm;

    @FindBy(id="lbl_itemNotFullfilledByAmazon")
    public WebElement itemAvailabilityAlert;

    @FindBy( id = "btn_checkout")
    public WebElement CheckoutInternalSite;

    protected static Logger LOGGER = Logger.getLogger( ShoppingBasketPageJupiter.class );

    public ShoppingBasketPageJupiter()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return "https://jupiter-buyers.procserveonline.com" + "/ui/shopping/shoppingbasket";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Basket";
    }

    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "FirstItemQuantity": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "SummaryFirstSupplierItemTotalAmount": return getTextOfWebElement(getWebElementListNamed( "SummarySupplierItemTotalAmounts" ).get(0));
            case "SummaryFirstSupplierDeliveryTotalAmount": return getTextOfWebElement(getWebElementListNamed( "SummarySupplierDeliveryTotalAmounts" ).get(0));
            case "SummaryFirstSupplierShoppingBasketTotalAmount": return getTextOfWebElement(getWebElementListNamed( "SummarySupplierShoppingBasketTotalAmounts" ).get(0));
            case "SummaryFirstSupplierShoppingBasketCurrency": return getTextOfWebElement(getWebElementListNamed( "SummarySupplierShoppingBasketTotalCurrencys" ).get(0));
            case "CatfishItemQuantity":return getAttributeValueOfWebElement(getWebElementNamed(elementName),"value");
            default: return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    // Clicks the button.  (Use only when no page load or reload.)
    public void clickButton( String buttonName ) throws Exception
    {
        clickWebElement( getWebElementNamed( buttonName ) );
    }

    public ItemComparisonPage clickOnElement(String value) throws Exception{
        waitUntillElementIsClickableAndClick(CompareIcon);
        return new ItemComparisonPage();
    }

    public MarketplaceLandingPage clickHomeBreadcrumb() throws Exception
    {
        waitUntilDisplayed( HomeText );
        scrollToElement( HomeText );  // click sometimes doesn't work if the element is scrolled out of sight
        HomeText.click();
        return new MarketplaceLandingPage();
    }

    public MarketplaceSearchResultsPageJupiter clickBackLinkBreadcrumb() throws Exception
    {
        waitUntilDisplayed( BackLink );
        scrollToElement( BackLink );  // click sometimes doesn't work if the element is scrolled out of sight
        waitUntillElementIsClickableAndClick(BackLink);
        return new MarketplaceSearchResultsPageJupiter();
    }

    public EditBasketItemPage clickFirstItemNameLink() throws Exception
    {
        waitUntilDisplayed( FirstItemName );
        FirstItemName.click();
        return new EditBasketItemPage();
    }

    public RequisitionPage clickCheckoutButton() throws Exception
    {
        waitUntilDisplayed( CheckoutButton );
        CheckoutButton.click();
        return new RequisitionPage();
    }

    public PunchOutTestToolCheckOutPage clickOnCheckButton()
    {
        waitUntilDisplayed( CheckoutButton );
        CheckoutButton.click();
        return new PunchOutTestToolCheckOutPage();
    }

    public ShoppingBasketPage clickCheckoutInternalSite(){
        waitUntillElementIsClickableAndClick(CheckoutInternalSite);
        return new ShoppingBasketPage();

    }

    public ItemComparisonPage clickCompareItems(){
        waitUntillElementIsClickableAndClick(CompareIcon);
        return new ItemComparisonPage();
    }
    // Use this to click a button or link that causes the same page be re-loaded
    public ShoppingBasketPageJupiter clickPageReloadingElement(String elementName ) throws Exception
    {
        WebElement element;
        switch (elementName)
        {
            // first item buttons:
            case "first item UpdateBasketQty": element = FirstItemUpdateBasketQtyButton; break;
            case "first item RemoveFromBasket": element = FirstItemRemoveFromBasketButton; break;
            case "UpdateCatfishItemQuantity":element=UpdateCatfishItemQuantity;break;
            case "RemoveCatfishItem":element=RemoveCatfishItem;break;
            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        return new ShoppingBasketPageJupiter();
    }

    // Use this to click a button or link that causes the same page be refreshed
    public void clickPageRefreshingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // first item buttons:
            case "first item UpdateBasketQty": element = FirstItemUpdateBasketQtyButton; break;
            case "first item RemoveFromBasket": element = FirstItemRemoveFromBasketButton; break;

            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        waitUntilPageDocumentIsCompleted();
    }

    public void clickModalAlertOKButton() throws Exception
    {
        try {
            clickModalAlertButton("accept");
        }
        catch (Exception e) {
            throw new Exception (e.getMessage());
        }
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    public void clickModalAlertCancelButton() throws Exception
    {
        try {
            clickModalAlertButton("dismiss");
        }
        catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }

    public ShoppingBasketPageJupiter checkStatus(String elem) throws Exception{
        Assert.assertTrue(getTextOfWebElement(PORItem).contains(elem));
        LOGGER.debug("POR item found in the shopping basket with id - "+elem);
        return new ShoppingBasketPageJupiter();
    }

    // Empties the shopping basket, if it is not already empty
    public void emptyTheBasket() throws Exception
    {
        // Check if the yellow alert band ('You have no items in your shopping basket') is or is not displayed
        pauseFor(2000);
        if (elementIsNotDisplayed( "HeaderAlertMessage" ) )
        {
            // Need to empty the basket
            EmptyBasketButton.click();
            LOGGER.debug( "Shopping Basket Page ... emptying the shopping basket" + "\n");
            // going into modal popup
            waitUntilModalPopupDisplayed();
            // WARNING! driver.findElement(By.name()) does not work in modal pop-up (chromedriver bug) - use By.id or By.xpath
            clickWebElement(ModalEmptyBasketOKButton);
            waitUntilNoModalPopup();
            // now out of modal popup
            waitUntilAnyAJAXIsCompleted();
            waitUntilPageDocumentIsCompleted();
        }
        else LOGGER.debug( "Shopping Basket Page ... shopping basket is empty" + "\n");
        pauseFor(2000);
    }

    // log state as debug messages
    public void logTheStateOfElement( String elementName, int noOfTimes ) throws Exception
    {
        for(int i=0; i<noOfTimes; i++)
        {
            if(elementName.equals("Quantity"))
            {
                WebElement webElement = getWebElementNamed( "FirstItemQuantity" );
                LOGGER.debug("----- State of " + elementName + ": Stale=" + isWebElementStale( webElement ) + " Value=" + webElement.getAttribute("value").trim() );
            }
            else
            {
                WebElement webElement = getWebElementNamed( elementName );
                LOGGER.debug("----- State of " + elementName + ": Stale=" + isWebElementStale( webElement ) + " Text=" + webElement.getText().trim() );
            }
        }
    }

    public ShoppingBasketPageJupiter checkAvailability(String prod){
        String alert = driver.findElement(By.xpath(String.format("//strong[text()='%s']//..//..//..//..//span[@name='alertMessageDetail']",prod))).getText();
        Assert.assertTrue(alert.contains("Only items fulfilled by Amazon are available"));
        LOGGER.debug("Items not fullfulled by Amazon were not available in Basket ..");
        return new ShoppingBasketPageJupiter();
    }

    public ShoppingBasketPageJupiter removeUnavailableItem(){
        RemoveUnavailableItem.click();
        return new ShoppingBasketPageJupiter();
    }
}
