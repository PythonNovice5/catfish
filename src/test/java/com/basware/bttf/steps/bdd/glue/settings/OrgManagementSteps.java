package com.basware.bttf.steps.bdd.glue.settings;
import com.basware.bttf.pages.contracts.ContractsSuppliersPage;
import com.basware.bttf.pages.settings.OrganisationManagementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.bs.I;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class OrgManagementSteps extends AbstractSteps {

    protected static Logger LOGGER = Logger.getLogger( OrgManagementSteps.class.getName() );

    @When("^On Organisation Management Page - I click on '([^\"]*)'$")
    public void clickLink (String value) throws Exception
    {
        OrganisationManagementPage organisationManagementPage = (OrganisationManagementPage) getCurrentPage();
        LOGGER.debug("On Organisation Management page .....click on " + value+ "\n");
        setCurrentPage(organisationManagementPage.clickOn(value));
    }


    @Then("^On Organisation Management Page - I verify the status as '([^\"]*)'$")
    public void verifyStat(String value)
    {
        OrganisationManagementPage organisationManagementPage = (OrganisationManagementPage) getCurrentPage();
        LOGGER.debug("On Organisation Management page .....I verify the LVP certification status as: " +value+ "\n");
        setCurrentPage(organisationManagementPage.verifyStatus(value));
    }

    @And("^On Organisation Management Page - I select '([^\"]*)' as type of course$")
    public void selectCourseType(String value) throws Exception
    {
        OrganisationManagementPage organisationManagementPage = (OrganisationManagementPage) getCurrentPage();
        LOGGER.debug("On Organisation Management page .....I select course type as: " +value+ "\n");
        setCurrentPage(organisationManagementPage.selectCourse(value));
    }


    @Then ("^On Organisation Management Page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoOrgManagmentPageField(String value, String fieldName ) throws Throwable
    {
        LOGGER.debug( "Manage Price List Page ... Enter value " + value + " into field " + fieldName + "\n" );
        OrganisationManagementPage organisationManagementPage = (OrganisationManagementPage) getCurrentPage();
        organisationManagementPage.enterValueIntoField( value, fieldName);
    }


    @Then ("On Organisation Management Page - I switch '([^\"]*)' the toggle for '([^\"]*)'$")
    public void clickToggle(String value, String fieldName ) throws Throwable
    {
        LOGGER.debug( "Organisation Management Page ... Switch " + value + " for " + fieldName + "\n" );
        OrganisationManagementPage organisationManagementPage = (OrganisationManagementPage) getCurrentPage();
        organisationManagementPage.toggleEnableDisable( value, fieldName);
    }
}


