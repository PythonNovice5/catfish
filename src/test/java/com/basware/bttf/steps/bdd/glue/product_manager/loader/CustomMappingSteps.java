package com.basware.bttf.steps.bdd.glue.product_manager.loader;

import com.basware.bttf.pages.product_manager.Loader.MapperPage;
import com.basware.bttf.pages.product_manager.Loader.MappingDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.generator.ContentLoaderCSVWithTaxGenerator;
import com.basware.bttf.util.generator.CsvGenerator;
import com.basware.bttf.util.generator.ExcelGenerator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomMappingSteps extends AbstractSteps {

    private final String PRICE_LIST_NAME = "pricelistName";
    private final String SKU_UNIQUE_ID = "skuUniqueId";

    @Then("^On Mapping directory page - I click on create mapping button$")
    public void clickOnCreateButton()
    {
        MappingDirectoryPage mappingDirectoryPage = (MappingDirectoryPage)getCurrentPage();
        setCurrentPage(mappingDirectoryPage.clickOnCreateMappingButton());
    }

    @Then("^On Mapper page - I enter all details$")
    public void enterFiledvalues(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        MapperPage mapperPage = (MapperPage) getCurrentPage();

        for (List<String> columns : rows) {
            mapperPage.enterMappingDetails(columns.get(0),columns.get(1));
        }
    }

    @Then("^On Mapper page - I upload the ([^\"']*) file ([^\"']*)$")
    public void uploadFileInMapperPage(String fileType ,String fileName) throws IOException, InterruptedException {

        String uniqueId = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        String storedPriceListFileName = uniqueId + fileName;
        String storedPricelistName = storedPriceListFileName.substring(0, storedPriceListFileName.lastIndexOf('.'));
        LOGGER.debug("pricelistName is " + storedPriceListFileName + "\n");
        MapperPage mapperPage = (MapperPage) getCurrentPage();
        switch(fileType) {
            case "csv":
                CsvGenerator csvGeneratorTax = new ContentLoaderCSVWithTaxGenerator();
                csvGeneratorTax.generateFile(uniqueId, storedPriceListFileName);
                props.set(PRICE_LIST_NAME, storedPricelistName);
                props.set(SKU_UNIQUE_ID, uniqueId);
                LOGGER.debug("Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName + "\n");
                waitPageLoaded();
                mapperPage.enterFileToUpload(storedPriceListFileName);
                break;
            case "xlsx":
                ExcelGenerator excelGenerator = new ExcelGenerator();
                excelGenerator.generateFile(uniqueId, storedPriceListFileName);
                props.set(PRICE_LIST_NAME, storedPricelistName);
                props.set(SKU_UNIQUE_ID, uniqueId);
                LOGGER.debug("Content Upload Page ... Upload " + fileType.toLowerCase() + " file called: " + storedPriceListFileName + "\n");
                waitPageLoaded();
                mapperPage.enterFileToUpload(storedPriceListFileName);
                break;
        }
    }

    @Then("On Mapper page - I add constant column for '([^\"']*)'")
    public void addColumn(String columnName) throws Exception
    {
        MapperPage mapperPage = (MapperPage) getCurrentPage();
        mapperPage.createConstantColumn(columnName);

    }

    @And("^On Mapper page - I drag all source columns to destination columns$")
    public void mapColumns(DataTable table) throws Exception {
        List<List<String>> rows = table.asLists(String.class);
        MapperPage mapperPage = (MapperPage) getCurrentPage();

        for (List<String> columns : rows) {
            mapperPage.mapAllFields(columns.get(0), columns.get(1));
        }
    }

    @Then("^On Mapper page - Save mapping$")
    public void saveCustomMapping()
    {
        MapperPage mapperPage = (MapperPage) getCurrentPage();
        mapperPage.saveMapping();
    }

    @Then("^On Mapper page - I add actions for fields$")
    public void addActions(DataTable table) throws Exception {
        List<List<String>> rows = table.asLists(String.class);
        MapperPage mapperPage = (MapperPage) getCurrentPage();

        for (List<String> columns : rows) {
            mapperPage.addMappingActions(columns.get(0), columns.get(1));
        }

    }

    @Then("^On Mapping directory page - I select upload button on recent custom mapping created$")
    public void clickOnUploadButtonOnCustomMapping()
    {
        MappingDirectoryPage mappingDirectoryPage = (MappingDirectoryPage)getCurrentPage();
       setCurrentPage(mappingDirectoryPage.clickOnUploadButton());

    }

    @Then("^On Mapping directory page - I delete custom mapping created$")
    public void deleteCustomMapping()
    {
        MappingDirectoryPage mappingDirectoryPage = (MappingDirectoryPage)getCurrentPage();
        mappingDirectoryPage.deleteCustomMapping();
    }
}