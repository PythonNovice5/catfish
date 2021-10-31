package com.basware.bttf.steps.bdd.glue.product_manager.supplier.content_upload;

import com.basware.bttf.pages.product_manager.buyer.agreements.UploadAgentItemsPage;
import com.basware.bttf.pages.product_manager.supplier.content_upload.ContentUploadPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.ManagePriceListPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.UploadBundlesPage;
import com.basware.bttf.pages.shared.ImportPageUtil;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.generator.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ContentUploadPageSteps  extends AbstractSteps {

    ContentUploadPage contentUploadPage = new ContentUploadPage();
    private final String PRICE_LIST_NAME = "pricelistName";
    private final String SKU_UNIQUE_ID = "skuUniqueId";

    @When("^I select the upload type ([^\"']*)$")
    public void selectType(String uploadType) throws Throwable
    {
        waitPageLoaded();
        contentUploadPage.selectUploadType(uploadType);
    }

    @When("^I select the currency ([^\"']*) for the price list$")
    public void selectCurrency(String currency) throws Throwable
    {
        LOGGER.debug( "Content Upload Page ... Select Currency: " + currency +"\n");
        contentUploadPage.selectCurrency(currency);
    }

    @When("^I select the language ([^\"']*) for the price list$")
    public void selectLanguage(String language) throws Throwable
    {
        LOGGER.debug( "Content Upload Page ... Select Language: " + language +"\n");
        contentUploadPage.selectLanguage(language);
    }

    @When("^On Content Upload Page - I upload the ([^\"']*) file ([^\"']*)$")
    public void uploadFile(String fileType,String fileName) throws Throwable
    {
        String uniqueId = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        String storedPriceListFileName = uniqueId + fileName;
        String storedPricelistName = storedPriceListFileName.substring(0,storedPriceListFileName.lastIndexOf('.'));
        LOGGER.debug( "pricelistName is " + storedPriceListFileName +"\n");
        CsvGenerator csvGenerator = new ContentLoaderCSVGenerator();
        switch (fileType.toLowerCase()){
            case "bmecat":
                BMECatGenerator bmeGen = new BMECatGenerator();
                bmeGen.generateFile(uniqueId,storedPriceListFileName);
                props.set(PRICE_LIST_NAME,storedPricelistName);
                LOGGER.debug( "Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName +"\n");
                waitPageLoaded();
                contentUploadPage.enterFileToUpload(fileType,storedPriceListFileName);
                contentUploadPage.uploadFileOfType(fileType);
                break;
            case "csv":
//                CsvGenerator csvGenerator = new ContentLoaderCSVGenerator();
                csvGenerator.generateFile(uniqueId,storedPriceListFileName);
                props.set(PRICE_LIST_NAME,storedPricelistName);
                props.set(SKU_UNIQUE_ID,uniqueId);
                LOGGER.debug( "Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName +"\n");
                waitPageLoaded();
                contentUploadPage.enterFileToUpload(fileType,storedPriceListFileName);
                contentUploadPage.uploadFileOfType(fileType);
                break;
            case "agent":
                CsvGenerator csvGeneratorAgent = new AgentAgreementCSVGenerator();
                csvGeneratorAgent.generateFile(uniqueId,storedPriceListFileName);
                props.set(PRICE_LIST_NAME,storedPricelistName);
                props.set(SKU_UNIQUE_ID,uniqueId);
                LOGGER.debug( "Agent agreement PAge ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName +"\n");
                waitPageLoaded();
                UploadAgentItemsPage uploadAgentItemsPage = new UploadAgentItemsPage();
                uploadAgentItemsPage.enterAgentFileToUpload(fileType,storedPriceListFileName);
                uploadAgentItemsPage.clickOnUploadButton();
                break;
            case "bundled":
                CsvGenerator csvGenerator1 = new BundledCSVGenerator();
                csvGenerator1.generateFile(props.get(SKU_UNIQUE_ID),storedPriceListFileName);
                ImportPageUtil.uploadFile(driver,storedPriceListFileName);
                break;
            case "related":
                CsvGenerator csvGenerator2 = new RelatedCSVGenerator();
                csvGenerator2.generateFile(props.get(SKU_UNIQUE_ID),storedPriceListFileName);
                ImportPageUtil.uploadFile(driver,storedPriceListFileName);
                break;
            case "pricelist":
                CsvGenerator csvGenerator3 = new PriceListCsvGenerator();
                csvGenerator3.generateFile(props.get(SKU_UNIQUE_ID),storedPriceListFileName);
                ImportPageUtil.uploadFile(driver,storedPriceListFileName);
                break;
            case "zip":
                String storedZipFileName = storedPriceListFileName.replace("csv","zip");
                CsvGenerator csvGenerator4 = new ContentLoaderCSVGenerator();
                csvGenerator4.generateFile(uniqueId,storedPriceListFileName);
                waitPageLoaded();
                csvGenerator4.generateZipFile(storedPriceListFileName,storedZipFileName);
                props.set(PRICE_LIST_NAME,storedPricelistName);
                props.set(SKU_UNIQUE_ID,uniqueId);
                LOGGER.debug( "Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName +"\n");
                waitPageLoaded();
                contentUploadPage.enterFileToUpload(fileType,storedZipFileName);
                contentUploadPage.uploadFileOfType(fileType);
                break;
            case "zip_xml":
                String storedZipFileNameXml = storedPriceListFileName.replace("xml","zip");
                BMECatGenerator bmeCatGenerator = new BMECatGenerator();
                bmeCatGenerator.generateFile(uniqueId,storedPriceListFileName);
                waitPageLoaded();
                bmeCatGenerator.generateZipFile(storedPriceListFileName,storedZipFileNameXml);
                props.set(PRICE_LIST_NAME,storedPricelistName);
                props.set(SKU_UNIQUE_ID,uniqueId);
                LOGGER.debug( "Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName +"\n");
                waitPageLoaded();
                contentUploadPage.enterFileToUpload(fileType,storedZipFileNameXml);
                contentUploadPage.uploadFileOfType(fileType);
                break;
            case "frameworkcsv":
                contentUploadPage.enterItemsFileToUpload(fileType,fileName);
                setCurrentPage(contentUploadPage.uploadFile());
                break;
            default:
                break;
        }

    }

    @Then("^The upload of the ([^\"']*) file has completed with ([^\"']*)$")
    public void uploadCompleted(String fileType, String expectedStatus) throws Throwable {
        LOGGER.debug("Content Upload Page ... Waiting for upload to finish" + "\n" );
        String actualStatusMessage = contentUploadPage.waitForUploadStatusMessage();
        assertEquals(actualStatusMessage,expectedStatus);
        String actualFileName = contentUploadPage.fileName();
        assertEquals(actualFileName,props.get(PRICE_LIST_NAME)+"."+fileType);
    }

    @Then("I navigate to the PriceList page to verify upload is success")
    public void navigatToPricelist()
    {
        LOGGER.debug( "PriceList Page ... Checking that Number Of Items Reported To Have Been Uploaded ... ");
        setCurrentPage(contentUploadPage.clickPMSupplierSubmenuPriceLists());
    }

    @And("^On pricelist page - I click on Sort By:([^\"']*)$")
    public void sortBy(String sortOption)
    {
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage) getCurrentPage();
        priceListDirectoryPage.sortBy(sortOption);
    }

    @And("^On Pricelist Page - I verify newly created pricelist ([^\"']*)$")
    public void verifyPriceListCreated(String priceListName) throws  Exception
    {
        PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage)getCurrentPage();
        String actualPriceListName = priceListDirectoryPage.getFirstPriceListFieldValue(priceListName);
        assertEquals(actualPriceListName,props.get(PRICE_LIST_NAME));
    }

    @Then("^The file has processed ([^\"']*) ([^\"']*) successfully$")
    public void checkNumberOfItemsReportedToHaveBeenUploaded(String expectedNumberOfItems,String fieldValue) throws Throwable
    {
        LOGGER.debug( "PriceList Page ... Checking that Number Of Items Reported To Have Been Uploaded ... ");
       PriceListDirectoryPage priceListDirectoryPage = (PriceListDirectoryPage)getCurrentPage();
       String actualNumberOfItems = priceListDirectoryPage.getFirstPriceListFieldValue(fieldValue);
       assertEquals(expectedNumberOfItems,actualNumberOfItems);
    }



   @When("^I stop the ([^\"']*) file upload prematurely$")
    public void stopUpload(String fileType) throws Throwable {
        LOGGER.debug( "Content Upload Page ... Stopping the " + fileType + " upload" +"\n");
        contentUploadPage.stopUpload();
    }

    @Then("^On upload bundles page - I click on upload button to upload$")
    public void clickOnUploadButton() throws InterruptedException {
        setCurrentPage(ImportPageUtil.clickOnUploadButton(driver));
        waitPageLoaded();
    }

    @Then("^I select '([^\"']*)'$")
    public void selectUploadType(String action)
    {
        ImportPageUtil.selectUploadAction(driver,action);
    }

    @Then("^On the Manage Price list page - I verify '([^\"']*)'$")
    public void verifyBundledAndRelatedItems(String type)
    {
        ManagePriceListPage managePriceListPage = (ManagePriceListPage) getCurrentPage();
        managePriceListPage.verifyUploadedItems(type);

    }


    public boolean waitPageLoaded()  throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        /* *** DKN-20161114 Cannot seem to avoid this sleep *** */
        Thread.sleep(500);
        final JavascriptExecutor js = (JavascriptExecutor) driver;

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try
                {
                    //LOGGER.debug( "jQuery Active " + js.executeScript("return jQuery.active").toString() );
                    return ((Long) js.executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                //LOGGER.debug( "Javascript ??? " + js.executeScript("return document.readyState").toString() );
                return js.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);

    }
}
