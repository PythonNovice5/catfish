package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditMatrixPage extends ProductManagerPage {

    public EditMatrixPage()

    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return "products/matrix/edit/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Edit Matrix";
    }

    @FindBy(xpath = "//*[@id='itemSkus[0]']//..//..//..//button[@class='btn btn-icon btn-minus']")
    public WebElement ItemMinus;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SaveButton;

    public void clickOnButton(String button)
    {
        switch (button)
        {
            case "DeleteItem":
                waitUntillElementIsClickableAndClick(ItemMinus);
                break;
            case "AddOptionSet":
                break;
            case "Add Item":
                break;
        }

    }

    public PriceListMatrixItemsDirectoryPage clickSave(){
        waitUntillElementIsClickableAndClick(SaveButton);
        return new PriceListMatrixItemsDirectoryPage();
    }
}
