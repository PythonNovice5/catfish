package com.basware.bttf.steps.bdd.glue.shopping.catalogue_shopping;

import com.basware.bttf.pages.shopping.catalogue_shopping.RequisitionPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RequisitionSteps extends AbstractSteps 
{
    @Then("^On the Requisition page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Requisition page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", requisitionPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", requisitionPage.elementIsNotDisplayed( elementName  ));
    }

    @Then ("^On the Requisition page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        String actualValue = requisitionPage.getElementValue( elementName );
        LOGGER.debug( "Requisition page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( expectedValue, actualValue );
    }

    @Then ("^On the Requisition page - I check that first line '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatFirstLineElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        String actualValue = requisitionPage.getElementValue( "FirstLine" + elementName );
        LOGGER.debug( "Requisition page ... Comparing first line " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( expectedValue, actualValue );
    }

    @Then ("^On the Requisition page - I check that second line '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatSecondLineElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        String actualValue = requisitionPage.getElementValue( "SecondLine" + elementName );
        LOGGER.debug( "Requisition page ... Comparing second line " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( expectedValue, actualValue );
    }

    @Then ("^On the Requisition page - I enter '([^\"']*)' plus DateTimeNow into '([^\"']*)'$")
    public void enterValuePlusDateTimeIntoElement( String value, String elementName )  throws Throwable
    {
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        enterValueIntoElement(value + requisitionPage.getDateTimeNow(), elementName);
    }

    @Then ("^On the Requisition page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Requisition page ... Enter value " + value + " into field " + elementName + "\n" );
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        requisitionPage.enterValueIntoElement( value, elementName);
    }

    @Then("On the Requisition page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromPerPageDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Requisition Page ... Select " + dropdownOption + " from " + dropdownName + "dropdown" + "\n" );
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        requisitionPage.selectOptionFromDropdown( dropdownOption, dropdownName );
    }

    @Then("^On the Requisition page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Requisition Page ... Click " + buttonName + " button" + "\n" );
        RequisitionPage requisitionPage = (RequisitionPage)getCurrentPage();
        switch( buttonName )
        {
            case "Submit": setCurrentPage( requisitionPage.clickSubmitButton() ); break;
            case "Cancel": setCurrentPage( requisitionPage.clickCancelButton() ); break;
            default: throw new RuntimeException("No case statement matching: " + buttonName);
        }
    }


}
