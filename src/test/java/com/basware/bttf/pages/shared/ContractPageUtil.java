package com.basware.bttf.pages.shared;

import com.basware.bttf.pages.contracts.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContractPageUtil {

    public ContractsPage clickOnContractTab(String tabName, WebDriver driver) {
        ContractsPage page = null;
        WebElement tab = driver.findElement(By.linkText(tabName));
        switch (tabName) {
            case "Items":
                tab.click();
                page = new ContractManageItemsPage();
                break;
            case "Item Attributes":
                tab.click();
                page = new ContractItemAttributesPage();
                break;
            case "Contract":
                tab.click();
                page = new MyContractPage();
                break;
            case "Suppliers":
                tab.click();
                page = new ContractsSuppliersPage();
                break;
            case "Attachments":
                tab.click();
                page = new ContractAttachmentsPage();
                break;
            case "Categories" :
                tab.click();
                page = new ContractCategoryPage();
                break;
        }
        return page;
    }

}
