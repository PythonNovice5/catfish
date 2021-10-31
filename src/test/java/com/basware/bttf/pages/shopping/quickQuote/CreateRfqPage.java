package com.basware.bttf.pages.shopping.quickQuote;

import com.basware.bttf.pages.shopping.SelectSupplierForQuickQuotePage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class CreateRfqPage extends ShoppingPage {

    @FindBy(id = "name")
    private WebElement titleTextBox;

    @FindBy(css = "button.btn.btn-primary.done")
    public WebElement doneButton;

    @FindBy(xpath = "//input[contains(@id,'unitOfMeasure')]")
    public WebElement orderUnit;

    @FindBy(xpath = "//input[contains(@id,'quantity')]")
    public WebElement Quantity;

    @FindBy(id = "expiryDate")
    private WebElement expiryDate;

    @FindBy( name = "procserveaction_addCategories")
    private WebElement classificationCog;

    @FindBy(id = "currency")
    private WebElement currencyFiled;

    @FindBy(name = "editLines[0].name")
    private WebElement rfqProdcutName;

    @FindBy(name = "editLines[0].description")
    private WebElement descriptionFiled;

    @FindBy(name = "_action_addSupplier")
    private WebElement addSupplierButton;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/a")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/button[1]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/button[2]" )
    private WebElement sendButton;

    @FindBy(id = "expiryTime")
    private  WebElement expirationTime;

    @FindBy(css = "div.col-sm-8.control input#name.form-control.required")
    private WebElement actualRfqTitle;

    @FindBy(xpath= "//a[@id='addLineAction']")
    private WebElement addButton;

//    @FindBy(id="updateLineAction")
    @FindBy(xpath = "//a[@id='addLineAction']")
    private WebElement updateLineButton;

    @FindBy(xpath="//div[5]/div[1]/div/span")
    private WebElement rfqSentMessage;

    public CreateRfqPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/rfq/rfq/edit";
    }

    @Override
    public String getExpectedTitle() {
        return "Create RFQ";
    }

    public void enterTitle(String title) {
        waitUntilDisplayed(titleTextBox);
        titleTextBox.sendKeys(title);
    }


    public void enterDate(String days) {
        String dateAfterAdded = addDaysTocurrentDate(Integer.parseInt(days));
        waitUntilDisplayed(expiryDate);
        expiryDate.sendKeys(dateAfterAdded);
    }

    public void selectCurrency(String currency) {
        selectDropdownOption(currencyFiled, currency);
    }

    public void enterProductName(String productName) {
        rfqProdcutName.sendKeys("productName");
    }

    public void enterDescription(String description) {
        waitUntilDisplayed(descriptionFiled);
        descriptionFiled.sendKeys(description);
    }

    public void clickClassificationCog()
    {
        classificationCog.click();
    }

    public void clickOnAddButton()
    {
        waitUntillElementIsClickableAndClick(addButton);
//        addButton.click();
        pauseFor(2000);
    }

    public SelectSupplierForQuickQuotePage clickOnAddSupplierButton(){
        waitUntillElementIsClickableAndClick(addSupplierButton);
        return new SelectSupplierForQuickQuotePage();
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    public void clickOnSaveButton(){
        saveButton.click();
    }

    public void clickOnSendButton(){
        pauseFor(1000);
        waitUntillElementIsClickableAndClick(sendButton);
    }

    public void enterTime(){
        String timePassed = currentHour();
        selectDropdownOption(expirationTime,timePassed+":00");
    }

    public void clickDone(){
        waitUntillElementIsClickableAndClick(doneButton);
    }

    public void updateLine()
    {
        waitUntillElementIsClickableAndClick(updateLineButton);
    }

    public void verifyRfqSuccessMessage()
    {
       waitUntilDisplayed(rfqSentMessage);
       assertEquals("The RFQ has been sent.", rfqSentMessage.getText());

    }

    public void checkRfqTile(String rfqTtitle){
        assertEquals(rfqTtitle,actualRfqTitle.getText());
    }
}
