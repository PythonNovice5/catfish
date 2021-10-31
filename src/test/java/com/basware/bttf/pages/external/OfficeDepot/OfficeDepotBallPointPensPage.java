package com.basware.bttf.pages.external.OfficeDepot;

import com.basware.bttf.pages.external.ExternalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OfficeDepotBallPointPensPage extends ExternalPage {
    public OfficeDepotBallPointPensPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl() { return "https://ibsdgb-sqm.officedepot.eu/catalog/browseCatalog"; }

    public String getExpectedTitle()
    {
        return "Ballpoint Pens - Pens, Pencils & Writing - Office Supplies at Office Depot";
    }

    @FindBy(name = "entryFormList[0].qty")
    public WebElement BallPointPenQuantity;

    @FindBy(name = "cmd_addCart.button.INDEX[0]")
    public WebElement AddToBasket;

    public OfficeDepotFindYourProductPage clickOnElem(String elem) throws Exception {
        waitUntillElementIsClickableAndClick(AddToBasket);
        return new OfficeDepotFindYourProductPage();
    }

}
