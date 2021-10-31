package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.HomePagePunchOut;
import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.LoginPage;
import com.basware.bttf.pages.dashboard.DashboardPage;
import com.basware.bttf.pages.external.punchout.LoginPagePunchOutTool;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoggedInPageSteps extends AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger( LoggedInPageSteps.class.getName() );

    @Given("^I make a note: '([^\"']*)'$")       // (JS) Makes a note of something in the log - useful for debugging!
    public void logSomeText( String someText ) throws Throwable
    {
        LOGGER.debug( ">>>>>>>>>> NOTE: " + someText + "\n");
    }

    @And("^I refresh page and wait '([^\"']*)' seconds before continuing$")
    public void refreshAndWait(String secs) throws Throwable{
        LOGGER.debug("Reloading current page ..");
        driver.navigate().refresh();
        getCurrentPage().waitForANumberOfSeconds(Integer.valueOf(secs));
    }
    @Then("^I wait '([^\"']*)' seconds before continuing$")     // (JS) Use this when a step takes some time to process
    public void waitAWhile( String secs) throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Waiting " + secs + " seconds \n");
        getCurrentPage().waitForANumberOfSeconds( Integer.valueOf(secs) );
    }


    @Then("^I verify that toast message '([^\"']*)' is displayed$")     // (JS) Use this when a step takes some time to process
    public void verifyToastMessage( String msg) throws Throwable
    {
        LOGGER.debug( "Verifying the toast message: "+msg);
        LoggedInPage loginPage = (LoggedInPage) getCurrentPage();
        String actual = loginPage.getTextOfToastMessage();
        assertEquals("Did not get expected toast message",msg,actual);
    }

    @Then("^I scroll down '([^\"']*)' pixels$")     // (JS) negative value scrolls up the page
    public void scrollUpOrDown( String numberOfPixels) throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Scroll " + numberOfPixels + " pixels" + "\n"  );
        getCurrentPage().scrollUpOrDown( numberOfPixels );
    }

    @Then("^I log out$")
    public void logOut() throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Log out" + "\n");
        LoginPage loginPage = getCurrentPage().logOut();
        Assert.assertEquals( "Page title not correct on logout" , loginPage.getExpectedTitle() , driver.getTitle() );
    }

    @When("^I click on the Basware icon and I remain on the same page$")
    public void clickOnTheBaswareIcon() throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Click on the Basware Icon" + "\n" );
        setCurrentPage( getCurrentPage().navigateBaswareIcon() );
    }

    @Then("^I navigate to the internal '([^\"']*)' page$")
    public void navigateToInternalPageInline( String pageName )
    {
        LOGGER.debug( "(A logged in page) ... Navigate to internal " + pageName + " page" + "\n"  );
        setCurrentPage( getCurrentPage().navigateToInternalPageInline( pageName ) );
    }

    @Then("^I navigate to the internal '([^\"']*)' page which opens in a new window$")
    public void navigateToInternalPageNewWindow( String pageName ) throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Navigate to internal " + pageName + " page (New Window)" + "\n"  );
        setCurrentPage( getCurrentPage().navigateToInternalPageNewWindow( pageName ) );
    }

    @Then("^I navigate to the external '([^\"']*)' page from a logged in page$")
    public void navigateToExternalPageFromLoggedInPageInline( String pageName ) throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Navigate to external " + pageName + " page" + "\n"  );
        setCurrentPage( ( (DashboardPage) getCurrentPage() ).navigateToExternalPageInline( pageName ) );
    }

    @Then("^I wait for the page refresh to complete")
    public void waitForPageRefreshToComplete() throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Wait for the page re-display to complete" + "\n" );
        getCurrentPage().waitUntilPageDocumentIsCompleted();
        getCurrentPage().waitUntilAnyAJAXIsCompleted();
    }



    @Then("^I wait for the modal popup to be '(displayed|closed)'")
    public void waitForModalPopup( String expectedState ) throws Throwable
    {
        LOGGER.debug( "(A logged in page) ... Wait for the modal popup to be " + expectedState + "\n" );
        if(expectedState.equals("displayed")) // if expecting the popup to be displayed
            assertTrue("unexpectedly, modal popup has not displayed", getCurrentPage().waitUntilModalPopupDisplayed());
        else                                // if expecting the element to be closed
            assertTrue("unexpectedly, modal popup has not closed", getCurrentPage().waitUntilNoModalPopup());
    }


    public LoggedInPage getCurrentPage()
    {
        return ( LoggedInPage ) super.getCurrentPage();
    }
}
