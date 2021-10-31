package com.basware.bttf.steps.bdd.glue.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.supplier.price_lists.CreatePriceListPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.ManagePriceListPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CreatePriceListSteps extends AbstractSteps
{

    @Then("^I click on the Create Price List '([^\"']*)' breadcrumb$")
    public void clickCreatePriceListPageBreadcrumb( String breadcrumbItem ) throws Exception
    {
        LOGGER.debug( "Create Price List Page ... Click " + breadcrumbItem + " breadcrumb" + "\n" );
        CreatePriceListPage createPriceListPage = (CreatePriceListPage) getCurrentPage();
        setCurrentPage( createPriceListPage.createPriceListBreadcrumbClick() );
    }


    @Then ("^I enter '([^\"]*)' into Create Price List '([^\"']*)'$")
    public void enterValueIntoCreatePriceListField( String value, String fieldName ) throws Throwable
    {
        LOGGER.debug( "Create Price List Page ... Enter value " + value + " into field " + fieldName + "\n" );
        CreatePriceListPage createPriceListPage = (CreatePriceListPage) getCurrentPage();
        createPriceListPage.enterValueIntoField( value, fieldName );
    }

    @Then("^I select the '([^\"']*)' option from the Create Price List '([^\"']*)' dropdown$")
    public void selectOptionFromCreatePriceListDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug("Create Price List Page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        CreatePriceListPage createPriceListPage = (CreatePriceListPage) getCurrentPage();
        createPriceListPage.selectDropDownOption( dropdownName, dropdownOption );
    }

    @Then("^On the Create Price List Page - I select '([^\"']*)' as '([^\"']*)'$")
    public void selectElement( String field, String value ) throws Exception
    {
        LOGGER.debug("On Create Price List Page ... Select " + field + " as " + value +  "\n" );
        CreatePriceListPage createPriceListPage = (CreatePriceListPage) getCurrentPage();
        createPriceListPage.selectClassificationType( field, value );
    }


    @And("^I click on the Create Price List '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Throwable {
        LOGGER.debug("Create Price List Page ... Click " + buttonName + " link" + "\n" );
        CreatePriceListPage createPriceListPage = (CreatePriceListPage) getCurrentPage();
        switch( buttonName )
        {
            // case "FirstItemName": setCurrentPage( createPriceListPage.clickFirstItemName() ); break;
            default: setCurrentPage(createPriceListPage.clickButton( buttonName ));
        }
    }

    @And("^I click on the '([^\"']*)' Modal Alert '([^\"']*)' button$")
    public void clickModalAlertButton( String alertName, String buttonName ) throws Throwable {
        LOGGER.debug("Create Price List Page ... click " + alertName + " modal alert " + buttonName + " button" + "\n" );
        CreatePriceListPage createPriceListPage = (CreatePriceListPage) getCurrentPage();
        switch(alertName)
        {
            case "Cancel": {
                switch (buttonName) {
                    case "OK":
                        createPriceListPage.clickCancelAlertOKButton(); break;
                    case "Cancel":
                        createPriceListPage.clickCancelAlertCancelButton(); break;
                }
                break;
            }
            default: throw new Exception("alertName not recognised");
        }
    }

    @Then("on the Manage Price List page - I verify '([^\"']*)' is displayed")
    public void verifyAlertdisplayed(String alert) throws Exception {
        ManagePriceListPage managePriceListPage = (ManagePriceListPage)getCurrentPage();
        setCurrentPage(managePriceListPage.verifyAlert(alert));
    }


}

