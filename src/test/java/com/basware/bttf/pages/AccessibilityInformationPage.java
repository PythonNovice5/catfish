package com.basware.bttf.pages;

import com.basware.bttf.pages.InternalPage;
import org.openqa.selenium.support.PageFactory;

public class AccessibilityInformationPage extends InternalPage
{
    public AccessibilityInformationPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/accessibility_information.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Zanzibar - powered by Baswaretitle.page.accessibility_information";
    }
}
