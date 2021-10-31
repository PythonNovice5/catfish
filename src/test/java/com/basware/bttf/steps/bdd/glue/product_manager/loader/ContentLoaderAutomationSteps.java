package com.basware.bttf.steps.bdd.glue.product_manager.loader;

import com.basware.bttf.pages.product_manager.Loader.ContentLoaderAutomationPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class ContentLoaderAutomationSteps extends AbstractSteps {

    @When("On Automation Page - I click on '([^\"']*)' button")
    public void clickOnCreateAutomation(String button)
    {
        ContentLoaderAutomationPage contentLoaderAutomationPage = (ContentLoaderAutomationPage)getCurrentPage();
        contentLoaderAutomationPage.clickOnCreateButton();
    }

    @And("On Automation page - I enter all details")
    public void enterAllAutomationDetails(DataTable table) throws Exception
    {
        List<List<String>> rows = table.asLists(String.class);
        ContentLoaderAutomationPage contentLoaderAutomationPage = (ContentLoaderAutomationPage)getCurrentPage();

        for (List<String> columns : rows) {
            contentLoaderAutomationPage.enterAutomationDetails(columns.get(0), columns.get(1));
        }
    }

    @Then("On Automation page - I click in create to create record")
    public void createAutomation()
    {
        ContentLoaderAutomationPage contentLoaderAutomationPage = (ContentLoaderAutomationPage)getCurrentPage();
        contentLoaderAutomationPage.createAutomation();

    }

    @Then("I verify new automation create successfully")
    public void verifyNewAutomation()
    {
        ContentLoaderAutomationPage contentLoaderAutomationPage = (ContentLoaderAutomationPage)getCurrentPage();
        contentLoaderAutomationPage.verifyAutomationCreated();

    }

    @And("On Automation Page - I delete newly created automation")
    public void deleteAutomation()
    {
        ContentLoaderAutomationPage contentLoaderAutomationPage = (ContentLoaderAutomationPage)getCurrentPage();
        contentLoaderAutomationPage.deleteNewAutomationRecord();
    }
}
