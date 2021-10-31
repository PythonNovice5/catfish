package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.support.PageFactory;

public class UploadFrameworkItemsPage extends ProductManagerPage {

    public UploadFrameworkItemsPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl(){
        return getBaseUrl() + "/products/agreements/uploadFrameworkItems";
    }
    @Override
    public String getExpectedTitle(){
        return "Import";
    }

}
