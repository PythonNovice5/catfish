package com.basware.bttf.pages.shopping.notifications;


import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingNotificationsPage extends ShoppingPage
{


    public ShoppingNotificationsPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/shopping/marketplace/landingpage";
    }

    public String getExpectedTitle()
    {
        return "Marketplace: Home";
    }


}
