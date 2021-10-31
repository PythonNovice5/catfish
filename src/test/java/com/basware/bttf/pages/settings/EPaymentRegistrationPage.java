package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.support.PageFactory;

public class EPaymentRegistrationPage extends LoggedInPage
{
    public EPaymentRegistrationPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/otis/epaymentregistration/registration_details.html";
    }

    @Override
    public String getExpectedTitle()
    {
        return "ePayment Registration";
    }
}
