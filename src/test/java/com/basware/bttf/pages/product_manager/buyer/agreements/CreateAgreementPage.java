package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.util.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class CreateAgreementPage extends ProductManagerPage
{

    protected static Logger LOGGER = Logger.getLogger( CreateAgreementPage.class.getName() );
//    public WebElement agreementTypeDropdown = driver.findElement(By.id("agreementType"));
    public CreateAgreementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @FindBy(id="agreementType")
    public WebElement agreementTypeDropdown;
    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/addAgreement";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Create Agreement";
    }

    public void enterAgreementName(String name) throws InterruptedException
    {
        WebElement agreementName = driver.findElement(By.id("name"));
        agreementName.sendKeys(name);
    }

    public void enterStartDateByText(String relativeDate) throws InterruptedException
    {
        WebElement agreementStartDate = driver.findElement(By.id("startDate"));
        String dateString = getDateText(relativeDate);
        agreementStartDate.sendKeys(dateString + Keys.TAB);
    }

    public void enterExpiryDateByText(String relativeDate) throws InterruptedException
    {
        WebElement agreementExpiryDate = driver.findElement(By.id("expiryDate"));
        String dateString = getDateText(relativeDate);
        agreementExpiryDate.sendKeys(dateString + Keys.TAB);
    }

    public void enterContractReference(String cRef) throws InterruptedException
    {
        WebElement contractReference = driver.findElement(By.id("contractRef"));
        contractReference.sendKeys(cRef);
        LOGGER.debug("Entered Contract Reference as: "+cRef);
    }

    protected void pauseFor(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {}
    }

    public void selectAgreementType(String type) throws InterruptedException
    {
//        WebElement agreementTypeDropdown = driver.findElement(By.id("agreementType"));
        waitUntilDisplayed(agreementTypeDropdown);
        selectDropdownOption(agreementTypeDropdown,type);
    }

    public void selectLanguage(String language) throws InterruptedException
    {
        WebElement languageDropdown = driver.findElement(By.id("languageCode"));
        waitUntilDisplayed(languageDropdown);
        selectDropdownOption(languageDropdown,language);
    }

    public void selectCurrency(String currency) throws InterruptedException
    {
        WebElement currencyDropdown = driver.findElement(By.id("currency"));
        waitUntilDisplayed(currencyDropdown);
        selectDropdownOption(currencyDropdown,currency);
    }

    public void enterKeywords(String keywords) throws InterruptedException
    {
        WebElement agreementKeywords = driver.findElement(By.id("keywords"));
        agreementKeywords.sendKeys(keywords);
    }

    public void enterDescription(String description) throws InterruptedException
    {
        WebElement agreementDescription = driver.findElement(By.id("description"));
        agreementDescription.sendKeys(description);
    }

    public void enterForSupplier(String forSupplier) throws InterruptedException
    {
        WebElement agreementForSupplier = driver.findElement(By.id("forSupplier"));
        agreementForSupplier.sendKeys(forSupplier);
    }




    public ProductManagerDirectoryPage cancelAgreement() throws InterruptedException
    {
        clickLinkByHref("cancel");
        //Deal with pop-up dialog "Are you sure you want to cancel adding this agreement? Any information you have provided will be lost"
        return new AgreementDirectoryPage();
    }

    public ProductManagerPage saveAgreement(String type) throws InterruptedException
    {
        WebElement saveAgreement = driver.findElement(By.name("product_management_saveAgreement"));
        waitUntillElementIsClickableAndClick(saveAgreement);
//        saveAgreement.click();
        String url = driver.getCurrentUrl();
        String agreementId = url.substring(url.lastIndexOf("/")+1,url.length());

        switch (type.toLowerCase()){
            case "organisation":
                props.set(TestConstants.ORG_AGREEMENT_ID, agreementId );
                break;
            case "shared":
                props.set(TestConstants.SHARED_AGREEMENT_ID, agreementId );
                break;
            case "punchout":
                props.set(TestConstants.PUNCHOUT_AGREEMENT_ID, agreementId );
                break;
            case "agent":
                props.set(TestConstants.AGENT_AGREEMENT_ID,agreementId);
                break;
            case "framework":
                props.set(TestConstants.FRAMEWORK_AGREEMENT_ID,agreementId);
                break;
            default:
                break;
        }
        return new ManageAgreementPage();
    }


    private String getDateText(String dateString)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime( new Date() );

        switch (dateString.toUpperCase())
        {
            case "PAST DATE":
                cal.add( Calendar.DAY_OF_YEAR ,-1 );
                break;
            case "TOMORROW":
                cal.add( Calendar.DAY_OF_YEAR ,1 );
                break;
            case "FUTURE DATE":
                cal.add( Calendar.MONTH ,2 );
                break;
        }

        return new SimpleDateFormat( "dd-MM-yyyy" ).format( cal.getTime() );
    }
}
