package com.basware.bttf.steps.bdd.glue.shopping.marketplace;
// Created by Julian Sheppard on 21/05/2017

import com.basware.bttf.pages.shopping.marketplace.ShoppingListsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingListsSteps extends AbstractSteps
{
    @Then("^On the Shopping Lists page - I empty the My Lists lists$")
    public void emptyTheShoppingBasket() throws Throwable
    {
        LOGGER.debug( "Shopping Lists Page ... Emptying My Lists lists" + "\n");
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        shoppingListsPage.emptyTheMyListsLists();
    }

    @Then("^On the Shopping Lists page - I remove any My List named '([^\"]*)'$")
    public void emptyTheShoppingBasket( String listName ) throws Throwable
    {
        LOGGER.debug( "Shopping Lists Page ... Remove any My List named " + listName + "\n");
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        setCurrentPage( shoppingListsPage.removeAMyList( listName ) );
    }

    @Then("^On the Shopping Lists page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Shopping Lists Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", shoppingListsPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", shoppingListsPage.elementIsNotDisplayed( elementName ));
    }

    @Then("^On the Shopping Lists page - I check that '([^\"']*)' '(is|is not)' enabled$")
    public void checkThatElementIsEnabled( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Shopping Lists Page ... Check " + elementName + " " + isOrIsNot + " enabled" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be clickable
            assertTrue(elementName + " element is unexpectedly not enabled", shoppingListsPage.elementIsEnabled( elementName ));
        else                                // if expecting the element not to be clickable
            assertTrue(elementName + " element is unexpectedly enabled", !shoppingListsPage.elementIsEnabled( elementName ));
    }

    @Then("^On the Shopping Lists page - I check that '([^\"']*)' '(is|is not)' readonly")
    public void checkThatElementIsReadOnly( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Shopping Lists Page ... Check " + elementName + " " + isOrIsNot + " readonly" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be readonly
            assertTrue(elementName + " element is unexpectedly not enabled", shoppingListsPage.elementIsReadOnly( elementName ));
        else                                // if expecting the element not to be readonly
            assertTrue(elementName + " element is unexpectedly enabled", !shoppingListsPage.elementIsReadOnly( elementName ));
    }

    @Then ("^On the Shopping Lists page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        String actualValue = shoppingListsPage.getElementValue( elementName );
        LOGGER.debug( "Shopping Lists Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Shopping Lists page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        Integer actualNumber = shoppingListsPage.getListElementCount( listElementName );
        LOGGER.debug( "Shopping Lists Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }

    @Then ("^On the Shopping Lists page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Shopping Lists Page ... Enter value " + value + " into element " + elementName + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        shoppingListsPage.enterValueIntoElement( value, elementName);
       }

    @Then ("^On the Shopping Lists page - I enter '([^\"]*)' into '([^\"']*)' associated with '([^\"']*)' '([^\"]*)'$")
    public void enterValueIntoElement( String value, String inputListElementName, String searchableListElementName, String searchText ) throws Exception
    {
        LOGGER.debug( "Shopping Lists Page ... Enter value " + value + " into element " + inputListElementName + " associated with "+ searchableListElementName + " " + searchText + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        switch( inputListElementName )
        {
            case "Quantity": shoppingListsPage.enterValueIntoQuantity( value, searchText ); break;
            default: throw new Exception("Unrecognised inputListElementName");
        }
    }


    @Then("^On the Shopping Lists page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Shopping Lists Page ... Click " + buttonName + " button" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        switch( buttonName )
        {
            case "Basket": setCurrentPage( shoppingListsPage.clickBasketButton() ); break;
            case "BuyAll": setCurrentPage( shoppingListsPage.clickBuyAllButton() ); break;
            case "Create": shoppingListsPage.clickButton( "CreateButton" ); break;
            case "Rename": shoppingListsPage.clickButton( "RenameListButton" ); break;
            case "Delete": shoppingListsPage.clickButton( "DeleteListButton" ); break;
            case "ModalCreateOK": shoppingListsPage.clickButton( "ModalCreateOKButton" ); break;
            case "ModalCreateCancel": shoppingListsPage.clickButton( "ModalCreateCancelButton" ); break;
            case "ModalRenameOK": shoppingListsPage.clickButton( "ModalRenameOKButton" ); break;
            case "ModalRenameCancel": shoppingListsPage.clickButton( "ModalRenameCancelButton" ); break;
            case "ModalDeleteOK": shoppingListsPage.clickButton( "ModalDeleteOKButton" ); break;
            case "ModalDeleteCancel": shoppingListsPage.clickButton( "ModalDeleteCancelButton" ); break;
            // default for those elements that cause page re-load
            default: setCurrentPage( shoppingListsPage.clickPageReloadingElement( buttonName ) );
        }
    }

    @Then("^On the Shopping Lists page - I click on the first item '([^\"']*)' button$")
    public void clickFirstItemButton( String buttonName ) throws Exception
    {
        clickButton( "first item " + buttonName );
    }

    @Then("^On the Shopping Lists page - I click on the '([^\"']*)' breadcrumb$")
    public void clickBreadcrumb( String breadcrumbName ) throws Exception
    {
        LOGGER.debug( "Shopping Lists Page ... Click " + breadcrumbName + " breadcrumb" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        switch( breadcrumbName )
        {
            case "Home": setCurrentPage( shoppingListsPage.clickHomeBreadcrumb() ); break;
            default: throw new Exception("Unrecognised breadcrumb");
        }
    }

    @Then("^On the Shopping Lists page - I click on the '([^\"']*)' list selection$")
    public void clickListSelection( String listElementName ) throws Exception
    {
        LOGGER.debug( "Shopping Lists Page ... Click " + listElementName + " list selection" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        switch( listElementName )
        {
            default: shoppingListsPage.clickListSelection( listElementName );
        }
    }

    @Then("^On the Shopping Lists page - I click on the '([^\"']*)' '([^\"]*)' link$")
    public void clickListLink( String listElementName, String text ) throws Exception
    {
        LOGGER.debug( "Shopping Lists Page ... Click " + listElementName + " " + text + " link" + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        switch( listElementName )
        {
            case "Item Name": setCurrentPage( shoppingListsPage.clickAnItemName( text ) ); break;
            default: shoppingListsPage.clickListLink( listElementName, text );
        }
    }

    @Then("^On the Shopping Lists page - I click on the '([^\"']*)' button associated with '([^\"']*)' '([^\"]*)'$")
    // WARNING! Unreliable when the element being sought may or may not be present e.g. either an add or remove button is present
    public void clickListLink( String clickableListElementName, String searchableListElementName, String searchText ) throws Exception
    {
        LOGGER.debug( "Shopping Lists Page ... Click " + clickableListElementName + " button associated with "+ searchableListElementName + " " + searchText + "\n" );
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage)getCurrentPage();
        switch( clickableListElementName )
        {
            case "Add To Basket": shoppingListsPage.clickAnAddToBasketButton( searchText ); break;
            case "Remove From Basket": shoppingListsPage.clickARemoveFromBasketButton( searchText ); break;
            default: throw new Exception("Unrecognised clickableListElementName");
        }
    }

}
