package com.basware.bttf.steps.bdd.glue.shopping.marketplace;
// Created by Julian Sheppard on 19/03/2018

import com.basware.bttf.pages.shopping.marketplace.ItemComparisonPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.generator.model.Item;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemComparisonSteps extends AbstractSteps
{
    @Then("^On the Item Comparison page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        LOGGER.debug( "Item Comparison page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        ItemComparisonPage itemComparisonPage = (ItemComparisonPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", itemComparisonPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", itemComparisonPage.elementIsNotDisplayed( elementName ));
    }




    @When("^On the Item Comparison page - I remove all the added items for comparison")
    public void removeItemsForComparison() throws Exception{
        LOGGER.debug("On the Item Comparison page - I remove all the added items for comparison");
        ItemComparisonPage itemComparisonPage = (ItemComparisonPage)getCurrentPage();
        itemComparisonPage.removeAllItems();
    }

    @When("^On the Item Comparison page - I click on '([^\"']*)' link")
    public void clickOn(String value) throws Exception {
        LOGGER.debug("Item Comparison page ... Click " + value + "  link");
        ItemComparisonPage itemComparisonPage = (ItemComparisonPage) getCurrentPage();
        setCurrentPage(itemComparisonPage.clickLink(value));
    }

    @Then("^On the Item Comparison page - I click on '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Item Comparison page ... Click " + buttonName + " button" + "\n" );
        ItemComparisonPage itemComparisonPage = (ItemComparisonPage)getCurrentPage();
        switch( buttonName )
        {
            case "FirstItemAddToBasket": setCurrentPage( itemComparisonPage.clickBtn(0) ); break;
            case "SecondItemAddToBasket":setCurrentPage( itemComparisonPage.addSecondItem() ); break;
            case "Basket": setCurrentPage(itemComparisonPage.clickBtn("BasketIcon"));break;
        }
    }

    @Then("^On the Item Comparison page - I check that first item '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatFirstItemElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        checkThatElementIsDisplayed( "FirstItem" + elementName, isOrIsNot );
    }

    @Then ("^On the Item Comparison page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        ItemComparisonPage itemComparisonPage = (ItemComparisonPage)getCurrentPage();
        switch (elementName) {
            case "QuotesText":
                itemComparisonPage.hoverToElement(itemComparisonPage.getWebElementNamed("QuotesIcon"));
                break;
            case "ListsText":
                itemComparisonPage.hoverToElement(itemComparisonPage.getWebElementNamed("ListsIcon"));
                break;
            case "CompareText":
                itemComparisonPage.hoverToElement(itemComparisonPage.getWebElementNamed("CompareIcon"));
                break;
            case "BasketText":
                itemComparisonPage.hoverToElement(itemComparisonPage.getWebElementNamed("BasketIcon"));
                break;
            case "SecondItemName":itemComparisonPage.hoverToElement(itemComparisonPage.getWebElementNamed(elementName));
                break;
        }
        String actualValue = itemComparisonPage.getElementValue( elementName );
        actualValue = actualValue.replaceAll("\n","");
        LOGGER.debug( "Item Comparison Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Item Comparison page - I check that first item '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatFirstItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "First" + elementName, expectedValue );
    }

    @Then ("^On the Item Comparison page - I check that second item '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatSecondItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "Second" + elementName, expectedValue );
    }

    @Then ("^On the Item Comparison page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        ItemComparisonPage itemComparisonPage = (ItemComparisonPage)getCurrentPage();
        Integer actualNumber = itemComparisonPage.getListElementCount( listElementName );
        LOGGER.debug( "Item Comparison Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }

}
