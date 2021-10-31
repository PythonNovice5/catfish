package com.basware.bttf.steps.bdd.glue.settings;

import com.basware.bttf.pages.settings.RootManagementPage;
import com.basware.bttf.pages.settings.RootUserManagementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.When;

public class RootManagementSteps extends AbstractSteps {

    @When("^On Root Management page - I click on Supplier users button$")
    public void clickOnSupplierUsersCog()
    {
        RootManagementPage rootManagementPage = (RootManagementPage) getCurrentPage();
        setCurrentPage(rootManagementPage.clickOnSupplierUserCog());
    }

    @When("^On Root User management page - I verify '([^\"']*)' is not in the search results$")
    public void verifyBuyerIsNotInTheSearch(String user)
    {
        RootUserManagementPage rootUserManagementPage = (RootUserManagementPage) getCurrentPage();
        rootUserManagementPage.searchKeyword(user);
        rootUserManagementPage.verifyBuyerNotInTheSearchList();
    }
}
