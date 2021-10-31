package com.basware.bttf.steps.bdd.glue.product_manager.supplier.items;
// Created by Julian Sheppard on 21/06/2017

import com.basware.bttf.pages.product_manager.supplier.items.EditItemPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditItemSteps extends AbstractSteps
{
    @Then("^On the Edit Item page - I check that '([^\"']*)' '(is|is not)' displayed$")
    public void checkThatElementIsDisplayed( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Edit Item Page ... Check " + elementName + " " + isOrIsNot + " displayed" + "\n" );
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        if(isOrIsNot.equals("is"))
            assertTrue("Element is unexpectedly not displayed", editItemPage.elementIsDisplayed( elementName ));
        else
            assertTrue("Element is unexpectedly displayed", editItemPage.elementIsNotDisplayed( elementName ));
    }

    @Then("^On the Edit Item page - I check that '([^\"']*)' '(is|is not)' enabled$")
    public void checkThatElementIsEnabled( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Edit Item Page ... Check " + elementName + " " + isOrIsNot + " enabled" + "\n" );
        EditItemPage editItemPage = (EditItemPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be clickable
            assertTrue(elementName + " element is unexpectedly not enabled", editItemPage.elementIsEnabled( elementName ));
        else                                // if expecting the element not to be clickable
            assertTrue(elementName + " element is unexpectedly enabled", !editItemPage.elementIsEnabled( elementName ));
    }

    @Then("^On the Edit Item page - I check that '([^\"']*)' '(is|is not)' readonly")
    public void checkThatElementIsReadOnly( String elementName, String isOrIsNot ) throws Throwable
    {
        LOGGER.debug( "Edit Item Page ... Check " + elementName + " " + isOrIsNot + " readonly" + "\n" );
        EditItemPage editItemPage = (EditItemPage)getCurrentPage();
        if(isOrIsNot.equals("is"))          // if expecting the element to be readonly
            assertTrue(elementName + " element is unexpectedly not enabled", editItemPage.elementIsReadOnly( elementName ));
        else                                // if expecting the element not to be readonly
            assertTrue(elementName + " element is unexpectedly enabled", !editItemPage.elementIsReadOnly( elementName ));
    }

    @Then ("^On the Edit Item page - I check that '([^\"']*)' value is '([^\"]*)'$")
    public void checkThatElementValueIs( String elementName, String expectedValue ) throws Throwable
    {
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        String actualValue = editItemPage.getElementValue( elementName );
        LOGGER.debug( "Edit Item page ... Comparing " + elementName + ": Expected:[" + expectedValue + "] Actual:[" + actualValue + "]" + "\n");
        assertEquals( expectedValue, actualValue );
    }


    @Then("On the Edit Item page - I check that '([^\"']*)' is displayed in '([^\"']*)'$")
    public void on_the_Create_Item_page_I_check_that_is_displayed_in(String element,String listOfElements) throws Exception {
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        setCurrentPage(editItemPage.checkElement(element,listOfElements));
    }

    @Then("^On the Edit Item page - I check that '([^\"']*)' is displayed under '([^\"']*)' for '([^\"']*)'$")
    public void checkIfDisplayed(String classification, String value, String service) throws Throwable {
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        setCurrentPage(editItemPage.verifyClassification(classification, value, service));

    }

    @Then ("^On the Edit Item page - I check that '([^\"']*)' value is '([^\"]*)' plus SessionGUID$")
    public void checkThatElementValueIsPlusGUID( String elementName, String expectedValue ) throws Throwable
    {
        String sessionGUID = getCurrentPage().getSessionID();
        checkThatElementValueIs( elementName, expectedValue + sessionGUID );
    }

    @Then("^On the Edit Item page - I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "Edit Item page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        EditItemPage editItemPage = (EditItemPage)getCurrentPage();
        switch( dropdownName )
        {
            case "Item type": editItemPage.selectItemType( dropdownOption ); break;
            case "Delivery type": editItemPage.selectDeliveryType( dropdownOption ); break;
            case "Delivery Basket Attribute": editItemPage.selectDeliveryBasketAttribute( dropdownOption ); break;
            case "Item class": editItemPage.selectItemClass( dropdownOption ); break;
            case "Environment friendly": editItemPage.selectEnvFriendly( dropdownOption ); break;
            case "Hazardous item": editItemPage.selectHazardous( dropdownOption ); break;
            case "Comparison UOM": editItemPage.selectComparisonUOM( dropdownOption ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }

    @Then ("^On the Edit Item page - I enter '([^\"]*)' into '([^\"']*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Edit Item Page ... Enter value " + value + " into element " + elementName + "\n" );
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        editItemPage.enterValueIntoElement( value, elementName);
    }

    @When("^On the Edit Item page - I search '([^\"]*)'$")
    public void searchItemTemplate(String itemTemplate) throws Throwable {
        LOGGER.debug("On Edit Item Page - I search - "+itemTemplate);
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        setCurrentPage(editItemPage.searchItemTemplate(itemTemplate));
    }

    @When("^On the Edit Item page - I add the item template for Edit Item page$")
    public void addTemplateforEditItem() throws Throwable {
        LOGGER.debug("On Edit Item Page - I am adding Item Template");
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        setCurrentPage(editItemPage.addTemplateEditItem());
    }


    @Then("^On the Edit Item page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception
    {
        LOGGER.debug( "Edit Item Page ... Click " + buttonName + " button" + "\n" );
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        switch( buttonName )
        {
            case "HeaderAlertMessageClose": editItemPage.clickButton( buttonName ); break;
            case "Delete": setCurrentPage( editItemPage.clickDeleteButton() ); break;
            case "Cancel": setCurrentPage( editItemPage.clickCancelButton() ); break;
            case "Copy": setCurrentPage( editItemPage.clickCopyButton() ); break;
            case "Save": setCurrentPage( editItemPage.clickSaveButton() ); break;
            case "Select Image": setCurrentPage( editItemPage.clickSelectImageButton() ); break;
//            case "addTemplate": setCurrentPage( editItemPage.clickAddTemplate() ); break;
            case "Add Classification": setCurrentPage( editItemPage.clickClassificationButton() ); break;
            case "Add Linked Media": setCurrentPage( editItemPage.clickAddLinkedMediaButton() ); break;
            case "Remove First Linked Media": editItemPage.clickButton( "FirstLinkedMediaRemoveButton" ); break;
            case "Image 0 Remove": editItemPage.clickButton( "Image0RemoveButton" ); break;
            case "ModalClosePreviewIcon": editItemPage.clickButton( "ModalClosePreviewIcon" ); break;
            case "ModalClosePreview": editItemPage.clickButton( "ModalClosePreview" ); break;
            case "Manage Template": setCurrentPage(editItemPage.clickManageTempDataBtns("ManageTemplate")); break;
            case "Manage Template Data":setCurrentPage(editItemPage.clickManageTempDataBtns("ManageTemplateData"));break;
            // default for those elements that cause page re-load
            default: setCurrentPage( editItemPage.clickPageReloadingElement( buttonName ) );
        }
    }

    @Then("^On the Edit Item page - I click on '([^\"']*)' thumbnail$")
    public void clickOnAThumbnail( String thumbnailNumber ) throws Exception {
        LOGGER.debug("Edit Item Page ... Click image " + thumbnailNumber + " thumbnail" + "\n");
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        switch (thumbnailNumber) {
            case "First":
                editItemPage.clickThumbnail(0);
                break;
            case "Second":
                editItemPage.clickThumbnail(1);
                break;
            case "Third":
                editItemPage.clickThumbnail(2);
                break;
            case "Fourth":
                editItemPage.clickThumbnail(3);
                break;
            case "Fifth":
                editItemPage.clickThumbnail(4);
                break;
            case "Sixth":
                editItemPage.clickThumbnail(5);
                break;
            case "Seventh":
                editItemPage.clickThumbnail(6);
                break;
            case "Eighth":
                editItemPage.clickThumbnail(7);
                break;
            case "Nineth":
                editItemPage.clickThumbnail(8);
                break;
            case "Tenth":
                editItemPage.clickThumbnail(9);
                break;
            default:
                throw new RuntimeException("No case statement for image number: " + thumbnailNumber);
        }
    }

    @Then("^On the Edit Item page - I remove any External Links$")
    public void RemoveAnyExternalLinks() throws Throwable
    {
        LOGGER.debug( "Edit Item Page ... Remove any External Links" + "\n" );
        EditItemPage editItemPage = (EditItemPage) getCurrentPage();
        editItemPage.removeAnyExternalLinks();
    }
}
