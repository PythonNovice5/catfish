package com.basware.bttf.pages.product_manager.supplier.templates;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.product_manager.supplier.items.EditItemPage;
import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import sun.reflect.annotation.ExceptionProxy;

import java.util.HashMap;


public class ItemTemplateDirectoryPage extends ProductManagerDirectoryPage<ItemTemplateDirectoryPage>
{

    protected static Logger LOGGER = Logger.getLogger( ItemTemplateDirectoryPage.class.getName() );

    // Buttons
    @FindBy( linkText="Search" )
    public WebElement manageItemTemplatesButtonSearch;

    @FindBy( linkText="Create" )
    public WebElement manageItemTemplatesButtonCreate;

    // Sort By Dropdowns
    @FindBy( linkText="Relevance" )
    public WebElement manageItemTemplatesDropDownSortRelevance;

    @FindBy( linkText="Name" )
    public WebElement manageItemTemplatesDropDownSortName;

    @FindBy( linkText="Last modified" )
    public WebElement manageItemTemplatesDropDownSortLastModified;

    // Filters
    @FindBy( partialLinkText="All" )
    public WebElement manageItemTemplatesFilterAll;

    @FindBy( partialLinkText="Active (In use)" )
    public WebElement manageItemTemplatesFilterActive;

    @FindBy( partialLinkText="Inactive (Not in use)" )
    public WebElement manageItemTemplatesFilterInactive;

    @FindBy( partialLinkText="Ready to use" )
    public WebElement manageItemTemplatesFilterReady;

    @FindBy( partialLinkText="Not ready to use" )
    public WebElement mmanageItemTemplatesFilterNotReady;

    @FindBy( css = "[title='Delete']")
    public WebElement directoryButtonDelete;


    @FindBy( xpath = "//a//span[@title='Delete']")
    public WebElement directoryButtonDelete_1;

    public ItemTemplateDirectoryPage()

    {
        PageFactory.initElements( driver, this );
    }

    @Override
    public String getExpectedUrl(){ return getBaseUrl() + "/products/itemTemplate";  }

    @Override
    public String getExpectedTitle(){ return "Product Manager: Item Templates"; }

    public ProductManagerPage clickButton( String buttonName ) throws Exception
    {
        switch( buttonName )
        {
            case "Search": return clickButtonSearch();
            case "Create": return clickButtonCreate();
            case "Delete": return clickButtonDelete();
        }

        return null;
    }

    public ItemTemplateDirectoryPage clickFilter(String filterName){
        clickFilter(filterName);
        return this;
    }

    public CreateItemTemplatePage clickButtonCreate()
    {
        manageItemTemplatesButtonCreate.click();
        return new CreateItemTemplatePage();
    }

    public ItemTemplateDirectoryPage clickButtonDelete() throws Exception
    {
        directoryButtonDelete.click();
        pauseFor(2000);
//        if (isModalAlertPresent()){
            directoryButtonDelete_1.click();
//        }
        return new ItemTemplateDirectoryPage();
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(
                new HashMap<String,WebElement>() {{
                    put( "Relevance" , manageItemTemplatesDropDownSortRelevance );
                    put( "Name"      , manageItemTemplatesDropDownSortName );
                    put( "Last modified"    , manageItemTemplatesDropDownSortLastModified );
                }}
        );
    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put( "All", manageItemTemplatesFilterAll );
                    put( "Active (In use)", manageItemTemplatesFilterActive );
                    put( "Inactive (Not in use)", manageItemTemplatesFilterInactive );
                    put( "Ready to use", manageItemTemplatesFilterReady );
                    put( "Not ready to use", mmanageItemTemplatesFilterNotReady );
                }}
        );
    }

    public ItemTemplateDirectoryPage searchItemTemplate(String template) throws  Exception{

        if (template.contains("TemplateName")){
            template = props.get("TemplateName");
        }
        directoryInputSearch.sendKeys(template);
        directoryButtonSearch.click();
        WebElement itemTemplate = driver.findElement(By.xpath(String.format("//a[text()='%s']",template)));
        getTextOfWebElement(itemTemplate);
        Assert.assertEquals("Item Template was not found",template,getTextOfWebElement(itemTemplate));
        return new ItemTemplateDirectoryPage();
     }

    public CreateItemPage addTemplate(){
        clickAddBtn("//span[@class='glyphicon glyphicon-plus']");
        clickByXpath("//button[@title='Done']");
//        pauseFor(5000);
        return new CreateItemPage();
     }

    public EditItemPage addTemplateEditItem(){
        clickAddBtn("//span[@class='glyphicon glyphicon-plus']");
        clickByXpath("//button[@title='Done']");
        return new EditItemPage();
    }


    public ProductManagerPage clickOn(String btnValue) throws Exception{
        switch (btnValue){
            case "Create":
        }
        return null;
     }


}
