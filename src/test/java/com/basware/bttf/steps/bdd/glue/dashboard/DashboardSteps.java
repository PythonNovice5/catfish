package com.basware.bttf.steps.bdd.glue.dashboard;
// Created by Julian Sheppard on 22/06/2017

import com.basware.bttf.pages.dashboard.DashboardPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

public class DashboardSteps extends AbstractSteps
{
    @Then("^On the Dashboard page - I validate the main menu items are correct for the user$")
    public void validateMainMenuItemsForTheUser() throws Throwable
    {
        LOGGER.debug( "Dashboard Page ... Validate menu items are correct for the user" );
        DashboardPage dashboardPage = (DashboardPage)getCurrentPage();
        dashboardPage.validateUserMainMenuItems(getCurrentUser());
    }

    @Then("^On the Dashboard page - I validate the Settings dropdown options are correct for the user$")
    public void validateSettingsDropdownOptionsForTheUser() throws Throwable
    {
        LOGGER.debug( "Dashboard Page ... Validate Settings dropdown options are correct for the user" );
        DashboardPage dashboardPage = (DashboardPage)getCurrentPage();
        dashboardPage.validateSettingsDropdownItems(getCurrentUser());
    }

    @Then("^On the Dashboard page - I validate the footer items are correct for the user$")
    public void validateFooterItemsForTheUser() throws Throwable
    {
        LOGGER.debug( "Dashboard Page ... Validate footer items are correct for the user" );
        DashboardPage dashboardPage = (DashboardPage)getCurrentPage();
        dashboardPage.validateFooterItems(getCurrentUser());
    }


    @Then("^On the Dashboard page - I navigate to the external Knowledge Base page which opens in a new window$")
    public void navigateToExternalPageNewWindow() throws Throwable
    {
        LOGGER.debug( "navigateToExternalPageNewWindow(): Navigate to the Knowledge Base page" + "\n" );
        DashboardPage dashboardPage = (DashboardPage)getCurrentPage();
        setCurrentPage(dashboardPage.navigateToKnowledgeBasePage() );
    }

}
