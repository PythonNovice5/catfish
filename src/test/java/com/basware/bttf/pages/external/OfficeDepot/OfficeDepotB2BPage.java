package com.basware.bttf.pages.external.OfficeDepot;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficeDepotB2BPage extends ExternalPage {
    public OfficeDepotB2BPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return "https://ibsdgb-sqm.officedepot.eu/b2b/shoppingCart"; }

    public String getExpectedTitle()
    {
        return "Office Supplies: Office Products and Office Furniture: Office Depot";
    }

    @FindBy(xpath = "//input[@title='Continue']")
    public WebElement continueButton;

    public ShoppingBasketPage clickThisElem(String elem) throws Exception {
        waitUntillElementIsClickableAndClick(continueButton);
        return new ShoppingBasketPage();
    }
}
