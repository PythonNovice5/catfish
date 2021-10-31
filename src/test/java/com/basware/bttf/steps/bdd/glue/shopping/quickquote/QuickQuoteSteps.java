package com.basware.bttf.steps.bdd.glue.shopping.quickquote;

import com.basware.bttf.pages.AbstractPage;
import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.quotes.QuotesDirectoryPage;
import com.basware.bttf.pages.quotes.ViewQuotePage;
import com.basware.bttf.pages.shared.RfqUtils;
import com.basware.bttf.pages.shopping.SelectSupplierForQuickQuotePage;
import com.basware.bttf.pages.shopping.quickQuote.CreateRfqPage;
import com.basware.bttf.pages.shopping.quickQuote.QuickQuotePage;
import com.basware.bttf.pages.shopping.quickQuote.RfqDirectoryPage;
import com.basware.bttf.pages.shopping.quickQuote.ViewRfqPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sourceforge.htmlunit.corejs.javascript.EcmaError;

public class QuickQuoteSteps extends AbstractSteps
{
    private final String RFQ_TITLE_SEARCH_NAME = "rfq title";

    @And("^I click on '([^\"']*)' in the list items$")
    public void clickOnItemListInQuickQuoteDashBoard(String item)
    {
        QuickQuotePage quickQuotePage = (QuickQuotePage) getCurrentPage();
        LOGGER.debug("Quick quote page ... " + "click on " + item);
        switch (item.toLowerCase()) {
            case "create new":
                setCurrentPage(quickQuotePage.clickCreateNewRfqButton());
                break;
            case "draft":
                setCurrentPage(quickQuotePage.clickOnDraft());
                break;
            case "sent":
                setCurrentPage(quickQuotePage.clickOnSent());
                break;
            case "award rfqs":
                setCurrentPage(quickQuotePage.clickOnAwardRfqs());
                break;
            case "check out":
                setCurrentPage(quickQuotePage.clickOnCheckOut());
                break;
        }
    }

    @And("^On the RFQ page - I enter '([^\"']*)' as '([^\"]*)'$")
    public void enterDetailsOnRfqPage(String fieldName, String value) throws Exception
    {
        CreateRfqPage createRfqPage = (CreateRfqPage) getCurrentPage();
        LOGGER.debug("Create rfq page ... Enter rfq " + fieldName + " with value of " + value + "\n");
        switch (fieldName.toLowerCase())
        {
            case RFQ_TITLE_SEARCH_NAME:
                String actualRfqTitle = value + AbstractPage.genUUID();
                createRfqPage.enterTitle(actualRfqTitle);
                props.set(RFQ_TITLE_SEARCH_NAME, actualRfqTitle);
                LOGGER.debug("RFQ Title entered: "+actualRfqTitle);
                break;
            case "expiration date":
                createRfqPage.enterDate(value);
                break;
            case "currency":
                createRfqPage.selectCurrency(value);
                break;
            case "name":
                createRfqPage.enterProductName(value);
                break;
            case "description":
                createRfqPage.enterDescription(value);
                break;
            case "expiration time":
                createRfqPage.enterTime();
                break;
            case "quantity":
                createRfqPage.enterValueIntoElement(value,fieldName);break;
            case "order unit":
                createRfqPage.enterValueIntoElement(value,"orderUnit");break;
        }
    }

    @And("^On the RFQ page - I click on classification cog$")
    public void clickOnClassificationCog()
    {
        CreateRfqPage createRfqPage = (CreateRfqPage) getCurrentPage();
        createRfqPage.clickClassificationCog();
    }

    @And("^I select the classification category as '([^\"]*)' in '([^\"]*)'$")
    public void selectRFQClassifications(String category,String dropdown) throws Exception
    {
       RfqUtils rfqUtils = new RfqUtils();
       RfqUtils.selectClassification(driver, category, dropdown);
    }

    @And("^I click on done button$")
    public void confirmCategories()
    {
        CreateRfqPage createRfqPage = new CreateRfqPage();
        createRfqPage.clickDone();
    }

    @And("^On the RFQ page - I click on add button to add line$")
    public void clickOnAdd()
    {
        CreateRfqPage createRfqPage = (CreateRfqPage) getCurrentPage();
        createRfqPage.clickOnAddButton();
    }

    @And("^On the RFQ Page - I click on add button to add supplier$")

    public void clickOnAddSupplier()
    {
        CreateRfqPage createRfqPage = (CreateRfqPage) getCurrentPage();
        setCurrentPage(createRfqPage.clickOnAddSupplierButton());
    }

    @And("^On the Select Supplier page - I select first supplier in the list$")

    public void selectFirstSupplier()
    {
        SelectSupplierForQuickQuotePage selectSupplierForQuickQuotePage = (SelectSupplierForQuickQuotePage) getCurrentPage();
        selectSupplierForQuickQuotePage.addFirstSupplier();
    }

    @When("On the QuickQuote Suppliers page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterIntoElem(String value, String field) throws Exception{
        LOGGER.debug( "QuickQuote Suppliers page ... Enter value " + value + " into element " + field + "\n" );
        SelectSupplierForQuickQuotePage selectSupplierForQuickQuotePage = (SelectSupplierForQuickQuotePage) getCurrentPage();
        selectSupplierForQuickQuotePage.enterValueIntoElement( value, field);
        selectSupplierForQuickQuotePage.searchSupplier();
    }

    @And("^On the Select Supplier page - I click on the Save button$")

    public void clickSaveSupplierButton()
    {
        SelectSupplierForQuickQuotePage selectSupplierForQuickQuotePage = (SelectSupplierForQuickQuotePage) getCurrentPage();
        setCurrentPage(selectSupplierForQuickQuotePage.saveSupplier());
    }

    @And("^On the RFQ Page - I click on '([^\"']*)' button$")

    public void clickButtonOnRFQPage(String fieldName)
    {
        CreateRfqPage createRfqPage = (CreateRfqPage) getCurrentPage();
        switch (fieldName.toLowerCase()) {
            case "save":
                createRfqPage.clickOnSaveButton();
                break;
            case "send":
                createRfqPage.clickOnSendButton();
                createRfqPage.verifyRfqSuccessMessage();
                break;
            case"update":
                createRfqPage.updateLine();
                break;
            case "cancel":
                createRfqPage.clickOnCancelButton();
                break;
        }
    }

    @And("^I search for newly created rfq in the directory page$")

    public void searchRfq()
    {
        RfqUtils.searchRFQ( driver , props.get(RFQ_TITLE_SEARCH_NAME));
    }

    @And("^click on new rfq$")
    public void clickOnRfq() {
        RfqDirectoryPage rfqDirectoryPage = (RfqDirectoryPage) getCurrentPage();
        setCurrentPage(rfqDirectoryPage.clickOnRfq());
    }

    @And("^On the RFQ page - I check title is same")
    public void verifyTitle()
    {
        CreateRfqPage createRfqPage = (CreateRfqPage) getCurrentPage();
        createRfqPage.checkRfqTile("Mamatha");

    }

    @And("^On the supplier RFQ directory page - I search for the rfq$")
    public void searchRFQ()
    {
        LOGGER.debug("Searching for RFQ with title - "+ props.get(RFQ_TITLE_SEARCH_NAME));
        RfqUtils.searchRFQ( driver , props.get(RFQ_TITLE_SEARCH_NAME));
    }


    @Then("^I click on the Quotes '([^\"']*)' filter$")
    public void clickMyTransactionsFilters( String agreementsFilter ) throws Throwable
    {
        QuotesDirectoryPage quotesDirectoryPage = (QuotesDirectoryPage) getCurrentPage();
        quotesDirectoryPage.clickFilter(agreementsFilter);
    }

    @And("^On the supplier RFQ directory page - I click on cog$")
    public void onSupplierClickOnCog()
    {
        LOGGER.debug("On the Supplier RFQ directory page Click on " + " Cog button");
        QuotesDirectoryPage quotesDirectoryPage = (QuotesDirectoryPage) getCurrentPage();
        setCurrentPage(quotesDirectoryPage.clickCog());
    }

    @And("^On the supplier RFQ directory page - I click on cog for status Open$")
    public void onSupplierClickOnCogOpen()
    {
        QuotesDirectoryPage quotesDirectoryPage = (QuotesDirectoryPage) getCurrentPage();
        setCurrentPage(quotesDirectoryPage.clickCogOpen());
    }

    @And("^On view quote page - Supplier click on '([^\"]*)' button to '([^\"]*)'$")
    public void clickOnCog(String fieldName, String value)
    {
        ViewQuotePage viewQuotePage = (ViewQuotePage) getCurrentPage();
        switch (fieldName.toLowerCase()) {
            case "quote":
                viewQuotePage.clickQuote();
                break;
            case "watch":
                viewQuotePage.clickWatch();
                break;
            case "close":
                viewQuotePage.clickClose();
                break;
            case "send":
                viewQuotePage.clickSend();
                break;
            case "add":
                viewQuotePage.clickAdd();
                break;
        }
    }

    @And("^On the quote page - Supplier select '([^\"]*)' as '([^\"]*)'$")
    public void enterQuote(String fieldName, String value)
    {
        ViewQuotePage viewQuotePage = (ViewQuotePage) getCurrentPage();
        viewQuotePage.selectDeliverCost(value);
    }


    @And("^On the quote page - I click on '([^\"]*)' button$")
    public void clickOn(String elem) throws Exception
    {
        ViewQuotePage viewQuotePage = (ViewQuotePage) getCurrentPage();
        viewQuotePage.clickOnThis(elem);
    }

    @And("^On the quote page - Supplier enter '([^\"]*)' as '([^\"]*)'$")
    public void enterValueForQuote(String fieldName, String value) throws Exception {
        ViewQuotePage viewQuotePage = (ViewQuotePage) getCurrentPage();
        switch (fieldName.toLowerCase()) {
            case "quantity":
                viewQuotePage.enterQuoteQuantity(value);
                break;
            case "order unit":
                viewQuotePage.enterOrderUnit(value);
                break;
            case "unit price":
                viewQuotePage.enterUnitPrice(value);
                break;
        }
    }

    @And("^On view quote page - Validate successful message$")
    public void validateSuccessfulMessage() throws Exception
    {
        ViewQuotePage viewQuotePage = (ViewQuotePage) getCurrentPage();
        viewQuotePage.validateMessage();
    }

    @And("^On the buyer RFQ directory page - I search for the rfq$")
    public void seachRfqAsBuyer()
    {
        RfqUtils.searchRFQ( driver , props.get(RFQ_TITLE_SEARCH_NAME));
    }

    @And("^On the buyer RFQ directory page - I click on cog$")
    public void clickOnCog()
    {
        RfqDirectoryPage rfqDirectoryPage = (RfqDirectoryPage) getCurrentPage();
        setCurrentPage(rfqDirectoryPage.clickOnCog());
    }

    @And("^On the RFQ view page - I click on Award button$")
    public void awardRfq()
    {
        ViewRfqPage viewRfqPage = (ViewRfqPage) getCurrentPage();
        viewRfqPage.clickAward();
    }

    @And("^I click on award in the popup modal$")
    public void clickOnAwardInPopUp()
    {
        ViewRfqPage viewRfqPage = (ViewRfqPage) getCurrentPage();
        viewRfqPage.awardRfq();
    }

    @And("^On the buyer RFQ view page - I validate awarded message$")
    public void awardMessage() throws Exception
    {
        ViewRfqPage viewRfqPage = (ViewRfqPage) getCurrentPage();
        viewRfqPage.successfulMessage();
    }

    @And("^On the buyer RFQ view page - I add item to the basket$")
    public void addItemToTheBasket() {
        ViewRfqPage viewRfqPage = (ViewRfqPage) getCurrentPage();
        viewRfqPage.addRfqItem();
        viewRfqPage.confirmAddItem();
    }

    @And("^On the buyer RFQ view page - I close the success message$")
    public void closeMessage()
    {
        ViewRfqPage viewRfqPage = (ViewRfqPage) getCurrentPage();
        viewRfqPage.clickClose();
    }
}
