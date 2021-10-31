package com.basware.bttf.pages.product_manager.supplier.price_lists;

import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class ManagePriceListPage extends ProductManagerDirectoryPage
{
    protected static Logger LOGGER = Logger.getLogger( ManagePriceListPage.class.getName() );

    // Breadcrumb
    @FindBy( xpath="//div[@id='breadcrumb-content']/ul/li[1]/a[contains(text(),'Price List Directory')]")
    public WebElement managePriceListBreadcrumbPriceListDirectory;

    @FindBy(linkText = "Publish")
    public WebElement PublishButton;
    // Price List Fields
    @FindBy( id="name_read")
    public WebElement managePriceListName;

    @FindBy( id="name_text_area")
    public WebElement managePriceListNameInput;

    @FindBy( id="name-cancelAction")
    public WebElement managePriceListNameCancel;

    @FindBy( id="name-saveAction")
    public WebElement managePriceListNameSave;

    @FindBy( id="reference_read")
    public WebElement managePriceListReference;

    @FindBy( id="reference_input")
    public WebElement managePriceListReferenceInput;

    @FindBy( id="reference-cancelAction")
    public WebElement managePriceListReferenceCancel;

    @FindBy( id="reference-saveAction")
    public WebElement managePriceListReferenceSave;

    @FindBy( xpath="//div[@id='details-row1']/div[4]" )
    public WebElement managePriceListType;

    @FindBy( xpath="//div[@id='details-row2']/div[2]" )
    public WebElement managePriceListCurrency;

    @FindBy( id="startDate_read")
    public WebElement managePriceListStartDate;

    @FindBy( id="startDate_input")
    public WebElement managePriceListStartDateInput;

    @FindBy( id="startDate-cancelAction")
    public WebElement managePriceListStartDateCancel;

    @FindBy( id="startDate-saveAction")
    public WebElement managePriceListStartDateSave;

    @FindBy( id="expiryDate_read")
    public WebElement managePriceListExpiryDate;

    @FindBy( id="expiryDate_input")
    public WebElement managePriceListExpiryDateInput;

    @FindBy( id="expiryDate-cancelAction")
    public WebElement managePriceListExpiryDateCancel;

    @FindBy( id="expiryDate-saveAction")
    public WebElement managePriceListExpiryDateSave;

    @FindBy( id="description_read")
    public WebElement managePriceListDescription;

    @FindBy( id="description_text_area")
    public WebElement managePriceListDescriptionInput;

    @FindBy( id="description-cancelAction")
    public WebElement managePriceListDescriptionCancel;

    @FindBy( id="description-saveAction")
    public WebElement managePriceListDescriptionSave;

    @FindBy( id="keywords_read")
    public WebElement managePriceListKeywords;

    @FindBy( id="keywords_text_area")
    public WebElement managePriceListKeywordsInput;

    @FindBy( id="keywords-cancelAction")
    public WebElement managePriceListKeywordsCancel;

    @FindBy( id="keywords-saveAction")
    public WebElement managePriceListKeywordsSave;

    // Help text
    @FindBy( xpath="//div[@id='instructions']/p[1]")
    public WebElement managePriceListHelpTextFirstPara;

    // Management buttons
    @FindBy( xpath="//a[@title='Manage delivery items']//span")
    public WebElement managePriceListDeliveryItemsManage;

    @FindBy( xpath="//a[@title='Manage standard items']//span")
    public WebElement managePriceListStandardItemsManage;

    @FindBy( xpath="//div[@id='componentLinks']/a[span[@title='View bundled items']]")
    public WebElement managePriceListBundlesView;

    @FindBy( xpath="//div[@id='relatedLinks']/a[span[@title='View related items']]")
    public WebElement managePriceListRelatedItemsView;

    @FindBy( id = "manageMatrix")
    public WebElement managePriceListMatrixItemsManage;

    @FindBy( xpath="//a[@id='manageAgreements']")
    public WebElement managePriceListAgreementsManage;

    @FindBy(xpath = "//div[text()='None']")
    public WebElement TaxType;

    @FindBy(xpath = "//select[@name='value']")
    public WebElement TaxDropDown;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OKBtn;

    @FindBy(id="taxTerritoryId")
    public WebElement TaxTerritory;

    @FindBy(id = "importBundle")
    private WebElement uploadBundle;

    @FindBy(id = "importRelated")
    private WebElement uploadRelatedItems;

    @FindBy(id = "importStandard")
    private WebElement importStandardItems;

    @FindBy(id = "exportStandard")
    private WebElement exportStandardItems;

    @FindBy(name= "_action_asd")
    private WebElement exportButton;

    @FindBy(xpath = "//*[@id='exportModalBody']/div[4]/div/p/a")
    private WebElement exportLink;

    @FindBy(id = "exportModalClose")
    private  WebElement closeModal;

    @FindBy(xpath = "//*[@id='sectionTitle_componentLinks']/span")
    private WebElement bundledText;

    @FindBy(xpath = "//*[@id='sectionTitle_relatedLinks']/span")
    private WebElement relatedText;

    @FindBy(xpath = "//*[@id='sectionTitle_standardItems']/span")
    private WebElement standardText;

    @FindBy(css = "#sectionTitle_standardItems .legend-text span")
    public WebElement numOfStandardItems;

    @FindBy(css = "#sectionTitle_componentLinks .legend-text span")
    public WebElement numOfBundledItems;

    @FindBy(css = "#sectionTitle_matrixItems .legend-text span")
    public WebElement numOfMatrixItems;





    public ManagePriceListPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/priceList/view";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Manage Price List";
    }

    @Override
    protected void initSortByItems() {

    }

    @Override
    protected void initFilterItems() {

    }

    public PriceListDirectoryPage managePriceListBreadcrumbClick()
    {
        managePriceListBreadcrumbPriceListDirectory.click();
        return new PriceListDirectoryPage();
    }


    public PriceListDeliveryItemsDirectoryPage clickButtonDeliveryItemsManage()
    {
        managePriceListDeliveryItemsManage.click();
        return new PriceListDeliveryItemsDirectoryPage();
    }

    public PriceListStandardItemsDirectoryPage clickButtonStandardItemsManage()
    {
        waitUntillElementIsClickableAndClick(managePriceListStandardItemsManage);
//        managePriceListStandardItemsManage.click();
        return new PriceListStandardItemsDirectoryPage();
    }

    public PriceListStandardItemsDirectoryPage clickButtonBundlesView()
    {
        waitUntillElementIsClickableAndClick(managePriceListBundlesView);
//        managePriceListBundlesView.click();
        return new PriceListStandardItemsDirectoryPage();
    }

    public PriceListStandardItemsDirectoryPage clickButtonRelatedItemsView()
    {
        waitUntillElementIsClickableAndClick(managePriceListRelatedItemsView);
//        managePriceListRelatedItemsView.click();
        return new PriceListStandardItemsDirectoryPage();
    }

    public String getNumOfItems(String itemType) throws Exception{
        WebElement elem = null;
        switch(itemType){
            case "StandardItems":
                elem = numOfBundledItems;
                break;
            case "MatrixItems":
                elem = numOfMatrixItems;
                break;
            case "BundledItems":
                elem = numOfBundledItems;
                break;
        }

       return getTextOfWebElement(elem);
    }

    public PriceListMatrixItemsDirectoryPage clickButtonMatrixItemsManage()
    {
        waitUntillElementIsClickableAndClick(managePriceListMatrixItemsManage);
//        managePriceListMatrixItemsManage.click();
        return new PriceListMatrixItemsDirectoryPage();
    }

     public PriceListAgreementsPage clickButtonAgreementsItemsManage()
    {
       waitUntillElementIsClickableAndClick(managePriceListAgreementsManage);
//        managePriceListAgreementsManage.click();
        return new PriceListAgreementsPage();
    }

    public UploadBundlesPage clickButtonImportBundledItems()
    {
       waitUntillElementIsClickableAndClick(uploadBundle);
//        uploadBundle.click();
       return new UploadBundlesPage();
    }

    public ImportRelatedItemsPage clickButtonImportedRelatedItems()
    {
        waitUntillElementIsClickableAndClick(uploadRelatedItems);
//        uploadRelatedItems.click();
        return new ImportRelatedItemsPage();
    }

    public ImportStandardItems  clickPriceListImportItems()
    {
//        waitUntilDisplayed(importStandardItems);
        waitUntillElementIsClickableAndClick(importStandardItems);
//        importStandardItems.click();
        return new ImportStandardItems();
    }

    public void clickPricelistExportItems()
    {
//        exportStandardItems.click();
        waitUntillElementIsClickableAndClick(exportStandardItems);
        waitUntillElementIsClickableAndClick(exportButton);
//        exportButton.click();
//        waitUntilDisplayed(exportLink);
        waitUntillElementIsClickableAndClick(exportLink);
//        exportLink.click();
//        pauseFor(2000);
        waitUntillElementIsClickableAndClick(closeModal);
        waitUntilNoModalPopup();
//        closeModal.click();
//        pauseFor(1000);
    }

    public ManagePriceListPage verifyAlert(String alert) throws Exception{
        pauseFor(1000);
        verifyMessage(alert);
        return new ManagePriceListPage();
    }


    public String getFieldValue( String fieldName )
    {
        String fieldValue = "";
        waitUntilDisplayed(managePriceListName);
        switch( fieldName )
        {
            case "Name":
                fieldValue = managePriceListName.getText();
                break;
            case "Reference":
                fieldValue = managePriceListReference.getText();
                break;
            case "Type":
                fieldValue = managePriceListType.getText();
                break;
            case "Currency":
                fieldValue = managePriceListCurrency.getText();
                break;
            case "Start Date":
                fieldValue = managePriceListStartDate.getText();
                break;
            case "Expiry Date":
                fieldValue = managePriceListExpiryDate.getText();
                break;
            case "Description":
                fieldValue = managePriceListDescription.getText();
                break;
            case "Keywords":
                fieldValue = managePriceListKeywords.getText();
                break;
        }
        return fieldValue;
    }

    public void enterValueIntoField( String value, String fieldName,  String buttonSaveOrCancel ) throws InterruptedException
    {
        switch (fieldName)
        {
            case "Name":
                managePriceListName.click();
                managePriceListNameInput.sendKeys(value);
                if (buttonSaveOrCancel.toLowerCase().equals("save"))
                    managePriceListNameSave.click();
                else
                    managePriceListNameCancel.click();
                break;
            case "Reference":
                managePriceListReference.click();
                managePriceListReferenceInput.sendKeys(value);
                if (buttonSaveOrCancel.toLowerCase().equals("save"))
                    managePriceListReferenceSave.click();
                else
                    managePriceListReferenceCancel.click();
                break;
            case "Start Date":
                managePriceListStartDate.click();
                managePriceListStartDateInput.sendKeys(value);
                if (buttonSaveOrCancel.toLowerCase().equals("save"))
                    managePriceListStartDateSave.click();
                else
                    managePriceListStartDateCancel.click();
                break;
            case "Expiry Date":
                managePriceListExpiryDate.click();
                managePriceListExpiryDateInput.sendKeys(value);
                if (buttonSaveOrCancel.toLowerCase().equals("save"))
                    managePriceListExpiryDateSave.click();
                else
                    managePriceListExpiryDateCancel.click();
                break;
            case "Description":
                managePriceListDescription.click();
                managePriceListDescriptionInput.sendKeys(value);
                if (buttonSaveOrCancel.toLowerCase().equals("save"))
                    managePriceListDescriptionSave.click();
                else
                    managePriceListDescriptionCancel.click();
                break;
            case "Keywords":
                managePriceListKeywords.click();
                managePriceListKeywordsInput.sendKeys(value);
                if (buttonSaveOrCancel.toLowerCase().equals("save"))
                    managePriceListKeywordsSave.click();
                else
                    managePriceListKeywordsCancel.click();
                break;
        }
    }

    public int getHelpTextLength()
    {
        int helpTextLength;
        waitUntilDisplayed(managePriceListHelpTextFirstPara);
        try
        {
            helpTextLength = managePriceListHelpTextFirstPara.getText().length();
        }
        catch(Exception e)
        {
            helpTextLength = 0;
        }
        return helpTextLength;
    }

    public ManagePriceListPage setTaxSpecs(String value) throws Exception{

//        TaxType.click();
        waitUntillElementIsClickableAndClick(TaxType);
        selectDropdownOptionByText(TaxDropDown,value);
        waitUntillElementIsClickableAndClick(OKBtn);
//        OKBtn.click();
        pauseFor(2000);
        return new ManagePriceListPage();
    }

    public ManagePriceListPage setTaxTerritory(String value) throws Exception{
        waitUntillElementIsClickableAndClick(TaxTerritory);
//        TaxTerritory.click();
        selectDropdownOptionByText(TaxDropDown,value);
        waitUntillElementIsClickableAndClick(OKBtn);
//        OKBtn.click();
        pauseFor(5000);
        return new ManagePriceListPage();
    }

    public void enterValueIntoElement( String value, String elementName ) throws Exception
    {
        switch( elementName )
        {
//            case "FirstExternalLinkLabel": setValueOfWebElement( ExternalLinkLabels.get(0), value ); break;
//            case "FirstExternalLinkAddress": setValueOfWebElement( ExternalLinkAddresses.get(0), value ); break;
//            case "SecondExternalLinkLabel": setValueOfWebElement( ExternalLinkLabels.get(1), value ); break;
//            case "SecondExternalLinkAddress": setValueOfWebElement( ExternalLinkAddresses.get(1), value ); break;

            default: setValueOfWebElement( getWebElementNamed( elementName ), value );
        }
    }

    public void clickPublishButton(){
//        PublishButton.click();
        waitUntillElementIsClickableAndClick(PublishButton);
        pauseFor(2000);
        driver.navigate().refresh();
        return;
    }

    public void verifyUploadedItems(String type)
    {
        switch(type)
        {
            case "pricelist items":
                assertEquals(standardText.getText(),"(9 Items added)");
                break;
            case "bundled items":
                assertEquals(bundledText.getText(),"(1 Bundles added)");
                break;
            case "related items":
                assertEquals(relatedText.getText(),"(1 items have related items)");
                break;
        }

    }



}
