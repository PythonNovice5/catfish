package com.basware.bttf.pages.product_manager.buyer.categories;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManageCategoriesPage extends ProductManagerPage {
    String publishBtn = "//input[@value='Publish']";

    public ManageCategoriesPage() {
        PageFactory.initElements(driver, this);
    }

    public String getExpectedTitle() {
        return "Manage Categories";
    }

    public String getExpectedUrl() {
        return getBaseUrl() + "/products/presetSearches/manage";
    }

    public ManageCategoriesPage clickHeading() throws Exception {
        //click on drop down button
        clickByXpath("//span[@class='caret']");
        pauseFor(2500);
        clickByXpath("//a[text()='Heading']");
//        pauseFor(3000);
        return new ManageCategoriesPage();
    }

    public ManageCategoriesPage clickCategory() throws Exception {
        //click on drop down button
        clickByXpath("//span[@class='caret']");
        pauseFor(1000);
        clickByXpath("//a[text()='Category']");
//        pauseFor(3000);
        return new ManageCategoriesPage();
    }

    public ManageCategoriesPage enterDetailsHeading(String name, String desc, int ind) throws Exception {

        List<WebElement> headingName = driver.findElements(By.xpath("//div[@class='row item heading']//input[@type='text']"));
        pauseFor(1000);
        headingName.get(ind).click();
        headingName.get(ind).sendKeys(name);
        return new ManageCategoriesPage();
    }

    public ManageCategoriesPage enterDetailsCategory(String name, String desc, int index) throws Exception {
        List<WebElement> catName = driver.findElements(By.xpath("//div[contains(text(),'Category')]/following-sibling::div//input[@type='text']"));
        List<WebElement> search = driver.findElements(By.xpath("//textarea[contains(@name,'search')]"));
        //textarea[contains(@name,'search')]
        pauseFor(1000);
        catName.get(index).click();
        catName.get(index).sendKeys(name);
        pauseFor(1000);
        search.get(index).click();
        search.get(index).sendKeys(desc);
        return new ManageCategoriesPage();
    }

    public ManageCategoriesPage clearData() throws Exception {
//        clearAllData();
        try {
            List<WebElement> minus = driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-minus']"));
            for (int i = 0; i < minus.size(); i++) {
                if (minus.get(i).isDisplayed()) {
                    minus.get(i).click();
                    pauseFor(2500);
                }
            }
        } catch (ElementNotVisibleException e) {
            LOGGER.debug("Minus button was not found");
        }
        return new ManageCategoriesPage();
    }

    public ManageCategoriesPage clickPublish(){
        clickByXpath(publishBtn);
        return new ManageCategoriesPage();
    }

    public ManageCategoriesPage validateSuccessMsg(){
        verifyMsgInfo("categories have been published to Marketplace.");
        return new ManageCategoriesPage();
    }

    private void verifyMsgInfo(String msg)
    {
        WebElement msgInfo = driver.findElement(By.xpath("//span[contains(text(),'"+msg+"')]"));
        LOGGER.debug("Successfully verified the success message");
    }
}