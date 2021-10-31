package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class CommunityRegistrationPage extends LoggedInPage
{
    public CommunityRegistrationPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/communityregistration/communities.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Community Registration";
    }
}
