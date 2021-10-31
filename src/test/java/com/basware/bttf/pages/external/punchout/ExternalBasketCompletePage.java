package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import com.basware.bttf.util.TestConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExternalBasketCompletePage extends ExternalPage {

    public ExternalBasketCompletePage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return "https://jupiter-buyers.procserveonline.com/punchout-test-tool/alusta-basket-complete";
    }

    public String getExpectedTitle()
    {
        return "Punchout Test Tool";
    }

    @FindBy(id="ORG_ID")
    public WebElement orgID;

    @FindBy(id="SHARED_SECRET")
    public WebElement sharedSecret;

    @FindBy(id="USER_NAME")
    public WebElement userName;

    @FindBy(id="environment")
    public WebElement environment;

    @FindBy(id="submit")
    public WebElement submitBtn;

    public ExternalBasketCompletePage selectValue(String field, String value) throws Exception {
        value= testEnv.toUpperCase();
        selectDropdownOptionByText(environment,value);
        return new ExternalBasketCompletePage();
    }

    public ExternalBasketCompletePage clickButton(String btn){
        switch(btn){
            case "Submit":
                waitUntillElementIsClickableAndClick(submitBtn);
                break;
        }
        return new ExternalBasketCompletePage();
    }
}


