package com.basware.bttf.pages.product_manager.supplier.items;
// Created by Julian Sheppard on 21/07/2017
// For both 'Select Image from Media Directory' and 'Select PDF from Media Directory'

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectMediaPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( SelectMediaPage.class.getName() );


    @FindBy( xpath="//div[contains(text(),'catfish001.jpg')]" )
    public WebElement CatfishMedia;

    // Page title area fields
    @FindBy( name="closebutton")
    public WebElement PageClose;

    @FindBy( id="selectMediaTitle" )
    public WebElement PageTitle;

    @FindBy( name="procserveaction_save" )
    public WebElement AddItemsButton;

    // Page search bar fields
    @FindBy( id="keywords" )
    public WebElement SearchKeywords;

    @FindBy( id="removeSearchButton" )
    public WebElement SearchClearButton;

    @FindBy( name="btn-search")
    public WebElement SearchButton;

    // Order By
    @FindBy( name="btn-sortBy" )
    public WebElement OrderByDropdown;

    @FindBy( name="relevance" )
    public WebElement OrderByRelevance;

    @FindBy( name="filename" )
    public WebElement OrderByFileName;

    @FindBy( name="title" )
    public WebElement OrderByTitle;

    @FindBy( name="caption" )
    public WebElement OrderByCaption;

    @FindBy( name="created" )
    public WebElement OrderByCreationDate;

    // Results displayed summary
    @FindBy( id="resultsShown_1" )
    public WebElement ResultsShown;

    // Thumbnails
    @FindBy( xpath="//a[starts-with(@name,'file_')]" )
    public List<WebElement> Thumbnails;

    @FindBy( name="file_0" )
    public WebElement FirstThumbnail;

    // Pagination
    @FindBy( xpath="//*[@name='previousPage_1' or @id='previousPage_1']" )
    public WebElement PreviousPageTopButton;

    @FindBy( xpath="//*[@name='nextPage_1' or @id='nextPage_1']" )
    public WebElement NextPageTopButton;


    public SelectMediaPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/addMedia";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Select Item ";
    }   // '... Item Image' or '... Item PDF'

    // Clicks the button.  (Use only when not moving to another page.)
    public void clickButton( String buttonName ) throws Exception
    {
        clickWebElement(getWebElementNamed( buttonName ));
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    // Use this to click a button or link that causes the same page be re-loaded
    public SelectMediaPage clickPageReloadingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "Search": element = SearchButton; break;
            case "SearchClear": element = SearchClearButton; break;
            case "PreviousPage": element = PreviousPageTopButton; break;
            case "NextPage": element = NextPageTopButton; break;
            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        return new SelectMediaPage();
    }

    public void clickThumbnail( Integer thumbnailIndex ) throws Exception
    {
        waitUntillElementIsClickableAndClick( Thumbnails.get(thumbnailIndex) );
        // This page uses AJAX to refresh
        waitUntilAnyAJAXIsCompleted();
    }

    public CreateItemPage clickToExitToCreateItem( String elementName ) throws Exception
    {
        WebElement exitElement = getWebElementNamed( elementName );
        waitUntilDisplayed( exitElement );
        scrollToElement( exitElement );  // click sometimes doesn't work if the element is scrolled out of sight
        exitElement.click();
        return new CreateItemPage();
    }

    public EditItemPage clickToExitToEditItem( String elementName ) throws Exception
    {
        WebElement exitElement = getWebElementNamed( elementName );
        waitUntilDisplayed( exitElement );
        scrollToElement( exitElement );  // click sometimes doesn't work if the element is scrolled out of sight
        exitElement.click();
        return new EditItemPage();
    }

    public SelectMediaPage selectOrderBy( String dropdownOption ) throws RuntimeException
    {
        clickWebElement(OrderByDropdown);
        WebElement optionElement;
        switch( dropdownOption )
        {
            case "Relevance"  : optionElement = OrderByRelevance; break;
            case "File Name"  : optionElement = OrderByFileName; break;
            case "Title"  : optionElement = OrderByTitle; break;
            case "Caption"  : optionElement = OrderByCaption; break;
            case "Creation date"  : optionElement = OrderByCreationDate; break;
            default: throw new RuntimeException( "Couldn't find a matching Order by dropdown option" );
        }
        clickWebElement( optionElement );
        return new SelectMediaPage();
    }
}
