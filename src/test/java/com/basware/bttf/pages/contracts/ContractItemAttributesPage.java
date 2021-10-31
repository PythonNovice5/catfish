package com.basware.bttf.pages.contracts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractItemAttributesPage extends ContractsPage {

    @FindBy(name = "itemAttributesConfig")
    private WebElement itemAttributesConfig;

    @FindBy(name = "_action_saveConfig")
    private WebElement saveItemAttributes;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/contracts/manageItems/configure";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Basware Network";
    }

    public void enterItemAttributes(String attributes) throws Exception {
       // itemAttributesConfig.sendKeys(attributes);
        itemAttributesConfig.click();
        setValueOfWebElement(itemAttributesConfig,attributes);
        /*itemAttributesConfig.click();
        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);",itemAttributesConfig,attributes);*/
    }


    public ContractManageItemsPage saveAttributes()
    {
//        pauseFor(10000);

        waitUntillElementIsClickableAndClick(saveItemAttributes);
//
//        waitUntilDisplayed(saveItemAttributes);
//        saveItemAttributes.click();

        return  new ContractManageItemsPage();
    }
}
