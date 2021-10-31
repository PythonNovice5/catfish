package com.basware.bttf.steps.bdd.glue.shopping.marketplace;
// Created by Julian Sheppard on 21/04/2017

import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
//import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPageGrails;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPageJupiter;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarketplaceLandingSteps extends AbstractSteps
{
    @Then("^On the Marketplace Landing page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Marketplace Landing Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage)getCurrentPage();
        switch (elementName){
            case "QuotesText":
                marketplaceLandingPage.hoverToElement(marketplaceLandingPage.getWebElement("QuotesIcon"));
                break;
            case "ListsText":
                marketplaceLandingPage.hoverToElement(marketplaceLandingPage.getWebElement("ListsIcon"));
                break;
            case "CompareText":
                marketplaceLandingPage.hoverToElement(marketplaceLandingPage.getWebElement("CompareIcon"));
                break;
            case "BasketText":
                marketplaceLandingPage.hoverToElement(marketplaceLandingPage.getWebElement("BasketIcon"));
                break;
            case "SearchClearButton":
                marketplaceLandingPage.enterValueIntoElement("test","SearchKeywords");
                LOGGER.debug("Entered value - test into Search box");
                break;
        }
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", marketplaceLandingPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", marketplaceLandingPage.elementIsNotDisplayed( elementName ));
    }

    @Then ("^On the Marketplace Landing page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage)getCurrentPage();
        String actualValue = marketplaceLandingPage.getElementValue( elementName );
        LOGGER.debug( "Marketplace Landing Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Marketplace Landing page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage)getCurrentPage();
        Integer actualNumber = marketplaceLandingPage.getListElementCount( listElementName );
        LOGGER.debug( "Marketplace Landing Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }



    @Then("^On the Marketplace Landing page - I enter shared item into '([^\"']*)'$")
    public void enterSharedItemID( String elementName )  throws Throwable
    {
        String value = props.get("SupID");
        LOGGER.debug( "Marketplace Landing Page ... Enter value " + value + " into element " + elementName + "\n" );
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage)getCurrentPage();
        marketplaceLandingPage.enterValueIntoElement( value, elementName);
    }

    @Then("^On the Marketplace Landing page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception {
        LOGGER.debug("Marketplace Landing Page ... Click " + buttonName + " button" + "\n");
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage) getCurrentPage();
        switch (buttonName) {
            case "Lists":
                setCurrentPage(marketplaceLandingPage.clickListsButton());
                break;
            case "Basket":
                setCurrentPage(marketplaceLandingPage.clickBasketButton());
                break;
            case "Search":
                setCurrentPage(marketplaceLandingPage.clickSearchButton());
                break;
            case "Quotes":
                setCurrentPage(marketplaceLandingPage.clickMPBtns(buttonName));
                break;
            case "CompareItems": setCurrentPage(marketplaceLandingPage.clickOnElement(buttonName));break;
            default:
                throw new RuntimeException("No case statement for button: " + buttonName);
        }

    }

    @Then("^On the Marketplace Landing page Jupiter - I click on the '([^\"']*)' button$")
    public void clickThisButton( String buttonName ) throws Exception {
        LOGGER.debug("Marketplace Landing Page Jupiter ... Click " + buttonName + " button" + "\n");
        MarketplaceLandingPageJupiter marketplaceLandingPageJupiter = (MarketplaceLandingPageJupiter) getCurrentPage();
        switch (buttonName) {
            case "Lists":
                setCurrentPage(marketplaceLandingPageJupiter.clickListsButton());
                break;
            case "Basket":
                setCurrentPage(marketplaceLandingPageJupiter.clickBasketButton());
                break;
            case "Search":
                setCurrentPage(marketplaceLandingPageJupiter.clickSearchButton());
                break;
            case "Quotes":
                setCurrentPage(marketplaceLandingPageJupiter.clickMPBtns(buttonName));
                break;
            case "CompareItems": setCurrentPage(marketplaceLandingPageJupiter.clickOnElement(buttonName));break;
            default:
                throw new RuntimeException("No case statement for button: " + buttonName);
        }

    }

//    @Then("^On the Marketplace Landing page - I click on the '([^\"']*)' toggle$")
//    public void clickToggle( String buttonName ) throws Exception {
//        LOGGER.debug("Marketplace Landing Page ... Click " + buttonName + "\n");
//        MarketplaceLandingPageGrails marketplaceLandingPageGrails = (MarketplaceLandingPageGrails) getCurrentPage();
//        setCurrentPage(marketplaceLandingPageGrails.switchToNewUI());
//    }

    @Then("^On the Marketplace Landing page - I enter item into '([^\"']*)'$")
    public void enterItemID( String elementName )  throws Throwable
    {
        String value = props.get("SupID");
        LOGGER.debug( "Marketplace Landing Page ... Enter value " + value + " into element " + elementName + "\n" );
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage)getCurrentPage();
        marketplaceLandingPage.enterValueIntoElement( value, elementName);
    }

    @Then ("^On the Marketplace Landing page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Marketplace Landing Page ... Enter value " + value + " into element " + elementName + "\n" );
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage)getCurrentPage();
        marketplaceLandingPage.enterValueIntoElement( value, elementName);
    }

    @When("On the Marketplace Landing page Jupiter - I click on the '([^\"']*)' link")
    public void clickTheLink(String link) {
        LOGGER.debug("Marketplace Landing Page ... Click " + link + " link" + "\n");
        MarketplaceLandingPageJupiter marketplaceLandingPageJupiter = (MarketplaceLandingPageJupiter) getCurrentPage();
        setCurrentPage(marketplaceLandingPageJupiter.clickLink(link));
    }

    @When("On the Marketplace Landing page - I click on the '([^\"']*)' link")
    public void clickLink(String link) {
        LOGGER.debug("Marketplace Landing Page ... Click " + link + " link" + "\n");
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage) getCurrentPage();
        setCurrentPage(marketplaceLandingPage.clickLink(link));
    }

}
