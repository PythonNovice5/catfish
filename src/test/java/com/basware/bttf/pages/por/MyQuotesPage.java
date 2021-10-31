package com.basware.bttf.pages.por;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyQuotesPage extends ShoppingPage {

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/por/index";
    }

    @Override
    public String getExpectedTitle() {
        return "My quotes";
    }



    @FindBy(xpath = "//strong[text()='Ready']//..//..//..//span[@title='View']")
    public WebElement ViewQuote;

    public MyQuotesPage(){
        PageFactory.initElements(driver,this);
    }

    public ViewPriceOnRequestPage clickMyQuotesBtns(String btn){
        switch (btn){
            case "ViewQuote":
                ViewQuote.click();
        }
        return new ViewPriceOnRequestPage();
    }


}
