package com.basware.bttf.steps.bdd.glue.shopping.marketplace;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.external.ShoppingBasketPageJupiter;
import com.basware.bttf.pages.product_manager.buyer.agreements.UploadAgentItemsPage;
import com.basware.bttf.pages.shared.ImportPageUtil;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.generator.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.net.ssl.SNIHostName;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingBasketSteps extends AbstractSteps
{
    @Then("^On the Shopping Basket page - I empty the shopping basket$")
    public void emptyTheShoppingBasket() throws Throwable
    {
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        shoppingBasketPage.emptyTheBasket();
    }


    @Then("^On the Shopping Basket page Jupiter - I empty the shopping basket$")
    public void emptyTheShoppingBasketInJupiterExternal() throws Throwable
    {
        ShoppingBasketPageJupiter shoppingBasketPageJupiter = (ShoppingBasketPageJupiter) getCurrentPage();
        shoppingBasketPageJupiter.emptyTheBasket();
    }


    @And("^On the Shopping Basket page Jupiter - I click on the '([^\"']*)' breadcrumb$")
    public void clickTheBreadcrumb( String breadcrumbName ) throws Exception
    {
        LOGGER.debug( "Shopping Basket Page Jupiter... Click " + breadcrumbName + " breadcrumb" + "\n" );
        ShoppingBasketPageJupiter shoppingBasketPageJupiter = (ShoppingBasketPageJupiter) getCurrentPage();
        switch( breadcrumbName )
        {
            case "Home": setCurrentPage( shoppingBasketPageJupiter.clickHomeBreadcrumb() ); break;
            case "Back Link": setCurrentPage( shoppingBasketPageJupiter.clickBackLinkBreadcrumb() ); break;
            default: throw new Exception("Unrecognised breadcrumb");
        }
    }

    @Then("^On the Shopping Basket page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Shopping Basket Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", shoppingBasketPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", shoppingBasketPage.elementIsNotDisplayed( elementName ));
    }

    @Then("^On the Shopping Basket page - I check that first item '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatFirstItemElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        checkThatElementIsDisplayed( "FirstItem" + elementName, isOrIsNot );
    }

    @Then ("^On the Shopping Basket page Jupiter - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        ShoppingBasketPageJupiter shoppingBasketPageJupiter = (ShoppingBasketPageJupiter) getCurrentPage();
        String actualValue = shoppingBasketPageJupiter.getElementValue( elementName );
        LOGGER.debug( "Shopping Basket Page Jupiter... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Shopping Basket page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        String actualValue = shoppingBasketPage.getElementValue( elementName );
        LOGGER.debug( "Shopping Basket Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then("^On the Shopping Basket page - I verify template customisations$")
    public void verifyCustomisation()
    {
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        shoppingBasketPage.verifyTemplateCustomisationPreset();
    }

    @Then ("^On the Shopping Basket page - I check that first item '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatFirstItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "FirstItem" + elementName, expectedValue );
    }

    @Then ("^On the Shopping Basket page Jupiter - I check that first item '([^\"']*)' value is '([^\"]*)'$")
    public void checkIftheFirstItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkElementValueIs( "FirstItem" + elementName, expectedValue );
    }

    @Then ("^On the Shopping Basket page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        Integer actualNumber = shoppingBasketPage.getListElementCount( listElementName );
        LOGGER.debug( "Shopping Basket Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }

    @Then ("^On the Shopping Basket page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Shopping Basket Page ... Enter value " + value + " into " + elementName + "\n");
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        shoppingBasketPage.enterValueIntoElement( value, elementName);
    }

    @Then ("^On the Shopping Basket page - I enter '([^\"]*)' into first item '([^\"']*)'$")
    public void enterValueIntoFirstItemElement( String value, String elementName )  throws Throwable
    {
        enterValueIntoElement( value, "FirstItem" + elementName);
    }

    @Then("^On the Shopping Basket page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Shopping Basket Page ... Click " + buttonName + " button" + "\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        switch( buttonName )
        {
            case "HeaderAlertMessageClose": shoppingBasketPage.clickButton( "HeaderAlertMessageClose"); break;
            case "EmptyBasket": shoppingBasketPage.clickButton( "EmptyBasketButton"); break;
            case "Checkout": setCurrentPage( shoppingBasketPage.clickCheckoutButton() ); break;
            case "CheckoutPO": setCurrentPage( shoppingBasketPage.clickOnCheckButton() ); break;
            // default for those elements that cause page re-load
            case "Import": shoppingBasketPage.clickButton("importBOMButton");break;
            case "Process":setCurrentPage(shoppingBasketPage.clickProcessButton());break;
                       default: setCurrentPage( shoppingBasketPage.clickPageReloadingElement( buttonName ) );
        }
    }


    @And("^On the Shopping Basket page - I verify the '([^\"']*)' dialog box$")
    public void verify( String dialogBoxName ) throws Exception
    {
        LOGGER.debug("Verifying the "+dialogBoxName+" dialog box");
        ShoppingBasketPage shoppingBasketPage= (ShoppingBasketPage)getCurrentPage();
        shoppingBasketPage.verifyDialogBox(dialogBoxName);

    }

    @When("^On the Shopping Basket page - I upload the ([^\"']*) file ([^\"']*)$")
    public void uploadFile(String fileType,String fileName) throws Throwable
    {
        LOGGER.debug( "Uploading file: " + fileName +"\n");
        ShoppingBasketPage shoppingBasketPage =(ShoppingBasketPage)getCurrentPage();
        switch (fileType.toLowerCase()){
            case "xlsx":
                shoppingBasketPage.enterFileToUpload(fileName);
                break;
            default:
                break;
        }
    }

    @Then("^On the Shopping Basket page - I click on the first item '([^\"']*)' button$")
    public void clickFirstItemButton( String buttonName ) throws Exception
    {
        clickButton( "first item " + buttonName );
    }

    @Then("^On the Shopping Basket page - I click on the '([^\"']*)' breadcrumb$")
    public void clickBreadcrumb( String breadcrumbName ) throws Exception
    {
        LOGGER.debug( "Shopping Basket Page ... Click " + breadcrumbName + " breadcrumb" + "\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        switch( breadcrumbName )
        {
            case "Home": setCurrentPage( shoppingBasketPage.clickHomeBreadcrumb() ); break;
            case "Back Link": setCurrentPage( shoppingBasketPage.clickBackLinkBreadcrumb() ); break;
            default: throw new Exception("Unrecognised breadcrumb");
        }
    }

    @Then("^On the Shopping Basket page - I click on the first item '([^\"']*)' link")
    public void clickLink( String linkName ) throws Exception
    {
        LOGGER.debug( "Shopping Basket Page ... Click first item " + linkName + " link" + "\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        switch( linkName )
        {
            case "Name": setCurrentPage( shoppingBasketPage.clickFirstItemNameLink() ); break;
            default: throw new RuntimeException("No case statement for linkName: " + linkName);
        }
    }

    @And("^On the Shopping Basket page - I log the state of '([^\"']*)' '(\\d+)' times$")
    public void logTheStateOfElement( String elementName, int noOfTimes )  throws Throwable
    {
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        shoppingBasketPage.logTheStateOfElement( elementName, noOfTimes );
    }


    @Then("^On the Shopping Basket page - I check that the '([^\"']*)' is present$")
    public void checkStatus( String elementName)  throws Throwable
    {
        LOGGER.debug("Checking if "+elementName+" is present in Shopping Basket");
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        setCurrentPage(shoppingBasketPage.checkStatus( elementName));
    }

    @Then("^On the Shopping Basket page - I store the item details$")
    public void storeDetails()  throws Throwable
    {
        LOGGER.debug("Storing Item details present in Shopping Basket");
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
//        props.set("ItemDesc",shoppingBasketPage.getElementValue("FirstItemDescription"));
        props.set("ItemID",shoppingBasketPage.getElementValue("FirstItemItemID"));
        props.set("ItemPriceWithoutTax",shoppingBasketPage.getElementValue("FirstItemPriceWithoutTax"));
        props.set("ItemCurrency",shoppingBasketPage.getElementValue("SummaryFirstSupplierShoppingBasketCurrency"));
    }

    @Then("^On the Shopping Basket page Jupiter - I store the item details$")
    public void storeTheDetails()  throws Exception
    {
        LOGGER.debug("Storing Item details present in Shopping Basket Jupiter");
        ShoppingBasketPageJupiter shoppingBasketPageJupiter = (ShoppingBasketPageJupiter) getCurrentPage();
//        props.set("ItemDesc",shoppingBasketPage.getElementValue("FirstItemDescription"));
//        props.set("ItemID",shoppingBasketPageJupiter.getElementValue("FirstItemItemID"));
//        props.set("ItemTotalAmount",shoppingBasketPageJupiter.getElementValue("SummaryFirstSupplierItemTotalAmount"));
//        props.set("ItemCurrency",shoppingBasketPageJupiter.getElementValue("SummaryFirstSupplierShoppingBasketCurrency"));

        props.set("ItemID",shoppingBasketPageJupiter.getElementValue("FirstItemItemID"));
        props.set("ItemPriceWithoutTax",shoppingBasketPageJupiter.getElementValue("FirstItemPriceWithoutTax"));
        props.set("ItemCurrency",shoppingBasketPageJupiter.getElementValue("SummaryFirstSupplierShoppingBasketCurrency"));
    }

    @Then("^On the Shopping Basket page Jupiter - I click on the '([^\"']*)' button$")
    public void clickThisButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Shopping Basket Page Jupiter ... Click " + buttonName + " button" + "\n" );
        ShoppingBasketPageJupiter shoppingBasketPageJupiter = (ShoppingBasketPageJupiter) getCurrentPage();
        switch( buttonName )
        {
            case "HeaderAlertMessageClose": shoppingBasketPageJupiter.clickButton( "HeaderAlertMessageClose"); break;
            case "EmptyBasket": shoppingBasketPageJupiter.clickButton( "EmptyBasketButton"); break;
            case "Checkout": setCurrentPage( shoppingBasketPageJupiter.clickCheckoutButton() ); break;
            case "CheckoutPO": setCurrentPage( shoppingBasketPageJupiter.clickOnCheckButton() ); break;
            case "CheckoutInternalSite":setCurrentPage( shoppingBasketPageJupiter.clickCheckoutInternalSite() ); break;
            case "CompareItems": setCurrentPage(shoppingBasketPageJupiter.clickOnElement(buttonName));break;
            // default for those elements that cause page re-load
            default: setCurrentPage( shoppingBasketPageJupiter.clickPageReloadingElement( buttonName ) );
        }
    }

}
