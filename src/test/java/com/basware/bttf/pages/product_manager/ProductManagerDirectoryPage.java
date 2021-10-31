package com.basware.bttf.pages.product_manager;

import com.basware.bttf.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Map;

public abstract class ProductManagerDirectoryPage<T extends AbstractPage> extends ProductManagerPage
{
    public Map<String,WebElement> sortByItems;
    public Map<String,WebElement> filterItems;

    // Search input and button
    @FindBy( name="keywords" )
    protected WebElement directoryInputSearch;

    @FindBy( className="glyphicon-remove")
    public WebElement directoryButtonClearKeywords;

    @FindBy( xpath="//button[text()='Search']" )
    protected WebElement directoryButtonSearch;

    // Result count label
    @FindBys( { @FindBy( className="row-fluid" ) , @FindBy( xpath="//div[contains(text(), 'results for ')]" ) } )
    protected WebElement directoryResultsCountLabel;

    // Dropdowns
    @FindBy( xpath="//span[contains(text(), 'Sort by')]" )
    public WebElement directorySortBy;

    @FindBy( xpath="//span[contains(text(), 'results per page')]" )
    public WebElement directoryResultsPerPage;

    @FindBy( linkText="25 results per page" )
    public WebElement directory25ResultsPerPage;

    @FindBy( linkText="50 results per page" )
    public WebElement directory50ResultsPerPage;

    @FindBy( linkText="100 results per page" )
    public WebElement directory100ResultsPerPage;

    protected abstract void initSortByItems();
    protected abstract void initFilterItems();

    public T sortBy( String dropdownOption )
    {
        LOGGER.debug( String.format( "sortBy() - dropdownOption: '%s'" , dropdownOption ) );

        if( sortByItems == null )
        {
            initSortByItems();
        }
//        pauseFor(3000);
//        directorySortBy.click();
        waitUntillElementIsClickableAndClick(directorySortBy);

        sortByItems.get( dropdownOption ).click();
        pauseFor(1000);
        return (T) this;
    }

    public T selectResultsPerPage( String dropdownOption )
    {
        LOGGER.debug( String.format( "selectResultsPerPage() - dropdownOption: '%s'", dropdownOption ) );

        directoryResultsPerPage.click();

        switch( dropdownOption )
        {
            case "25 results per page"  : directory25ResultsPerPage.click(); break;
            case "50 results per page"  : directory50ResultsPerPage.click(); break;
            case "100 results per page" : directory100ResultsPerPage.click(); break;

            default:
                    return null;
        }

        return (T) this;
    }

    public T clickFilter( String filterName )
    {
        LOGGER.debug( String.format( "clickFilter() - filterName: '%s'", filterName ) );

        if( filterItems == null )
        {
            initFilterItems();
        }

        filterItems.get( filterName ).click();

        return (T) this;
    }

    protected void setSortByItems( Map<String,WebElement> sortByItems )
    {
        this.sortByItems = sortByItems;
    }

    protected void setFilterByItems( Map<String,WebElement> filterItems )
    {
        this.filterItems = filterItems;
    }

    protected Map<String,WebElement> getFilterItems ()
    {
        return this.filterItems;
    }

    public T clickButtonClearKeywords()
    {
        directoryButtonClearKeywords.click();
        return (T) this;
    }

    public T clickButtonSearch()
    {
//        directoryButtonSearch.click();
        waitUntillElementIsClickableAndClick(directoryButtonSearch);
        return (T) this;
    }
}
