package com.basware.bttf.steps.bdd.glue.shopping.punchin_out;

import com.basware.bttf.pages.external.punchout.AmazonBusinessPage;
import com.basware.bttf.pages.external.punchout.AmazonProductPage;
import com.basware.bttf.pages.external.punchout.AmazonSearchProductPage;
import com.basware.bttf.pages.external.punchout.AmazonShoppingBasketPage;
import com.basware.bttf.pages.shopping.marketplace.*;

import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class AmazonPunchoutSteps extends AbstractSteps {

    @When("^On the Amazon Business page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterValueIntoField( String elementName, String field ) throws Throwable
    {
        LOGGER.debug( "Amazon Business page ... Enter value " + elementName + " into element " + field + "\n" );
        props.set("Product",elementName);
        AmazonBusinessPage amazonBusinessPage = (AmazonBusinessPage)getCurrentPage();
        amazonBusinessPage.enterInSearchBox(elementName);
    }

    @When("^On the Amazon Business page - I click on the '([^\"']*)' button$")
    public void clickButton( String buttonName ) throws Exception {
        LOGGER.debug("Amazon Business page ... Click " + buttonName + " button" + "\n");
        AmazonBusinessPage amazonBusinessPage = (AmazonBusinessPage) getCurrentPage();
        switch (buttonName) {
            case "Search":
                setCurrentPage(amazonBusinessPage.clickSrchButton());
                break;
            default:
                throw new RuntimeException("No case statement for button: " + buttonName);
        }

    }

        @Then("^On the Amazon Search Product page - I click on the '([^\"']*)' filter$")
        public void clickFilter( String filterName ) throws Exception {
            LOGGER.debug("Amazon Laptop page ... Click " + filterName + " button" + "\n");
            AmazonSearchProductPage amazonSearchProductPage = (AmazonSearchProductPage) getCurrentPage();
            setCurrentPage(amazonSearchProductPage.clickFilter(filterName));
            }


    @When("^On the Amazon Search Product page - I click on '([^\"']*)' link$")
    public void clickLink( String link ) throws Exception {
        LOGGER.debug("Amazon Search Product page ... Click " + link + " link" + "\n");
        AmazonSearchProductPage amazonSearchProductPage = (AmazonSearchProductPage) getCurrentPage();
        setCurrentPage(amazonSearchProductPage.clickProductLink(link));
    }

    @When("On the Amazon Search Product Page - I click on '([^\"']*)'")
    public void clickOn(String prod) throws Exception{
        LOGGER.debug("On Amazon Search Product Page ..Click on "+ prod +"\n");
        AmazonSearchProductPage amazonSearchProductPage = (AmazonSearchProductPage) getCurrentPage();
        setCurrentPage(amazonSearchProductPage.clickProductLink(prod));

    }

    @When("On the Amazon Product Page - I verify that the product '([^\"']*)' dispatched by Amazon")
    public void verifyDispatch(String status) throws Exception{
        AmazonProductPage amazonProductPage= (AmazonProductPage) getCurrentPage();
        setCurrentPage(amazonProductPage.verifyDispatchedBy(status));
    }


    @When("On the Amazon Product Page - I click on '([^\"']*)' button")
    public void clickBtn(String btn) throws Exception{
        LOGGER.debug("On Amazon Product Page ..Click "+ btn +"\n");
        AmazonProductPage amazonProductPage = (AmazonProductPage) getCurrentPage();
        setCurrentPage(amazonProductPage.clickButton(btn));
    }


    @When("On the Amazon Shopping Basket page - I click on '([^\"']*)' button")
    public void clickButtonValue(String btn) throws Exception{
        LOGGER.debug("On Amazon Shopping Basket Page ..Click "+ btn +"\n");
        AmazonShoppingBasketPage amazonShoppingBasketPage = (AmazonShoppingBasketPage) getCurrentPage();
        switch (btn){
            case "Search":
                setCurrentPage(amazonShoppingBasketPage.clickSrchButton());
                break;
            case "SubmitForApproval":
                setCurrentPage(amazonShoppingBasketPage.clickSubmitForApproval());
                break;
        }
    }

    @When("^On the Amazon Shopping Basket page - I enter '([^\"']*)' into '([^\"']*)'$")
    public void enterValue( String elementName, String field ) throws Throwable
    {
        LOGGER.debug( "Amazon Shopping Basket page ... Enter value " + elementName + " into element " + field + "\n" );
        props.set("Product",elementName);
        AmazonShoppingBasketPage amazonShoppingBasketPage = (AmazonShoppingBasketPage)getCurrentPage();
        amazonShoppingBasketPage.enterInSearchBox(elementName);
    }


    @When("^On the Shopping Basket page - I check that '([^\"']*)' is not available$")
    public void checkAvailability( String product) throws Throwable
    {
        LOGGER.debug( "Shopping Basket page ... Check availability for: "+ "\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage) getCurrentPage();
        shoppingBasketPage.checkAvailability(product);
    }


    @When("^On the Shopping Basket page - I check that '([^\"']*)' '([^\"']*)' disabled$")
    public void checkStatus( String elem,String isOrIsNot) throws Throwable
    {
        LOGGER.debug( "Shopping Basket page ... Check Status of: "+ elem +"\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage) getCurrentPage();
        assertTrue(elem + " button is disabled", shoppingBasketPage.elementIsDisplayed(elem));
        if (elem.equals("CheckoutButton")) {
            if (isOrIsNot.equals("is"))          // if expecting the element to be displayed
                assertTrue(elem + " button is disabled", shoppingBasketPage.elementIsDisplayed("CheckoutButtonDisabled"));
            else                                // if expecting the element not to be displayed
                assertTrue(elem + " button is not disabled", shoppingBasketPage.elementIsNotDisplayed("CheckoutButtonDisabled"));
        }

//        if(isOrIsNot.equals("is"))          // if expecting the element to be displayed
//            assertTrue(elem + " button is disabled", shoppingBasketPage.elementIsNotDisplayed( elem ));
//        else                                // if expecting the element not to be displayed
//        assertTrue(elem + " button is not disabled", shoppingBasketPage.elementIsDisplayed( elem ));
    }


    @When("^On the Shopping Basket page - I remove the unavailable item$")
    public void clickRemoveBtn() throws Throwable
    {
        LOGGER.debug( "Shopping Basket page ... click remove button to delete unavailable Item form the basket" +"\n" );
        ShoppingBasketPage shoppingBasketPage = (ShoppingBasketPage)getCurrentPage();
        setCurrentPage(shoppingBasketPage.removeUnavailableItem());

    }
}
