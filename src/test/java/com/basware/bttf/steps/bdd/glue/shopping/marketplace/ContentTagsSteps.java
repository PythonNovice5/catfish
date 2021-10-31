package com.basware.bttf.steps.bdd.glue.shopping.marketplace;

        import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
        import com.basware.bttf.pages.shopping.marketplace.MarketplaceSearchResultsPage;
        import com.basware.bttf.steps.bdd.glue.AbstractSteps;
        import cucumber.api.java.en.And;

public class ContentTagsSteps extends AbstractSteps {

    @And("^On the Marketplace Search Results page - I verify content tag section appears$")

    public void verifyContentTagsSection()
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        marketplaceSearchResultsPage.contentTagSection();
    }

    @And("^On the Marketplace Search Results page - I check that content tag is displayed$")
    public void verifyContentTagInMarketPlace()
    {
       MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
       marketplaceSearchResultsPage.contentTagInMarketPlace();
    }

    @And("^On the Marketplace Search Results page - I click on newly created ([^\"]*)$")
    public void clickOnContentTag(String contentTagName)
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage)getCurrentPage();
        marketplaceSearchResultsPage.clickOnContentTag(contentTagName);
    }

    @And("^On the Marketplace Search Results page - I verify results are displaying correct$")
    public void verifyResults()
    {
        MarketplaceSearchResultsPage marketplaceSearchResultsPage = (MarketplaceSearchResultsPage) getCurrentPage();
        marketplaceSearchResultsPage.verifyContentTagResults();
    }
}
