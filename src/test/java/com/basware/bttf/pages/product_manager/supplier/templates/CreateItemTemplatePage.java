package com.basware.bttf.pages.product_manager.supplier.templates;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.items.CreateItemPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by DuncanNash on 04/03/2017.
 */
public class CreateItemTemplatePage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( CreateItemPage.class.getName() );

    public CreateItemTemplatePage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/itemTemplate/edit";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Create Item Template";
    }

    @FindBy( name="name")
    public WebElement TemplateName;

    @FindBy( name="description")
    public WebElement TemplateDescription;

    @FindBy( xpath="//div//strong[contains(text(),'Text Entry (Single Line)')]//..//following-sibling::div//span[@title='add']")
    public WebElement PlusButtonTextEntrySingleLine;

    @FindBy( xpath="//div//strong[contains(text(),'Text Entry (Multi Line)')]//..//following-sibling::div//span[@title='add']")
    public WebElement PlusButtonTextEntryMultiLine;

    @FindBy( xpath="//div//strong[contains(text(),'Dropdown (Single-select)')]//..//following-sibling::div//span[@title='add']")
    public WebElement PlusButtonDropDownSingleSelect;

    @FindBy( xpath="//div//strong[contains(text(),'List (multi-select)')]//..//following-sibling::div//span[@title='add']")
    public WebElement PlusButtonListMultiSelect;

    @FindBy( xpath="//div//strong[contains(text(),'Buyer guidance text')]//..//following-sibling::div//span[@title='add']")
    public WebElement PlusButtonBuyerGuidanceText;


    @FindBy( xpath="//label//following-sibling::div//input")
    public WebElement Label;

    @FindBy( xpath="//div[@class='row field field-variable']//input")
    public WebElement VariableName;

    @FindBy( name="maxSize")
    public WebElement MaxSize;

    @FindBy( name="minSize")
    public WebElement MinSize;

    @FindBy(xpath = "//div[normalize-space(text())='Override basket value:']//..//select")
    public WebElement OverrideBasketValue;


    @FindBy(xpath = "//form//input[@value='Save']")
    public WebElement FormSaveBtn;

    @FindBy(xpath = "//div[@id='page-actions']//input[@value='Save']")
    public WebElement TempSaveBtn;

    @FindBy(xpath = "//label//following-sibling::div//textarea")
    public WebElement Text;


    public CreateItemTemplatePage enterValueIntoField(String value,String field) throws Exception{
        if (field.contains("TemplateName")){
            value = value + getDateTimeNow();
            props.set("TemplateName",value);
        }
        enterValueIntoElement(value,field);
        return new CreateItemTemplatePage();
    }

    public CreateItemTemplatePage clickPlusButtonFor(String tool){
        switch(tool){
            case "TextEntrySingleLine":
                PlusButtonTextEntrySingleLine.click();
                break;
            case "TextEntryMultiLine":
                PlusButtonTextEntryMultiLine.click();
                break;
            case "DropdownSingleSelect":
                PlusButtonDropDownSingleSelect.click();
                break;
            case "ListMultiSelect":
                PlusButtonListMultiSelect.click();
                break;
            case "BuyerGuidanceText":
                PlusButtonBuyerGuidanceText.click();
                break;
        }
        return new CreateItemTemplatePage();
    }

    public CreateItemTemplatePage selectValueFromDropDown(String value,String dropdownName) throws Exception
    {
        selectDropdownOption(getWebElementNamed(dropdownName),value);
        pauseFor(2000);
        return new CreateItemTemplatePage();
    }

    public ProductManagerPage clickSave(String tool) throws Exception
    {
        if (tool.contains("ItemTemplate"))
        {
            TempSaveBtn.click();
            return new ItemTemplateDirectoryPage();
        }
        FormSaveBtn.click();
//        pauseFor(2000);
        return new CreateItemTemplatePage();
    }

}
