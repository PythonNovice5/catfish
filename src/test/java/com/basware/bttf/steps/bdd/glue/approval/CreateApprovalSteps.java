package com.basware.bttf.steps.bdd.glue.approval;


import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeDirectoryCreatePage;
import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeDirectoryPage;
import com.basware.bttf.pages.product_manager.buyer.approvals.ApprovalSchemeManagePage;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;

/**
 * @Author Mamatha chittlur
 */

public class CreateApprovalSteps extends AbstractSteps {

    @And("^I click on the Create button$")
    public void clickOnCreateApprovalButton() {
        ApprovalSchemeDirectoryPage approvalSchemeDirectoryPage = (ApprovalSchemeDirectoryPage) getCurrentPage();
        LOGGER.debug("Through approval scheme Page..Create new approval ");
        setCurrentPage(approvalSchemeDirectoryPage.clickCreateApprovalButton());
    }

    @And("^On the Create approval page - I enter '([^\"]*)' as '([^\"']*)'$")
    public void enterNameOfTheApproval(String fieldName, String value) {
        ApprovalSchemeDirectoryCreatePage approvalSchemeDirectoryCreatePage = (ApprovalSchemeDirectoryCreatePage) getCurrentPage();
        LOGGER.debug("Create Approval page..enter " + fieldName + " with value of " + value + "\n");
        switch (fieldName.toLowerCase()) {
            case "name":
                approvalSchemeDirectoryCreatePage.enterApprovalName(value + approvalSchemeDirectoryCreatePage.getSessionID());
                props.set(TestConstants.DEFAULT_APPROVAL_NAME, value + approvalSchemeDirectoryCreatePage.getSessionID() );
                break;
            case "description":
                approvalSchemeDirectoryCreatePage.enterDescription(value);
                break;
        }
    }

    @And("^on the Create approval page - I save the approval$")
    public void saveTheApproval() {
        ApprovalSchemeDirectoryCreatePage approvalSchemeDirectoryCreatePage = (ApprovalSchemeDirectoryCreatePage) getCurrentPage();
        LOGGER.debug("Saving the approval");
        setCurrentPage(approvalSchemeDirectoryCreatePage.saveApproval());
    }

    @And("^On the Manage approval page - I select '([^\"]*)' as '([^\"']*)'$")
    public void selectApprovers(String approver, String fieldName) {
        ApprovalSchemeManagePage approvalSchemeManagePage = (ApprovalSchemeManagePage) getCurrentPage();
        LOGGER.debug("Approval manage page...i select" + approver + "as" + "filedName");
        switch (fieldName.toLowerCase()) {
            case "auto":
                approvalSchemeManagePage.selectAutoToggle();
                break;
            case "add approvers":
                approvalSchemeManagePage.addApprovers();
                break;
            case "level2 approvers":
                approvalSchemeManagePage.addlevel2Approvers();
                break;
        }
    }

    @And("^On the Manage approval page - I save the approval$")

    public void saveTheAprrovalOnManagementPage() {
        ApprovalSchemeManagePage approvalSchemeManagePage = (ApprovalSchemeManagePage) getCurrentPage();
        LOGGER.debug("Saving the approval on management page");
        approvalSchemeManagePage.saveApprovalScheme();
    }


    @And("^On the Manage approval page - I click on '([^\"']*)'$")

    public void clickOnButtons(String fieldName) {
        ApprovalSchemeManagePage approvalSchemeManagePage = (ApprovalSchemeManagePage) getCurrentPage();
        switch (fieldName.toLowerCase()) {
            case "add levels":
                approvalSchemeManagePage.clickOnAddLevel();
                break;
            case "add rule":
                approvalSchemeManagePage.clickOnAddRule();
                break;
            case "quality scoring rules":
                approvalSchemeManagePage.addQualityScoringRules();
                break;
        }

    }

    @And("^On the Manage approval page - I select '([^\"']*)' in the modal window$")
    public void selectRule(String fieldName) {
        ApprovalSchemeManagePage approvalSchemeManagePage = (ApprovalSchemeManagePage) getCurrentPage();
        switch (fieldName.toLowerCase()) {
            case "item added":
                approvalSchemeManagePage.selectRule(1);
                break;
            case "item removed":
                approvalSchemeManagePage.selectRule(2);
                break;
            case "base price increased":
                approvalSchemeManagePage.selectRule(3);
                break;
            case "base price decreased":
                approvalSchemeManagePage.selectRule(4);
                break;
            case "image":
                approvalSchemeManagePage.selectQualityScoringRule(1);
                break;
            case "keywords":
                approvalSchemeManagePage.selectQualityScoringRule(2);
                break;
            case "attributes":
                approvalSchemeManagePage.selectQualityScoringRule(3);
                break;
            case "classification":
                approvalSchemeManagePage.selectQualityScoringRule(4);
                break;
            case "supplier part id":
                approvalSchemeManagePage.selectQualityScoringRule(5);
                break;
        }

    }

    @And("^on the Manage approval page - I add '(\\d+)' to the '([^\"']*)'$")

    public void addBasePrice(int price, String fieldName) {
        ApprovalSchemeManagePage approvalSchemeManagePage = (ApprovalSchemeManagePage) getCurrentPage();
        switch (fieldName.toLowerCase()) {
            case "base price increased":
                approvalSchemeManagePage.increasedPrice(price);
                break;
            case "base price decreased":
                approvalSchemeManagePage.decreasePrice(price);
                break;
        }
    }


}




