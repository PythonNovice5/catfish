package com.basware.bttf.pages.product_manager.supplier.items;
// Created by Julian Sheppard on 21/07/2017

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectClassificationPage extends ProductManagerPage
{
    @FindBy( name="backToLink" )
    public WebElement BackToBreadcrumb;

    @FindBy( id="selectAClassificationTitle" )
    public WebElement PageTitle;

    @FindBy( id="categoryTypeLabel" )
    public WebElement ClassificationTypeLabel;

    @FindBy( id="category_type" )
    public WebElement ClassificationType;

    @FindBy( id="UNSPSCCodeLabel" )
    public WebElement UNSPSCCodeLabel;

    @FindBy( id="unspsc_number" )
    public WebElement UNSPSCCode;

    @FindBy( id="level1Category" )
    public WebElement Level1;

    @FindBy( id="level2Category" )
    public WebElement Level2;

    @FindBy( id="level3Category" )
    public WebElement Level3;

    @FindBy( id="level4Category" )
    public WebElement Level4;

    @FindBy( id="unspsc_number_feedback" )
    public WebElement ValidationMessage;

    @FindBy( name="cancelButton" )
    public WebElement CancelButton;

    @FindBy( id="saveChanges" )
    public WebElement SaveButton;


    protected static Logger LOGGER = Logger.getLogger( SelectClassificationPage.class.getName() );

    public SelectClassificationPage()
    {
        PageFactory.initElements( driver, this );
    }

    @Override
//    public String getExpectedUrl(){ return getBaseUrl() + "/products/category/add?unspsc=";  }
    public String getExpectedUrl(){ return getBaseUrl() + "/products/addProduct/index";  }
    @Override
//    public String getExpectedTitle(){ return "Product Manager: UNSPSC Selector"; }
    public String getExpectedTitle(){ return "Product Manager: Create Item"; }

    @FindBy(xpath = "//button[text()='Done']")
    public WebElement DoneClassificationBtn;
    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "UNSPSCCode": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            default: return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    // Clears and sets the text or value of the element
    public void enterValueIntoElement( String value, String elementName ) throws Exception
    {
        if(elementName.equals("UNSPSCCode"))
            setValueOfAJAXInteractiveWebElement( getWebElementNamed( elementName ), value );
        else
            setValueOfWebElement( getWebElementNamed( elementName ), value );
    }

    public CreateItemPage clickToExitToCreateItem( String elementName ) throws Exception
    {
        waitUntilDisplayed( getWebElementNamed( elementName ) );
        getWebElementNamed( elementName ).click();
        return new CreateItemPage();
    }

    public EditItemPage clickToExitToEditItem( String elementName ) throws Exception
    {
        waitUntilDisplayed( getWebElementNamed( elementName ) );
        getWebElementNamed( elementName ).click();
        return new EditItemPage();
    }

    // Clicks the button.  (Use only when not moving to another page.)
    public SelectClassificationPage clickButton( String buttonName ) throws Exception
    {
        waitUntillElementIsClickableAndClick(getWebElementNamed( buttonName ));
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
        return new SelectClassificationPage();
    }

    public SelectClassificationPage selectLevelDropdownOptionByText( String levelDropdownName, String dropdownOptionText ) throws Exception
    {
        selectDropdownOptionByText( getWebElementNamed( levelDropdownName ), dropdownOptionText );
        waitUntilAnyAJAXIsCompleted();
        return new SelectClassificationPage();
    }

}
