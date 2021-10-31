package com.basware.bttf.pages.product_manager.buyer.groups;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageGroupsPage extends ProductManagerPage {

    public ManageGroupsPage()
    {
        PageFactory.initElements( driver , this );
    }
    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/manageGroups/view";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Manage Group";
    }

    @FindBy(id ="publishGroup" )
    public WebElement publishButton;

    public ProductManagerPage clickCog(String fieldName)
    {
        WebElement cog = driver.findElement(By.xpath("//*[@id=\"div-"+fieldName+"\"]/div[2]/a/span"));
       waitUntillElementIsClickableAndClick(cog);

        ProductManagerPage page = null;

        switch( fieldName.toLowerCase() )
        {
            case "members":
                page = new ManageGroupMembersPage();
                break;
            case "resources":
                page = new ManageGroupResourcePage();
                break;
        }

        return page;
    }

    public GroupDirectoryPage publishGroup()
    {
//        pauseFor(2000);
        waitUntillElementIsClickableAndClick(publishButton);
        pauseFor(1000);
        return new GroupDirectoryPage();
    }
}
