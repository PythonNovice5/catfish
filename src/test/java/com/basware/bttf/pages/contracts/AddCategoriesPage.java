package com.basware.bttf.pages.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoriesPage extends ContractsPage {

    @FindBy(name = "_action_save")
    private WebElement addCategoriesButton;
    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/contractCategories";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Add Category";
    }

    public AddCategoriesPage()
    {
        PageFactory.initElements(driver,this);
    }

    public ContractCategoryPage clickOnAddButton()
    {
      addCategoriesButton.click();
      return new ContractCategoryPage();
    }

}
