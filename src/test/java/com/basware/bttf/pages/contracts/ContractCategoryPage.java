package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractCategoryPage extends ContractsPage {

    @FindBy(linkText = "Add Categories")
    private WebElement addCategoriesButton;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/contractCategories";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Manage Categories";
    }

    public ContractCategoryPage()
    {
        PageFactory.initElements(driver,this);
    }

    public AddCategoriesPage clickOnAddCategories()
    {
        addCategoriesButton.click();
        return new AddCategoriesPage();
    }

}
