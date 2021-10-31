package com.basware.bttf.steps.bdd.glue;


import com.basware.bttf.util.generator.BMECatGenerator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hooks extends AbstractSteps {


    @Before()
    public void logStartOfScenario( Scenario scenario)
    {
        LOGGER.debug("XXXXXXXXXX Start of Scenario: " + scenario.getName() + "\n" );
        ArrayList<String> tabs= new ArrayList<String> (driver.getWindowHandles());
        if (tabs.size() > 1)
        {
            driver.switchTo().window(tabs.get(1));
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }

    @After()
    public void logEndOfScenario( Scenario scenario) throws Exception
    {
        if(scenario.isFailed())
            {
                scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
            }
        LOGGER.debug("XXXXXXXXXX End of Scenario: " + scenario.getName() + "\n");
        // Clear all page states and user data
        try {
            resetPageState();
        }
        catch (NoSuchSessionException n){
            LOGGER.debug("No Session was found");
        }
    }

    @Before("@BMEcat or @AllCsvUploads or @zippedCSV or @AgentAgreement")
    public void DeleteTemporaryBmecatTestData() throws IOException
    {
        BMECatGenerator.deleteFile();
    }

}
