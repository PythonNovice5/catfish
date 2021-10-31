package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContractSupplierPage extends ContractsPage {


    @FindBy(id = "keywords")
    private WebElement inputKeyword;

    @FindBy(name = "btn-search")
    private WebElement searchButton;

    @FindBy(id = "selectedSuppliers")
    private  WebElement selectFirstSupplier;

    @FindBy(name = "contracts.suppliers_addSelectedSuppliers")
    private WebElement addSelectedButton;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/contractSuppliers/display/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Add Suppliers";
    }

    public AddContractSupplierPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void searchSupplier(String supplier)
    {
        inputKeyword.sendKeys(supplier);
        searchButton.click();
    }

    public void selectSupplier()
    {
        selectFirstSupplier.click();
    }

    public ContractManageSuppliersPage addSelectedSupplier()
    {
         addSelectedButton.click();
//         pauseFor(5000);
         return new ContractManageSuppliersPage();
    }
}
