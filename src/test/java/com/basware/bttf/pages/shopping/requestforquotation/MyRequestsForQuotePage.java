package com.basware.bttf.pages.shopping.requestforquotation;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyRequestsForQuotePage extends ShoppingPage {
    public MyRequestsForQuotePage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/shopping/rfq?sortBy=expiry";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ: My RFQs";
    }

    @FindBy(xpath="//a[text()='Date Issued']")
    public WebElement DateIssuedTab;

    @FindBy(xpath="//table//td[2]")
    public WebElement YourReferenceFirstRecord;
}
