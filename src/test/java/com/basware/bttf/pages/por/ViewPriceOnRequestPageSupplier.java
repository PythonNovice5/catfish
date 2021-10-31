package com.basware.bttf.pages.por;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPriceOnRequestPageSupplier extends ShoppingPage {
    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/quote/view";
    }

    @Override
    public String getExpectedTitle() {
        return "View price on request";
    }

    public ViewPriceOnRequestPageSupplier(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="showQuoteAction")
    public WebElement QuoteSupplier;

    @FindBy(name ="price")
    public WebElement Unitprice;

    @FindBy(id="deliveryIncluded")
    public WebElement DeliveryCost;

    @FindBy(id="sendAction")
    public WebElement Send;



    public ProductManagerPage clickButtonSup(String btn) throws Exception{
       switch (btn){
            case "Quote":
                btn = "QuoteSupplier";
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
//                getWebElementNamed(btn).click();break;
            case "BacktoMyquotes":
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
                return new ViewPriceOnRequestPageSupplier();
            case "Send":
                waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
                waitUntilAnyAJAXIsCompleted();
//                pauseFor(5000);
                break;
        }
        return new ViewPriceOnRequestPageSupplier();
    }

    public ViewPriceOnRequestPageSupplier selectValueFrom(String dropdown,String value) throws Exception{
        pauseFor(1000);
        selectDropdownOptionByText(getWebElementNamed(dropdown),value);
        pauseFor(1000);
        return new ViewPriceOnRequestPageSupplier();
    }


}
