package com.basware.bttf.steps.bdd.glue.shopping.marketplace;

import com.basware.bttf.pages.shopping.marketplace.EditBasketItemPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class EditBasketItemSteps extends AbstractSteps {


    @Then("^On the Edit Basket Item Details page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs(String elementName, String expectedValue) throws Throwable {
        EditBasketItemPage editBasketItemPage = (EditBasketItemPage) getCurrentPage();
        switch (elementName) {
            case "QuotesText":
                editBasketItemPage.hoverToElement(editBasketItemPage.getWebElementNamed("QuotesIcon"));
                break;
            case "ListsText":
                editBasketItemPage.hoverToElement(editBasketItemPage.getWebElementNamed("ListsIcon"));
                break;
            case "CompareText":
                editBasketItemPage.hoverToElement(editBasketItemPage.getWebElementNamed("CompareIcon"));
                break;
            case "BasketText":
                editBasketItemPage.hoverToElement(editBasketItemPage.getWebElementNamed("BasketIcon"));
                break;
        }
        String actualValue = editBasketItemPage.getElementValue( elementName );
        LOGGER.debug( "Item Details Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then("^On the Edit Basket Item page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Item Details Page ... Click " + buttonName + " button" + "\n" );
        EditBasketItemPage editBasketItemPage = (EditBasketItemPage)getCurrentPage();
        switch( buttonName )
        {
            case "Compare": setCurrentPage( editBasketItemPage.clickCompareButton() ); break;
            case "Basket": setCurrentPage( editBasketItemPage.clickBasketButton() ); break;
            case "AddToList": editBasketItemPage.clickButton( "AddToListButton" ); break;
            case "Lists": setCurrentPage( editBasketItemPage.clickListsButton() ); break;
            case "AddToComparison": editBasketItemPage.clickButton("AddToComparisonButton" ); break;
            default: throw new RuntimeException("No case statement matching: " + buttonName);
        }

    }
}