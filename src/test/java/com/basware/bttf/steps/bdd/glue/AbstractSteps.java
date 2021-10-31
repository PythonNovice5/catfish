package com.basware.bttf.steps.bdd.glue;

import com.basware.bttf.domain.Environment;
import com.basware.bttf.domain.User;
import com.basware.bttf.pages.AbstractPage;
import com.basware.bttf.util.TestProperties;
import com.basware.webdriver.manager.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractSteps
{
    protected static Logger LOGGER = Logger.getLogger( AbstractSteps.class.getName() );
    protected Environment env = Environment.getInstance();
    protected TestProperties props = TestProperties.getInstance();
    protected WebDriver driver = Driver.getDriver();

    static private User currentUser;

    static private AbstractPage currentPage;
    static private AbstractPage previousPage;

    public void setCurrentUser( User currentUser )
    {
        this.currentUser = currentUser;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentPage( AbstractPage page )
    {
        if( currentPage == null && previousPage == null )
        {
            page.loadPage();
        }

        previousPage = currentPage;
        currentPage = page;
        currentPage.get();

        if( env.isPageTrace() )
        {
            String previousPageClass = previousPage != null ? previousPage.getClass().getName() : "not set";
            String currentPageClass = currentPage != null ? currentPage.getClass().getName() : "not set";
            LOGGER.trace( String.format( "previousPage: %s , currentPage: %s", previousPageClass, currentPageClass ) );
        }
    }

    public AbstractPage getCurrentPage()
    {
        return currentPage;
    }

    public AbstractPage getPreviousPage()
    {
        return previousPage;
    }

    public void returnToPreviousPage()
    {
        currentPage.back();
        currentPage = previousPage;
    }

    public void resetPageState()
    {
        previousPage = null;
        currentPage = null;
        currentUser = null;
        driver.manage().deleteAllCookies();
    }

    public boolean waitPageLoaded()  throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        /* *** DKN-20161114 Cannot seem to avoid this sleep *** */
        Thread.sleep(500);
        final JavascriptExecutor js = (JavascriptExecutor) driver;

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try
                {
                    //LOGGER.debug( "jQuery Active " + js.executeScript("return jQuery.active").toString() );
                    return ((Long) js.executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                //LOGGER.debug( "Javascript ??? " + js.executeScript("return document.readyState").toString() );
                return js.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);

    }



}
