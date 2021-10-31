package com.basware.webdriver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver extends Thread
{
    protected static Logger log = Logger.getLogger(Driver.class.getName());

    public static final String BROWSER_PROPERTY_NAME = "selenium2basics.webdriver";
    private static String DEFAULT_BROWSER = "GOOGLECHROME";

    private static WebDriver driver = null;

    private static boolean avoidRecursiveCall = false;

    public static WebDriver getDriver()
    {
        if( driver == null )
        {
            try{String browser = getParameter("browser");
                if (browser!=null){
                    DEFAULT_BROWSER = browser;
                }
            }
            catch (Exception e)
                {
                    System.out.println("Using DEFAULT BROWSER AS CHROME");
                }

            BrowserName browserName = BrowserName.valueOf( getPropertyOrEnv(BROWSER_PROPERTY_NAME, DEFAULT_BROWSER) );


            setDriverLocationProperty( browserName );

            switch (browserName)
            {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;

                case IE:
                    driver=getIEDriver();
                    driver.manage().window().maximize();
//                    driver = new InternetExplorerDriver();
                    break;

                case GOOGLECHROME:
                    driver = getChromeDriver();
                    Capabilities caps= ((RemoteWebDriver)driver).getCapabilities();
                    String browserVersion = caps.getVersion();
                    System.out.println("THE VERSION OF CHROME I AM USING: "+browserVersion);
                    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    break;

                case EDGE:
                    driver = getEdgeDriver();
                    driver.manage().window().maximize();
                    break;

                default:
                    log.error( "Invalid browser specified" );
                    System.exit(-1);
            }

            // we want to shutdown the shared brower when the steps finish
            Runtime.getRuntime().addShutdownHook(
                    new Thread(){
                        public void run(){
//                            Driver.quit();
                        }   
                    }
            );
        }
        else
        {
            try
            {
                if(driver.getWindowHandle()!=null)
                {
                    // assume it is still alive
                }
            }
            catch(Exception e)
            {
                if(avoidRecursiveCall)
                {
                    throw new RuntimeException();
                }

                quit();
                driver =null;
                avoidRecursiveCall = true;
                return getDriver();
            }
        }
        avoidRecursiveCall = false;
        return driver;
    }

    private static String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }

    /**
     * Allow setting the controls via property or environment variable
     * property takes precedence, then environment variable, then default
     */
    private static String getPropertyOrEnv(String name, String theDefault)
    {
        String theValue = System.getProperty(name);
        if(theValue == null)
        {
            System.out.println("Could not find Property " + name);
            theValue = System.getenv(name);

            if(theValue==null)
            {
                System.out.println("Could not find Environment Variable " + name + " using default value " + theDefault);
                theValue = theDefault;
            }
            else
            {
                System.out.println("Using Environment Variable " + name + " with value " + theValue);
            }
        }
        else
        {
            System.out.println("Using Property " + name + " with value " + theValue);
        }

        return theValue;
    }

    private static void setDriverLocationProperty( BrowserName browserName )
    {
        String driverBinary = null;

        if( browserName ==  BrowserName.GOOGLECHROME )
        {
            if( SystemUtils.IS_OS_WINDOWS )
            {
                driverBinary = "windows/chromedriver.exe";
            }
            else if( SystemUtils.IS_OS_LINUX )
            {
                driverBinary = "linux/chromedriver";
            }
        }
        else if( browserName ==  BrowserName.IE )
        {
            driverBinary = "windows/IEDriverServer.exe";
        }
        else if (browserName == BrowserName.EDGE){
            driverBinary = "windows/msedgedriver.exe";
        }
        else
        {
            // NOTE: FF doesn't use a binary driver like Chrome and IE so we shouldn't use this method for it.
            throw new IllegalStateException( "Invalid browser defined" );
        }

        String basePath = FileSystems.getDefault().getPath( "" ).normalize().toAbsolutePath().toString();
        String path = String.format( "%s/bin/%s" , basePath , driverBinary );

        log.debug( "Using driver executable found at: " + path );

        System.setProperty( browserName.getPropertyName() , path );
    }

    private static WebDriver getChromeDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");

        // with Chrome v35 it now reports an error on --ignore-certificate-errors so call with args "test-type"
        // https://code.google.com/p/chromedriver/issues/detail?id=799
        options.addArguments("test-type");

        // set the locale of the ChromeDriver to be English English becuase it defaults as US English
        options.addArguments("--lang=en-GB");

        options.addArguments("--disable-gpu");
        //options.addArguments("--disable-browser-side-navigation");

        Long version = (Long) options.getCapability("version");

        return new ChromeDriver(options);
    }
    private static WebDriver getIEDriver()
    {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.ignoreZoomSettings();
        ieOptions.setCapability("requireWindowFocus",true);
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        ieOptions.setCapability("acceptSslCerts",true);
        return new InternetExplorerDriver(ieOptions);
    }

    private static WebDriver getEdgeDriver(){
        EdgeOptions options = new EdgeOptions();
        String version = options.getVersion();
        System.out.println("THE VERSION OF CHROME I AM USING is: " +version);
        WebDriverManager.chromedriver().browserVersion(version).setup();
        WebDriverManager.chromedriver().driverVersion(version).setup();
        return new EdgeDriver();
    }



    public static void quit()
    {
        if(driver !=null)
        {
            try
            {
                driver.quit();
                driver =null;
            }
            catch(Exception e)
            {
                // I don't care about errors at this point
            }
        }
    }
}
