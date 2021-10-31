package com.basware.bttf.steps.bdd.glue.product_manager.loader;

import com.basware.bttf.pages.product_manager.Loader.*;
import com.basware.bttf.pages.product_manager.buyer.views.SelectAgreementPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.generator.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.basware.bttf.pages.AbstractPage.genUUID;
import static org.junit.Assert.assertEquals;

public class TwoStageLoaderSteps extends AbstractSteps {



    private final String PRICE_LIST_NAME = "pricelistName";
    private final String SKU_UNIQUE_ID = "skuUniqueId";
    private final String STOCK_NAME = "stockName";

    @Then("^On Loader page - I verify header of the page$")
    public void verifyTileForLoaderPage()
    {
        TwoStageLoaderDashboardPage twoStageLoaderDashboardPage = (TwoStageLoaderDashboardPage)getCurrentPage();
        twoStageLoaderDashboardPage.verifyHeaderOfThePage();
    }

    @And("^On Loader page - verify mandatory panels display for user$")
    public void verifyAllMandatoryPanels()
    {
        TwoStageLoaderDashboardPage twoStageLoaderDashboardPage = (TwoStageLoaderDashboardPage)getCurrentPage();
        twoStageLoaderDashboardPage.verifyPanelsInLoaderPage();
    }

    @When("^On Loader page - I click on '([^\"']*)' panel$")
    public void clickOnLoaderPanels(String panel)
    {
        TwoStageLoaderDashboardPage twoStageLoaderDashboardPage = (TwoStageLoaderDashboardPage)getCurrentPage();
        setCurrentPage(twoStageLoaderDashboardPage.clickOnPanel(panel));
    }

    @Then("^On Upload file page - I select mapping as '([^\"']*)'$")
    public void selectMappingOptions(String mappingOption)
    {
        LoaderUploadPage loaderUploadPage = (LoaderUploadPage)getCurrentPage();
        loaderUploadPage.selectMapping(mappingOption);
    }

   @Then("^On Upload page - I enter all details$")
    public void selectOutputTypeOption(DataTable table) {
       List<List<String>> rows = table.asLists(String.class);
       LoaderUploadPage loaderUploadPage = (LoaderUploadPage) getCurrentPage();

       for (List<String> columns : rows) {
           loaderUploadPage.selectUploadOptions(columns.get(0), columns.get(1));
       }
   }

   @When("^On upload file page - I click on upload button$")
    public void uploadTheFile()
   {
       LoaderUploadPage loaderUploadPage = (LoaderUploadPage)getCurrentPage();
       setCurrentPage(loaderUploadPage.clickOnUploadButton());
   }


    @When("^On Upload File page - I update ([^\"']*) in ([^\"']*)$")
    public void updateFile(String field, String filename) throws Exception
    {
        ExcelGenerator excelGenerator = new ExcelGenerator();
        String priceListName = "SLC_price_list"+ genUUID();
        props.set(PRICE_LIST_NAME,priceListName);
        switch (field){
            case "PriceListName":
                excelGenerator.updateFile(2,3,filename,priceListName);
                break;
        }
    }

    @When("^I upload the ([^\"']*) file ([^\"']*)$")
    public void uploadFile(String fileType,String fileName) throws Throwable {
        LoaderUploadPage loaderUploadPage = (LoaderUploadPage)getCurrentPage();
        String uniqueId = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        String storedPriceListFileName = uniqueId + fileName;
        String storedPricelistName = storedPriceListFileName.substring(0, storedPriceListFileName.lastIndexOf('.'));
        LOGGER.debug("pricelistName is " + storedPriceListFileName + "\n");
        CsvGenerator csvGenerator = new ContentLoaderCSVGenerator();
        switch (fileType.toLowerCase()) {
            case "bmecat":
                BMECatGenerator bmeGen = new BMECatGenerator();
                bmeGen.generateFile(uniqueId, storedPriceListFileName);
                props.set(PRICE_LIST_NAME, storedPricelistName);
                LOGGER.debug("Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName + "\n");
                waitPageLoaded();
                loaderUploadPage.enterFileToUpload(fileType, storedPriceListFileName);
                break;
            case "csv":
                csvGenerator.generateFile(uniqueId, storedPriceListFileName);
                props.set(PRICE_LIST_NAME, storedPricelistName);
                props.set(SKU_UNIQUE_ID, uniqueId);
                LOGGER.debug("Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName + "\n");
                waitPageLoaded();
                loaderUploadPage.enterFileToUpload(fileType, storedPriceListFileName);
                break;
            case "csvtax":
                fileType = "csv";
                CsvGenerator csvGeneratorTax = new ContentLoaderCSVWithTaxGenerator();
                csvGeneratorTax.generateFile(uniqueId, storedPriceListFileName);
                props.set(PRICE_LIST_NAME, storedPricelistName);
                props.set(SKU_UNIQUE_ID, uniqueId);
                LOGGER.debug("Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName + "\n");
                waitPageLoaded();
                loaderUploadPage.enterFileToUpload(fileType, storedPriceListFileName);
                break;
            case "xlsx":
                ExcelGenerator excelGenerator = new ExcelGenerator();
                excelGenerator.generateFile(uniqueId, storedPriceListFileName);
                props.set(PRICE_LIST_NAME, storedPricelistName);
                props.set(SKU_UNIQUE_ID, uniqueId);
                LOGGER.debug("Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName + "\n");
                waitPageLoaded();
                loaderUploadPage.enterFileToUpload(fileType, storedPriceListFileName);
                break;
            case "agent":
                fileType = "csv";
                CsvGenerator csvGeneratorAgent = new AgentAgreementCSVGenerator();
                csvGeneratorAgent.generateFile(uniqueId,storedPriceListFileName);
                props.set(PRICE_LIST_NAME,storedPricelistName);
                props.set(SKU_UNIQUE_ID,uniqueId);
                LOGGER.debug( "Agent agreement PAge ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName +"\n");
                loaderUploadPage.enterFileToUpload(fileType, storedPriceListFileName);
                waitPageLoaded();
                break;
            case "stock":
                fileType = "csv";
                CsvGenerator csvGeneratorAgentStock = new StockCsvGenerator();
                csvGeneratorAgentStock.generateFile(props.get(SKU_UNIQUE_ID),storedPriceListFileName);
                loaderUploadPage.enterFileToUpload(fileType, storedPriceListFileName);
                props.set(STOCK_NAME,storedPricelistName);
                break;
            case "modifiedxlsx":
                loaderUploadPage.enterFileToUpload(fileType,fileName);
                break;

        }
    }

   @Then("^The 2SL upload of the ([^\"']*) file has completed with ([^\"']*)$")
    public void verifyFileInStatusPage(String fileType, String expectedStatus)
   {
       LoaderStatusPage loaderStatusPage = (LoaderStatusPage)getCurrentPage();
       LOGGER.debug("Content Upload Page ... Waiting for upload to finish" + "\n" );
       String actualStatusMessage = loaderStatusPage.waitForUploadStatusMessage();
       assertEquals(expectedStatus,actualStatusMessage);
       String actualFileName = loaderStatusPage.fileName();
       switch (fileType.toLowerCase()) {
           case "csv":
                 assertEquals(actualFileName,props.get(PRICE_LIST_NAME));
                 break;
           case "xlsx":
               assertEquals(actualFileName,props.get(PRICE_LIST_NAME));
               break;
           case "stock":
               assertEquals(actualFileName,props.get(STOCK_NAME));
               break;
           case "sclxlsx":
               loaderStatusPage.verifyStatus();
               break;
       }
   }

   @And("^On upload status page - I click on view to see the staged file$")
    public void viewStagedFile()
   {
       LoaderStatusPage loaderStatusPage = (LoaderStatusPage)getCurrentPage();
       setCurrentPage(loaderStatusPage.clickOnViewForTheFirstEntry());
   }

   @Then("^On staging page - I verify items are present")
   public void verifyItemsInStagingPage()
   {
       LoaderStagingPage loaderStagingPage = (LoaderStagingPage) getCurrentPage();
       String skuValue = loaderStagingPage.verifyStagingItems();
       props.set("SupID", skuValue);
   }

   @Then("^On staging page - I click on '([^\"']*)'$")
    public void clickOnButtonInStagingPage(String button)
   {
      LoaderStagingPage loaderStagingPage = (LoaderStagingPage) getCurrentPage();
      setCurrentPage(loaderStagingPage.clickOnButton(button));
   }

   @Then("^The 2SL progress of the ([^\"']*) file has completed with ([^\"']*)")
    public void checkProgressStatus(String fileType, String expectedStatus)
   {
       LoaderStatusPage loaderStatusPage = (LoaderStatusPage)getCurrentPage();
       LOGGER.debug("Content Upload Page ... Waiting for upload to finish" + "\n" );
       String actualStatusMessage = loaderStatusPage.waitForProgressStatusMessage();
       assertEquals(actualStatusMessage,expectedStatus);
   }

   @Then("^I navigate to the Agreements page to verify upload is success$")
    public void navigateToAgreementsFromLoaderPage()
   {
       LoaderStatusPage loaderStatusPage = (LoaderStatusPage)getCurrentPage();
       LOGGER.debug( "PriceList Page ... Checking that Number Of Items Reported To Have Been Uploaded ... ");
       setCurrentPage(loaderStatusPage.clickPMBuyerSubmenuAgreements());
   }

   @Then("^On Select view agreement page - I select agreement created via 2SL$")
      public void searchAgreement()
    {
           SelectAgreementPage selectAgreementPage=(SelectAgreementPage) getCurrentPage();
           selectAgreementPage.searchSharedAgreement(props.get(PRICE_LIST_NAME));
    }

    @And("^On upload status page - I update the price for item first time$")
    public void updatePriceInDataLoad()
    {

    }

    @Then("^On Upload status page - I delete the record$")
    public void deleteTheRecord()
    {
        LoaderStagingPage loaderStagingPage = (LoaderStagingPage)getCurrentPage();
        loaderStagingPage.deleteRow();

    }
}

