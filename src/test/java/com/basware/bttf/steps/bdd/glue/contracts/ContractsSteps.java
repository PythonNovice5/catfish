package com.basware.bttf.steps.bdd.glue.contracts;

import com.basware.bttf.pages.contracts.*;
import com.basware.bttf.pages.contracts.ContractUtils;
import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.shared.ContractPageUtil;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.generator.AbstractFileGenerator;
import com.basware.bttf.util.generator.BMECatGenerator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContractsSteps extends AbstractSteps {

    @Then("^In contract page - I click on '([^\"]*)' button to create '([^\"]*)'$")
    public void selectContractType(String button , String action )
    {
        LOGGER.debug("Contract page...click on" + button + "to" + "action");
        ContractsPage contractspage = (ContractsPage)getCurrentPage();
        setCurrentPage(contractspage.clickOnCreateContractType(action));
    }

    @Then("On Supplier Contracts page - I click on first Contract '([^\"']*)' link")
    public void clickOnSuppContractLinks( String linkname ) throws Exception
    {
        LOGGER.debug("On Supplier Contracts page  ... Click " + linkname + " button" + "\n" );
        SupplierContractsPage supplierContractsPage = (SupplierContractsPage) getCurrentPage();
        setCurrentPage(supplierContractsPage.clickOnLink(linkname));
    }

    @And("^On Contracts Create Item page - I click on '([^\"']*)' button")
    public void clickBtnOnCreateItemPage( String buttonName ) throws Exception
    {
        LOGGER.debug("On Contracts Create Item page ... Click " + buttonName + " button" + "\n" );
        ContractsCreateItemPage contractsCreateItemPage = (ContractsCreateItemPage) getCurrentPage();
        setCurrentPage(contractsCreateItemPage.clickBtn(buttonName));
    }

    @Then("^On Contracts Create Item page - I enter the following item details")
    public void enterItemDetails( DataTable table ) throws Exception {
        LOGGER.debug("On Contracts Create Item page - I enter the following item details" + "\n");
        ContractsCreateItemPage contractsCreateItemPage = (ContractsCreateItemPage) getCurrentPage();
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            contractsCreateItemPage.enterAllDetails(columns.get(0), columns.get(1));
        }
    }

    @Then("^On Contracts Item Directory page - I click on '([^\"']*)' button")
    public void clickItemDirButton( String buttonName ) throws Exception
    {
        LOGGER.debug("On Contracts Item Directory page ... Click " + buttonName + " button" + "\n" );
        ContractsItemsDirectoryPage contractsItemsDirectoryPage = (ContractsItemsDirectoryPage) getCurrentPage();
        setCurrentPage(contractsItemsDirectoryPage.clickBtn(buttonName));
    }

    @Then("^On Supplier Contracts page - I click on '([^\"']*)' button$")
    public void clickThisButton( String buttonName ) throws Exception
    {
        LOGGER.debug("On Supplier Contracts page ... Click " + buttonName + " button" + "\n" );
        SupplierContractsPage supplierContractsPage = (SupplierContractsPage) getCurrentPage();

        switch( buttonName )
        {
            case "Search":
//                contractsPage.clickWebElement(contractsPage.ViewItems);
                supplierContractsPage.clickWebElement(supplierContractsPage.SearchBtn);
                break;
            // default for those elements that cause page re-load
//            default: setCurrentPage( itemDirectoryPage.clickPageReloadingElement( buttonName ) );
        }
    }
    @Then ("^On Supplier Contracts page - I enter '([^\"]*)' into '([^\"]*)'$")
    public void enterValueIntoField( String value, String fieldName )  throws Throwable
    {
        LOGGER.debug( "Supplier Contracts Page ... Enter value " + value + " into field " + fieldName + "\n" );
        SupplierContractsPage supplierContractsPage = (SupplierContractsPage) getCurrentPage();
        supplierContractsPage.enterValueIntoField(value,fieldName);
    }


    @Then("^In edit contract page - I enter '([^\"]*)' as '([^\"]*)'$")
    public void enterContractDetails(String field, String value)
    {
      EditContractPage editContractPage =  (EditContractPage)getCurrentPage();
        LOGGER.debug("On Contract page.....enter"+ field + " with value of" + value + "\n");
        editContractPage.enterContractDetails(field,value);
    }

    @Then("^In edit contract page - I select '([^\"]*)' as '([^\"]*)'$")
    public void selectContractDetails(String dropdown, String value) throws Exception {
        EditContractPage editContractPage =  (EditContractPage)getCurrentPage();
        LOGGER.debug("On Contract page.....select"+ dropdown + " with value of" + value + "\n");
        editContractPage.selectContractDetails(dropdown,value);
    }

    @Then("^In edit contract page - I click on '([^\"]*)' button to '([^\"]*)'$")
    public void clickOnButtonInEditContractPage(String button,String action )
    {
        EditContractPage editContractPage = (EditContractPage) getCurrentPage();
        LOGGER.debug("On contract page.......click on"+ button + "to" + action );
        setCurrentPage(editContractPage.clickOnButton(button,action));
    }

    @And("^In the Manage suppliers page - I click on '([^\"]*)' button to '([^\"]*)' suppliers$")
    public void addSupplierToContract(String button, String action)
    {
        ContractsSuppliersPage contractsSuppliersPage = (ContractsSuppliersPage) getCurrentPage();
        LOGGER.debug("On Manage suppliers page.....click on"+ button + "to" + action + "\n");
        setCurrentPage(contractsSuppliersPage.clickOnSuppliersButton(button));
    }

    @Then("^In the Contract upload suppliers page - I select a file to upload$")
    public void uploadSuppliersFile() throws Exception {
        ContractUploadSuppliersPage contractUploadSuppliersPage = (ContractUploadSuppliersPage) getCurrentPage();
        contractUploadSuppliersPage.enterFileToUploadSuppliers();
        contractUploadSuppliersPage.clickOnUploadSupplierButton();
        contractUploadSuppliersPage.verifyUploadResults();
    }

    @Then("^In the Contract supplier page - I search as '([^\"]*)'$")
    public void searchSupplier(String supplier)
    {
        AddContractSupplierPage addContractSupplierPage = (AddContractSupplierPage) getCurrentPage();
        addContractSupplierPage.searchSupplier(supplier);
    }

    @Then("^In the Contract supplier page - I select check box for Catfish-RW-Supplier$")
    public void selectSupplier()
    {
        AddContractSupplierPage addContractSupplierPage = (AddContractSupplierPage) getCurrentPage();
        addContractSupplierPage.selectSupplier();
    }

    @When("^In the Contract supplier page - I click on 'add selected' button$")
    public void clickAddSelectedSupplier()
    {
       AddContractSupplierPage addContractSupplierPage = (AddContractSupplierPage) getCurrentPage();
       setCurrentPage(addContractSupplierPage.addSelectedSupplier());

    }

    @Then("^In the Contract page - I click on '([^\"]*)' button$")
    public void clickOnItemTab(String tabName)
    {
        ContractPageUtil contractPageUtil = new ContractPageUtil();
        setCurrentPage(contractPageUtil.clickOnContractTab(tabName,driver));
    }

    @And("^In the Contract Item page - I click on 'Upload items' button to upload suppliers$")
    public void uploadContractItems()
    {
        ContractManageItemsPage contractManageItemsPage = (ContractManageItemsPage) getCurrentPage();
        setCurrentPage(contractManageItemsPage.clickOnUploadItems());
    }

    @Then("^In the Contract upload item page - I upload file for items$")
    public void uploadItemFile() throws Exception
    {
        ContractUploadItemPage contractUploadItemPage = (ContractUploadItemPage)getCurrentPage();
        contractUploadItemPage.enterFileToUploadItems();
        contractUploadItemPage.verifyUploadResults();
    }

    @Then("^On Add Categories page - I click on Add to add categories$")
    public void addCategories()
    {
        AddCategoriesPage addCategoriesPage = (AddCategoriesPage)getCurrentPage();
        setCurrentPage(addCategoriesPage.clickOnAddButton());
    }

    @Then("^In the Contract attachment page - I upload file$")
    public void uploadAttachment()
    {
        ContractAttachmentsPage contractAttachmentsPage = (ContractAttachmentsPage)getCurrentPage();
        contractAttachmentsPage. clickOnAddAttachment();
        contractAttachmentsPage.chooseFileToAttach();
    }

    @Then("^In the Contract categories page - I click on 'add categories' button$")
    public void addCategoriesToContract()
    {
        ContractCategoryPage contractCategoryPage = (ContractCategoryPage)getCurrentPage();
        setCurrentPage(contractCategoryPage.clickOnAddCategories());
    }

    @Then("^In the Manage item page - I enter 'item attributes configuration'$")
    public void enterItemAttributesConfiguration() throws Exception {
        ContractItemAttributesPage contractItemAttributesPage = (ContractItemAttributesPage) getCurrentPage();
        BMECatGenerator bmeCatGenerator = new BMECatGenerator();
        String itemAttributes = bmeCatGenerator.readFile(AbstractFileGenerator.testDataPath+"ItemAttributesForFSF.txt");
        itemAttributes = itemAttributes.replace("\t","");
        contractItemAttributesPage.enterItemAttributes(itemAttributes);
    }

    @Then("^In the Manage item page - I click on save button$")
    public void saveItemAttributes()
    {
        ContractItemAttributesPage contractItemAttributesPage = (ContractItemAttributesPage) getCurrentPage();
        setCurrentPage(contractItemAttributesPage.saveAttributes());
    }

    @Then("^In the Manage item page - I verify successful message$")
    public void verifySuccessMessage()
    {
       ContractManageItemsPage contractManageItemsPage = (ContractManageItemsPage) getCurrentPage();
       contractManageItemsPage.verifySuccessMessage();
    }

   /* @Then("^In the Manage item page - I click on '([^\"]*)' tab$")
    public void clickOnContractTab(String tab)
    {
        ContractManageItemsPage contractManageItemsPage = (ContractManageItemsPage) getCurrentPage();
        setCurrentPage(contractManageItemsPage.clickOnContractTab(tab));
    }*/

   @When("^In My Contract page - I click on publish button to publish the contract$")
    public void clickOnPublishButton()
    {
        MyContractPage myContractPage = (MyContractPage) getCurrentPage();
        myContractPage.clickOnPublish();
    }

    @Then("^In My Contract page - I confirm ok$")
    public void confirmOk() {
        MyContractPage myContractPage = (MyContractPage) getCurrentPage();
        myContractPage.clickOK();
    }

    @Then("^In My Contract page - I verify contract published")
     public void verifySuccessfulMessage()
    {
        MyContractPage myContractPage = (MyContractPage)getCurrentPage();
        myContractPage.verifySuccessfulContractPublish();
    }

    @Then("^On My Contract page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkElementValue(String elementName, String expectedValue) throws Throwable {
    MyContractPage myContractPage = (MyContractPage) getCurrentPage();
    String actualValue = myContractPage.getElementValue( elementName );
    LOGGER.debug( "My Contract Page ... " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
    assertEquals( "Unexpected value", expectedValue, actualValue );
    }

    @Then("^On Contracts List page - I click on '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug("On Contracts List page ... Click " + buttonName + " button" + "\n" );
        ContractsPage contractsPage = (ContractsPage) getCurrentPage();

        switch( buttonName )
        {
            case "Search":
//                contractsPage.clickWebElement(contractsPage.ViewItems);
                contractsPage.clickWebElement(contractsPage.SearchContract);
                 break;
            // default for those elements that cause page re-load
//            default: setCurrentPage( itemDirectoryPage.clickPageReloadingElement( buttonName ) );
        }
    }

    @Then ("^On Contracts List page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoPriceListDirectoryField( String value, String fieldName )  throws Throwable
    {
        LOGGER.debug( "Price List Directory Page ... Enter value " + value + " into field " + fieldName + "\n" );
        ContractsPage contractsPage = (ContractsPage) getCurrentPage();
        contractsPage.enterValueIntoField(value,fieldName);
    }

    @Then("^On Contracts List page - I click on '([^\"']*)' link")
    public void clickLink( String buttonName ) throws Exception
    {
        LOGGER.debug("On Contracts List page ... Click " + buttonName + " button" + "\n" );
        ContractsPage contractsPage = (ContractsPage) getCurrentPage();
        switch(buttonName)        {
            case "Catfish Contract":
                setCurrentPage(contractsPage.clickContractLink());
                break;
            // default for those elements that cause page re-load
//            default: setCurrentPage( itemDirectoryPage.clickPageReloadingElement( buttonName ) );
        }
    }


    @Then("^On My Contract page - I click on '([^\"']*)' button")
    public void clickBtn( String buttonName ) throws Exception
    {
        LOGGER.debug("On My Contract page ... Click " + buttonName + " button" + "\n" );
        MyContractPage myContractPage = (MyContractPage) getCurrentPage();
        setCurrentPage(myContractPage.clickBtn(buttonName));
    }


    @Then("^On Contracts Management Page - I navigate '([^\"']*)'")
    public void navigateTo(String value){
        ContractManageItemsPage contractManageItemsPage = (ContractManageItemsPage)getCurrentPage();
        LOGGER.debug("On Contracts Management Page ... Navigate to previous page" + "\n" );
        switch (value){
            case "Back":
                setCurrentPage(contractManageItemsPage.navigateToPrevious());
                break;
        }
    }


    @And("^On Contracts Sharing page - I select and add '([^\"']*)'$")
    public void addComm(String value) throws Exception
    {
        LOGGER.debug("On Contracts Sharing page ... I select and add -  " + value + "\n" );
        ContractsSharingPage contractsSharingPage = (ContractsSharingPage) getCurrentPage();
        setCurrentPage(contractsSharingPage.addOrg(value));

    }


    @Then("^On Contracts Sharing page - I click on '([^\"']*)' button")
    public void clickOn( String buttonName ) throws Exception
    {
        LOGGER.debug("On Contracts Sharing page ... Click " + buttonName + " button" + "\n" );
        ContractsSharingPage contractsSharingPage = (ContractsSharingPage) getCurrentPage();
        setCurrentPage(contractsSharingPage.clickBtn(buttonName));
    }



    @Then("^On Contracts Management Page - I click on '([^\"']*)' button")
    public void clickOnButton( String btn ) throws Exception
    {
        LOGGER.debug("On Contracts Management page ... Click " + btn + " button" + "\n" );
        ContractManageItemsPage contractManageItemsPage = (ContractManageItemsPage) getCurrentPage();
        setCurrentPage(contractManageItemsPage.clickBtn(btn));
    }

    @Then("^On manage items page - I choose item$")
    public void chooseItemForContract()
    {
        ContractManageItemsPage contractManageItemsPage = (ContractManageItemsPage)getCurrentPage();
        contractManageItemsPage.selectItem();

    }
}
