package com.basware.bttf.steps.bdd.glue.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.*;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ManagePriceListSteps extends AbstractSteps
{

    @Then("^I click on the Manage Price List '([^\"']*)' breadcrumb$")
    public void clickManagePriceListPageBreadcrumb( String breadcrumbItem ) throws Exception
    {
        LOGGER.debug( "Manage Price List Page ... Click " + breadcrumbItem + " breadcrumb" + "\n" );
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        setCurrentPage( managePriceListPage.managePriceListBreadcrumbClick() );
    }

    @Then ("^I check that Manage Price List '([^\"']*)' is '([^\"]*)'$")
    public void checkManagePriceListFieldIsValue( String fieldName, String expectedValue ) throws Throwable
    {
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        String actualValue = managePriceListPage.getFieldValue( fieldName );
        LOGGER.debug( "Manage Price List Page ... Comparing " + fieldName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( expectedValue, actualValue );
    }

    @Then ("^I check that Manage Price List help text length is not 0$")
    public void checkManagePriceListHelpTextLengthNotZero() throws Throwable
    {
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        long expectedValue = 0;
        long actualValue = managePriceListPage.getHelpTextLength();
        LOGGER.debug( "Manage Price List Page ... Checking length of help text: Not Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertNotEquals(expectedValue, actualValue);
    }


    @Then ("^I enter '([^\"]*)' into Manage Price List '([^\"']*)' and click '([^\"']*)'$")
    public void enterValueIntoManagePriceListPageField( String value, String fieldName, String buttonSaveOrCancel ) throws Throwable
    {
        LOGGER.debug( "Manage Price List Page ... Enter value " + value + " into field " + fieldName + " and click " + buttonSaveOrCancel + "\n" );
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        managePriceListPage.enterValueIntoField( value, fieldName, buttonSaveOrCancel );
    }

    @Then("^I click on the Manage Price List '([^\"']*)' button$")
    public void clickManagePriceListPageButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Manage Price List Page ... Click " + buttonName + " button" + "\n" );
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        switch (buttonName)
        {
            case "Delivery Items Manage":
                setCurrentPage(managePriceListPage.clickButtonDeliveryItemsManage());
                break;
            case "Standard Items Manage":
                setCurrentPage( managePriceListPage.clickButtonStandardItemsManage() );
                break;
            case "Bundles View":
                setCurrentPage( managePriceListPage.clickButtonBundlesView() );
                break;
            case "Related Items View":
                setCurrentPage( managePriceListPage.clickButtonRelatedItemsView() );
                break;
            case "Matrix Items Manage":
                setCurrentPage( managePriceListPage.clickButtonMatrixItemsManage() );
                break;
            case "Agreements Manage":
                setCurrentPage( managePriceListPage.clickButtonAgreementsItemsManage() );
                break;
            case "Publish":
                managePriceListPage.clickPublishButton();
                break;
            case "import bundle":
                setCurrentPage(managePriceListPage.clickButtonImportBundledItems());
                break;
            case "import related items":
                setCurrentPage(managePriceListPage.clickButtonImportedRelatedItems());
                break;
            case "import pricelist":
                setCurrentPage(managePriceListPage.clickPriceListImportItems());
                break;
            case "export pricelist":
                managePriceListPage.clickPricelistExportItems();
                break;
        }
    }

    @Then("^On the Manage Price list Item page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement(String value, String elementName) throws Throwable {
        LOGGER.debug("Manage Prie list Item page ... Enter value " + value + " into element " + elementName + "\n");
        ManagePriceListDeliveryItemPage managePriceListDeliveryItemPage = (ManagePriceListDeliveryItemPage) getCurrentPage();
        managePriceListDeliveryItemPage.enterValueIntoElement(value, elementName);
    }



    @Then("^On Manage Price list page - I verify '([^\"]*)' are '([^\"]*)'$")
    public void verifyItems(String itemType, String numOfItems) throws Throwable {
        LOGGER.debug("On Manage Price list page ... I verify that " + itemType + " are " + numOfItems + "\n");
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        String actual_num_items = managePriceListPage.getNumOfItems(itemType);
        LOGGER.debug("Actualy number of Items: "+actual_num_items);
        assertEquals("The expected item count was not found!",actual_num_items,numOfItems);
    }

    @Then("^On the Manage Price list Standard Item page - I enter '([^\"]*)' into '([^\"]*)' in row '([^\"]*)'$")
    public void enterIntoElement(String value, String elementName, String row) throws Throwable {
        LOGGER.debug("Manage Prie list Item page ... Enter value " + value + " into element " + elementName + "\n");
        ManagePriceListStandardItemPage managePriceListStandardItemPage = (ManagePriceListStandardItemPage) getCurrentPage();
        int rowNum = Integer.parseInt(row)-1;
        managePriceListStandardItemPage.enterValue(value,elementName,rowNum);
    }

    @And("^On the Manage Price list Standard Item page - I click on '([^\"]*)' button")
    public void clickButton(String btnValue) throws Throwable {
        LOGGER.debug("Clicking on .. " + btnValue + "\n");
        ManagePriceListStandardItemPage managePriceListStandardItemPage = (ManagePriceListStandardItemPage) getCurrentPage();
        switch(btnValue){
            case "Plus":
                managePriceListStandardItemPage.clickPlusBtn();
                break;
            case "PriceOnRequest4":
                managePriceListStandardItemPage.clickToggle(btnValue,6);
                break;
            case "Save":
                setCurrentPage(managePriceListStandardItemPage.clickSave(btnValue));
                break;

        }
    }


    @And("^On the Manage Price list Update Item Directory page - I click on '([^\"]*)' button")
    public void clickToUpdate(String btnValue) throws Throwable {
        LOGGER.debug("Clicking on .. " + btnValue + "\n");
        ManagePriceListUpdateItemDirectoryPage managePriceListUpdateItemDirectoryPage = (ManagePriceListUpdateItemDirectoryPage) getCurrentPage();
        switch(btnValue){
            case "Save":
                setCurrentPage(managePriceListUpdateItemDirectoryPage.clickSave(btnValue));
                break;
            case "Plus":
                managePriceListUpdateItemDirectoryPage.clickPlusBtn();
        }
    }

    @And("^On Manage Price list Item page - I click on '([^\"]*)' button")
    public void clickBtn(String btnValue) throws Throwable {
        LOGGER.debug("Clicking on .. " + btnValue + "\n");
        switch(btnValue){
            case "Save":
                ManagePriceListDeliveryItemPage managePriceListDeliveryItemPage = (ManagePriceListDeliveryItemPage) getCurrentPage();
                setCurrentPage(managePriceListDeliveryItemPage.clickBtn(btnValue));
                break;
                }

    }

    @And("^On the Manage Price list Item page - I select '([^\"]*)' as '([^\"]*)'")
    public void setTaxDetails(String field,String value) throws Throwable {
        LOGGER.debug("On the Manage Price list Item page .. I select" + field  + "as" + value + "\n");
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        switch(field){
            case "TaxType":
                setCurrentPage(managePriceListPage.setTaxSpecs(value));
                break;
            case "TaxTerritory":
                setCurrentPage(managePriceListPage.setTaxTerritory(value));
                break;
        }
    }


    @And("^On the Manage Price list Update Item Directory page - I select '([^\"]*)' as '([^\"]*)'")
    public void setTaxCode(String field,String value) throws Throwable {
        LOGGER.debug("On the Manage Price list Update Item Directory page .. I select" + field  + "as" + value + "\n");
        ManagePriceListUpdateItemDirectoryPage managePriceListUpdateItemDirectoryPage = (ManagePriceListUpdateItemDirectoryPage) getCurrentPage();
        managePriceListUpdateItemDirectoryPage.selectTaxCode(field, value);
        }

    @Then("^On the Manage Price list Update Item Directory page - I enter '([^\"]*)' into '([^\"]*)' in row '([^\"]*)' to update$")
    public void enterValueIntoElement(String value, String elementName, String row) throws Throwable {
        LOGGER.debug("Manage Price list Update Item Directory page ... Enter value " + value + " into element " + elementName + "\n");
        ManagePriceListUpdateItemDirectoryPage managePriceListUpdateItemDirectoryPage = (ManagePriceListUpdateItemDirectoryPage) getCurrentPage();

//        if(value.contains("SetUpRequest")){
//            value = createItemPage.generateSetUpRequest();
//            LOGGER.debug("Entering Setup request..");
//        }
        int rowNum = Integer.parseInt(row)-1;
        managePriceListUpdateItemDirectoryPage.enterValueIntoField(value,elementName,rowNum);
//        managePriceListDeliveryItemPage.enterValueIntoElement(value, elementName);
    }

}
