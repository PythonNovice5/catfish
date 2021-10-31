package com.basware.bttf.pages.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;


public class ViewDirectoryPage extends ProductManagerDirectoryPage {
    protected static Logger LOGGER = Logger.getLogger( ViewDirectoryPage.class.getName() );
    @FindBy( linkText="Relevance" )
    public WebElement viewDirectoryDropdownSortRelevance;

    @FindBy( linkText="Name" )
    public WebElement viewDirectoryDropdownSortName;

    @FindBy( linkText="Last modified" )
    public WebElement viewDirectoryDropdownSortLastModified;

    @FindBy( xpath="//a[normalize-space(text())='Published']" )
    public WebElement viewDirectoryFilterPublished;

    @FindBy( xpath="//a[normalize-space(text())='User']" )
    public WebElement viewDirectoryFilterUser;

    @FindBy( xpath="//a[normalize-space(text())='Organisation']" )
    public WebElement viewDirectoryFilterOrganisation;

    @FindBy( xpath="//a[normalize-space(text())='All']" )
    public WebElement viewDirectoryFilterAll;

    @FindBy( xpath="//a[normalize-space(text())='Draft']" )
    public WebElement viewDirectoryFilterDraft;

    @FindBy( xpath="//a[normalize-space(text())='Empty']" )
    public WebElement viewDirectoryFilterEmpty;

    @FindBy( xpath="//a[normalize-space(text())='Processing']" )
    public WebElement viewDirectoryFilterProcessing;

    private String viewDirectoryFirstView = "//*[@title='Manage']";

    public ViewDirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/manageViews";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Views";
    }

    @FindBy(xpath = "//*[@title='Manage']")
    private WebElement cogButton;

    public CreateViewPage clickCreateView()
    {
        WebElement createButton = driver.findElement(By.linkText("Create"));
        createButton.click();
//        pauseFor(2500);
        return new CreateViewPage();
    }

    @Override
    protected void initSortByItems()
    {
        setSortByItems(
                new HashMap<String,WebElement>(){{
                    put("Relevance", viewDirectoryDropdownSortRelevance);
                    put("Name", viewDirectoryDropdownSortName);
                    put("Last Modified",viewDirectoryDropdownSortLastModified);
                }}
                );

    }

    @Override
    protected void initFilterItems()
    {
      setFilterByItems(
                                new HashMap<String, WebElement>() {{
                                    put( "All", viewDirectoryFilterAll );
                                    put( "Draft ", viewDirectoryFilterDraft );
                                    put( "Empty", viewDirectoryFilterEmpty );
                                    put( "Published", viewDirectoryFilterPublished );
                                    put( "Processing", viewDirectoryFilterProcessing );
                                    put( "User", viewDirectoryFilterUser);
                                    put( "Organisation", viewDirectoryFilterOrganisation);
                                }}
                                );

    }


    public void searchView(String viewName)
    {
        directoryInputSearch.click();
        directoryInputSearch.clear();
        directoryInputSearch.sendKeys(viewName);
        clickButtonSearch();
    }

    public ManageViewPage clickOnFirstView() throws Exception
    {
        clickByXpath(viewDirectoryFirstView);
        WebElement elem = driver.findElement(By.xpath("//div[@id='page-name']"));
        String viewName = getTextOfWebElement(elem);
        props.set("ViewPublished",viewName);
        return new ManageViewPage();
    }

    public ProductManagerPage clickButton(String value){
        ProductManagerPage page = null;
        switch (value){
            case "Search":
                clickButtonSearch();
                page = new ViewDirectoryPage();
                break;
            case "cog":
                waitUntillElementIsClickableAndClick(cogButton);
                page = new ManageViewPage();
                break;
        }
    return page;
    }

}
