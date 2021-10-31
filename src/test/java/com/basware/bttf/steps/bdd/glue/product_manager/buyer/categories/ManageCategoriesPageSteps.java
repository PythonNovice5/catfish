package com.basware.bttf.steps.bdd.glue.product_manager.buyer.categories;
import com.basware.bttf.pages.product_manager.buyer.categories.ManageCategoriesPage;
import com.basware.bttf.pages.shopping.marketplace.MarketplaceLandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
//import sun.security.util.PendingException;

public class ManageCategoriesPageSteps extends AbstractSteps {

    @When("^On Manage Categories page - I delete previous data$")
    public void deleteData() throws Throwable{
        ManageCategoriesPage manageCategoriesPage = (ManageCategoriesPage)getCurrentPage();
        setCurrentPage(manageCategoriesPage.clearData());
    }


    @When("^On Manage Categories page - I click on '([^\"']*)' in dropdown$")
    public void clickCategoryInDropdown(String dropdownValue) throws Throwable {
        LOGGER.debug( "Manage Categories page ... I click on " + dropdownValue +"\n" );
        ManageCategoriesPage manageCategoriesPage = (ManageCategoriesPage)getCurrentPage();
        switch(dropdownValue){
            case "Heading":
                setCurrentPage(manageCategoriesPage.clickHeading());
                break;
            case "Category":
                setCurrentPage(manageCategoriesPage.clickCategory());
        }
    }

    @When("^On Manage Categories page - I enter '([^\"']*)' of Heading '([^\"']*)'$")
    public void enterNameOfHeading(String name,String ind) throws Throwable {
        LOGGER.debug( "Manage Categories page ... I enter " + name + " of Heading "+ ind +"\n" );
        ManageCategoriesPage manageCategoriesPage = (ManageCategoriesPage)getCurrentPage();
        int index = Integer.parseInt(ind);
        setCurrentPage(manageCategoriesPage.enterDetailsHeading(name,"None",index));
    }

    @When("^On Manage Categories page - I enter multiple '([^\"']*)' and '([^\"']*)' of Category '([^\"']*)'$")
    public void enterCatNameSearch(String name,String search,String ind) throws Throwable {
        LOGGER.debug( "Manage Categories page ... Enter multiple " + name + " and " + search + " of " + ind +"\n" );
        ManageCategoriesPage manageCategoriesPage = (ManageCategoriesPage)getCurrentPage();
        manageCategoriesPage.clickCategory();
        int index = Integer.parseInt(ind);
        manageCategoriesPage.enterDetailsCategory(name,search,index);
    }

    @When("^On Manage Categories page - I click on Publish$")
    public void clickPublish() throws Throwable {
        ManageCategoriesPage manageCategoriesPage = (ManageCategoriesPage)getCurrentPage();
        setCurrentPage(manageCategoriesPage.clickPublish());
        }

    @Then("^On Manage Categories page - I verify the success message$")
    public void verifySuccessMsg() throws Throwable{
        ManageCategoriesPage manageCategoriesPage = (ManageCategoriesPage)getCurrentPage();
        setCurrentPage(manageCategoriesPage.validateSuccessMsg());
    }

    @Then("^On the Marketplace Landing page - I verify the category search for '([^\"']*)' in '([^\"']*)'$")
    public void verifyCategorySearch(String search,String categoryName) throws Throwable {
        MarketplaceLandingPage marketplaceLandingPage = (MarketplaceLandingPage) getCurrentPage();
        marketplaceLandingPage.searchCat(search, categoryName);

    }
}