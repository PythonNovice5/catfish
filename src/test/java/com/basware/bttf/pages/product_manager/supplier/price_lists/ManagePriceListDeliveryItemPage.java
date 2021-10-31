package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePriceListDeliveryItemPage extends ProductManagerPage {
    protected static Logger LOGGER = Logger.getLogger( ManagePriceListDeliveryItemPage.class.getName() );

    public ManagePriceListDeliveryItemPage()
    {
        PageFactory.initElements(driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceListItem/addItemDirectory/";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Manage Price List Delivery Item";
    }

    @FindBy( xpath="//div[@id='priceBreaks']//input[@id='prices[].pricePerItem']")
    public WebElement Price;

    @FindBy( xpath="//input[@value='Save']")
    public WebElement Save;

    public PriceListDeliveryItemsDirectoryPage clickBtn(String btn) throws Exception{
        pauseFor(2000);
        getWebElementNamed(btn).click();
        return new PriceListDeliveryItemsDirectoryPage();
    }




}
