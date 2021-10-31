package com.basware.bttf.pages.product_manager.Loader;

import com.basware.bttf.util.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.basware.bttf.util.TestConstants.AUTOMATION_NAME;

public class ContentLoaderAutomationPage extends TwoStageLoaderDashboardPage {

    @FindBy(id="btn_createMapping")
    public WebElement createAutomationButton;

    @FindBy(id="txt_name")
    public WebElement automationName;

    @FindBy(id="chk_enabled")
    public WebElement enableCheckBox;

    @FindBy(id="drp_automationType")
    public WebElement automationTypeDropDown;

    @FindBy(id="txt_location")
    public WebElement automationLocation;

    @FindBy(id="drp_dataMapping")
    public WebElement dataMappingDropdown;

    @FindBy(id = "drp_outputType")
    public WebElement outPutTypeDropDown;

    @FindBy(id="drp_dataMapping_0")
    public WebElement languageDropDown;

    @FindBy(id= "drp_dataMapping_1" )
    public WebElement unspscDropDown;

    @FindBy(id= "drp_dataMapping_2")
    public WebElement currencyDropDown;

    @FindBy(id="chk_autoCommit")
    public WebElement autoCommitCheckBox;

    @FindBy(id ="chk_autoCreate")
    public WebElement autoCreateCheckBox;

    @FindBy(id="chk_autoPublish")
    public WebElement autoPublishCheckBox;

    @FindBy(id="txt_createEmail")
    public WebElement createEmailAddress;

    @FindBy(id="txt_errorEmail")
    public WebElement errorEmailAddress;

    @FindBy(id="txt_updateEmail")
    public WebElement updateEmailAddress;

    @FindBy(id = "btn_submit")
    public WebElement createButton;

    @FindBy(id = "lnk_recordName")
    public WebElement automationRecordName;

    @FindBy(id="app-dialog-confirm")
    public WebElement confirmDeleteAutomation;

    public ContentLoaderAutomationPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/loader/automation";
    }

    @Override
    public String getExpectedTitle() {
        return "Content Loader: Automation";
    }

    public void clickOnCreateButton()
    {
        pauseFor(500);
        if(driver.findElements(By.xpath("//*[contains(@id,'automationRecord_')]")).size()!=0) {
            WebElement deleteRecord = driver.findElement(By.id("delete-automation-mapping"));
            deleteRecord.click();
            pauseFor(500);
            confirmDeleteAutomation.click();
        }
        waitUntillElementIsClickableAndClick(createAutomationButton);
    }

    public void enterAutomationDetails(String field, String value) throws Exception
    {
        switch(field)
        {
            case "Name":
                String newAutomationName = value + getSessionID();
//                automationName.sendKeys(newAutomationName);
                enterValueIntoElement(newAutomationName,"automationName");
                props.set(TestConstants.AUTOMATION_NAME,newAutomationName);
                break;
            case "Enabled":
                waitUntillElementIsClickableAndClick(enableCheckBox);
//               enableCheckBox.click();
                break;
            case "Automation Type":
                selectDropdownOption(automationTypeDropDown,value);
                break;
            case "Location":
                enterValueIntoElement(value,"automationLocation");
                automationLocation.sendKeys(value);
                break;
            case "Data Mappings":
                selectDropdownOption(dataMappingDropdown,value);
                break;
            case "Output Type":
                pauseFor(1000);
                selectDropdownOption(outPutTypeDropDown,value);
                break;
            case "Language":
                selectDropdownOption(languageDropDown,value);
                break;
            case "UNSPSC Version":
                selectDropdownOption(unspscDropDown,value);
                break;
            case "Currency":
                selectDropdownOption(currencyDropDown,value);
                break;
            case "Auto Commit":
                waitUntillElementIsClickableAndClick(autoCommitCheckBox);
//                autoCommitCheckBox.click();
                break;
            case "Auto Create":
                waitUntillElementIsClickableAndClick(autoCreateCheckBox);
                break;
            case "Auto Publish":
                waitUntillElementIsClickableAndClick(autoPublishCheckBox);
                break;
            case "Create Email":
                enterValueIntoElement(value,"createEmailAddress");
//                createEmailAddress.sendKeys(value);
                break;
            case "Error Email":
                enterValueIntoElement(value,"errorEmailAddress");
//                errorEmailAddress.sendKeys(value);
                break;
            case "Update Email":
                enterValueIntoElement(value,"updateEmailAddress");
//                updateEmailAddress.sendKeys(value);
                break;
        }
    }

    public void createAutomation()
    {
        createButton.click();
        pauseFor(2000);
    }

    public void verifyAutomationCreated()
    {
        String newAutomationName = props.get(TestConstants.AUTOMATION_NAME);
        WebElement newAutomation = driver.findElement(By.xpath("//*[@title=\""+newAutomationName+"\"]"));
        newAutomation.isDisplayed();
    }

    public void deleteNewAutomationRecord()
    {
        String newAutomationName = props.get(TestConstants.AUTOMATION_NAME);
        WebElement deleteButtonForRecord = driver.findElement(By.xpath("//*[@title=\""+newAutomationName+"\"]/div/div[1]//..//*[@id=\"delete-automation-mapping\"]"));
        deleteButtonForRecord.click();
        pauseFor(500);
        confirmDeleteAutomation.click();
    }
}
