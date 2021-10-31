package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RootManagementPage extends LoggedInPage
{

    @FindBy(xpath = "//*[@id='root']/div[4]/div[3]/a")
    private WebElement supplierUsersCog;


    public RootManagementPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/admin/root/manage";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Root Management";
    }

    public  RootUserManagementPage clickOnSupplierUserCog()
    {
        waitUntillElementIsClickableAndClick(supplierUsersCog);
        return new RootUserManagementPage();
    }




}
