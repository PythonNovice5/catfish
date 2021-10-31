package com.basware.bttf.pages.shopping.freetextrequisitions;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FTRSuppliersPage extends ShoppingPage {

    @FindBy(xpath = "//table/tbody/tr/td[2]/div[5]/div/a")
    private WebElement selectSupplier;

    public FTRSuppliersPage()
    {
        PageFactory.initElements(driver,this);
    }
    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/shopping/suppliers/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "FTR: Suppliers";
    }

    public FTREditPage selectSupplierForFTR(String supplier)
    {
        searchSupplier(supplier);
        selectSupplier.click();
        return new FTREditPage();
    }
}
