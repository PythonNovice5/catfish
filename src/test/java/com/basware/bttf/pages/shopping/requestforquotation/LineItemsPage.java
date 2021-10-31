package com.basware.bttf.pages.shopping.requestforquotation;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LineItemsPage extends ShoppingPage {
    public LineItemsPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/shopping/lineItems/index/";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ: Line Items";
    }

    @FindBy(id="name")
    public WebElement LineItemsItemName;

    @FindBy(id="quantity")
    public WebElement LineItemsItemQuantity;

    @FindBy(id="unitPrice")
    public WebElement LineItemsTargetUnitPrice;

    @FindBy(id="description")
    public WebElement LineItemsItemDesc;

    @FindBy(xpath = "//select[@name='level1Category']//option[text()='Apparel and Luggage and Personal Care Products']")
    public WebElement LineItemsCatLevel1;

    @FindBy(xpath = "//select[@name='level2Category']//option[text()='Clothing']")
    public WebElement LineItemsCatLevel2;

    @FindBy(xpath = "//select[@name='level3Category']//option[text()='Athletic wear']")
    public WebElement LineItemsCatLevel3;


    @FindBy(xpath = "//input[@value='Add']")
    public WebElement AddButton;

    public LineItemsPage selectCatLevel(String value,String locator) throws Exception{
        String str="";
        WebElement location;
        switch(locator){
            case "CatLevel1":
                str = "1";
                break;
            case "CatLevel2":
                str = "2";
                break;
            case "CatLevel3":
                str = "3";
                break;
            case "CatLevel4":
                str = "4";
                location = driver.findElement(By.xpath(String.format("//select[@name='level%sCategories']",str)));
                selectDropdownOptionByText(location,value);
//                pauseFor(2000);
                return new LineItemsPage();
        }
        location = driver.findElement(By.xpath(String.format("//select[@name='level%sCategory']",str)));
        selectDropdownOptionByText(location,value);
        pauseFor(1000);
        return new LineItemsPage();
    }

    public RequestQuotePage clickBtn(String btnValue){
        switch(btnValue){
            case "Add":
                AddButton.click();
                break;
        }
        return new RequestQuotePage();
    }
}
