package com.basware.bttf.pages.product_manager.supplier.items;
// Created by Julian Sheppard on 21/06/2017

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ItemTemplateDirectoryPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ManageTemplateData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class EditItemPage extends ProductManagerPage
{

    @FindBy(xpath="//div[@id='itemTemplateDetail']//..//span[@title='Manage']" )
    public WebElement ManageTemplate;

    @FindBy(xpath = "//div[@id='selectItemTemplateBody']//span[@class='glyphicon glyphicon-plus']")
    public WebElement AddBtn;

    @FindBy(xpath = "//div[@id='selectItemTemplateBody']//strong[contains(text(),'Catfish')]")
    public WebElement ItemTemplate;

    @FindBy( xpath="//button[normalize-space(text())='Search']" )
    protected WebElement directoryButtonSearch;

    @FindBy( name="keywords" )
    protected WebElement directoryInputSearch;

    @FindBy( xpath="//a[starts-with(@name,'linked_media_')]")
    public List<WebElement> ModalFirstLinkedMediaFiles;

    // Thumbnails
    @FindBy( xpath="//a[starts-with(@name,'file_')]" )
    public List<WebElement> Thumbnails;

    @FindBy(xpath="//label[@title=\"Template Data\"]//..//span" )
    public WebElement ManageTemplateData;

    // Page title area fields
    @FindBy( name="alertMessageDetail" )
    public WebElement HeaderAlertMessage;

    @FindBy(xpath="//span[@name='alertMessageDetail']" )
    public WebElement AlertMsg;

    @FindBy( name="closeAlertButton" )
    public WebElement HeaderAlertMessageClose;

    @FindBy( id="editProductPageTitle" )
    public WebElement PageTitle;

    @FindBy( id="keywords" )
    public WebElement SearchKeywords;

    @FindBy(xpath = "//div[@id=\"mediaModal\"]//*[@class=\"modal-title\"]")
    public WebElement ModalWindowTitle;

    @FindBy( id="publishButton_0" )
    public WebElement UpdateMarketplaceButtonTop;

    @FindBy( id="previewButton_0" )
    public WebElement PreviewButtonTop;

    @FindBy( id="cancelButton_0" )
    public WebElement CancelButtonTop;

    @FindBy( id="copyButton_0" )
    public WebElement CopyButtonTop;

    @FindBy( id="saveButton_0" )
    public WebElement SaveButtonTop;

    @FindBy( name="procserveaction_deleteProduct_0" )
    public WebElement DeleteButtonTop;

    // Details fields
    @FindBy( id="itemTypeLabel" )
    public WebElement ItemTypeLabel;

    @FindBy( id="product.productType" )
    public WebElement ItemType;

    @FindBy( xpath="//select[@id='product.productType']/option[@value='STANDARD']" )           // needs improvement
    public WebElement ItemTypeStandard;

    @FindBy( xpath="//select[@id='product.productType']/option[@value='DELIVERY']" )           // needs improvement
    public WebElement ItemTypeDelivery;

    @FindBy( xpath="//select[@id='product.productType']/option[@value='PUNCHOUT']" )           // needs improvement
    public WebElement ItemTypePunchout;

    @FindBy( xpath="//select[@id='product.productType']/option[@value='SUPPLIER_CONTRACT']" )           // needs improvement
    public WebElement ItemTypeContract;

    @FindBy( id="deliveryTypeLabel" )
    public WebElement DeliveryTypeLabel;

    @FindBy( id="product.deliveryType" )
    public WebElement DeliveryType;

    @FindBy( xpath="//select[@id='product.deliveryType']/option[@value='ITEM']" )           // needs improvement
    public WebElement DeliveryTypeItem;

    @FindBy( xpath="//select[@id='product.deliveryType']/option[@value='BASKET']" )           // needs improvement
    public WebElement DeliveryTypeBasket;

    @FindBy( id="deliveryBasketAttributeLabel" )
    public WebElement DeliveryBasketAttributeLabel;

    @FindBy( id="product.deliveryBasketAttribute" )
    public WebElement DeliveryBasketAttribute;

    @FindBy( xpath="//select[@id='product.deliveryBasketAttribute']/option[@value='PRICE']" )           // needs improvement
    public WebElement DeliveryBasketAttributePrice;

    @FindBy( id="contractLabel" )
    public WebElement ContractLabel;

    @FindBy( id="contractsSizeLabel" )
    public WebElement ContractChoice;

    @FindBy( id="selectContractButton" )
    public WebElement ContractSelectButton;

    @FindBy( id="div_available_Label" )
    public WebElement AvailabilityLabel;

    @FindBy( id="product.available" )
    public WebElement Availability;

    @FindBy( id="supplierItemIDLabel" )
    public WebElement SupplierItemIDLabel;

    @FindBy( id="product.sku" )
    public WebElement SupplierItemID;


    @FindBy( id="itemTemplateLabel" )
    public WebElement ItemTemplateLabel;

    @FindBy( name="procserveaction_addTemplate" )
    public WebElement AddItemTemplateButton;


    @FindBy( id="itemAttributesLanguageTitle" )
    public WebElement LanguageSpecificLabel;

    @FindBy( id="ui-id-1" )
    public WebElement EnglishLanguageButton;

    @FindBy( id="language-dropdown-tab-top-button" )
    public WebElement AddLanguageButton;


    @FindBy( id="itemAttributesFieldsNameLabel-en" )
    public WebElement NameLabel;

    @FindBy( name="product.draftProductDetails[\\'en\\'].name" )
    public WebElement Name;

    @FindBy( id="itemAttributesFieldsDescriptionLabel-en" )
    public WebElement DescriptionLabel;

    @FindBy( id="itemAttributesFieldsDescriptionInfoIcon-en" )
    public WebElement DescriptionInfoButton;

    @FindBy( name="product.draftProductDetails[\\'en\\'].description" )
    public WebElement Description;

    @FindBy( id="itemAttributesFieldsKeywordsLabel-en" )
    public WebElement KeywordsLabel;

    @FindBy( name="product.draftProductDetails[\\'en\\'].keywords" )
    public WebElement Keywords;


    @FindBy( id="itemAttributesFieldsProductAttributesLabel-en" )
    public WebElement ItemAttributesLabel;

    @FindBy( id="itemAttributesFieldsProductAttributesProductClassLabel-en" )
    public WebElement ItemClassLabel;

    @FindBy( name="product.categoryClassId" )
    public WebElement ItemClass;

    @FindBy( xpath="//select[@name='product.categoryClassId']/option[1]" )           // needs improvement
    public WebElement ItemClassOption1;

    @FindBy( xpath="//select[@name='product.categoryClassId']/option[2]" )           // needs improvement
    public WebElement ItemClassOption2;

    @FindBy( xpath="//select[@name='product.categoryClassId']/option[3]" )           // needs improvement
    public WebElement ItemClassOption3;

    @FindBy( id="itemAttributesFieldsProductAttributesNameLabel-en" )
    public WebElement ItemAttrNameLabel;

    @FindBy( id="itemAttributesFieldsProductAttributesValueLabel-en" )
    public WebElement ItemAttrValueLabel;

    @FindBy( id="categoryAttributeName_1-en" )
    public WebElement EnvFriendlyLabel;

    @FindBy( name="product.categoryAttributes[ENV_FRIENDLY]" )
    public WebElement EnvFriendly;

    @FindBy( xpath="//select[@name='product.categoryAttributes[ENV_FRIENDLY]']/option[1]" )
    public WebElement EnvFriendlyOption1;

    @FindBy( xpath="//select[@name='product.categoryAttributes[ENV_FRIENDLY]']/option[2]" )
    public WebElement EnvFriendlyOption2;

    @FindBy( id="categoryAttributeName_2-en" )
    public WebElement HazardousLabel;

    @FindBy( name="product.categoryAttributes[HAZARDOUS_ITEM]" )
    public WebElement Hazardous;

    @FindBy( xpath="//select[@name='product.categoryAttributes[HAZARDOUS_ITEM]']/option[1]" )
    public WebElement HazardousOption1;

    @FindBy( xpath="//select[@name='product.categoryAttributes[HAZARDOUS_ITEM]']/option[2]" )
    public WebElement HazardousOption2;

    @FindBy( xpath="//select[@name='product.categoryAttributes[HAZARDOUS_ITEM]']/option[3]" )
    public WebElement HazardousOption3;

    @FindBy( id="categoryAttributeName_6-en" )
    public WebElement LegalServiceLabel;

    @FindBy( name="product.categoryAttributes[LEGAL_SERVICE]" )
    public WebElement LegalServiceDropdown;

    @FindBy( id="categoryAttributeName_5-en" )
    public WebElement LegalSeniorityLabel;

    @FindBy( name="product.categoryAttributes[LEGAL_SENIORITY]" )
    public WebElement LegalSeniorityDropdown;

    @FindBy( id="categoryAttributeName_3-en" )
    public WebElement ManufacturerNameLabel;

    @FindBy( name="product.draftProductDetails['en'].categoryAttributeValues[MAN_NAME]" )
    public WebElement ManufacturerName;

    @FindBy( id="categoryAttributeName_4-en" )
    public WebElement ManufacturerItemIDLabel;

    @FindBy( name="product.draftProductDetails['en'].categoryAttributeValues[MAN_PART_ID]" )
    public WebElement ManufacturerItemID;

    @FindBy( id="categoryAttributeName_0-en" )
    public WebElement LeadTimeLabel;

    @FindBy( name="product.draftProductDetails['en'].categoryAttributeValues[DELIVERY_TIME]" )
    public WebElement LeadTime;

    @FindBy( id="categoryAttributeName_8-en" )
    public WebElement GTINLabel;

    @FindBy( name="product.draftProductDetails['en'].categoryAttributeValues[GTIN]" )
    public WebElement GTIN;

    @FindBy( id="itemAttributesFieldsCustomAttributesLabel-en" )
    public WebElement CustomAttributesLabel;

    @FindBy( id="itemAttributesFieldsCustomAttributesNameLabel-en" )
    public WebElement CustomAttrNameLabel;

    @FindBy( id="itemAttributesFieldsCustomAttributesValueLabel-en" )
    public WebElement CustomAttrValueLabel;

    @FindBy( id="addCustomAttribute" )
    public WebElement CustomAttributeAddButton;

    @FindBy( id="customAttributeNameAdded_0")
    public WebElement FirstCustomAttrName;

    @FindBy( id="customAttributeValueAdded_0")
    public WebElement FirstCustomAttrValue;

    @FindBy( id="remove-customAttribute_0" )
    public WebElement FirstCustomAttributeRemoveButton;

    @FindBy( id="customAttributeNameAdded_1")
    public WebElement SecondCustomAttrName;

    @FindBy( id="customAttributeValueAdded_1")
    public WebElement SecondCustomAttrValue;

    @FindBy( id="remove-customAttribute_1" )
    public WebElement SecondCustomAttributeRemoveButton;

    // Comparison section fields
    @FindBy( id="unitOfMeasureLabel" )
    public WebElement ComparisonUOMLabel;

    @FindBy( id="product.unitOfMeasure" )
    public WebElement ComparisonUOM;

    @FindBy( name="unitsOfMeasure_EA" )
    public WebElement ComparisonUOMEach;

    @FindBy( name="unitsOfMeasure_HUR" )
    public WebElement ComparisonUOMHour;

    @FindBy( name="unitsOfMeasure_KGM" )
    public WebElement ComparisonUOMKilogram;

    @FindBy( name="unitsOfMeasure_LTR" )
    public WebElement ComparisonUOMLitre;

    @FindBy( name="unitsOfMeasure_MTR" )
    public WebElement ComparisonUOMMetre;

    @FindBy( name="unitsOfMeasure_ST" )
    public WebElement ComparisonUOMSheet;

    @FindBy( name="unitsOfMeasure_MTK" )
    public WebElement ComparisonUOMSquareMetre;

    @FindBy( id="div_comparisonScale_Label" )
    public WebElement ComparisonScaleLabel;

    @FindBy( id="product.comparisonScale" )
    public WebElement ComparisonScale;

    // Classification section fields
    @FindBy( id="classificationLabel" )
    public WebElement ClassificationTitle;

    @FindBy( id="classificationProvidedLabel" )
    public WebElement ProvidedLabel;

    @FindBy( id="classificationProvidedType" )
    public WebElement ProvidedType;

    @FindBy( id="classificationProvidedVersion" )
    public WebElement ProvidedVersion;

    @FindBy( id="classificationProvidedName" )
    public WebElement ProvidedName;

    @FindBy( id="classificationStandardLabel" )
    public WebElement StandardLabel;

    @FindBy( id="classificationStandardType" )
    public WebElement StandardType;

    @FindBy( id="classificationStandardVersion" )
    public WebElement StandardVersion;

    @FindBy( id="classificationStandardName" )
    public WebElement StandardName;

    @FindBy( name="procserveaction_addCategories" )
    public WebElement ClassificationButton;

    // Price Lists section fields
    @FindBy( id="priceListLinkLabel" )
    public WebElement PriceListsTitle;

    @FindBy( id="priceListLinkNameLabel" )
    public WebElement PriceListsNameLabel;

    @FindBy( id="priceListLinkSpecialLabel" )
    public WebElement PriceListsSpecialLabel;

    @FindBy( id="priceListLinkBasePriceLabel" )
    public WebElement PriceListsBasePriceLabel;

    @FindBy( id="priceListLinkNameDetail_0" )
    public WebElement FirstPriceListNameLink;

    @FindBy( id="iconHasDelivery_0" )
    public WebElement FirstPriceListSpecialIcon;

    @FindBy( id="priceListLinkBasePriceDetail_0" )
    public WebElement FirstPriceListBasePriceLink;

    @FindBy( id="minusBtn_0" )
    public WebElement FirstPriceListRemoveButton;

    // Linked Media section fields
    @FindBy( id="linkedMediaLabel" )
    public WebElement LinkedMediaTitle;

    @FindBy( id="linkedMediaTableTitleLabel" )
    public WebElement LinkedMediaTitleLabel;

    @FindBy( id="linkedMediaTableDisplayDescriptionLabel" )
    public WebElement LinkedMediaDisplayDescLabel;

    @FindBy( id="linkedMediaTableFileNameLabel" )
    public WebElement LinkedMediaFileNameLabel;

    @FindBy( id="linkMediaPDFIcon_0" )
    public WebElement FirstLinkedMediaFileIcon;

    @FindBy( xpath="//td[starts-with(@id,'linkMediaTitle_')]" )
    public List<WebElement> FirstLinkedMediaFileTitles;

    @FindBy( id="linkMediaTitle_0" )
    public WebElement FirstLinkedMediaFileTitle;

    @FindBy( id="linkMediaName_0" )
    public WebElement FirstLinkedMediaFileName;

    @FindBy( name="minusLinkedMediaButton_0" )
    public WebElement FirstLinkedMediaRemoveButton;

//    @FindBy( name="procserveaction_addLinkedMedia" )
    @FindBy( xpath="//a[contains(@href,'LINKED')]" )
    public WebElement AddLinkedMediaButton;

    // External Links section fields
    @FindBy( id="externalLinksLabel" )
    public WebElement ExternalLinksTitle;

    @FindBy( id="externalLinksLabelLabel" )
    public WebElement ExternalLinksLabelLabel;

    @FindBy( id="externalLinksUrlLabel" )
    public WebElement ExternalLinksAddressLabel;

//    @FindBy( name="externalLinkAddButton_" )
    @FindBy(xpath="//legend[normalize-space(text())=\"External Links\"]//..//span[@class=\"glyphicon glyphicon-plus\"]")
    public WebElement ExternalLinkAddButton;

    @FindBy( name="product.externalLinks.label" )
    public List<WebElement> ExternalLinkLabels;

    @FindBy( id="product.externalLinks.url" )
    public List<WebElement> ExternalLinkAddresses;

    @FindBy( xpath="//a[starts-with(@name, 'externalLinkRemoveButton_')]")
    public List<WebElement> ExternalLinkRemoveButtons;


    // Page footer area fields
    @FindBy( id="publishButton_1" )
    public WebElement UpdateMarketplaceButtonBottom;

    @FindBy( id="previewButton_1" )
    public WebElement PreviewButtonBottom;

    @FindBy( id="cancelButton_1" )
    public WebElement CancelButtonBottom;

    @FindBy( id="copyButton_1" )
    public WebElement CopyButtonBottom;

    @FindBy( id="saveButton_1" )
    public WebElement SaveButtonBottom;

    @FindBy( name="procserveaction_deleteProduct_1" )
    public WebElement DeleteButtonBottom;

    // Images area fields
    @FindBy(xpath="//a[normalize-space(text())='Select Image from Media Directory']")
    public WebElement SelectImageFromMediaButton;

    @FindBy( xpath="//div[@id='image-dropzone']/div[1]/div" )
    public WebElement Image0Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[1]/a" )
    public WebElement Image0RemoveButton;

    @FindBy( xpath="//div[@id='image-dropzone']/div[1]/div/img" )
    public WebElement Image0Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[2]/div" )
    public WebElement Image1Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[2]/div/img" )
    public WebElement Image1Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[3]/div" )
    public WebElement Image2Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[3]/div/img" )
    public WebElement Image2Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[4]/div" )
    public WebElement Image3Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[4]/div/img" )
    public WebElement Image3Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[5]/div" )
    public WebElement Image4Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[5]/div/img" )
    public WebElement Image4Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[6]/div" )
    public WebElement Image5Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[6]/div/img" )
    public WebElement Image5Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[7]/div" )
    public WebElement Image6Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[7]/div/img" )
    public WebElement Image6Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[8]/div" )
    public WebElement Image7Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[8]/div/img" )
    public WebElement Image7Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[9]/div" )
    public WebElement Image8Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[9]/div/img" )
    public WebElement Image8Image;

    @FindBy( xpath="//div[@id='image-dropzone']/div[10]/div" )
    public WebElement Image9Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[10]/div/img" )
    public WebElement Image9Image;

    // Images
    @FindBy( name="addImages" )
    public WebElement SelectImageButton;


    // Modal Preview pop-up
    // WARNING! driver.findElement(By.name()) does not work in modal pop-up (chromedriver bug) - use By.id or By.xpath
    @FindBy( id="cancelModalButton" )
    public WebElement ModalClosePreviewIcon;

    @FindBy( id="previewModalTitle" )
    public WebElement ModalTitle;

    @FindBy( name="main_image_0" )
    public WebElement ModalImage;

    @FindBy( id="navigation_prev-navigation" )
    public WebElement ModalCarouselPreviousButton;

    @FindBy( id="navigation_next-navigation" )
    public WebElement ModalCarouselNextButton;

    @FindBy( xpath="//div[starts-with(@name,'navigation_image_')]" )
    public List<WebElement> ModalCarouselItems;

    @FindBy( name="navigation_image_0" )
    public WebElement ModalFirstCarouselItem;

    @FindBy( id="itemNameData" )
    public WebElement ModalItemName;

    @FindBy( id="supplierLabel" )
    public WebElement ModalSupplierLabel;

    @FindBy( id="supplierData" )
    public WebElement ModalSupplier;

    @FindBy( id="itemIdLabel" )
    public WebElement ModalItemIdLabel;

    @FindBy( id="itemIdData" )
    public WebElement ModalItemId;

    @FindBy( id="itemPriceLabel" )
    public WebElement ModalPriceLabel;

    @FindBy( id="itemPriceData" )
    public WebElement ModalPrice;

    @FindBy( id="orderUnitLabel" )
    public WebElement ModalOrderUnitLabel;

    @FindBy( id="orderUnitData" )
    public WebElement ModalOrderUnit;

    @FindBy( id="incrementLabel" )
    public WebElement ModalIncrementLabel;

    @FindBy( id="incrementData" )
    public WebElement ModalIncrement;

    @FindBy( id="priceBreaksLabel" )
    public WebElement PriceBreaksLabel;

    @FindBy( id="priceBreaksData" )
    public WebElement PriceBreaks;

    @FindBy( id="deliveryLabel" )
    public WebElement ModalDeliveryLabel;

    @FindBy( id="deliveryData" )
    public WebElement ModalDelivery;

    @FindBy( id="quantityLabel_0" )
    public WebElement ModalQuantityLabel;

    @FindBy( id="quantity_null" )
    public WebElement ModalQuantity;

    @FindBy( id="updateButton_null" )
    public WebElement ModalAddButton;

    @FindBy( id="minQuantityIncrementLabel_0" )
    public WebElement ModalMinIncrLabel;

    @FindBy( id="minQuantityIncrementData_0" )
    public WebElement ModalMinIncr;

    @FindBy( id="descriptionLabel" )
    public WebElement ModalDescriptionLabel;

    @FindBy( id="descriptionData" )
    public WebElement ModalDescription;

    @FindBy( id="additionalInformationLabelSmallScreen" )
    public WebElement ModalAdditionalInformationTitle;

    @FindBy( id="additionalInformationNameLabel" )
    public WebElement ModalAddInfNameLabel;

    @FindBy( id="additionalInformationValueLabel" )
    public WebElement ModalAddInfValueLabel;

    @FindBy( id="attrName_1_0" )
    public WebElement ModalFirstAddInfName;

    @FindBy( id="attrValue_1_0" )
    public WebElement ModalFirstAddInfValue;

    @FindBy( id="attrName_1_1" )
    public WebElement ModalSecondAddInfName;

    @FindBy( id="attrValue_1_1" )
    public WebElement ModalSecondAddInfValue;

    @FindBy( id="attrName_1_2" )
    public WebElement ModalThirdAddInfName;

    @FindBy( id="attrValue_1_2" )
    public WebElement ModalThirdAddInfValue;

    @FindBy( id="pdf_icon_1" )
    public WebElement ModalFirstLinkedMediaIcon;

    @FindBy( name="linked_media_1" )
    public WebElement ModalFirstLinkedMedia;

    @FindBy( id="large_title" )
    public WebElement ModalExtLinksTitle;

    @FindBy( id="large_warning" )
    public WebElement ModalExtLinksWarning;

    @FindBy( name="large_externalLink_0" )
    public WebElement ModalFirstExtLink;

//   @FindBy( name="closeModalButton" )
    @FindBy( xpath="//div[@id='itemPreviewModal']//div[@class='modal-footer']/a" )
    public WebElement ModalClosePreview;

    @FindBy( id="mediaModalSearch")
    public WebElement SearchButton;

    @FindBy( xpath="//td[starts-with(@id,'linkMediaName_')]" )
    public List<WebElement> FirstLinkedMediaFileNames;


    protected static Logger LOGGER = Logger.getLogger( EditItemPage.class.getName() );

    public EditItemPage()
    {
        PageFactory.initElements( driver, this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/editProduct/index";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Product Manager: Edit Item";
    }

    // Returns true when the element is present and displayed
    public boolean elementIsDisplayed( String elementName )
    {
        try {
            switch (elementName)
            {
                case "FirstExternalLinkLabel": waitUntilDisplayed( ExternalLinkLabels.get(0) ); break;
                case "FirstExternalLinkAddress": waitUntilDisplayed( ExternalLinkAddresses.get(0) ); break;
                case "FirstExternalLinkRemoveButton": waitUntilDisplayed( ExternalLinkRemoveButtons.get(0) ); break;
                case "SecondExternalLinkLabel": waitUntilDisplayed( ExternalLinkLabels.get(1) ); break;
                case "SecondExternalLinkAddress": waitUntilDisplayed( ExternalLinkAddresses.get(1) ); break;
                case "SecondExternalLinkRemoveButton": waitUntilDisplayed( ExternalLinkRemoveButtons.get(1) ); break;
                default: waitUntilDisplayed( getWebElementNamed( elementName) );
            }
            return true;
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }

    // Returns true when the element is not present or not displayed
    public boolean elementIsNotDisplayed( String elementName )
    {
        try {
            switch (elementName)
            {
                case "FirstExternalLinkLabel": return !ExternalLinkLabels.get(0).isDisplayed();
                case "FirstExternalLinkAddress": return !ExternalLinkAddresses.get(0).isDisplayed();
                case "FirstExternalLinkRemoveButton": return !ExternalLinkRemoveButtons.get(0).isDisplayed();
                case "SecondExternalLinkLabel": return !ExternalLinkLabels.get(1).isDisplayed();
                case "SecondExternalLinkAddress": return !ExternalLinkAddresses.get(1).isDisplayed();
                case "SecondExternalLinkRemoveButton": return !ExternalLinkRemoveButtons.get(1).isDisplayed();
                default: return !getWebElementNamed( elementName ).isDisplayed();
            }
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return true;
        }
    }

    public EditItemPage verifyClassification(String classificationType, String value, String service) throws Exception{
        WebElement field=null;
        switch(service){
            case "Standard":
//                field = driver.findElement(By.xpath(String.format("//span[text()='%s']//../following-sibling::div//span[@id='classificationStandardName']",value)));
                field = driver.findElement(By.xpath(String.format("//span[text()='%s']//../following-sibling::div",value)));
                break;
            case "Provided":
                field = driver.findElement(By.xpath(String.format("//span[text()='%s']//../following-sibling::div",value)));
//                field = driver.findElement(By.xpath(String.format("//span[text()='%s']//../following-sibling::div//span[@id='classificationProvidedName']",value)));
                break;
        }
//        WebElement field = driver.findElement(By.xpath(String.format("//span[text()='%s']//../following-sibling::div//span[@id='classificationProvidedName']",value)));

        assertEquals("The classification was not found as expected",classificationType,getTextOfWebElement(field));

        LOGGER.debug("Classification type verified successfully..");
        return new EditItemPage();
    }

    // Returns true when the element is enabled (clickable)
    public boolean elementIsEnabled( String elementName )
    {
        try {
            switch( elementName ) {
                // By default, checks the enabled status of the element with the element name
                // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
//                case "List Name": return getWebElementListNamed( "AnotherName" ).size();
                default: return isWebElementEnabled( getWebElementNamed( elementName) );
            }
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }

    // Returns true when the element has the readonly attribute
    public boolean elementIsReadOnly( String elementName )
    {
        try {
            switch( elementName ) {
                // By default, checks the readonly status of the element with the element name
                // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
//                case "List Name": return getWebElementListNamed( "AnotherName" ).size();
                default: return getAttributeValueOfWebElement( getWebElementNamed( elementName ), "readonly" ).equals( "true" );
            }
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }

    public String getElementValue( String elementName ) throws Exception
    {
        switch( elementName )
        {
            // By default, get the text within the element with the element name
            // So list here any exceptions e.g. where we get the attribute value, the element has another name or is in a List
            case "ItemType": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "Availability": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "SupplierItemID": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "DeliveryType": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "DeliveryBasketAttribute": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "Name": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "Keywords": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "ItemClass": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "EnvFriendly": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "Hazardous": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "ManufacturerName": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "ManufacturerItemID": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "LeadTime": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "GTIN": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "ComparisonUOM": return getSelectedTextOfDropdownWebElement(getWebElementNamed( elementName ));
            case "ComparisonScale": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "FirstCustomAttrName": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "FirstCustomAttrValue": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "SecondCustomAttrName": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "SecondCustomAttrValue": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");
            case "FirstExternalLinkLabel": return getAttributeValueOfWebElement( ExternalLinkLabels.get(0), "value");
            case "FirstExternalLinkAddress": return getAttributeValueOfWebElement( ExternalLinkAddresses.get(0), "value");
            case "SecondExternalLinkLabel": return getAttributeValueOfWebElement( ExternalLinkLabels.get(1), "value");
            case "SecondExternalLinkAddress": return getAttributeValueOfWebElement( ExternalLinkAddresses.get(1), "value");
            case "ModalQuantity": return getAttributeValueOfWebElement(getWebElementNamed( elementName ), "value");

            default: return getTextOfWebElement( getWebElementNamed( elementName ));
        }
    }

    // Clears and sets the text or value of the element
    public void enterValueIntoElement( String value, String elementName ) throws Exception
    {
        switch( elementName )
        {
            case "FirstExternalLinkLabel": setValueOfWebElement( ExternalLinkLabels.get(0), value ); break;
            case "FirstExternalLinkAddress": setValueOfWebElement( ExternalLinkAddresses.get(0), value ); break;
            case "SecondExternalLinkLabel": setValueOfWebElement( ExternalLinkLabels.get(1), value ); break;
            case "SecondExternalLinkAddress": setValueOfWebElement( ExternalLinkAddresses.get(1), value ); break;

            default: setValueOfWebElement( getWebElementNamed( elementName ), value );
        }
    }


    public void selectItemType( String dropdownOption ) throws RuntimeException
    {
        clickWebElement(ItemType);
        switch( dropdownOption.toLowerCase() )
        {
            case "standard item"  : clickWebElement(ItemTypeStandard); break;
            case "delivery item"  : clickWebElement(ItemTypeDelivery); break;
            case "punchout item" : clickWebElement(ItemTypePunchout); break;
            case "contract item" : clickWebElement(ItemTypeContract); break;
            default: throw new RuntimeException("Couldn't find a matching Item type dropdown option");
        }
    }

    public void selectDeliveryType( String dropdownOption ) throws RuntimeException
    {
        clickWebElement(DeliveryType);
        switch( dropdownOption )
        {
            case "Item"  : clickWebElement(DeliveryTypeItem); break;
            case "Basket"  : clickWebElement(DeliveryTypeBasket); break;
            default: throw new RuntimeException("Couldn't find a matching Delivery type dropdown option");
        }
    }

    public void selectDeliveryBasketAttribute( String dropdownOption ) throws RuntimeException
    {
        clickWebElement(DeliveryBasketAttribute);
        switch( dropdownOption )
        {
            case "Price"  : clickWebElement(DeliveryBasketAttributePrice); break;
            default: throw new RuntimeException("Couldn't find a matching Delivery Basket Attribute dropdown option");
        }
    }

    public void selectItemClass(String dropdownOption) throws InterruptedException
    {
        clickWebElement(ItemClass);
        switch( dropdownOption.toLowerCase() )
        {
            case "goods"  : clickWebElement(ItemClassOption1); break;
            case "service"  : clickWebElement(ItemClassOption2); break;
            case "legal service" : clickWebElement(ItemClassOption3); break;
            default: throw new RuntimeException("Couldn't find a matching Item class dropdown option");
        }
    }

    public void selectEnvFriendly(String dropdownOption) throws InterruptedException
    {
        clickWebElement(ItemClass);
        switch( dropdownOption )
        {
            case "N/A"  : clickWebElement(EnvFriendlyOption1); break;
            case "Yes"  : clickWebElement(EnvFriendlyOption2); break;
            default: throw new RuntimeException("Couldn't find a matching Environment friendly dropdown option");
        }
    }

    public void selectHazardous(String dropdownOption) throws InterruptedException
    {
        clickWebElement(ItemClass);
        switch( dropdownOption )
        {
            case "N/A"  : clickWebElement(HazardousOption1); break;
            case "Yes"  : clickWebElement(HazardousOption2); break;
            case "No"  : clickWebElement(HazardousOption3); break;
            default: throw new RuntimeException("Couldn't find a matching Hazardous item dropdown option");
        }
    }

    public void selectComparisonUOM(String dropdownOption) throws InterruptedException
    {
        clickWebElement(ComparisonUOM);
        switch( dropdownOption.toLowerCase() )
        {
            case "each"  : clickWebElement(ComparisonUOMEach); break;
            case "hour"  : clickWebElement(ComparisonUOMHour); break;
            case "kilogram"  : clickWebElement(ComparisonUOMKilogram); break;
            case "litre"  : clickWebElement(ComparisonUOMLitre); break;
            case "metre"  : clickWebElement(ComparisonUOMMetre); break;
            case "sheet"  : clickWebElement(ComparisonUOMSheet); break;
            case "square metre"  : clickWebElement(ComparisonUOMSquareMetre); break;
            default: throw new RuntimeException("Couldn't find a matching selectComparison UOM dropdown option");
        }
    }


    private void clickModalAlertOKButton() throws Exception
    {
        try {
            clickModalAlertButton("accept");
        }
        catch (Exception e) {
            throw new Exception (e.getMessage());
        }
        // For safety, wait until any page refresh occurs before continuing
        waitUntilPageDocumentIsCompleted();
    }

    public ItemDirectoryPage clickCancelButton() throws Exception
    {
        waitUntilDisplayed( CancelButtonTop );
        scrollToElement( CancelButtonTop );  // click sometimes doesn't work if the element is scrolled out of sight
        CancelButtonTop.click();
        clickModalAlertOKButton();
        return new ItemDirectoryPage();
    }

    public EditItemPage clickSaveButton() throws Exception
    {
        waitUntilNoModalPopup();
        waitUntilDisplayed( SaveButtonTop );
        scrollToElement( SaveButtonTop );  // click sometimes doesn't work if the element is scrolled out of sight
        SaveButtonTop.click();
        return new EditItemPage();
    }

    public CreateItemPage clickCopyButton() throws Exception
    {
        waitUntilDisplayed( CopyButtonTop );
        scrollToElement( CopyButtonTop );  // click sometimes doesn't work if the element is scrolled out of sight
        CopyButtonTop.click();
        return new CreateItemPage();
    }

    public EditItemPage clickSelectImageButton() throws Exception
    {
        waitUntilDisplayed( SelectImageFromMediaButton );
        scrollToElement( SelectImageFromMediaButton );  // click sometimes doesn't work if the element is scrolled out of sight
        waitUntillElementIsClickableAndClick(SelectImageFromMediaButton);
        return new EditItemPage();
    }

    public SelectClassificationPage clickClassificationButton() throws Exception
    {
        waitUntilDisplayed( ClassificationButton );
        scrollToElement( ClassificationButton );  // click sometimes doesn't work if the element is scrolled out of sight
        ClassificationButton.click();
        return new SelectClassificationPage();
    }

    public EditItemPage clickAddLinkedMediaButton() throws Exception
    {
        waitUntilDisplayed( AddLinkedMediaButton );
        scrollToElement( AddLinkedMediaButton );  // click sometimes doesn't work if the element is scrolled out of sight
        waitUntillElementIsClickableAndClick(AddLinkedMediaButton);
        return new EditItemPage();
    }

    public ItemDirectoryPage clickDeleteButton() throws Exception
    {
        waitUntilDisplayed( DeleteButtonTop );
        DeleteButtonTop.click();
        clickModalAlertOKButton();
        return new ItemDirectoryPage();
    }

    public ProductManagerPage clickManageTempDataBtns(String btn)
    {
        switch (btn){
            case "ManageTemplateData":
                ManageTemplateData.click();
                break;
            case "ManageTemplate":
                ManageTemplate.click();
                break;
        }
        return new EditItemPage();
    }

    // Clicks the button.  (Use only when not moving to another page.)
    public void clickButton( String buttonName ) throws Exception
    {
        clickWebElement(getWebElementNamed( buttonName ));
        // Proceed with caution
        waitUntilAnyAJAXIsCompleted();
        waitUntilPageDocumentIsCompleted();
    }

    // Use this to click a button or link that causes the same page be re-loaded
    public EditItemPage clickPageReloadingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "Preview": element = PreviewButtonTop; break;
            case "Custom Attribute Add": element = CustomAttributeAddButton; break;
            case "First Custom Attribute Remove": element = FirstCustomAttributeRemoveButton; break;
            case "Second Custom Attribute Remove": element = SecondCustomAttributeRemoveButton; break;
            case "First Remove Linked Media": element = FirstLinkedMediaRemoveButton; break;
            case "External Link Add": element = ExternalLinkAddButton; break;
            case "First External Link Remove": element = ExternalLinkRemoveButtons.get(0); break;
            case "Second External Link Remove": element = ExternalLinkRemoveButtons.get(1); break;
            case "Search": element = SearchButton; break;
            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        return new EditItemPage();
    }


    // removes all External Links and saves
    public void removeAnyExternalLinks() throws Exception
    {
        for(int i=1; i<1000; i++)
        {
            try {
                if (ExternalLinkRemoveButtons.get(0).isDisplayed()){
                    LOGGER.debug( "Edit Item Page ... Removing an External Link" + "\n");
                    ExternalLinkRemoveButtons.get(0).click();
                }
            }
            catch(Exception exception) {break;}    // happens when element is not found in page DOM
        }
        LOGGER.debug( "Edit Item Page ... Clicking HeaderSaveButton" + "\n");
        this.clickButton("HeaderSaveButton");
        LOGGER.debug( "Edit Item Page ... HeaderSaveButton has been clicked" + "\n");
    }

    public void verifyAlertMsg(String msg) throws Exception{
        assertEquals("Alert message was not found!",getTextOfWebElement(AlertMsg),msg);
        LOGGER.debug("Alert message was found on the web page as - "+msg);
    }

    public void clickThumbnail( Integer thumbnailIndex ) throws Exception
    {
        pauseFor(5000);
       waitUntillElementIsClickableAndClick( Thumbnails.get(thumbnailIndex) );
       waitUntilNoModalPopup();
//        waitUntilAnyAJAXIsCompleted();
    }

    public EditItemPage checkElement(String element,String listName) throws Exception{
        List <WebElement> list= new ArrayList<WebElement>();
        switch(listName){
            case "LinkedMediaFiles":
                list = FirstLinkedMediaFileNames;
                break;
            case "Modal FirstLinked Media Files":
                list = ModalFirstLinkedMediaFiles;
                break;
        }

        boolean status = false;
        for (WebElement elem:FirstLinkedMediaFileNames)
        {
            try{
                LOGGER.debug("Comparing values: " +element + " " + elem.getText());
                assertEquals(element,elem.getText());
                status = true;
            }
            catch (AssertionError A){
                continue;
            }

            if (status == false) {
                Assert.fail();
                LOGGER.debug(element + ": Element was not found..");
            }
            else{
                LOGGER.debug(element + ": Element was found successfully..");
            }
        }
        return new EditItemPage();
    }

    public EditItemPage searchItemTemplate(String template) throws  Exception{

        if (template.contains("TemplateName")){
            template = props.get("TemplateName");
        }
        waitUntilDisplayed(directoryInputSearch);
        directoryInputSearch.sendKeys(template);
        directoryButtonSearch.click();
        waitUntilDisplayed(ItemTemplate);
        pauseFor(1000);
        WebElement itemTemplate = driver.findElement(By.xpath(String.format("//div//strong[text()='%s']",template)));
        getTextOfWebElement(itemTemplate);
        Assert.assertEquals("Item Template was not found",template,getTextOfWebElement(itemTemplate));
        return new EditItemPage();
    }

    public EditItemPage addTemplateEditItem(){
        waitUntillElementIsClickableAndClick(AddBtn);
//        clickByXpath("//button[@title='Done']");
        return new EditItemPage();
    }
}
