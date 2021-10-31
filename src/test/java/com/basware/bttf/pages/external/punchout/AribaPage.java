package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.ExternalPage;
import org.openqa.selenium.support.PageFactory;

public class AribaPage extends ExternalLoginPage {

    public AribaPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl() {
        return "https://preprod-eprocurement1.procserveonline.com/Buyer/Main";
    }

    @Override
    public String getExpectedTitle() {
        return "Ariba Spend Management";
    }
}
