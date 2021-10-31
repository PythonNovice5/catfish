package com.basware.bttf.pages.product_manager;

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.AgreementDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.CreateAgreementNewPage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.PublishAgreementsPage;
import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.categories.CoderPage;
import com.basware.bttf.pages.product_manager.buyer.groups.CreateGroupPage;
import com.basware.bttf.pages.product_manager.buyer.groups.GroupDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.views.CreateViewPage;
import com.basware.bttf.pages.product_manager.buyer.views.ViewDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.content_upload.ContentUploadPage;
import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.media.MediaDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListDirectoryPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductManagerDashboardPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( ProductManagerDashboardPage.class.getName() );

    /* ============================
     * MESSAGE DIV
     * ============================ */
    @FindBy(className="pm__section-notification")
    public WebElement message;

    /* ============================
    * SUPPLIER WORKFLOW
    * ============================ */
    @FindBy( xpath="//div[contains(text(), 'Media')]/following-sibling::div//span[@class='pm__list-icon-link']" )
    public WebElement pmSupplierWorkflowCountMedia;

    @FindBy( xpath="//div[contains(text(), 'Items')]/following-sibling::div//span[@class='pm__list-icon-link']" )
    public WebElement pmSupplierWorkflowCountItems;

    @FindBy( xpath="//div[contains(text(), 'Price Lists')]/following-sibling::div//span[@class='pm__list-icon-link']" )
    public WebElement pmSupplierWorkflowCountPriceLists;

    @FindBy( xpath="//div[contains(text(), 'Agreements')]/following-sibling::div//span[@class='pm__list-icon-link']" )
    public WebElement pmSupplierWorkflowCountAgreements;

    /* ============================
    * SUPPLIER PANELS
    * ============================ */
    @FindBy( linkText="View Agreements" )
    public WebElement pmSupplierPanelAgreements;

    @FindBy( linkText="Download Content Loader" )
    public WebElement pmSupplierPanelContentLoader;

    @FindBy( linkText="Upload content" )
    public WebElement pmSupplierPanelUploadContent;

    @FindBy( linkText="View Items" )
    public WebElement pmSupplierPanelViewItems;

    @FindBy( linkText="View Price Lists" )
    public WebElement pmSupplierPanelPriceLists;

    @FindBy( linkText="View Media" )
    public WebElement pmSupplierPanelMedia;


    /* ============================
     * BUYER WORKFLOW
     * ============================ */
    @FindBy( xpath="//div[contains(text(), 'Groups')]/following-sibling::div//span[@class='pm__list-icon-link']" )
    public WebElement pmBuyerWorkflowCountGroups;

    @FindBy(name="manageAgreements")
    public WebElement pmBuyerWorkflowCountAgreements;

    @FindBy( xpath="//div[contains(text(), 'Views')]/following-sibling::div//span[@class='pm__list-icon-link']" )
    public WebElement pmBuyerWorkflowCountViews;


    /* ============================
     * BUYER PANELS
     * ============================ */
    @FindBy( linkText="Create Agreement" )
    public WebElement pmBuyerPanelCreateAgreement;

    @FindBy( linkText="Create a View" )
    public WebElement pmBuyerPanelCreateView;

    @FindBy( linkText="Create Group" )
    public WebElement pmBuyerPanelCreateGroup;

    @FindBy( linkText="View your Approvals" )
    public WebElement pmBuyerPanelViewApprovals;

    @FindBy( linkText="Manage your Coder" )
    public WebElement pmBuyerPanelManageYourCoder;


    public ProductManagerDashboardPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Home";
    }

    /* =====================================
    * WORKFLOW COUNTS
    * ===================================== */
    public ProductManagerPage clickProductManagerWorkflowCount( String userType , String workflowItem )
    {
        switch( userType )
        {
            case "Supplier":
                switch( workflowItem )
                {
                    case "Media":       return clickPMSupplierWorkflowCountMedia();
                    case "Items":       return clickPMSupplierWorkflowCountItems();
                    case "Price Lists": return clickPMSupplierWorkflowCountPriceLists();
                    case "Agreements":  return clickPMSupplierWorkflowCountAgreements();
                    default:
                        return null;
                }

            case "Buyer":
                switch( workflowItem )
                {
                    case "Groups":     return clickPMBuyerWorkflowCountGroups();
                    case "Agreements": return clickPMBuyerWorkflowCountAgreements();
                    case "Views":      return clickPMBuyerWorkflowCountViews();
                    default:
                        return null;
                }

            default:
                return null;
        }
    }

    // SUPPLIER
    public ProductManagerPage clickPMSupplierWorkflowCountMedia()
    {
        pmSupplierWorkflowCountMedia.click();
        return new MediaDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierWorkflowCountItems()
    {
        pmSupplierWorkflowCountItems.click();
        return new ItemDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierWorkflowCountPriceLists()
    {
        pmSupplierWorkflowCountPriceLists.click();
        return new PriceListDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierWorkflowCountAgreements()
    {
        pmSupplierWorkflowCountAgreements.click();
        return new PublishAgreementsPage();
    }

    // BUYER
    public ProductManagerPage clickPMBuyerWorkflowCountGroups()
    {
        pmBuyerWorkflowCountGroups.click();
        return new GroupDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerWorkflowCountAgreements()
    {
        pmBuyerWorkflowCountAgreements.click();
        return new AgreementDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerWorkflowCountViews()
    {
        pmBuyerWorkflowCountViews.click();
        return new ViewDirectoryPage();
    }

    /* =====================================
     * PANELS
     * ===================================== */
    public LoggedInPage clickProductManagerPanel( String userType , String panelName )
    {
        switch( userType )
        {
            case "Supplier":
                switch( panelName )
                {
                    case "View Agreements":  return clickPMSupplierPanelAgreements();
                    case "Content Loader":   return clickPMSupplierPanelContentLoader();
                    case "Upload Content":   return clickPMSupplierPanelUploadContent();
                    case "View Items":       return clickPMSupplierPanelViewItems();
                    case "View Price Lists": return clickPMSupplierPanelViewPriceLists();
                    case "View Media":       return clickPMSupplierPanelViewMedia();
                    default:
                        return null;
                }

            case "Buyer":
                switch( panelName )
                {
                    case "Manage Agreements":   return clickPMBuyerWorkflowCountAgreements();
                    case "Create Agreement":    return clickPMBuyerPanelAgreements();
                    case "Create a View":       return clickPMBuyerPanelViews();
                    case "Create Group":        return clickPMBuyerPanelGroups();
                    case "View your approvals": return clickPMBuyerPanelApprovals();
                    case "Manage your Coder":  return clickPMBuyerPanelCoder();
                    default:
                        return null;
                }

            default:
                return null;
        }
    }

    // SUPPLIER
    public ProductManagerPage clickPMSupplierPanelAgreements()
    {
        pmSupplierPanelAgreements.click();
        return new PublishAgreementsPage();
    }

    public ProductManagerPage clickPMSupplierPanelContentLoader()
    {
        pmSupplierPanelContentLoader.click();
        return null;
    }

    public LoggedInPage clickPMSupplierPanelUploadContent()
    {
        pmSupplierPanelUploadContent.click();
        return new ContentUploadPage();
    }

    public ProductManagerPage clickPMSupplierPanelViewItems()
    {
        pmSupplierPanelViewItems.click();
        return new ItemDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierPanelViewPriceLists()
    {
        pmSupplierPanelPriceLists.click();
        return new PriceListDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierPanelViewMedia()
    {
        pmSupplierPanelMedia.click();
        return new MediaDirectoryPage();
    }

    // BUYER
    public ProductManagerPage clickPMBuyerPanelAgreements()
    {
        waitUntillElementIsClickableAndClick(pmBuyerPanelCreateAgreement);
        return new CreateAgreementNewPage();
    }

    public ProductManagerPage clickPMBuyerPanelViews()
    {
        waitUntillElementIsClickableAndClick(pmBuyerPanelCreateView);
        return new CreateViewPage();
    }

    public ProductManagerPage clickPMBuyerPanelGroups()
    {
        waitUntillElementIsClickableAndClick(pmBuyerPanelCreateGroup);
        return new CreateGroupPage();
    }

    public ProductManagerPage clickPMBuyerPanelApprovals()
    {
        waitUntillElementIsClickableAndClick(pmBuyerPanelViewApprovals);
        return new ApprovalSchemeDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerPanelCoder()
    {
        waitUntillElementIsClickableAndClick(pmBuyerPanelManageYourCoder);
        return new CoderPage();
    }
}
