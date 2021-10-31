package com.basware.bttf.steps.bdd.glue.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.supplier.price_lists.CreateMatrixPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.EditMatrixPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListMatrixItemsDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MatrixItemSteps extends AbstractSteps {

    @When("^On Matrix directory page - I click on '([^\"']*)' button$")
    public void clickOnCreateMatrix(String button)
    {
        LOGGER.debug( "Matrix directory page ... Click on create button" + "\n" );
        PriceListMatrixItemsDirectoryPage priceListMatrixItemsDirectoryPage = (PriceListMatrixItemsDirectoryPage)getCurrentPage();
        switch(button)
        {
            case "create":
                setCurrentPage(priceListMatrixItemsDirectoryPage.clickOnCreate());
                break;
            case "search":
                priceListMatrixItemsDirectoryPage.clickOnSearch();
                break;
            case "First Item Manage":
                setCurrentPage(priceListMatrixItemsDirectoryPage.clickManageItem());
                break;
        }
    }

    @Then("^On Create Matrix page - I enter '([^\"']*)' as '([^\"']*)'$")
    public void enterMatrixDetails(String field, String value)
    {
        LOGGER.debug("In Matrix create page... I enter" + value +" in" + field);
        CreateMatrixPage createMatrixPage = (CreateMatrixPage) getCurrentPage();
        createMatrixPage.enterMatrixItemValue(field,value);
    }

    @When("^On Create Matrix page - I click on '([^\"']*)' button$")
    public void clickOnButtonInMatrixPage(String button)
    {
        LOGGER.debug("In matrix create page...I click on " + button);
        CreateMatrixPage createMatrixPage = (CreateMatrixPage) getCurrentPage();
        createMatrixPage.clickOnButton(button);
    }

    @When("^On Edit Matrix page - I click on '([^\"']*)' button$")
    public void clickButtonInEditMatrixPage(String button)
    {
        LOGGER.debug("In Edit matrix page...I click on " + button);
        EditMatrixPage editMatrixPage = (EditMatrixPage) getCurrentPage();

        switch (button){
            case "Save":
                setCurrentPage(editMatrixPage.clickSave());
                break;
            default:
                editMatrixPage.clickOnButton(button);
        }

    }



    @When("^On Create Matrix page - I click on save button$")
    public void saveMatrix()
    {
       CreateMatrixPage createMatrixPage = (CreateMatrixPage)getCurrentPage();
       setCurrentPage(createMatrixPage.saveMatrixItem());
    }

    @When("^I '([^\"']*)' in the model alert pop up$")
    public void clickOnAlertButton(String button)
    {
        CreateMatrixPage createMatrixPage = (CreateMatrixPage) getCurrentPage();
        createMatrixPage.alertConfirmation(button);
    }

    @And("^On Matrix directory page - I delete recently created matrix$")
    public void deleteMatrix(){
        PriceListMatrixItemsDirectoryPage priceListMatrixItemsDirectoryPage = (PriceListMatrixItemsDirectoryPage) getCurrentPage();
        priceListMatrixItemsDirectoryPage.deleteMatrixItem();
    }

}
