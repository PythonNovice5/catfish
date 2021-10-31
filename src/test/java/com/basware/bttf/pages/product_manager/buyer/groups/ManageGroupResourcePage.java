package com.basware.bttf.pages.product_manager.buyer.groups;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.util.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class ManageGroupResourcePage extends ProductManagerDirectoryPage<ManageGroupResourcePage>
{
    @FindBy( linkText="Last updated" )
    private WebElement groupResourceDropdownSortLastUpdated;

    @FindBy(xpath = "//*[@id=\"pagable-content\"]/div[2]/div[1]/div/div[1]/div[2]/a/span")
    public WebElement selectAgreement;

    @FindBy( linkText="Name" )
    private WebElement groupResourceDropdownSortName;

    @FindBy( linkText="Start date" )
    private WebElement groupResourceDropdownSortStartDate;

    @FindBy( linkText="Expiration Date" )
    private WebElement groupResourceDropdownExpirationDate;

    @FindBy(xpath = "//span[@title = 'Delete']")
    private WebElement removeResource;

    @FindBy(linkText = "Done")
    private WebElement doneButton;

    // Filters
    @FindBy( linkText="All" )
    public WebElement groupResourceFilterAll;

    @FindBy( linkText="Added" )
    public WebElement groupResourceFilterAdded;

    @FindBy( linkText="Available" )
    public WebElement groupResourceFilterAvailable;

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+ "/products/manageResourcesGroup/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Select Group Agreements";
    }

    @Override
    protected void initSortByItems() {
        setSortByItems(
                new HashMap<String,WebElement>(){{
                    put("Last updated", groupResourceDropdownSortLastUpdated);
                    put("Name", groupResourceDropdownSortName);
                    put("Start date",groupResourceDropdownSortStartDate);
                    put("Expiration Date",groupResourceDropdownExpirationDate);
                }}
        );
    }

    @Override
    protected void initFilterItems() {
        setFilterByItems(new HashMap<String,WebElement>()
        {{
            put("All", groupResourceFilterAll);
            put("Added", groupResourceFilterAdded);
            put("Available", groupResourceFilterAvailable);
        }});
    }

    ManageGroupResourcePage()
    {
        PageFactory.initElements(driver,this);
    }


    public void selectResource(){
        pauseFor(2000);
        long giveUpAt = System.currentTimeMillis()+ 7000;
        while (System.currentTimeMillis() < giveUpAt && driver.findElements(By.xpath("//*[@id='pagable-content']/div[2]/div[1]/div/div[1]/div[2]/a/span")).size()==0)
        {
            pauseFor(1000);
            driver.navigate().refresh();
        }
        waitUntillElementIsClickableAndClick(selectAgreement);
        pauseFor(1000);
    }

    public ManageGroupsPage removeResource()
    {
        waitUntillElementIsClickableAndClick(removeResource);
        waitUntillElementIsClickableAndClick(doneButton);
        return new ManageGroupsPage();
    }

    public ManageGroupsPage clickOnDone(){
        WebElement done = driver.findElement(By.linkText("Done"));
        waitUntillElementIsClickableAndClick(done);
        pauseFor(500);
        return new ManageGroupsPage();
    }

    public void searchAgreementInResource(String value)
    {
        waitUntilDisplayed(directoryInputSearch);
        directoryInputSearch.sendKeys(value);
        clickButtonSearch();
//        pauseFor(1000);
    }
}
