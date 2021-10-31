package com.basware.bttf.steps.bdd.glue.product_manager.supplier.agreements;

import com.basware.bttf.pages.product_manager.supplier.price_lists.AttachPricelistToAgreementPage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.SupplierManageAgreementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SupplierAgreementSteps extends AbstractSteps {
    @Then("^On Supplier Manage agreement page - I click on '([^\"]*)' to '([^\"]*)'$")
    public void clickOnAddPriceList(String button , String action)
    {
        LOGGER.debug("On Supplier agreement page" + action);
        SupplierManageAgreementPage supplierManageAgreementPage = (SupplierManageAgreementPage)getCurrentPage();
        setCurrentPage(supplierManageAgreementPage.clickButtonInSupplierAgreementPage(button));
    }

    @And("^On Attach pricelist page - I search recently created pricelist$")
    public void searchForPriceList()
    {
        AttachPricelistToAgreementPage attachPricelistToAgreementPage = (AttachPricelistToAgreementPage) getCurrentPage();
        attachPricelistToAgreementPage.searchPriceList();
    }

    @And("^On Attach pricelist page - I click on plus button to add pricelist$")
    public void addPricelist()
    {
        AttachPricelistToAgreementPage attachPricelistToAgreementPage = (AttachPricelistToAgreementPage) getCurrentPage();
        setCurrentPage(attachPricelistToAgreementPage.addPricelistToAgreement());

    }
}
