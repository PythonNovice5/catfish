package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDashboardPage;
import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class PriceListAgreementsPage extends ProductManagerDirectoryPage<PriceListAgreementsPage>
{
    protected static Logger LOGGER = Logger.getLogger( PriceListAgreementsPage.class.getName() );

    // Breadcrumbs
    @FindBy( xpath="//ul[@class='breadcrumb']/li[1]/a")
    public WebElement priceListAgreementsBreadcrumbProductManager;

    @FindBy( xpath="//ul[@class='breadcrumb']/li[2]/a")
    public WebElement priceListAgreementsBreadcrumbPriceListDirectory;

    @FindBy( xpath="//ul[@class='breadcrumb']/li[3]/a")
    public WebElement priceListAgreementsBreadcrumbPriceList;

    // Sort by
    @FindBy( linkText="Relevance" )
    public WebElement priceListAgreementsDropDownSortRelevance;

    @FindBy( linkText="Name" )
    public WebElement priceListAgreementsDropDownSortName;

    @FindBy( linkText="Agreement Owner" )
    public WebElement priceListAgreementsDropDownSortAgreementOwner;

    @FindBy( linkText="Start Date" )
    public WebElement priceListAgreementsDropDownSortStartDate;

    @FindBy( linkText="Expiry Date" )
    public WebElement priceListAgreementsDropDownSortExpiryDate;

    // Filters
    @FindBy( xpath="//a[normalize-space(text())='All']" )
    public WebElement priceListAgreementsFilterAll;

    @FindBy( xpath="//a[normalize-space(text())='Approved']" )
    public WebElement priceListAgreementsFilterApproved;

    @FindBy( xpath="//a[normalize-space(text())='Pending']" )
    public WebElement priceListAgreementsFilterPending;

    @FindBy( xpath="//a[normalize-space(text())='Declined']" )
    public WebElement priceListAgreementsFilterDeclined;

    // First Agreement Details
    @FindBy( xpath="//div[@class='col-sm-9 link-document']/strong/a" )
    public WebElement priceListsAgreementsFirstAgreementName;


    public PriceListAgreementsPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceList/agreements";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Price List Agreements";
    }

    public ProductManagerDashboardPage priceListAgreementsBreadcrumbProductManagerClick()
    {
        priceListAgreementsBreadcrumbProductManager.click();
        return new ProductManagerDashboardPage();
    }

    public PriceListDirectoryPage priceListAgreementsBreadcrumbPriceListDirectoryClick()
    {
        priceListAgreementsBreadcrumbPriceListDirectory.click();
        return new PriceListDirectoryPage();
    }

    public ManagePriceListPage priceListAgreementsBreadcrumbPriceListClick()
    {
        priceListAgreementsBreadcrumbPriceList.click();
        return new ManagePriceListPage();
    }

    public boolean IsAnAgreementDisplayed()
    {
        boolean isDisplayed = false;
        String fieldValue;
        try
        {
            waitUntilDisplayed(priceListsAgreementsFirstAgreementName);
            fieldValue = priceListsAgreementsFirstAgreementName.getText();
            isDisplayed = true;
        }
        catch(Exception e){}
        return isDisplayed;
    }


    @Override
    protected void initSortByItems()
    {
        setSortByItems(
                new HashMap<String,WebElement>() {{
                    put( "Relevance" , priceListAgreementsDropDownSortRelevance );
                    put( "Name" , priceListAgreementsDropDownSortName );
                    put( "Agreement Owner" , priceListAgreementsDropDownSortAgreementOwner );
                    put( "Start Date" , priceListAgreementsDropDownSortStartDate );
                    put( "Expiry Date" , priceListAgreementsDropDownSortExpiryDate );
                }}
        );
    }

    @Override
    protected void initFilterItems()
    {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put( "All", priceListAgreementsFilterAll );
                    put( "Approved", priceListAgreementsFilterApproved );
                    put( "Pending", priceListAgreementsFilterPending );
                    put( "Declined", priceListAgreementsFilterDeclined );
                }}
        );
    }

}
