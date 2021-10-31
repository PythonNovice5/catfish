package com.basware.bttf.pages.product_manager.Loader;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.Set;

public class TwoStageLoaderDashboardPage extends ProductManagerPage {

    @FindBy(name = "Mappings")
    private WebElement mappingsCount;

    @FindBy(name = "Uploading")
    private WebElement uploading;

    @FindBy(name = "Issues")
    private WebElement issues;

    @FindBy(name = "Mapping Directory")
    private WebElement mappings;

    @FindBy(name = "Upload Files")
    private WebElement uploadFiles;

    @FindBy(name = "Upload Status")
    private WebElement uploadStatus;

    @FindBy(name = "Automation")
    private WebElement automation;

    @FindBy(id = "landing-nav")
    private WebElement header;

    public TwoStageLoaderDashboardPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/loader/dashboard";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Content Loader: Dashboard";
    }

    public void verifyHeaderOfThePage()
    {
        Assert.assertEquals("Content Loader",header.getText());
    }

    public void verifyPanelsInLoaderPage()
    {
        Set<WebElement> loaderPanelSelectors = new HashSet<WebElement>() {{
            add(mappingsCount);
            add(uploading);
            add(issues);
            add(mappings);
            add(uploadFiles);
            add(uploadStatus);
            add(automation);
        }};

        for(WebElement w : loaderPanelSelectors) {
            Assert.assertTrue(w.isDisplayed());
        }
    }


    public TwoStageLoaderDashboardPage clickOnPanel(String panel)
    {
       TwoStageLoaderDashboardPage page = null;

        switch(panel){
            case "Upload files":
                uploadFiles.click();
                page = new LoaderUploadPage();
                break;
            case "Upload status":
                uploadStatus.click();
                page = new LoaderStatusPage();
                break;
            case "Mapping Directory":
                mappings.click();
                page = new MappingDirectoryPage();
                break;
            case "Automation":
                automation.click();
                page = new ContentLoaderAutomationPage();
                break;
        }
        return page;
    }
   }
