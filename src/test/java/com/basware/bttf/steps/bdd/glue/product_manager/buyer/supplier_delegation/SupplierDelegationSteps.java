package com.basware.bttf.steps.bdd.glue.product_manager.buyer.supplier_delegation;

import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.PublishAgreementsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;

import cucumber.api.java.en.And;

public class SupplierDelegationSteps extends AbstractSteps {

   @And("^On Supplier Agreement directory page - I click on exit supplier link$")
    public void clickOnExitSupplierLink()
   {
       PublishAgreementsPage publishAgreementsPage = (PublishAgreementsPage) getCurrentPage();
       publishAgreementsPage.exitFromSupplier();
   }
}
