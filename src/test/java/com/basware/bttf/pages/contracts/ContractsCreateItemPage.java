package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractsCreateItemPage extends SupplierContractsPage {
    public ContractsCreateItemPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/contractItems/create";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Create Item";
    }

    @FindBy(name = "name")
    public WebElement contractItemName;

    @FindBy(name = "sku")
    public WebElement contractItemSuppID;

    @FindBy(name="description")
    public WebElement contractItemDesc;

    @FindBy(name = "keywords")
    public WebElement contractItemKeywords;

    @FindBy(name = "contactEmail")
    public WebElement contactEmail;

    @FindBy(xpath = "//td[@aria-label=\"Color\"]//..//select")
    public WebElement selectColorDropDown;

    @FindBy(name="submit-form-btn")
    public WebElement submitButton;

    public void enterAllDetails(String field, String value) throws Exception {
        switch (field) {
            case "Name":
                String newNameValue = value + getSessionID();
                enterValueIntoElement(newNameValue, "contractItemName");
                break;
            case "SKU":
                String newSupID = value + getSessionID();
                enterValueIntoElement(newSupID, "contractItemSuppID");
                break;
            case "Description":
                enterValueIntoElement(value, "contractItemDesc");
                break;
            case "Keywords":
                enterValueIntoElement(value, "contractItemKeywords");
                break;
            case "Contact Email":
                enterValueIntoElement(value, "contactEmail");
                break;
            case "Color":
                selectDropdownOption(selectColorDropDown, value);
                break;

        }
    }



        public SupplierContractsPage clickBtn (String btn) throws Exception{

        switch (btn)
        {
            case "Submit":
                waitUntillElementIsClickableAndClick(submitButton);
                return new ContractsItemsDirectoryPage();

    }

            return new SupplierContractsPage();
    }
}

