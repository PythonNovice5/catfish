package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportStandardItems extends ProductManagerPage {


    public ImportStandardItems()
    {
        PageFactory.initElements(driver,this);
    }
    @Override
    public String getExpectedUrl() {
        return "/products/priceList/upload/";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Upload Price List Standard Items";
    }
}
