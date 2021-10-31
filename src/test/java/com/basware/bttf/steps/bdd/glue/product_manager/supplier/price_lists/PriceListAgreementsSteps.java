package com.basware.bttf.steps.bdd.glue.product_manager.supplier.price_lists;


import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListAgreementsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PriceListAgreementsSteps extends AbstractSteps
{

    @Then("^I click on the Price List Agreements '([^\"']*)' breadcrumb$")
    public void clickPriceListAgreementsPageBreadcrumb( String breadcrumbItem ) throws Exception
    {
        LOGGER.debug( "Price List Agreements Page ... Click " + breadcrumbItem + " breadcrumb" + "\n" );
        PriceListAgreementsPage priceListAgreementsPage = (PriceListAgreementsPage) getCurrentPage();
        switch (breadcrumbItem)
        {
            case "Product Manager":
                setCurrentPage( priceListAgreementsPage.priceListAgreementsBreadcrumbProductManagerClick() );
                break;
            case "Price List Directory":
                setCurrentPage( priceListAgreementsPage.priceListAgreementsBreadcrumbPriceListDirectoryClick() );
                break;
            case "Price List":
                setCurrentPage( priceListAgreementsPage.priceListAgreementsBreadcrumbPriceListClick() );
                break;
        }
    }

    @Then("^I click on the Price List Agreements '([^\"']*)' page filter$")
    public void clickManagePriceListAgreementsFilter( String filterName ) throws Exception
    {
        LOGGER.debug( "Price List Agreements Page ... Click " + filterName + " filter$" + "\n" );
        PriceListAgreementsPage priceListAgreementsPage = (PriceListAgreementsPage) getCurrentPage();
        setCurrentPage( priceListAgreementsPage.clickFilter( filterName ) );
    }

    @Then("^I check that Price List Agreements has '([^\"]*)' Agreement displayed$")
    public void checkPriceListAgreementsDisplaysAnAgreement( String anOrNo ) throws Exception
    {
        LOGGER.debug( "Price List Agreements Page ... Check " + anOrNo + "Agreement displayed$" + "\n" );
        PriceListAgreementsPage priceListAgreementsPage = (PriceListAgreementsPage) getCurrentPage();
        if (anOrNo.equals("an"))
        {
            assertEquals(true, priceListAgreementsPage.IsAnAgreementDisplayed());
        }
        if (anOrNo.equals("no"))
        {
            assertEquals(false, priceListAgreementsPage.IsAnAgreementDisplayed());
        }
    }

}
