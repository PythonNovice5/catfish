package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.Loader.LoaderUploadPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeDirectoryPage;
import net.sourceforge.htmlunit.corejs.javascript.EcmaError;
import org.apache.log4j.Logger;
import org.jaxen.function.SumFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Period;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManageAgreementPage extends ProductManagerPage {

    protected static Logger LOGGER = Logger.getLogger( ManageAgreementPage.class.getName() );
    private String agreementId;

    @FindBy(linkText = "Submit to supplier")
    public WebElement SubmitToSupplier;

    @FindBy(xpath = "//*[@id='priceList']/div[2]/div[2]/span")
    private  WebElement pricelistName;

    @FindBy(id = "modalConfirmOk")
    private WebElement addTag;

    @FindBy(id = "showAddContentTag")
    private WebElement addContentTags;

    @FindBy(id = "importItems")
    private WebElement itemImportButton;

    @FindBy(xpath = "//*[@id='div-details']/div[1]/div[2]")
    private WebElement type;

    @FindBy(linkText = "Publish")
    private WebElement publishButton;

    @FindBy(id = "sectionButtons_priceList")
    private  WebElement reviewPricelistButton;

    @FindBy(id = "sectionButtons_approval" )
    private WebElement selectApprovalScheme;

    @FindBy(id = "tagName")
    private WebElement tagNameText;

    @FindBy(id = "tagClose0")
    public WebElement removeFirstTag;

    @FindBy(css="[title='Dynamic Purchasing System options are turned on for this agreement']")
    public WebElement dpsAlreadyEnabled;

    @FindBy(css="[title='Dynamic Purchasing System options are turned off for this agreement'] .toggle")
    public WebElement dpsEnable;

    @FindBy(id = "myModalCloseBody")
    private  WebElement textOfTheModal;

    @FindBy(id = "myModalCloseClose")
    private WebElement closeButtonInModal;

    @FindBy(xpath = "//*[@id='div-stock']/div[2]/div[2]/div/div")
    public WebElement agentStockToggle;


    @FindBy(linkText = "Delete")
    private WebElement deleteButtonInModal;

    @FindBy(id = "supplierRef")
    private WebElement supplierReference;

    @FindBy(id = "supplierName")
    private WebElement supplierName;

    @FindBy(xpath = "//*[@id='div-items']/div[3]/div[2]")
    private WebElement agentItems;

    @FindBy(xpath = "//*[@id = 'manageItems']|//*[@id='viewItems']")
    public WebElement manageAgentItems;

    @FindBy(id = "importStock")
    public WebElement importStockButton;

    @FindBy(linkText = "Approve")
    public WebElement agentAgreementApproveButton;

    @FindBy(xpath = "//*[@id='page-content-container']/div[1]/div[1]/div/span")
    public WebElement agentAgreementApproveAlert;

    @FindBy(linkText = "Delete")
    public WebElement deleteAgreementButton;

    @FindBy(id = "modalConfirmOk")
    public WebElement deleteAgreementConfirmation;

//    @FindBy(linkText = "Approval.")
    @FindBy(linkText = "Approved.")
    public WebElement approvalLink;

    @FindBy(xpath = "//label[contains(text(),'Status')]//..//following-sibling::div")
    public WebElement status;

    public ManageAgreementPage( )
    {
        setAgreementId(agreementId);
        PageFactory.initElements( driver , this );
    }

    private String getAgreementId()
    {
        return this.agreementId;
    }

    private void setAgreementId(String id)
    {
        this.agreementId = id;
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/agreements/index/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Manage Agreement";
    }

    public void enterForSupplier(String supplierReference)
    {
        WebElement forSupplierReference = driver.findElement(By.id("forSupplier"));
        waitUntillElementIsClickableAndClick(forSupplierReference);
        WebElement textArea = driver.findElement(By.cssSelector("#forSupplier > form > div > textarea"));
        textArea.sendKeys(supplierReference);
        WebElement okButton = driver.findElement(By.cssSelector("#forSupplier > form > button.btn.btn-spacer.btn-primary"));
        okButton.click();
    }

    public String getAgreementName()
    {
        return driver.findElement(By.id("name")).getText();
    }

    public String getAgreementType()

    {
        //WebElement details = driver.findElement(By.id("div-details"));
        WebElement type = driver.findElement( By.xpath("//div[contains(text(),'Organisation agreement')]"));

        return type.getText();
        //return details.findElement(By.cssSelector(".col-sm-2 .col-sm-4")).getText();
    }

    public String getSupplier()
    {
        return driver.findElement(By.cssSelector("#div-supplier div.row div.col-sm-7 span.legend-text")).getText();

    }

    public String getStatus() throws Exception
    {
        return getTextOfWebElement(status);
    }

    public  void enableOrDisableDPS(String state){
        switch(state){
            case "Enable":
                try {
                    dpsAlreadyEnabled.isDisplayed();
                }
                catch (NoSuchElementException n){
                    LOGGER.debug("DPS was disabled");
                    waitUntillElementIsClickableAndClick(dpsEnable);
                }

                break;
        }
    }

    public AgentAgreementPricelistItemPage clickOnApprovalLink()
    {
        waitUntillElementIsClickableAndClick(approvalLink);
        return new AgentAgreementPricelistItemPage();
    }

    public void enableAgentStock()
    {
        agentStockToggle.click();
    }
    public String getLanguage()
    {
        return driver.findElement(By.id("languageCode")).getText();
    }

    public String getCurrency()
    {
        return driver.findElement(By.id("currency")).getText();
    }

    public String getApprovalScheme()
    {
        return driver.findElement(By.cssSelector("#div-approval div.row div.col-sm-7 p")).getText();
    }

    public String getKeyword()
    {
        return driver.findElement(By.id("keywords")).getText();
    }

    public String getForSupplier()
    {
        return driver.findElement(By.cssSelector("#forSupplier > div > div.edit-value.row.col-sm-11")).getText();
    }

    public ManageAgreementPage clickPublish(){
        waitUntillElementIsClickableAndClick(SubmitToSupplier);
        waitUntilPageDocumentIsCompleted();
        return new ManageAgreementPage();
    }

    public AgreementPricelistItemPage clickMangeItemsCog()
    {
        waitUntillElementIsClickableAndClick(manageAgentItems);
        return new AgreementPricelistItemPage();
    }


    public String getPriceListDetails()
    {
        return driver.findElement(By.cssSelector("#div-approval div.col-sm-6 span.legend-text")).getText();
    }

    public String getContractReference()
    {
        return driver.findElement(By.cssSelector("#contractRef div.edit-in-place div.edit-value.row.col-sm-11")).getText();
    }

    public SelectSupplierPage selectSupplier() throws InterruptedException
    {
        pauseFor(2000);
        WebElement selectSupplier = driver.findElement(By.xpath("//*[@id='sectionButtons_supplier']/a/span"));
        waitUntillElementIsClickableAndClick(selectSupplier);
        return new SelectSupplierPage();
    }

    public ApprovalSchemeDirectoryPage selectApprovalScheme() throws InterruptedException
    {

        waitUntillElementIsClickableAndClick(selectApprovalScheme);
        waitUntilPageDocumentIsCompleted();
        return new ApprovalSchemeDirectoryPage();
    }

    public void clickOnAddContentTag()
    {
          addContentTags.click();
    }

    public void clickAddOnModalPopUp(){
        addTag.click();
    }

    public void enterName(String contentTag) {
        pauseFor(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('input[name=tagName]').value='" + contentTag + "'");
       // WebElement nameTextBox = driver.findElement(By.cssSelector("#addContentTagForm input[type=text]"));
       // nameTextBox.sendKeys(contentTag);
    }

    public AgentAgreementPricelistItemPage clickOnReviewPricelistCog()
    {
//        reviewPricelistButton.click();
        waitUntillElementIsClickableAndClick(reviewPricelistButton);
        return new AgentAgreementPricelistItemPage();
    }

    public UploadAgentItemsPage clickOnImportButton(){
        waitUntillElementIsClickableAndClick(itemImportButton);
        return new UploadAgentItemsPage();
    }

    public void getPricelistName()
    {
       String actualPricelistName =  pricelistName.getText();
       actualPricelistName.contains(props.get("plName"));
    }

    public void publishAgreement()
    {
        waitUntilDisplayed(publishButton);
        publishButton.click();
    }

    public void removeContentTag()
    {
        removeFirstTag.click();
    }

    public void verifyConfirmationMessage()
    {
        pauseFor(2000);
      assertEquals("This tag must be removed from all agreement items before being deleted.",textOfTheModal.getText());
      closeButtonInModal.click();
    }

    public void clickOnDeleteButton()
    {
        waitUntillElementIsClickableAndClick(deleteButtonInModal);
        pauseFor(1000);
    }

    public void enterAgentAgreementSupplierDetails() throws Exception {
        waitUntilDisplayed(supplierReference);
        supplierReference.click();
        supplierReference.findElement(By.cssSelector("input")).sendKeys("Catfish");
        supplierReference.findElement(By.cssSelector("button[type=submit]")).click();
        supplierName.click();
        supplierName.findElement(By.cssSelector("input")).sendKeys("catfish");
        supplierName.findElement(By.cssSelector("button[type=submit]")).click();
    }

    public void verifyUploadedAgentItems()
    {
        int actualNumber = Integer.parseInt(agentItems.getText());

        long giveUpAt = System.currentTimeMillis()+ 10000;

        while (System.currentTimeMillis() < giveUpAt && actualNumber == 0)
        {
            pauseFor(2000);
            driver.navigate().refresh();
            pauseFor(2000);
            actualNumber = Integer.parseInt(agentItems.getText());
        }
    }

    public void clickOnApproveButton()
    {
        waitUntillElementIsClickableAndClick(agentAgreementApproveButton);
        waitUntilDisplayed(agentAgreementApproveAlert);
    }

    public void deleteAgreement()
    {
        waitUntillElementIsClickableAndClick(deleteAgreementButton);
        waitUntillElementIsClickableAndClick(deleteAgreementConfirmation);
    }

    public LoaderUploadPage clickOnImportStock()
    {
        importStockButton.click();
        return new LoaderUploadPage();
    }
}
