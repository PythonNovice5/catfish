package com.basware.bttf.pages.product_manager.Loader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoaderStagingPage extends TwoStageLoaderDashboardPage {

    @FindBy(id = "commit-dataload-button")
    private WebElement commitButton;

    @FindBy(id="delete-row-0")
    private WebElement deleteFirstRow;

    @FindBy(id= "app-dialog-confirm")
    private WebElement deleteRowConfirmation;

    @FindBy(xpath = "//*[@id='row-0']/td[3]")
    private WebElement sku;

    public LoaderStagingPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/loader/staging?dataLoadId";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Content Loader: Staging";
    }


    public TwoStageLoaderDashboardPage clickOnButton(String button) {
        switch (button) {
            case "commit":
                pauseFor(1000);
                waitUntillElementIsClickableAndClick(commitButton);
                break;
        }
        return new LoaderStatusPage();
    }

    public String verifyStagingItems()
    {
        waitUntilDisplayed(sku);
        return sku.getText();
    }

    public void deleteRow()
    {
        pauseFor(1000);
        deleteFirstRow.click();
        deleteRowConfirmation.click();
        pauseFor(2000);
    }
}
