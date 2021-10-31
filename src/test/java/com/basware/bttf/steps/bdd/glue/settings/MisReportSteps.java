package com.basware.bttf.steps.bdd.glue.settings;

import com.basware.bttf.pages.settings.MisDashBoardPage;
import com.basware.bttf.pages.settings.MisManagementPage;
import com.basware.bttf.pages.settings.MisReportPage;
import com.basware.bttf.pages.settings.MisUserManagementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class MisReportSteps extends AbstractSteps {

    protected static Logger LOGGER = Logger.getLogger( OrgManagementSteps.class.getName() );

    @And("^On MIS report page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectSortBy(String dropdownOption, String dropdownName)
    {
        MisReportPage misReportPage = (MisReportPage) getCurrentPage();
        switch( dropdownName )
        {
            case "Sort By": misReportPage.sortBy( dropdownOption ); break;
            case "Results Per Page": misReportPage.selectResultsPerPage( dropdownOption ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @And("^On MIS report page - I select filter '([^\"']*)'$")

    public void clickOnFilter(String filter)
    {
        MisReportPage misReportPage = (MisReportPage) getCurrentPage();
        misReportPage.clickFilter(filter);
    }

    @Then("^On MIS dashboard page - I click on view all tile$")
    public void clickOnReportTile()
    {
       MisDashBoardPage misDashBoardPage = (MisDashBoardPage) getCurrentPage();
       setCurrentPage(misDashBoardPage.clickOnReportTile());
    }

    @And("^On MIS report page - I verify '([^\"']*)' reports showing$")
    public void verifyResults(String expectedReportResults)
    {
        MisReportPage misReportPage = (MisReportPage) getCurrentPage();
        String currentReportResults = misReportPage.getTotalResultsInThePage();
        Assert.assertEquals(currentReportResults, expectedReportResults);
    }

    @Then("^On MIS report page - I click on run report button$")
    public void clickOnRunButton()
    {
        MisReportPage misReportPage = (MisReportPage) getCurrentPage();
        misReportPage.clickOnRunReportButton();
    }

    @And("^On MIS report page - I select transaction type '([^\"']*)' on pop up$")
    public void selectTransactionValues(String checkBoxValue)
    {
        MisReportPage misReportPage = (MisReportPage) getCurrentPage();
        misReportPage.selectTransactionCheckBoxes(checkBoxValue);
    }

    @Then("^On MIS report page - I click on create button$")
    public void clickOnCreateButton()
    {
        MisReportPage misReportPage = (MisReportPage) getCurrentPage();
        misReportPage.clickOnCreateReportButton();
    }


    @Then("^On MIS Management page - I click '([^\"']*)' button$")
    public void clickButtonOnMisPage(String button)
    {
        switch (button) {
            case "add":
            MisManagementPage misManagementPage = (MisManagementPage) getCurrentPage();
            setCurrentPage(misManagementPage.clickOnAddButton());
        }
    }

    @When("^On MIS User management page - I verify supplier '([^\"']*)' is not in the search results$")
    public void verifySupplierIsNotInTheSearch(String user)
    {
        MisUserManagementPage misUserManagementPage = (MisUserManagementPage) getCurrentPage();
        misUserManagementPage.searchKeyword(user);
        misUserManagementPage.verifyAddButtonIsNotDisplaying();
    }
}
