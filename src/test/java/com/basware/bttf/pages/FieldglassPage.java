package com.basware.bttf.pages;

import org.openqa.selenium.support.PageFactory;

public class FieldglassPage extends LoggedInPage
{
    public FieldglassPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/punchout/saml/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Basware Network";
    }
}
