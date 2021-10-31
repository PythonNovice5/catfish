package com.basware.bttf.pages.external.punchout;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductPage extends AmazonBusinessPage {
    protected static Logger LOGGER = Logger.getLogger( AmazonSearchProductPage.class );

    public AmazonProductPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        if(props.get("Product").contains("Amazon Basics Banded Bath Mat Black"))
         return "https://www.amazon.co.uk/AmazonBasics-";
         return  "https://www.amazon.co.uk/Tetley-Bags-Catering-Pack-1100/";
    }

    public String getExpectedTitle()
    {   if(props.get("Product").contains("Amazon Basics Banded Bath Mat Black"))
                return "Amazon Basics Banded Bath Mat, Black: Amazon.co.uk: Kitchen & Home";
        return  props.get("Product") + ": Amazon.co.uk: Business, Industry & Science";
    }

//    @FindBy(xpath = "//div[@id='shipsFromSoldBy_feature_div']")
    @FindBy(id="shipsFromSoldByInsideBuyBox_feature_div")
    public WebElement DispatchedBy;

    @FindBy(xpath = "//div[@id='shipsFromSoldByInsideBuyBox_feature_div']")
    public WebElement DispatchedBy_2;

    @FindBy(id = "add-to-cart-button")
    public WebElement AddToBasket;

    public AmazonProductPage verifyDispatchedBy(String status){
        String s = DispatchedBy.getAttribute("innerHTML");
//        String s2 = DispatchedBy_2.getAttribute("innerHTML");
        if(status.contentEquals("is")) {
//            Assert.assertTrue("The product is not dispatched by Amazon", s.contains("Dispatched and sold by Amazon")||s2.contains("Dispatched and sold by Amazon"));
            Assert.assertTrue("The product is not dispatched by Amazon", s.contains("Dispatched from and sold by Amazon") ||s.contains("Dispatched and sold by Amazon"));
            LOGGER.debug("Product is found to be dispatched and sold by Amazon");
        }
        else{
        Assert.assertFalse("The product is dispatched by Amazon which is not expected", s.contains("Dispatched and sold by Amazon"));
        LOGGER.debug("Product is not being dispatched by Amazon");
        }
        return new AmazonProductPage();
    }

    public AmazonBusinessPage clickButton(String btn) throws Exception{
        AddToBasket.click();
        switch (btn){
            case "AddToBasket":
                return new AmazonShoppingBasketPage();
        }
        return null;
    }
}
