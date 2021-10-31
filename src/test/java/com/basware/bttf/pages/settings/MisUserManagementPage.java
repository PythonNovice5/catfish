package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class MisUserManagementPage extends LoggedInPage {



    @FindBy(name = "userId")
    private WebElement plusButton;


    @Override
    public String getExpectedUrl() {
        return "/admin/misManagement/selectUser";
    }

    @Override
    public String getExpectedTitle()
    {
        return "User Management";
    }

    public MisUserManagementPage()
    {
        PageFactory.initElements(driver,this);
    }



    public void verifyAddButtonIsNotDisplaying()
    {
        assertTrue(driver.findElements(By.className("glyphicon-plus")).size()== 0);
    }


}
