package com.basware.bttf.steps.bdd.glue.product_manager.buyer.categories;

import com.basware.bttf.pages.product_manager.buyer.categories.CoderPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CoderPageSteps extends AbstractSteps {

    @When("^On Coder page - I delete previous data$")
    public void deleteData() throws Throwable
    {
        LOGGER.debug("On Coder page - Clearning the previous data ..");
        CoderPage coderPage = (CoderPage) getCurrentPage();
        setCurrentPage(coderPage.clearCoderData());
    }

    @Then("^On Coder page - I enter '([^\"]*)' into '([^\"]*)'$")
    public void enterValueIntoElement( String value, String elementName )  throws Throwable
    {
        LOGGER.debug( "Classification Mapper Page ... Enter value " + value + " into element " + elementName + "\n" );
        props.set(elementName,value);
        CoderPage coderPage = (CoderPage) getCurrentPage();
        coderPage.enterValueIntoElement( value, elementName);
    }

    @When("On Coder page - I click on plus button")
    public void clickPlusButton()
    {
        CoderPage coderPage = (CoderPage) getCurrentPage();
        coderPage.clickPlusBtn();
    }

    @When("On Coder page - I click on '([^\"]*)' button")
    public void clickSaveButton(String btn) throws Throwable
    {
        CoderPage coderPage = (CoderPage)getCurrentPage();
        coderPage.clickSave(btn);
    }

    @Then("On Coder page - I verify '([^\"]*)' value")
    public void verifyValue(String element) throws Exception
    {
        CoderPage coderPage = (CoderPage)getCurrentPage();
        String actual = coderPage.getValue(element);
        assertEquals("Expected and Actual values for " +element+" do not match!" ,actual,props.get(element));
    }

}
