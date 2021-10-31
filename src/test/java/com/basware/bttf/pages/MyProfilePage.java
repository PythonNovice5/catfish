package com.basware.bttf.pages;

import com.basware.bttf.pages.dashboard.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends LoggedInPage
{

    @FindBy(xpath = "//*[@id='user']/div[9]/span")
    private WebElement organisationButton;

       /* @FindBy(xpath = "//td[contains(text(),'-Buyer')]//..//*[@title='Switch to']")
    private WebElement switchToBuyerOrg;*/

    /*@FindBy(xpath = "//td[contains(text(),'-Buyer')]//..//*[@title='Switch back']")
    private WebElement switchBackToProcButton;
*/
    public MyProfilePage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/admin/userManagement/edit";
    }

    @Override
    public String getExpectedTitle()
    {
        return "User Management";
    }

    public void clickOnExpandableButton(String button)
    {
        switch(button) {
            case "organizations":
                clickWebElement(organisationButton);
                break;
        }
    }

    public DashboardPage switchToBuyingOrg(String orgToSwitch)
    {
        WebElement switchToBuyerOrg = driver.findElement(By.xpath("//td[contains(text(),'"+orgToSwitch+"')]//..//*[@title='Switch to']"));
        waitUntillElementIsClickableAndClick(switchToBuyerOrg);
        return new DashboardPage();
    }

    public DashboardPage switchBackToProc(String switchBackOrg)
    {
        WebElement switchBackToProcButton = driver.findElement(By.xpath("//td[contains(text(),'"+switchBackOrg+"')]//..//*[@title='Switch back']"));
        waitUntillElementIsClickableAndClick(switchBackToProcButton);
        return new DashboardPage();
    }
}
