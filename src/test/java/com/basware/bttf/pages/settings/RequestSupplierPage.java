package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class RequestSupplierPage extends LoggedInPage
{
    public RequestSupplierPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/request/request_supplier.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Request a Suppliertitle.page.request.request_supplier";
    }
}
