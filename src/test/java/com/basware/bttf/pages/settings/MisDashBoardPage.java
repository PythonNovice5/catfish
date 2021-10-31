package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MisDashBoardPage extends LoggedInPage {
    @Override
    public String getExpectedUrl()
    {
        return "/admin/reports/dashboard";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Reports";
    }

    public MisReportPage clickOnReportTile()
    {
        WebElement tileName = driver.findElement(By.xpath("//a[@name='view_all']"));
        waitUntillElementIsClickableAndClick(tileName);
        return new MisReportPage();
    }
}
