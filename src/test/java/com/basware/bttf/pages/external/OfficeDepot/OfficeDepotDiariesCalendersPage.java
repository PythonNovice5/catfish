package com.basware.bttf.pages.external.OfficeDepot;

import com.basware.bttf.pages.external.ExternalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficeDepotDiariesCalendersPage extends ExternalPage {

        public OfficeDepotDiariesCalendersPage()
        {
            PageFactory.initElements( driver , this );
        }

        public String getExpectedUrl() { return "https://ibsdgb-sqm.officedepot.eu/catalog/browseCatalog"; }

        public String getExpectedTitle()
        {
            return "Diaries - Diaries, Calendars & Planners - Office Supplies at Office Depot";
        }

    @FindBy(xpath = "//*[@value='5108697']//..//input[starts-with(@id,'quantity')]")
    public WebElement NiceDiaryItemQuantity;

    @FindBy(xpath = "//*[@value='5108697']//..//input[@title='Add To Basket']")
    public WebElement AddToBasket;

    public OfficeDepotFindYourProductPage clickOnElem(String elem) throws Exception {
        waitUntillElementIsClickableAndClick(AddToBasket);
        return new OfficeDepotFindYourProductPage();
    }

}
