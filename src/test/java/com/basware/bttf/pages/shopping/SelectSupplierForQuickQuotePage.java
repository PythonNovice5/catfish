package com.basware.bttf.pages.shopping;


import com.basware.bttf.pages.shopping.quickQuote.CreateRfqPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class SelectSupplierForQuickQuotePage extends ShoppingPage {

    @FindBy(id = "keywords")
    public WebElement SearchKeywords;

    @FindBy(name = "btn-search")
    public  WebElement clickOnSearch;


    public SelectSupplierForQuickQuotePage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
         return getBaseUrl()+ "/rfq/suppliers/index?orgType=ADOPTED&backToRef";
    }

    @Override
    public String getExpectedTitle() {
        return "Basware";
    }

    public void searchSupplier()
    {
        clickOnSearch.click();
    }

    public void  addFirstSupplier()
    {

        List<WebElement> supplierListDetails = driver.findElements(By.cssSelector("tr > .span9"));

        Iterator<WebElement> i = supplierListDetails.iterator();

        while (i.hasNext()){
            LOGGER.debug(i.next());
        }

        //for each row
        for (WebElement supplierName : supplierListDetails){
            {
                supplierName.findElement(By.linkText("Add")).click();
                break;
            }
        }

    }

    public  CreateRfqPage saveSupplier(){
        WebElement saveButton = driver.findElement(By.partialLinkText("Save"));
        saveButton.click();
        return new CreateRfqPage();
    }

}
