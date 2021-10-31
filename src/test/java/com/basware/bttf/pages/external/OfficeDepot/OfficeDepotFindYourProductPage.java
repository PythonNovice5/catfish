package com.basware.bttf.pages.external.OfficeDepot;

import com.basware.bttf.pages.external.ExternalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficeDepotFindYourProductPage extends ExternalPage {

    public OfficeDepotFindYourProductPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return "https://ibsdgb-sqm.officedepot.eu/catalog/searchRouter"; }

    public String getExpectedTitle()
    {
        return "Office Supplies: Office Products and Office Furniture: Office Depot";
    }

    @FindBy(xpath = "//a[text()='Shopping Basket']")
    public WebElement ShoppingBasket;

    public OfficeDepotShoppingBasketPage clickThisElem(String elem) throws Exception {
        waitUntillElementIsClickableAndClick(ShoppingBasket);
        return new OfficeDepotShoppingBasketPage();
    }
}
