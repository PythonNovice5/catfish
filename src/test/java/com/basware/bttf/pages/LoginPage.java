package com.basware.bttf.pages;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.dashboard.DashboardPage;
import com.basware.bttf.util.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends InternalPage
{
    protected static Logger LOGGER = Logger.getLogger( LoginPage.class );

    private String urlType;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit")
    public WebElement LogInButton;

    public LoginPage()
    {
        PageFactory.initElements( driver , this );

    }

    @Override
    protected void isLoaded()
    {
        super.isLoaded();
//        driver.manage().window().maximize();
    }

    public String getExpectedUrl()
     {
        return getBaseUrl() + "/admin/login/auth";
     }


    public String getExpectedTitle()
    {
        return TestConstants.TITLE_LOGIN;
    }

    public DashboardPage login(User user ) throws Exception
    {
        LOGGER.debug( "Log In Page ... Logging in as " + user.getUserAlias() + " " + user.getUsername() + "\n" );
        setValueOfWebElement( username , user.getUsername() );
        setValueOfWebElement( password , user.getPassword() );
        LogInButton.click();
        return user.getUserHomePage();      // currently, always the dashboard welcome page
    }
}
