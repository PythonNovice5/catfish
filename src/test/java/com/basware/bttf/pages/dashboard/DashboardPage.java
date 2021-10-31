package com.basware.bttf.pages.dashboard;
// Created by Julian Sheppard on 22/06/2017

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.external.KnowledgeBasePage;
import com.basware.bttf.util.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends LoggedInPage
{

    @FindBy(xpath = "//*[contains(text(),'Knowledge base')]")
    public WebElement knowledgeBaseLink;

    @FindBy(id="skip-tutorial-btn")
    public WebElement skipTutorialBtn;

    @FindBy(xpath =  "/html/body/div[2]/p")
    public WebElement organisationCurrentlyLoggedIn;

    @FindBy(id="app-dialog-confirm")
    public WebElement confirmSkip;

    protected static Logger LOGGER = Logger.getLogger( DashboardPage.class.getName() );

    public DashboardPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/admin/";
    }

    public String getExpectedTitle()
    {
        return TestConstants.TITLE_DASHBOARD;
    }

    public ExternalPage navigateToKnowledgeBasePage()
    {
        waitUntillElementIsClickableAndClick(skipTutorialBtn);
        waitUntillElementIsClickableAndClick(confirmSkip);
        waitUntillElementIsClickableAndClick(knowledgeBaseLink);
        switchToNewWindow(new KnowledgeBasePage());
        return new KnowledgeBasePage();
    }

    public void verifySwitchToOrg()
    {
       organisationCurrentlyLoggedIn.isDisplayed();
    }
}
