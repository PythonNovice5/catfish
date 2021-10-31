package com.basware.bttf.steps.bdd.glue.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.buyer.agreements.AgreementDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by NasirAhmed on 20/01/2017.
 */
public class AgreementDirectoryPageSteps extends AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger(AgreementDirectoryPageSteps.class);

    @Then("^I click on the Agreement '([^\"']*)' filter$")
    public void clickMyTransactionsFilters( String agreementsFilter ) throws Throwable
    {
        AgreementDirectoryPage agreementDirectoryPage = (AgreementDirectoryPage) getCurrentPage();
        agreementDirectoryPage.clickFilter(agreementsFilter);

    }

    @Then("^I verify '([^\"]*)' text in the page")
    public void verifyTextInPage(String text)
    {
        LOGGER.debug(text + "\n" );
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='pagable-content']//*[contains(text(),'" + text + "')]"));

        List<WebElement> icons = driver.findElements(By.xpath(".//*[@id='pagable-content']//*[contains(text(),'glyphicon-exclamation-sign')]"));

        if (list.size() == 0)
        {
            LOGGER.error(String.format("Text - [%s]not found!",text) + "\n");
        }

        if(icons.size() == 0)
        {
            LOGGER.error(String.format("glyphicon-exclamation-sign icon not found"));
        }
    }

    @And("^On Buyer Agreement directory page - I search recently created agreement$")
    public void searchAgreementInBuyerAgreementDirectory() throws Exception {
        AgreementDirectoryPage agreementDirectoryPage = (AgreementDirectoryPage)getCurrentPage();
        agreementDirectoryPage.searchRecentAgreement();
    }

    @And("^On Buyer Agreement directory page - I search agreement as '([^\"]*)'$")
    public void searchSpecifiedAgreement(String agreement)
    {
        AgreementDirectoryPage agreementDirectoryPage = (AgreementDirectoryPage)getCurrentPage();
        agreementDirectoryPage.searchAgreement(agreement);

    }

    @And("^On Buyer Agreement directory page - I click on cog to manage agreement$")
    public void clickManageAgreementCog()
    {
        AgreementDirectoryPage agreementDirectoryPage = (AgreementDirectoryPage) getCurrentPage();
        setCurrentPage(agreementDirectoryPage.clickManageCog());
    }








}
