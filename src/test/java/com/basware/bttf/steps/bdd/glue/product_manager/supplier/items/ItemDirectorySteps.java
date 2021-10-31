package com.basware.bttf.steps.bdd.glue.product_manager.supplier.items;
// Created by Julian Sheppard on 21/06/2017

import com.basware.bttf.pages.AbstractPage;
import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.items.EditItemPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ItemTemplateDirectoryPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceItemDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemDirectorySteps extends AbstractSteps
{
    @Then("^On the Item Directory page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        LOGGER.debug( "Item Directory Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", itemDirectoryPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", itemDirectoryPage.elementIsNotDisplayed( elementName ));
    }

    @When("^On the Marketplace Item Directory page - I click on '([^\"']*)' checkbox$")
    public void clickMPButton(String element) throws Throwable {
        LOGGER.debug( "On the Marketplace Item Directory page ... Click " + element + " checkbox" + "\n" );
        MarketplaceItemDirectoryPage marketplaceItemDirectoryPage = (MarketplaceItemDirectoryPage) getCurrentPage();
        setCurrentPage( marketplaceItemDirectoryPage.clickButton( element ));
    }

    @Then("^On the Marketplace Item Directory page - I click on '([^\"']*)' button$")
    public void clickThisButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "On the Marketplace Item Directory page ... Click " + buttonName + " button" + "\n" );
        MarketplaceItemDirectoryPage marketplaceItemDirectoryPage = (MarketplaceItemDirectoryPage) getCurrentPage();
        switch( buttonName )
        {
            case "Get Quotes": setCurrentPage(marketplaceItemDirectoryPage.getQuoteForItem());break;
        }
    }

    @Then("^On the Item Directory page - I check that first item '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatFirstItemElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        checkThatElementIsDisplayed( "FirstItem" + elementName, isOrIsNot );
    }

    @Then("On the Item Directory page - I validate the '([^\"']*)' filter value in '([^\"']*)'$")
    public void validateFilterValue(String filterName, String results) throws Exception {
        filterName = filterName + "Filter";
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        String actualValueResults = itemDirectoryPage.getElementValue(results);
        actualValueResults= actualValueResults.substring(actualValueResults.lastIndexOf("/") + 1);
        String actualValueFilter = Long.toString( itemDirectoryPage.extractFilterCount(filterName ));
        LOGGER.debug( "Item Directory Page ... Validating " + filterName + ": Expected:[" + actualValueFilter.trim() + "] Actual:[" + actualValueResults.trim() + "]" + "\n");
        assertEquals(actualValueFilter.trim()+" is not matching with "+actualValueResults.trim(),actualValueFilter.trim(),actualValueResults.trim());

    }

    @Then ("^On the Item Directory page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        String actualValue = itemDirectoryPage.getElementValue( elementName );
        LOGGER.debug( "Item Directory Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Item Directory page - I check that first item '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatFirstItemElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        checkThatElementValueIs( "FirstItem" + elementName, expectedValue );
    }

    @Then ("^On the Item Directory page - I check that first item '([^\"']*)' value is '([^\"]*)' plus SessionGUID$")
    public void checkThatElementValueIsPlusGUID( String elementName, String expectedValue ) throws Throwable
    {
        String sessionGUID = getCurrentPage().getSessionID();
        checkThatElementValueIs( "FirstItem" + elementName, expectedValue + sessionGUID );
    }

    @Then ("^On the Item Directory page - I check that the number of '([^\"']*)' is '([^\"']*)'$")
    public void checkThatNumberOfElementsIs( String listElementName, Integer expectedNumber ) throws Throwable
    {
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        Integer actualNumber = itemDirectoryPage.getListElementCount( listElementName );
        LOGGER.debug( "Item Directory Page ... Comparing " + listElementName + " count: Expected:[" + expectedNumber + "] Actual:[" + actualNumber + "]" + "\n");
        assertEquals( "Unexpected count", expectedNumber, actualNumber );
    }

    @Then ("^On the Item Directory page - I check that '([^\"']*)' filter count is '([^\"']*)'$")
    public void checkThatFilterCountIs( String filterName, String expectedValue ) throws Throwable
    {
        filterName = filterName + "Filter";
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        String actualValue = Long.toString( itemDirectoryPage.extractFilterCount( filterName ) );
        LOGGER.debug( "Item Directory Page ... Comparing " + filterName + " filter: Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then ("^On the Item Directory page - I check that filter counts are consistent$")
    public void checkThatFilterCountsConsistent() throws Throwable
    {
        LOGGER.debug( "Item Directory Page ... Check that filter counts are consistent" + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        assertTrue("Filter counts are unexpectedly inconsistent", itemDirectoryPage.areCountsAreConsistent());
    }

    @Then ("^On the Item Directory page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Item Directory Page ... Enter value " + value + " into element " + elementName + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        if(value.contains("SupID")){
            value = props.get("SupID");
        }
        itemDirectoryPage.enterValueIntoElement( value, elementName);
    }

    @Then("^On the Item Directory page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Item Directory Page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        switch( dropdownName )
        {
            case "Order By": itemDirectoryPage.selectOrderBy( dropdownOption ); break;
            case "Per Page": itemDirectoryPage.selectPerPage( dropdownOption ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @Then("^On the Item Directory page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Item Directory Page ... Click " + buttonName + " button" + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        switch( buttonName )
        {
            case "Create": setCurrentPage( itemDirectoryPage.clickButtonCreate() ); break;
            // default for those elements that cause page re-load
            default: setCurrentPage( itemDirectoryPage.clickPageReloadingElement( buttonName ) );
        }
    }

    @Then("On the Item Directory page - I verify that '([^\"']*)' option is applied in '([^\"']*)'$")
    public void verifyOptionApplied(String filter,String filterValue) throws Exception{
        LOGGER.debug( "Item Directory page ... verifying " + filter + " filter" + "\n" );
        if (filterValue.contains("SortFilterValue")){
        filter = "Sort by "+filter;}
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        String actualFilterValue = itemDirectoryPage.getElementValue(filterValue) ;
        LOGGER.debug( "Item Directory Page ... Comparing " + filter + ": Expected:[" + filter + "] Actual:[" + actualFilterValue + "]" + "\n");
        assertEquals( "Unexpected value", filter, actualFilterValue );
    }

    @When("^On the Item Directory page - I click on the '([^\"']*)' link$")
    public void clickLink( String linkName ) throws Exception
    {
        LOGGER.debug( "Item Directory page ... Click " + linkName + " link" + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        switch( linkName )
        {
            case "First Item Name": setCurrentPage( itemDirectoryPage.clickFirstItemName() ); break;
            case "First Item Image": setCurrentPage( itemDirectoryPage.clickFirstItemImage() ); break;
            default: throw new RuntimeException("No case statement matching: " + linkName);
        }
    }

    @When("^On the Item Directory page - I click on the '([^\"']*)' filter$")
    public void clickFilter(String filterName) throws Throwable {
        LOGGER.debug( "Item Directory Page ... Click " + filterName + " filter" + "\n" );
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        setCurrentPage( itemDirectoryPage.clickPageReloadingElement( filterName ) );
    }

    // Need to use this step after inserting an item because updating of search index is not immediate
    @Then("^On the Item Directory page - I search for '([^\"]*)' until found or timeout$")
    public void searchForItem( String itemName ) throws Exception
    {
        ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
        if(itemName.contains("SupID")){
            itemName = props.get("SupID");
        }
        LOGGER.debug( "Item Directory page ... Search for " + itemName + "\n" );
        setCurrentPage( itemDirectoryPage.searchForItemUntilFoundOrTimeout( itemName ) );
    }

    @When("^On the Item Directory page - I find and remove all CATFISH- items$")
    public void removeAllCatfishItems() throws Exception {
        for(int i=1; i<1000; i++)
        {
            ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
            itemDirectoryPage.enterValueIntoElement( "CATFISH-", "SearchKeywords");
            itemDirectoryPage.clickButton( "SearchButton");
            itemDirectoryPage.clickPageReloadingElement("New");
            if( itemDirectoryPage.elementIsNotDisplayed("FirstItemName") )  break;
            if( ! StringUtils.left( itemDirectoryPage.getElementValue( "FirstItemItemID" ) , 8 ).equals("CATFISH-") )  break;
            setCurrentPage( itemDirectoryPage.clickFirstItemName() );
            EditItemPage editItemPage = (EditItemPage) getCurrentPage();
            setCurrentPage(editItemPage.clickDeleteButton());
        }
    }


    @When("^On the Item template Directory page - I search '([^\"]*)'$")
    public void searchItemTemplate(String itemTemplate) throws Throwable {
        ItemTemplateDirectoryPage itemTemplateDirectoryPage = (ItemTemplateDirectoryPage) getCurrentPage();
        setCurrentPage(itemTemplateDirectoryPage.searchItemTemplate(itemTemplate));
    }

    @When("^On the Item template Directory page - I add the item template$")
    public void addTemplate() throws Throwable {
        ItemTemplateDirectoryPage itemTemplateDirectoryPage = (ItemTemplateDirectoryPage)getCurrentPage();
        setCurrentPage(itemTemplateDirectoryPage.addTemplate());
    }

    @When("^On the Item Template Directory page - I click on the '([^\"]*)' button$")
    public void clickBtn(String btnValue) throws Exception {
        ItemTemplateDirectoryPage itemTemplateDirectoryPage = (ItemTemplateDirectoryPage)getCurrentPage();
        switch (btnValue) {
            case "Create":
                setCurrentPage(itemTemplateDirectoryPage.clickButtonCreate());
                break;

            case "Delete":
                setCurrentPage(itemTemplateDirectoryPage.clickButton(btnValue));
                break;

        }

        }
        @When("^On the Item template Directory page - I add the item template for Edit Item page$")
        public void addTemplateforEditItem() throws Throwable {
            ItemTemplateDirectoryPage itemTemplateDirectoryPage = (ItemTemplateDirectoryPage) getCurrentPage();
            setCurrentPage(itemTemplateDirectoryPage.addTemplateEditItem());
        }

        @Then("^On the Item Directory page - I verify '([^\"]*)' is displayed$")
        public void verifyAlertMsg(String msg) throws Throwable
        {
             ItemDirectoryPage itemDirectoryPage = (ItemDirectoryPage) getCurrentPage();
             setCurrentPage(itemDirectoryPage.verifyAlertMsg(msg));
        }


    @Then ("^On the Item Directory page - I check that first item '([^\"']*)' value is as expected$")
    public void checkElemValue( String elementName) throws Throwable
    {
        String expectedValue = props.get("SupID");
        checkThatElementValueIs( "FirstItem" + elementName, expectedValue);
    }


}
