package com.basware.bttf.pages.product_manager.buyer.agreements;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import sun.awt.windows.WEmbeddedFrame;

import java.util.Iterator;
import java.util.List;


public class SelectSupplierPage extends ProductManagerPage
{

    protected static Logger LOGGER = Logger.getLogger( SelectSupplierPage.class.getName() );

    public SelectSupplierPage(){ PageFactory.initElements( driver , this );    }

    @Override
    public String getExpectedTitle(){ return "Supplier List"; }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/directory/supplier/list";
    }

    @FindBy(name="searchKeyword")
    public WebElement searchBox;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement addBtn;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveBtn;

    @FindBy(id="searchButton")
    public WebElement searchButton;

    public void searchForSupplier(String supplier)
    {
        WebElement searchSupplier = driver.findElement(By.id("keywords"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));

        waitUntilDisplayed( searchSupplier );
        searchSupplier.clear();
        searchSupplier.sendKeys(supplier);

        waitUntilDisplayed( searchButton );
        searchButton.click();
    }

    public ProductManagerPage addSupplier(String supplier) throws Exception
    {
        enterValueIntoElement(supplier,"searchBox");
        waitUntillElementIsClickableAndClick(searchButton);
        waitUntillElementIsClickableAndClick(addBtn);
        pauseFor(1000);
        waitUntillElementIsClickableAndClick(saveBtn);
        pauseFor(1000);
        return new ManageAgreementPage();
    }

}
