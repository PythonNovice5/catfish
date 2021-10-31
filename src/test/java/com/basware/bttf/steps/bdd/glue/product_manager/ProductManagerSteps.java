package com.basware.bttf.steps.bdd.glue.product_manager;

import com.basware.bttf.pages.product_manager.ProductManagerDashboardPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ProductManagerSteps extends AbstractSteps
{
    @Then("^I validate the Product Manager submenu items$")
    public void validateProductManagerSubMenus() throws Exception
    {
        LOGGER.debug( "(A product manager page) ... Validating submenu items" + "\n" );
        ProductManagerPage productManagerPage = ( ProductManagerPage ) getCurrentPage();
        Assert.assertTrue( "User has incorrect Product Manager submenu" , productManagerPage.validateSubmenuItems( getCurrentUser() ) );
    }

      @Then("^I click on the Product Manager '([^\"']*)' '([^\"']*)' submenu item$")
    public void clickProductManagerSubMenu( String  userType , String submenuItem ) throws Throwable
    {
        LOGGER.debug( "(A product manager page) ... Click Product Manager submenu item: " + submenuItem + "\n" );
        ProductManagerPage productManagerPage = ( ProductManagerPage ) getCurrentPage();
        setCurrentPage( productManagerPage.clickProductManagerSubmenuItem( userType , submenuItem ) );
    }


    @Then("^I select user mode as '([^\"']*)' on Product Manager page$")
    public void selectBuyerOrSupplier( String userMode ) throws Throwable
    {
        LOGGER.debug( "On Product Manager Page I select user mode as: " + userMode.toUpperCase() + "\n" );
        ProductManagerPage productManagerPage = ( ProductManagerPage ) getCurrentPage();
        productManagerPage.selectUserMode(userMode);
    }

    @Then("^I click on the Product Manager '([^\"']*)' '([^\"']*)' panel$")
    public void clickProductManagerPanel( String  userType , String panelName ) throws Throwable
    {
        LOGGER.debug( "(A product manager page) ... Click panel: " + panelName + "\n" );
        ProductManagerDashboardPage productManagerDashboardPage = ( ProductManagerDashboardPage ) getCurrentPage();
        setCurrentPage( productManagerDashboardPage.clickProductManagerPanel( userType , panelName ) );
    }

    @Then("^I click on the Product Manager '([^\"']*)' '([^\"']*)' workflow count$")
    public void clickProductManagerWorkflowCount( String  userType , String workflowItem ) throws Throwable
    {
        LOGGER.debug( "(A product manager page) ... Click workflow count: " + workflowItem + "\n" );
        ProductManagerDashboardPage productManagerDashboardPage = ( ProductManagerDashboardPage ) getCurrentPage();
        setCurrentPage( productManagerDashboardPage.clickProductManagerWorkflowCount( userType , workflowItem ) );
    }

}
