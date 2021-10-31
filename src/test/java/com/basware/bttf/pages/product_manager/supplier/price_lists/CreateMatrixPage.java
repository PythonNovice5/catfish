package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMatrixPage extends ProductManagerPage {

    @FindBy(name="name")
    private WebElement matrixName;

    @FindBy(name="itemSkus[0]")
    public WebElement firstItemField;


    @FindBy(xpath = "//span[text()='Option Sets']//..//..//..//div[@id='add-dimension']/span")
    public WebElement addOptionSetButton;

    @FindBy(name = "description")
    private WebElement matrixDescription;

    @FindBy(xpath = "//*[@id='matrixForm']//*[@name='attributes[0]']")
    private WebElement firstAttribute;

    @FindBy(xpath = "//*[@id='itemsLabel']//..//span[@class='glyphicon glyphicon-plus']")
    public WebElement addItemID;

    @FindBy(xpath = "//*[@id='dimensions']/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div/input")
    private WebElement firstValueFor1stCaption;

    @FindBy(xpath = "//*[@id='dimensions']/div[1]/div[2]/div[2]/div[4]/div[2]/div[1]/div/input")
    private WebElement secondValueFor1stCaption;

    @FindBy(xpath = "//*[@id='dimensions']/div[1]/div[2]/div[2]/div[4]/div[3]/div[1]/div/input")
    private WebElement thirdValueFor1stCaption;

    @FindBy(xpath = "//*[@id='dimensions']/div[2]/div[2]/div[1]/div[1]/div[2]/input")
    private WebElement secondCaption;

    @FindBy(xpath = "//*[@id='dimensions']/div[2]/div[2]/div[2]/div[4]/div[1]/div[1]/div/input")
    private WebElement firstValueFor2ndCaption;

    @FindBy(xpath = "//*[@id='dimensions']/div[2]/div[2]/div[2]/div[4]/div[2]/div[1]/div/input")
    private WebElement secondValueFor2ndCaption;

    @FindBy(xpath = "//*[@id='dimensions']/div[2]/div[2]/div[2]/div[4]/div[3]/div[1]/div/input")
    private WebElement thirdValueFor2ndCaption;

    @FindBy(xpath = "//*[@id='page-actions']/input")
    private WebElement saveMatrix;

    @FindBy(linkText = "Cancel")
    private WebElement cancelMatrix;

    @FindBy(xpath = "//*[@id='add-dimension']/span/span")
    private WebElement addCaptionButton;

    @FindBy(id = "confirmWipeMatrixItemsCancel")
    private WebElement cancelAlert;

    @FindBy(id = "confirmed")
    private WebElement alertConfirm;

    public CreateMatrixPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return "/products/matrix/edit?priceListId=";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Create Matrix";
    }

    public void enterMatrixItemValue(String field,String value)
    {
        switch(field)
        {
            case "name":
                matrixName.sendKeys(value + getSessionID());
                break;
            case "description":
                matrixDescription.sendKeys(value);
                break;
            case "first attribute":
                waitUntilDisplayed(firstAttribute);
                firstAttribute.sendKeys(value);
                break;
            case "second caption":
                pauseFor(5000);
                secondCaption.sendKeys(value);
                break;
            case "first value for 1st caption":
                firstValueFor1stCaption.sendKeys(value);
                break;
            case "second value for 1st caption":
                secondValueFor1stCaption.sendKeys(value);
                break;
            case "third value for 1st caption":
                thirdValueFor1stCaption.sendKeys(value);
                break;
            case "first value for 2nd caption":
                firstValueFor2ndCaption.sendKeys(value);
                break;
            case "second value for 2nd caption":
                secondValueFor2ndCaption.sendKeys(value);
                break;
            case "third value for 3rd caption":
                thirdValueFor2ndCaption.sendKeys(value);
                break;
            case "First Item ID":
                firstItemField.sendKeys(value);
                break;
        }
    }

    public void clickOnButton(String button)
    {
        switch (button)
        {
            case "cancel":
                waitUntillElementIsClickableAndClick(cancelMatrix);
//                cancelMatrix.click();
                break;
            case "AddOptionSet":
                waitUntillElementIsClickableAndClick(addOptionSetButton);
//                addCaptionButton.click();
//                pauseFor(5000);
                break;
            case "Add Item":
                waitUntillElementIsClickableAndClick(addItemID);

        }
    }

    public PriceListMatrixItemsDirectoryPage saveMatrixItem(){
        waitUntillElementIsClickableAndClick(saveMatrix);
        return new PriceListMatrixItemsDirectoryPage();
    }

    public void alertConfirmation(String button)
    {
        switch(button)
        {
            case "cancel":
                waitUntillElementIsClickableAndClick(cancelAlert);
//                cancelAlert.click();
                break;
            case "confirm":
                waitUntillElementIsClickableAndClick(alertConfirm);
//                alertConfirm.click();
                break;
        }
    }
}

