package com.basware.bttf.steps.bdd.glue.shopping.rfq_old;
import com.basware.bttf.pages.shopping.requestforquotation.*;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.experimental.theories.internal.Assignments;

import static org.junit.Assert.assertTrue;

public class ReqForQuotationSteps extends AbstractSteps {

    String supplierResults;
    String supplierResultsAfterFilter;

    @And("^On RFQ Management Page - I click on '([^\"']*)' tab$")
    public void clickOnRFQTab(String value) throws Exception {
        RFQManagementPage rfqManagementPage = (RFQManagementPage) getCurrentPage();
        LOGGER.debug("RFQ Management Page... " + "click on " + value+"\n");
        switch (value) {
            case "Request a Quote":
                setCurrentPage(rfqManagementPage.clickRFQElement(value));
                break;
        }
    }

    @When("^On Request Quote Page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterIntoField(String value, String field) throws Exception {
        RequestQuotePage requestQuotePage = (RequestQuotePage)getCurrentPage();
        LOGGER.debug("Request Quote Page... " + " Entering " + value+ " into "+field+"\n");
        switch (field){
            case "Your reference":
                field = "YourReferenceQuote";
                break;
            case "Target Delivery Date":
                field = "QuoteTargetDeliveryDate";
                break;
            case "Expiration Date":
                field = "QuoteExpirationDate";
                break;
            case "Expiration Time":
                field = "QuoteExpirationTime";
                break;
            case "Special Instructions":
                field = "QuoteSpeicalInstructions";
                break;
        }
        requestQuotePage.enterValueIntoElement(value,field);
    }

    @When("^On Request Quote Page - I click on '([^\"']*)' button$")
    public void clickButton(String button) {
        LOGGER.debug("Request Quote Page... " + " I click on " + button+"\n");
        RequestQuotePage requestQuotePage = (RequestQuotePage)getCurrentPage();
        setCurrentPage(requestQuotePage.clickButton(button));
    }

    @Then("^On the RFQ Suppliers page - I see current suppliers$")
    public void currentSuppliersCount()
    {
        RFQSuppliersPage rfqSuppliersPage = (RFQSuppliersPage) getCurrentPage();
        supplierResults =  rfqSuppliersPage.currentSupplierCount();
    }

    @When("^On the RFQ Suppliers page - I select '([^\"']*)' filter as '([^\"']*)'$")
    public void selectFilters(String Filter, String value)
    {
        LOGGER.debug("Select filters... " + Filter+"\n");
        RFQSuppliersPage rfqSuppliersPage = (RFQSuppliersPage) getCurrentPage();
        rfqSuppliersPage.selectSupplierFilters(value);
    }

    @Then("^On the RFQ Suppliers page - I verify results on applying filter$")
    public void verifySupplierResults()
    {
        RFQSuppliersPage rfqSuppliersPage = (RFQSuppliersPage)  getCurrentPage();
        supplierResultsAfterFilter = rfqSuppliersPage.currentSupplierCount();
        assertTrue(Integer.parseInt(supplierResults) > Integer.parseInt(supplierResultsAfterFilter));
    }

    @Then("^On the RFQ Suppliers page - I verify results on applying category filter$")
    public void verifySupplierResultsOnCategoryFilter()
    {
        RFQSuppliersPage rfqSuppliersPage = (RFQSuppliersPage)  getCurrentPage();
        String supplierResultsAfterCategoryFilter = rfqSuppliersPage.currentSupplierCount();
        assertTrue(Integer.parseInt(supplierResultsAfterFilter) >= Integer.parseInt(supplierResultsAfterCategoryFilter));
    }




    @When("On Line Items Page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterInto(String value, String field) throws Exception{
        LineItemsPage lineItemsPage = (LineItemsPage)getCurrentPage();
        LOGGER.debug("Line Items Page... " + " Entering " + value+ " into "+field+"\n");
        switch (field){
            case "ItemName":
                field = "LineItemsItemName";
                break;
            case "ItemQuantity":
                field = "LineItemsItemQuantity";
                break;
            case "TargetUnitPrice":
                field = "LineItemsTargetUnitPrice";
                break;
            case "Item description":
                field = "LineItemsItemDesc";
                break;
        }
        lineItemsPage.enterValueIntoElement(value,field);
    }

    @When("On Line Items Page - I select '([^\"']*)' from '([^\"']*)'")
    public void selectFrom(String value, String field) throws Exception {
        LineItemsPage lineItemsPage = (LineItemsPage)getCurrentPage();
        LOGGER.debug("Line Items Page... " + " Selecting " + value+ " from "+field+"\n");
        switch (field){
            case "Categories Level 1":
                field = "CatLevel1";
                break;
            case "Categories Level 2":
                field = "CatLevel2";
                break;
            case "Categories Level 3":
                field = "CatLevel3";
                break;
            case "Categories Level 4":
                field = "CatLevel4";
                break;
        }
        lineItemsPage.selectCatLevel(value,field);


    }

    @When("On Line Items Page - I click on '([^\"']*)' button")
    public void clickLineItemsButton(String btn) {
        LOGGER.debug("Line Items Page... " + " I click on " + btn+"\n");
        LineItemsPage lineItemsPage = (LineItemsPage)getCurrentPage();
        setCurrentPage(lineItemsPage.clickBtn(btn));
    }

    @When("On the RFQ Suppliers page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterIntoElem(String value, String field) throws Exception{
        LOGGER.debug( "RFQ Suppliers page ... Enter value " + value + " into element " + field + "\n" );
        RFQSuppliersPage rfqSuppliersPage = (RFQSuppliersPage) getCurrentPage();
        rfqSuppliersPage.enterValueIntoElement( value, field);
    }

    @When("On the RFQ Suppliers page - I click on the '([^\"']*)' button")
    public void clickRFQSupButton(String btn) throws Exception {
        LOGGER.debug("RFQ Suppliers Page... " + " I click on " + btn+"\n");
        RFQSuppliersPage rfqSuppliersPage = (RFQSuppliersPage)getCurrentPage();
        setCurrentPage(rfqSuppliersPage.clickButton(btn));
    }

    @When("On Manage Request For Quote page - I click on '([^\"']*)'")
    public void clickOn(String value) {
        LOGGER.debug("Manage Request For Quote page... " + " I click on " + value+"\n");
        ManageRequestForQuotePage manageRequestForQuotePage = (ManageRequestForQuotePage)getCurrentPage();
        setCurrentPage(manageRequestForQuotePage.clickBtn(value));
    }

    @Then("On Manage Request For Quote page - I verify that '([^\"']*)' contains '([^\"']*)'")
    public void verifyMsg(String elem,String msg) throws  Exception {
        LOGGER.debug("Manage Request For Quote page... " + " I verify " + elem+"\n");
        ManageRequestForQuotePage manageRequestForQuotePage = (ManageRequestForQuotePage)getCurrentPage();
        String actual = manageRequestForQuotePage.getElementValue(elem);
        LOGGER.debug( "Manage Request For Quote page... Comparing " + elem + ": Expected:[" + msg + "] Actual:[" + actual + "]" + "\n");
        assertTrue(actual.contains(msg));
    }


    @When("On My Requests For Quote page - I sort the records by '([^\"']*)'")
    public void sortBy(String value) {
        LOGGER.debug("My Requests For Quote page... " + " I sort the records by " + value+"\n");
        MyRequestsForQuotePage myRequestsForQuotePage = (MyRequestsForQuotePage) getCurrentPage();
        myRequestsForQuotePage.clickWebElement(myRequestsForQuotePage.DateIssuedTab);
    }

    @Then("On My Requests For Quote page - I verify that '([^\"']*)' is '([^\"']*)'")
    public void verifyRecord(String elem,String value) throws  Exception {
        LOGGER.debug("My Requests For Quote page... " + " I verify " + elem+"\n");
        MyRequestsForQuotePage myRequestsForQuotePage = (MyRequestsForQuotePage) getCurrentPage();
        String actual = myRequestsForQuotePage.getElementValue(elem);
        LOGGER.debug( "My Requests For Quote page... Comparing " + elem + ": Expected:[" + value + "] Actual:[" + actual + "]" + "\n");
        assertTrue(actual.contains(value));
    }

}



