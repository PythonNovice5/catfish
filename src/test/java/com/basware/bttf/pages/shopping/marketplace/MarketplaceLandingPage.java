package com.basware.bttf.pages.shopping.marketplace;
// Created by Julian Sheppard on 21/04/2017

import com.basware.bttf.pages.AbstractPage;
import com.basware.bttf.pages.external.OfficeDepot.OfficeDepotHomePage;
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

public class MarketplaceLandingPage extends ShoppingPage {
    // Page title area fields
    @FindBy(xpath = "//div[contains(@class,'page-title')]")
    public WebElement PageTitle;

    @FindBy(id="contractReferenceDetails_0")
    public WebElement ContractRef;

    @FindBy(id="newUI")
    public WebElement NewUIToggle;

    @FindBy(xpath = "//div[normalize-space(text())='My lists']/..//a")
    public WebElement firstList;

    @FindBy(id="supplierItemIDDetails_0")
    public WebElement firstItemId;

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

    @FindBy(id="lbl_categories")
    public WebElement CategoriesLink;

    @FindBy(xpath = "//div[@class='pull-right row inline-flex hidden-xs']//span[text()='Quotes']")
    public WebElement Quotes;

    @FindBy(css = "[title='Amazon For Business Punchout']")
    public WebElement AmazonBusiness;

    @FindBy(css = "[title ='OCI Jupiter']")
    public WebElement OCIJupiter;

    @FindBy(xpath = "//*[contains(text(),'DPO TO JUPITER')]")
    public WebElement DPOJupiter;

    @FindBy(xpath = "//*[@title='Office Depot']")
    public WebElement OfficeDepot;

    @FindBy(xpath = "//*[@title='OCIToJupiterAngularFoxfish']")
    public WebElement OCIToJupiterAngularFoxfish;

    @FindBy(xpath = "//*[@title='DPOToJupiterAngCXML']")
    public WebElement DPOToJupiterAngCXML;


    protected static Logger LOGGER = Logger.getLogger(MarketplaceLandingPage.class);

    public MarketplaceLandingPage() {
        PageFactory.initElements(driver, this);
    }

    public String getExpectedUrl() {
        return getBaseUrl() + "/ui/shopping/marketplace/landingpage";
    }

    public String getExpectedTitle() {
        return ": Home";
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
//        pauseFor(3000);
        pauseFor(1000);
        waitUntillElementIsClickableAndClick(ListsIcon);
        waitUntillElementIsClickableAndClick(firstList);
//        clickWebElement(firstList);
        return new ShoppingListsPage();
    }

    public ShoppingBasketPage clickBasketButton() throws Exception {
        pauseFor(500);
        BasketIcon  = driver.findElement(By.name("basketButtonIcon"));
        waitUntillElementIsClickableAndClick(BasketIcon);
        return new ShoppingBasketPage();
    }

    public MarketplaceLandingPage switchToNewUI(){
        clickWebElement(NewUIToggle);
        pauseFor(2000);
        return new MarketplaceLandingPage();
    }

    public MarketplaceSearchResultsPage clickSearchButton() throws Exception {
        waitUntillElementIsClickableAndClick(SearchButton);
        driver.navigate().refresh();
        waitUntilDisplayed(SearchButton);
        return new MarketplaceSearchResultsPage();
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
//        WebElement elemToBeHovered = driver.findElement(By.cssSelector("[title='Lists']"));
        hoverToElement(ListsIcon);
        waitUntillElementIsClickableAndClick(ListsIcon);
        return new MarketplaceLandingPage();
    }

    public ShoppingListsPage verifyAndClickList(String listName) {
        listName = "'" + listName + "'";
        WebElement wb = driver.findElement(By.xpath("//span[contains(text()," + listName + ")]"));
        hoverToElement(wb);
        waitUntillElementIsClickableAndClick(wb);
        return new ShoppingListsPage();
    }

    public MarketplaceLandingPage searchCat(String searchName, String category) throws Exception{

        waitUntilDisplayed(CategoriesLink);
        String catg = "'"+category+"'";
        WebElement cat = driver.findElement(By.xpath("//span[contains(text(),"+ catg+")]"));
        cat.click();
        pauseFor(2500);

        String srch = "'"+searchName+"'";

        WebElement srch2 = driver.findElement(By.xpath("//a[contains(text(),"+ srch+")]"));
        srch2.click();

        String itemIDText = getTextOfWebElement(firstItemId);
        LOGGER.debug(itemIDText);
        Assert.assertEquals("Verifying item in category",itemIDText,"CF53-UOM-Test-kits");
        return new MarketplaceLandingPage();
    }

    public AbstractPage clickLink(String link){
        switch(link){
            case "OCI Jupiter":
                waitUntillElementIsClickableAndClick(OCIJupiter);
                pauseFor(5000);
                return new MarketplaceLandingPageJupiter();
            case "DPO TO JUPITER":
                waitUntillElementIsClickableAndClick(DPOJupiter);
                pauseFor(5000);
                return new MarketplaceLandingPageJupiter();
            case "OfficeDepot":
                waitUntillElementIsClickableAndClick(OfficeDepot);
                return new OfficeDepotHomePage();
            case "OCIToJupiterAngularFoxfish":
                waitUntillElementIsClickableAndClick(OCIToJupiterAngularFoxfish);
//                waitUntilPageDocumentIsCompleted();
                pauseFor(5000);
                return new MarketplaceLandingPageJupiter();
            case "DPOToJupiterAngCXML":
                waitUntillElementIsClickableAndClick( DPOToJupiterAngCXML);
                pauseFor(5000);
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
