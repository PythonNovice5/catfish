package com.basware.bttf.pages;

import com.basware.bttf.pages.dashboard.DashboardPage;
import com.basware.bttf.util.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class HomePagePunchOut extends InternalPage {

    protected static Logger LOGGER = Logger.getLogger( HomePagePunchOut.class.getName() );

    public HomePagePunchOut()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return env.getPunchOutToolUrl();
    }

    public String getExpectedTitle()
    {
        return TestConstants.TITLE_PUNCHOUT;
    }

}
