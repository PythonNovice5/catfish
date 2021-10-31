package com.basware.bttf.pages.shopping.catalogue_shopping;

import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.notifications.ShoppingNotificationsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class RequisitionPage extends ShoppingPage
{
    // Page title area fields
    @FindBy( id="catalogueShoppingLabel" )
    public WebElement PageTitle;

    @FindBy( id="catalogueShoppingReferenceNumber" )
    public WebElement RequisitionNumber;

    @FindBy( id="catalogueShoppingStatus" )
    public WebElement RequisitionStatus;

    // Details fields
    @FindBy( id="fieldsetDetailsLabel" )
    public WebElement DetailsLabel;

    @FindBy( id="control_group_description_Label" )
    public WebElement YourReferenceLabel;

    @FindBy( id="description" )
    public WebElement YourReference;

    @FindBy( id="control_group_targetDeliveryDate_Label" )
    public WebElement TargetDeliveryDateLabel;

    @FindBy( id="targetDeliveryDate" )
    public WebElement TargetDeliveryDate;

    @FindBy( id="control_group_specialInstructions_Label" )
    public WebElement SpecialInstructionsLabel;

    @FindBy( id="specialInstructions" )
    public WebElement SpecialInstructions;

    @FindBy( id="shipTo.contactLabel" )
    public WebElement DeliverToLabel;

    @FindBy( id="shipTo.contact" )
    public WebElement DeliverTo;

    @FindBy( id="shipTo.addressLabel" )
    public WebElement AddressLabel;

    @FindBy( id="shipTo.address" )
    public WebElement Address;

    @FindBy( id="shipTo.cityLabel" )
    public WebElement CityTownLabel;

    @FindBy( id="shipTo.town" )
    public WebElement CityTown;

    @FindBy( id="shipTo.countyLabel" )
    public WebElement CountyLabel;

    @FindBy( id="shipTo.county" )
    public WebElement County;

    @FindBy( id="shipTo.countryLabel" )
    public WebElement CountryLabel;

    @FindBy( id="shipTo.countryId" )
    public WebElement CountryDropdown;

    @FindBy( id="shipTo.postcodeLabel" )
    public WebElement PostcodeLabel;

    @FindBy( id="shipTo.postcode" )
    public WebElement Postcode;

    @FindBy( id="shipTo.phoneNoLabel" )
    public WebElement PhoneNumberLabel;

    @FindBy( id="shipTo.phoneNo" )
    public WebElement PhoneNumber;

    // Lines area
    @FindBy( id="fieldsetLinesLabel" )
    public WebElement LinesLabel;

    @FindBy( id="shoppingItemSupplierLabel" )
    public WebElement SupplierHeaderLabel;

    @FindBy( id="shoppingItemNameLabel" )
    public WebElement ItemNameHeaderLabel;

    @FindBy( id="shoppingItemDescLabel" )
    public WebElement ItemDescriptionHeaderLabel;

    @FindBy( id="shoppingItemQuantityLabel" )
    public WebElement QuantityHeaderLabel;

    @FindBy( id="shoppingItemPriceLabel" )
    public WebElement TargetUnitPriceHeaderLabel;

    @FindBy( xpath="//td[contains(@id,'shoppingItemSupplierData_')]" )
    public List<WebElement> Suppliers;

    @FindBy( xpath="//td[contains(@id,'shoppingItemNameData_')]" )
    public List<WebElement> Names;

    @FindBy( xpath="//td[contains(@id,'shoppingItemDescData_')]" )
    public List<WebElement> Descriptions;

    @FindBy( xpath="//td[contains(@id,'shoppingItemQuantityData_')]" )
    public List<WebElement> Quantitys;

    @FindBy( xpath="//td[contains(@id,'shoppingItemPriceData_')]" )
    public List<WebElement> TargetUnitPrices;

    @FindBy( name="procserveaction_submitShopping" )
    public WebElement SubmitButton;

    @FindBy( name="cancelButton" )
    public WebElement CancelButton;



    protected static Logger LOGGER = Logger.getLogger( RequisitionPage.class );

    public RequisitionPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/shopping/catalogueShopping/edit";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Requisition";
    }

    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "YourReference": return getAttributeValueOfWebElement( YourReference, "value" );
            case "TargetDeliveryDate": return getAttributeValueOfWebElement( TargetDeliveryDate, "value" );
            case "DeliverTo": return getAttributeValueOfWebElement( DeliverTo, "value" );
            case "Address": return getAttributeValueOfWebElement( Address, "value" );
            case "CityTown": return getAttributeValueOfWebElement( CityTown, "value" );
            case "County": return getAttributeValueOfWebElement( County, "value" );
            case "CountryDropdown": return getSelectedTextOfDropdownWebElement( CountryDropdown );
            case "Postcode": return getAttributeValueOfWebElement( Postcode, "value" );
            case "PhoneNumber": return getAttributeValueOfWebElement( PhoneNumber, "value" );

            case "FirstLineSupplier": return getTextOfWebElement( Suppliers.get(0) );
            case "FirstLineName": return getTextOfWebElement( Names.get(0) );
            case "FirstLineDescription": return getTextOfWebElement( Descriptions.get(0) );
            case "FirstLineQuantity": return getTextOfWebElement( Quantitys.get(0) );
            case "FirstLineTargetUnitPrice": return getTextOfWebElement( TargetUnitPrices.get(0) );

            case "SecondLineSupplier": return getTextOfWebElement( Suppliers.get(1) );
            case "SecondLineName": return getTextOfWebElement( Names.get(1) );
            case "SecondLineDescription": return getTextOfWebElement( Descriptions.get(1) );
            case "SecondLineQuantity": return getTextOfWebElement( Quantitys.get(1) );
            case "SecondLineTargetUnitPrice": return getTextOfWebElement( TargetUnitPrices.get(1) );

            default: return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    // Selects the option from an HTML <select> dropdown element
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        switch( dropdownName )
        {
            // By default, selects from the named dropdown element using the text of the option
            // So list here any exceptions e.g. where the option value, rather than text, is to be used
//            case "ADropdownElement": selectDropdownOptionByValue( getWebElementNamed( dropdownName ), dropdownOption );

            default: selectDropdownOptionByText( getWebElementNamed( dropdownName ), dropdownOption );
        }
    }


    public ShoppingNotificationsPage clickCancelButton() throws Exception
    {
        waitUntilDisplayed( CancelButton );
        scrollToElement( CancelButton );  // click sometimes doesn't work if the element is scrolled out of sight
        CancelButton.click();
        return new ShoppingNotificationsPage();
    }

    public InvoiceDetailsPage clickSubmitButton() throws Exception
    {
        waitUntilDisplayed( SubmitButton );
        scrollToElement( SubmitButton );  // click sometimes doesn't work if the element is scrolled out of sight
        SubmitButton.click();
        return new InvoiceDetailsPage();
    }
}
