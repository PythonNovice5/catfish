package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class BuyerRegistrationPage extends LoggedInPage
{
    public BuyerRegistrationPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/buyerregistration/search_all.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Buyer Registration";
    }
}
