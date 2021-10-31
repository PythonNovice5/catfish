package com.basware.bttf.pages.product_manager;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.product_manager.Loader.TwoStageLoaderDashboardPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.AgreementDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.agreements_supplier.PublishAgreementsPage;
import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.categories.ManageCategoriesPage;
import com.basware.bttf.pages.product_manager.buyer.groups.GroupDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.views.ViewDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.media.MediaDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.PriceListDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.supplier_delegation.BaswareUkDashBoardPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ItemTemplateDirectoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Wait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ProductManagerPage extends LoggedInPage
{

    @FindBy( xpath="//label[text()='Enabled:']//..//..//div[normalize-space(@class)='toggle null checked']")
    public WebElement ToggleStateEnable;

    @FindBy(name="keywords")
    public WebElement searchBox;

    @FindBy(name="btn-search")
    public WebElement searchBtn;

    @FindBy( xpath="//label[text()='Enabled:']//..//..//div[normalize-space(@class)='toggle null']")
    public WebElement ToggleStateDisable;

    @FindBy( xpath="//span[@class='glyphicon glyphicon-plus']")
    public WebElement PlusButton;

    @FindBy(name="alertMessageDetail")
    public WebElement Alert;
    
    // SUPPLIER SUBMENU
    @FindBy( xpath="//a[span[@title='Home']]")          // needs improvement
    public WebElement pmSupplierSubmenuHomeIcon;

    @FindBy( id="manageProducts" )
    public WebElement pmSupplierSubmenuItems;

    @FindBy( id="manageItemTemplates" )
    public WebElement pmSupplierSubmenuItemTemplates;

    @FindBy( id="manageMedia" )
    public WebElement pmSupplierSubmenuMedia;

    @FindBy( id="managePriceLists" )
    public WebElement pmSupplierSubmenuPriceLists;

    @FindBy( id = "loader")
    public WebElement pmSupplierSubmenuLoader;

    @FindBy( id="publishAgreements" )
    public WebElement pmSupplierSubmenuAgreements;

    @FindBy(linkText = "Publish")
    public WebElement publishAgreement;

    //java.util.Date date= new java.util.Date();
    //java.util.Date d = new java.util.Date();
    private String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    // BUYER SUBMENU
    @FindBy( xpath="//a[span[@title='Home']]")          // needs improvement
    public WebElement pmBuyerSubmenuHomeIcon;

    @FindBy( id="manageAgreements" )
    public WebElement pmBuyerSubmenuAgreements;

    @FindBy( id="manageGroups" )
    public WebElement pmBuyerSubmenuGroups;

    @FindBy( id="manageViews" )
    public WebElement pmBuyerSubmenuViews;

    @FindBys( { @FindBy( linkText="Approvals") } )          // needs improvement
    public WebElement pmBuyerSubmenuApprovals;

    @FindBy(css = "[title='Manage agreements']")
    public WebElement AgreementsBtn;

    @FindBy(linkText = "Suppliers")
    public WebElement pmBuyerSubmenuSuppliers;

    @FindBy(xpath = "//span[text()='Categories']")
    public WebElement pmBuyerSubmenuCategories;

    @FindBy(id="addAgreement_0")
    public WebElement agreementAddBtn;

    @FindBy(xpath = "//*[@id='manage-suppliers-drop']//a/span")
    public WebElement actAsSupplierCog;

    @FindBy(xpath = "//span[@title='Mode']")
    public WebElement mode;

    @FindBy(linkText = "Buyer")
    public WebElement buyerMode;

    @FindBy(linkText = "Supplier")
    public WebElement supMode;

    @FindBy(xpath="//a[contains(text(),\'Done\')]|//button[contains(text(),'Done')]")
    public WebElement doneBtn;

    public Boolean validateSubmenuItems( User user ) throws Exception
    {
        final Map<String,WebElement> supplierSubmenuItems = new HashMap<String,WebElement>(){{
            put( "Home" , pmSupplierSubmenuHomeIcon );
            put( "Items" , pmSupplierSubmenuItems );
            put( "Item Templates" , pmSupplierSubmenuItemTemplates );
            put( "Media" , pmSupplierSubmenuMedia );
            put( "Price Lists" , pmSupplierSubmenuPriceLists );
            put( "Agreements" , pmSupplierSubmenuAgreements );
        }};

        final Map<String,WebElement> buyerSubmenuItems = new HashMap<String,WebElement>(){{
            put( "Home" , pmBuyerSubmenuHomeIcon );
            put( "Agreements" , pmBuyerSubmenuAgreements );
            put( "Groups" , pmBuyerSubmenuGroups );
            put( "Views" , pmBuyerSubmenuViews );
            put( "Approvals" , pmBuyerSubmenuApprovals );
        }};

        Map<String,WebElement> allowedItems = new HashMap<String,WebElement>();
        Map<String,WebElement> forbiddenItems = new HashMap<String,WebElement>();

        if( user.getIsBuyer() && user.getIsSupplier() )
        {
            allowedItems.putAll( supplierSubmenuItems );
            allowedItems.putAll( buyerSubmenuItems );
        }
        else if( user.getIsBuyer() )
        {
            allowedItems.putAll(buyerSubmenuItems);
            forbiddenItems.putAll(supplierSubmenuItems);
        }
        else
        {
            allowedItems.putAll(supplierSubmenuItems);
            forbiddenItems.putAll(buyerSubmenuItems);
        }

        for( Map.Entry<String,WebElement> entry : allowedItems.entrySet() )
        {
            WebElement we = entry.getValue();
            LOGGER.debug( "validateSubmenuItems() - item: " + entry.getKey() );
            we.isDisplayed();
        }

        for( Map.Entry<String,WebElement> entry : forbiddenItems.entrySet() )
        {
            try
            {
                WebElement we = entry.getValue();
                // if the element is missing we (as it should be) we expect the next line to throw a NoSuchElementException (which is caught and ignored)
                we.isEnabled();

                // ... however, if for some reason the item is present then we throw an uncaught exception to fail the test
                throw new Exception( "Item " + entry.getKey() + " should not be displayed but is" );
            }
            catch( NoSuchElementException e){}
        }

        return true;
    }

    public ProductManagerPage clickPMSupplierSubmenuLoader()
    {
        waitUntillElementIsClickableAndClick(pmSupplierSubmenuLoader);
        return new TwoStageLoaderDashboardPage();
    }


    /* ============================
     * NAVIGATION METHODS
     * ============================ */

    public ProductManagerPage clickProductManagerSubmenuItem( String  userType , String submenuItem ) throws Exception
        {
         switch( userType )
        {
            case "Supplier":
                switch( submenuItem )
                {
                    case "Home":           return clickPMSupplierSubmenuHome();
                    case "Items":          return clickPMSupplierSubmenuItems();
                    case "Item Templates": return clickPMSupplierSubmenuItemTemplates();
                    case "Media":          return clickPMSupplierSubmenuMedia();
                    case "Price Lists":    return clickPMSupplierSubmenuPriceLists();
                    case "Agreements":     return clickPMSupplierSubmenuAgreements();
                    case "Loader":         return clickPMSupplierSubmenuLoader();
                    default:
                        return null;
                }

            case "Buyer":
                switch( submenuItem )
                {
                    case "Home":       return clickPMBuyerSubmenuHome();
                    case "Agreements": return clickPMBuyerSubmenuAgreements();
                    case "Groups":     return clickPMBuyerSubmenuGroups();
                    case "Views":
                        return clickPMBuyerSubmenuViews();
                    case "Approvals":  return clickPMBuyerSubmenuApprovals();
                    case "Categories": return clickPMBuyerSubmenuCategories();
                    case "Suppliers": return clickPMBuyerSubmenuSuppliers();
                    case "Item Templates": return clickPMSupplierSubmenuItemTemplates();
                    case "Loader":         return clickPMSupplierSubmenuLoader();
                    default:
                        return null;
                }

            default:
                return null;
        }

    }


    // SUPPLIER
    public ProductManagerPage clickPMSupplierSubmenuHome()
    {
        pmSupplierSubmenuHomeIcon.click();
        return new ProductManagerDashboardPage();
    }

    public void selectUserMode(String userMode){
        waitUntillElementIsClickableAndClick(mode);
        switch(userMode){

            case "Supplier":
                waitUntillElementIsClickableAndClick(supMode);
                break;
            case "Buyer":
                waitUntillElementIsClickableAndClick(buyerMode);
                break;
            default:
                LOGGER.debug("Not a valide user mode ..");
                break;
        }

    }

    public ProductManagerPage clickPMSupplierSubmenuItems()
    {
        pauseFor(1000);
        scrollToElement(pmSupplierSubmenuItems);
//        pauseFor(2000);
        waitUntillElementIsClickableAndClick(pmSupplierSubmenuItems);
//        pmSupplierSubmenuItems.click();
        return new ItemDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierSubmenuItemTemplates()
    {
        waitUntillElementIsClickableAndClick(pmSupplierSubmenuItemTemplates);
        return new ItemTemplateDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierSubmenuMedia()
    {
        waitUntillElementIsClickableAndClick(pmSupplierSubmenuMedia);
        return new MediaDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierSubmenuPriceLists()
    {
        waitUntillElementIsClickableAndClick(pmSupplierSubmenuPriceLists);
//        pmSupplierSubmenuPriceLists.click();
        return new PriceListDirectoryPage();
    }

    public ProductManagerPage clickPMSupplierSubmenuAgreements()
    {
        waitUntillElementIsClickableAndClick(pmSupplierSubmenuAgreements);
        return new PublishAgreementsPage();
    }


    // BUYER
    public ProductManagerPage clickPMBuyerSubmenuHome()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuHomeIcon);
        return new ProductManagerDashboardPage();
    }

    public ProductManagerPage clickPMBuyerSubmenuAgreements()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuAgreements);
        return new AgreementDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerSubmenuGroups()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuGroups);
        return new GroupDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerSubmenuViews()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuViews);
        return new ViewDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerSubmenuApprovals()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuApprovals);
        return new ApprovalSchemeDirectoryPage();
    }

    public ProductManagerPage clickPMBuyerSubmenuCategories()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuCategories);
        return new ManageCategoriesPage();
    }

    public ProductManagerPage clickPMBuyerSubmenuSuppliers()
    {
        waitUntillElementIsClickableAndClick(pmBuyerSubmenuSuppliers);
        waitUntillElementIsClickableAndClick(actAsSupplierCog);
        return new ProductManagerDashboardPage();
    }

    public void clickAddBtn(String xpathValue){
//        pauseFor(500);
        WebElement toBeClicked = driver.findElement(By.xpath(xpathValue));
//        toBeClicked.click();
        waitUntillElementIsClickableAndClick(toBeClicked);
    }

    public void clickPlusBtn()
    {
        waitUntillElementIsClickableAndClick(PlusButton);
        pauseFor(1000);
        waitUntilPageDocumentIsCompleted();
    }

    public boolean clickDoneBtn(){
        waitUntillElementIsClickableAndClick(doneBtn);
        LOGGER.debug("Clicked on Done button successfully..");
        return true;
    }


    public void clickByXpath(String xpathValue){

        pauseFor(500);
        WebElement toBeClicked = driver.findElement(By.xpath(xpathValue));
        toBeClicked.click();
    }

    public void clearAllData() throws Exception {
        try {
            List<WebElement> minus = driver.findElements(By.xpath("//*[@id='ranges']//span[@class='glyphicon glyphicon-minus']"));
            for (int i = 0; i < minus.size(); i++) {
                if (minus.get(i).isDisplayed()) {
                    minus.get(i).click();
                    pauseFor(2500);
                }
            }
        } catch (ElementNotVisibleException e) {
            LOGGER.debug("Minus button was not found");
        }
    }

    public void verifyMessage(String alert) throws Exception{
        waitUntilDisplayed(Alert);
        pauseFor(5000);
        assertTrue("Expected Alert message was not found! Instead found -" +getTextOfWebElement(Alert),getTextOfWebElement(Alert).contains(alert));
        LOGGER.debug("Expected Alert message was found on the web page as - "+alert);
    }

    public void enableOrDisable(String state)
    {
        switch (state){
                case "Disable":
                    try {
                        if (ToggleStateEnable.isDisplayed()) {
                            ToggleStateEnable.click();
                            LOGGER.debug("Switched OFF the toggle button");
                            break;
                        }
                    }
                    catch (NoSuchElementException n){

                        if (ToggleStateDisable.isDisplayed()) {
                            LOGGER.debug("the toggle button is already OFF");
                            break;
                        }
                    }
                    case "Enable":
                        try {
                            if (ToggleStateDisable.isDisplayed()) {
                                ToggleStateDisable.click();
                                LOGGER.debug("Switched ON the toggle button..");
                                break;
                            }
                        }
                        catch (NoSuchElementException n)
                        {
                                if (ToggleStateEnable.isDisplayed()) {
                                    LOGGER.debug("Toggle switch is already ON");
                                    break;
                                }
                        }
             }

         }

     }





