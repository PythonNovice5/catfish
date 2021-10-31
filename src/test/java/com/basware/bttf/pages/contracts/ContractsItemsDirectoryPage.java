package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractsItemsDirectoryPage extends SupplierContractsPage {

    public ContractsItemsDirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/contractItems/index/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Item directory";
    }

    @FindBy(linkText = "Create")
    public WebElement createItemButton;

    @FindBy(linkText = "Done")
    public WebElement doneButton;

    public SupplierContractsPage clickBtn (String btn) throws Exception{

        switch (btn){
            case "Create Item":
                waitUntillElementIsClickableAndClick(createItemButton);
                break;
            case "Done":
                waitUntillElementIsClickableAndClick(doneButton);
               return new SupplierContractsPage();
        }
        return new ContractsCreateItemPage();
    }
}
