package com.basware.bttf.pages;

import com.basware.bttf.domain.Environment;
import com.basware.bttf.util.TestProperties;
import com.basware.webdriver.manager.Driver;
import org.apache.commons.exec.TimeoutObserver;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public abstract class AbstractPage extends LoadableComponent
{

    protected static Logger LOGGER = Logger.getLogger( AbstractPage.class.getName() );
    protected Environment env = Environment.getInstance();
    protected TestProperties props = TestProperties.getInstance();
    protected WebDriver driver = Driver.getDriver();
    protected String testEnv = System.getProperty("test.env");
    WebDriverWait wait = new WebDriverWait(driver, 15);
    // define/override in properties?
    private static final int DEFAULT_WEBDRIVER_WAIT = 30;
    private static final int ELEMENT_STATUS_CHECK_WAIT = 15; // maximum time to wait for an element to get to an expected status
    private static final int MODAL_POPUP_WAIT = 10;          // maximum time to wait for modal pop-up to be fully displayed or concealed
    private static final int DEFAULT_UPLOAD_WAIT = 120;
    private static final int SEARCH_RETRY_WAIT = 10;         // maximum time to retry searching because the index is still being updated
    private String windowHandle;
    public abstract String  getExpectedUrl();
    public abstract String getExpectedTitle();

    // isLoaded() is called by LoadableComponent.get() when AbstractSteps.setCurrentPage is called
    protected void isLoaded()
    {

//        if( (wait.until(ExpectedConditions.titleContains(getExpectedTitle()))) & driver.getCurrentUrl().contains(getExpectedUrl()) )
        if(wait.until(ExpectedConditions.titleContains(getExpectedTitle())))
        {
            if(driver.getCurrentUrl().contains(getExpectedUrl()))
            {
                LOGGER.debug(">>>>>>>>>> Current page title: " + driver.getTitle() + "\n");
            }

        }

        else
        {
            LOGGER.debug("***** Expected Title: " + getExpectedTitle() );
            LOGGER.debug("***** Actual Title:   " + driver.getTitle() );
            LOGGER.debug("***** Expected URL:   " + getExpectedUrl() );
            LOGGER.debug("***** Actual URL:     " + driver.getCurrentUrl() + "\n" );
            throw new RuntimeException( "***** Unexpected page is loaded" );
        }
    }

    protected void load()
    {
        LOGGER.debug("AbstractPage.load() call");
        loadPage();
    }

    public void loadPage()
    {
        LOGGER.debug("AbstractPage.loadPage() call");
        driver.get( getExpectedUrl() );
    }

    public void hoverToElement(WebElement elem)
    {
        Actions action= new Actions(driver);
        action.moveToElement(elem).perform();
        pauseFor(1000);
    }


//    Boolean elem = wait.until(ExpectedConditions.titleContains(getExpectedTitle()));

    protected void pauseFor(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {}
    }

    public void back()
    {
        driver.navigate().back();
    }

    public String getBaseUrl()
    {
        return env.getBttfBaseUrl();
    }

    public static WebDriverWait createWebDriverWait(WebDriver driver, long timeOutInSeconds)
    {
        return new WebDriverWait( driver , timeOutInSeconds );
    }

    public WebDriverWait getDefaultDriverWait()
    {
        return createWebDriverWait( driver , DEFAULT_WEBDRIVER_WAIT );
    }

    public WebDriverWait getElementStatusCheckWait()
    {
        return createWebDriverWait( driver , ELEMENT_STATUS_CHECK_WAIT );
    }

    public WebDriverWait getElementStatusCheckWait(int time)
    {
        return createWebDriverWait( driver , time);
    }



    public WebDriverWait getModalPopupWait()
    {
        return createWebDriverWait( driver , MODAL_POPUP_WAIT );
    }

    public WebDriverWait getDefaultUploadWait()
    {
        return createWebDriverWait( driver , DEFAULT_UPLOAD_WAIT );
    }

    public int timeToRetrySearch() { return SEARCH_RETRY_WAIT; }

    // (JS) Just wait a certain number of seconds, by checking for something that will never be and catching the timeout
    public void waitForANumberOfSeconds( int number_of_seconds )
    {
        try {
            createWebDriverWait( driver , number_of_seconds ).until( ExpectedConditions.titleIs( "A fictitious page title!" ) );
        }
        catch (Exception exception) {
            // It is expected always to get here, due to timeout. Don't need to do anything more.
        }
    }

    // (JS) Returns when page document construction/display has completed (or timeout expires)
    public void waitUntilPageDocumentIsCompleted() throws TimeoutException
    {
        try {
            getDefaultDriverWait().until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver wdriver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState" ).equals("complete");
                }
            });
        }
        catch (Exception exception) {
            throw new RuntimeException("Page display did not complete within timeout");
        }
    }

    // (JS) Returns when any AJAX actions have completed (or timeout expires)
    public void waitUntilAnyAJAXIsCompleted() throws TimeoutException
    {
        // Check for presence of AJAX
        Boolean AJAXisPresent = false;
        try {
            // following will error if no AJAX
            ((JavascriptExecutor) driver).executeScript("return jQuery.active" );
            AJAXisPresent = true;       // there is AJAX
        }
        catch (Exception exception) {
            AJAXisPresent = false;      // no AJAX
        }
        if (AJAXisPresent) {
            // This waits for any AJAX actions to be completed
            getDefaultDriverWait().until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver wdriver) {
                    return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
                }
            });
        }
    }

    // (JS) Returns when element has become stale (or timeout expires)
    public Boolean isWebElementStale( final WebElement webElement )
    {
        try
        {
            getElementStatusCheckWait().until ( ExpectedConditions.not(ExpectedConditions.stalenessOf( webElement )) );
            return false;
        }
        catch (Exception exception) {
            return true;
        }
    }


    public Boolean waitUntillElementIsClickableAndClick(WebElement webElement) throws TimeoutException
    {
        try{
            waitUntilDisplayed(webElement);
            WebElement e= wait.until( ExpectedConditions.elementToBeClickable( webElement ));
            e.click();
        }

        catch (StaleElementReferenceException s){
//            driver.navigate().refresh();
            webElement.click();
            LOGGER.debug(s.getMessage());
        }
        catch (TimeoutException t){
            webElement.click();
            LOGGER.debug(t.getMessage());
        }
        catch (ElementClickInterceptedException e){
            pauseFor(1000);
            webElement.click();
        }
//        pauseFor(1000);
        return true;
    }


    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }


    // (JS) Returns when element has become stale (or timeout expires)
    public void waitUntilStale( final WebElement webElement )
    {
        getElementStatusCheckWait().until( ExpectedConditions.stalenessOf( webElement ) );
    }

    // (JS) Returns when element is displayed (or timeout expires)
    public void waitUntilDisplayed( final WebElement webElement ) throws TimeoutException
    {
        getElementStatusCheckWait().until( new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d)
            {
                return webElement.isDisplayed();
            }
            @Override
            public String toString() { return "WebElement " + webElement + " was not displayed within the timeout"; }
        } );
    }


    // (JS) Returns true when Bootstrap AJAX modal popup dialogue is displayed (within the timeout period) or an exception
    public Boolean waitUntilModalPopupDisplayed() throws TimeoutException
    {
//        getModalPopupWait().until( ExpectedConditions.presenceOfElementLocated( By.className( "modal-backdrop" ) ) );
        getModalPopupWait().until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//*[@aria-modal='true']|//*[contains(@class,'toast-success')]|//*[@id='userModal']/div" ) ) );
        return true;
    }

    // (JS) Returns true when Bootstrap AJAX modal popup dialogue has closed or is not displayed (within the timeout period) or an exception
    public Boolean waitUntilNoModalPopup() throws TimeoutException
    {
        getModalPopupWait().until( ExpectedConditions.numberOfElementsToBe(By.xpath( "//*[@aria-modal='true']|//*[contains(@class,'toast-success')]" ), 0 ) );
        return true;
    }

    // (JS) Returns true when element is enabled.  Returns false when not enabled, not displayed or display timeout expires
    public Boolean isWebElementEnabled( final WebElement webElement )
    {
        try {
            waitUntilDisplayed(webElement); // make sure the element is displayed before continuing
        }
        catch (Exception exception) {
            return false;
        }
        return webElement.isEnabled();      // is element clickable
    }

    // (JS) Returns the trimmed display text of the element
    public String getTextOfWebElement( WebElement webElement ) throws Exception
    {
        waitUntilDisplayed( webElement );   // make sure the element is displayed before continuing
        return webElement.getText().trim();
    }

    // (JS) Returns the trimmed value of an attribute of the element
    public String getAttributeValueOfWebElement( WebElement webElement, String attributeName ) throws Exception
    {
        waitUntilDisplayed( webElement );   // make sure the element is displayed before continuing
        return webElement.getAttribute(attributeName).trim();
    }

    // Clears any existing value and enters a new value into the element
    public void setValueOfWebElement( WebElement webElement, String value ) throws Exception
    {
        waitUntilDisplayed( webElement );   // make sure the element is displayed before continuing
//        webElement.click();
        webElement.clear();
        webElement.sendKeys( value );

    }

    // Clears any existing value and enters a new value into the element, one character at a time
    // For use with an element where AJAX interactively refreshes the page content while the value is keyed in
    public void setValueOfAJAXInteractiveWebElement( WebElement webElement, String value ) throws Exception
    {
        waitUntilDisplayed( webElement );   // make sure the element is displayed before continuing
        webElement.clear();
        waitUntilAnyAJAXIsCompleted();
        for(int i=0; i<value.length(); i++)
        {
            webElement.sendKeys( StringUtils.substring(value, i, i + 1) );
            waitUntilAnyAJAXIsCompleted();
        }
    }

    // (JS) Clicks on the element
    public void clickWebElement( WebElement webElement )
    {
        waitUntilDisplayed( webElement );   // make sure the element is displayed before continuing
//        scrollToElement( webElement );      // click sometimes doesn't work if the element is scrolled out of sight
        webElement.click();

    }

    // (JS) Returns the first 20 characters of PRC_SESSION cookie value (a GUID that has the same value throughout the session)
    public String getSessionID()
    {
        Cookie prc_session = driver.manage().getCookieNamed("PRC_SESSION");
        if (prc_session != null)
            return prc_session.getValue().substring(0,19);
        else
            return "NULL";
    }

    public static String genUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // Find the first HTML <a /> link element that has (partially) matching href attribute and clicks on it e.g. <a href="http://href">Click this link<a>
    protected void clickLinkByHref( String href )
    {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext())
        {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href))
            {
                anchor.click();
                break;
            }
        }
    }

    // (JS) Returns the element from a list of elements that has the text or value attribute matching a text
    public WebElement getElementByTextFromListOfElements(List<WebElement> listOfWebElements, String searchText) throws Exception
    {
        String elementText;
        for( WebElement element: listOfWebElements )
        {
            try
            {
                elementText = element.getAttribute("value").trim();
            }
            catch (Exception e)
            {
                elementText = element.getText().trim();
            }
            if(elementText.equals(searchText))
            {
                return element;
            }
        }
        throw new Exception( searchText + " not found in list" );
    }

    // (JS) Returns the element from a list of elements corresponding to the element from a list of elements that has the text or value attribute matching a text
    // WARNING! Does not work when the element being sought may or may not be present e.g. either an add or remove button is present
    public WebElement getAssociatedElementFromListOfElements(List<WebElement> correspondingListOfWebElements, List<WebElement> searchableListOfWebElements, String searchText ) throws Exception
    {
        String elementText;
        for(int i=0; i<searchableListOfWebElements.size(); i++)
        {
            try
            {
                elementText = searchableListOfWebElements.get(i).getAttribute("value").trim();
            }
            catch (Exception e)
            {
                elementText = searchableListOfWebElements.get(i).getText().trim();
            }
            if(elementText.equals(searchText))
            {
                return correspondingListOfWebElements.get(i);
            }
        }
        throw new Exception( searchText + " not found in list" );
    }


    // Returns the trimmed text of the currently selected <option /> of an HTML <select /> dropdown element
    public String getSelectedTextOfDropdownWebElement( WebElement dropdownElement ) throws Exception
    {
        waitUntilDisplayed( dropdownElement );
        Select select = new Select( dropdownElement );
        return select.getFirstSelectedOption().getText().trim();
    }

    // Selects the option of an HTML <select /> dropdown element that has matching text e.g. <option value="value">text</option>
    public void selectDropdownOptionByText( WebElement dropdownElement , String text ) throws Exception
    {
        waitUntilDisplayed( dropdownElement );
        Select select = new Select( dropdownElement );
        select.selectByVisibleText( text );
    }

    // Selects the option of an HTML <select /> dropdown element that matches the value e.g. <option value="value">text</option>
    protected void selectDropdownOptionByValue( WebElement dropdownElement , String value )
    {
        waitUntilDisplayed( dropdownElement );
        Select select = new Select( dropdownElement );
        select.selectByValue( value );
    }

    // (JS) Checks whether a modal alert dialog box is being displayed (This is not the Bootstrap modal pop-up)
    public boolean isModalAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    // (JS) Clicks one of modal alert dialog box buttons (This is not the Bootstrap modal pop-up)
    public void clickModalAlertButton( String acceptOrDismiss) throws Exception
    {
        LOGGER.debug( "***** In AbstractPage.clickModalAlertButton(). Parameter is: " + acceptOrDismiss + "\n" );

        if (isModalAlertPresent()) {
            LOGGER.debug( "***** Detected presence of Modal alert" + "\n" );

            driver.switchTo().alert();              // moves focus to modal pop-up
            LOGGER.debug( "***** Switched into Modal alert" + "\n" );
            switch (acceptOrDismiss.toLowerCase())
            {
                case "accept":              // e.g. OK, Yes or Accept
                    LOGGER.debug( "***** Going to click accept" + "\n" );
                    driver.switchTo().alert().accept(); break;
                case "dismiss":             // e.g. No or Cancel
                    LOGGER.debug( "***** Going to click dismiss" + "\n" );
                    driver.switchTo().alert().dismiss(); break;
                default: throw new Exception("Invalid clickModalAlertButton parameter"); // should only happen during development!
            }
            LOGGER.debug( "***** Going to switch out of Modal alert" + "\n" );
            driver.switchTo().defaultContent();     // moves focus back to page
            LOGGER.debug( "***** Switched out of Modal alert" + "\n" );
        }
    }
    public void switchToNewWindow(AbstractPage page) {
        getDefaultDriverWait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return (d.getWindowHandles().size() != 1);
            }
        });

        LOGGER.debug("Number of window handles:" + driver.getWindowHandles().size());
        assertEquals("There should only be two open windows", 2, driver.getWindowHandles().size());

        String thisWindowHandle = driver.getWindowHandle();

        page.setWindowHandle(thisWindowHandle);

        Set<String> allWindowHandles = driver.getWindowHandles();
        allWindowHandles.remove(thisWindowHandle);
        String newWindowHandle = (String) (allWindowHandles.toArray())[0];
        driver.switchTo().window(newWindowHandle);
    }


    public void scrollUpOrDown( String numberOfPixels )
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0," + numberOfPixels + ");", "");
    }

    public void scrollToElement( WebElement element )
    {
        int elementPositionYAxis = element.getLocation().getY();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0," + elementPositionYAxis + ");");
    }

    // Returns current date and time as string of year, month, day, hour, minute, second and millisecond
    public String getDateTimeNow()
    {
        return new SimpleDateFormat("yyMMddhhmmssSSS").format(new Date());
    }

    public void setWindowHandle( String windowHandle )
    {
        this.windowHandle = windowHandle;
    }

    public String getWindowHandle()
    {
        return windowHandle;
    }

    public void returnAndClose()
    {
        driver.close();
        driver.switchTo().window( getWindowHandle() );
    }

    // use when the select box is rendered by UICL
    protected void selectDropdownOption( WebElement selectElement , String value )
    {
        Select select = new Select( selectElement );
        select.selectByVisibleText( value );
        //select.selectByIndex(1);
    }

    public String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\testdata\\temp\\");
    }

    public void dragAndDrop(WebElement source, WebElement destination) throws Exception{
        Actions action = new Actions(driver);
//        pauseFor(5000);
        LOGGER.debug("Source is:" +source);
        action.moveToElement(source);
        action.pause(Duration.ofSeconds(1));
        action.clickAndHold(source);
        action.pause(Duration.ofSeconds(1));
        action.moveByOffset(2,0);
        action.moveToElement(destination);
        action.moveByOffset(2,0);
        action.pause(Duration.ofSeconds(1));
        action.release().build().perform();

//        Action dragDrop = action.dragAndDrop(source, destination).build();
//        dragDrop.perform();
    }
    public String getTestDataPath(){
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\generator\\test_data\\");
    }

    @Override
    public String toString()
    {
        return "AbstractPage{" +
                "DEFAULT_WEBDRIVER_WAIT=" + DEFAULT_WEBDRIVER_WAIT +
                ", ELEMENT_STATUS_CHECK_WAIT=" + ELEMENT_STATUS_CHECK_WAIT +
                ", MODAL_POPUP_WAIT=" + MODAL_POPUP_WAIT +
                ", DEFAULT_UPLOAD_WAIT=" + DEFAULT_UPLOAD_WAIT +
                ", SEARCH_RETRY_WAIT=" + SEARCH_RETRY_WAIT +
                ", BttfBaseUrl='" + env.getBttfBaseUrl() + '\'' +
                ", expectedUrl='" + this.getExpectedUrl() + '\'' +
                ", expectedTitle='" + this.getExpectedTitle() + '\'' +
                '}';
    }
}
