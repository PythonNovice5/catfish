package com.basware.bttf.pages.shopping.marketplace;

import com.basware.bttf.pages.AbstractPage;
import com.basware.bttf.pages.external.punchout.AmazonBusinessPage;
import com.basware.bttf.pages.por.MyQuotesPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketplaceLandingPageJupiter extends ShoppingPage {

        // Page title area fields
        @FindBy(xpath = "//div[contains(@class,'page-title')]")
        public WebElement PageTitle;

        @FindBy(id="contractReferenceDetails_0")
        public WebElement ContractRef;

        @FindBy(id="newUI")
        public WebElement NewUIToggle;

        @FindBy(xpath = "//div[normalize-space(text())='My lists']/..//a")
        public WebElement firstList;

        @FindBy(name = "rfqButtonIcon")
        public WebElement QuotesIcon;

        @FindBy(xpath = "//div[@class='cdk-overlay-container']")
        public WebElement QuotesText;

        @FindBy(name = "rfqBadge")
        public WebElement QuotesCount;

        @FindBy(name = "itemFavouritesButtonIcon")
        public WebElement ListsIcon;

        @FindBy(xpath = "//div[@class='cdk-overlay-container']")
        public WebElement ListsText;

        @FindBy(name = "itemComparisonButtonIcon")
        public WebElement CompareIcon;

        @FindBy(xpath = "//div[@class='cdk-overlay-container']")
        public WebElement CompareText;

        @FindBy(name = "comparisonBadge")
        public WebElement CompareCount;

        @FindBy(name = "basketButtonIcon")
        public WebElement BasketIcon;

//    @FindBy(name = "basketButtonText")
//    public WebElement BasketText;

        @FindBy(xpath = "//div[@class='cdk-overlay-container']")
        public WebElement BasketText;

        @FindBy(name = "itemCount")
        public WebElement BasketCount;

        @FindBy(xpath = "//div[@id='marketPLaceBasketSummary']//span[@name='total']")
        public WebElement BasketValue;

        @FindBy(xpath = "//div[@id='marketPLaceBasketSummary']//span[@name='amount']")
        public WebElement BasketAmount;

        @FindBy(xpath = "//div[@id='marketPLaceBasketSummary']//span[@name='currency']")
        public WebElement BasketCurrency;

        // Page fields
        @FindBy(id = "marketplaceWelcomeMessage")
        public WebElement MarketplaceWelcomeMessage;

        @FindBy(id = "keywords")
        public WebElement SearchKeywords;

        @FindBy(id = "searchButton")
        public WebElement SearchButton;

        @FindBy(id = "navigation_prev-stage")
        public WebElement CarouselPreviousButton;

        @FindBy(id = "navigation_next-navigation")
        public WebElement CarouselNextButton;

        @FindBy(xpath = "//a[starts-with(@name,'navigation_image_')]")
        public List<WebElement> CarouselItems;

        @FindBy(name = "navigation_image_0")
        public WebElement FirstCarouselItem;

        @FindBy(xpath = "//p[starts-with(@id,'category_')]/a")
        public List<WebElement> Categories;

        @FindBy(xpath = "//div[@class='pull-right row inline-flex hidden-xs']//span[text()='Quotes']")
        public WebElement Quotes;

        @FindBy(css = "[title='Amazon For Business Punchout']")
        public WebElement AmazonBusiness;

        @FindBy(css = "[title ='OCI Jupiter']")
        public WebElement OCIJupiter;

        protected static Logger LOGGER = Logger.getLogger(MarketplaceLandingPageJupiter.class);

        public MarketplaceLandingPageJupiter() {
            PageFactory.initElements(driver, this);
        }

        public String getExpectedUrl() {
            return "https://jupiter-buyers.procserveonline.com" + "/ui/shopping/marketplace/landingpage";
        }

        public String getExpectedTitle() {
            return "Marketplace: Home";
        }

        // Returns the displayed text or value of the element
        public String getElementValue(String elementName) throws Exception {
            switch (elementName) {
                // By default, get the text within the element with the element name
                // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
                case "SearchKeywords":
                    return getAttributeValueOfWebElement(getWebElementNamed(elementName), "value");
                default:
                    return getTextOfWebElement(getWebElementNamed(elementName));
            }
        }

        public ShoppingListsPage clickListsButton() throws Exception {
            waitUntillElementIsClickableAndClick(ListsIcon);
            pauseFor(2000);
            clickWebElement(firstList);
//        clickWebElement(firstList);
            return new ShoppingListsPage();
        }

        public ShoppingBasketPage clickBasketButton() throws Exception {
            clickWebElement(BasketIcon);
            return new ShoppingBasketPage();
        }

        public MarketplaceLandingPage switchToNewUI(){
            clickWebElement(NewUIToggle);
            pauseFor(2000);
            return new MarketplaceLandingPage();
        }

        public MarketplaceSearchResultsPageJupiter clickSearchButton() throws Exception {
            waitUntillElementIsClickableAndClick(SearchButton);
            return new MarketplaceSearchResultsPageJupiter();
        }

        public ProductManagerPage clickMPBtns(String button) throws Exception{
            switch(button){
                case "Quotes":
                    waitUntillElementIsClickableAndClick(QuotesIcon);
                    return new MyQuotesPage();
            }
            return null;
        }


        public MarketplaceLandingPage hoverToMarketPlaceElement(String element) {
            WebElement elemToBeHovered = driver.findElement(By.cssSelector("[title='Lists']"));
            hoverToElement(elemToBeHovered);
            return new MarketplaceLandingPage();
        }

        public ShoppingListsPage verifyAndClickList(String listName) {
            listName = "'" + listName + "'";
            WebElement wb = driver.findElement(By.xpath("//a[contains(text()," + listName + ")]"));
            clickWebElement(wb);
            return new ShoppingListsPage();
        }

        public MarketplaceLandingPage searchCat(String searchName, String category){

            String catg = "'"+category+"'";
            WebElement cat = driver.findElement(By.xpath("//span[text()="+ catg+"]"));
            cat.click();
            pauseFor(2500);

            String srch = "'"+searchName+"'";
            WebElement srch2 = driver.findElement(By.xpath("//span[text()="+ catg+"]"+"//..//..//a[text()="+ srch+"]"));
            srch2.click();

            WebElement itemID = driver.findElement(By.xpath("//span[@id='supplierItemIDDetails_0']"));
            String itemIDText = itemID.getText();
            LOGGER.debug(itemIDText);
            Assert.assertEquals("Verifying item in category",itemIDText,"CF53-UOM-Test-kits");
            return new MarketplaceLandingPage();
        }


        public AbstractPage clickLink(String link){
            switch(link){
                case "OCI Jupiter":
                    waitUntillElementIsClickableAndClick(OCIJupiter);
                    return new MarketplaceLandingPageJupiter();

            }
            waitUntillElementIsClickableAndClick(AmazonBusiness);
            return new AmazonBusinessPage();
        }

        public WebElement getWebElement(String elem) throws Exception{

            return getWebElementNamed(elem);

        }

        public ItemComparisonPage clickOnElement(String value) throws Exception{
            waitUntillElementIsClickableAndClick(CompareIcon);
            return new ItemComparisonPage();
        }
    }

