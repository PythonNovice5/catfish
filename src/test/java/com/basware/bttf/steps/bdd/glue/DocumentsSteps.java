package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.documents.DocumentTracker;
import com.basware.bttf.pages.documents.DocumentsPage;
import com.basware.bttf.pages.documents.MyNotificationsPage;
import com.basware.bttf.pages.documents.MyTransactionsPage;
import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Do;
import org.junit.Assert;

import javax.swing.text.Document;

import static org.junit.Assert.assertEquals;

public class DocumentsSteps extends AbstractSteps
{
    @Then("^I validate that I can see the correct Documents tabs$")
    public void validateDocumentsTabs() throws Throwable
    {
        MyNotificationsPage myNotificationsPage = getCurrentMyNotificationsPage();
        myNotificationsPage.validateDocumentTabItems( getCurrentUser() );
    }

    @Then("^I validate that I can see the correct My Notifications filters$")
    public void validateDocumentsFilters() throws Throwable
    {
        MyNotificationsPage myNotificationsPage = getCurrentMyNotificationsPage();
        myNotificationsPage.validateDocumentFilterItems( getCurrentUser() );
    }

    @Then("^I click on the Search button$")
    public void clickSearchButton() throws Throwable
    {
        MyNotificationsPage myNotificationsPage = (MyNotificationsPage)getCurrentPage();
        setCurrentPage( myNotificationsPage.clickSearchButton() );
    }


    @Then("^On the Document Tracker Page - I click on '([^\"']*)' button$")
    public void clickButton(String btn) throws Throwable
    {
        LOGGER.debug("Document Tracker Page - I click on " +btn + " button");
        DocumentTracker documentTracker = (DocumentTracker) getCurrentPage();
        switch (btn){
            case "Search":
                setCurrentPage( documentTracker.clickSearchButton() );
                break;
            case "Download as PDF":
                setCurrentPage( documentTracker.clickDownloadAsPDF() );
                break;
            case "BackToPreviousPage":
                driver.navigate().back();
                break;
        }

    }

    @When("^On the Document Tracker Page - I click on '([^\"']*)' link under '([^\"']*)'$")
    public void clickLink(String link, String cat) throws Throwable
    {
        LOGGER.debug("Document Tracker Page - I click on " +link + " link");
        DocumentTracker documentTracker = (DocumentTracker) getCurrentPage();
        switch (link){
            case "Purchase Order XXXXXXXXXXXX":
                documentTracker.POL.click();
                break;
        }

    }

    @Then("^I click on the '([^\"']*)' tab$")
    public void clickDocumentsTab( String docsTab ) throws Throwable
    {
        DocumentsPage documentsPage = ( DocumentsPage ) getCurrentPage();
        setCurrentPage( documentsPage.clickDocumentTabs( docsTab ) );
    }

    @Then("^I check that the link of the first notification found works$")
    public void navigateToMyTransactionsViaNotificationLink() throws Throwable
    {
        MyNotificationsPage myNotificationsPage = getCurrentMyNotificationsPage();
        setCurrentPage( myNotificationsPage.findAndClickOnFirstNotificationLinks() );
    }

    @Then("^I navigate to the My Transactions page via the '([^\"']*)' filter$")
    public void navigateToMyTransactionsViaDocumentsFilters( String filterName ) throws Throwable
    {
        MyNotificationsPage myNotificationsPage = getCurrentMyNotificationsPage();
        setCurrentPage( myNotificationsPage.navigateToMyTransactionsViaFilter( filterName ) );

        String queryStringSnippet = getCurrentMyTransactionsPage().getQueryStringSnippet();

        Assert.assertTrue( String.format( "Query string snippet '%s' is incorrect for filter: '%s'" , queryStringSnippet , filterName ) ,
                           driver.getCurrentUrl().contains(  queryStringSnippet ) );

    }

    @Then("^I click on the '([^\"']*)' filter$")
    public void clickMyTransactionsFilters( String docsFilter ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.clickOnMyTransactionsFilter( docsFilter ) );

        String queryStringSnippet = getCurrentMyTransactionsPage().getQueryStringSnippet();

        Assert.assertTrue( String.format( "Query string snippet '%s' is incorrect for docsFilter: '%s'" , queryStringSnippet , docsFilter ) ,
                           driver.getCurrentUrl().contains(  queryStringSnippet ) );
    }

    @Then("^I click on Sort By: '([^\"']*)'$")
    public void sortBy( String sortType ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.clickSortBy( sortType ) );

        String queryStringSnippet = getCurrentMyTransactionsPage().getQueryStringSnippet();

        Assert.assertTrue( String.format( "Query string snippet '%s' is incorrect for sortType: '%s'" , queryStringSnippet , sortType ) ,
                           driver.getCurrentUrl().contains(  queryStringSnippet ) );
    }

    @Then("^I click on Select: '([^\"']*)'$")
    public void select( String selectType ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.clickSelect( selectType ) );

        String queryStringSnippet = getCurrentMyTransactionsPage().getQueryStringSnippet();

        Assert.assertTrue( String.format( "Query string snippet '%s' is incorrect for selectType: '%s'" , queryStringSnippet , selectType ) ,
                           driver.getCurrentUrl().contains(  queryStringSnippet ) );
    }

    @Then("^I click on Mark as: '([^\"']*)'$")
    public void markAs( String markType ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.clickMarkAs( markType ) );
    }

    @Then("^I set the page size to '([^\"']*)'$")
    public void pageSize( String pageSize ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.pageSize( pageSize ) );

        String queryStringSnippet = getCurrentMyTransactionsPage().getQueryStringSnippet();

        Assert.assertTrue( String.format( "Query string snippet '%s' is incorrect for pageSize: '%s'" , queryStringSnippet , pageSize ) ,
                           driver.getCurrentUrl().contains(  queryStringSnippet ) );
    }

    @Then("^I check I can look at a document family in My Transactions$")
    public void checkDocument() throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();

        setCurrentPage( myTransactionsPage.clickThatWereAllOfTheAboveFilter().clickDocumentTypeAny().clickOnFirstDocument() );

        Assert.assertTrue( "Could not view document family in My Transactions" , driver.getCurrentUrl().contains( getCurrentMyTransactionsPage().getQueryStringSnippet() ) );
    }

    @Then("^I '([^\"']*)' the first document in the family in My Transactions$")
    public void expandandCollapseFirstDocument( String operation ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.expandCollapseDocumentView() );
    }

    @Then("^I download the first document as '([^\"']*)'")
    public void downloadDocumentAs( String documentType ) throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.downloadDocumentAs( documentType ) );
    }

    @And("^On the Document Tracker Page - I click to sort by '([^\"']*)'")
    public void sortByElement( String sortBy) throws Throwable
    {
        DocumentTracker documentTracker = (DocumentTracker)getCurrentPage();
        setCurrentPage( documentTracker.clickSortBy(sortBy));
    }

    @And("^On the Document Tracker Page - I click the first Document reference")
    public void clickFirstRef() throws Throwable
    {
        DocumentTracker documentTracker = (DocumentTracker)getCurrentPage();
        setCurrentPage( documentTracker.clickFirstReference());
    }

    @Then("On the Document Tracker Page - I check that '([^\"']*)' value is '([^\"']*)'")
    public void checkValue(String element, String value) throws  Exception{
        DocumentTracker documentTracker = (DocumentTracker)getCurrentPage();
        String actualValue=null;
        switch (element){
            case "Document Ref":
                element = "DocRef";
                actualValue = documentTracker.getElementValue(element );
                break;
            case "Supplier Name":
                element = "SupName";
                actualValue = documentTracker.getElementValue(element );
                break;
            case "DateFrom":
                value= documentTracker.getDate();
                actualValue = documentTracker.getAttributeValueOfWebElement(documentTracker.DateFrom,"value");
                LOGGER.debug(documentTracker.getDate());
                break;
            case "DateTo":
                value= documentTracker.CurrentDate;
                actualValue = documentTracker.getAttributeValueOfWebElement(documentTracker.DateTo,"value");
                break;
            case "Event":
                actualValue = documentTracker.returnSelected(element);
                break;
            case "Type":
                actualValue = documentTracker.returnSelected(element);
                break;
            default:
                actualValue = documentTracker.getElementValue(element);
                break;
        }


        if (actualValue.contentEquals("")){
            actualValue="Blank";
        }
        LOGGER.debug( "Document Tracker Page ... Comparing " + value + ": Expected:[" + value + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", value, actualValue );
    }

    @Then("On the Document Tracker Page - I check that '([^\"']*)' is displayed")
    public void checkIfDisplayed(String value) {
        LOGGER.debug( "Document Tracker Page ... Checking if " + value + " is displayed" + "\n");
        DocumentTracker documentTracker = (DocumentTracker)getCurrentPage();
        switch (value){
            case "Purchase Order number":
                documentTracker.elementIsDisplayed("PON");
                break;
            case "Download as PDF":
                documentTracker.elementIsDisplayed("DAPDF");
                break;
            case "Purchase Order List":
                documentTracker.elementIsDisplayed("POL");
                break;
            case "Invoice list":
                documentTracker.elementIsDisplayed("Invoice");
                break;
            case "Purchase Order XXXXXXXXXXXX":
                documentTracker.elementIsDisplayed("DocHistoryPO");
                break;
            case "Invoice XXXXXXXXXX":
                documentTracker.elementIsDisplayed("DocHistoryInvoice");
                break;
            case "Any Document Received":
                documentTracker.elementIsDisplayed("AnyDocReceived");
                break;
        }
    }

    @Then("^I click on Back to your results$")
    public void backToYourResults() throws Throwable
    {
        MyTransactionsPage myTransactionsPage = getCurrentMyTransactionsPage();
        setCurrentPage( myTransactionsPage.clickOnBackToYourResults() );
    }

    @Then("On the Document Tracker Page - I select '([^\"']*)' value as '([^\"']*)'")
    public void selectValue(String element, String value) throws  Exception{
        LOGGER.debug( "Document Tracker Page ... selecting " + value + " from " + element+"\n");
        DocumentTracker documentTracker =  (DocumentTracker)getCurrentPage();
        documentTracker.selectDropdownOptionByText(documentTracker.DocType,value);
    }

    public MyNotificationsPage getCurrentMyNotificationsPage()
    {
        return ( MyNotificationsPage ) super.getCurrentPage();
    }

    @Then ("^On the Document Tracker Page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Document Tracker Page ... Enter value " + value + " into element " + elementName + "\n" );
        DocumentTracker documentTracker = (DocumentTracker) getCurrentPage();
        documentTracker.enterValueIntoElement( value, elementName);
    }


    public MyTransactionsPage getCurrentMyTransactionsPage()
    {
        return ( MyTransactionsPage ) super.getCurrentPage();
    }
}