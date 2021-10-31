package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class ManagePriceListUpdateItemDirectoryPage extends ProductManagerPage {
    protected static Logger LOGGER = Logger.getLogger( ManagePriceListUpdateItemDirectoryPage.class.getName() );

    @FindBy(xpath = "//a[@class='link-document']")
    public List<WebElement> ItemList;

    @FindBy(xpath="//div[@id='priceBreaks']//input[@id='prices[].pricePerItem']")
    public List<WebElement> Price;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement Save;

    @FindBy(xpath = "//select[@name='taxCode']")
    public WebElement TaxCode;

    @FindBy(xpath="//div[@id='priceBreaks']//input[@id='prices[].qty']")
    public List<WebElement> NumOfUnits;

    public ManagePriceListUpdateItemDirectoryPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceListItem/updateItemDirectory/";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Manage Price List Standard Item";
    }


    public ManagePriceListUpdateItemDirectoryPage selectTaxCode(String field, String value) throws Exception{

        switch(value){
            case "Standard20%":
                value = "[S] Standard, 20%";
                break;
        }
        getWebElementNamed(field).click();
        selectDropdownOptionByText(getWebElementNamed(field),value);
        return new ManagePriceListUpdateItemDirectoryPage() ;
    }

    public PriceListStandardItemsDirectoryPage clickSave(String btn) throws Exception
    {
        pauseFor(3000);
        getWebElementNamed(btn).click();
        return new PriceListStandardItemsDirectoryPage();
    }

    public void clickPlusBtn()
    {
        PlusButton.click();
    }

    public ManagePriceListPage enterValueIntoField(String value,String field, int row) throws Exception{
        switch(field){
            case "Price":
                Random rand = new Random();
                int rand_int1 = rand.nextInt(50);
                int updatedPriceVal = Integer.parseInt(value)+rand_int1;
                double dValue = (double)updatedPriceVal;
                String numberAsString = String.format ("%.2f", dValue);
                setValueOfWebElement(Price.get(row),numberAsString);
                props.set("UpdatedPrice",numberAsString);
                System.out.println("We are getting the value ----------- to be updated " + numberAsString);
                break;
            case "NumOfUnits":
                setValueOfWebElement(NumOfUnits.get(row),value);
                break;
        }
        return new ManagePriceListPage();
    }
}
