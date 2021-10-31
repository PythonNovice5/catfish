package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonBusinessPage extends ExternalPage {

    protected static Logger LOGGER = Logger.getLogger( AmazonBusinessPage.class );

    @FindBy(xpath="//input[@value='Go']")
    public WebElement searchBtnAmazon;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBoxAmazon;

    @FindBy(xpath = "//span[text()='Amazon.co.uk']")
    public WebElement AmazonBusinessTitle;

    public AmazonBusinessPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return "https://www.amazon.co.uk/ref=nodl_punchout";
    }

    public String getExpectedTitle()
    {
        return "Amazon Business";
    }

    public AmazonSearchProductPage clickSrchButton(){
        searchBtnAmazon.click();
        pauseFor(3000);
        return new AmazonSearchProductPage();
    }

    public void enterInSearchBox(String value)
    {
        waitUntilDisplayed(searchBoxAmazon);
        searchBoxAmazon.sendKeys(value);

    }
}
