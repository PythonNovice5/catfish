package com.basware.bttf.steps.bdd.glue.shopping.catalogue_shopping;

import com.basware.bttf.pages.shopping.catalogue_shopping.InvoiceDetailsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InvoiceDetailsSteps extends AbstractSteps
{
    @Then("^On the Invoice Details page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Invoice Details page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", invoiceDetailsPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", invoiceDetailsPage.elementIsNotDisplayed( elementName ));
    }

    @Then("^On the Invoice Details page - I check that first supplier '([^\"']*)' '(is|is not)' ticked")
    public void checkThatFirstSupplierElementIsTicked( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Invoice Details page ... Check first supplier " + elementName + " " + isOrIsNot + " ticked" + "\n" );
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        elementName = "FirstSupplier" + elementName;
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not ticked", invoiceDetailsPage.elementIsOrIsNotTicked( elementName, "is ticked" ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly ticked", invoiceDetailsPage.elementIsOrIsNotTicked( elementName, "is not ticked" ));
    }

    @Then ("^On the Invoice Details page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        String actualValue = invoiceDetailsPage.getElementValue( elementName );
        LOGGER.debug( "Invoice Details page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( expectedValue, actualValue );
    }

    @Then ("^On the Invoice Details page - I check that first supplier '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatFirstSupplierElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "FirstSupplier" + elementName, expectedValue );
    }

    @Then ("^On the Invoice Details page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Invoice Details page ... Enter value " + value + " into field " + elementName + "\n" );
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        invoiceDetailsPage.enterValueIntoElement( value, elementName);
    }

    @Then("On the Invoice Details page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Invoice Details Page ... Select " + dropdownOption + " from " + dropdownName + "dropdown" + "\n" );
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        switch( dropdownName )
        {
            case "CountryDropdown": invoiceDetailsPage.selectOptionFromDropdown( dropdownOption, dropdownName ); break;
            case "PaymentMethodDropdown": invoiceDetailsPage.selectOptionFromDropdown( dropdownOption, dropdownName ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @Then("On the Invoice Details page - I click on the first supplier Checkbox")
    public void clickFirstSupplierCheckbox() throws Exception
    {
        LOGGER.debug( "Invoice Details Page ... Click first supplier Checkbox" + "\n" );
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        invoiceDetailsPage.clickFirstSupplierCheckbox();
    }

    @Then("^On the Invoice Details page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Invoice Details Page ... Click " + buttonName + " button" + "\n" );
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage)getCurrentPage();
        switch( buttonName )
        {
            case "Send": setCurrentPage( invoiceDetailsPage.clickSendButton("rfq") ); break;
            case "Cancel": setCurrentPage( invoiceDetailsPage.clickCancelButton() ); break;
            // default for those elements that cause page re-load
            default: setCurrentPage( invoiceDetailsPage.clickPageReloadingElement( buttonName ) );
        }
    }





}
