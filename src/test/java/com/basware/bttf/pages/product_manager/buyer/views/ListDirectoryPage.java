package com.basware.bttf.pages.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListDirectoryPage extends ViewDirectoryPage {

    private static String listName;
    public ListDirectoryPage()
    {
        PageFactory.initElements(driver, this );
    }

    @FindBy(xpath = "//*[@title='Delete']")
    private WebElement deleteListButton;

    @FindBy(xpath = "//button[@id='deleteList']")
    private WebElement deleteConfirmationPop;

    public String getExpectedTitle()
    {
        return "List directory";
    }

    public String getExpectedUrl(){

        return getBaseUrl() + "/products/manageViewLists/index";
    }

    public ListDirectoryPage clickCreateList() {
        List<WebElement> totalList = driver.findElements(By.xpath("//*[@title='Delete']"));
        while ( totalList.size()>0)
        {
            deleteList();
            driver.navigate().refresh();
            totalList = driver.findElements(By.xpath("//*[@title='Delete']"));
        }

        WebElement createButton = driver.findElement(By.id("createAction"));
        waitUntillElementIsClickableAndClick(createButton);
        return new ListDirectoryPage();
    }

    public String listNameNew(String listName){
        listName = listName + getDateTimeNow();
        return listName;
    }

    public ListDirectoryPage  enterListDetails(String listName, String listDesc){
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        listName = listName + getDateTimeNow();
        props.set("listTitle",listName);
        waitUntilDisplayed(name);
        name.sendKeys(listName);
        WebElement desc = driver.findElement(By.xpath("//textarea[@name='description']"));
        waitUntilDisplayed(desc);
        desc.sendKeys(listDesc);
        return new ListDirectoryPage();
    }

    public CreateListPage clickSaveButton(){
        WebElement saveBtn = driver.findElement(By.id("btnCreate"));
        waitUntillElementIsClickableAndClick(saveBtn);
        return new CreateListPage();
    }

    public ListDirectoryPage getListStatus(){
        System.out.println(this.listName);
        listName = "'"+props.get("listTitle")+"'";
        pauseFor(2500);
        WebElement d =  driver.findElement(By.xpath("//span[text()="+listName+']'+"//..//..//..//..//..//div[@class='switch open'"+"]"));
        LOGGER.debug("List created was verified successfully on List Directory Page .. ");
        LOGGER.debug("Available knob is switched ON as expected on List Directory Page for the given list ");
        return new ListDirectoryPage();
    }

    public void deleteList(){
        pauseFor(1000);
        driver.navigate().refresh();
        waitUntillElementIsClickableAndClick(deleteListButton);
        waitUntillElementIsClickableAndClick(deleteConfirmationPop);
    }
}
