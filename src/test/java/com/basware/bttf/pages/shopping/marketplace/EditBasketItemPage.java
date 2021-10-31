package com.basware.bttf.pages.shopping.marketplace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditBasketItemPage extends ShoppingBasketPage {

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/shopping/itemview";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Edit Basket Item";
    }

    @FindBy(xpath = "//div[contains(@class,'page-title')]")
    public WebElement PageTitle;

    @FindBy( name="itemFavouritesButtonIcon" )
    public WebElement ListsIcon;

    @FindBy( name="basketButtonIcon" )
    public WebElement BasketIcon;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']")
    public WebElement CompareText;

    @FindBy(xpath = "//div[text()='My Lists']/..//a")
    public WebElement firstList;

    public ShoppingBasketPage clickBasketButton() throws Exception
    {
        waitUntilDisplayed( BasketIcon );
        scrollToElement( BasketIcon );  // click sometimes doesn't work if the element is scrolled out of sight
        BasketIcon.click();
        return new ShoppingBasketPage();
    }

    public ItemComparisonPage clickCompareButton() throws Exception
    {
        waitUntilDisplayed( CompareText );
        scrollToElement( CompareText );  // click sometimes doesn't work if the element is scrolled out of sight
        CompareText.click();
        return new ItemComparisonPage();
    }

    public ShoppingListsPage clickListsButton() throws Exception
    {
        waitUntilDisplayed( ListsIcon );
        scrollToElement( ListsIcon );  // click sometimes doesn't work if the element is scrolled out of sight
        ListsIcon.click();
        waitUntillElementIsClickableAndClick(firstList);
        return new ShoppingListsPage();
    }
}
