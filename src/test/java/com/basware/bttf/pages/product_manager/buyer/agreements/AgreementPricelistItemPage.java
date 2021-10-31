package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AgreementPricelistItemPage extends ProductManagerDirectoryPage
{
    @FindBy(linkText = "Done")
    private WebElement doneButton;

    @FindBy(xpath = "//*[@id='page-results']/div[1]/div[2]/div/span[1]")
    private WebElement approveButton;

    @FindBy(xpath= "//*[@id='confirmationModal']/div/div/div[3]/span")
    private WebElement confirmApproval;

    @FindBy(xpath = "//*[normalize-space(text())='Create']")
    public WebElement CreateNewItem;

    @FindBy(xpath = "//*[@title= \"Manage qualification questionnaire\"]")
    public WebElement ManageQualificationQuestionnaire;

    @FindBy(xpath = "//*[@title= \"Manage item questionnaire\"]")
    public WebElement ManageItemQuestionnaire;


    public AgreementPricelistItemPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void initSortByItems() {

    }

    @Override
    protected void initFilterItems() {

    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/products/agreementItems/";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Agreement Price List Items";
    }

    public void assignContentTagToItem(int number,String tagToSelect)
    {
        WebElement contentTagEditable = driver.findElement(By.xpath("//*[@id='pricelistTable']/div["+number+"]/div/div[1]/div/div[7]/div/div[2]"));
        contentTagEditable.click();
        WebElement contentTagDropDown = driver.findElement(By.xpath("//*[@id='pricelistTable']/div["+number+"]/div/div[1]/div/div[7]/div/div[2]/div/form/div/select"));
        new Select(contentTagDropDown).selectByVisibleText(tagToSelect);
        WebElement contentTagOK = driver.findElement(By.xpath("//*[@id='pricelistTable']/div["+number+"]/div/div[1]/div/div[7]/div/div[2]/div/form/button[@type='submit']"));
        contentTagOK.click();
    }
    public ProductManagerPage clickOnElem(String elem){
        switch (elem) {
            case "Create":
                waitUntillElementIsClickableAndClick(CreateNewItem);
                return new AgreementItemCreateItemPage();
            case "ManageQualificationQuestionnaire":
                waitUntillElementIsClickableAndClick(ManageQualificationQuestionnaire);
                return new ManageQualificationQuestionnairePage();
            case "ManageItemQuestionnaire":
                waitUntillElementIsClickableAndClick(ManageItemQuestionnaire);
                return new ManageItemQuestionnairePage();
            case "Done":
                waitUntillElementIsClickableAndClick(doneBtn);
                pauseFor(1000);
                return new ManageAgreementPage();
        }
        return null;
    }
    public ManageAgreementPage clickDone()
    {
     doneButton.click();
     return new ManageAgreementPage();
    }
}
