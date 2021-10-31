package com.basware.bttf.pages.product_manager.supplier.templates;

import com.basware.bttf.pages.product_manager.ProductManagerDashboardPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import com.basware.bttf.pages.product_manager.supplier.items.EditItemPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManageTemplateData extends ProductManagerDashboardPage {

        protected static Logger LOGGER = Logger.getLogger( ManageTemplateData.class.getName() );

    public ManageTemplateData()
        {
            PageFactory.initElements( driver, this );
        }

        public String getExpectedUrl()
        {
            return getBaseUrl() + "/products/itemTemplateValues/edit";
        }

        public String getExpectedTitle()
        {
            return "Product Manager: Manage Template Data";
        }


    @FindBy(xpath="//input[@ value='Save']")
    public WebElement FormSaveBtn;

    @FindBy(xpath="//div[text()='Text Entry (Single Line)']//..//..//..//div//input[@name='fields[0].initialValue']")
    public WebElement InitialValueTextEntrySingleLine;

    @FindBy(xpath="//div[text()='Text Entry (Multi Line)']//..//..//..//div//input[@name='fields[0].initialValue']")
    public WebElement InitialValueTextEntryMultiLine;


    @FindBy(xpath="//div[text()='Dropdown (Single-select)']//..//..//..//div//input[@name='fields[2].options[0].display']")
    public WebElement DisplayTextDropDownSingleSelect;

    @FindBy(xpath="//div[text()='Dropdown (Single-select)']//..//..//..//div//input[@name='fields[2].options[0].basket']")
    public WebElement BasketValueDropDownSingleSelect;

    @FindBy(xpath="//div[text()='List (multi-select)']//..//..//..//div//input[@name='fields[3].options[0].basket']")
    public WebElement BasketValueListMultiSelect;

    @FindBy(xpath="//div[text()='List (multi-select)']//..//..//..//div//input[@name='fields[3].options[0].display']")
    public WebElement DisplayTextListMultiSelect;

    public EditItemPage clickSaveBtn() throws Exception
    {
        FormSaveBtn.click();
        pauseFor(2000);
        return new EditItemPage();
    }

    public ItemTemplateDirectoryPage saveForEditItemTemplate(){
        FormSaveBtn.click();
        pauseFor(2000);
        return new ItemTemplateDirectoryPage();
    }

}
