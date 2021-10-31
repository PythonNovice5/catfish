package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
//import jdk.internal.loader.AbstractClassLoaderValue;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonShoppingBasketPage extends AmazonBusinessPage {
    protected static Logger LOGGER = Logger.getLogger( AmazonShoppingBasketPage.class );
    @FindBy(id="hlb-approval-btn-announce")
    public WebElement SubmitForApproval;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBoxAmazonShoppingBasketPage;

    @FindBy(xpath="//span[@id=\"nav-search-submit-text\"]//following-sibling::input")
    public WebElement searchButtonAmazonShoppingBasketPage;

    public AmazonShoppingBasketPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return "https://www.amazon.co.uk/gp/";
    }

    public String getExpectedTitle()
    {
        return "Amazon.co.uk Shopping Basket";
    }

    public ShoppingPage clickSubmitForApproval(){
        LOGGER.debug("Click on Submit for approval button");

        waitUntillElementIsClickableAndClick(SubmitForApproval);

//        pauseFor(5000);
        return new ShoppingBasketPage();
    }

    public AmazonSearchProductPage clickSrchButton(){
        searchButtonAmazonShoppingBasketPage.click();
//        pauseFor(3000);
        return new AmazonSearchProductPage();
    }

}
