package com.basware.bttf.steps.bdd.glue.product_manager.supplier.agreements;


//import com.basware.bttf.pages.product_manager.buyer.agreements.PublishAgreementsPage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.SupplierManageAgreementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import com.basware.bttf.pages.product_manager.buyer.groups.ManageGroupResourcePage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.PublishAgreementsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

/**
 * Created by NasirAhmed on 20/02/2017.
 */
public class SupplierAgreementDirectoryPageSteps extends AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger(SupplierAgreementDirectoryPageSteps.class);

    @Then("^I click on the Supplier Agreement '([^\"]*)' filter$")
    public void clickMyTransactionsFilters( String agreementsFilter ) throws Throwable
    {
        PublishAgreementsPage publishAgreementsPage = (PublishAgreementsPage) getCurrentPage();
        publishAgreementsPage.clickFilter(agreementsFilter);
    }


    @Then("^I click on the Supplier Agreement '([^\"]*)' to view Agreement$")
    public void iClickOnTheSupplierAgreementManageIconToViewAgreement(String icon) throws Throwable
    {
        PublishAgreementsPage publishAgreementsPage = (PublishAgreementsPage) getCurrentPage();
        setCurrentPage(publishAgreementsPage.clickIconManageAgreement());
    }

    @Then("^I click on the Supplier Agreement '([^\"]*)' link$")
    public void iClickOnTheSupplierAgreementBackToAgreementDirectoryLink(String link) throws Throwable
    {
        SupplierManageAgreementPage supplierManageAgreementPage = (SupplierManageAgreementPage) getCurrentPage();
        setCurrentPage(supplierManageAgreementPage.clickLinkBackToAgreementDirectory());
    }

    @Then ("^On Publish Agreements Page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoPriceListDirectoryField( String value, String fieldName )  throws Throwable
    {
        LOGGER.debug( "Publish Agreements Page ... Enter value " + value + " into field " + fieldName + "\n" );
        PublishAgreementsPage publishAgreementsPage = (PublishAgreementsPage) getCurrentPage();
        publishAgreementsPage.enterValueIntoField( value, fieldName);
    }


    @Then("^On Publish Agreements Page - I click on '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Publish Agreements Page ... Click " + buttonName + " button" + "\n" );
        PublishAgreementsPage publishAgreementsPage = (PublishAgreementsPage) getCurrentPage();
        setCurrentPage(publishAgreementsPage.clickAgmntDirButtons(buttonName));
    }

    @When("^On Supplier Agreement directory page - I search recently created agreement$")
    public void searchAgreement()
    {
       PublishAgreementsPage publishAgreementsPage = (PublishAgreementsPage)getCurrentPage();
       publishAgreementsPage.searchAgreement( props.get(TestConstants.ORG_AGREEMENT_NAME ));
    }


}
