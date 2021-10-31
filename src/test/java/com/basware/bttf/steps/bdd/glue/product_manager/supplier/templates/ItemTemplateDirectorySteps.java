package com.basware.bttf.steps.bdd.glue.product_manager.supplier.templates;

import com.basware.bttf.pages.product_manager.supplier.templates.CreateItemTemplatePage;
import com.basware.bttf.pages.product_manager.supplier.templates.ItemTemplateDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ManageTemplateData;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by DuncanNash on 04/03/2017.
 */
public class ItemTemplateDirectorySteps extends AbstractSteps
{

    @Then("^I click on the Item Template Directory '([^\"']*)' button$")
    public void clickItemTemplateButton( String buttonName ) throws Exception
    {
        ItemTemplateDirectoryPage itemTemplateDirectoryPage = (ItemTemplateDirectoryPage) getCurrentPage();
        setCurrentPage( itemTemplateDirectoryPage.clickButton( buttonName ) );
        LOGGER.debug( "Item Template Directory Page ... Click on the " + buttonName +" button" + "\n" );
    }

    @When("On the Create Item Template page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterDetails(String value, String field) throws  Exception{
        CreateItemTemplatePage createItemTemplatePage = (CreateItemTemplatePage) getCurrentPage();

        setCurrentPage(createItemTemplatePage.enterValueIntoField(value,field));

    }

    @When("On the Create Item Template page - I click on '([^\"']*)' button for '([^\"']*)'")
    public void clickOn(String btnValue,String tool) throws Exception
    {
        CreateItemTemplatePage createItemTemplatePage = (CreateItemTemplatePage)getCurrentPage();
        LOGGER.debug("On Create Item Template Page I click on - " + btnValue);
        switch (btnValue){
            case "Plus":
                createItemTemplatePage.clickPlusButtonFor(tool);
                break;
            case "Save":
                setCurrentPage(createItemTemplatePage.clickSave(tool));
                break;
        }
    }

    @When("On the Manage Template Data page - I click on '([^\"']*)' button")
    public void clickManageTemButtons(String btnValue) throws Exception
    {
        ManageTemplateData manageTemplateData = (ManageTemplateData) getCurrentPage();
        LOGGER.debug("On Manage Template Data Page - I click on " + btnValue);
        switch (btnValue){
            case "Save":
                setCurrentPage(manageTemplateData.clickSaveBtn());
                break;
            case "SaveForEditItemTemplate":
                setCurrentPage(manageTemplateData.saveForEditItemTemplate());
                break;
        }
    }


    @When("On the Create Item Template page - I enter '([^\"']*)' into '([^\"']*)' for '([^\"']*)'$")
    public void enterValues(String value, String field, String tool) throws Exception
    {
        LOGGER.debug( "Create Item Template Page ... Enter value " + value + " into field " + field + "\n" );
        CreateItemTemplatePage createItemTemplatePage = (CreateItemTemplatePage)getCurrentPage();
        setCurrentPage(createItemTemplatePage.enterValueIntoField(value,field));
    }

    @When("On the Create Item Template page - I select '([^\"']*)' from '([^\"']*)' dropdown for '([^\"']*)'")
    public void on_the_Create_Item_Template_page_I_select_from_dropdown_for(String value, String dropdownName, String tool) throws Exception
    {
        LOGGER.debug( "Create Item Template page ... Selecting value " + value + " from dropdown " + dropdownName + "\n" );
        CreateItemTemplatePage createItemTemplatePage = (CreateItemTemplatePage)getCurrentPage();
        setCurrentPage(createItemTemplatePage.selectValueFromDropDown(value,dropdownName));
    }

    @When("On the Create Item Template page - I '([^\"']*)' the item template")
    public void enableOrDisable(String state) throws Exception
    {
        LOGGER.debug("Making the item template - " + state);
        CreateItemTemplatePage createItemTemplatePage = (CreateItemTemplatePage)getCurrentPage();
        createItemTemplatePage.enableOrDisable(state);
    }

    @When("On the Manage Template Data page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterValues(String value,String field) throws Exception
    {
        LOGGER.debug( "Manage Template Data page ... Enter value " + value + " into field " + field + "\n" );
        ManageTemplateData manageTemplateData = (ManageTemplateData) getCurrentPage();
        manageTemplateData.enterValueIntoElement(value,field);
    }

}
