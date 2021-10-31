package com.basware.bttf.steps.bdd.glue.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.buyer.agreements.ManageItemQuestionnairePage;
import com.basware.bttf.pages.product_manager.buyer.agreements.ManageQualificationQuestionnairePage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class QuestionnaireSteps extends AbstractSteps {


    @When("On Manage Qualificaiton Questionnaire Page - I drag '([^\"']*)' component into Form")
    public void dragComponentIntoForm(String componentName) throws Throwable {
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Qualificaiton Questionnaire Page ... Drag Component " + componentName + " into Form " + "\n");
        manageQualificationQuestionnairePage.drag_component(componentName);
    }

    @When("On Manage Item Questionnaire Page - I drag '([^\"']*)' component into Form")
    public void dragThisComponent(String componentName) throws Throwable {
        ManageItemQuestionnairePage manageItemQuestionnairePage = (ManageItemQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Item Questionnaire Page ... Drag Component " + componentName + " into Form " + "\n");
        manageItemQuestionnairePage.drag_component(componentName);
    }

    @When("On Manage Qualificaiton Questionnaire Page - I click on  Edit Component of '([^\"']*)'")
    public void clickOn(String componentName) throws Throwable {
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Qualificaiton Questionnaire Page ... Click On " + "Edit Component" + " Of " + componentName + "\n");
        manageQualificationQuestionnairePage.clickEditComponent(componentName);
    }

    @When("On Manage Item Questionnaire Page - I click on  Edit Component of '([^\"']*)'")
    public void clickOnThisElem(String componentName) throws Throwable {
        ManageItemQuestionnairePage manageItemQuestionnairePage = (ManageItemQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Item Questionnaire Page ... Click On " + "Edit Component" + " Of " + componentName + "\n");
        manageItemQuestionnairePage.clickEditComponent(componentName);
    }

    @Then("^On Manage Qualificaiton Questionnaire Page - I check that '([^\"']*)' modal window '([^\"']*)' displayed$")
    public void checkThatElementIsDisplayed(String elementName, String isOrIsNot) throws Exception {
        LOGGER.debug("On Manage Qualificaiton Questionnaire Page - I check that " + elementName + " " + isOrIsNot + " displayed" + "\n");
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        switch (elementName) {
            case "Edit Component":
                elementName = "EditComponentModalWindow";
                break;
        }
        if (isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", manageQualificationQuestionnairePage.elementIsDisplayed(elementName));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", manageQualificationQuestionnairePage.elementIsNotDisplayed(elementName));
    }

    @Then("^On Manage Item Questionnaire Page - I check that '([^\"']*)' modal window '([^\"']*)' displayed$")
    public void checkIfElementIsDisplayed(String elementName, String isOrIsNot) throws Exception {
        LOGGER.debug("On Manage Item Questionnaire Page - I check that " + elementName + " " + isOrIsNot + " displayed" + "\n");
        ManageItemQuestionnairePage manageItemQuestionnairePage = (ManageItemQuestionnairePage) getCurrentPage();
        switch (elementName) {
            case "Edit Component":
                elementName = "EditComponentModalWindow";
                break;
        }
        if (isOrIsNot.equals("is"))          // if expecting the element to be displayed
            assertTrue(elementName + " element is unexpectedly not displayed", manageItemQuestionnairePage.elementIsDisplayed(elementName));
        else                                // if expecting the element not to be displayed
            assertTrue(elementName + " element is unexpectedly displayed", manageItemQuestionnairePage.elementIsNotDisplayed(elementName));
    }
    @Then("^On Manage Qualificaiton Questionnaire Page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterIntoElement(String value, String elementName) throws Throwable {
        LOGGER.debug("On Manage Qualificaiton Questionnaire Page ... Enter value " + value + " into element " + elementName + "\n");
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        manageQualificationQuestionnairePage.enterValueIntoElement(value, elementName);
    }

    @Then("^On Manage Item Questionnaire Page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterIntoThisElement(String value, String elementName) throws Throwable {
        LOGGER.debug("On Manage Item Questionnaire Page ... Enter value " + value + " into element " + elementName + "\n");
        ManageItemQuestionnairePage manageItemQuestionnairePage = (ManageItemQuestionnairePage) getCurrentPage();
        manageItemQuestionnairePage.enterValueIntoElement(value, elementName);
    }


    @When("On Manage Qualificaiton Questionnaire Page - I click on '([^\"']*)'")
    public void clickOnElem(String elem) throws Throwable {
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Qualificaiton Questionnaire Page ... Click On " + elem + "\n");
        setCurrentPage(manageQualificationQuestionnairePage.clickOnElement(elem));
    }

    @When("On Manage Item Questionnaire Page - I click on '([^\"']*)'")
    public void clickOnItemElem(String elem) throws Throwable {
        ManageItemQuestionnairePage manageItemQuestionnairePage = (ManageItemQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Item Questionnaire Page ... Click On " + elem + "\n");
        setCurrentPage(manageItemQuestionnairePage.clickOnElement(elem));
    }


    @When("On Manage Qualificaiton Questionnaire Page - I select '([^\"']*)' for autoapproval")
    public void selectForAutoApproval(String option) throws Throwable {
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        LOGGER.debug("Manage Qualificaiton Questionnaire Page ... Select " + option + " for auto approval" + "\n");
        manageQualificationQuestionnairePage.clickOnElement(option);
    }

    @And("On Manage Qualificaiton Questionnaire Page - I select '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown(String dropdownOption, String dropdownName) throws Exception {
        LOGGER.debug("On Manage Qualificaiton Questionnaire Page  ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n");
        ManageQualificationQuestionnairePage manageQualificationQuestionnairePage = (ManageQualificationQuestionnairePage) getCurrentPage();
        switch (dropdownName) {
            case "Approval":
                dropdownName = "ApprovalTypeDropDown";
                break;
        }
        manageQualificationQuestionnairePage.selectDropDownOption(dropdownOption, dropdownName);
    }
}
