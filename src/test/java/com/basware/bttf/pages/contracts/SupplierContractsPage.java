package com.basware.bttf.pages.contracts;

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.ManageQualificationPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierContractsPage extends LoggedInPage {


    @FindBy(xpath = "//div[2]/div[1]/div[1]/button")
    private WebElement createButton;

    @FindBy(xpath = "//*[@title='Manage items']")
    public WebElement manageItems;

    @FindBy(linkText = "Contract")
    private WebElement contractButton;

    @FindBy(linkText = "Framework")
    private WebElement frameworkButton;

    @FindBy(linkText = "View Items  ")
    public WebElement ViewItems;

    @FindBy(name = "keywords")
    public WebElement SearchContract;

    @FindBy(name="btn-search")
    public WebElement SearchBtn;

    @FindBy(xpath = "//a[contains(text(),'Catfish contract reference5CF10961B7BF3B13240')]")
    public WebElement ContractLink;

    @FindBy(xpath = "//*[@id='importResults']/div/div/strong")
    private WebElement uploadResultMessage;

    @FindBy(xpath = "//*[@title='Manage qualification']")
    public WebElement manageQualification;

    public SupplierContractsPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/products/contracts";
    }

    @Override
    public String getExpectedTitle() {
        return "Contracts";
    }

    public ContractsPage clickOnCreateContractType(String button) {
        ContractsPage page = null;
        createButton.click();
        switch (button) {
            case "contract":
                contractButton.click();
                page = new EditContractPage();
                break;
            case "framework":
                frameworkButton.click();
                page = new CreateFrameworkPage();
                break;
        }
        return page;
    }

    public void clickOK() {
        driver.switchTo().alert().accept();
    }

    public void verifyUploadResults() {
        long giveUpAt = System.currentTimeMillis() + 20000;

        while (System.currentTimeMillis() < giveUpAt && driver.findElements(By.xpath("//*[@id='importResults']/div/div/strong")).size() == 0) {
            pauseFor(1000);
        }
        Assert.assertEquals(uploadResultMessage.getText(), "The upload completed successfully.");
    }

    public void enterValueIntoField(String value, String fieldName) throws Exception {
        switch (value) {
            case "Catfish Contract":
                SearchContract.sendKeys(props.get("Cname"));
                break;
            case "DPS Contract":
                waitUntilDisplayed(SearchContract);
                SearchContract.sendKeys(props.get("SupID"));
                break;
            default:
                enterValueIntoElement(value,"SearchContract");
        }
    }

    public MyContractPage clickContractLink() {
        pauseFor(1000);
        driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", props.get("Cname")))).click();
        return new MyContractPage();
    }

    public LoggedInPage clickOnLink(String linkName) throws Exception {
        switch (linkName) {
            case "Manage qualification":
                waitUntillElementIsClickableAndClick(manageQualification);
                return new ManageQualificationPage();
            case "Manage Items":
                waitUntillElementIsClickableAndClick(manageItems);
                return new ContractsItemsDirectoryPage();

        }
        return null;
    }
}
