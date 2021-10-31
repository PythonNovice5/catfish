package com.basware.bttf.pages.contracts;


import com.basware.bttf.pages.shopping.requestforquotation.RequestQuotePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class ContractManageItemsPage extends ContractsPage {


    @FindBy(xpath = "//div[6]/div[3]/div/div[2]/span")
    private WebElement alertMessage;

    @FindBy(linkText = "Add to RFQ")
    public WebElement AddToRFQ;

    @FindBy(linkText = "Upload Items")
    public WebElement uploadItemsButton;

    @FindBy(linkText = ".NET")
    public WebElement itemToSelect;

    @FindBy(name = "_action_createLineItem")
    public WebElement createLineItemButton;

    @FindBy(name = "_action_createRFQ")
    public WebElement requestAQuote;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/contracts/manageItems/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Manage Items";
    }

    public ContractManageItemsPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void verifySuccessMessage()
    {
          assertEquals(alertMessage.getText(),"Changes successfully saved");
    }

    public MyContractPage navigateToPrevious(){
        driver.navigate().back();
        return new MyContractPage();
    }

    public RequestQuotePage clickBtn (String btn) throws Exception{
        getWebElementNamed(btn).click();
        switch (btn){
            case "AddToRFQ":
                return new RequestQuotePage();
            case "requestAQuote":
                clickOK();
                break;
        }
        return new RequestQuotePage();
    }

    public ContractUploadItemPage clickOnUploadItems()
    {
        waitUntillElementIsClickableAndClick(uploadItemsButton);
        return new ContractUploadItemPage();
    }

    public void selectItem()
    {
        waitUntillElementIsClickableAndClick(itemToSelect);
        waitUntillElementIsClickableAndClick(createLineItemButton);
    }


}
