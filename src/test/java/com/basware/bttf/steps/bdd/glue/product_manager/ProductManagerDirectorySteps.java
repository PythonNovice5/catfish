package com.basware.bttf.steps.bdd.glue.product_manager;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.steps.bdd.glue.AbstractSteps;
import cucumber.api.java.en.Then;

public class ProductManagerDirectorySteps extends AbstractSteps
{
    @Then("^I select the '([^\"']*)' option from the '([^\"']*)' dropdown$")
    public void selectOptionFromDropdown( String dropdownOption, String dropdownName ) throws Exception
    {
        LOGGER.debug( "A Product Manager Directory Page Page ... Select " + dropdownOption + " from " + dropdownName + " dropdown" + "\n" );
        ProductManagerDirectoryPage productManagerDirectoryPage = (ProductManagerDirectoryPage)getCurrentPage();
        switch( dropdownName )
        {
            case "Sort By": productManagerDirectoryPage.sortBy( dropdownOption ); break;
            case "Results Per Page": productManagerDirectoryPage.selectResultsPerPage( dropdownOption ); break;
            default: throw new RuntimeException("No case statement for dropdown: " + dropdownName);
        }
    }
}
