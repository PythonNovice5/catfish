package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.LoggedInPage;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

public class AdminUserSteps extends AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger( AdminUserSteps.class.getName() );

    @Then("^I click on the Settings link$")
    public void clickOnTheSettingsLink() throws Throwable
    {
        LOGGER.debug( "clickOnTheSettingsLink() - Click on settings tab" +"\n" );

        LoggedInPage loggedInPage = getCurrentLoggedInPage();
        loggedInPage.clickSettings();
    }

    @Then("^I navigate to the internal '([^\"']*)' page via the Settings dropdown$")
    public void navigateToTheSettingsPageViaTheSettingsDropdown( String settingsPageName ) throws Throwable
    {
        LOGGER.debug( "navigateToTheSettingsPageViaTheSettingsDropdown(): Navigate to settings page: " + settingsPageName +"\n" );
        setCurrentPage( getCurrentLoggedInPage().navigateToInternalSettingsPageInline( settingsPageName ) );
    }

    @Then("^I navigate to the external '([^\"']*)' tab via the Settings dropdown$")
    public void navigateToTheExternalSettingsTabViaTheSettingsDropdown( String settingsPageName ) throws Throwable
    {
        LOGGER.debug( "navigateToTheExternalSettingsTabViaTheSettingsDropdown(): Navigate to external settings page:" + settingsPageName +"\n" );
        setCurrentPage( getCurrentLoggedInPage().navigateToExternalSettingsPageNewWindow( settingsPageName ) );
    }

    public LoggedInPage getCurrentLoggedInPage()
    {
        return ( LoggedInPage ) super.getCurrentPage();
    }
}
