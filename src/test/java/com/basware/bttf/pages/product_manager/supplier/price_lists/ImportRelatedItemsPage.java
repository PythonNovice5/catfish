package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.support.PageFactory;

public class ImportRelatedItemsPage extends ProductManagerPage {


    public ImportRelatedItemsPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl() {
        return "/products/priceListLink/upload/";
    }

    @Override
    public String getExpectedTitle() {
        return "Import related item links";
    }
}
