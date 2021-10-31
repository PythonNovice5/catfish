package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageItemQuestionnairePage extends ProductManagerPage {

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/agreementItems/manageItemFilters/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Manage item questionnaire";
    }

    public ManageItemQuestionnairePage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text()='Text Input']")
    public WebElement inputText;

    @FindBy(xpath = "//*[text()='List (single-select)']")
    public WebElement listSingleSelect;

    @FindBy (id = "form-builder-drop-container")
    public WebElement QuestionnaireForm;

    @FindBy(xpath = "//span[contains(text(),'Text Input')]//..//..//*[contains(@id,'edit-component')]")
    public WebElement editTextInput;

    @FindBy(xpath = "//span[contains(text(),'List (single-select)')]//..//..//*[contains(@id,'edit-component')]")
    public WebElement editListSingleSelect;

    @FindBy(xpath ="//div[@class='modal-dialog-title mat-dialog-title' and contains(text(),'Edit component')]")
    public WebElement EditComponentModalWindow;

    @FindBy(xpath = "//*[contains(text(),'Label text')]//..//input")
    public WebElement labelTextInput;

    @FindBy(xpath = "//*[@name='Required Field']//..")
    public WebElement requiredFieldCheckBox;

        @FindBy(xpath = "//*[@title='Filterable Field']")
    public WebElement filterableFieldCheckBox;

    @FindBy(xpath = "//td[contains(text(),'Select Options')]//..//*[@id='option--0']")
    public WebElement firstOptionValue;

    @FindBy(xpath = "//td[contains(text(),'Select Options')]//..//*[@id='option--1']")
    public WebElement secondOptionValue;

    @FindBy(xpath = "//a[text()=' Agreement Price List Items ']")
    public WebElement BackToAggrmntPriceListItems;

    @FindBy(id="add-option-")
    public WebElement addOptionButton;

    @FindBy(id="update-btn")
    public WebElement updateComponent;

    @FindBy(id="approve-0")
    public WebElement firstOptionAutoApprove;

    @FindBy(id="approve-1")
    public WebElement secondOptionAutoApprove;

    @FindBy(id="cancel-btn")
    public WebElement cancelBtn;

    @FindBy(id="approval-type")
    public WebElement ApprovalTypeDropDown;

    @FindBy(xpath="//button[contains(text(),'Save')]")
    public WebElement SaveButton;

    @FindBy(xpath = "//a[contains(text(),'Done')]")
    public WebElement DoneBtn;

    public ManageItemQuestionnairePage drag_component(String component) throws Exception{

        switch (component){
            case "Input Text":
                component="inputText";
                break;
            case "List (single-select)":
                component="listSingleSelect";
                break;
        }

        waitUntilDisplayed(QuestionnaireForm);
        waitUntilDisplayed(getWebElementNamed(component));
        scrollToElement(getWebElementNamed(component));
        dragAndDrop(getWebElementNamed(component),QuestionnaireForm);
        return new ManageItemQuestionnairePage();
    }

    public ManageItemQuestionnairePage clickEditComponent(String componentName){

        switch (componentName){
            case "Input Text":
                waitUntillElementIsClickableAndClick(editTextInput);
                break;
            case "List (single-select)":
                waitUntillElementIsClickableAndClick(editListSingleSelect);
        }

        return new ManageItemQuestionnairePage();
    }

    public ProductManagerPage clickOnElement(String elem){

        switch(elem){
            case "Required Field CheckBox":
                waitUntillElementIsClickableAndClick(requiredFieldCheckBox);
                return new ManageItemQuestionnairePage();
            case "Add Option":
                waitUntillElementIsClickableAndClick(addOptionButton);
                return new ManageItemQuestionnairePage();
            case "First Option Value":
                waitUntillElementIsClickableAndClick(firstOptionAutoApprove);
                return new ManageItemQuestionnairePage();
            case "Update":
                waitUntillElementIsClickableAndClick(updateComponent);
                waitUntilNoModalPopup();
                return new ManageItemQuestionnairePage();
            case "Save":
                waitUntillElementIsClickableAndClick(SaveButton);
                return new ManageItemQuestionnairePage();
            case "Done":
                waitUntillElementIsClickableAndClick(DoneBtn);
                return  new AgreementPricelistItemPage();
            case "Filterable Field":
                waitUntillElementIsClickableAndClick(filterableFieldCheckBox);
                return new ManageItemQuestionnairePage();
            case "Agreement Price List Items bread crumb":
                waitUntillElementIsClickableAndClick(BackToAggrmntPriceListItems);
                return new AgreementPricelistItemPage();
        }
        return null;
    }

}
