package com.basware.bttf.steps.bdd.glue.shopping.punchin_out;

import com.basware.bttf.pages.external.punchout.PunchOutTestToolCheckOutPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;

public class PunchoutSteps extends AbstractSteps {

    @And("^On Punchout Test Tool Checkout Page - I verify Item details$")
    public void verifyItemDetailsOnCheckOut() throws Exception{
        PunchOutTestToolCheckOutPage punchOutTestToolCheckOutPage = (PunchOutTestToolCheckOutPage) getCurrentPage();
        LOGGER.debug("On Punchout Test Tool Checkout Page verifying Item details ");
        setCurrentPage(punchOutTestToolCheckOutPage.verifyItemDetails());
    }

    @And("^On Punchout Test Tool Checkout Page - I verify Express Checkout details$")
    public void verifyExpressCheckOutItemDetails() throws Exception{
        PunchOutTestToolCheckOutPage punchOutTestToolCheckOutPage = (PunchOutTestToolCheckOutPage) getCurrentPage();
        LOGGER.debug("On Punchout Test Tool Checkout Page verifying Expres Checkout Item details ");
        setCurrentPage(punchOutTestToolCheckOutPage.verifyExpressCheckoutDetails());
    }

    @And("^On Punchout Test Tool Checkout Page - I verify Item details for '([^\"']*)'$")
    public void verifyDifferentItemDetailsOnCheckOut(String format) throws Exception{
        PunchOutTestToolCheckOutPage punchOutTestToolCheckOutPage = (PunchOutTestToolCheckOutPage) getCurrentPage();
        LOGGER.debug("On Punchout Test Tool Checkout Page verifying Item details ");
        switch(format)
        {
            case "CXML":
                setCurrentPage(punchOutTestToolCheckOutPage.verifyShoppingBasketOnCXMLPunchin());
                break;
            case "OCI":
                setCurrentPage(punchOutTestToolCheckOutPage.verifyShoppingBasketOnOCIPunchin());
                break;
        }
    }
}
