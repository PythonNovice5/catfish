package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.external.ExternalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class ExternalLoginPage extends ExternalPage {
    @FindBy(id= "txtLogin")
    private WebElement alustaUserName;

    @FindBy(id= "txtPassword")
    private WebElement alusataPassword;

    @FindBy(id = "btnLogin")
    private WebElement alustaLoginButton;

    @FindBy(name= "UserName")
    private WebElement aribaUserName;

    @FindBy(id = "Password")
    private  WebElement aribaPassword;

    @FindBy(xpath = "//*[@id='loginForm']/table/tbody/tr[7]/td/input")
    private WebElement aribaLoginButton;

    public void loginToExternalSite(String externalSite, User user ) throws Exception
    {
        switch (externalSite){
            case "alusta":
                LOGGER.debug( "External Log In Page ... Logging in as " + user.getUserAlias() + " " + user.getUsername() + "\n" );
                setValueOfWebElement( alustaUserName , user.getUsername() );
                setValueOfWebElement( alusataPassword , user.getPassword() );
                alustaLoginButton.click();
                break;
            case "ariba":
                LOGGER.debug( "External Log In Page ... Logging in as " + user.getUserAlias() + " " + user.getUsername() + "\n" );
                setValueOfWebElement(aribaUserName,user.getUsername());
                setValueOfWebElement(aribaPassword,user.getPassword());
                aribaLoginButton.click();
                break;
        }
    }
}
