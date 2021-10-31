package com.basware.bttf.pages.contracts;


import com.basware.bttf.pages.LoggedInPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractsPage extends LoggedInPage
{
    @FindBy(xpath = "//div[2]/div[1]/div[1]/button")
    private WebElement createButton;

    @FindBy(linkText = "Contract" )
    private WebElement contractButton;

    @FindBy(linkText = "Framework")
    private WebElement frameworkButton;

    @FindBy(linkText = "View Items  ")
    public WebElement ViewItems;

    @FindBy(id = "keywords")
    public WebElement SearchContract;

    @FindBy(xpath = "//a[contains(text(),'Catfish contract reference5CF10961B7BF3B13240')]")
    public WebElement ContractLink;

    @FindBy(xpath = "//*[@id='importResults']/div/div/strong")
    private WebElement uploadResultMessage;


    public ContractsPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/contract/list";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: List";
    }

    public ContractsPage clickOnCreateContractType(String button)
    {
        ContractsPage page = null;
    createButton.click();
        switch(button) {
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

    public void clickOK()  {
        driver.switchTo().alert().accept();
    }

    public void verifyUploadResults ()throws Exception
    {
        long startAt = System.currentTimeMillis();
        long giveUpAt = System.currentTimeMillis()+ 30000;
        long waiting=0;
        while (System.currentTimeMillis() < giveUpAt && driver.findElements(By.xpath("//*[@id='importResults']/div/div/strong")).size()==0)
        {
            pauseFor(1000);
            waiting = waiting+1000;
        }
//       pauseFor(25000);
       waitUntilDisplayed(uploadResultMessage);

       Assert.assertEquals(getTextOfWebElement(uploadResultMessage), "The upload completed successfully.");
       long timeTakenForUpload = (System.currentTimeMillis()-startAt)+waiting;
       LOGGER.debug("The System took "+ Long.toString(waiting)+ " millisecons for file upload" );
    }

    public void enterValueIntoField(String value, String fieldName) throws InterruptedException {
        switch (value) {
            case "Catfish Contract":
                SearchContract.sendKeys(props.get("Cname"));
                break;
                }
        }

        public MyContractPage clickContractLink(){
            pauseFor(1000);
            driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]",props.get("Cname")))).click();
            return new MyContractPage();
        }
    }


