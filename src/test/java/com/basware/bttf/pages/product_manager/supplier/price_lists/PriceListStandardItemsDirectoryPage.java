package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PriceListStandardItemsDirectoryPage extends ProductManagerDirectoryPage
{
    protected static Logger LOGGER = Logger.getLogger( PriceListStandardItemsDirectoryPage.class.getName() );


    @FindBy(xpath = "//a[@class='link-document']")
    public List<WebElement> ItemList;


    @FindBy(xpath = "//span[@class='glyphicon glyphicon-pencil']")
    public List<WebElement> UpdateItems;

    @FindBy(xpath="//span[@class='block-ellipsis-short']")
    public List<WebElement> itemIDs ;

    @FindBy( name="keywords" )
    public WebElement InputSearch;

    @FindBy( xpath="//button[text()='Search']" )
    public WebElement Search;

    @Override
    protected void initSortByItems() {

    }

    @Override
    protected void initFilterItems() {

    }

    public PriceListStandardItemsDirectoryPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceList/standardItemDirectory";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Price List Standard Items";
    }

    public ProductManagerPage clickButton(String btn) throws Exception {
        switch (btn) {
            case "Plus":
                clickPlusBtn();
                return new ManagePriceListStandardItemPage();
            case "Done":
                clickDoneBtn();
                return new ManagePriceListPage();
            case "UpdateItem1":
                return updateItems(0);
            case "UpdateItem2":
                return updateItems(1);
            case "Search":
                Search.click();
                return new PriceListStandardItemsDirectoryPage();
            case "EditFirstItem":
                UpdateItems.get(0).click();
                return new ManagePriceListUpdateItemDirectoryPage();


        }
        return null;
    }

    public PriceListStandardItemsDirectoryPage verifyAddedItems(String itemCount){
        Assert.assertEquals("Standard Items were not found..",ItemList.size(),Integer.parseInt(itemCount));
        LOGGER.debug("Standard items were present in the present list..");
        return new PriceListStandardItemsDirectoryPage();
    }


    public ManagePriceListUpdateItemDirectoryPage updateItems(int value){
        props.set("Item1",itemIDs.get(0).getText());
        props.set("Item2",itemIDs.get(1).getText());
        LOGGER.debug("Item 1: " +itemIDs.get(0).getText());
        LOGGER.debug("Item 2: " +itemIDs.get(1).getText());
        UpdateItems.get(value).click();
        return new ManagePriceListUpdateItemDirectoryPage();
    }
    public void searchNewPricelist(String pricelistName)
    {
        directoryInputSearch.sendKeys(pricelistName);
        clickButtonSearch();

    }

}



