package com.basware.bttf.pages.product_manager.buyer.approvals;

import com.basware.bttf.pages.product_manager.buyer.agreements.CreateAgreementNewPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.CreateAgreementPage;
import com.basware.bttf.pages.product_manager.buyer.agreements.ManageAgreementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ApprovalSchemeDirectoryCreatePage extends ApprovalSchemeDirectoryPage
{
    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/approvalScheme/displayCreate";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Create Approval Scheme";
    }

    public ManageAgreementPage clickDone()
    {
        WebElement doneButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        doneButton.click();

        return new ManageAgreementPage();
        //return new CreateAgreementPage();
    }

    public void enterApprovalName(String name) {
        WebElement Approvalname = driver.findElement(By.id("name"));
        Approvalname.sendKeys(name);
    }

    public void enterDescription(String description){
        WebElement approvalDescription =  driver.findElement(By.id("description"));
        approvalDescription.sendKeys(description);
    }

    public ApprovalSchemeManagePage saveApproval(){
        WebElement saveButton = driver.findElement(By.id("saveApprovalSchemeButton"));
        saveButton.click();
        return new ApprovalSchemeManagePage();
    }

}
