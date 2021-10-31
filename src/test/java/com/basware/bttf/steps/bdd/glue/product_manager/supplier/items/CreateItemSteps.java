package com.basware.bttf.steps.bdd.glue.product_manager.supplier.items;
// Created by Julian Sheppard on 21/06/2017

import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.product_manager.supplier.items.EditItemPage;
import com.basware.bttf.pages.product_manager.supplier.items.SelectMediaPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.pages.AbstractPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class CreateItemSteps extends AbstractSteps {

    @Then("^On the Create Item page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed(String elementName, String isOrIsNot) throws Exception {
        LOGGER.debug("Create Item Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n");
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        if (isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", createItemPage.elementIsDisplayed(elementName));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", createItemPage.elementIsNotDisplayed(elementName));
    }

    @Then("On the Create Item page - I check that '([^\"']*)' is displayed in '([^\"']*)'$")
    public void on_the_Create_Item_page_I_check_that_is_displayed_in(String element,String listOfElements) throws Exception {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        setCurrentPage(createItemPage.checkElement(element,listOfElements));
    }

    @Then("^On the Create Item page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs(String elementName, String expectedValue) throws Throwable {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        String actualValue = createItemPage.getElementValue(elementName);
        LOGGER.debug("Create Item Page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals("Unexpected value", expectedValue, actualValue);
    }

    @When("On the Create Item page - I click on the '([^\"']*)' Checkbox")
    public void clickCheckbox(String checkBoxValue) throws Exception {
        CreateItemPage createItemPage = (CreateItemPage)getCurrentPage();
        createItemPage.clickCheckBox(checkBoxValue);
    }

    @Then("On the Create Item page - I check that '([^\"']*)' value is available$")
    public void checkAvailability(String elementName) throws Throwable {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        String actualValue = createItemPage.getElementValue(elementName).replaceAll("[^0-9]","");
        int actual = Integer.parseInt(actualValue);
        LOGGER.debug("Checking value with -- "+actual);
        LOGGER.debug("Create Item Page ... Checking value of" + elementName);
        assertNotEquals("Unexpected value",0, actual);

    }

    @When("On the Create Item page - I select '([^\"']*)'")
    public void selectContract(String contract) {
        CreateItemPage createItemPage = (CreateItemPage)getCurrentPage();
        createItemPage.selectContract(contract);
    }



    @Then("^On the Create Item page - I check that '([^\"']*)' value is '([^\"]*)' plus SessionGUID$")
    public void checkThatElementValueIsPlusGUID(String elementName, String expectedValue) throws Throwable {
        String sessionGUID = getCurrentPage().getSessionID();
        checkThatElementValueIs(elementName, expectedValue + sessionGUID);
    }

    @Then("^On the Create Item page - I click on '([^\"']*)' thumbnail$")
    public void clickOnAThumbnail( String thumbnailNumber ) throws Exception
    {
        LOGGER.debug( "On the Create Item page ... Click image " + thumbnailNumber + " thumbnail" + "\n" );
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        switch( thumbnailNumber )
        {
            case "First": createItemPage.clickThumbnail(0); break;
            case "Second": createItemPage.clickThumbnail(1); break;
            case "Third": createItemPage.clickThumbnail(2); break;
            case "Fourth": createItemPage.clickThumbnail(3); break;
            case "Fifth": createItemPage.clickThumbnail(4); break;
            case "Sixth": createItemPage.clickThumbnail(5); break;
            case "Seventh": createItemPage.clickThumbnail(6);break;
            case "Eighth": createItemPage.clickThumbnail(7);break;
            case "Nineth": createItemPage.clickThumbnail(8);break;
            case "Tenth":createItemPage.clickThumbnail(9);break;
            default: throw new RuntimeException("No case statement for image number: " + thumbnailNumber);
        }


    }

    @Then("^On the Create Item page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown(String dropdownOption, String dropdownName) throws Exception {
        LOGGER.debug("Create Item page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n");
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        createItemPage.generateSetUpRequest();
        switch (dropdownName) {
            case "Item type":
                createItemPage.selectItemType(dropdownOption);
                break;
            case "Delivery type":
                createItemPage.selectDeliveryType(dropdownOption);
                break;
            case "Delivery Basket Attribute":
                createItemPage.selectDeliveryBasketAttribute(dropdownOption);
                break;
            case "Item class":
                createItemPage.selectItemClass(dropdownOption);
                break;
            case "Environment friendly":
                createItemPage.selectEnvFriendly(dropdownOption);
                break;
            case "Hazardous item":
                createItemPage.selectHazardous(dropdownOption);
                break;
            case "Comparison UOM":
                createItemPage.selectComparisonUOM(dropdownOption);
                break;
            case "Claimant engagement":
                createItemPage.selectClaimantEngagement(dropdownOption);
                break;
            case "Minimum number of claimants":
                createItemPage.selectMinNumClaimants(dropdownOption);
                break;
            case "Lead time":
                createItemPage.selectLeadTime(dropdownOption);
                break;
            default:
                createItemPage.selectLevelDropdownOptionByText( dropdownName, dropdownOption );
//                throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @Then("^On the Create Item page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement(String value, String elementName) throws Throwable {
        LOGGER.debug("Create Item Page ... Enter value " + value + " into element " + elementName + "\n");
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        if(value.contains("SetUpRequest")){
            value = createItemPage.generateSetUpRequest();
            LOGGER.debug("Entering Setup request..");
        }
        createItemPage.enterValueIntoElement(value, elementName);
    }

    @When("On the Create Item page - I click on '([^\"]*)' button")
    public void clickSavebutton(String element) throws Throwable {
        CreateItemPage createItemPage = (CreateItemPage)getCurrentPage();
        switch (element){
            case "Save":
                setCurrentPage(createItemPage.clickSaveButton());
                break;
            case "SavePunchoutItem":
                setCurrentPage(createItemPage.savePunchOutItem());
                break;
            case "Select":
                setCurrentPage(createItemPage.clickSelect());
                break;
            case "Use":
                 createItemPage.clickButton(element);
                  break;
            case "Edit":
                  createItemPage.clickButton(element);
                  break;
            case "Done":
                  createItemPage.clickDoneBtn();
                  break;
            default:
                createItemPage.clickPageReloadingElement(element);
                break;
        }
    }

    @Then("On the Edit Item page - I verify '([^\"]*)' in alert message")
    public void verifyMsg(String msg) throws Throwable{
        EditItemPage editItemPage = (EditItemPage)getCurrentPage();
        editItemPage.verifyAlertMsg(msg);
    }


    @Then("^On the Create Item page - I enter '([^\"]*)' plus SessionGUID into '([^\"']*)'$")
    public void enterValuePlusGUIDIntoElement(String value, String elementName) throws Throwable {
        String sessionGUID = getCurrentPage().getSessionID();
        String valueNew = value + sessionGUID;
//        if(value.contains("CATFISH-ITEM2-Eclass"))
//            props.set("SupIDEclass",valueNew);
        props.set("SupID",valueNew);
        enterValueIntoElement(valueNew, elementName);
    }

    @Then("^On the Create Item page - I click on the '([^\"']*)' button$")
    public void clickButton(String buttonName) throws Exception {
        LOGGER.debug("Create Item Page ... Click " + buttonName + " button" + "\n");
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        switch (buttonName) {
            case "Cancel":
                setCurrentPage(createItemPage.clickCancelButton());
                break;
            case "Save":
                setCurrentPage(createItemPage.clickSaveButton());
                break;
            case "Select Image":
                setCurrentPage(createItemPage.clickSelectImageButton());
                break;
            case "Add Classification":
                setCurrentPage(createItemPage.clickClassificationButton());
                break;
            case "Add Classification Eclass":
                setCurrentPage(createItemPage.clickClassificationButtonEclass());
                break;
            case "Add Linked Media":
                setCurrentPage(createItemPage.clickAddLinkedMediaButton());
                break;
            case "Remove First Linked Media":
                createItemPage.clickButton("FirstLinkedMediaRemoveButton");
                break;
            case "Image 0 Remove":
                createItemPage.clickButton("Image0RemoveButton");
                break;
            case "Done":
                buttonName="DoneClassificationBtn";
                setCurrentPage(createItemPage.clickButton( buttonName ));
                break;
            case "DoneEclass":
                buttonName = "DoneClassificationBtnEclass";
                setCurrentPage(createItemPage.clickButton( buttonName ));
                break;
            case "Add Classification Type Eclass":
                createItemPage.addClassificationTypeEclass();
                break;
            case "Add Classification Type":
                createItemPage.addClassificationType();
                break;
            case "Delete UNPSC":
                createItemPage.deleteUNPSCClassification();
                break;
            default:
                setCurrentPage(createItemPage.clickPageReloadingElement(buttonName));
        }
    }

    @And("^On the Create Item page - I click on the 'Save' button to verify mandatory fields$")
    public void clickSaveBtnToVerifyMandatoryFields() throws Throwable
    {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        setCurrentPage(createItemPage.clickSaveToVerify());
    }

    @And("^On the Create Item page - I verify error message thrown$")
    public void verifyErrorMessage()
    {
        CreateItemPage createItemPage = (CreateItemPage)getCurrentPage();
        createItemPage.verifyErrorMessage();
    }

    @Then("^On the Create Item page - I check that '([^\"']*)' is a mandatory field$")
    public void verifyMandatoryFields(String field) throws Throwable {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        setCurrentPage(createItemPage.verifyFields(field));

    }

    @When("^On the Create Item page - I click on plus button$")
    public void clickPlusButton() throws Throwable {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        setCurrentPage(createItemPage.addItemTemplate());
    }

    @Then("^On the Create Item page - I check that '([^\"']*)' is displayed under '([^\"']*)' for '([^\"']*)'$")
    public void on_the_Create_Item_page_I_check_that_X_ray_laboratory_services_is_displayed_under_V(String classification, String value, String service) throws Throwable {
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        setCurrentPage(createItemPage.verifyClassification(classification, value, service));

    }

    @When("^On the Create Item page - I search '([^\"]*)'$")
    public void searchItemTemplate(String itemTemplate) throws Throwable {
        LOGGER.debug("On Create Item Page - Searching Item Template ..");
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        setCurrentPage(createItemPage.searchItemTemplate(itemTemplate));
    }

    @When("^On the Create Item page - I add the item template$")
    public void addTemplate() throws Throwable {
        LOGGER.debug("On the Create Item page - Adding Item Template from Pop up..");
        CreateItemPage createItemPage = (CreateItemPage)getCurrentPage();
        setCurrentPage(createItemPage.addTemplate());
    }

    @Then("^On the Create item page - I verify '([^\"']*)' image$")
    public void verifyPreviewImages(String thumbnailNumber) throws Exception {
        LOGGER.debug("Checking Media Page ... " + thumbnailNumber + " thumbnail" + "\n");
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        switch (thumbnailNumber) {
            case "First":
                createItemPage.verifyImage(0);
                break;
            case "Second":
                createItemPage.verifyImage(1);
                break;
            case "Third":
                createItemPage.verifyImage(2);
                break;
            case "Fourth":
                createItemPage.verifyImage(3);
                break;
            case "Fifth":
                createItemPage.verifyImage(4);
                break;
            case "Sixth":
                createItemPage.verifyImage(5);
                break;
            case "Seventh":
                createItemPage.verifyImage(6);
                break;
            case "Eighth":
                createItemPage.verifyImage(7);
                break;
            case "Nineth":
                createItemPage.verifyImage(8);
                break;
            case "Tenth":
                createItemPage.verifyImage(9);
                break;
            default:
                throw new RuntimeException("No case statement for image number: " + thumbnailNumber);
        }
    }
        @And("^On the Create Item page - I click on '([^\"']*)' arrow$")
        public void clickOnArror(String direction) throws Exception
        {
            CreateItemPage createItemPage = (CreateItemPage)getCurrentPage();
            setCurrentPage(createItemPage.clickArrow(direction));

        }

    @And("^On the Create Item page - I delete '([^\"']*)'$")
    public void deleteElements( String element ) throws Exception
    {
        LOGGER.debug( "Select Media page ... Deleting  : " + element  + "\n" );
        CreateItemPage createItemPage = (CreateItemPage) getCurrentPage();
        createItemPage.delete_elem( element);
    }


}