package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.InternalPage;
import com.basware.bttf.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

public class InternalPageSteps extends AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger( InternalPageSteps.class.getName() );

    @Given("^I navigate to the Commerce Network login page$")
    public void successfullyNavigateToLoginPage() throws Throwable
    {
        LOGGER.debug( "(An Internal page) ... Navigate to Commerce Network login page" + "\n" );
        setCurrentPage( new LoginPage() );
    }

    @Then("^I navigate to the non-logged in internal '([^\"']*)' page$")
    public void navigateToNonLoggedInInternalPageInline( String pageName ) throws Throwable
    {
        LOGGER.debug( "(An Internal page) ... Navigate to non-logged in internal" + pageName + "\n" );
        setCurrentPage( getCurrentInternalPage().navigateToInternalPageInline( pageName ) );
    }

    @Then("^I navigate to the external '([^\"']*)' page from a non-logged in page$")
    public void navigateToExternalPageFromNonLoggedInPageInline( String pageName ) throws Throwable
    {
        LOGGER.debug( "(An Internal page) ... Navigate to external" + pageName + "\n" );
        setCurrentPage( getCurrentInternalPage().navigateToExternalPageInline( pageName ) );
    }

    public InternalPage getCurrentInternalPage()
    {
        return ( InternalPage ) super.getCurrentPage();
    }
}
