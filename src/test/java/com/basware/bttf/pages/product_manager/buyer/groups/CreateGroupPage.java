package com.basware.bttf.pages.product_manager.buyer.groups;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class CreateGroupPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( CreateGroupPage.class.getName() );

    public CreateGroupPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/manageGroups/displayCreate";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Create Group";
    }

    public void enterGroupName(String groupName){
        WebElement groupNameField = driver.findElement(By.id("name"));
        groupNameField.sendKeys(groupName);
    }

    public void enterMyDescription(String description){
        WebElement myDescription = driver.findElement(By.id("description"));
        myDescription.sendKeys(description);
    }

    public void enterMemberDescription(String memberDescription){
        WebElement memberDescriptionField = driver.findElement(By.id("memberDescription"));
        memberDescriptionField.sendKeys(memberDescription);
    }

    public ManageGroupsPage clickOnSaveAndContinue(){
        WebElement saveButton = driver.findElement(By.id("saveGroupButton"));
        saveButton.click();
        return new ManageGroupsPage();
    }

}
