package com.basware.bttf.pages.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;



public class SelectAgreementPage extends ProductManagerDirectoryPage {
    protected static Logger LOGGER = Logger.getLogger( ManageViewPage.class.getName() );


    @FindBy(xpath = "//a[(contains(@href,'addAgreementView'))]")
    public WebElement addAgreementView;


    @FindBy(xpath = "//a[(contains(@href,'removeAgreementView'))]")
    public WebElement removeAgreementView;

    @FindBy(id = "keywords")
    public WebElement searchInput;

    @FindBy(name = "btn-search")
    private WebElement searchButton;

    @FindBy(linkText = "Selected agreements")
    private WebElement selectAgreementFilter;


    public SelectAgreementPage()
    {
        PageFactory.initElements(driver, this );
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Select View Agreements";
    }

    public String getExpectedUrl(){

        return getBaseUrl() + "/products/viewDocAgreements/index";
    }

    @FindBy(linkText = "Last modified")
    public WebElement selectAgreementDropdownSortLastModified;

    @FindBy(linkText = "All")
    public WebElement selectAgreementFilterAll;

    public ManageViewPage addAgreement(){

        long giveUpAt = System.currentTimeMillis()+ 7000;

        while (System.currentTimeMillis() < giveUpAt && driver.findElements(By.xpath("//a[(contains(@href,'addAgreementView'))]")).size()==0)
        {
            pauseFor(1000);
            driver.navigate().refresh();
        }
        waitUntillElementIsClickableAndClick(addAgreementView);
        pauseFor(1000);
        waitUntilDisplayed(doneBtn);
        waitUntillElementIsClickableAndClick(doneBtn);
        pauseFor(1000);
        return new ManageViewPage();
    }

    public ManageViewPage removeAgreement(){

        long giveUpAt = System.currentTimeMillis()+ 7000;

        while (System.currentTimeMillis() < giveUpAt && driver.findElements(By.xpath("//a[(contains(@href,'removeAgreementView'))]")).size()==0)
        {
            pauseFor(1000);
            driver.navigate().refresh();
        }
        waitUntillElementIsClickableAndClick(removeAgreementView);
        pauseFor(1000);
        waitUntilDisplayed(doneBtn);
        waitUntillElementIsClickableAndClick(doneBtn);
        pauseFor(1000);
        return new ManageViewPage();
    }


    @Override
    protected void initSortByItems() {
        setSortByItems(
                new HashMap<String, WebElement>() {{
                    put("Last Modified", selectAgreementDropdownSortLastModified);
                }}
        );

    }

    public void searchSharedAgreement(String value)
    {
        pauseFor(1000);
        waitUntilDisplayed(directoryInputSearch);
        directoryInputSearch.sendKeys(value);
        clickButtonSearch();
    }


    @Override
    protected void initFilterItems() {
        setFilterByItems(
                new HashMap<String, WebElement>() {{
                    put("All", selectAgreementFilterAll);
                }}
        );
    }


}
