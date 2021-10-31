package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class SystemManagementPage extends LoggedInPage
{
    public SystemManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/system-maintenance/systemMaintenance/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "System Management Overview";
    }
}
