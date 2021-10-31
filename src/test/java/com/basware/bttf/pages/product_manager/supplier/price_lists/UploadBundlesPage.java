package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadBundlesPage extends ProductManagerPage {

    public UploadBundlesPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceListLink/upload/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Upload Bundles";
    }

}
