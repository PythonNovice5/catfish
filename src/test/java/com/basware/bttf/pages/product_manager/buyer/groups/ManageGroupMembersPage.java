package com.basware.bttf.pages.product_manager.buyer.groups;


import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class ManageGroupMembersPage extends ProductManagerDirectoryPage {



    public ManageGroupMembersPage()
    {
        PageFactory.initElements( driver , this );
    }


    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+"/products/manageMembersGroup/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Select Group Members";
    }
    @Override
    protected void initSortByItems() {

    }

    @Override
    protected void initFilterItems() {

    }

    public void selectMemebersToShare()
    {
        WebElement members = driver.findElement(By.cssSelector("span.glyphicon.glyphicon-plus"));
        members.click();
    }

    public ManageGroupsPage clickOnDone(){
        WebElement done = driver.findElement(By.linkText("Done"));
        waitUntillElementIsClickableAndClick(done);
        return new ManageGroupsPage();
    }

    public void searchGroupMembers(String value)
    {
        directoryInputSearch.sendKeys(value);
        clickButtonSearch();
    }


}
