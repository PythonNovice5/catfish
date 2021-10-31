package com.basware.bttf.pages.quotes;

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.por.ViewPriceOnRequestPage;
import com.basware.bttf.pages.por.ViewPriceOnRequestPageSupplier;
import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class QuotesDirectoryPage extends ProductManagerDirectoryPage {
    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/rfq/quote";
    }

    @Override
    public String getExpectedTitle() {
        return "RFQ Directory";
    }


    public QuotesDirectoryPage(){
        PageFactory.initElements( driver , this );
    }

    @FindBy( xpath="//strong[text()='Open']//..//..//..//..//..//span[@title='View']")
    public WebElement CogOpen;

    @FindBy( xpath="//div/div[2]/a[1]/span")
    public WebElement cog;

    @FindBy(linkText = "Name")
    public WebElement quoteDirectoryDropdownSortName;

    @FindBy(linkText = "Recently modified")
    public WebElement quoteDirectoryDropdownSortRecentlyModified;

    @FindBy(linkText = "Newest")
    public WebElement quoteDirectoryDropdownSortNewest;

    @FindBy(linkText = "Relevance")
    public WebElement quoteDirectoryDropdownSortRelevance;

    @FindBy(linkText = "Expiring soon")
    public WebElement quoteDirectoryDropdownSortExpiringSoon;

    @FindBy( xpath="//a[normalize-space(text())='All']" )
    public WebElement quoteDirectoryFilterAll;

    @FindBy( xpath="//a[normalize-space(text())='Needs attention']" )
    public WebElement quoteDirectoryFilterNeedsAttention;

    @FindBy( xpath="//a[normalize-space(text())='Open']" )
    public WebElement quoteDirectoryFilterOpen;

    @FindBy( xpath="//a[normalize-space(text())='Sent']" )
    public WebElement quoteDirectoryFilterSent;

    @FindBy( xpath="//a[normalize-space(text())='Awarded']" )
    public WebElement quoteDirectoryFilterAwarded;

    @FindBy( xpath="//a[normalize-space(text())='Expired']" )
    public WebElement quoteDirectoryFilterExpired;

    @FindBy( xpath="//a[normalize-space(text())='Closed']" )
    public WebElement quoteDirectoryFilterClosed;

    @FindBy( xpath="//a[normalize-space(text())='Watched']" )
    public WebElement quoteDirectoryFilterWatched;

    public ViewQuotePage clickCog(){
        pauseFor(3000);
        waitUntillElementIsClickableAndClick(cog);
        return new ViewQuotePage();
    }

    public ViewPriceOnRequestPageSupplier clickCogOpen(){
        waitUntillElementIsClickableAndClick(CogOpen);
//        CogOpen.click();
        return new ViewPriceOnRequestPageSupplier();
    }


    @Override
    protected void initSortByItems() {
        setSortByItems(
                new HashMap<String,WebElement>(){{
                    put("Relevance", quoteDirectoryDropdownSortRelevance);
                    put("Name", quoteDirectoryDropdownSortName);
                    put("Last modified",quoteDirectoryDropdownSortRecentlyModified);
                    put("Newest",quoteDirectoryDropdownSortNewest);
                    put("Expiring soon",quoteDirectoryDropdownSortExpiringSoon);
                }}
        );

    }

    @Override
    protected void initFilterItems() {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put( "All", quoteDirectoryFilterAll );
                    put( "NeedsAttention ", quoteDirectoryFilterNeedsAttention );
                    put( "Open", quoteDirectoryFilterOpen );
                    put( "Sent", quoteDirectoryFilterSent );
                    put( "Awarded",quoteDirectoryFilterAwarded);
                    put( "Expired", quoteDirectoryFilterExpired );
                    put( "Closed", quoteDirectoryFilterClosed);
                    put( "Watched", quoteDirectoryFilterWatched);
                }}
        );

    }
}
