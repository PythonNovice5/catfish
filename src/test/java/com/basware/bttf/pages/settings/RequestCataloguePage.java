package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class RequestCataloguePage extends LoggedInPage
{
    public RequestCataloguePage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/request/request_catalogue.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Request Catalogue";
    }
}
