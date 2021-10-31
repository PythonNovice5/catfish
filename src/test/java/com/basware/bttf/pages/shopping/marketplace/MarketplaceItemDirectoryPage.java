package com.basware.bttf.pages.shopping.marketplace;

import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.quickQuote.CreateRfqPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class
MarketplaceItemDirectoryPage extends ShoppingPage {

    protected static Logger LOGGER = Logger.getLogger( MarketplaceItemDirectoryPage.class );

    public MarketplaceItemDirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }
    public String getExpectedUrl() { return getBaseUrl() + "/ui/shopping/itemview/searchDps/"; }

    public String getExpectedTitle()
    {
        return "Marketplace: Item Directory";
    }

    @FindBy(xpath = "//*[@name=\"Red\"]//..")
    public WebElement RedCheckBox;

    @FindBy(xpath = "//div[contains(text(),'Supplier Item ID:')]//..//..//input//..")
    public WebElement SelectItemCheckBox;

    @FindBy(xpath = "//button[contains(text(),'Get quotes')]")
    public WebElement getQuotes;

    public MarketplaceItemDirectoryPage clickButton(String elem) throws Exception{
        waitUntillElementIsClickableAndClick(getWebElementNamed(elem));
        return new MarketplaceItemDirectoryPage();
    }

    public CreateRfqPage getQuoteForItem(){
        waitUntillElementIsClickableAndClick(getQuotes);
        return new CreateRfqPage();
    }

}
