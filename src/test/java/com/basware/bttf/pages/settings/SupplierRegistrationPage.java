package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class SupplierRegistrationPage extends LoggedInPage
{
    public SupplierRegistrationPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/supplierregistration/search_invited.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Supplier Registration: Invited Suppliers";
    }
}
