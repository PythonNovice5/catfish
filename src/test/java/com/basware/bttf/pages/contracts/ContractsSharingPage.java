package com.basware.bttf.pages.contracts;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractsSharingPage extends ContractsPage{

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/contracts/sharing/share";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Sharing";
    }

    public ContractsSharingPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@id='sharingOptions']")
    public WebElement SharingOptions;

    @FindBy(xpath = "//input[@value='Add']")
    public WebElement AddCommunity;

    @FindBy(linkText = "Items")
    public  WebElement Items;

    public ContractsSharingPage addOrg(String value){
        try {
            selectDropdownOptionByValue(SharingOptions, "2_ORG");
        }
        catch (NoSuchElementException e){
            selectDropdownOptionByValue(SharingOptions,"1_ORG");
        }
        AddCommunity.click();
        return new ContractsSharingPage();
    }

    public ContractsPage clickBtn (String btn) throws Exception{
        getWebElementNamed(btn).click();
        switch (btn){
            case "Items":
                return new ContractManageItemsPage();
        }
        return new ContractManageItemsPage();
    }
}
