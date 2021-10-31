package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePriceListPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( CreatePriceListPage.class.getName() );

    @FindBy( id="savePricelistButtonTop")
    public WebElement SaveChanges;

    // Breadcrumb
    @FindBy( xpath="//div[@id='breadcrumb-content']/ul/li[1]/a[contains(text(),'Price List Directory')]")
    public WebElement createPriceListBreadcrumbPriceListDirectory;

    // Buttons
    @FindBy( linkText="Cancel" )
    public WebElement createPriceListButtonCancel;

    @FindBy( linkText="Save" )
    public WebElement createPriceListButtonSave;

    // Price List Details
    @FindBy( id="name")
    public WebElement createPriceListName;

    @FindBy( id="priceListType" )
    public WebElement createPriceListDropDownType;

    @FindBy( id="reference")
    public WebElement createPriceListReference;

    @FindBy( id="startDate_input")
    public WebElement createPriceListStartDate_input;

    @FindBy( id="currency")
    public WebElement createPriceListDropDownCurrency;

    @FindBy( id="expiryDate_input")
    public WebElement createPriceListExpiryDate_input;

    @FindBy( id="territory")
    public WebElement createPriceListDropDownTerritory;

    @FindBy( id="description")
    public WebElement createPriceListDescription;

    @FindBy( id="keywords")
    public WebElement createPriceListKeywords;

    @FindBy(xpath = "//*[@value='ECLASS']//..")
    public WebElement eClassToggle;


    public CreatePriceListPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/pricelistManagement/displayCreate";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Create Price List";
    }


    public PriceListDirectoryPage createPriceListBreadcrumbClick()
    {
        createPriceListBreadcrumbPriceListDirectory.click();
        return new PriceListDirectoryPage();
    }

    public void selectClassificationType(String field,String value) throws Exception{
        String elemValue= getAttributeValueOfWebElement(eClassToggle,"Class");
        if (elemValue.contains("toggle null checked"))
        {
            LOGGER.debug("Eclass Found to be selected already");
        }
        else
        {
            waitUntillElementIsClickableAndClick(eClassToggle);
        }
    }

    public void selectDropDownOption(String dropdownName, String dropdownOption) throws InterruptedException
    {
        switch (dropdownName)
        {
            case "Type":
                selectDropdownOption(createPriceListDropDownType,dropdownOption);
                break;
            case "Currency":
                selectDropdownOption(createPriceListDropDownCurrency,dropdownOption);
                break;
            case "Territory":
                selectDropdownOption(createPriceListDropDownTerritory,dropdownOption);
                break;
        }
    }


    public void enterValueIntoField( String value, String fieldName ) throws InterruptedException
    {
        waitUntilDisplayed(createPriceListName);
        switch (fieldName)
        {
            case "Name":
                value = value + getDateTimeNow();
                props.set("plName",value);
                createPriceListName.sendKeys(value);
                break;
            case "Reference":
                createPriceListReference.sendKeys(value);
                break;
            case "Start Date":
                createPriceListStartDate_input.sendKeys(value);
                break;
            case "Expiry Date":
                createPriceListExpiryDate_input.sendKeys(value);
                break;
            case "Description":
                createPriceListDescription.sendKeys(value);
                break;
            case "Keywords":
                createPriceListKeywords.sendKeys(value);
                break;
        }

    }

    public ManagePriceListPage clickButton( String buttonName )
    {
        switch( buttonName )
        {
            case "createPriceListButtonCancel":
                clickWebElement(createPriceListButtonCancel); break;
            case "Save":
                clickWebElement(SaveChanges); break;

        }
        return new ManagePriceListPage();
    }


    public void clickCancelAlertOKButton() throws Exception
    {
        try {
            clickModalAlertButton("accept");
        }
        catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }

    public void clickCancelAlertCancelButton() throws Exception
    {
        try {
            clickModalAlertButton("dismiss");
        }
        catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }
}
