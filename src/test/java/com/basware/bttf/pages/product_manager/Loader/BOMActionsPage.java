package com.basware.bttf.pages.product_manager.Loader;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
//import jdk.javadoc.internal.doclets.toolkit.PropertyUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import sun.awt.windows.WEmbeddedFrame;

public class BOMActionsPage extends ShoppingPage {


    public BOMActionsPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/ui/bom/actions/";
    }

    @Override
    public String getExpectedTitle() {
        return "BOM Actions";
    }

    @FindBy(xpath = "//label[@for='chk_marketplace.bom.filters.matched-input']")
    public WebElement matchedFilterRadioButton;

    @FindBy(css = "#acc_processingResults .mat-expansion-indicator")
    public WebElement expandArrowBtn;

    @FindBy(css = ".fa-check")
    public WebElement rightTick;

    @FindBy(xpath = "//*[@role='region']//*[@title='BOM Item Test']")
    public WebElement firstItemName;

    @FindBy(id="btn_add-to-basket")
    public WebElement addToBasketButton;

    public BOMActionsPage clickRadioButton(String btn_name) {
        switch (btn_name) {
            case "matchedFilter":
                waitUntillElementIsClickableAndClick(matchedFilterRadioButton);
        }

        return new BOMActionsPage();
    }

    public ShoppingPage clickTheButton(String btn_name) {
        switch (btn_name) {
            case "ExpandArrow":
                waitUntillElementIsClickableAndClick(expandArrowBtn);
                break;
            case "AddToBasket":
                waitUntillElementIsClickableAndClick(addToBasketButton);
                waitUntilNoModalPopup();
                return new ShoppingBasketPage();
            case "AddToBasketDiffCurrency":
                waitUntillElementIsClickableAndClick(addToBasketButton);
                return new BOMActionsPage();
        }
        return new BOMActionsPage();
    }

    public BOMActionsPage verifyItemMatch(String itemName) {

        waitUntilDisplayed(firstItemName);

        LOGGER.debug("####### VERIFYING THE MATCH #######\n");
        LOGGER.debug("Checking the presence of right tick ");
        assertTrue("Right tick was missing, match failed", rightTick.isDisplayed());


        LOGGER.debug("Checking the presence of item imported under matched section ");
        assertTrue("The item Name: " + itemName + " was not found under Matched section", firstItemName.isDisplayed());

        return new BOMActionsPage();
    }
}

