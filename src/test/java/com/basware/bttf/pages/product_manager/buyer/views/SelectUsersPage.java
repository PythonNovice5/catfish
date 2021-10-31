package com.basware.bttf.pages.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.View;

public class SelectUsersPage extends ViewDirectoryPage {
    protected static Logger LOGGER = Logger.getLogger( ManageViewPage.class.getName() );

    public SelectUsersPage()
    {
        PageFactory.initElements(driver, this );
    }

    public String getExpectedTitle()
    {

        return "Product Manager: Select View Users";
    }

    public String getExpectedUrl(){

        return getBaseUrl() + "/products/manageUsers/index";
    }

    public ManageViewPage addUser(String user){
        switch(user) {
            case "whole organisation":
                try {
                    WebElement knob = driver.findElement(By.cssSelector("[title='Whole organisation is ON']"));
                    LOGGER.debug("Available toggle switch is found to be ON");
                }
                catch (NoSuchElementException ignored){
                    clickByXpath("//div[@class='toggle   null']");
                    pauseFor(2000);
                    LOGGER.debug("Available toggle switch is made ON from OFF..");
                }
                break;

            default:
                directoryInputSearch.click();
                directoryInputSearch.sendKeys(user);
                directoryButtonSearch.click();
                clickAddBtn("//span[@title='Add']");

        }
        clickDoneBtn();
        return new ManageViewPage();
    }

}
