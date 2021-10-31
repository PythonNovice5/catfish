package com.basware.bttf.pages.product_manager.buyer.views;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class CreateListPage extends ViewDirectoryPage
{
    protected static Logger LOGGER = Logger.getLogger( CreateViewPage.class.getName() );
    @FindBy( linkText="Relevance" )
    public WebElement createListRelevance;

    @FindBy( xpath="//span[@class='items-added-count']" )
    public WebElement listFilterItemsOnList;

    @FindBy( xpath="//span[@class='items-not-added-count']" )
    public WebElement listFilterItemsNotOnList;

    @FindBy( xpath="//a[normalize-space(text())='Empty']" )
    public WebElement viewDirectoryFilterEmpty;

    String availableToggle = "//div[@class='knob']";
    String availableToggleSwitch = "//div[@class='switch open']";



    public CreateListPage()
    {
        PageFactory.initElements(driver, this );
    }

    public String getExpectedTitle()
    {
        return "Create List";
    }

    public String getExpectedUrl()
    {

        return getBaseUrl() + "/products/manageViewListsProducts/index/";
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(
                new HashMap<String,WebElement>(){{
                    put("Relevance", createListRelevance);

                }}
        );

    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put( "Items on list", listFilterItemsOnList );
                    put( "Items not on list ", listFilterItemsNotOnList );

                }}
        );

    }

    public CreateListPage addItems(){
        clickAddBtn("//span[@class='glyphicon glyphicon-plus']");
        pauseFor(2000);

        clickAddBtn("//span[@class='glyphicon glyphicon-plus']");
//        pauseFor(2000);
        return new CreateListPage();
    }

    public CreateListPage nextPage() {
        pauseFor(2000);
        try {
            WebElement next = driver.findElement(By.name("nextPage_2"));
            next.click();
        }
        catch (NoSuchElementException e) {
            LOGGER.debug("Element was not found.. ");
        }
        return new CreateListPage();
    }

    public CreateListPage verifyBtn(){

        try
        {
            List<WebElement> minusBtns = driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-minus']"));
            int length = minusBtns.size();
            if (length ==2);{
                LOGGER.debug("Verified the add button changed to minus button successfully after adding the items");
            }
        }
        catch (NoSuchElementException e){
            LOGGER.debug("Elements were not added in the list, try again .. ");
        }

        return new CreateListPage();
    }

    public CreateListPage verifyItemCount() throws Throwable{
         String val = getTextOfWebElement(listFilterItemsOnList);
         System.out.println(val.trim());

         if (val.trim().equals("Items on list (4)")){
             LOGGER.debug("Item count on List verified successfully");

        }
        else
        {
            LOGGER.debug("Failed to verify item count on List");
            throw new Exception("Failed to verify item count on List");
        }
        return  new CreateListPage();
    }


    public ListDirectoryPage clickAvailableToggle(){

        try{
            pauseFor(2500);
            WebElement d =  driver.findElement(By.xpath(availableToggleSwitch));
        }
        catch(NoSuchElementException e){
            LOGGER.debug("The switch is closed");
            clickByXpath(availableToggle);
            pauseFor(2000);
        }

        clickDoneBtn();
        return new ListDirectoryPage();
    }

}
