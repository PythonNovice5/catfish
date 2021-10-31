package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.contracts.SupplierContractsPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class ManageQualificationPage extends ProductManagerPage {

    protected static Logger LOGGER = Logger.getLogger( PriceListStandardItemsDirectoryPage.class.getName() );
    public ManageQualificationPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/contracts/register/";
    }

    public String getExpectedTitle()
    {
        return "Manage qualification";
    }

    @FindBy(xpath ="//td[@aria-label='Your Delivery Time in days?']//..//select" )
    public WebElement DeliveryTimeDropDown;

    @FindBy(xpath = "//*[@name='contactEmail']")
    public WebElement contactEmail;

    @FindBy(xpath = "//*[@name='submit-form-btn']")
    public WebElement SubmitBtn;

    public ProductManagerPage selectDropDownOption(String dropDownValue, String dropDownName) throws Exception{

        selectDropdownOptionByText(getWebElementNamed(dropDownName),dropDownValue);
        return new ManageQualificationPage();
    }

    public SupplierContractsPage clickOnElement(String elem){
        switch(elem){
            case "Submit":
                waitUntillElementIsClickableAndClick(SubmitBtn);
                return new SupplierContractsPage();

        }
        return null;
    }

    }

