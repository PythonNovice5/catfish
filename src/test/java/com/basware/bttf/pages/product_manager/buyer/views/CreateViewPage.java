package com.basware.bttf.pages.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateViewPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( CreateViewPage.class.getName() );

    public CreateViewPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/addView/index";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Create View";
    }

    @FindBy(id="viewType")
    public WebElement dropdownName;

    public CreateViewPage selectTypeInDropDown(String type) throws InterruptedException{
        selectDropdownOption(dropdownName,type);
        return new CreateViewPage();

    }
    public CreateViewPage  enterViewDetails(String viewName, String viewDesc){
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        viewName = viewName + getDateTimeNow();
        name.sendKeys(viewName);
        pauseFor(100);
        WebElement desc = driver.findElement(By.xpath("//textarea[@name='description']"));
        desc.sendKeys(viewDesc);
        return new CreateViewPage();
    }

    public ManageViewPage clickSaveButton(){
        WebElement saveBtn = driver.findElement(By.xpath("//input[@value='Save']"));
        pauseFor(1000);
        saveBtn.click();
        return new ManageViewPage();
    }

    public CreateViewPage checkExistingView (String view) {
            WebElement existingView;
        try {
            existingView = driver.findElement(By.xpath("//a[text()=]" + view));
        }
        catch(NoSuchElementException e)
        {
            LOGGER.debug("The view was not present on the Page:" + e);
            return new CreateViewPage();
        };

        if (existingView != null){
        }
        return new CreateViewPage();
    }
}

