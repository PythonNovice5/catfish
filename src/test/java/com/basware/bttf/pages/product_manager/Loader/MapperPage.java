package com.basware.bttf.pages.product_manager.Loader;

import com.basware.bttf.util.TestConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapperPage extends TwoStageLoaderDashboardPage {

    @FindBy(id= "destination-select")
    private WebElement destinationDropDown;

    @FindBy(id = "file-type-select")
    private WebElement fileTypeDropDown;

    @FindBy(id = "mapping-name")
    private WebElement mappingName;

    @FindBy(id = "mapping-description")
    private WebElement mappingDescription;

    @FindBy(name = "file-select-input")
    private WebElement chooseFile;

    @FindBy(id="file-sheet-select")
    private WebElement sheetNumber;

    @FindBy(id="start-row")
    private WebElement startRowNumber;

    @FindBy(xpath = "//*[contains(@id, '(Item ID)')]")
    public  WebElement sourceCustomId;

    @FindBy(xpath = "//*[contains(@id, '(Item Name)')]")
    public WebElement sourceItemName;

    @FindBy(xpath = "//*[contains(@id, '(Item Type)')]")
    public WebElement sourceItemType;

    @FindBy(xpath = "//*[contains(@id, '(Delivery Item ID)')]")
    public WebElement sourceDeliveryId;

    @FindBy(xpath = "//*[contains(@id, '(Delivery Type)')]")
    public WebElement sourceDeliveryType;

    @FindBy(xpath = "//*[contains(@id, '(Unit of Measure)')]")
    public WebElement sourceUOM;

    @FindBy(xpath = " //*[contains(@id, 'Number in an Order Unit')] ")
    public WebElement sourceNumberInOrderUnit;

    @FindBy(xpath = "//*[contains(@id, '(Unit Price)')]")
    public WebElement sourceUnitPrice;

    @FindBy(xpath = "//*[contains(@id, 'Tax Code')]")
    public WebElement sourceTaxRate;

    @FindBy(xpath="//*[contains(@id, '(TAX territory)')]")
    public WebElement sourceTaxTerritory;

    @FindBy(xpath = "//*[contains(@id, '(Minimum Order Quantity)')]")
    public WebElement sourceMinimumOrderUnity;

    @FindBy(xpath = "//*[contains(@id, '(Quantity Interval)')]")
    public WebElement  sourceQualityInterval;

    @FindBy(xpath = "//*[contains(@id, '(UNSPSC v8)')]")
    public WebElement sourceUNSPSC;

    @FindBy(xpath = " //*[contains(@id, 'Goods or Service')]")
    public WebElement  sourceGoodsOrService ;

    @FindBy(xpath = " //*[contains(@id, '(Long Description)')]")
    public WebElement sourceLongDescription;

    @FindBy(xpath = " //*[contains(@id, '(Keywords)')]")
    public WebElement sourceKeywords;

    @FindBy(xpath = " //*[contains(@id, '(Manufacturer Part Number)')]")
    public WebElement sourceManufacturerPartId;

    @FindBy(xpath = " //*[contains(@id, 'Manufacturer Name')]")
    public WebElement sourceManufacturerName;

    @FindBy(id = "unmapped-8")
    public WebElement sourceUnspscVersion;

    @FindBy(id= "unmapped-UNSPSC")
    public WebElement sourceUnspscUNSPSCType;


    @FindBy(id = "unmapped-itemId")
    public WebElement destinationCustomId;

    @FindBy(id = "unmapped-itemName")
    public WebElement destinationItemName;

    @FindBy(id = "unmapped-itemType")
    public WebElement destinationItemType;

    @FindBy(id = "unmapped-deliveryItemId")
    public WebElement destinationDeliveryId;

    @FindBy(id = "unmapped-deliveryType")
    public WebElement destinationDeliveryType;

    @FindBy(id = "unmapped-unitOfMeasure")
    public WebElement destinationUOM;

    @FindBy(id = "unmapped-itemsPerUOM")
    public WebElement destinationNumberInOrderUnit;

    @FindBy(id = "unmapped-minimumOrderQuantity")
    public WebElement destinationMinimumOrderQuantity;

    @FindBy(id = "unitPrice_6")
    public WebElement destinationUnitPrice;

    @FindBy(id = "unmapped-taxCode")
    public WebElement destinationTaxRate;

    @FindBy(id = "unmapped-taxTerritory")
    public WebElement destinationTaxTerritory;

    @FindBy(id = "unmapped-quantityInterval")
    public WebElement destinationQualityInterval;

    @FindBy(id = "unmapped-code")
    public WebElement destinationUNSPSC;

    @FindBy(id = "scheme_10")
    public WebElement destinationClassificationType;

    @FindBy(id= "version_10")
    public WebElement destinationUNSPSCVersion;

    @FindBy(id = "scheme_8")
    public WebElement destinationClassificationTypeNoTax;

    @FindBy(id= "version_8")
    public WebElement destinationUNSPSCVersionNoTax;


    @FindBy(id = "unmapped-itemClass")
    public WebElement destinationGoodsOrService;

    @FindBy(id = "unmapped-description")
    public WebElement destinationLongDescription;

    @FindBy(id = "unmapped-keywords")
    public WebElement destinationKeywords;

    @FindBy(id = "unmapped-manufacturerPartId")
    public WebElement destinationManufacturerPartId;

    @FindBy(id = "unmapped-manufacturerName")
    public WebElement destinationManufacturerName;

    @FindBy(id = "save-mapping-button")
    private WebElement saveMappingButton;

    @FindBy(id = "mapping-action-deliveryItemId")
    public WebElement mappingActionDeliveryItemId;

    @FindBy(id = "mapping-action-deliveryType")
    public WebElement mappingActionDeliveryType;

    @FindBy(id = "mapping-action-itemClass")
    public WebElement mappingActionItemClass;

    @FindBy(id = "transforms-dialog-add-row")
    private WebElement addTransform;

    @FindBy(id = "edit-transform-0")
    private WebElement changeTransformType;

    @FindBy(id = "choose-transform-MAP")
    private WebElement mapAction;

    @FindBy(id = "transform-source-0-0")
    private WebElement sourceValue;

    @FindBy(id ="transforms-dialog-update")
    private  WebElement updateButton;

    @FindBy(id= "add-source-bottom-button")
    private WebElement addSourceButton;

    @FindBy(xpath = "//button[contains(text(),'Constant')]")
    private WebElement constantButton;

    @FindBy(css = "input[name='source']")
    private WebElement enterConstantName;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addColumnButton;


    public MapperPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/ui/products/loader/mapper";
    }

    @Override
    public String getExpectedTitle() {
        return "Content Loader: Mapper";
    }


    public void enterMappingDetails(String field, String value) {

        switch (field) {
            case "Destination":
                pauseFor(1000);
                selectDropdownOption(destinationDropDown, value);
                break;
            case "File type":
                selectDropdownOption(fileTypeDropDown, value);
                break;
            case "Mapping Name":
                String newMappingName = value + getSessionID();
                mappingName.sendKeys(newMappingName);
                props.set(TestConstants.MAPPING_NAME, newMappingName );
                break;
            case "Description":
                mappingDescription.sendKeys(value);
                break;
            case "Sheet number":
                pauseFor(1000);
                selectDropdownOption(sheetNumber,value);
                break;
            case "Start row":
                startRowNumber.clear();
                startRowNumber.sendKeys(value);
                break;
        }
    }

    public void enterFileToUpload(String fileName)
    {
       chooseFile.sendKeys(getFilePath() + fileName);
    }

    public void mapAllFields(String sourceColumn, String destinationColumn) throws Exception {

        pauseFor(1000);
        dragAndDrop(getWebElement(sourceColumn),getWebElement(destinationColumn));
    }

    public void dragAndDrop(WebElement fromElement, WebElement toElement )
    {
        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(fromElement)

                .moveToElement(toElement)

                .release(toElement)

                .build();

        dragAndDrop.perform();
    }

    public void saveMapping()
    {
        clickWebElement(saveMappingButton);
    }

    public void addMappingActions(String element, String value) throws Exception {
        getWebElement(element).click();
        addTransform.click();
        changeTransformType.click();
        pauseFor(500);
        mapAction.click();
        sourceValue.sendKeys(value);
        updateButton.click();
        pauseFor(500);
    }


    public void createConstantColumn(String constantColumnName) throws  Exception
    {
        pauseFor(1000);
        addSourceButton.click();
        constantButton.click();
//        enterValueIntoElement(constantColumnName,"enterConstantName");
        pauseFor(1000);
        enterConstantName.sendKeys(constantColumnName);
        addColumnButton.click();
    }
}
