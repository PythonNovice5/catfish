package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.punchout.AmazonProductPage;
import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class AmazonSearchProductPage extends ProductManagerDirectoryPage {

   protected static Logger LOGGER = Logger.getLogger( AmazonSearchProductPage.class );

    @FindBy(xpath="//i[@aria-label='Prime Eligible']//..//..//i[@class='a-icon a-icon-checkbox']")
    public WebElement Prime;

    @FindBy(id="sp-cc-accept")
    public WebElement cookiesOnPage;

    @FindBy(xpath = "//a//span[text()='Amazon Basics Banded Bath Mat, Black']")
    public WebElement ProductToBeAdded;

    @FindBy(xpath = "//a//span[text()='Tetley One Cup Tea Bags Catering Pack (Pack of 1100)']")
    public WebElement ProductToBeAdded2;

    public AmazonSearchProductPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        if(props.get("Product").contains("Amazon Basics Banded Bath Mat Black"))
            return "https://www.amazon.co.uk/s?k=Amazon+Basics+Banded+Bath+Mat";
            return  "https://www.amazon.co.uk/s?k=Tetley+One+Cup+Tea+Bags+Catering+Pack";
    }

    public String getExpectedTitle()
    {
        return "Amazon.co.uk : "+ props.get("Product");

    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                        put( "Prime", Prime );
                }}
        );
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(new HashMap<String,WebElement>()
        {{
            put("RelevanceDummyOne",Prime);
        }});
    }

    public AmazonProductPage clickProductLink(String link) throws Exception{
        try{
        if (cookiesOnPage.isDisplayed()==true) {
            cookiesOnPage.click();
            waitUntilAnyAJAXIsCompleted();
            driver.navigate().back();
        }}
        catch (Exception e) {
            LOGGER.debug("Click on Product link " + link.toUpperCase());
            waitUntillElementIsClickableAndClick(getWebElementNamed(link));
            pauseFor(2000);
        }
        return new AmazonProductPage();
    }
}
