package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ContractUploadItemPage extends ContractsPage {

     @FindBy(id = "uploadBtn")
     private WebElement contractSelectFileButton;

     @FindBy(id= "uploadFileItem")
     private WebElement uploadItemButton;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/contracts/addItems/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Upload Items";
    }

    public ContractUploadItemPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void enterFileToUploadItems()
    {
        contractSelectFileButton.sendKeys(getFilePath()+"Contract_Upload_Items.csv");
        uploadItemButton.click();
    }

    public String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\generator\\test_data\\");
    }
}
