package com.basware.bttf.pages.shopping.quickQuote;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RfqDirectoryPage extends ShoppingPage {

    public RfqDirectoryPage(){
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/rfq/index?sm_status";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ Directory";
    }

   public CreateRfqPage clickOnRfq(){
        WebElement rfq = driver.findElement(By.xpath("//div[3]/div[1]/div/div[1]/a"));
        rfq.click();
        return new CreateRfqPage();
    }

    public ViewRfqPage clickOnCog(){
        WebElement cog = driver.findElement(By.xpath("//div/div[2]/a[1]/span"));
        cog.click();
        return new ViewRfqPage();
    }
}
