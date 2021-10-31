package com.basware.bttf.pages.shopping.freetextrequisitions;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LineItemPage extends ShoppingPage {

     @FindBy(id = "name")
     private WebElement lineItemName;
     @FindBy(id = "quantity")
     private WebElement lineQunality;
     @FindBy(id="unitPrice")
     private WebElement unitPrice;
     @FindBy(id="description")
     private WebElement itemDescription;
     @FindBy(id="level1Category")
     public WebElement level1Category;
     @FindBy(id="level2Category")
     public WebElement level2Category;
     @FindBy(id="level3Category")
     public WebElement level3Category;
     @FindBy(id="level4Categories")
     public WebElement level4Category;
     @FindBy(name = "procserveaction_addLine")
     private WebElement addLineItem;
     @FindBy(name = "procserveaction_addAnotherLine")
     private WebElement addAnotherLineItem;
     @FindBy(name = "procserveaction_cancel")
     private WebElement cancelLinItem;


    public LineItemPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/shopping/lineItems/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "FTR: Line Items";
    }

    public void enterLineDetails(String fieldName,String value)
    {
        switch (fieldName.toLowerCase())
        {
          case "item name":
             lineItemName.sendKeys(value);
             break;
          case "quantity":
              lineQunality.sendKeys(value);
              break;
          case "unit price":
              unitPrice.sendKeys(value);
              break;
          case "item description":
              itemDescription.sendKeys(value);
              break;
        }
    }

    public void clickOnCategory(String element,String value) throws Exception {
        pauseFor(1000);
        selectDropdownOption(getWebElementNamed(element),value);
    }

    public FTREditPage clickOnAdd()
    {
         addLineItem.click();
         return new FTREditPage();
    }

    public void clickOnAddLineItems()
    {
        addAnotherLineItem.click();
    }

    public FTREditPage cancelLineItem()
    {
        cancelLinItem.click();
        return new FTREditPage();
    }
}
