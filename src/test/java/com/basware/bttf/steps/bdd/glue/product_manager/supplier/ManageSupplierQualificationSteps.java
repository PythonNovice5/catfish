package com.basware.bttf.steps.bdd.glue.product_manager.supplier;

import com.basware.bttf.pages.product_manager.supplier.price_lists.ManageQualificationPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ManageSupplierQualificationSteps extends AbstractSteps {


    @And("^On Manage Qualification page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterIntoElement(String value, String elementName) throws Throwable {
        LOGGER.debug("On Manage Qualification Page ... Enter value " + value + " into element " + elementName + "\n");
        ManageQualificationPage manageQualificationPage = (ManageQualificationPage) getCurrentPage();
        switch (elementName){
            case "Contact Email":
                elementName="contactEmail";
                break;
        }
        manageQualificationPage.enterValueIntoElement(value, elementName);
    }

    @When("^On Manage Qualification page - I select '([^\"']*)' from '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown(String dropdownOption, String dropdownName) throws Exception {
        LOGGER.debug("Manage Qualification page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n");
        ManageQualificationPage manageQualificationPage = (ManageQualificationPage) getCurrentPage();
        switch (dropdownName) {
            case "Your Delivery Time in days?":
                dropdownName = "DeliveryTimeDropDown";
                break;
        }
        manageQualificationPage.selectDropDownOption(dropdownOption, dropdownName);
    }

    @When("On Manage Qualification page - I click on '([^\"']*)'")
    public void clickOn(String elem) throws Throwable {
        ManageQualificationPage manageQualificationPage = (ManageQualificationPage) getCurrentPage();
        LOGGER.debug("Manage Qualification Page ... Click On " + elem + "\n");
        setCurrentPage(manageQualificationPage.clickOnElement(elem));
    }
}