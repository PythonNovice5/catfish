package com.basware.bttf.steps.bdd.glue.shopping.ftr;

import com.basware.bttf.pages.AbstractPage;
import com.basware.bttf.pages.shopping.catalogue_shopping.AddPaymentDetailsPage;
import com.basware.bttf.pages.shopping.catalogue_shopping.InvoiceDetailsPage;
import com.basware.bttf.pages.shopping.freetextrequisitions.*;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import javax.sound.sampled.Line;

public class FTRSteps extends AbstractSteps {
    private final String FTR_REFERENCE = "Catfish reference";

    @And("^On Free text requisitions management page -I click on 'Raise a Free Text Requisition' from the Actions menu$")
    public void clickOnFreeTextRequisitionMenu()
    {
        FreeTextRequisitionsManagementPage freeTextRequisitionsManagementPage = (FreeTextRequisitionsManagementPage) getCurrentPage();
        setCurrentPage(freeTextRequisitionsManagementPage.clickOnRaiseFreeTextRequisition());
    }

    @And("^On FTR edit page - I enter '([^\"']*)' as '([^\"']*)'$")
    public void enterFtrDetials(String fieldName,String value)
    {
        FTREditPage ftrEditPage = (FTREditPage) getCurrentPage();
        LOGGER.debug( "Enter FTR details as  " + fieldName + " with value of " + value + "\n" );
        switch (fieldName.toLowerCase())
        {
            case "your reference":
                String actualFtrReference = value + AbstractPage.genUUID();
                ftrEditPage.enterReference(actualFtrReference);
                props.set(FTR_REFERENCE,actualFtrReference);
                 break;
            case "target delivery date":
                ftrEditPage.enterDeliverDate(value);
                break;
            case "special instructions":
                ftrEditPage.specialInstructions(value);
                break;
        }

    }

    @And("^On FTR edit page - I click on '([^\"']*)' to add '([^\"']*)'")

    public void clickButtonInFtrEditPage(String fieldName,String value )
    {
          FTREditPage ftrEditPage = (FTREditPage) getCurrentPage();
        LOGGER.debug( "On FTR edit page click on  " + fieldName + "to add "+ value +"\n" );
        switch (fieldName.toLowerCase())
        {
            case "add line item":
                setCurrentPage(ftrEditPage.addLineItem());
                break;
            case "select a supplier":
                setCurrentPage(ftrEditPage.selectSupplier());
                break;
        }
    }

    @And("^On Line item page - I enter '([^\"']*)' as '([^\"']*)'$")

    public void enterLineItemDetails(String fieldName, String value)
    {
        LineItemPage lineItemPage = (LineItemPage) getCurrentPage();
        LOGGER.debug("On line item page enter in " + fieldName + "enter value as "+ value + "\n");
        lineItemPage.enterLineDetails(fieldName,value);

    }

    @And("^On Line item page - I select '([^\"']*)' as '([^\"']*)'$")

    public void selectCategories(String element,String value) throws Exception {
        LineItemPage lineItemPage = (LineItemPage) getCurrentPage();
        lineItemPage.clickOnCategory(element,value);

    }

    @And("^On Line item page - I click on '([^\"']*)' to add '([^\"']*)'$")
    public void clickButtonInLineItemPage(String fieldName,String action)
    {
        LineItemPage lineItemPage = (LineItemPage) getCurrentPage();
        LOGGER.debug("On line item page clicking on"+ fieldName + "to" + action );
        switch (fieldName.toLowerCase())
        {
            case "add":
                setCurrentPage(lineItemPage.clickOnAdd());
                break;
            case "add line item":
                lineItemPage.clickOnAddLineItems();
            case "cancel":
                lineItemPage.cancelLineItem();
                break;

        }
    }

    @And("^On Available supplier page - I select supplier '([^\"']*)' to the the FTR$")
    public void selectFromAvailableSupplier(String supplier)
    {
        String supplierSubString = "rw";
        FTRSuppliersPage ftrSuppliersPage = (FTRSuppliersPage)getCurrentPage();
        setCurrentPage(ftrSuppliersPage.selectSupplierForFTR(supplierSubString));
    }

    @And("^On FTR edit page - I click on Submit button$")
    public void submitFTR()
    {
        FTREditPage ftrEditPage = (FTREditPage) getCurrentPage();
        setCurrentPage(ftrEditPage.submitFTR());
    }

    @Then("^On Invoice details page - I select check box for supplier$")
    public void selectSupplierToChangeThePayment()
    {
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage) getCurrentPage();
        invoiceDetailsPage.selectSupplier();
    }

    @And("^On Invoice details page - I select payment method to '([^\"']*)'$")
    public void selectPaymentMethod(String paymentType) throws Exception {
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage) getCurrentPage();
        invoiceDetailsPage.selectPaymentType(paymentType);
    }

    @Then("^On Invoice details page - I click on change button$")
    public void changePaymentMethod()
    {
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage) getCurrentPage();
      setCurrentPage(invoiceDetailsPage.clickOnChangeButton());
    }

    @Then("^On add payment details page - I end card number and save$")
    public void enterCardInformation()
    {
        AddPaymentDetailsPage addPaymentDetailsPage = (AddPaymentDetailsPage) getCurrentPage();
        setCurrentPage(addPaymentDetailsPage.enterCardDetails("123456"));
    }

    @And("^On Invoice details page - I click on '([^\"']*)' button to submit '([^\"']*)'$")
        public void clickOnSend(String action, String page) throws Exception {
        InvoiceDetailsPage invoiceDetailsPage = (InvoiceDetailsPage) getCurrentPage();
        setCurrentPage(invoiceDetailsPage.clickSendButton(page));
    }

    @And("^On Free text requisitions management page - I verify the FTR")
    public void verifyNewlyCreatedFTR(){
        FreeTextRequisitionsIndexPage freeTextRequisitionsIndexPage = (FreeTextRequisitionsIndexPage)getCurrentPage();
        freeTextRequisitionsIndexPage.verifyNewlyCreatedFtr(props.get(FTR_REFERENCE));
    }
}

