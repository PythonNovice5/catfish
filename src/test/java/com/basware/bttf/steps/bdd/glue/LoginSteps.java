package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.LoginPage;
import cucumber.api.java.en.Given;

public class LoginSteps extends AbstractSteps
{
    @Given("^I log into Commerce Network as '([^\"']*)'$")
    public void logIntoCommerceNetwork( String userAlias ) throws Throwable
    {
        LOGGER.debug( "Log In Page ... Log in as " + userAlias  + "\n" );

        // set up login page
        LoginPage loginPage = new LoginPage();
        setCurrentPage( loginPage );

        // Now get the user details and do the log in
        setCurrentUser( env.getUser( userAlias ) );
        setCurrentPage( loginPage.login( getCurrentUser() ) );
    }
}
