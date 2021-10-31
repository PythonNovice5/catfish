package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunityManagementPage extends LoggedInPage
{
    public CommunityManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/admin/community/manage";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Community Management";
    }

    @FindBy(xpath ="//select[@name='community']" )
    public WebElement SelectCommunity;

    @FindBy(xpath ="//td[normalize-space(text())='Catfish-RW-Buyer']//..//span" )
    public WebElement CatfishRWBuyerSettings;

    @FindBy(xpath ="//span[text()='Features']" )
    public WebElement Features;

    @FindBy(xpath = "//*[@id='community']/div[2]/div/div[3]/a/span")
    public WebElement communityUserCog;

    public CommunityManagementPage selectOption(String value,String elem) throws Exception{
        selectDropdownOptionByText(getWebElementNamed(elem),value);
        return null;
    }

    public LoggedInPage clickOnValue(String elem) throws Exception{

         LoggedInPage page  = null;
        switch(elem) {

            case "Oranisation cog" :
               getWebElementNamed(elem).click();
               page =  new OrganisationManagementPage();
            case "user cog":
               waitUntillElementIsClickableAndClick(communityUserCog);
               page = new CommunityUserManagementPage();
        }

        return page;
    }

}
