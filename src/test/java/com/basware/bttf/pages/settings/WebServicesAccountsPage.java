package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class WebServicesAccountsPage extends LoggedInPage
{
    public WebServicesAccountsPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/webaccounts/accounts.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Basware Network - eProcurement powered by Baswaretitle.page.webaccounts.accounts";
    }
}
