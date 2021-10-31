package com.basware.bttf.pages.shopping.marketplace;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShoppingListsPage extends ShoppingPage
{
    // Page title area fields
    @FindBy( xpath="//span[text()='home']" )
    public WebElement HomeIcon;

    @FindBy(xpath = "//div[contains(@class,'mat-dialog-title') and contains(text(),'Item Options')]")
    public WebElement ItemOptions;

    @FindBy(id = "btn_submit")
    public WebElement AddInformation;

    @FindBy(id = "txt_quantity_0")
    public WebElement CatfishLabel1;

    @FindBy(id = "txtArr_1")
    public WebElement CatfishLabel2;

    @FindBy( xpath="//a[normalize-space(text())='Home']")
    public WebElement HomeText;

    @FindBy( name="backLinkButton" )
    public WebElement BackToSearchResults;

    //    @FindBy( id="page-page-title" )
    @FindBy(xpath = "//div[@class= \"bold text-large page-title\"]")
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

    @FindBy( name="comparisonBadge" )
    public WebElement CompareCount;

    @FindBy( name="basketButtonIcon" )
    public WebElement BasketIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement BasketText;

    @FindBy( name="itemCount" )
    public WebElement BasketCount;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='total']" )
    public WebElement BasketValue;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='amount']" )
    public WebElement BasketAmount;

    @FindBy( xpath="//div[@id='marketPLaceBasketSummary']//span[@name='currency']" )
    public WebElement BasketCurrency;

    @FindBy(xpath = "//*[@name='add-to-basket-button']")
    public WebElement addToBasket;

    // Header bar fields
    @FindBy( xpath="//div[contains(@id,'userList_Row_')]" )
    public WebElement ListName;

    @FindBy( xpath = "//span[contains(@class,'edit')]")
    public WebElement RenameListButton;

    @FindBy(xpath="//a[starts-with(@id,'userListBtn_Delete_')]")
    public WebElement DeleteListButton;

    @FindBy( id="buyAllAction" )
    public WebElement BuyAllButton;

    // Order by
    @FindBy( id="orderByLabel" )
    public WebElement OrderByLabel;

    @FindBy( id="orderByButton" )
    public WebElement OrderByDropdown;

    @FindBy( name="NEWEST" )
    public WebElement OrderByDateNtoO;

    @FindBy( name="OLDEST" )
    public WebElement OrderByDateOtoN;

    @FindBy( name="NAME_ASC" )
    public WebElement OrderByNameAtoZ;

    @FindBy( name="SKU_ASC" )
    public WebElement OrderByItemIDAtoZ;

    // Items displayed summary and Pagination
    @FindBy( xpath="//div[normalize-space(text())='No items to show!']")
    public WebElement ShoppingListEmpty;

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

    // Item Details
    @FindBy( xpath="//a[starts-with(@name,'name_')]" )
    public List<WebElement> ItemNames;

    @FindBy( xpath="//input[@name='quantity']" )
    public List<WebElement> Quantitys;

    @FindBy( xpath="//span[starts-with(@name,'addButton_')]/input" )
    public List<WebElement> AddToBasketButtons;

    @FindBy( xpath="//a[starts-with(@name,'removeButton_')]" )
    public List<WebElement> RemoveFromBasketButtons;



    @FindBy( name="image_0" )
    public WebElement FirstItemImage;

    @FindBy( id="name_0" )
    public WebElement FirstItemName;

    @FindBy( id="supplierNameLabel_0" )
    public WebElement FirstItemSupplierNameLabel;

    @FindBy( id="supplierNameDetails_0" )
    public WebElement FirstItemSupplierName;

    @FindBy( id="supplierItemIDLabel_0" )
    public WebElement FirstItemItemIDLabel;

    @FindBy( id="supplierItemIDDetails_0" )
    public WebElement FirstItemItemID;

    @FindBy( id="contractReferenceLabel_0" )
    public WebElement FirstItemContractReferenceLabel;

    @FindBy( id="contractReferenceDetails_0" )
    public WebElement FirstItemContractReference;

    @FindBy( id="descriptionLabel_0" )
    public WebElement FirstItemDescriptionLabel;

    @FindBy( id="descriptionDetails_0" )
    public WebElement FirstItemDescription;

    @FindBy( id="priceDetails_0" )
    public WebElement FirstItemPriceCurrencyUnit;

    @FindBy( id="quantity-input" )
    public WebElement FirstItemQuantityLabel;

    @FindBy(id="quantity-input")
    public WebElement FirstItemQuantity;

    @FindBy( xpath="//button[starts-with(@name,'add-to-basket')]" )
    public WebElement FirstItemAddToBasketButton;

    @FindBy( name="update-in-list-button")
    public WebElement FirstItemUpdateQtyButton;

    @FindBy( xpath="remove-from-list-button" )
    public WebElement FirstItemRemoveFromBasketButton;

    @FindBy( xpath="//span[starts-with(@name,'compareButton_')]" )
    public WebElement FirstItemAddToCompareButton;

    @FindBy( name="remove-from-list-button")
    public WebElement FirstItemRemoveFromListButton;

    @FindBy( name="name_1" )
    public WebElement SecondItemName;

    // List Selection area
    @FindBy( id="lbl_myLists" )
    public WebElement MyListsLabel;

    @FindBy( id="btn_create" )
    public WebElement CreateButton;

    //    @FindBy( xpath="//a[starts-with(@name,'shoppingListsFilter_')]" )
    @FindBy( xpath = "//div[@id='myLists']//div[starts-with(@id,'userList_Row_')]")
    public List<WebElement> MyLists;

    @FindBy(xpath = "//div[@id='orgLists']/div[contains(text(),'Organisation lists')]")
    public WebElement OrganisationListsLabel;

    @FindBy( xpath="//div[starts-with(@id,'orgList_')]")
    public List<WebElement> OrganisationLists;


    // Modal Rename List Pop-up area
    // WARNING! driver.findElement(By.name()) does not work in modal pop-up (chromedriver bug) - use By.id or By.xpath

    @FindBy(id="mat-dialog-2")
    public WebElement ModalRenameTitle;

    @FindBy( id="icn_close" )
    public WebElement ModalRenameClose;

    @FindBy( xpath ="//div[@id='mat-dialog-title-2']//span[text()='Edit List']")
    public WebElement ModalRenameNameLabel;

    @FindBy( id="txt_listName" )
    public WebElement ModalRenameListName;

    @FindBy( id="myModalFormClose" )
    public WebElement ModalRenameCancelButton;

    @FindBy( xpath = "//button[normalize-space(text())='Save']")
    public WebElement ModalRenameSaveButton;

    // Modal Delete List Pop-up area
    @FindBy( xpath="//h2[contains(@id,'app-dialog-title') and text()='Delete']" )
    public WebElement ModalDeleteTitle;

    @FindBy( id="closeButtonDeleteListLabel" )
    public WebElement ModalDeleteCloseButton;

    @FindBy( xpath="//mat-dialog-content[contains(text(),\"Are you sure?\")]" )
    public WebElement ModalDeleteMessage;

    @FindBy( id="shoppingListNameDelete" )
    public WebElement ModalDeleteListName;

    @FindBy(xpath = "//*[contains(@id,'starIcon_')]")
    public List<WebElement> numberOfListElements;

    @FindBy(xpath ="//*[contains(@id,'starIcon_1')]" )
    public WebElement elementNum2;

    @FindBy( xpath="//button[normalize-space(text())='No']" )
    public WebElement ModalDeleteCancelButton;

    @FindBy( xpath="//button[normalize-space(text())='Yes']" )
    public WebElement ModalDeleteOKButton;

    // Modal Create New List Pop-up area
    @FindBy( id="mat-dialog-0" )
    public WebElement ModalCreateTitle;

    @FindBy( id="closeButtonNewListLabel" )
    public WebElement ModalCreateCloseButton;

    @FindBy( xpath="//span[@id='modal_title' and contains(text(),'Create List')]" )
    public WebElement ModalCreateNameLabel;

    @FindBy(  id="txt_listName" )
    public WebElement ModalCreateListName;

    @FindBy( id="btn_close" )
    public WebElement ModalCreateCancelButton;

    @FindBy( id="btn_submit" )
    public WebElement ModalCreateSaveButton;


    protected static Logger LOGGER = Logger.getLogger( ShoppingListsPage.class );

    public ShoppingListsPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return getBaseUrl() + "/ui/shopping/shoppinglist"; }

    public String getExpectedTitle()
    {
        return "Marketplace: Lists";
    }

    // Returns true when the element is present and displayed
    public boolean elementIsDisplayed( String elementName )
    {
        try {
            switch( elementName ) {
                case "First My List": waitUntilDisplayed( MyLists.get(0) ); break;
                case "First Organisation List": waitUntilDisplayed( OrganisationLists.get(0) ); break;
                default: waitUntilDisplayed( getWebElementNamed( elementName) );
            }
            return true;
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }

    // Returns true when the element is enabled (clickable)
    public boolean elementIsEnabled( String elementName )
    {
        try {
            return isWebElementEnabled( getWebElementNamed( elementName) );
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }

    // Returns true when the element has the readonly attribute
    public boolean elementIsReadOnly( String elementName )
    {
        try {
            switch( elementName ) {
                // By default, checks the readonly status of the element with the element name
                // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
//                case "List Name": return getWebElementListNamed( "AnotherName" ).size();
                default: return getAttributeValueOfWebElement( getWebElementNamed( elementName ), "readonly" ).equals( "true" );
            }
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }


    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "First My List": pauseFor(1000);return getTextOfWebElement( MyLists.get(0) );
            case "First Organisation List": return getTextOfWebElement( OrganisationLists.get(0) );
            case "FirstItemQuantity": return getAttributeValueOfWebElement( FirstItemQuantity, "value" );
            case "ModalRenameListName": return getAttributeValueOfWebElement( ModalRenameListName, "value" );

            default:
                LOGGER.debug("TEXT OF WEBELEMENT "+elementName+ ": "+getTextOfWebElement(getWebElementNamed(elementName)));
                return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    public void enterValueIntoQuantity( String value, String itemNameText ) throws Exception
    {
        setValueOfWebElement( getAssociatedElementFromListOfElements( Quantitys, ItemNames, itemNameText ), value );
    }

    // Clicks the button.  (Use only when not moving to another page.)
    public void clickButton( String buttonName ) throws Exception
    {
        clickWebElement(getWebElementNamed( buttonName ));
    }

    public MarketplaceLandingPage clickHomeBreadcrumb() throws Exception
    {
        waitUntilDisplayed( HomeText );
        scrollToElement( HomeText );  // click sometimes doesn't work if the element is scrolled out of sight
        HomeText.click();
        return new MarketplaceLandingPage();
    }

    public ShoppingBasketPage clickBasketButton() throws Exception
    {
        waitUntilDisplayed( BasketIcon );
        scrollToElement( BasketIcon );  // click sometimes doesn't work if the element is scrolled out of sight
        BasketIcon.click();
        return new ShoppingBasketPage();
    }

    public ShoppingBasketPage clickBuyAllButton() throws Exception
    {
        waitUntilDisplayed( BuyAllButton );
        scrollToElement( BuyAllButton );  // click sometimes doesn't work if the element is scrolled out of sight
        BuyAllButton.click();
        return new ShoppingBasketPage();
    }

    // Use this to click a button or link that causes the same page be re-loaded
    public ShoppingListsPage clickPageReloadingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "BuyAll": element = BuyAllButton; break;
            case "PreviousPageTop": element = PreviousPageTopButton; break;
            case "NextPageTop": element = NextPageTopButton; break;
            case "PreviousPageBottom": element = PreviousPageBottomButton; break;
            case "NextPageBottom": element = NextPageBottomButton; break;
            // first item buttons:
            case "first item AddToBasket": element = FirstItemAddToBasketButton; break;
            case "first item UpdateQty": element = FirstItemUpdateQtyButton; break;
            case "first item RemoveFromBasket": element = FirstItemRemoveFromBasketButton; break;
            case "first item RemoveFromList": element = FirstItemRemoveFromListButton; break;
            case "ModalCreateSaveButton":element = ModalCreateSaveButton;break;
            case "ModalRenameClose":element=ModalRenameClose;break;
            case "ModalRenameSave":element=ModalRenameSaveButton;break;
            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        return new ShoppingListsPage();
    }


    public ItemDetailsPage clickAnItemName( String itemNameText ) throws Exception
    {
        getElementByTextFromListOfElements( ItemNames, itemNameText ).click();
        return new ItemDetailsPage();
    }

    public void clickAnAddToBasketButton( String itemNameText ) throws Exception
    {
        getAssociatedElementFromListOfElements( AddToBasketButtons, ItemNames, itemNameText ).click();
    }

    public void clickARemoveFromBasketButton( String itemNameText ) throws Exception
    {
        getAssociatedElementFromListOfElements( RemoveFromBasketButtons, ItemNames, itemNameText ).click();
    }

    public void clickListSelection( String listElementName ) throws Exception
    {
        switch( listElementName )
        {
            case "First My List": waitUntillElementIsClickableAndClick(MyLists.get(0));break;
            case "First Organisation List": waitUntillElementIsClickableAndClick(OrganisationLists.get(0)); break;
            default: throw new Exception("List not recognised");
        }
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    public void clickListLink( String listElementName, String text ) throws Exception
    {
        switch( listElementName )
        {
            case "My lists": getElementByTextFromListOfElements( MyLists, text ).click(); break;
            case "Organisation lists": getElementByTextFromListOfElements( OrganisationLists, text ).click(); break;
            default: throw new Exception("List not recognised");
        }
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }


    public ShoppingListsPage selectPerPage(String dropdownOption ) throws RuntimeException
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
        return new ShoppingListsPage();
    }

    // Deletes a My List (Favourites) list if it exists
    public ShoppingListsPage removeAMyList( String listName ) throws Exception
    {
        String elementText;
        for( WebElement element: MyLists )
        {
            if(element.getText().trim().equals(listName))
            {
                LOGGER.debug( "----> Deleting My Lists list: " + listName + "\n");
                clickWebElement( element );
                clickWebElement( DeleteListButton );
                // going into modal popup
                waitUntilModalPopupDisplayed();
                // WARNING! driver.findElement(By.name()) does not work in modal pop-up (chromedriver bug) - use By.id or By.xpath
                clickWebElement( ModalDeleteOKButton );
                waitUntilNoModalPopup();
                // now out of modal popup
                waitUntilAnyAJAXIsCompleted();
                break;
            }
        }
        return new ShoppingListsPage();
    }

    // Empties the My Lists (Favourites) lists if not already empty
    public void emptyTheMyListsLists() throws Exception
    {
        WebElement lastMyList;
        int deletedListCount = 0;
        int deletedItemCount = 0;

        waitUntilDisplayed( PageTitle );
//        waitUntilListOfWebElementsDisplayed(MyLists);
        // while there is more than one My List
        List<WebElement> MyLists = driver.findElements(By.xpath("//div[@id='myLists']//div[starts-with(@id,'userList_Row_')]"));
        while ( MyLists.size() > 1 )
        {
            lastMyList = MyLists.get( MyLists.size()-1) ;   // the last in the list
            LOGGER.debug( "----> Deleting My Lists list: " + getTextOfWebElement( lastMyList ) + "\n");
            waitUntillElementIsClickableAndClick(lastMyList);
            waitUntillElementIsClickableAndClick(DeleteListButton);
            // going into modal popup
            waitUntilModalPopupDisplayed();
            // WARNING! driver.findElement(By.name()) does not work in modal pop-up (chromedriver bug) - use By.id or By.xpath
            clickWebElement( ModalDeleteOKButton );
            waitUntilNoModalPopup();
            // now out of modal popup
            waitUntilAnyAJAXIsCompleted();
            deletedListCount++;
        }
        if ( deletedListCount > 0 )
            LOGGER.debug( "----> My Lists: " + deletedListCount + " list(s) deleted" + "\n");

        // Make sure we have the first My List items displayed.
        clickListSelection("First My List" );
        pauseFor(5000);
        if (elementIsNotDisplayed( "ShoppingListEmpty"))
        {
            // Now we are going to delete all items in the list.
            LOGGER.debug( "----> Deleting items from first My List: " + ListName.getText() + "\n");
            // while the empty list message is not displayed (i.e. while an item is displayed)
            while (elementIsNotDisplayed("ShoppingListEmpty"))
            {
                waitUntilDisplayed(FirstItemRemoveFromListButton);
                FirstItemRemoveFromListButton.click();
                pauseFor(1000);
                waitUntilAnyAJAXIsCompleted();
                deletedItemCount++;
            }
            if (deletedItemCount > 0)
                LOGGER.debug("----> My Lists " + deletedItemCount + " item(s) deleted from first My List" + "\n");
        }

        // Note that the first My List is now being displayed because we have deleted any others.
        // If necessary, rename the first list as 'Favourites'

        if ( !getTextOfWebElement(ListName).equals( "Favourites" ) )
        {
            LOGGER.debug( "----> Renaming " + ListName.getText() + " as 'Favourites'" + "\n");
            clickWebElement( RenameListButton );
            // going into modal popup
            waitUntilModalPopupDisplayed();
            enterValueIntoElement("Favourites", "ModalRenameListName" );
            waitUntilModalPopupDisplayed();
            clickWebElement( ModalRenameSaveButton );
            waitUntilNoModalPopup();
            // now out of modal popup
            LOGGER.debug( "----> My Lists first list renamed as 'Favourites'" + "\n");
            waitUntilAnyAJAXIsCompleted();
        }
        LOGGER.debug( "----> My Lists is now 'empty'" + "\n");
    }
    public ShoppingListsPage verifyNumOfListElemets() throws Exception{

        String text= " ";
        waitUntilDisplayed(elementNum2);
        scrollToElement(elementNum2);
        int num = numberOfListElements.size();

        text = Integer.toString(num);
        LOGGER.debug("Num of elem:"+text);
        assertEquals("Found 4 items in the list",text,"4");
        return  new ShoppingListsPage();
    }

    public WebElement getWebElement(String elem) throws Exception{

        return getWebElementNamed(elem);

    }
}
