package com.basware.bttf.pages.settings;

import com.basware.bttf.pages.LoggedInPage;
import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class MisReportPage extends ProductManagerDirectoryPage {

    // Dropdowns
    @FindBy( linkText="Report Type" )
    public WebElement misReportDropDownSortReportType;
    @FindBy( linkText="Name" )
    public WebElement misReportDropDownReportDropDownSortName;
    @FindBy( linkText="Relevance" )
    public WebElement misReportDropDownReportDropDownRelevance;

    // Filters
    @FindBy( linkText="All" )
    public WebElement manageAgreementsFilterAll;
    @FindBy ( linkText = "Summary Reports")
    public WebElement summaryReportFilter;
    @FindBy (linkText = "Detailed Reports")
    public WebElement detailedReportFilter;
    @FindBy (linkText = "Supplier Enablement Reports")
    public WebElement supplierEnablementReportFilter;
    @FindBy (linkText = "Buyer Enablement Reports")
    public WebElement buyerEnablementReportFilter;
    @FindBy (linkText = "Product Manager Reports")
    public WebElement productManagerReportFilter;
    @FindBy (linkText = "Custom Reports")
    public WebElement customeReportFilter;

    @FindBy(id = "manageReport_0")
    public WebElement firstReportRunButton;

    @FindBy(id = "modalConfirmCheck")
    public WebElement createButton;

    @FindBy(id = "modalConfirmCancel")
    public WebElement cancelButton;

    public MisReportPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='pagable-content']/div[1]")
    private WebElement resultsShowingOnPage;

    @FindBy(id = "modalConfirmLabel")
    private  WebElement reportPopupModal;

    @Override
    public String getExpectedUrl() {
        return "/admin/reports/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Reports";
    }

    @Override
    protected void initSortByItems() {
        setSortByItems(new HashMap<String,WebElement>()
        {{
            put("Relevance",misReportDropDownReportDropDownRelevance);
            put("Name",misReportDropDownReportDropDownSortName);
            put("Report Type",misReportDropDownSortReportType);
        }});


    }

    @Override
    protected void initFilterItems() {
        setFilterByItems(new HashMap<String,WebElement>()
        {{
            put("All", manageAgreementsFilterAll);
            put("Summary Reports", summaryReportFilter);
            put("Detailed Reports", detailedReportFilter);
            put("Supplier Enablement Reports", supplierEnablementReportFilter);
            put("Buyer Enablement Reports", buyerEnablementReportFilter);
            put("Product Manager Reports", productManagerReportFilter);
            put("Custom Reports", customeReportFilter);
        }});
    }

    public String getTotalResultsInThePage()
    {
        String totalNumberOfReports = resultsShowingOnPage.getText();
        String[]  ActulReportOnPage= totalNumberOfReports.split(" ");
        return ActulReportOnPage[3];
    }

    public void clickOnRunReportButton()
    {
        waitUntillElementIsClickableAndClick(firstReportRunButton);
    }

    public void selectTransactionCheckBoxes(String checkBox)
    {
        waitUntilDisplayed(reportPopupModal);
        WebElement checkBoxElement = driver.findElement(By.xpath("//label[contains(text(),'"+checkBox+"')]"));
        waitUntillElementIsClickableAndClick(checkBoxElement);
    }

    public void clickOnCreateReportButton()
    {
        waitUntillElementIsClickableAndClick(createButton);
        pauseFor(2000);
        //Click cancel button to logout
       waitUntillElementIsClickableAndClick(cancelButton);
    }

}
