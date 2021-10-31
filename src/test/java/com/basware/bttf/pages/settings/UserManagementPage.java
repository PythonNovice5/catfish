package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage extends LoggedInPage
{
    public UserManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/usermanagement/browse_users.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "User Management: Browse Users";
    }
}
