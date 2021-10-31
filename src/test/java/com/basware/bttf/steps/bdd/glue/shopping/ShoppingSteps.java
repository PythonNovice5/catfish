package com.basware.bttf.steps.bdd.glue.shopping;
// Created by Julian Sheppard on 21/04/2017

import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

public class ShoppingSteps extends AbstractSteps
{
    @Then("^I click on the Shopping '([^\"']*)' submenu item$")
    public void clickOnShoppingSubMenuitem( String submenuItem ) throws Throwable
    {
        LOGGER.debug( "(A shopping page) ... Click Shopping submenu item: " + submenuItem + "\n" );
        ShoppingPage shoppingPage = (ShoppingPage) getCurrentPage();
        switch( submenuItem )
        {
            case "Notifications": setCurrentPage( shoppingPage.clickSubMenuNotifications() ); break;
//            case "Catalogue Shopping": setCurrentPage( shoppingPage.clickSubMenuCatalogueShopping() ); break;
            case "Marketplace": setCurrentPage( shoppingPage.clickSubMenuMarketplace() ); break;
            case "Quick Quote": setCurrentPage( shoppingPage.clickSubMenuQuickQuotation() ); break;
            case "Free Text Requisitions": setCurrentPage( shoppingPage.clickSubMenuFreeTextRequisitions() ); break;
            case "Request for Quotation": setCurrentPage(shoppingPage.clickSubMenuRequestForQuotation());break;
        }
    }

}
