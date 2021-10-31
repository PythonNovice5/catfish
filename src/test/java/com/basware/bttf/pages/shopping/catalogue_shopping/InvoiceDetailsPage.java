package com.basware.bttf.pages.shopping.catalogue_shopping;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.freetextrequisitions.FreeTextRequisitionsIndexPage;
import com.basware.bttf.pages.shopping.freetextrequisitions.FreeTextRequisitionsManagementPage;
import com.basware.bttf.pages.shopping.notifications.ShoppingNotificationsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class InvoiceDetailsPage extends ShoppingPage
{

    // Page title area fields
    @FindBy( id="invoice_details.header" )
    public WebElement PageTitle;

    @FindBy(xpath = "//*[text()='Catfish-RW-Supplier']//..//input[@type='checkbox']")
    public WebElement CatfishRWSup;

    // Details fields
    @FindBy( id="billTo.contactLabel" )
    public WebElement InvoiceToLabel;

    @FindBy( id="billTo.contact" )
    public WebElement InvoiceTo;

    @FindBy( id="billTo.addressLabel" )
    public WebElement AddressLabel;

    @FindBy( id="billTo.address" )
    public WebElement Address;

    @FindBy( id="billTo.cityLabel" )
    public WebElement CityTownLabel;

    @FindBy( id="billTo.town" )
    public WebElement CityTown;

    @FindBy( id="billTo.countyLabel" )
    public WebElement CountyLabel;

    @FindBy( id="billTo.county" )
    public WebElement County;

    @FindBy( id="billTo.countryLabel" )
    public WebElement CountryLabel;

    @FindBy( id="billTo.countryId" )
    public WebElement CountryDropdown;

    @FindBy( id="billTo.postcodeLabel" )
    public WebElement PostcodeLabel;

    @FindBy( id="billTo.postcode" )
    public WebElement Postcode;

    @FindBy( id="billTo.phoneNoLabel" )
    public WebElement PhoneNumberLabel;

    @FindBy( id="billTo.phoneNo" )
    public WebElement PhoneNumber;

    // Suppliers area
    @FindBy( id="shoppingSupplierNameLabel" )
    public WebElement SupplierNameHeaderLabel;

    @FindBy( id="shoppingPaymentMethodLabel" )
    public WebElement SupplierPaymentMethodHeaderLabel;

    @FindBy( xpath="//input[@id='supplierId']" )
    public List<WebElement> SupplierCheckboxs;

    @FindBy( id="shoppingSupplierNameData_0" )
    public List<WebElement> Suppliers;

    @FindBy( id="shoppingPaymentMethodData_0" )
    public List<WebElement> PaymentMethods;

    // Footer area
    @FindBy( id="paymentTypeOptionsLabel" )
    public WebElement ChangePaymentMethodLabel;

    @FindBy( id="paymentType" )
    public WebElement PaymentMethodDropdown;

    @FindBy( name="_action_changePayment" )
    public WebElement ChangePaymentMethodButton;

    @FindBy( id="submitButton" )
    public WebElement SendButton;

    @FindBy( name="cancelButton" )
    public WebElement CancelButton;

    @FindBy( id = "supplierId")
    private WebElement supplierCheckbox;

    @FindBy( name = "_action_changePayment")
    private WebElement changeButton;


    protected static Logger LOGGER = Logger.getLogger( InvoiceDetailsPage.class );

    public InvoiceDetailsPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/shopping/invoice";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Invoice Details";
    }

    // Returns true when the element is or is not ticked in accordance with the expected state
    public boolean elementIsOrIsNotTicked( String elementName, String expectedState ) throws Exception
    {
        WebElement webElement;
        switch( elementName )
        {
            case "FirstSupplierCheckbox": webElement = SupplierCheckboxs.get(0); break;
            default: webElement = getWebElementNamed( elementName );
        }
        waitUntilDisplayed( webElement );
        if( expectedState.equals("is ticked"))   // if expecting the element to be ticked
        {
            return webElement.isSelected();
        }
        else                                    // if expecting the element not to be ticked
        {
            return !webElement.isSelected();
        }
    }

    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "InvoiceTo": return getAttributeValueOfWebElement( InvoiceTo, "value" );
            case "Address": return getAttributeValueOfWebElement( Address, "value" );
            case "CityTown": return getAttributeValueOfWebElement( CityTown, "value" );
            case "County": return getAttributeValueOfWebElement( County, "value" );
            case "CountryDropdown": return getSelectedTextOfDropdownWebElement( CountryDropdown );
            case "Postcode": return getAttributeValueOfWebElement( Postcode, "value" );
            case "PhoneNumber": return getAttributeValueOfWebElement( PhoneNumber, "value" );

            case "FirstSupplierSupplier": return getTextOfWebElement( Suppliers.get(0) );
            case "FirstSupplierPaymentMethod": return getTextOfWebElement( PaymentMethods.get(0) );

            case "PaymentMethodDropdown": return getSelectedTextOfDropdownWebElement( PaymentMethodDropdown );
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


    public RequisitionPage clickCancelButton() throws Exception
    {
        waitUntilDisplayed( CancelButton );
        scrollToElement( CancelButton );  // click sometimes doesn't work if the element is scrolled out of sight
        CancelButton.click();
        return new RequisitionPage();
    }

    public void selectSupplier()
    {
        supplierCheckbox.click();
    }

    public AddPaymentDetailsPage clickOnChangeButton()
    {
        changeButton.click();
        return new AddPaymentDetailsPage();

    }

    public void selectPaymentType(String paymentType) throws Exception {
       selectDropdownOptionByText(PaymentMethodDropdown,paymentType);
    }

    public ShoppingPage clickSendButton(String fieldName) throws Exception      // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CHANGE THIS PAGE
    {
        ShoppingPage page = null;
        waitUntilDisplayed( SendButton );
        scrollToElement( SendButton );  // click sometimes doesn't work if the element is scrolled out of sight
        SendButton.click();
        switch( fieldName )
        {
            case "FTR":
                 page =  new FreeTextRequisitionsIndexPage();

                 break;
            case "rfq":
                 page = new ShoppingNotificationsPage();
                 break;
        }
        return page;
    }

    public void clickFirstSupplierCheckbox() throws Exception
    {
        waitUntillElementIsClickableAndClick( SupplierCheckboxs.get(0) );
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    // Use this to click a button or link that causes the same page be re-loaded
    public InvoiceDetailsPage clickPageReloadingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "ChangePaymentMethod": element = ChangePaymentMethodButton; break;

            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        waitUntillElementIsClickableAndClick( element );
        return new InvoiceDetailsPage();
    }


}
