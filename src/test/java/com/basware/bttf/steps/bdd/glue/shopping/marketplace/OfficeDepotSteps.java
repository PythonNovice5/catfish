package com.basware.bttf.steps.bdd.glue.shopping.marketplace;

import com.basware.bttf.pages.external.OfficeDepot.*;
import com.basware.bttf.pages.shopping.freetextrequisitions.FTREditPage;
import com.basware.bttf.pages.shopping.marketplace.ShoppingBasketPage;
import com.basware.bttf.pages.shopping.requestforquotation.MyRequestsForQuotePage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OfficeDepotSteps extends AbstractSteps {

    @When("^On Diaries And Calendars Page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterValue(String value, String field) throws Throwable
    {
        LOGGER.debug("On Diaries And Calendars Page - I enter "+value+" into "+field);
        OfficeDepotDiariesCalendersPage officeDepotDiariesCalendersPage = (OfficeDepotDiariesCalendersPage) getCurrentPage();
        officeDepotDiariesCalendersPage.enterValueIntoElement(value,field);
    }

    @When("^On Ballpoint Pens and Pencils Page - I enter '([^\"']*)' into '([^\"']*)'")
    public void enterValueInto(String value, String field) throws Throwable
    {
        LOGGER.debug("On Ballpoint Pens and Pencils Page - I enter "+value+" into "+field);
        OfficeDepotBallPointPensPage officeDepotBallPointPensPage = (OfficeDepotBallPointPensPage) getCurrentPage();
        officeDepotBallPointPensPage.enterValueIntoElement(value,field);
    }


    @And("^On Office Depot Home page - I click on '([^\"']*)' under Office Supplies")
    public void clickOn(String elem) throws Exception
    {
        LOGGER.debug("On Office Depot Home Page - click on "+elem);
        OfficeDepotHomePage officeDepotHomePage = (OfficeDepotHomePage) getCurrentPage();
        setCurrentPage(officeDepotHomePage.clickElement(elem));
    }


    @And("^On Ballpoint Pens and Pencils Page - I click on '([^\"']*)' button")
    public void clickThisButton(String elem) throws Exception
    {
        LOGGER.debug("On Ballpoint Pens and Pencils Page - click on "+elem);
        OfficeDepotBallPointPensPage officeDepotBallPointPensPage = (OfficeDepotBallPointPensPage) getCurrentPage();
        setCurrentPage(officeDepotBallPointPensPage.clickOnElem(elem));
    }

    @And("^On Diaries And Calendars Page - I click on '([^\"']*)' button")
    public void clickButton(String elem) throws Exception
    {
        LOGGER.debug("On Diaries And Calendars Page - click on "+elem);
        OfficeDepotDiariesCalendersPage officeDepotDiariesCalendersPage = (OfficeDepotDiariesCalendersPage) getCurrentPage();
        setCurrentPage(officeDepotDiariesCalendersPage.clickOnElem(elem));
    }


    @And("^On Find Your Product Page - I click on '([^\"']*)' button")
    public void clickOnButton(String elem) throws Exception
        {
        LOGGER.debug("On Find Your Product Page - click on "+elem);
        OfficeDepotFindYourProductPage officeDepotFindYourProductPage = (OfficeDepotFindYourProductPage) getCurrentPage();
        setCurrentPage(officeDepotFindYourProductPage.clickThisElem(elem));
        }

    @Then("On Office Depot Shopping Basket page - I verify that '([^\"']*)' is '([^\"']*)'")
    public void verifyDesc(String elem,String value) throws  Exception {
        LOGGER.debug("n Office Depot Shopping Basket page... " + " I verify " + elem+"\n");
        OfficeDepotShoppingBasketPage officeDepotShoppingBasketPage = (OfficeDepotShoppingBasketPage) getCurrentPage();
        String actual = officeDepotShoppingBasketPage.getElementValue(elem);
        LOGGER.debug( "On Office Depot Shopping Basket page... Comparing " + elem + ": Expected:[" + value + "] Actual:[" + actual + "]" + "\n");
        Assert.assertTrue(actual.contains(value));
    }

    @And("^On Office Depot Shopping Basket page - I click on '([^\"']*)' button")
    public void clickOnBtn(String elem) throws Exception
    {
        LOGGER.debug("On Office Depot Shopping Basket page - click on "+elem);
        OfficeDepotShoppingBasketPage officeDepotShoppingBasketPage = (OfficeDepotShoppingBasketPage) getCurrentPage();
        setCurrentPage(officeDepotShoppingBasketPage.clickThisElem(elem));
    }


    @And("^On Office Depot B2B page - I click on '([^\"']*)' button")
    public void clickBtn(String elem) throws Exception
    {
        LOGGER.debug("On Office Depot B2B page - click on "+elem);
        OfficeDepotB2BPage officeDepotB2BPage = (OfficeDepotB2BPage) getCurrentPage();
        setCurrentPage(officeDepotB2BPage.clickThisElem(elem));
    }

}