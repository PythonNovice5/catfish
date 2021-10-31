package com.basware.bttf.steps.bdd.glue.product_manager.supplier.items;
// Created by Julian Sheppard on 21/07/2017

import com.basware.bttf.pages.product_manager.supplier.items.SelectMediaPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SelectMediaSteps extends AbstractSteps
{
    @Then("^On the Select Media page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Select Media Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        SelectMediaPage selectMediaPage = (SelectMediaPage) getCurrentPage();
        if(isOrIsNot.equals("is"))
            assertTrue("Element is unexpectedly not displayed", selectMediaPage.elementIsDisplayed( elementName ));
        else
            assertTrue("Element is unexpectedly displayed", selectMediaPage.elementIsNotDisplayed( elementName ));
    }

    @Then ("^On the Select Media page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        SelectMediaPage selectMediaPage = (SelectMediaPage)getCurrentPage();
        String actualValue = selectMediaPage.getElementValue( elementName );
        LOGGER.debug( "Select Media Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Select Media page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        SelectMediaPage selectMediaPage = (SelectMediaPage)getCurrentPage();
        Integer actualNumber = selectMediaPage.getListElementCount( listElementName );
        LOGGER.debug( "Select Media Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }


    @Then("^On the Select Media page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Select Media Page ... Enter value " + value + " into element " + elementName + "\n" );
        SelectMediaPage selectMediaPage = (SelectMediaPage)getCurrentPage();
        selectMediaPage.enterValueIntoElement( value, elementName);
    }

    @Then("^On the Select Media page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Select Media Page ... Click " + buttonName + " button" + "\n" );
        SelectMediaPage selectMediaPage = (SelectMediaPage)getCurrentPage();
        switch( buttonName )
        {
            case "CLOSE":
            {
            // Determine whether to go back to Create Item page or Edit Item page
            boolean goBackToCreatePage = driver.getCurrentUrl().contains("backToController=addProduct");
            if( goBackToCreatePage )
                setCurrentPage( selectMediaPage.clickToExitToCreateItem("PageClose" ) );
            else
                setCurrentPage( selectMediaPage.clickToExitToEditItem("PageClose" ) );
            } break;
            case "Add items":
            {
            // Determine whether to go back to Create Item page or Edit Item page
            boolean goBackToCreatePage = driver.getCurrentUrl().contains("backToController=addProduct");
            if( goBackToCreatePage )
                setCurrentPage( selectMediaPage.clickToExitToCreateItem( "AddItemsButton" ) );
            else
                setCurrentPage( selectMediaPage.clickToExitToEditItem("AddItemsButton" ) );
            } break;
            // default for those elements that cause page re-load
            default: setCurrentPage( selectMediaPage.clickPageReloadingElement( buttonName ) );
        }
    }

    @Then("^On the Select Media page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Select Media page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        SelectMediaPage selectMediaPage = (SelectMediaPage)getCurrentPage();
        switch( dropdownName )
        {
            case "Order By": setCurrentPage( selectMediaPage.selectOrderBy( dropdownOption ) ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @Then("^On the Select Media page - I click on '([^\"']*)' thumbnail$")
    public void clickOnAThumbnail( String thumbnailNumber ) throws Exception
    {
        LOGGER.debug( "Select Media Page ... Click image " + thumbnailNumber + " thumbnail" + "\n" );
        SelectMediaPage selectMediaPage = (SelectMediaPage)getCurrentPage();
        switch( thumbnailNumber )
        {
            case "First": selectMediaPage.clickThumbnail(0); break;
            case "Second": selectMediaPage.clickThumbnail(1); break;
            case "Third": selectMediaPage.clickThumbnail(2); break;
            case "Fourth": selectMediaPage.clickThumbnail(3); break;
            case "Fifth": selectMediaPage.clickThumbnail(4); break;
            case "Sixth": selectMediaPage.clickThumbnail(5); break;
            case "Seventh": selectMediaPage.clickThumbnail(6);break;
            case "Eighth": selectMediaPage.clickThumbnail(7);break;
            case "Nineth": selectMediaPage.clickThumbnail(8);break;
            case "Tenth":selectMediaPage.clickThumbnail(9);break;
            default: throw new RuntimeException("No case statement for image number: " + thumbnailNumber);
        }


    }

}
