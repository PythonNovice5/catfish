package com.basware.bttf.pages.contracts;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ContractUploadSuppliersPage extends ContractsPage {

    @FindBy(id = "uploadBtn")
    private WebElement uploadSupplier;

    @FindBy(id = "uploadFileSuppliers")
    private WebElement uploadSuppliersButton;



    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/contracts/addSuppliers/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Upload Suppliers";
    }

    public ContractUploadSuppliersPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void enterFileToUploadSuppliers()
    {
        uploadSupplier.sendKeys(getFilePath()+"Contract_Suppliers.csv");
    }

    public void clickOnUploadSupplierButton()
    {
        uploadSuppliersButton.click();
    }



    public String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\generator\\test_data\\");
    }

}