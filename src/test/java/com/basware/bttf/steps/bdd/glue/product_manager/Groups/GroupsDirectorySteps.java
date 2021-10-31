package com.basware.bttf.steps.bdd.glue.product_manager.Groups;

import com.basware.bttf.pages.product_manager.buyer.groups.GroupDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.groups.ViewGroupAgreementsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GroupsDirectorySteps extends AbstractSteps {

    @And("^On Groups directory page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectSortBy(String dropdownOption, String dropdownName)
    {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        switch( dropdownName )
        {
            case "Sort By": groupDirectoryPage.sortBy( dropdownOption ); break;
            case "Results Per Page": groupDirectoryPage.selectResultsPerPage( dropdownOption ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @And("^On Groups directory page - I select filter '([^\"']*)'$")

    public void clickOnFilter(String filter)
    {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        groupDirectoryPage.clickFilter(filter);
    }

    @Then("^On Group directory page - I search shared group$")

    public void searchForGroup() throws Exception {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        groupDirectoryPage.searchSharedGroup(props.get(TestConstants.SHARED_GROUP_NAME));
    }

    @Then("^On Group directory page - I click on search button$")
    public void clickOnSearchButton()
    {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        groupDirectoryPage.clickOnSearch();
    }

    @And("^On Group directory page - I click accept button$")
     public void acceptTheSharedGroup()
    {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        groupDirectoryPage.acceptGroup();
    }

    @When("^On Group directory page - I click on eye to view shared agreements$")
    public void clickOnViewIcon()
    {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        setCurrentPage(groupDirectoryPage.clickOnViewGroupAgreements());
    }

    @Then("On View group agreements page - I verify shared agreements")
    public void verifySharedAgreements() throws Exception
    {
        ViewGroupAgreementsPage viewGroupAgreementsPage = (ViewGroupAgreementsPage) getCurrentPage();
        viewGroupAgreementsPage.verifyAgreementNumber();
    }



}
