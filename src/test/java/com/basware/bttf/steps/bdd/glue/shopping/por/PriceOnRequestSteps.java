package com.basware.bttf.steps.bdd.glue.shopping.por;

import com.basware.bttf.pages.por.MyQuotesPage;
import com.basware.bttf.pages.por.ViewPriceOnRequestPage;
import com.basware.bttf.pages.por.ViewPriceOnRequestPageSupplier;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PriceOnRequestSteps extends AbstractSteps {

    @When("On the View Price On Request page - I click on '([^\"']*)'")
    public void clickBtn(String btn) throws Exception
    {
        LOGGER.debug("View Price On Request page - Click on " +btn );
        ViewPriceOnRequestPage viewPriceOnRequestPage  = (ViewPriceOnRequestPage)getCurrentPage();
        setCurrentPage(viewPriceOnRequestPage.clickButton(btn));
    }

    @Then("On the View Price On Request page - I verify the success message as '([^\"']*)'")
    public void verifySuccessMsg(String msg) throws Exception
    {
        LOGGER.debug("View Price On Request page - Verfiying Success Message " +msg );
        ViewPriceOnRequestPage viewPriceOnRequestPage  = (ViewPriceOnRequestPage)getCurrentPage();
        viewPriceOnRequestPage.verifyAlertMessage(msg);
    }

    @When("On the View Price On Request Supplier page - I click on '([^\"']*)'")
    public void clickBtnSupplier(String btn) throws Exception
    {
        LOGGER.debug("View Price On Request Supplier page - Click on " +btn );
        ViewPriceOnRequestPageSupplier viewPriceOnRequestPageSupplier  = (ViewPriceOnRequestPageSupplier)getCurrentPage();
        setCurrentPage(viewPriceOnRequestPageSupplier.clickButtonSup(btn));
    }

    @When("On the View Price On Request Supplier page - I enter '([^\"']*)' into '([^\"']*)'")
    public void on_the_View_Price_On_Request_Supplier_page_I_enter_into(String value, String field) throws Exception{
        LOGGER.debug("View Price On Request Supplier page - I enter "+ value + " into" + field);
        ViewPriceOnRequestPageSupplier viewPriceOnRequestPageSupplier = (ViewPriceOnRequestPageSupplier)getCurrentPage();
        viewPriceOnRequestPageSupplier.enterValueIntoElement(value,field);
    }

    @And("On the View Price On Request Supplier page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown")
    public void selectValueFrom(String value, String dropdown) throws Exception{
        LOGGER.debug("View Price On Request Supplier page - I select "+ value + " from" + dropdown);
        ViewPriceOnRequestPageSupplier viewPriceOnRequestPageSupplier = (ViewPriceOnRequestPageSupplier)getCurrentPage();
        viewPriceOnRequestPageSupplier.selectValueFrom(dropdown,value);
    }

    @Then("On the View Price On Request Supplier page - I verify the success message as '([^\"']*)'")
    public void verifySuccessMsgSupp(String msg) throws Exception
    {
        LOGGER.debug("View Price On Request Supplier page - Verfiying Success Message " +msg );
        ViewPriceOnRequestPageSupplier viewPriceOnRequestPageSupplier  = (ViewPriceOnRequestPageSupplier) getCurrentPage();
        viewPriceOnRequestPageSupplier.verifyMessage(msg);
    }

    @Then("On My Quotes Page - I click on '([^\"']*)'")
    public void clickMyQuotesBtns(String btnName) throws Exception
    {
        LOGGER.debug("My Quotes Page - I click on  " +btnName );
        MyQuotesPage myQuotesPage  = (MyQuotesPage) getCurrentPage();
        setCurrentPage(myQuotesPage.clickMyQuotesBtns(btnName));
    }
}
