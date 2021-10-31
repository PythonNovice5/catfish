package com.basware.bttf.pages.shopping.freetextrequisitions;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.support.PageFactory;

public class FreeTextRequisitionsIndexPage extends ShoppingPage {



    public FreeTextRequisitionsIndexPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/shopping/ftr_index?manage";
    }

    @Override
    public String getExpectedTitle() {
        return "FTR: My FTRs";
    }

    public void verifyNewlyCreatedFtr(String FTRReference)
    {
        driver.getPageSource().contains(FTRReference);
    }
}
