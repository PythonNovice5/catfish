package com.basware.bttf.steps.bdd.glue.product_manager.loader;

import com.basware.bttf.pages.product_manager.Loader.BOMActionsPage;
import com.basware.bttf.pages.product_manager.Loader.ContentLoaderAutomationPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.When;

public class BOMActionsSteps extends AbstractSteps {

    @When("On BOM Actions Page - I click on '([^\"']*)' radio button")
    public void clickOnRadioButton(String buttonName)
    {
        LOGGER.debug("On BOM Actions Page - I click on: "+buttonName+" radio button");
        BOMActionsPage bomActionsPage = (BOMActionsPage) getCurrentPage();
        bomActionsPage.clickRadioButton(buttonName);
    }

    @When("On BOM Actions Page - I click on '([^\"']*)' button")
    public void clickOnButton(String buttonName)
    {
        LOGGER.debug("On BOM Actions Page - I click on: "+buttonName);
        BOMActionsPage bomActionsPage = (BOMActionsPage) getCurrentPage();
        setCurrentPage(bomActionsPage.clickTheButton(buttonName));
    }


    @When("On BOM Actions Page - I verify that item '([^\"']*)' is matched")
    public void verifyMatch(String itemName)
    {
        LOGGER.debug("On BOM Actions Page - I verify the match for Item named : "+itemName);
        BOMActionsPage bomActionsPage = (BOMActionsPage) getCurrentPage();
        bomActionsPage.verifyItemMatch(itemName);
    }

}
