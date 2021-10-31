package com.basware.bttf.pages.shared;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RfqUtils
{
    public static void searchRFQ( WebDriver driver , String rfqTitle )
    {
        WebElement searchText = driver.findElement(By.id("keywords"));
        searchText.sendKeys(rfqTitle);
        WebElement searchButton = driver.findElement(By.name("btn-search"));
        searchButton.click();
    }

    public static void selectClassification(WebDriver driver, String category,String dropdown) throws Exception
    {
        Select levelCategory = new Select( driver.findElement(By.id(dropdown)));
        Thread.sleep(1000);
        levelCategory.selectByVisibleText(category);
        Thread.sleep(1000);
    }

    public static void clickOnDoneCategoryButton(WebDriver driver)
    {
        WebElement doneButton = driver.findElement(By.cssSelector("button.btn.btn-primary.done"));
        doneButton.click();
    }
}

