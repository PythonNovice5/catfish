package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.external.punchout.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class ExternalPageSteps extends AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger( ExternalPageSteps.class.getName() );

    @Then("^I navigate back to the last page from the ([^\"]*) page window and close it$")
    public void navigateBackToLastCommerceNetworkPageAndCloseExternalWindow( String pageType ) throws Throwable
    {
        LOGGER.debug( "navigateBackToLastCommerceNetworkPageAndCloseExternalWindow(): Closing external window and returning to " + getPreviousPage().getExpectedTitle() +"\n" );

        if( pageType.equals( "external" ) )
        {
            getCurrentExternalPage().returnAndClose();
            setCurrentPage( getPreviousPage() );
        }
        else
        {
            getCurrentPage().returnAndClose();
            setCurrentPage( getPreviousPage() );
        }
    }



    @When("^I close the current window")
    public void closeCurrentWindow() throws Throwable
    {
        LOGGER.debug( "Closing current window " + "\n" );
        driver.close();
    }

    @When("^I navigate back to previous tab")
    public void navigateBack() throws Throwable
    {
        LOGGER.debug( "navigate back to previous tab" + "\n" );
        getCurrentPage().switchToNewWindow(getPreviousPage());

    }

    @Then("^I click on the back button and return to the previous ([^\"]*) page$")
    public void clickBackButtonToInternalPage( String pageName ) throws Throwable
    {
        LOGGER.debug( "clickBackButtonToInternalPage(): Clicking back button and returning to " + pageName + "\n" );
        returnToPreviousPage();
    }

    public ExternalPage getCurrentExternalPage()
    {
        return ( ExternalPage ) super.getCurrentPage();
    }

    @Given("I log into '([^\"']*)' as '([^\"']*)'")
    public void loginToExternalSite(String externalSite,String userAlias) throws Exception {
        PunchOutUtil punchOutUtilObject = new PunchOutUtil();
        ExternalLoginPage page = punchOutUtilObject.returnExternalPage(externalSite);
        setCurrentPage(page);
        setCurrentUser( env.getUser( userAlias ) );
        page.loginToExternalSite( externalSite,getCurrentUser() ) ;
    }

    @When("^On Punchout Home page - I click on '([^\"']*)' link for '([^\"']*)'$")
    public void     clickOnLinkForPunchOutTool(String link, String value) {
        LoginPagePunchOutTool loginPagePunchOutTool = new LoginPagePunchOutTool();
        setCurrentPage(loginPagePunchOutTool.clickLink(link,value));
    }

    @And("^On Punchout Form page - I select framework as '([^\"']*)'$")
    public  void selectFramework(String frameworkValue){
        LOGGER.debug("On Punchout Form page selecting Framework value as : "+frameworkValue);
        PunchOutFormPage punchOutFormPage = (PunchOutFormPage)getCurrentPage();
        punchOutFormPage.selectFrameworkValue(frameworkValue);
    }


    @And("^On Punchout Form page - I enter value '([^\"']*)' into '([^\"']*)'$")
    public  void enterValue(String value,String element) throws Exception{
        LOGGER.debug("On Punchout Form page - I enter value as : "+value+ " into "+element);
        PunchOutFormPage punchOutFormPage = (PunchOutFormPage)getCurrentPage();
        punchOutFormPage.enterInto(value, element);
    }

    @And("^On Punchout Form page - I click on '([^\"']*)' button$")
    public void clickBtn(String btnValue) {
        LOGGER.debug("On Punchout Form page click on :" + btnValue);
        PunchOutFormPage punchOutFormPage = (PunchOutFormPage) getCurrentPage();
        setCurrentPage(punchOutFormPage.clickButton(btnValue));
    }

    @And("^On Punchout Form page - I store the View details$")
    public void storeViewDetails() throws Exception{
        LOGGER.debug("On Punchout Form page  :" +"Storing View Details");
        PunchOutFormPage punchOutFormPage = (PunchOutFormPage) getCurrentPage();
        setCurrentPage(punchOutFormPage.store_view_details());
    }

    @When("^On Punchout Home page - I click on '([^\"']*)' link$")
    public void clickON(String link) {
        LOGGER.debug("On Punchout Home page  : Click on " +link);
        LoginPagePunchOutTool loginPagePunchOutTool = new LoginPagePunchOutTool();
        setCurrentPage(loginPagePunchOutTool.clickLink(link));
    }

    @Then ("On Complete Basket page - I enter value '([^\"]*)' into '([^\"]*)'$")
    public void enterValueIntoThisElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "On Complete Basket page  ... Enter value " + value + " into element " + elementName + "\n" );
        ExternalBasketCompletePage externalBasketCompletePage = (ExternalBasketCompletePage) getCurrentPage();
        switch (value){
            case "OrgIDValue":
                value = props.get("OrgID");
                break;
            case "SharedSecretValue":
                value = props.get("SharedSecret");
                break;
            case "UserNameValue":
                value = props.get("BuyerUserID");
                break;

        }
        externalBasketCompletePage.enterValueIntoElement( value, elementName);
    }

    @And("^On Complete Basket page - I select '([^\"']*)' as '([^\"']*)'$")
    public  void selectEnv(String env,String value) throws Exception {
        LOGGER.debug("On Complete Basket page selecting environment value as : "+env);
        ExternalBasketCompletePage externalBasketCompletePage = (ExternalBasketCompletePage) getCurrentPage();
        externalBasketCompletePage.selectValue(env,value);
    }

    @And("^On Complete Basket page - I click on '([^\"']*)' button$")
    public void clickThisBtn(String btnValue) {
        LOGGER.debug("On Complete Basket page click on :" + btnValue);
        ExternalBasketCompletePage externalBasketCompletePage = (ExternalBasketCompletePage) getCurrentPage();
        setCurrentPage(externalBasketCompletePage.clickButton(btnValue));
    }

    @And("^On Punchout Form page - I override the OCI fields$")
    public void overRideOCISubOrgFields() throws Exception
    {
        PunchOutFormPage punchOutFormPage = (PunchOutFormPage) getCurrentPage();
        punchOutFormPage.overRideSubOrgData();
    }

}
