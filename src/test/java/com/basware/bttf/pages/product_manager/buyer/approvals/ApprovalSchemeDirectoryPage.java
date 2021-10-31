package com.basware.bttf.pages.product_manager.buyer.approvals;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.CreateAgreementApprovalSelectedPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.CreateAgreementPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.ManageAgreementPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class ApprovalSchemeDirectoryPage extends ProductManagerDirectoryPage<ApprovalSchemeDirectoryPage>
{
    protected static Logger LOGGER = Logger.getLogger( ApprovalSchemeDirectoryPage.class.getName() );


    @FindBy(xpath="//a[starts-with(@update,'statusApprovalAgreement_')]")
    private WebElement approvalName;

    public ApprovalSchemeDirectoryPage()
    {
        PageFactory.initElements( driver , this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/approvalScheme";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Approval Schemes";
    }

    @Override
    protected void initSortByItems()
    {

    }

    @Override
    protected void initFilterItems()
    {

    }

    public void searchApprovalScheme(String approvalScheme)
    {
        WebElement searchApprovalScheme = driver.findElement(By.id("keywords"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchApprovalScheme.clear();
        searchApprovalScheme.sendKeys(approvalScheme);
        searchButton.click();
    }

    public void selectApprovalSchemeFromSearchResults(String schemeName)
    {
        List<WebElement> approvalsList = driver.findElements(By.cssSelector(".col-sm-6.link-document"));
        Iterator<WebElement> i = approvalsList.iterator();

        while (i.hasNext()){
            LOGGER.debug(i.next());
        }

        WebElement parentElement;

        //for each row
        for (WebElement approvalScheme : approvalsList){

            if ( approvalScheme.findElement(By.cssSelector("strong>a")).getText().contains(schemeName)){

                parentElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", approvalScheme);
                pauseFor(1000);
                approvalName.click();
                /* DKN - This selects the Approval Scheme Link
                parentElement.findElement(By.cssSelector("a[href*='keywords="+ schemeName + "']")).click();
                */

                LOGGER.debug("Scheme name " + schemeName + " found and clicked");
                break;
            }

        }
    }

    public ManageAgreementPage clickDone()
    {
        WebElement doneButton = driver.findElement(By.cssSelector("a.btn.btn-primary.pull-right"));
        doneButton.click();

        return new ManageAgreementPage();
    }

    public ApprovalSchemeDirectoryCreatePage clickCreateApprovalButton(){
        WebElement createButton = driver.findElement(By.linkText("Create"));
        createButton.click();
        return new ApprovalSchemeDirectoryCreatePage();
    }
}
