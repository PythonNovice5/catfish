package com.basware.bttf.steps.bdd.glue.product_manager.Groups;

import com.basware.bttf.pages.product_manager.buyer.groups.*;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GroupsSteps extends AbstractSteps {

    @And("^On Groups directory page - I click on '([^\"']*)' button$")
    public void clickOnCreateButton(String button)
    {
        GroupDirectoryPage groupDirectoryPage = (GroupDirectoryPage) getCurrentPage();
        setCurrentPage(groupDirectoryPage.clickOnButton(button));
    }

    @And("^On the Create Group page - I enter '([^\"']*)' as '([^\"']*)'$")
    public void enterGroupName(String fieldName, String value)
    {
        LOGGER.debug( "Enter..  " + fieldName + "\n" );
        CreateGroupPage createGroupPage = (CreateGroupPage)getCurrentPage();
        switch(fieldName.toLowerCase()){
        case "group name":
            String groupName = value+createGroupPage.getSessionID();
            props.set(TestConstants.SHARED_GROUP_NAME,groupName);
            createGroupPage.enterGroupName(groupName);
            break;
        case "my description":
            createGroupPage.enterMyDescription(value);
            break;
        case "memeber description":
            createGroupPage.enterMemberDescription(value);
            break;
    }
  }

  @And("^On the Create Group page - I click on save and continue$")
  public void saveGroup()
  {
        CreateGroupPage createGroupPage = (CreateGroupPage)getCurrentPage();
        setCurrentPage(createGroupPage.clickOnSaveAndContinue());
  }


  @And("^On the Manage group page - I click on cog to select '([^\"']*)' for the group$")
  public void clickCog(String fieldName)
  {
      ManageGroupsPage manageGroupsPage = (ManageGroupsPage) getCurrentPage();
      setCurrentPage(manageGroupsPage.clickCog(fieldName));
  }

  @When("^On the Manage Group page - I search '([^\"']*)' in '([^\"']*)'$")
  public void searchMemberToShare(String value,String element) throws Exception
  {
      ManageGroupMembersPage manageGroupMembersPage = (ManageGroupMembersPage) getCurrentPage();
      manageGroupMembersPage.searchGroupMembers(value);
  }



  @And("^On the Manage Group Members Page - I select member to share$")
    public void selectMembers()
  {
      ManageGroupMembersPage manageGroupMembersPage = (ManageGroupMembersPage) getCurrentPage();
      manageGroupMembersPage.selectMemebersToShare();
  }

  @And("^On the Manage Group Members Page - I click on Done$")
  public void addMemberToTheGroup()
  {
      ManageGroupMembersPage manageGroupMembersPage = (ManageGroupMembersPage) getCurrentPage();
      setCurrentPage(manageGroupMembersPage.clickOnDone());
  }
    @When("^On the Manage resources page - I search shared agreement$")
    public void searchSharedAgreement()
    {
        ManageGroupResourcePage manageGroupResourcePage = (ManageGroupResourcePage) getCurrentPage();
        manageGroupResourcePage.searchAgreementInResource(props.get(TestConstants.ORG_AGREEMENT_NAME));
    }

    @When("^On the Manage resources page - I search shared agreement '([^\"']*)'$")
    public void searchSharedAgreementByName(String agreementName)
    {
        ManageGroupResourcePage manageGroupResourcePage = (ManageGroupResourcePage) getCurrentPage();
        manageGroupResourcePage.searchAgreementInResource(agreementName);
    }

  @And("^On the Manage resources page - I select Agreement to share$")
    public void selectResources(){
      ManageGroupResourcePage manageGroupResourcePage = (ManageGroupResourcePage) getCurrentPage();
      manageGroupResourcePage.selectResource();
  }

  @And("^On the Manage resources page - I click on Done$")
    public void addResourcesToTheGroup()
  {
      ManageGroupResourcePage manageGroupResourcePage = (ManageGroupResourcePage) getCurrentPage();
      setCurrentPage(manageGroupResourcePage.clickOnDone());
  }

  @And("^On the Manage Group page - I click on Publish$")
   public void publishTheGroup()
  {
      LOGGER.debug("On the Manage Group page - I click on Publish button to publish the group..");
      ManageGroupsPage manageGroupsPage = (ManageGroupsPage)getCurrentPage();
      setCurrentPage(manageGroupsPage.publishGroup());
  }

    @When("^On the Manage resources page - I select filter '([^\"']*)'$")

    public void clickOnFilter(String filter)
    {
        ManageGroupResourcePage manageGroupResourcePage = (ManageGroupResourcePage) getCurrentPage();
        manageGroupResourcePage.clickFilter(filter);
    }

    @Then("^On the Manage resource page - I remove recently added agreement$")
    public void removeAgreementFromGroup()
    {
        ManageGroupResourcePage manageGroupResourcePage = (ManageGroupResourcePage) getCurrentPage();
        setCurrentPage(manageGroupResourcePage.removeResource());

    }
}
