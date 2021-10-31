package com.basware.bttf.steps.bdd.glue.shopping.marketplace;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.shopping.marketplace.ItemDetailsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemDetailsSteps extends AbstractSteps
{
    @Then("^On the Item Details page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Item Details Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", itemDetailsPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", itemDetailsPage.elementIsNotDisplayed( elementName ));
    }

    @Then ("^On the Item Details page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        switch (elementName) {
            case "QuotesText":
                itemDetailsPage.hoverToElement(itemDetailsPage.getWebElementNamed("QuotesIcon"));
                break;
            case "ListsText":
                itemDetailsPage.hoverToElement(itemDetailsPage.getWebElementNamed("ListsIcon"));
                break;
            case "CompareText":
                itemDetailsPage.hoverToElement(itemDetailsPage.getWebElementNamed("CompareIcon"));
                break;
            case "BasketText":
                itemDetailsPage.hoverToElement(itemDetailsPage.getWebElementNamed("BasketIcon"));
                break;
        }
        String actualValue = itemDetailsPage.getElementValue( elementName );
        actualValue= actualValue.replaceAll("\n","");
        LOGGER.debug(actualValue.replaceAll("\n",""));
        LOGGER.debug( "Item Details Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @When("^On the Item Details page - I select '([^\"']*)' from the '([^\"']*)' dropdown$")
    public void selectMatrixOptions(String matrixOption, String attribute ) throws Exception {
        LOGGER.debug( "Clicking on matrix attribute...." + attribute );
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        itemDetailsPage.clickButton(matrixOption);
    }

    @Then ("^On the Item Details page - I check that the number of '([^\"']*)' is '([^\"]*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        Integer actualNumber = itemDetailsPage.getListElementCount( listElementName );
        LOGGER.debug( "Item Details Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }

    @Then("^On the Item Details page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Item Details Page ... Click " + buttonName + " button" + "\n" );
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        switch( buttonName )
        {
            case "Compare": setCurrentPage( itemDetailsPage.clickCompareButton() ); break;
            case "Basket": setCurrentPage( itemDetailsPage.clickBasketButton() ); break;
            case "AddToList": itemDetailsPage.clickButton( "AddToListButton" ); break;
            case "AddToBasket": itemDetailsPage.clickButton( "AddToBasketButton" ); break;
            case "Lists": setCurrentPage( itemDetailsPage.clickListsButton() ); break;
            case "AddToComparison": itemDetailsPage.clickButton("AddToComparisonButton" );waitPageLoaded(); break;
            case "Select Suppliers": setCurrentPage(itemDetailsPage.selectSup());break;
            case "Get quotes": setCurrentPage(itemDetailsPage.clickgetQuotes());break;
            default: throw new RuntimeException("No case statement matching: " + buttonName);
        }
    }

    @Then("^On the Item Details page - I click on the '([^\"']*)' link")
    public void clickLink( String linkName ) throws Exception
    {
        LOGGER.debug( "Item Details Page ... Click " + linkName + " link" + "\n" );
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        switch( linkName )
        {
            case "ModalFirstList": itemDetailsPage.clickLink( "ModalFirstList" ); break;
            default: throw new RuntimeException("No case statement matching: " + linkName);
        }
    }

    @Then("^On the Item Details page - I click on the '([^\"']*)' '([^\"]*)' link$")
    public void clickListLink( String listElementName, String text ) throws Exception
    {
        LOGGER.debug( "Item Details Page ... Click " + listElementName + " " + text + " link" + "\n" );
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        switch( listElementName )
        {
            default: itemDetailsPage.clickListLink( listElementName, text );
        }
    }

    @Then("^On the Item Details page - I click on the '([^\"']*)' breadcrumb")
    public void clickBreadcrumb( String breadcrumbName ) throws Exception
    {
        LOGGER.debug( "Item Details page ... Click " + breadcrumbName + " breadcrumb" + "\n" );
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        switch( breadcrumbName )
        {
            case "BackLink":
                if(itemDetailsPage.getElementValue( breadcrumbName ).equals("Back to Search Results"))
                    setCurrentPage( itemDetailsPage.clickBackToSearchResults() );
                else
                    setCurrentPage( itemDetailsPage.clickBackToLists() );
                break;
            case "Home": setCurrentPage( itemDetailsPage.clickHomeBreadcrumb() ); break;
            default: throw new Exception("Unrecognised breadcrumb");
        }
    }

    @Then("^On the Item Details page - I check that stock information is displayed$")
    public void verifyStockInformation()
    {
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        itemDetailsPage.verifyStockDetails();
    }

    @When("^On the Item Details page - I click on the GetQuotes link$")
    public void clickOnButtonOnItemViewPage()
    {
        ItemDetailsPage itemDetailsPage = (ItemDetailsPage)getCurrentPage();
        setCurrentPage(itemDetailsPage.clickOnGetQuotes());
    }
}
