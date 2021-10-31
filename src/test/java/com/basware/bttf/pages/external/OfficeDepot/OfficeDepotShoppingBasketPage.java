package com.basware.bttf.pages.external.OfficeDepot;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficeDepotShoppingBasketPage extends ExternalPage {

    public OfficeDepotShoppingBasketPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return "https://ibsdgb-sqm.officedepot.eu/cart/shoppingCart"; }

    public String getExpectedTitle()
    {
        return "Office Supplies: Office Products and Office Furniture: Office Depot";
    }

    @FindBy(xpath = "//*[@class='itemname']")
    public WebElement ItemDescription;

    @FindBy(xpath = "//a[text()='CheckOut']")
    public WebElement CheckOutBtn;

    public OfficeDepotB2BPage clickThisElem(String elem) throws Exception {
        waitUntillElementIsClickableAndClick(CheckOutBtn);
        return new OfficeDepotB2BPage();
    }

}
