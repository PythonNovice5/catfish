package com.basware.bttf.pages.external;

public class CookieNoticePage extends ExternalPage
{
    @Override
    public String getExpectedUrl()
    {
        return "http://info.basware.co.uk/wp-content/uploads/2018/05/Cookie-Notice.pdf";
    }

    @Override
    public String getExpectedTitle()
    {
        return "";
    }
}
