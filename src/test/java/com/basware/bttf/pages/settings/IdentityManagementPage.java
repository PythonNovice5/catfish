package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class IdentityManagementPage extends LoggedInPage
{
    public IdentityManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/idm/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Identity Management";
    }
}
