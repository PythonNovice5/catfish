package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManagePriceListStandardItemPage extends ProductManagerPage {
    protected static Logger LOGGER = Logger.getLogger( ManagePriceListStandardItemPage.class.getName() );

    public ManagePriceListStandardItemPage()
    {
        PageFactory.initElements(driver, this );
    }



    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceListItem/addItemDirectory/";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Manage Price List Standard Item";
    }

    @FindBy(xpath="//div[@id='priceBreaks']//input[@id='prices[].pricePerItem']")
    public List<WebElement> Price;

    @FindBy(xpath="//div[normalize-space(@class)='toggle null']")
    public List<WebElement> PriceOnReq;


    @FindBy(xpath = "//div[@class='toggle null checked']")
    public WebElement ToggleChecked;

    @FindBy(xpath="//div[@id='priceBreaks']//input[@id='prices[].qty']")
    public List<WebElement> NumOfUnits;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement Save;

    public ManagePriceListStandardItemPage enterValue(String value, String element,int rowNum)throws Exception
    {
        switch(element){
            case "Price":
                setValueOfWebElement(Price.get(rowNum),value);
            case "NumOfUnits":
                setValueOfWebElement(NumOfUnits.get(rowNum),value);
        }

//        enterValueIntoElement(value,element);
        return new ManagePriceListStandardItemPage();
    }

    public ManagePriceListStandardItemPage clickToggle(String btnValue,int row) throws Exception
        {
            waitUntillElementIsClickableAndClick(PriceOnReq.get(row));
            pauseFor(2000);
            Assert.assertTrue("Toggle switch was not selected",ToggleChecked.isDisplayed());
            return  new ManagePriceListStandardItemPage();
        }

    public PriceListStandardItemsDirectoryPage clickSave(String btn) throws Exception
    {

        waitUntillElementIsClickableAndClick(getWebElementNamed(btn));
        return new PriceListStandardItemsDirectoryPage();
    }
}
