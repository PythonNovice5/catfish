package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.external.ExternalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlustaPage extends ExternalLoginPage {

    public AlustaPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl() {
        return "https://qaten5.p2p.baswareqa.com/Portal/FormsLogin/Default.aspx?forms=1&returnUrl=%2fedge%2f&tz=60&ln=en-US&lnf=en-GB#/home/_2Fedge_2Fapi_2Fhome_3FuserTaskInfo_3DNone";
    }

    @Override
    public String getExpectedTitle() {
        return "Basware Purchase-to-Pay";
    }


}
