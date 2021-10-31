package com.basware.bttf.steps.bdd.glue.shopping.marketplace;
// Created by Julian Sheppard on 21/04/2017

import com.basware.bttf.pages.shopping.marketplace.ItemDetailsPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPageJupiter;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarketPlaceSearchResultsSteps extends AbstractSteps
{
    @Then("^On the Marketplace Search Results page - I log the value of '([^\"']*)'$")
    public void logValueOfElement( String elementName ) throws Throwable
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        String actualValue = marketplaceSearchResultsPage.getElementValue( elementName );
        LOGGER.debug( ">>>>> NOTE: " + elementName + "[" + actualValue + "]" + "\n" );
    }

    @Then("^On the Marketplace Search Results page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        LOGGER.debug( "Marketplace Search Results page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        switch (elementName){
            case "QuotesText":
                marketplaceSearchResultsPage.hoverToElement(marketplaceSearchResultsPage.getWebElement("QuotesIcon"));
                break;
            case "ListsText":
                marketplaceSearchResultsPage.hoverToElement(marketplaceSearchResultsPage.getWebElement("ListsIcon"));
                break;
            case "CompareText":
                marketplaceSearchResultsPage.hoverToElement(marketplaceSearchResultsPage.getWebElement("CompareIcon"));
                break;
            case "BasketText":
                marketplaceSearchResultsPage.hoverToElement(marketplaceSearchResultsPage.getWebElement("BasketIcon"));
                break;
            case "SearchClearButton":
                marketplaceSearchResultsPage.enterValueIntoElement("test","SearchKeywords");
                LOGGER.debug("Entered value - test into Search box");
                break;
        }
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", marketplaceSearchResultsPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", marketplaceSearchResultsPage.elementIsNotDisplayed( elementName ));
    }

    @Then("^On the Marketplace Search Results page - I check that first item '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatFirstItemElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        checkThatElementIsDisplayed( "FirstItem" + elementName, isOrIsNot );
    }

    @Then("^On the Marketplace Search Results page - I check that first item is shared item$")
    public void verifyFirstItem() throws Exception
    {

        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        marketplaceSearchResultsPage.verifyFirstSupId(props.get("SupID"));
    }

    @Then("^On the Marketplace Search Results page - I check that first item is Eclass item$")
    public void verifyFirstItemEclass() throws Exception
    {

        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        marketplaceSearchResultsPage.verifyFirstSupId(props.get("SupID"));
    }

    @Then ("^On the Marketplace Search Results page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        String actualValue = marketplaceSearchResultsPage.getElementValue( elementName );
        switch (expectedValue){
            case "Item1":
                expectedValue = props.get("Item1");
                break;
            case "Item2":
                expectedValue = props.get("Item2");
                break;
            case "UpdatedPrice":
                expectedValue = props.get("UpdatedPrice");
                driver.navigate().refresh();
                Thread.sleep(1000);
                driver.navigate().refresh();
                actualValue = marketplaceSearchResultsPage.getElementValue( elementName );
                break;
            case "ExpectedValue":
                expectedValue = props.get(TestConstants.CONTRACT_REF);
                break;
//            case "ContainerItemImage":
//                marketplaceSearchResultsPage.getElementValue(elementName);
        }
        LOGGER.debug( "Marketplace Search Results Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Marketplace Search Results page - I check that first item '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatFirstItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "FirstItem" + elementName, expectedValue );
    }

    @Then ("^On the Marketplace Search Results page - I check that second item '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatSecondItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "SecondItem" + elementName, expectedValue );
    }

    @Then ("^On the Marketplace Search Results page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        Integer actualNumber = marketplaceSearchResultsPage.getListElementCount( listElementName );
        LOGGER.debug( "Marketplace Search Results page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }

    @Then("^On the Marketplace Search Results page - I select the '([^\"]*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Marketplace Search Results page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        switch( dropdownName )
        {
//            case "Order By": setCurrentPage( marketplaceSearchResultsPage.selectOrderBy( dropdownOption ) ); break;
            case "Per Page": setCurrentPage( marketplaceSearchResultsPage.selectPerPage( dropdownOption ) ); break;
            case "Order By":
                dropdownName="OrderBy";
                setCurrentPage( marketplaceSearchResultsPage.selectOption( dropdownName,dropdownOption ) );
                break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);

        }
    }

    @Then ("^On the Marketplace Search Results page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Marketplace Search Results Page ... Enter value " + value + " into element " + elementName + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        switch (value){
            case "Item1":
                value = props.get("Item1");
                break;
            case "Item2":
                value = props.get("Item2");
                break;
        }
        marketplaceSearchResultsPage.enterValueIntoElement( value, elementName);
    }



    @Then("^On the Marketplace Search Results page Jupiter - I click on the '([^\"']*)' button$")
    public void clickThisButton( String buttonName ) throws Exception {
        LOGGER.debug("Marketplace Search Results page Jupiter ... Click " + buttonName + " button" + "\n");
        MarketplaceSearchResultsPageJupiter marketplaceSearchResultsPageJupiter = (MarketplaceSearchResultsPageJupiter) getCurrentPage();
        switch (buttonName) {
            case "Lists":
                setCurrentPage(marketplaceSearchResultsPageJupiter.clickListsButton());
                break;
            case "Basket":
                setCurrentPage(marketplaceSearchResultsPageJupiter.clickBasketButton());
                break;
            case "first item AddToBasket":
                marketplaceSearchResultsPageJupiter.clickPageRefreshingElement(buttonName);
                break;
            case "Search":
                marketplaceSearchResultsPageJupiter.clickPageReloadingElement(buttonName);
                break;
        }
    }


    @Then("^On the Marketplace Search Results page - I add all items into basket$")
    public void addItemsToBasket(DataTable table) throws Exception {
        List<List<String>> rows = table.asLists(String.class);
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();

        for(List<String> columns : rows) {
            marketplaceSearchResultsPage.enterValueIntoElement(columns.get(1),"SearchKeywords");
            setCurrentPage( marketplaceSearchResultsPage.clickPageReloadingElement( "Search" ) );
            setCurrentPage( marketplaceSearchResultsPage.clickFirstItemNameLink() );
            ItemDetailsPage itemDetailsPage = (ItemDetailsPage) getCurrentPage();
            itemDetailsPage.clickButton( "AddToBasketButton" );
            setCurrentPage( itemDetailsPage.clickBackToSearchResults() );
        }
    }

    @Then("^On the Marketplace Search results page - I verify language items are displaying as expected$")
    public void verifyLanguageItems()
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        marketplaceSearchResultsPage.verifyLanguageItemCount();


    }

    @Then ("^On the Marketplace Search Results page - I enter '([^\"]*)' into first item '([^\"']*)'$")
    public void enterValueIntoFirstItemElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Marketplace Search Results page ... Enter value " + value + " into first item  " + elementName + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        marketplaceSearchResultsPage.enterValueIntoElement( value, "FirstItem" + elementName);
    }

    @Then ("^On the Marketplace Search Results page Jupiter - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoTheElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Marketplace Search Results Page Jupiter... Enter value " + value + " into element " + elementName + "\n" );
        MarketplaceSearchResultsPageJupiter marketplaceSearchResultsPageJupiter = (MarketplaceSearchResultsPageJupiter) getCurrentPage();
        switch (value){
            case "Item1":
                value = props.get("Item1");
                break;
            case "Item2":
                value = props.get("Item2");
                break;
            case "DPSItem":
                value=props.get("SupID");
                break;
        }
        marketplaceSearchResultsPageJupiter.enterValueIntoElement( value, elementName);
    }

    @Then("^On the Marketplace Search Results page Jupiter - I click on the first item '([^\"']*)' button$")
    public void clickTheFirstItemButton( String buttonName ) throws Exception
    {
        clickThisButton( "first item " + buttonName );
    }

    @Then("^On the Marketplace Search Results page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Marketplace Search Results page ... Click " + buttonName + " button" + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        switch( buttonName )
        {
            case "Lists": setCurrentPage( marketplaceSearchResultsPage.clickListsButton() ); break;
            case "Quotes":setCurrentPage(marketplaceSearchResultsPage.clickQuotesButton());break;
            case "Basket": setCurrentPage( marketplaceSearchResultsPage.clickBasketButton() ); break;
            case "first item AddToList": marketplaceSearchResultsPage.clickButton( "FirstItemAddToListButton" ); break;
            case "first item AddToComparison": marketplaceSearchResultsPage.clickButton( "FirstItemAddToComparisonButton" ); break;
            case "first item AddToBasket": marketplaceSearchResultsPage.clickPageRefreshingElement( buttonName ); break;
            case "AddInformation": marketplaceSearchResultsPage.clickButton( buttonName ); break;
            case "ShowAsListButton": marketplaceSearchResultsPage.clickButton(buttonName); break;
            case "ShowAsThumbnailButton":marketplaceSearchResultsPage.clickButton(buttonName);break;
            case "ShowAsTableButton":marketplaceSearchResultsPage.clickButton(buttonName);break;
            case "CompareItems": setCurrentPage(marketplaceSearchResultsPage.clickOnElement(buttonName));break;
            case "first item View":setCurrentPage(marketplaceSearchResultsPage.clickView());break;
            case "FirsItemExpressCheckOut":setCurrentPage(marketplaceSearchResultsPage.clickExpressCheckout());break;

            //            case "first item UpdateBasketQty": marketplaceSearchResultsPage.clickPageRefreshingElement( buttonName); break;
//            case "first item RemoveFromBasket": marketplaceSearchResultsPage.clickPageRefreshingElement( buttonName ); break;
            // default for those elements that cause page re-load
            default: setCurrentPage( marketplaceSearchResultsPage.clickPageReloadingElement( buttonName ));
        }
    }

    @Then("^On the Marketplace Search Results page - I click on the first item '([^\"']*)' button$")
    public void clickFirstItemButton( String buttonName ) throws Exception
    {
        clickButton( "first item " + buttonName );
    }

    @Then("On the Marketplace Search Results page - I verify item added to compare")
    public void verifyItemAddedToCompare()
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        marketplaceSearchResultsPage.verifyItemAddedToCompare();
    }

    @Then("^On the Marketplace Search Results page - I click on the '([^\"']*)' link")
    public void clickLink( String linkName ) throws Exception
    {
        LOGGER.debug( "Marketplace Search Results Page ... Click " + linkName + " link" + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        switch( linkName )
        {
            case "FirstItemName": setCurrentPage( marketplaceSearchResultsPage.clickFirstItemNameLink() ); break;
            case "here": setCurrentPage(marketplaceSearchResultsPage.clickLink( linkName ));break;
            default: marketplaceSearchResultsPage.clickLink( linkName );
        }
    }

    @Then("^On the Marketplace Search Results page - I click on the '([^\"']*)' '([^\"]*)' link$")
    public void clickListLink( String listElementName, String text ) throws Exception
    {
        LOGGER.debug( "Marketplace Search Results page ... Click " + listElementName + " " + text + " link" + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        switch( listElementName )
        {
            default: marketplaceSearchResultsPage.clickListLink( listElementName, text );
        }
    }

    @Then("^On the Marketplace Search Results page - I click on the first item '([^\"']*)' link")
    public void clickFirstItemLink( String linkName ) throws Exception
    {
        clickLink( "FirstItem" + linkName  );
    }

    @Then("^On the Marketplace Search Results page - I click on the '([^\"']*)' filter$")
    public void clickFilter( String filterName ) throws Exception
    {
        LOGGER.debug( "Marketplace Search Results Page ... Click " + filterName + " filter" + "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        setCurrentPage( marketplaceSearchResultsPage.clickPageReloadingElement( filterName ) );
    }

    @Then("^On the Marketplace Search Results page - I verify the '([^\"']*)' value$")
    public void verifyValue(String elementValue) throws Exception{
        LOGGER.debug("Verifying " + elementValue +" value");
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        marketplaceSearchResultsPage.verifyValue(elementValue);
    }

    @And("On the Marketplace Search Results page - I enter '([^\"']*)' plus SessionGUID into '([^\"']*)'")
    public void enterPlusSessionGUID(String value, String field) throws Exception{
        LOGGER.debug( "Marketplace Search Results Page ... Enter " + value + " value" +  " into " +field+ "\n" );
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        String sessionGUID = getCurrentPage().getSessionID();
        String valueNew = value + sessionGUID;
        marketplaceSearchResultsPage.enterValueIntoElement(valueNew,field);
    }

    @And("On the Marketplace Search Results page - I verify that '([^\"']*)' contains '([^\"']*)'")
    public void verifyMessage(String element,String valueToBeVerified) throws Exception {
        LOGGER.debug("Marketplace Search Results Page ...Verifying message Enter " + valueToBeVerified + "\n");
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        String actualValue = marketplaceSearchResultsPage.getElementValue( element );
        LOGGER.debug( "Marketplace Search Results Page ... Comparing " + element + ": Expected:[" + valueToBeVerified + "] Actual:[" + actualValue + "]" + "\n");
        assertTrue("Expected "+valueToBeVerified+" but got: "+actualValue +actualValue,actualValue.contains(valueToBeVerified));
    }


}
