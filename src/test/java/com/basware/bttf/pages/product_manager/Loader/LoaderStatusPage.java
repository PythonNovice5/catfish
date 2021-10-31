package com.basware.bttf.pages.product_manager.Loader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import sun.rmi.runtime.Log;

public class LoaderStatusPage extends TwoStageLoaderDashboardPage {


    public LoaderStatusPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//pmmp-upload-list-item[1]/div[2]/div[1]/div[2]/span")
    private WebElement latestItemName;

    @FindBy(xpath = "//*[@id='data-load-0']//*[contains(text(),'Validation Status : VALID')]")
    private WebElement validationStatus;

    @FindBy(xpath = "//pmmp-upload-list-item[1]/div[2]/div[2]/div/button")
    private WebElement viewButtonForTheFirstEntry;

    @FindBy(xpath = "//pmmp-upload-list-item[1]/div[2]/div[1]/div[4]/div[1]/b")
    private WebElement progressionStatus;

    @FindBy(xpath = "////span[contains(text(),'superContentLoader')]//..//..//..//..//..//*[@id='data-load-0']//b[contains(text(),'Validation Status : VALID')]")
    public WebElement superContentLoaderFileInvalid;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/loader/uploads";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Content Loader: Uploads";
    }


    public String fileName() {
        waitUntilDisplayed(latestItemName);
        String fileName = latestItemName.getText();
        return fileName;
    }

    public void verifyStatus(){
        waitUntilDisplayed(superContentLoaderFileInvalid);
        LOGGER.debug("Status of super content loader file has been found as valid");
    }

    public String waitForUploadStatusMessage()
    {
        waitUntilDisplayed(validationStatus);
        String[] statusMessage =null;

        long giveUpAt = System.currentTimeMillis()+ 50000;

        while (System.currentTimeMillis() < giveUpAt && ! validationStatus.getText().equals("Validation Status : VALID"))
        {
            pauseFor(2000);
            driver.navigate().refresh();
            waitUntilDisplayed(validationStatus);
        }
        statusMessage = (validationStatus.getText()).split((":"));
        return statusMessage[1].replaceAll("\\s+","");
    }

    public String waitForProgressStatusMessage()
    {
        waitUntilDisplayed(progressionStatus);
        String[] statusMessage = null;
        long giveUpAt = System.currentTimeMillis()+ 20000;

        while (System.currentTimeMillis() < giveUpAt && ! progressionStatus.getText().equals("Progress : PROCESS - COMPLETED"))
        {
            pauseFor(2000);
            driver.navigate().refresh();
            waitUntilDisplayed(progressionStatus);
            statusMessage = (progressionStatus.getText()).split((":"));
        }
        return statusMessage[1].replaceAll("\\s+","");
    }

    public LoaderStagingPage clickOnViewForTheFirstEntry()
    {
        waitUntillElementIsClickableAndClick(viewButtonForTheFirstEntry);
        return new LoaderStagingPage();
    }
}
