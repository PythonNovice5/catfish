package com.basware.bttf.pages.product_manager.buyer.agreements;


import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentAgreementCreateItemPage extends ProductManagerPage {

   @FindBy(id = "sku")
   public WebElement supplierItemID;

   @FindBy(id = "attributes.name")
   public WebElement agentItemName;

   @FindBy(id = "attributes.description")
   public WebElement agentItemDescription;

   @FindBy(id = "productPrices[0].price")
   public WebElement agentItemPrice;

   @FindBy(name = "procserveaction_addCategories")
   public WebElement classificationCog;

   @FindBy(xpath = "//*[@id='page-actions']/button")
   public WebElement saveButton;

   @FindBy(xpath = "//*[@id='div_itemTemplate']/div[3]/button")
   public WebElement manageTemplateCog;

   @FindBy(xpath = "//*[@id='selectItemTemplateBody']/div[1]/form/div[2]/button")
   public WebElement searchTemplateButton;

   @FindBy(xpath = "//div[@id='selectItemTemplateBody']//span[@class='glyphicon glyphicon-plus']")
   public WebElement addTemplate;

   @FindBy(css = "#selectItemTemplate input[name=keywords]")
   public WebElement searchInput;

   @FindBy(name = "templateValues[2].options[0].display")
   public WebElement firstVariableName;

   @FindBy(name = "templateValues[2].options[0].basket")
   public WebElement firstBasketValue;

   @FindBy(name= "templateValues[3].options[0].display")
   public WebElement secondVariableName;

   @FindBy(name = "templateValues[3].options[0].basket")
   public WebElement secondBasketValue;

   @FindBy(xpath = "//*[@id='agreementItem']//..//span[@class='link-document']")
   public WebElement templateDataButton;

    @Override
    public String getExpectedUrl() {
        return "/products/agreementItems/create";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Create Item";
    }

    public AgentAgreementCreateItemPage()
    {
        PageFactory.initElements(driver,this);
    }

    public ProductManagerPage clickOnButtonInAgentItemPage(String button)
    {

        ProductManagerPage page = null;
        switch(button){
            case "classificationCog":
                waitUntillElementIsClickableAndClick(classificationCog);
                page = this;
                break;
            case "save":
                waitUntillElementIsClickableAndClick(saveButton);
                page = new AgentAgreementEditItemPage();
                break;
        }
        return page;

    }

    public void selectTemplateForAnItem() throws Exception {
        manageTemplateCog.click();
        waitUntilDisplayed(searchInput);
        searchInput.sendKeys(props.get("TemplateName"));
        searchTemplateButton.click();
        pauseFor(2000);
        WebElement itemTemplate = driver.findElement(By.xpath(String.format("//div//strong[text()='%s']",props.get("TemplateName"))));
        getTextOfWebElement(itemTemplate);
        Assert.assertEquals("Item Template was not found",props.get("TemplateName"),getTextOfWebElement(itemTemplate));
        addTemplate.click();
    }

    public void enterTemplateData(String variableName, String basketValue)
    {
        waitUntilDisplayed(templateDataButton);
        scrollToElement(templateDataButton);
        waitUntillElementIsClickableAndClick(templateDataButton);
        waitUntilDisplayed(firstVariableName);
        firstVariableName.sendKeys(basketValue);
        firstBasketValue.sendKeys(variableName);
        secondVariableName.sendKeys(variableName);
        secondBasketValue.sendKeys(basketValue);

    }
}
