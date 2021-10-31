package com.basware.bttf.pages.settings;
import com.basware.bttf.pages.LoggedInPage;
import net.sourceforge.htmlunit.corejs.javascript.EcmaError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
//import sun.reflect.annotation.ExceptionProxy;

public class OrganisationManagementPage extends LoggedInPage
{
    public OrganisationManagementPage()
    {
        PageFactory.initElements( driver , this );
    }
    public WebElement toggle;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/admin/organisation/manage";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Organisation management";
    }

    @FindBy(xpath = "//span[text()='Certification']")
    public WebElement certifications;

    @FindBy(xpath = "//span[text()='Financial information']")
    public WebElement financialInformation;

    @FindBy(xpath = "//p[contains(text(),'LVP self-certification status')]//span")
    public WebElement certificationStatus;

    @FindBy(xpath = "//button[text()='Take the self-certification questionnaire.']")
    public WebElement questionnaire;

    @FindBy(xpath = "//input[@value='YES']")
    public List<WebElement> yesRadioButtons;

    @FindBy(xpath = "//select[@id='tpd.supplierCertificates['DWPLVP'].serviceCategorie']")
    public WebElement typeOfTrainingCourse;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateAnswers;

    @FindBy(xpath = "//select[contains(@id,'supplierCertificates')]")
    public WebElement selectTrainingType;

    @FindBy(name = "tpd.primaryBankDetails.accountName")
    public WebElement accountName;

    @FindBy(xpath = "//div[@class='row']")
    public WebElement webpageBody;

    @FindBy(xpath = "//span[text()='Features']")
    public WebElement Features;

    @FindBy(xpath="//input[@value='Save']")
    public WebElement Save;

    @FindBy(xpath = "//option[text()='Care (All)']")
    public WebElement careAll;

    public OrganisationManagementPage clickOn(String value) throws Exception {

        switch(value){
            case "Certification":
                scrollToElement(certifications);
                waitUntillElementIsClickableAndClick(certifications);
                break;
            case "Financial information":
                financialInformation.click();
                break;
            case "self-certification questionnaire":
                questionnaire.click();
                break;
            case "YesRadioButtonForAllAnswers":
                selectYesRadioButtons();
                break;
            case "Update":
                updateAnswers.click();
                break;
            case "Care (All)":
                waitUntillElementIsClickableAndClick(careAll);
//                careAll.click();
                break;
                default:
                    waitUntillElementIsClickableAndClick(getWebElementNamed(value));
//                    pauseFor(2000);
                    break;
        }
        return new OrganisationManagementPage();
    }

    public OrganisationManagementPage verifyStatus(String value){
        waitUntilDisplayed(certificationStatus);
        Assert.assertTrue("Certification Status was not found as per expectation",certificationStatus.getText().trim().contains(value));
        return new OrganisationManagementPage();
    }

    public OrganisationManagementPage selectYesRadioButtons() throws Exception{

        for(WebElement i: yesRadioButtons)
        {
            waitUntillElementIsClickableAndClick(i);
            if (i.isSelected())
                LOGGER.debug("Selected the YES radio button");
        }

        return new OrganisationManagementPage();
    }

    public OrganisationManagementPage selectCourse(String value) throws Exception {
//        switch (value){
//            case "Beauty/Cosmetic (non hairdressing)":
//                selectDropdownOptionByValue(selectTrainingType,"DWPLVP00006");
                selectDropdownOptionByText(selectTrainingType,value);
//        driver.findElement(By.xpath(String.format("//option[text()='%s']",value))).click();
                pauseFor(3000);
//                break;
//            case "Arts and Crafts":
//                selectDropdownOptionByValue(selectTrainingType,"DWPLVP00005");
//                break;
//        }
        return new OrganisationManagementPage();
    }

    public void enterValueIntoField( String value, String fieldName ) throws Exception {
        switch (fieldName) {
            case "AccountName":
                setValueOfWebElement(accountName,value);
//                accountName.sendKeys(value);
                webpageBody.click();
                break;
        }
    }

    public OrganisationManagementPage toggleEnableDisable(String value,String fieldName){
        boolean Switchflag;
        try {
            toggle = driver.findElement(By.xpath(String.format(("//label[text()='%s:']//..//..//div[normalize-space(@class)='toggle']"),fieldName)));
            LOGGER.debug("Available toggle switch is found to be OFF");
            Switchflag=false;
        }
        catch(NoSuchElementException e){
            toggle = driver.findElement(By.xpath(String.format(("//label[text()='%s:']//..//..//div[normalize-space(@class)='toggle checked']"),fieldName)));
            LOGGER.debug("Available toggle switch is found to be On");
            Switchflag=true;
        }

        switch(value) {
            case "On":
                if (Switchflag==false)
                    toggle.click();
                break;
            case "Off":
                if(Switchflag==true)
                    toggle.click();
                break;
        }
        return new OrganisationManagementPage();
    }

}
