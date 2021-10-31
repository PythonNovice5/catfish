package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.MyProfilePage;
import com.basware.bttf.pages.dashboard.DashboardPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class myProfileSteps extends AbstractSteps{

    @Then("^I click on '([^\"']*)' expandable menu option$")
    public void expandOrganisation(String button)
    {
        MyProfilePage myProfilePage = (MyProfilePage) getCurrentPage();
        myProfilePage.clickOnExpandableButton(button);
    }

    @And("^I click on switch-to to buying organisation '([^\"']*)'$")
    public void switchToBuyer(String switchToOrg)
    {
        MyProfilePage myProfilePage = (MyProfilePage) getCurrentPage();
        setCurrentPage(myProfilePage.switchToBuyingOrg(switchToOrg));
    }

    @Then("^I click on switch-back to proc organisation '([^\"']*)'")
    public void switchBackToProc(String switchBackOrg)
    {
        MyProfilePage myProfilePage = (MyProfilePage) getCurrentPage();
        setCurrentPage(myProfilePage.switchBackToProc(switchBackOrg));
    }

    @Then("^I verify I have switched to buying organisation$")
    public void verificationAfterSwitchTo()
    {
        DashboardPage dashboardPage = (DashboardPage) getCurrentPage();
        dashboardPage.verifySwitchToOrg();
    }

    @Then("^On the Marketplace Search Results page - I check that the number of results are more than 0$")
    public void checkSwitchToResults()
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
//        marketplaceSearchResultsPage.getSearchCount();
    }
}
