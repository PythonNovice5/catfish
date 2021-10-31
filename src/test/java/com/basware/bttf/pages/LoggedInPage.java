package com.basware.bttf.pages;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.contracts.ContractsPage;
import com.basware.bttf.pages.contracts.SupplierContractsPage;
import com.basware.bttf.pages.dashboard.DashboardPage;
import com.basware.bttf.pages.directory.DirectoryPage;
import com.basware.bttf.pages.documents.MyNotificationsPage;
import com.basware.bttf.pages.external.CatalogueAccessManagementPage;
import com.basware.bttf.pages.external.CatalogueManagementPage;
import com.basware.bttf.pages.external.ExternalPage;
import com.basware.bttf.pages.external.SupplierPortalPage;
import com.basware.bttf.pages.product_manager.ProductManagerDashboardPage;
import com.basware.bttf.pages.quotes.QuotesDirectoryPage;
import com.basware.bttf.pages.settings.*;
import com.basware.bttf.pages.shopping.notifications.ShoppingNotificationsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class LoggedInPage extends InternalPage
{
    protected static Logger LOGGER = Logger.getLogger(LoggedInPage.class.getName());

    // Main Menu Items
    @FindBy(className = "brand")
    public WebElement menuBaswareIcon;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

    @FindBy(id = "navHome")
    public WebElement menuDashboard;

    @FindBy(id = "navDocuments")
    public WebElement menuDocuments;

    @FindBy(id = "navShopping")
    public WebElement menuShopping;

    @FindBy(id = "navSupplierPortal")
    public WebElement menuSupplierPortal;

    @FindBy(id = "navProducts")
    public WebElement menuProductManager;

    @FindBy(id="navQuotes")
    public WebElement menuQuotes;

    @FindBy(id="navDirectory")

    public WebElement menuDirectory;

    @FindBy(id = "navContracts")
    public WebElement menuContracts;

    @FindBy(id = "navFieldglass")
    public WebElement menuFieldglass;

    @FindBy(id = "navMy_profile_UserSettings_btn")
    public WebElement menuMyProfile;

    @FindBy(xpath = "//*[contains(text(),'My Profile')]")
    public WebElement myProfileDropDownOption;

    @FindBy(xpath="//a[@id = \"navMy_profile_UserSettings_btn\"] |//a[@id = 'navMy_profile']")
    public WebElement menuLogout;

    @FindBy(className = "dropdown-backdrop")
    public WebElement backdrop;

    @FindBy(id = "keywords")
    private WebElement searchInput;

    @FindBy(name = "btn-search")
    private WebElement searchButton;

    // Settings dropdown
    @FindBy(id = "navSettings-SETTINGS_btn")
    public WebElement menuSettings;

    @FindBy(className = "dropdown-menu")
    public WebElement menuSettingsItems;

    @FindBy(linkText = "System Management")
    public WebElement settingsSystemManagement;

    @FindBy(linkText = "Analytics")
    public WebElement settingsAnalytics;

    @FindBy(linkText = "PDF e-Invoice")
    public WebElement settingsPDFeInvoice;

    @FindBy(linkText = "Identity Management")
    public WebElement settingsIdentityManagement;

    @FindBy(linkText = "Root Management")
    public WebElement settingsRootManagement;

    @FindBy(linkText = "Network management")
    public WebElement settingsNetworkManagement;

    @FindBy(linkText = "Community Management")
    public WebElement settingsCommunityManagement;

    @FindBy(linkText = "Community Registration")
    public WebElement settingsCommunityRegistration;

    @FindBy(linkText = "Organisation management")
    public WebElement settingsOrganisationManagement;

    @FindBy(id="navSupplierContracts")
    public WebElement SupplierContracts;

    @FindBy(linkText = "User Management")
    public WebElement settingsUserManagement;

    @FindBy(linkText = "Supplier Registration")
    public WebElement settingsSupplierRegistration;

    @FindBy(linkText = "Request a Supplier")
    public WebElement settingsRequestSupplier;

    @FindBy(linkText = "Request a Catalogue")
    public WebElement settingsRequestCatalogue;

    @FindBy(linkText = "Buyer registration")
    public WebElement settingsBuyerRegistration;

    @FindBy(linkText = "User registration")
    public WebElement settingsUserRegistration;

    @FindBy(linkText = "ePayment Registration")
    public WebElement settingsEPaymentRegistration;

    @FindBy(linkText = "Web Services Accounts")
    public WebElement settingsWebServicesAccounts;

    @FindBy(id="skip-tutorial-btn")
    public WebElement skipTutorialBtn;

    @FindBy(xpath =  "/html/body/div[2]/p")
    public WebElement organisationCurrentlyLoggedIn;

    @FindBy(id="app-dialog-confirm")
    public WebElement confirmSkip;

    @FindBy(linkText = "MIS Management")
    public WebElement settingsMISManagement;

    @FindBy(linkText = "Catalogue Access Management")
    public WebElement settingsCatalogueAccessManagement;

    @FindBy(linkText = "Catalogue Management")
    public WebElement settingsCatalogueManagement;

    @FindBy(linkText = "MIS reports")
    public WebElement settingsMISReport;

    @FindBy(css = ".toast-message")
    public WebElement toastMessage;

    private Map<String,WebElement> possibleMainMenuItems = null;
    Map<String,WebElement> possibleSettingsDropdownItems = null;

    public void validateUserMainMenuItems( User user ) throws Exception
    {
        LOGGER.debug( "Validating main menu items:" );

        possibleMainMenuItems = new HashMap<String,WebElement>(){{
            put( "HOME" , menuBaswareIcon );
            put( "DASHBOARD" , menuDashboard );
            put( "DOCUMENTS" , menuDocuments );
            put( "SHOPPING" , menuShopping );
            put( "SUPPLIERPORTAL" , menuSupplierPortal );
            put( "PRODUCTMANAGER" , menuProductManager );
            put( "QUOTES" , menuQuotes );
            put( "DIRECTORY" , menuDirectory );
            put( "CONTRACTS" , menuContracts );
            put( "FIELDGLASS" , menuFieldglass );
            put( "SETTINGS" , menuSettings );
            put( "MYPROFILE" , menuMyProfile );
        }};
        waitUntillElementIsClickableAndClick(skipTutorialBtn);
        waitUntillElementIsClickableAndClick(confirmSkip);
        validateItems(possibleMainMenuItems, user.getAllowedMainMenuItems());
    }

    public void validateSettingsDropdownItems(User user) throws Exception {
        if (user.getAllowedSettings().size() == 0) {
            LOGGER.debug("Not checking Settings items" + "\n");
            return;
        }

        LOGGER.debug("Validating user Settings items:");

        menuSettings.click();

        possibleSettingsDropdownItems = new HashMap<String, WebElement>() {{
            put("PDF e-Invoice",settingsPDFeInvoice);
            put("Analytics",settingsAnalytics);
            put("SYSTEM_MANAGEMENT", settingsSystemManagement);
            put("ROOT_MANAGEMENT", settingsRootManagement);
            put("NETWORK_MANAGEMENT", settingsNetworkManagement);
            put("COMMUNITY_MANAGEMENT", settingsCommunityManagement);
            put("COMMUNITY_REGISTRATION", settingsCommunityRegistration);
            put("ORGANISATION_MANAGEMENT", settingsOrganisationManagement);
            put("USER_MANAGEMENT", settingsUserManagement);
            put("SUPPLIER_REGISTRATION", settingsSupplierRegistration);
            put("WEB_SERVICES_ACCOUNTS", settingsWebServicesAccounts);
            put("MIS_MANAGEMENT", settingsMISManagement);
            put("CATALOGUE_ACCESS_MANAGEMENT", settingsCatalogueAccessManagement);
            put("CATALOGUE_MANAGEMENT", settingsCatalogueManagement);
            put("MIS_REPORTS", settingsMISReport);
        }};

        validateItems(possibleSettingsDropdownItems, user.getAllowedSettings());

        // The Settings button can be non-clickable due to presence of the backdrop, depending on the css in use.
        // So try clicking the backdrop and if it errors, because it is not there, click the Settings button
        try
        {
            menuSettings.click();
        }
        catch (Exception e)
        {
            backdrop.click();
        }
    }

    public void validateItems(Map<String, WebElement> possibleItems, Set<String> expectedItems) throws Exception {
        // first check that the allowed items are valid i.e. they all exist in possibleItems
        Set<String> difference = new HashSet<String>(expectedItems);
        difference.removeAll(possibleItems.keySet());
        assertTrue("INVALID ITEM(S) SPECIFIED - check environment users     json", difference.size() == 0);
        LOGGER.debug("All " + expectedItems.size() + " expected items are possible items");

        // then validate that all allowed items are present and displayed in the page
        for (String expectedItem : expectedItems) {
            WebElement webElement = possibleItems.get(expectedItem);
            LOGGER.debug("* item: " + expectedItem);
            webElement.isDisplayed();
        }
        LOGGER.debug("All expected items are displayed");

        // then validate that all remaining items are not present in the page
        difference = new HashSet<String>(possibleItems.keySet());
        difference.removeAll(expectedItems);

        for (String notExpectedItem : difference) {
            WebElement webElement = possibleItems.get(notExpectedItem);
            try {
                // if the element is missing webElement (as it should be) we expect the next line to throw a NoSuchElementException (which is caught and ignored)
                webElement.isEnabled();

                // ... however, if for some reason the item is present then we throw an uncaught exception to fail the test
                throw new Exception("Item " + notExpectedItem + " is NOT expected but is displayed");
            }
            catch (NoSuchElementException e) {
            }
        }
        LOGGER.debug("No unexpected items are displayed" + "\n");
    }

    /* =======================================
     * MENU ITEMS
     * ======================================= */
    public InternalPage navigateToInternalPageInline(String pageName) {
        InternalPage internalPage;
        waitUntilPageDocumentIsCompleted();
        switch (pageName) {
            case "dashboard":
                internalPage = navigateToMenuHome();
                break;
            case "Documents":
                internalPage = navigateToMenuDocuments();
                break;
            case "Shopping":
                internalPage = navigateToMenuShopping();
                break;
            case "Product Manager":
                internalPage = navigateToMenuProductManager();
                break;
            case "Directory":
                internalPage = navigateToMenuDirectory();
                break;
            case "Contracts":
                internalPage = navigateToMenuContracts();
                break;
            case "SupplierContracts":
                internalPage = navigateToSupplierContracts();
                break;
            case "My Profile":
                internalPage = navigateToMyProfile();
                break;
            case "Quotes":
                internalPage = navigateToQuotes();
                break;
            default:
                internalPage = super.navigateToInternalPageInline(pageName);
                break;
        }

        return internalPage;
    }

    public LoggedInPage navigateToInternalPageNewWindow(String pageName) {
        LoggedInPage internalPage = null;

        switch (pageName) {
            case "Fieldglass":
                internalPage = navigateToMenuFieldglass();
        }

        switchToNewWindow(internalPage);

        return internalPage;
    }

    public String getTextOfToastMessage() throws Exception{
        return getTextOfWebElement(toastMessage);
    }



    @Override
    public ExternalPage navigateToExternalPageInline(String pageName) {
        ExternalPage externalPage = null;

        switch (pageName) {
            case "Supplier Portal":
                externalPage = navigateToMenuSupplierPortal();
                break;
            default:
                externalPage = super.navigateToExternalPageInline(pageName);
                break;
        }

        return externalPage;
    }

    public LoggedInPage navigateBaswareIcon() {
        menuBaswareIcon.click();
        return this;
    }

    public LoggedInPage navigateToMenuHome() {
        menuDashboard.click();
        return new DashboardPage();
    }

    public LoggedInPage navigateToMenuDocuments() {
        menuDocuments.click();
        return new MyNotificationsPage();
    }

    public LoggedInPage navigateToMenuShopping() {
        waitUntilAnyAJAXIsCompleted();
        waitUntillElementIsClickableAndClick(menuShopping);
        return new ShoppingNotificationsPage();
    }

    public ExternalPage navigateToMenuSupplierPortal() {
        menuSupplierPortal.click();
        return new SupplierPortalPage();
    }

    public LoggedInPage navigateToMenuProductManager() {
        waitUntillElementIsClickableAndClick(menuProductManager);
        return new ProductManagerDashboardPage();
    }

    public LoggedInPage navigateToMenuDirectory() {
        menuDirectory.click();
        return new DirectoryPage();
    }

    public LoggedInPage navigateToMenuContracts() {
        menuContracts.click();
        return new ContractsPage();
    }

    public SupplierContractsPage navigateToSupplierContracts(){
        waitUntillElementIsClickableAndClick(SupplierContracts);
        return new SupplierContractsPage();
    }

    public LoggedInPage navigateToMenuFieldglass() {
        menuFieldglass.click();
        return new FieldglassPage();
    }

    public LoggedInPage navigateToMyProfile() {
        menuMyProfile.click();
        myProfileDropDownOption.click();
        return new MyProfilePage();
    }

    public QuotesDirectoryPage navigateToQuotes(){
//        menuQuotes.click();
        waitUntillElementIsClickableAndClick(menuQuotes);
        return new QuotesDirectoryPage();
    }

//    public LoginPage logOut() {
//        waitUntilNoModalPopup();        // give time for any modal popup that was displayed to fade out
//        waitUntilAnyAJAXIsCompleted();  // give time for any AJAX to complete
//        scrollToElement(menuLogout);    // click sometimes doesn't work if the element is scrolled out of sight
//        menuLogout.click();
//        waitUntilPageDocumentIsCompleted();
//        return new LoginPage();
//    }

    public LoginPage logOut() {
        waitUntilNoModalPopup();        // give time for any modal popup that was displayed to fade out
//        waitUntilAnyAJAXIsCompleted();  // give time for any AJAX to complete
        scrollToElement(menuLogout);
        waitUntillElementIsClickableAndClick(menuLogout);    // click sometimes doesn't work if the element is scrolled out of sight
//        menuLogout.click();
        waitUntillElementIsClickableAndClick(logoutLink);
//        logoutLink.click();
        waitUntilPageDocumentIsCompleted();
        return new LoginPage();
    }

    /* =======================================
     * SETTINGS
     * ======================================= */
    public LoggedInPage navigateToInternalSettingsPageInline(String pageName) {

        waitUntillElementIsClickableAndClick(menuSettings);
        switch (pageName) {
            // settings pages
            case "System Management":
                return navigateToSettingsSystemManagement();
            case "Identity Management":
                return navigateToSettingsIdentityManagement();
            case "Root Management":
                return navigateToSettingsRootManagement();
            case "Network Management":
                return navigateToSettingsNetworkManagement();
            case "Community Management":
                return navigateToSettingsCommunityManagement();
            case "Community Registration":
                return navigateToSettingsCommunityRegistration();
            case "Organisation Management":
                return navigateToSettingsOrganisationManagement();
            case "User Management":
                return navigateToSettingsUserManagement();
            case "Supplier Registration":
                return navigateToSettingsSupplierRegistration();
            case "Request a Supplier":
                return navigateToSettingsRequestSupplier();
            case "Request a Catalogue":
                return navigateToSettingsRequestCatalogue();
            case "Buyer Registration":
                return navigateToSettingsBuyerRegistration();
            case "User Registration":
                return navigateToSettingsUserRegistration();
            case "E-Payment Registration":
                return navigateToSettingsEPaymentRegistration();
            case "Web Services Accounts":
                return navigateToSettingsWebServicesAccounts();
            case "MIS reports":
                return navigateToSettingsMIS();
            case "MIS Management":
                return navigateToSettingsMISManagement();
        }

        return null;
    }

    public ExternalPage navigateToExternalSettingsPageNewWindow(String pageName) {
        ExternalPage externalPage = null;

        if (!menuSettingsItems.isDisplayed()) {
            menuSettings.click();
        }
        waitUntilDisplayed(menuSettingsItems);

        switch (pageName) {
            case "Catalogue Access Management":
                externalPage = navigateToSettingsCatalogueAccessManagement();
                break;
            case "Catalogue Management":
                externalPage = navigateToSettingsCatalogueManagement();
                break;
        }

        switchToNewWindow(externalPage);

        return externalPage;
    }

    public void clickSettings() {
        menuSettings.click();
    }

    private LoggedInPage navigateToSettingsSystemManagement() {
        settingsSystemManagement.click();
        return new SystemManagementPage();
    }

    private LoggedInPage navigateToSettingsIdentityManagement() {
        settingsIdentityManagement.click();
        return new IdentityManagementPage();
    }

    private LoggedInPage navigateToSettingsRootManagement() {
        settingsRootManagement.click();
        return new RootManagementPage();
    }

    private LoggedInPage navigateToSettingsNetworkManagement() {
        settingsNetworkManagement.click();
        return new NetworkManagementPage();
    }

    private LoggedInPage navigateToSettingsCommunityManagement() {
        settingsCommunityManagement.click();
        return new CommunityManagementPage();
    }

    private LoggedInPage navigateToSettingsCommunityRegistration() {
        settingsCommunityRegistration.click();
        return new CommunityRegistrationPage();
    }

    private LoggedInPage navigateToSettingsOrganisationManagement() {
        settingsOrganisationManagement.click();
        return new OrganisationManagementPage();
    }

    private LoggedInPage navigateToSettingsUserManagement() {
        settingsUserManagement.click();
        return new UserManagementPage();
    }

    private LoggedInPage navigateToSettingsSupplierRegistration() {
        settingsSupplierRegistration.click();
        return new SupplierRegistrationPage();
    }

    private LoggedInPage navigateToSettingsRequestSupplier() {
        settingsRequestSupplier.click();
        return new RequestSupplierPage();
    }

    private LoggedInPage navigateToSettingsRequestCatalogue() {
        settingsRequestCatalogue.click();
        return new RequestCataloguePage();
    }

    private LoggedInPage navigateToSettingsBuyerRegistration() {
        settingsBuyerRegistration.click();
        return new BuyerRegistrationPage();
    }

    private LoggedInPage navigateToSettingsUserRegistration() {
        settingsUserRegistration.click();
        return new UserRegistrationPage();
    }

    private LoggedInPage navigateToSettingsEPaymentRegistration() {
        settingsEPaymentRegistration.click();
        return new EPaymentRegistrationPage();
    }

    private LoggedInPage navigateToSettingsWebServicesAccounts() {
        settingsWebServicesAccounts.click();
        return new WebServicesAccountsPage();
    }

    private LoggedInPage navigateToSettingsMIS()
    {
        hoverToElement(settingsMISReport);
        waitUntillElementIsClickableAndClick(settingsMISReport);
        return new MisDashBoardPage();
    }

    private LoggedInPage navigateToSettingsMISManagement()
    {
        settingsMISManagement.click();
        return new MisManagementPage();
    }

    private ExternalPage navigateToSettingsCatalogueAccessManagement() {
        settingsCatalogueAccessManagement.click();
        return new CatalogueAccessManagementPage();
    }

    private ExternalPage navigateToSettingsCatalogueManagement() {
        settingsCatalogueManagement.click();
        return new CatalogueManagementPage();
    }

    public WebElement getWebElementNamed( String elementName ) throws Exception
    {
        try
        {
            return (WebElement) this.getClass().getDeclaredField(elementName).get(this);
        }
        catch (Exception exception)
        {
            throw new Exception( "getWebElementNamed(): Cannot find a WebElement with the name: " + elementName );
        }
    }

    protected WebElement getWebElement(String elem) throws Exception{

        return getWebElementNamed(elem);

    }

    // Handy method that returns the List of WebElements that has the given name
    protected List<WebElement> getWebElementListNamed(String elementListName ) throws Exception
    {
        try {
            return (List<WebElement>)this.getClass().getDeclaredField(elementListName).get(this);
        }
        catch (Exception exception) {
            throw new Exception("getWebElementListNamed(): Cannot find a List of WebElements with the name: " + elementListName);
        }
    }

    // Returns true when the element is present and displayed
    public boolean elementIsDisplayed( String elementName )
    {
        try
        {
            waitUntilDisplayed( getWebElementNamed( elementName) );
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    // Returns true when the element is not present or not displayed
    public boolean elementIsNotDisplayed( String elementName )
    {
        try {
            return !getWebElementNamed( elementName ).isDisplayed();
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return true;
        }
    }

    // Clears and sets the text or value of the element
    public void enterValueIntoElement( String value, String elementName ) throws Exception
    {
        pauseFor(1000);
        setValueOfWebElement( getWebElementNamed( elementName ), value );
    }

    // Returns the displayed text or value of the element
    public String getElementValue( String elementName ) throws Exception
    {
        return getTextOfWebElement( getWebElementNamed( elementName ));
    }

    public int getListElementCount(String elementListName) throws Exception
    {
        return getWebElementListNamed( elementListName ).size();
    }

    public void searchKeyword(String keyword)
    {
        searchInput.sendKeys(keyword);
        waitUntillElementIsClickableAndClick(searchButton);
    }
}