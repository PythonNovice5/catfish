package com.basware.bttf.pages.directory;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class DirectoryPage extends LoggedInPage
{
    public DirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/directory/supplier/list";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Find Suppliers";
    }
}
