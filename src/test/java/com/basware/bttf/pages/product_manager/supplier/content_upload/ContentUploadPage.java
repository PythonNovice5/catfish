package com.basware.bttf.pages.product_manager.supplier.content_upload;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.ManageAgreementPage;
import com.basware.bttf.pages.product_manager.supplier.media.UploadFilesPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class ContentUploadPage extends ProductManagerPage {
    protected static Logger LOGGER = Logger.getLogger(ContentUploadPage.class.getName());

    public ContentUploadPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(id = "contentType")
    WebElement uploadType;
    @FindBy(id="currency")
    WebElement currencyDropdown;
    @FindBy(id="language")
    WebElement languageDropdown;
    @FindBy(name = "attachment")
    WebElement selectFileButton;
    @FindBy(xpath="//*[@id='BMECAT']/div[4]/div[2]/button|//input[@id='uploadFileSubmit']")
    WebElement uploadButton;
    @FindBy(xpath = "//*[@id='activities']/div[1]/div/div[2]/button[1]")
    WebElement stopButtonId;

    @FindBy(id="uploadFile")
    WebElement ImportFileField;

    @FindBy(xpath = "//a[text()='Back']")
    public WebElement backButton;

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/products/dashboard/upload";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Content Upload";
    }

    public void selectUploadType(String value) {
        selectDropdownOption(uploadType, value);
    }

    public void selectCurrency(String currency) throws InterruptedException {
        waitUntilDisplayed(currencyDropdown);
        selectDropdownOption(currencyDropdown, currency);
    }

    public void selectLanguage(String language) throws InterruptedException {
        waitUntilDisplayed(languageDropdown);
        selectDropdownOption(languageDropdown, language);
    }

    public void enterFileToUpload(String fileType, String fileName) throws InterruptedException {
        selectFileButton.sendKeys(getFilePath() + fileName);
    }

    public void enterItemsFileToUpload(String fileType, String fileName) throws InterruptedException {
        selectFileButton.sendKeys(getFrameworkItems() + fileName);
    }

    public void uploadFileOfType(String fileType) throws InterruptedException {
        waitUntillElementIsClickableAndClick(uploadButton);
    }

    public ManageAgreementPage uploadFile() throws Exception{
        waitUntillElementIsClickableAndClick(uploadButton);
        pauseFor(10000);
        return new ManageAgreementPage();
    }

    public void stopUpload() throws InterruptedException {
        pauseFor(1000);
        waitUntilDisplayed(stopButtonId);
        stopButtonId.click();
    }

    public String fileName() {
        waitUntilDisplayed(driver.findElement(By.xpath("//*[@id='activities']/div[1]/div/div[2]/button[2]")));
        String fileName = driver.findElement(By.xpath("//*[@id='activities']/div[1]/div/div[1]/div/div[2]/div")).getText();
        return fileName;
    }

    public String waitForUploadStatusMessage() {
        pauseFor(15000);
        waitUntilDisplayed(driver.findElement(By.xpath("//*[@id='activities']/div[1]/div/div[2]/button[2]")));
        String statusMessage = driver.findElement(By.xpath("//*[@id='activities']/div[1]/div/div[1]/div/div[3]/div")).getText();
        return statusMessage;
    }

    public String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\testdata\\temp\\");
    }

    public String getFrameworkItems(){
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\generator\\test_data\\");
    }

    public ContentUploadPage importFrameworkItems(String fileName) throws  Exception{
        File file = new File(getFilePath() + "/.." + "/" + fileName);
        LOGGER.debug("Path to be used   ----" + file.getCanonicalPath());
        ImportFileField.sendKeys(file.getCanonicalPath());
        return new ContentUploadPage();
    }
}
