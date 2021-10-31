package com.basware.bttf.pages.product_manager.buyer.approvals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @Author Mamatha
 */

public class ApprovalSchemeManagePage extends ApprovalSchemeDirectoryPage {

   @Override
    public String getExpectedUrl(){ return getBaseUrl() + "/products/approvalScheme/view/";}

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Manage Approval Scheme";
    }

    public void selectAutoToggle() {
        WebElement toggle = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/div[1]/div"));
        toggle.click();
    }

    public void saveApprovalScheme() {
        pauseFor(1000);
        WebElement saveApprovalButton = driver.findElement(By.xpath("//*[@id='page-actions']/div/button"));
        saveApprovalButton.click();
    }

    public void addApprovers() {
//        waitUntilModalPopupDisplayed();
        WebElement addApproversButton = driver.findElement(By.cssSelector("button.pull-right.btn.btn-icon.btn-plus"));
        addApproversButton.click();
//        pauseFor(3000);
        waitUntilModalPopupDisplayed();
        WebElement selectApprovers = driver.findElement(By.xpath("//*[@id='userModal']/div/div/div[2]/table/tbody/tr/td/div/button/span"));
        waitUntillElementIsClickableAndClick(selectApprovers);
    }

    public void addlevel2Approvers() {
//        pauseFor(3000);
        WebElement addApproversButtonSecondLevel = driver.findElement(By.xpath("//b[text()='Approvers']//..//..//button"));
        clickWebElement(addApproversButtonSecondLevel);
//        addApproversButtonSecondLevel.click();
        getModalPopupWait();
//        pauseFor(3000);
        WebElement selectApproversIOnSecondLevel = driver.findElement(By.xpath("//h4[text()='Add approvers']//..//..//button//span[@class='glyphicon glyphicon-plus']"));
        clickWebElement(selectApproversIOnSecondLevel);
        //        selectApproversIOnSecondLevel.click();
    }


    public void clickOnAddRule() {
//        pauseFor(3000);
        waitUntilNoModalPopup();
//        WebElement addRuleButton = driver.findElement(By.xpath("//*[@id='updateApproval']/div[4]/table[2]/tbody/tr[1]/td[2]/button/span"));
        WebElement addRuleButton = driver.findElement(By.xpath("//b[text()='Rules']//..//..//button"));
        waitUntillElementIsClickableAndClick(addRuleButton);
//        addRuleButton.click();
    }

    public void clickOnAddRule2() {
//        pauseFor(5000);
//        waitUntilModalPopupDisplayed();
        WebElement addRuleButton = driver.findElement(By.xpath("//*[@id='updateApproval']/div[4]/table[2]/tbody/tr[1]/td[2]/button/span"));
       waitUntillElementIsClickableAndClick(addRuleButton);
    }

    public void clickOnAddLevel() {
        waitUntilNoModalPopup();
        WebElement addLevelButton = driver.findElement(By.cssSelector("#updateApproval > div.form-group.pull-right > button"));
//        pauseFor(1000);
        waitUntillElementIsClickableAndClick(addLevelButton);
    }

    public void selectRule(int i) {
//        pauseFor(3000);
        WebElement selectRuleButton = driver.findElement(By.xpath("//*[@id='ruleModal']/div/div/div[2]/table/tbody/tr[" + i + "]/td/div/div"));
//        selectRuleButton.click();
        waitUntillElementIsClickableAndClick(selectRuleButton);
    }

    public void selectQualityScoringRule(int i) {
        pauseFor(1000);
        WebElement selectImage = driver.findElement(By.xpath("//*[@id='qualityModal']/div/div/div[2]/table/tbody/tr[" + i + "]/td/div/div/span"));
        clickWebElement(selectImage);
//        selectImage.click();
    }

    public void increasedPrice(int price) {
        pauseFor(1000);
        WebElement priceTextBox = driver.findElement(By.xpath("//form[@id='updateApproval']//table//tbody//div//span[contains(text(),'Base price increased')]//following-sibling::input[@class='form-control required number positive']"));
        priceTextBox.sendKeys(String.valueOf(price));
    }

    public void decreasePrice(int price) {
        pauseFor(1000);
        WebElement decreasePriceTextBox = driver.findElement(By.xpath("//form[@id='updateApproval']//table//tbody//div//span[contains(text(),'Base price decreased')]//following-sibling::input[@class='form-control required number positive']"));
        decreasePriceTextBox.sendKeys(String.valueOf(price));
    }

    public void addQualityScoringRules() {
//        pauseFor(3000);
        waitUntilNoModalPopup();
        WebElement qualityScoringRuleButton = driver.findElement(By.xpath("//form/table/tbody/tr[1]/th/button"));
        waitUntillElementIsClickableAndClick(qualityScoringRuleButton);
    }
}
