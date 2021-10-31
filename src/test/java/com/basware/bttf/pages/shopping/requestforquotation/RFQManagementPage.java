package com.basware.bttf.pages.shopping.requestforquotation;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RFQManagementPage extends ShoppingPage {
    public RFQManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/shopping/rfqManagement";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ: My RFQs";
    }

    @FindBy(xpath = "//a[contains(text(),'Request a Quote')]")
    public WebElement RequestQuote;

    public RequestQuotePage clickRFQElement(String value) throws Exception{

        switch(value){
            case "Request a Quote":
                value = "RequestQuote";
                break;
        }
        getWebElementNamed(value).click();
        return new RequestQuotePage();
    }
}
