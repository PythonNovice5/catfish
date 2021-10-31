package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class RootUserManagementPage extends LoggedInPage {

    @Override
    public String getExpectedUrl() {
        return "/admin/root/supplierUsers";
    }

    @Override
    public String getExpectedTitle() {
        return "User Management";
    }

    public RootUserManagementPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void verifyBuyerNotInTheSearchList()
    {
        assertTrue(driver.findElements(By.xpath("//*[contains(@title,'Manage users')]")).size()== 0);
    }
}
