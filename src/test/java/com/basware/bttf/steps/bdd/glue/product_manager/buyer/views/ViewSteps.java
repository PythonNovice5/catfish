package com.basware.bttf.steps.bdd.glue.product_manager.buyer.views;

import com.basware.bttf.pages.product_manager.buyer.views.*;
import com.basware.bttf.pages.product_manager.supplier.items.ItemDirectoryPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingListsPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import com.basware.bttf.util.TestConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ViewSteps extends AbstractSteps {

    String listName;

    @When("^On the View directory page - I search for View$")
    public void searchView() throws Throwable {
        ViewDirectoryPage viewDirectoryPage = (ViewDirectoryPage) getCurrentPage();
        LOGGER.debug("Searching for the view..");
        String viewName = props.get("ViewPublished");
        viewDirectoryPage.searchView(viewName);
}

    @When("^On the View directory page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterValue(String value,String elementName) throws Throwable {
        LOGGER.debug( "View directory page ... Enter value " + value + " into element " + elementName + "\n" );
        ViewDirectoryPage viewDirectoryPage = (ViewDirectoryPage) getCurrentPage();
        viewDirectoryPage.searchView( value );
    }


    @Then("^I click on Create button$")
    public void createView() throws Throwable {
        ViewDirectoryPage viewDirectoryPage = (ViewDirectoryPage) getCurrentPage();
        LOGGER.debug("Through View Directory Page..Create new View ");
        setCurrentPage(viewDirectoryPage.clickCreateView());
    }

    @And("^On Create View page - I select type as '([^\"']*)'$")
    public void selectType(String type) throws Throwable {
        CreateViewPage createViewPage = (CreateViewPage) getCurrentPage();
        setCurrentPage(createViewPage.selectTypeInDropDown(type));
    }


    @Then("^On List Directory page - I click on Create button to create List$")
    public void createList() throws Throwable {
        ListDirectoryPage listDirectoryPage = (ListDirectoryPage) getCurrentPage();
        LOGGER.debug("Through View Directory Page..Create new View ");
        setCurrentPage(listDirectoryPage.clickCreateList());
    }

    @Then("^On Create View page - I enter Name '([^\"']*)' and description '([^\"]*)'$")
    public void addViewDetails(String name, String desc) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        CreateViewPage createViewPage = (CreateViewPage) getCurrentPage();
        createViewPage.enterViewDetails(name, desc);
    }

    @Then("^On Create View page - I click on 'Save' button$")
    public void saveDetails() throws Throwable {
        CreateViewPage createViewPage = (CreateViewPage) getCurrentPage();
        setCurrentPage(createViewPage.clickSaveButton());
    }

    @Then("^On Manage view page - I verify that '([^\"']*)' is created$")
    public void on_Manage_view_page_I_verify_that_CatfishView_is_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^On Manage View page - I click on '([^\"']*)' toggle button$")
    public void clickAgreementsToggleBtn(String btnValue) throws Throwable {
        LOGGER.debug("On Manage View page - I click on"+ btnValue);
        ManageViewPage manageViewPage = (ManageViewPage) getCurrentPage();
        setCurrentPage( manageViewPage.addToView( btnValue ) );
    }

    @Then("^On Manage view page - I click create checkout form$")
    public void createCheckoutForm()
    {
        ManageViewPage manageViewPage = (ManageViewPage) getCurrentPage();
        manageViewPage.addCheckoutForm();
    }

    @When("^I add Agreement to the View$")
    public void addAgreement() throws Throwable {
        LOGGER.debug("Adding agreenment to the view--");
        SelectAgreementPage selectAgreementPage = (SelectAgreementPage)getCurrentPage();
        setCurrentPage(selectAgreementPage.addAgreement());
    }

    @Then("^I remove recently added Agreement to the View$")

    public void removeAgreementFromView() throws Throwable {
        LOGGER.debug("Remove agreement to the view--");
        SelectAgreementPage selectAgreementPage = (SelectAgreementPage)getCurrentPage();
        setCurrentPage(selectAgreementPage.removeAgreement());
    }

    @When("^I add agreement named 'CATFISH-ORG-ONLY-TAX-' to the View$")
    public void addAgreementDyanamic(String agreement) throws Throwable {
        SelectAgreementPage selectAgreementPage = (SelectAgreementPage)getCurrentPage();
        setCurrentPage(selectAgreementPage.addAgreement());
    }

    @When("^I publish the View$")
    public void publishView() throws Throwable {
        ManageViewPage manageViewPage = (ManageViewPage)getCurrentPage();
        setCurrentPage(manageViewPage.publishView());
    }

    @When("^On the View directory Page - I click on the first view$")
    public void clickFirst_view() throws Throwable {
        ViewDirectoryPage viewDirectoryPage = (ViewDirectoryPage)getCurrentPage();
        setCurrentPage(viewDirectoryPage.clickOnFirstView());
    }

    @When("^On the View directory page - I click on '([^\"']*)' button$")
    public void clickButton(String value) throws Throwable {
        LOGGER.debug("View Directory Page..I click on "+value);
        ViewDirectoryPage viewDirectoryPage = (ViewDirectoryPage)getCurrentPage();
        setCurrentPage(viewDirectoryPage.clickButton(value));
    }

    @When("^On Select User page - I add user '([^\"']*)' to the view$")
    public void addUserToView(String user) throws Throwable {
        SelectUsersPage selectUsersPage = (SelectUsersPage)getCurrentPage();
        setCurrentPage(selectUsersPage.addUser(user));
    }

    @Then("^On Manage View page - I verify that the View is published$")
    public void verifyPublishedView() throws Throwable {
        ManageViewPage manageViewPage = (ManageViewPage)getCurrentPage();
        manageViewPage.verifyViewPublished();
    }

    @And("^On Manage View page - I delete the view through URL$")
    public void deleteRecentView()
    {
        ManageViewPage manageViewPage = (ManageViewPage) getCurrentPage();
        manageViewPage.deleteView();
    }

    @When("^On Views directory page - I click on the Views '([^\"']*)' filter$")
    public void i_click_on_the_Views_Published_filter(String filterValue) throws Throwable {
        ViewDirectoryPage viewDirectoryPage = (ViewDirectoryPage)getCurrentPage();
        setCurrentPage(viewDirectoryPage.clickFilter(filterValue));
    }

    @When("^On List directory Page - I enter Name '([^\"']*)' and description '([^\"']*)'$")
    public void on_List_directory_Page_I_enter_Name_CatfishTestListName_and_description_CatfishListDescription(String name,String desc) throws Throwable {
        ListDirectoryPage listDirectoryPage = (ListDirectoryPage) getCurrentPage();
        //listName = listDirectoryPage.listNameNew(name);
        setCurrentPage(listDirectoryPage.enterListDetails(name, desc));
    }

    @When("^On List directory Page - I click on 'Save' button$")
    public void on_List_directory_Page_I_click_on_Save_button() throws Throwable {
        ListDirectoryPage listDirectoryPage = (ListDirectoryPage) getCurrentPage();
        setCurrentPage(listDirectoryPage.clickSaveButton());
    }

    @When("^On Create List page - I add items to the list$")
    public void on_Create_List_page_I_add_item_to_the_list() throws Throwable {
        CreateListPage createListPage = (CreateListPage) getCurrentPage();
        setCurrentPage(createListPage.addItems());
    }

    @Then("^On Create List page - verify that plus button changes to minus button$")
    public void verity_that_plus_button_changes_to_minus_button() throws Throwable {
         CreateListPage createListPage = (CreateListPage) getCurrentPage();
         createListPage.verifyBtn();
    }

    @When("^On Create List page - click Done and add two more items on next page$")
    public void addItemsFromNextPage() throws Throwable {
        CreateListPage createListPage = (CreateListPage)getCurrentPage();
        createListPage.clickDoneBtn();
        driver.navigate().back();
        createListPage.listFilterItemsNotOnList.click();
        setCurrentPage(createListPage.nextPage());
        createListPage.addItems();
        createListPage.verifyBtn();
        createListPage.clickDoneBtn();
        driver.navigate().back();
    }

    @Then("^On Create List page - I verify item count in '([^\"']*)' filter$")
    public void i_verify_item_count_in_Items_on_list_filter(String filter) throws Throwable {
        CreateListPage createListPage = (CreateListPage)getCurrentPage();
        setCurrentPage(createListPage.clickFilter(filter));
        createListPage.verifyItemCount();
    }

    @When("On Manage List page - I verify and click on Available Toggle Switch$")
    public void verifyAndClickAvailableToggleSwitch() throws Throwable {
        CreateListPage createListPage = (CreateListPage) getCurrentPage();
        setCurrentPage(createListPage.clickAvailableToggle());
    }

    @Then("On List directory page - I verify the List created and the status of Available knob$")
    public void verifyListCreatedAndToogleBtn(){
        ListDirectoryPage listDirectoryPage = (ListDirectoryPage)getCurrentPage();
        setCurrentPage(listDirectoryPage.getListStatus());
    }

    @When("On Marketplace Landing page - I hover to '([^\"']*)'$")
    public void verifyListCreatedAndToogleBtn(String element) {
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage) getCurrentPage();
        setCurrentPage(marketplaceLandingPage.hoverToMarketPlaceElement(element));
    }

    @Then("^I verify and click on the List created in previous steps$")
    public void i_verify_and_click_on_the_List_created_in_previous_steps() throws Throwable {
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage) getCurrentPage();
        setCurrentPage(marketplaceLandingPage.verifyAndClickList(props.get("listTitle")));
    }

    @Then("^I verify the added items in the List$")
    public void i_verify_the_added_items_in_the_List() throws Throwable {
        ShoppingListsPage shoppingListsPage = (ShoppingListsPage) getCurrentPage();
        shoppingListsPage.verifyNumOfListElemets();
    }

    @Then("^On List directory Page - I delete the list created$")
        public void deleteList() throws Throwable {
            ListDirectoryPage listDirectoryPage = (ListDirectoryPage) getCurrentPage();
            listDirectoryPage.deleteList();
    }

    @When("On Select view agreement page - I select agreement")
    public void searchAgreement()
    {
        SelectAgreementPage selectAgreementPage = (SelectAgreementPage)getCurrentPage();
        selectAgreementPage.searchSharedAgreement(props.get(TestConstants.ORG_AGREEMENT_NAME));
    }

}




