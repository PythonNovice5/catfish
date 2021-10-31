package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class NetworkManagementPage extends LoggedInPage
{
    public NetworkManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/networkmanagement/general.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Network Management: Overview";
    }
}
