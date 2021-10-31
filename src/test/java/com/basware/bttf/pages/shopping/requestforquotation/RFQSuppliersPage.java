package com.basware.bttf.pages.shopping.requestforquotation;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RFQSuppliersPage extends ShoppingPage {
    @FindBy(xpath = "//table/tbody/tr/td[2]/div[5]/div/a")
    private WebElement selectSupplier;

    public RFQSuppliersPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/shopping/suppliers/index";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ: Suppliers";
    }

    @FindBy(name = "btn-search")
    public WebElement SearchButton;

    @FindBy(id = "keywords")
    public WebElement SearchKeywords;


    @FindBy(xpath = "//table/tbody//td//a")
    public WebElement AddButton;


    @FindBy(xpath = "//a[contains(@href,'save')]")
    public WebElement SaveButton;

    @FindBy(linkText = "Cancel")
    public WebElement cancelButton;

    @FindBy(tagName = "strong")
    public WebElement supplierResultCount;

    public ShoppingPage clickButton(String btn) throws Exception {
        ShoppingPage page = null;
        WebElement element=null;
        switch (btn) {
            // buttons:
            case "Search":
                element = SearchButton;
                page = new RFQSuppliersPage();
                break;
            case "SearchKeywords":
                element = SearchKeywords;
                page = new RFQSuppliersPage();
                break;
            case "AddSupplier":
                element = AddButton;
                page = new RFQSuppliersPage();
                break;
            case "Save":
                element = SaveButton;
                page = new RequestQuotePage();
                break;
            case "Cancel":
                element = cancelButton;
                page = new RequestQuotePage();
                break;
        }
        element.click();
        pauseFor(2000);
        return page;
    }

    public String currentSupplierCount()
    {
        return supplierResultCount.getText();
    }

    public void selectSupplierFilters(String filterName)
    {
        waitUntillElementIsClickableAndClick(driver.findElement(By.linkText(filterName)));
    }
}