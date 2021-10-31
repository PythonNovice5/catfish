package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDashboardPage;
import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class PriceListMatrixItemsDirectoryPage extends ProductManagerDirectoryPage
{
    protected static Logger LOGGER = Logger.getLogger( PriceListMatrixItemsDirectoryPage.class.getName() );

    @FindBy(linkText = "Create")
    private WebElement createMatrixButton;

    @FindBy(linkText = "Search")
    private WebElement searchButton;

    @FindBy( linkText="Last modified" )
    public WebElement matrixDirectoryDropdownSortLastModified;

    @FindBy( xpath="//a[normalize-space(text())='All']" )
    public WebElement matrixDirectoryAll;

    @FindBy(xpath = "//*[@id='pagable-content']/div[2]/div/div[1]/div[2]/div/span")
    private WebElement deleteMatrixButton;

    @FindBy(linkText = "Delete")
    private  WebElement deleteConfirmation;

    @FindBy(xpath = "//span[@title='Manage']")
    public WebElement ManageItem;

    public PriceListMatrixItemsDirectoryPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/matrix/index";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Matrix";
    }

    public CreateMatrixPage clickOnCreate()
    {
        while (driver.findElements(By.xpath("//*[@id='pagable-content']/div[2]/div/div[1]/div[2]/div/span")).size() > 0)
        {
            waitUntillElementIsClickableAndClick(deleteMatrixButton);
            waitUntillElementIsClickableAndClick(deleteConfirmation);
        }
      waitUntillElementIsClickableAndClick(createMatrixButton);
      return new CreateMatrixPage();
    }

    public void clickOnSearch()
    {
       searchButton.click();
    }

    public void deleteMatrixItem()
    {
        waitUntillElementIsClickableAndClick(deleteMatrixButton);
        waitUntillElementIsClickableAndClick(deleteConfirmation);

    }

    public EditMatrixPage clickManageItem(){
        waitUntillElementIsClickableAndClick(ManageItem);
        return new EditMatrixPage();
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(
                new HashMap<String,WebElement>(){{
//                    put("Relevance", matrixDirectoryDropdownSortRelevance);
//                    put("Name", matrixDirectoryDropdownSortName);
                    put("Last Modified",matrixDirectoryDropdownSortLastModified);
                }}
        );

    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put( "All", matrixDirectoryAll );

                }}
        );

    }
}
