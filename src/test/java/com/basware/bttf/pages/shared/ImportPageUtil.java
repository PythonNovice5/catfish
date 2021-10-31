package com.basware.bttf.pages.shared;

import com.basware.bttf.pages.product_manager.supplier.price_lists.ManagePriceListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class ImportPageUtil {

    public static String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\testdata\\temp\\");
    }

    public static void uploadFile(WebDriver driver, String fileName)
    {
        driver.findElement(By.id("uploadBtn")).sendKeys(getFilePath()+fileName);
    }

    public static ManagePriceListPage clickOnUploadButton(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("uploadFileSubmit")).click();
        Thread.sleep(5000);
        return new ManagePriceListPage();
    }

    public static void selectUploadAction(WebDriver driver,String action)
    {
        Select actionDropDown = new Select( driver.findElement(By.id("uploadSelectActions")));
        actionDropDown.selectByVisibleText(action);
    }
}
