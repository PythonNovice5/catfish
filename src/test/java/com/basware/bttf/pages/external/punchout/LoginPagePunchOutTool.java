package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePunchOutTool extends ExternalPage {
    protected static Logger LOGGER = Logger.getLogger( LoginPagePunchOutTool.class );
        public LoginPagePunchOutTool()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return "https://jupiter-buyers.procserveonline.com/punchout-test-tool/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Punchout Test Tool";
    }

    public void loadPunchOutPage(WebDriver driver)
    {
        driver.get( "https://developer:aEL9MINurCK0jTbcOuNQ@jupiter-buyers.procserveonline.com/punchout-test-tool/index");
    }

    @FindBy(xpath = "//a[text()='ALUSTA']")
    public WebElement alustaLink;

    @FindBy(xpath = "//a[text()='BASKET COMPLETE']")
    public WebElement basketComplete;

    public ProductManagerPage clickLink(String linkValue, String value){
        WebElement elemToClick = driver.findElement(By.xpath(String.format("//a[text()='%s']//..//following-sibling::td[text()='%s']//following-sibling::td//a[text()='%s']",testEnv.toUpperCase(),value,linkValue)));
        elemToClick.click();
        switch (linkValue){
            case "VIEW":
                switchToNewWindow(new PunchOutFormPage());
                return(new PunchOutFormPage());
        }
        switchToNewWindow(new MarketplaceLandingPage());
        return new MarketplaceLandingPage();
    }

    public ProductManagerPage clickLink(String linkValue){
            switch(linkValue){
                case "ALUSTA":
                    waitUntillElementIsClickableAndClick(alustaLink);
                    break;
                case "Basket Complete":
                    waitUntillElementIsClickableAndClick(basketComplete);
                    return new ExternalBasketCompletePage();
            }
            return new LoginPagePunchOutTool();
    }

}