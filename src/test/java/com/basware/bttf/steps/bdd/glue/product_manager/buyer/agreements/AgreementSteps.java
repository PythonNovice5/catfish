package com.basware.bttf.steps.bdd.glue.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.buyer.agreements.*;
import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AgreementSteps extends AbstractSteps
{

    @When("^On the Create Agreement page - I enter Agreement '([^\"']*)' of '([^\"]*)'$")
    public void enterAgreementFieldOf(String fieldName, String value) throws Throwable
    {
        CreateAgreementPage createAgreementPage  = (CreateAgreementPage) getCurrentPage();
        LOGGER.debug( "Create Agreement Page ... Enter Agreement " + fieldName + " with value of " + value + "\n" );

        switch (fieldName.toLowerCase()){
            case "name":
                createAgreementPage.enterAgreementName( value + createAgreementPage.getSessionID() );
                //Store the expected name of the organisation agreement for future tests
                props.set(TestConstants.ORG_AGREEMENT_NAME, value + createAgreementPage.getSessionID() );
                LOGGER.debug("Entered Agreement Name "+props.get(TestConstants.ORG_AGREEMENT_NAME));
                break;
            case "contract reference":
                value= value +createAgreementPage.getSessionID();
                createAgreementPage.enterContractReference(value);
                props.set(TestConstants.CONTRACT_REF,value);
                break;
            case "description":
                createAgreementPage.enterDescription(value);
                break;
            case "start date":
                createAgreementPage.enterStartDateByText(value);
                break;
            case "expiry date":
                createAgreementPage.enterExpiryDateByText(value);
                break;
            case "keywords":
                createAgreementPage.enterKeywords(value);
                break;
            case "for supplier":
                createAgreementPage.enterForSupplier(value);
                break;
        }

    }

    @And("^On the Agreement Pricelist Items page - I click on '([^\"]*)' button")
    public void clickOn(String button)
    {
        LOGGER.debug("On Agreement Pricelist Items page I click on  "+button);
        AgreementPricelistItemPage agreementPricelistItemPage = (AgreementPricelistItemPage) getCurrentPage();
        setCurrentPage(agreementPricelistItemPage.clickOnElem(button));
    }

    @Then("^On the Agreement Items create item page - I enter '([^\"]*)' plus SessionGUID into '([^\"]*)'$")
    public void enterAgentSupplierId(String value,String elementName) throws Exception {
        String sessionGUID = getCurrentPage().getSessionID();
        String valueNew = value + sessionGUID;
        props.set("SupID",valueNew);
        LOGGER.debug("Supplier ID: "+valueNew);
        enterItemDeatilsForAgentItem(valueNew,elementName);
    }

    @Then("^On the Agreement Items create item page - I enter '([^\"]*)' into '([^\"]*)'$")
    public void enterItemDeatilsForAgentItem(String value, String elementName) throws Exception {
        LOGGER.debug("On Agreement Items Create Item Page - I enter "+value+" into "+elementName);
        AgreementItemCreateItemPage agreementItemCreateItemPage = (AgreementItemCreateItemPage) getCurrentPage();
        agreementItemCreateItemPage.enterValueIntoElement(value,elementName);
    }


    @And("^On the Agreement Items create item page - I click on '([^\"]*)'$")
    public void clickOnCogForAgentItem(String button)
    {
        LOGGER.debug("On the Agreement Items create Item page - I click on "+button);
        AgreementItemCreateItemPage agreementItemCreateItemPage = (AgreementItemCreateItemPage) getCurrentPage();
        setCurrentPage(agreementItemCreateItemPage.clickOnButton(button));
    }

    @Then("^On the Agreement Items Edit page - I verify agent item is added successfully$")
    public void verifyAgentItemAdded()
    {
        AgreementItemsEditPage agreementItemsEditPage = (AgreementItemsEditPage) getCurrentPage();
        agreementItemsEditPage.verifySuccessAlert();
    }

    @Then("^On the Agenet Agreement Create item page - I verify agent item is added successfully$")
    public void verifyAgentItemAddedSuccessfully()
    {
        AgreementItemsEditPage agreementItemsEditPage = (AgreementItemsEditPage) getCurrentPage();
        agreementItemsEditPage.verifySuccessAlert();
    }

//    @Then("^On the Agreement Items Edit page - I click on '([^\"]*)'")
//    public void goBackToPricelist(String button)
//    {
//        AgreementItemsEditPage agreementItemsEditPage = (AgreementItemsEditPage) getCurrentPage();
//
//        switch (button) {
//            case "BackToAgreementPriceListItems":
//                setCurrentPage(agreementItemsEditPage.navigateBackToPricelistItems());
//                break;
//        }
//    }


    @When("^On the Create Agreement page - I select Agreement '([^\"']*)' of '([^\"']*)'$")
    public void selectAgreementFieldOf(String dropdown, String value) throws Throwable
    {
        CreateAgreementPage createAgreementPage  = (CreateAgreementPage) getCurrentPage();
        LOGGER.debug( "Create Agreement Page ... Select Agreement " + dropdown + " of " + value + " \n");

        switch (dropdown.toLowerCase()) {
            case "type":
                createAgreementPage.selectAgreementType(value);
                break;
            case "currency":
                createAgreementPage.selectCurrency(value);
                break;
            case "language":
                createAgreementPage.selectLanguage(value);
                break;
        }
    }

    @Then("^On Buyer Manage Agreement price list page - I click on approve button$")
    public void approveAgentAgreement()
    {
        AgentAgreementPricelistItemPage agentAgreementPricelistItemPage = (AgentAgreementPricelistItemPage)getCurrentPage();
        agentAgreementPricelistItemPage.approveAgreement();
    }

    @When("^On the Manage Agreement page - I '([^\"']*)' dps")
    public void enableDPS(String enableOrDisable){
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage)getCurrentPage();
        manageAgreementPage.enableOrDisableDPS(enableOrDisable);
    }

    @When("^On the Manage Agreement page - I click on the '([^\"']*)' button$")
    public void clickButton(String button) throws Throwable
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        LOGGER.debug( "Create Agreement Page ... Click " + button + " button" + "\n");

        switch ( button.toLowerCase())
        {
            case "select supplier":
                setCurrentPage( manageAgreementPage.selectSupplier() );
                break;
            case "select approval scheme":
                setCurrentPage( manageAgreementPage.selectApprovalScheme() );
                break;
            case "add content tag":
                manageAgreementPage.clickOnAddContentTag();
                break;
            case "review pricelist cog":
                setCurrentPage(manageAgreementPage.clickOnReviewPricelistCog());
                break;
            case "import":
               setCurrentPage(manageAgreementPage.clickOnImportButton());
                break;
            case "importitemframework":
                setCurrentPage(manageAgreementPage.clickOnImportButton());
                break;
            case "remove content tag":
                manageAgreementPage.removeContentTag();
                break;
            case "publish":
                manageAgreementPage.publishAgreement();
                break;
            case "submittosupplier":
                manageAgreementPage.clickPublish();
                break;
            case "manageitems":
                setCurrentPage(manageAgreementPage.clickMangeItemsCog());
                break;
            case "approve":
                manageAgreementPage.clickOnApproveButton();
                break;
            case "cancel":
                if (isAlertPresent()) {
                    driver.switchTo().alert();
                    driver.switchTo().alert().accept();
                    driver.switchTo().defaultContent();
                }
                break;
            case "approval link":
                setCurrentPage(manageAgreementPage.clickOnApprovalLink());
                break;
            default:
                LOGGER.debug( "Create Agreement Page ... No such button called " + button + "\n" );
                break;
        }

    }

    @Then("^On the Create Agreement page - I check that '([^\"']*)' '([^\"']*)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Exception
    {
        LOGGER.debug( "On the Create Agreement page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        CreateAgreementPage createAgreementPage = (CreateAgreementPage) getCurrentPage();
        createAgreementPage.agreementTypeDropdown.click();
        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
            Assert.assertTrue(elementName + " element is unexpectedly not displayed", createAgreementPage.elementIsDisplayed( elementName ));
        else                                // if expecting the element not to be displayed
            Assert.assertTrue(elementName + " element is unexpectedly displayed", createAgreementPage.elementIsNotDisplayed( elementName ));
    }

    @And("^On the Select Supplier page - I select the Supplier called '([^\"]*)'$")
    public void searchForAndAddSupplier(String supplierName) throws Throwable
    {
        SelectSupplierPage selectSupplierPage = ( SelectSupplierPage ) getCurrentPage();
        LOGGER.debug( "Select Supplier Page ... Search and Select Supplier " + supplierName + "\n" );
        selectSupplierPage.searchForSupplier( supplierName );
        setCurrentPage( selectSupplierPage.addSupplier( supplierName ) );
    }

    @And("^On the Select Approval Scheme page - I select the Approval Scheme called '([^\"]*)'$")
    public void selectApprovalScheme(String approvalSchemeName) throws Throwable
    {
        ApprovalSchemeDirectoryPage selectApprovalSchemePage = (ApprovalSchemeDirectoryPage) getCurrentPage();
        LOGGER.debug( "Select Approval Scheme Page ... Search and Select Supplier " + approvalSchemeName + "\n" );
        selectApprovalSchemePage.searchApprovalScheme( approvalSchemeName );
        selectApprovalSchemePage.selectApprovalSchemeFromSearchResults( approvalSchemeName );
        setCurrentPage( selectApprovalSchemePage.clickDone() );
    }


    @When("^On the Create Agreement page - I save the '([^\"']*)' Agreement$")
    public void saveAgreement(String type) throws Throwable
    {
        CreateAgreementPage createAgreementPage  = (CreateAgreementPage) getCurrentPage();
        LOGGER.debug( "Create Agreement Page ... Save Agreement" + "\n" );
        setCurrentPage( createAgreementPage.saveAgreement(type) );
    }

    @And("^On the Manage Agreement page - I enter Agreement For Supplier of '([^\"']*)'$")
    public void enterForSupplier(String value )
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        manageAgreementPage.enterForSupplier(value);
    }

    @Then("^On the Manage Agreement page - The Agreement '([^\"']*)' is '([^\"]*)'$")
    public void validateAgreementValue(String field, String expectedValue) throws Throwable {

        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        //setCurrentPage( manageAgreementPage );

        String actualValue = "";
        String[] priceListDetails;

        switch (field.toLowerCase()){
            case "name":
                expectedValue = expectedValue + manageAgreementPage.getSessionID();
                actualValue = manageAgreementPage.getAgreementName();
                break;
            case "type":
                actualValue = manageAgreementPage.getAgreementType();
                break;
            case "supplier":
                actualValue = manageAgreementPage.getSupplier();
                break;
            case "pricelist name":
                actualValue = manageAgreementPage.getPriceListDetails();
                priceListDetails = actualValue.split("-");
                actualValue = priceListDetails[0];
                break;
            case "pricelist item count":
                actualValue = manageAgreementPage.getPriceListDetails();
                priceListDetails = actualValue.split("-");
                actualValue = priceListDetails[1];
                break;
            case "contract reference":
                expectedValue = expectedValue + manageAgreementPage.getSessionID();
                actualValue = manageAgreementPage.getContractReference();
                break;
            case "status":
                actualValue = manageAgreementPage.getStatus();
                break;
            case "language":
                actualValue = manageAgreementPage.getLanguage();
                break;
            case "currency":
                actualValue = manageAgreementPage.getCurrency();
                break;
            case "approval scheme":
                actualValue = manageAgreementPage.getApprovalScheme();
                break;
            case "keywords":
                actualValue = manageAgreementPage.getKeyword();
                break;
            case "for supplier":
                actualValue = manageAgreementPage.getForSupplier();
                break;

                 }

        LOGGER.debug( "Create Agreement Page ... Comparing " + field + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( "Unexpected value", actualValue, expectedValue );
    }

    @When("^On the Manage Agreement page - I select the Supplier called '([^\"]*)'$")
    public void selectSupplierCalled(String supplierName) throws Throwable
    {
        LOGGER.debug( "Manage Agreement Page ... Select Supplier Called: " + supplierName + "\n" );
    }

    @When("^On the Manage Agreement page - I select the Approval Scheme called '([^\"]*)'$")
    public void selectApprovalSchemeCalled(String approvalSchemeName) throws Throwable
    {
        LOGGER.debug( "Manage Agreement Page ... Select Approval Scheme Called: " + approvalSchemeName + "\n" );
    }

    @When("^Enter content tag name as '([^\"]*)' in the modal popup$")
        public void enterContentTag(String contentTag) throws Throwable{

            ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
            manageAgreementPage.enterName(contentTag);
    }

    @Then("^I click on 'add' button in the modal popup$")
    public void addContentTag(){
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        manageAgreementPage.clickAddOnModalPopUp();
    }

    @Then("^On Buyer Manage Agreement price list page - click On content tag drop down for '([^\"]*)' item and choose '([^\"]*)'$")
    public void addContentTagToItem(int itemNumber,String tagToSelect)
    {
        AgentAgreementPricelistItemPage agentAgreementPricelistItemPage = (AgentAgreementPricelistItemPage) getCurrentPage();
        agentAgreementPricelistItemPage.assignContentTagToItem(itemNumber,tagToSelect);
    }

    @Then("^On Buyer Manage agreement page - I verify pricelist attached$")
    public void verifyAttachedPricelistName()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        manageAgreementPage.getPricelistName();
    }

    @Then("^On the Manage Agreement page - I verify message in popup$")
    public void verifyRemoveConformationMessage()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage)getCurrentPage();
        manageAgreementPage.verifyConfirmationMessage();
    }
    @When ("^On Buyer Manage Agreement price list page - I click on done$")
    public void clickOnDone()
    {
        AgentAgreementPricelistItemPage agentAgreementPricelistItemPage = (AgentAgreementPricelistItemPage) getCurrentPage();
        setCurrentPage(agentAgreementPricelistItemPage.clickDone());
    }

    @And("^On the Manage Agreement page - I click delete in modal popup$")
    public void clickOnDeleteInPopUP()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage)getCurrentPage();
        manageAgreementPage.clickOnDeleteButton();
    }

    @And("^On Upload Agent agreement page - I select upload type as '([^\"]*)'$")
    public void selectAgentAgreementUploadType(String value)
    {
        UploadAgentItemsPage uploadAgentItemsPage = (UploadAgentItemsPage) getCurrentPage();
        uploadAgentItemsPage.selectUploadType(value);
    }

    @Then("^On Manage Agreement page - I verify items are uploaded$")
    public void verifyAgentItemsUploaded()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage)getCurrentPage();
        manageAgreementPage.verifyUploadedAgentItems();
    }

    @Then("^On Manage Agreement page - I delete new agreement$")
    public void delteNewlyCreatedAgreement()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage)getCurrentPage();
        manageAgreementPage.deleteAgreement();
    }

    @And("^On Upload Agent agreement page - I click on back button$")
    public void clickOnBackButton()
    {
        UploadAgentItemsPage uploadAgentItemsPage = (UploadAgentItemsPage) getCurrentPage();
        setCurrentPage(uploadAgentItemsPage.clickOnBack());
    }

    @And("^On the Agent Agreement Item page - I click on '([^\"]*)' button$")
    public void clickButtonOnAgentAgreementItemPage(String button)
    {
        AgentAgreementItemsPage agentAgreementItemsPage = (AgentAgreementItemsPage)getCurrentPage();
        switch (button)
        {
            case "create":
                setCurrentPage(agentAgreementItemsPage.clickOnCreateButton());
                break;
            case "done":
                setCurrentPage(agentAgreementItemsPage.clickOnDoneButton());
                break;

        }

    }

//    @Then("^On the Agent Agreement create item page - I enter '([^\"]*)' plus SessionGUID into '([^\"]*)'$")
//    public void enterAgentSupplierId(String value,String elementName) throws Exception {
//        String sessionGUID = getCurrentPage().getSessionID();
//        String valueNew = value + sessionGUID;
//        props.set("SupID",valueNew);
//        enterItemDeatilsForAgentItem(valueNew,elementName);
//    }

//    @Then("^On the Agent Agreement create item page - I enter '([^\"]*)' into '([^\"]*)'$")
//    public void enterItemDeatilsForAgentItem(String value, String elementName) throws Exception {
//        AgentAgreementCreateItemPage agentAgreementCreateItemPage = (AgentAgreementCreateItemPage) getCurrentPage();
//        agentAgreementCreateItemPage.enterValueIntoElement(value,elementName);
//    }

//    @And("^On the Agent Agreement Create item page - I click on '([^\"]*)'$")
//     public void clickOnCogForAgentItem(String button)
//    {
//        AgentAgreementCreateItemPage agentAgreementCreateItemPage = (AgentAgreementCreateItemPage) getCurrentPage();
//        setCurrentPage(agentAgreementCreateItemPage.clickOnButtonInAgentItemPage(button));
//    }

//    @Then("^On the Agent Agreement Create item page - I verify agent item is added successfully$")
//    public void verifyAgentItemAddedSuccessfully()
//    {
//        AgentAgreementEditItemPage agentAgreementEditItemPage = (AgentAgreementEditItemPage) getCurrentPage();
//        agentAgreementEditItemPage.verifySuccessAlert();
//    }

    @Then("^On the Agreement Items Edit page - I click on '([^\"]*)'")
    public void goBackToPricelist(String button)
    {
        AgreementItemsEditPage agreementItemsEditPage = (AgreementItemsEditPage) getCurrentPage();

        switch (button) {
            case "Back To Agreement Price List Items":
                setCurrentPage(agreementItemsEditPage.navigateBackToPricelistItems());
                break;
            default: throw new RuntimeException("No case statement matching: " + button);
        }
    }

    @When("^On the Manage Agreement page - I enable stock$")
    public void enableStock()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        manageAgreementPage.enableAgentStock();
    }

    @Then("^On the Manage Agreement page - I click on import stock button$")
    public void importStock()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        setCurrentPage(manageAgreementPage.clickOnImportStock());
    }

    @Then("^On the Agreement Items create item page - I select recently created templated item$")
    public void selectTemplatedItem() throws Exception {
        AgreementItemCreateItemPage agreementItemCreateItemPage = (AgreementItemCreateItemPage) getCurrentPage();
        agreementItemCreateItemPage.selectTemplateForAnItem();
    }

    @Then("^On the Agent Agreement create item page - I enter template data$")
    public void enterTemplateDetails() throws Exception
    {
        AgreementItemCreateItemPage agreementItemCreateItemPage = (AgreementItemCreateItemPage) getCurrentPage();
        agreementItemCreateItemPage.enterTemplateData("Automation variable name","Automation variable value");
    }

    @Then("^On the Manage Agreement page - I enter supplier details$")
     public void enterSupplierDetails() throws Exception {
         ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
         manageAgreementPage.enterAgentAgreementSupplierDetails();
     }

    @Then("^On the Manage Agreement page - I verify if there are any old tags there$")
    public void verifyExistingContentTags()
    {
        ManageAgreementPage manageAgreementPage = (ManageAgreementPage) getCurrentPage();
        if(manageAgreementPage.elementIsDisplayed("removeFirstTag")) {
            setCurrentPage(manageAgreementPage.clickOnReviewPricelistCog());
            AgentAgreementPricelistItemPage agentAgreementPricelistItemPage = (AgentAgreementPricelistItemPage) getCurrentPage();
            agentAgreementPricelistItemPage.assignContentTagToItem(1, "None");
            agentAgreementPricelistItemPage.assignContentTagToItem(2, "None");
            setCurrentPage(agentAgreementPricelistItemPage.clickDone());
            manageAgreementPage.removeContentTag();
            manageAgreementPage.clickOnDeleteButton();
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }

}
