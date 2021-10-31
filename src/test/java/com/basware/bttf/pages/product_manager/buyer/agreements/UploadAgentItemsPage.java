package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.util.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAgentItemsPage extends ProductManagerPage {

    @FindBy(id ="uploadFileSubmit")
    private WebElement agentUploadButton;

    @FindBy(id = "uploadBtn")
    private WebElement selectFileButton;

    @FindBy(id = "contentType")
    private  WebElement contentTypeDropDown;

    @FindBy(linkText = "Back")
    private WebElement back;

    @FindBy(id = "importResults")
    private WebElement importResults;

    public UploadAgentItemsPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl(){
        if (props.get(TestConstants.ORG_AGREEMENT_NAME).contains("Framework"))
            return getBaseUrl() + "/products/agreements/uploadFrameworkItems";
        return getBaseUrl() + "/products/agreements/uploadAgentItems";
    }

    @Override
    public String getExpectedTitle(){
        return "Import";
    }

    public void enterAgentFileToUpload(String fileType, String fileName){

        selectFileButton.sendKeys(getFilePath() + fileName);
    }

    public void clickOnUploadButton()
    {
        agentUploadButton.click();
    }

    public void selectUploadType(String option)
    {
       selectDropdownOption(contentTypeDropDown , option);
    }

    public ManageAgreementPage clickOnBack()
    {
        waitUntilDisplayed(importResults);
        waitUntillElementIsClickableAndClick(back);
        return new ManageAgreementPage();
    }

}
