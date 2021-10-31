package com.basware.bttf.steps.bdd.glue.product_manager.supplier.media;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.media.MediaDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MediaDirectoryPageSteps extends AbstractSteps {
    @When("^on Media Directory page - I click on '([^\"']*)' button$")
    public void clickOn(String button) throws Exception
    {
        LOGGER.debug( "(Media Directory page) ... clicking on " +button+ "\n" );
        MediaDirectoryPage mediaDirectoryPage = (MediaDirectoryPage) getCurrentPage();
        setCurrentPage(mediaDirectoryPage.clickMediaDirectoryButtons(button));
    }

    @Then("^On Media Directory page - I search '([^\"']*)' and verify image is uploaded in AWS media$")
    public void searchImage(String image)
    {
        MediaDirectoryPage mediaDirectoryPage = (MediaDirectoryPage) getCurrentPage();
        mediaDirectoryPage.searchImage(image);

    }

}
