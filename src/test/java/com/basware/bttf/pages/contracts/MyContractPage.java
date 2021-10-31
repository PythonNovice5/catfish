package com.basware.bttf.pages.contracts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class MyContractPage extends ContractsPage{


    @FindBy(linkText = "Publish")
    private WebElement publishButton;

    @FindBy(xpath = "//div[5]/div[1]/content/div[1]/span")
    private WebElement successfulContractPublish;

    @FindBy(xpath = "//div[@id='SuppliersStatus']//p//strong")
    public WebElement TotalSuppliers;

    @FindBy(xpath = "//div[@id='RegistrationProgressBar']//..//p//strong")
    public WebElement RegistrationProgress;

    @FindBy(xpath = "//div[@id='ItemsStatus']/p/strong[text()='1']")
    public WebElement Items;

    @FindBy(linkText = "View Items")
    public WebElement ViewItems;

    @FindBy(linkText = "Sharing")
    public WebElement Sharing;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/contract/display";
    }

    public String getExpectedTitle()
    {
        return "Contracts: My Contract";
    }

    public MyContractPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void clickOnPublish()
    {
        pauseFor(2000);
        waitUntillElementIsClickableAndClick(publishButton);
//        publishButton.click();
    }

    public void verifySuccessfulContractPublish()
    {
        waitUntilDisplayed(successfulContractPublish);
        assertEquals(successfulContractPublish.getText(),"This contract has been successfully published");
    }

    public ContractsPage clickBtn (String btn) throws Exception{
        getWebElementNamed(btn).click();
        switch (btn){
            case "ViewItems":
                return new ContractManageItemsPage();
            case "Sharing":
                return new ContractsSharingPage();
            case "Items":
                return new ContractManageItemsPage();
        }
        return new ContractManageItemsPage();
    }

}
