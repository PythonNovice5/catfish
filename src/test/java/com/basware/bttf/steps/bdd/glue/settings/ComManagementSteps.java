package com.basware.bttf.steps.bdd.glue.settings;


import com.basware.bttf.pages.settings.CommunityManagementPage;
import com.basware.bttf.pages.settings.CommunityUserManagementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class ComManagementSteps extends AbstractSteps {
    protected static Logger LOGGER = Logger.getLogger( OrgManagementSteps.class.getName() );


    @Then("On Community Management page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown")
    public void selectValue(String value, String element) throws  Exception{
        LOGGER.debug( "Community Management page ... selecting " + value + " from " + element+"\n");
        CommunityManagementPage communityManagementPage =  (CommunityManagementPage) getCurrentPage();
        communityManagementPage.selectOption(value,element);
    }

    @And("On Community Management page - I click on '([^\"']*)'")
    public void clickOn(String value) throws  Exception{
        LOGGER.debug( "Community Management page ... clicking " + value+"\n");
        CommunityManagementPage communityManagementPage =  (CommunityManagementPage) getCurrentPage();
        setCurrentPage(communityManagementPage.clickOnValue(value));
    }

    @When("^On Community User page - I verify '([^\"']*)' is not in the search results$")
    public void verifySupplierIsNotInTheSearch(String user)
    {
        CommunityUserManagementPage communityUserManagementPage = (CommunityUserManagementPage) getCurrentPage();
        communityUserManagementPage.searchKeyword(user);
        communityUserManagementPage.verifyUserIsNotPresent();
    }
}
