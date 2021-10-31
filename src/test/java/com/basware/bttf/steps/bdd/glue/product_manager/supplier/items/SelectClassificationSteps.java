package com.basware.bttf.steps.bdd.glue.product_manager.supplier.items;
// Created by Julian Sheppard on 21/07/2017

import com.basware.bttf.pages.product_manager.supplier.items.SelectClassificationPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class SelectClassificationSteps extends AbstractSteps {

    @Then ("^On the Select Classification page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        SelectClassificationPage selectClassificationPage = (SelectClassificationPage)getCurrentPage();
        String actualValue = selectClassificationPage.getElementValue( elementName );
        LOGGER.debug( "Select Classification Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then("^On the Select Classification page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Select Classification Page ... Enter value " + value + " into element " + elementName + "\n" );
        SelectClassificationPage selectClassificationPage = (SelectClassificationPage)getCurrentPage();
        selectClassificationPage.enterValueIntoElement( value, elementName);
    }

    @Then("^On the Select Classification page - I click on the '([^\"']*)' breadcrumb")
    public void clickBreadcrumb( String breadcrumbName ) throws Exception
    {
        LOGGER.debug( "Select Classification Page ... Click " + breadcrumbName + " breadcrumb" + "\n" );
        SelectClassificationPage selectClassificationPage = (SelectClassificationPage)getCurrentPage();
        switch( breadcrumbName )
        {
            case "Back to Create item": case "Back to Edit item":
            {
                // Determine whether to go back to Create Item page or Edit Item page
                boolean goBackToCreatePage = selectClassificationPage.getElementValue("BackToBreadcrumb" ).equals("Back to Create item");
                if( goBackToCreatePage )
                    setCurrentPage( selectClassificationPage.clickToExitToCreateItem("BackToBreadcrumb") );
                else
                    setCurrentPage( selectClassificationPage.clickToExitToEditItem("BackToBreadcrumb") );
            } break;
            default: throw new RuntimeException("No case statement for breadcrumb: " + breadcrumbName);
        }
    }

    @Then("^On the Select Classification page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Select Classification Page ... Click " + buttonName + " button" + "\n" );
        SelectClassificationPage selectClassificationPage = (SelectClassificationPage)getCurrentPage();
        switch( buttonName )
        {
            case "Cancel":
                break;
                case "Save":
            {
                // Determine whether to go back to Create Item page or Edit Item page
                boolean goBackToCreatePage = selectClassificationPage.getElementValue("BackToBreadcrumb" ).equals("Back to Create item");
                if( goBackToCreatePage )
                    setCurrentPage( selectClassificationPage.clickToExitToCreateItem(buttonName + "Button" ) );
                else
                    setCurrentPage( selectClassificationPage.clickToExitToEditItem(buttonName + "Button" ) );
            } break;

            case "Done":
                buttonName="DoneClassificationBtn";
                setCurrentPage(selectClassificationPage.clickButton( buttonName ));
                break;
            default: selectClassificationPage.clickButton( buttonName );
        }

    }

    @Then("^On the Select Classification page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Select Classification page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        SelectClassificationPage selectClassificationPage = (SelectClassificationPage)getCurrentPage();
        switch( dropdownName )
        {
            default: setCurrentPage(selectClassificationPage.selectLevelDropdownOptionByText( dropdownName, dropdownOption ));
        }
    }


}
