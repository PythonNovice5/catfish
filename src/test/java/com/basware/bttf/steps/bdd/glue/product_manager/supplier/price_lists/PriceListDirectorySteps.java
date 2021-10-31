package com.basware.bttf.steps.bdd.glue.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.supplier.price_lists.ManagePriceListPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListDeliveryItemsDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListStandardItemsDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PriceListDirectorySteps extends AbstractSteps
{
    @Then("^I click on the Price List Directory '([^\"']*)' button$")
    public void clickPriceListDirectoryButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Price List Directory Page ... Click " + buttonName + " button" + "\n" );
        switch( buttonName )
        {
            case "Create":
                PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
                setCurrentPage( priceListDirectoryPage.clickButtonCreate()); break;
            case "Plus":
                PriceListDeliveryItemsDirectoryPage priceListDeliveryItemsDirectoryPage= (PriceListDeliveryItemsDirectoryPage)getCurrentPage();
                setCurrentPage( priceListDeliveryItemsDirectoryPage.addDeliveryItem());
                break;
            case "Done":
                priceListDeliveryItemsDirectoryPage = (PriceListDeliveryItemsDirectoryPage)getCurrentPage();
                setCurrentPage(priceListDeliveryItemsDirectoryPage.clickDone());
                break;
            case "Delete":
                priceListDirectoryPage = (PriceListDirectoryPage)getCurrentPage();
                setCurrentPage(priceListDirectoryPage.clickButton(buttonName));
                break;
            default:
                priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
                setCurrentPage( priceListDirectoryPage.clickButton(buttonName)); break;
        }
    }

    @Then("^I click on the Price List Directory '([^\"']*)' page filter$")
    public void clickManagePriceListDirectoryFilter( String filterName ) throws Exception
    {
        LOGGER.debug( "Price List Directory Page ... Click " + filterName + " filter$" + "\n" );
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
        setCurrentPage( priceListDirectoryPage.clickFilter(filterName));
    }

    @Then ("^I enter '([^\"]*)' into Price List Directory '([^\"']*)'$")
    public void enterValueIntoPriceListDirectoryField( String value, String fieldName )  throws Throwable
    {
        LOGGER.debug( "Price List Directory Page ... Enter value " + value + " into field " + fieldName + "\n" );
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
        priceListDirectoryPage.enterValueIntoField( value, fieldName);
    }

    @Then ("^I click on the Price List Directory first price list name$")
    public void clickPriceListDirectoryFirstPriceListName() throws Throwable
    {
        LOGGER.debug( "Price List Directory Page ... Click first price list name" + "\n" );
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
        setCurrentPage( priceListDirectoryPage.clickFirstPriceListNameClick() );
    }

    @Then ("^I click on the Price List Directory first price list '([^\"']*)' button$")
    public void clickPriceListDirectoryFirstPriceListButton( String buttonName ) throws Throwable
    {
        LOGGER.debug( "Price List Directory Page ... Click first price list " + buttonName + " button" + "\n" );
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
        setCurrentPage( priceListDirectoryPage.clickFirstPriceListButtonManage() );
    }

    @When("^On Price list Standard Item page - I search recently created item in '([^\"']*)'$")
    public void searchItem(String element) throws Exception
    {
        PriceListStandardItemsDirectoryPage priceListStandardItemsDirectoryPage = (PriceListStandardItemsDirectoryPage) getCurrentPage();
        String value = props.get("SupID");
        priceListStandardItemsDirectoryPage.searchNewPricelist(value);
    }

    @And("^on Price list Standard Items page - I click on '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Throwable
    {
        LOGGER.debug( "Price List Standard Items Directory Page ... Click " + buttonName + " button" + "\n" );
        PriceListStandardItemsDirectoryPage priceListStandardItemsDirectoryPage = (PriceListStandardItemsDirectoryPage) getCurrentPage();
        setCurrentPage( priceListStandardItemsDirectoryPage.clickButton(buttonName));
        props.set("StdItemCount","1");
    }

    @And("^on Price list Standard Items page - I verify that '([^\"']*)' items are added$")
    public void verifyAddedItems(String itemCount) throws Throwable
    {
        LOGGER.debug( "Price list Standard Items page ... + " + "\n" );
        PriceListStandardItemsDirectoryPage priceListStandardItemsDirectoryPage = (PriceListStandardItemsDirectoryPage) getCurrentPage();
        setCurrentPage( priceListStandardItemsDirectoryPage.verifyAddedItems(itemCount));
    }

    @Then("I check that '([^\"']*)' filter works as expected")
    public void checkFilter(String filter) throws Exception {
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage)getCurrentPage();
        setCurrentPage(priceListDirectoryPage.checkFilter(filter));
    }

    @Then("On Price List Directory page - I verify that '([^\"']*)' option is applied in '([^\"']*)'")
    public void verifyOption(String filter, String filterValue) throws Exception {
        LOGGER.debug( "Price List Directory page ... verifying " + filter + " filter" + "\n" );
        if (filterValue.contains("SortFilterValue")){
            filter = "Sort by "+filter;}
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
        String actualFilterValue = priceListDirectoryPage.getElementValue(filterValue) ;
        LOGGER.debug( "Price List Directory page:  Comparing " + filter + ": Expected:[" + filter + "] Actual:[" + actualFilterValue + "]" + "\n");
        assertEquals( "Unexpected value", filter, actualFilterValue );
    }


    @And("On Price list Standard Items page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterVal(String value, String fieldName) throws Exception {
        LOGGER.debug( "On Price list Standard Items page ... Enter value " + value + " into field " + fieldName + "\n" );
        PriceListStandardItemsDirectoryPage priceListStandardItemsDirectoryPage = (PriceListStandardItemsDirectoryPage) getCurrentPage();
        priceListStandardItemsDirectoryPage.enterValueIntoElement( value,fieldName);
    }
}
