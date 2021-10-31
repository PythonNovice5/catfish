package com.basware.bttf.pages.shopping.requestforquotation;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageRequestForQuotePage extends ShoppingPage {
    public ManageRequestForQuotePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Back to your results')]")
    public WebElement BackToResultsTab;

    @FindBy(name = "alertMessageDetail")
    public WebElement SuccessMessage;

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/shopping/rfqView/view/";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ: View Details";
    }

    public ShoppingPage clickBtn(String value){
        switch(value){
            case "Back to your results":
                BackToResultsTab.click();
                return new MyRequestsForQuotePage();
        }
        return null;
    }

}
