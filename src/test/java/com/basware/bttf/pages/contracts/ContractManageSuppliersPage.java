package com.basware.bttf.pages.contracts;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractManageSuppliersPage extends ContractsPage {


    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+"/contracts/manageSuppliers/index";
    }

    @Override
    public String getExpectedTitle() {
       return "Contracts: Manage Suppliers";
    }

    public ContractManageSuppliersPage()
    {
        PageFactory.initElements(driver,this);
    }


    public void clickOnItem()
    {

    }

}
