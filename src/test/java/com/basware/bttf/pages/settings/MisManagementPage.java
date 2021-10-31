package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MisManagementPage extends LoggedInPage {

    @FindBy(linkText = "Add")
    private WebElement addButton;


    @Override
    public String getExpectedUrl() {
        return "/admin/misManagement/index";
    }

    @Override
    public String getExpectedTitle() {
        return "MIS Management";
    }

    public MisManagementPage()
    {
        PageFactory.initElements(driver,this);
    }

    public MisUserManagementPage clickOnAddButton()
    {
        waitUntillElementIsClickableAndClick(addButton);
        return new MisUserManagementPage();
    }


}
