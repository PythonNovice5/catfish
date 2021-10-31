package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractsSuppliersPage extends ContractsPage{


    @FindBy(linkText = "Select Suppliers")
    private WebElement selectSupplier;

    @FindBy(linkText = "Upload Suppliers")
    private WebElement uploadSuppliers;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/manageSuppliers/index/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Manage Suppliers";
    }

    public ContractsSuppliersPage()
    {
        PageFactory.initElements(driver,this);
    }

    public ContractsPage clickOnSuppliersButton(String button)
    {
        ContractsPage page = null;
        switch(button){
            case "upload suppliers":
                uploadSuppliers.click();
                page = new ContractUploadSuppliersPage();
                break;
            case "select suppliers":
                selectSupplier.click();
                page = new AddContractSupplierPage();
                break;
        }
        return page;
    }
}
