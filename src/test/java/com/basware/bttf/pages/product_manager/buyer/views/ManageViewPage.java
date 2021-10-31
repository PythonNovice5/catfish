package com.basware.bttf.pages.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class ManageViewPage extends ViewDirectoryPage {

    protected static Logger LOGGER = Logger.getLogger( ManageViewPage.class.getName() );
//    private String publishBtn = "//a[contains(text(),'Publish')]";
    private String manageUser = "//span[@title='Manage users']";
    private String viewPublished = "//div[text()='Published']";


    public ManageViewPage()
    {
        PageFactory.initElements(driver, this );
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Manage View";
    }

    public String getExpectedUrl(){

        return getBaseUrl() + "/products/viewDoc/index";
    }

    @FindBy(xpath="//a[contains(text(),'Publish')]")
    public WebElement publishBtn;

    @FindBy(xpath = "//div[@class='switch-container-large']//div[@class='switch open']")
    public WebElement showTaxOn;

    @FindBy(xpath = "//div[@title='Tax details are hidden in marketplace']//div[@class='switch']")
    public WebElement showTaxOff;

    @FindBy(xpath="//div[text()='Published']")
    public WebElement viewPublishedText;

    @FindBy(xpath = "//div[text()='Processing']")
    public WebElement viewProcessingText;

    @FindBy(xpath = "//span[contains(text(),'Checkout form')]")
    private WebElement checkOutFormButton;

    @FindBy(xpath = "//*[@id='checkoutFormTable']/table/thead/tr/th[4]/span/span")
    private WebElement addCheckoutForm;

    @FindBy(name = "view.checkoutForm[0].variable")
    private WebElement firstCheckoutFormVariable;

    @FindBy(name = "view.checkoutForm[0].label")
    private WebElement firstCheckFormLabel;

    @FindBy(name = "view.checkoutForm[1].variable")
    private  WebElement secondCheckoutFormVariable;

    @FindBy(name = "view.checkoutForm[1].label")
    private WebElement secondCheckoutFormLabel;

    @FindBy(name = "view.checkoutForm[2].variable")
    private WebElement thirdCheckoutFromVariable;

    @FindBy(name = "view.checkoutForm[2].label")
    private WebElement thirdCheckoutFormLabel;

    @FindBy(name = "_action_updateCheckoutForm")
    private WebElement saveCheckoutForm;

    @FindBy(id = "view.checkoutForm[1].type")
    private WebElement secondAnswerFormat;

    @FindBy(id= "view.checkoutForm[2].type")
    private WebElement thirdAnswerFormat;

    public ProductManagerPage addToView( String cogName )
    {
        ProductManagerPage page = null;
        switch( cogName )
        {
            case "Manage agreements":
//                pauseFor(15000);
                clickCog( cogName );
                page = new SelectAgreementPage();
                break;
            case "Manage users":
                clickCog(cogName);
                page = new SelectUsersPage();
                break;
            case "Manage lists":
                clickCog( cogName );
                page = new ListDirectoryPage();
                break;
            case "ShowtaxEnable":
                return showTaxEnableDisable(cogName);
        }

        return page;
    }

    private void clickCog(String btnValue)
    {
        pauseFor(5000);
        WebElement toBeClicked = driver.findElement(By.cssSelector("[title='" + btnValue + "']"));
        waitUntillElementIsClickableAndClick(toBeClicked);
//        toBeClicked.click();
        LOGGER.debug("Clicked on "+btnValue);
    }

    public ViewDirectoryPage publishView(){
      waitUntillElementIsClickableAndClick(publishBtn);
      pauseFor(2000);
      LOGGER.info("Clicked on Publish button and the view is published..");
      return new ViewDirectoryPage();
    }

    public ManageViewPage verifyViewPublished() throws Exception{
        waitForProcessing();
        assertEquals("Could not find status as Published, Instead Found - ",getTextOfWebElement(viewPublishedText),"Published");
        LOGGER.info("The view was published successfully");
        return new ManageViewPage();
    }

    public void waitForProcessing(){
        for (int i=0;i<=5;i++)
        {
            try{
                viewProcessingText.isDisplayed();
                driver.navigate().refresh();
                pauseFor(2000);
                continue;
            }
            catch(Exception e){
                pauseFor(1000);
                waitUntilDisplayed(viewPublishedText);
            }
        }
    }

    public ManageViewPage showTaxEnableDisable(String value){
        boolean toggleState;
     try{
         showTaxOn.isDisplayed();
         toggleState = true;

     }
     catch (Exception e){
         showTaxOff.isDisplayed();
         toggleState = false;
     }


        switch (value){

            case "ShowtaxEnable":
                if (!toggleState)
                    showTaxOff.click();
                break;
            case "ShowtaxDisable":
                if (toggleState)
                    showTaxOn.click();
                break;
        }
        return new ManageViewPage();
    }

    public void deleteView()
    {
        String url = driver.getCurrentUrl();
        String urlToDeleteViews = url.replace("index","delete");
        driver.get(urlToDeleteViews);
    }

    public void addCheckoutForm(){
        waitUntillElementIsClickableAndClick(checkOutFormButton);
        waitUntillElementIsClickableAndClick(addCheckoutForm);
        addCheckoutForm.click();
        addCheckoutForm.click();
        firstCheckoutFormVariable.sendKeys("Greetings");
        firstCheckFormLabel.sendKeys("Enter the greetings");
        secondCheckoutFormVariable.sendKeys("Enter the number");
        selectDropdownOption(secondAnswerFormat,"Number");
        secondCheckoutFormLabel.sendKeys("45767");
        thirdCheckoutFromVariable.sendKeys("Enter date");
        selectDropdownOption(thirdAnswerFormat,"Date");
        thirdCheckoutFormLabel.sendKeys("Enter date to see the date");
        saveCheckoutForm.click();
    }
}
