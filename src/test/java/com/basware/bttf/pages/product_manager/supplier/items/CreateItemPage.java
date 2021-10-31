package com.basware.bttf.pages.product_manager.supplier.items;
// Created by Julian Sheppard on 21/06/2017

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ItemTemplateDirectoryPage;
import com.basware.bttf.util.generator.AbstractFileGenerator;
import com.basware.bttf.util.generator.BMECatGenerator;
import cucumber.util.Encoding;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.basware.bttf.pages.product_manager.supplier.items.SelectMediaPage;
import com.basware.bttf.pages.product_manager.supplier.templates.ItemTemplateDirectoryPage;

import java.util.ArrayList;
import java.util.List;

import static com.basware.bttf.util.generator.AbstractFileGenerator.testDataPath;
import static cucumber.util.Encoding.readFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateItemPage extends ProductManagerPage
{
    String template;
    public String generateSetUpRequest() throws  Exception
    {
      BMECatGenerator bme = new BMECatGenerator();
      template = bme.readFile(testDataPath + "punchout.xml");
      return template;
    }

//    CreateItemPage()
    protected static Logger LOGGER = Logger.getLogger(CreateItemPage.class.getName());

    @FindBy( name="keywords" )
    protected WebElement directoryInputSearch;

    @FindBy(id="mediaModalCancel")
    public WebElement CancelModalWindow;

    @FindBy(xpath = "//b[contains(text(),'UNSPSC')]//..//..//span[@class='glyphicon glyphicon-minus']")
    public WebElement deleteUNPSC;

    @FindBy( className="glyphicon-remove")
    public WebElement directoryButtonClearKeywords;

    @FindBy( xpath="//button[normalize-space(text())='Search']" )
    protected WebElement directoryButtonSearch;

    @FindBy(xpath = "//legend[@id='classificationLabel']//button[@class='btn btn-icon btn-plus dropdown-toggle']")
    public WebElement addClassificationBtnECLASS;

    @FindBy(xpath = "//*[@id='UNSPSCclassificationControl']//*[@title='Manage']")
    public WebElement addClassificationBtnUNPSC;

    @FindBy( xpath="//div[contains(text(),'catfish001.jpg')]" )
    public WebElement CatfishMedia;

    @FindBy( name="backToLink" )
    public WebElement BackToBreadcrumb;

    @FindBy( id="mediaModalSearch")
    public WebElement SearchButton;

    @FindBy(xpath = "//*[@id='classificationModalUNSPSCBody']//following-sibling::div//button")
    public WebElement DoneClassificationBtn;

    @FindBy(xpath = "//*[@id='classificationModalECLASSBody']//following-sibling::div//button")
    public WebElement DoneClassificationBtnEclass;

    @FindBy( id="selectAClassificationTitle" )
    public WebElement PageTitle;

    @FindBy( id="categoryTypeLabel" )
    public WebElement ClassificationTypeLabel;

    @FindBy( xpath="//*[@id='classificationModalUNSPSCBody']//*[@id=\"categoryType\"]" )
    public WebElement ClassificationType;

    @FindBy( xpath="//*[@id='classificationModalECLASSBody']//*[@id=\"categoryType\"]" )
    public WebElement ClassificationTypeEclass;

    @FindBy( id="keywords" )
    public WebElement SearchKeywords;

    @FindBy( id="UNSPSCCodeLabel" )
    public WebElement UNSPSCCodeLabel;

    @FindBy( css=".modal.in .classificationPicker .classificationCode" )
    public WebElement UNSPSCCode;

    // Thumbnails
    @FindBy( xpath="//a[starts-with(@name,'file_')]" )
    public List<WebElement> Thumbnails;

    @FindBy( xpath="//*[@id='classificationModalUNSPSC']//*[@id=\"level1Category\"]" )
    public WebElement Level1;

    @FindBy( xpath="//*[@id='classificationModalECLASSBody']//*[@id=\"level1Category\"]" )
    public WebElement Level1Eclass;

    @FindBy( xpath="//*[@id='classificationModalUNSPSC']//*[@id=\"level2Category\"]")
    public WebElement Level2;

    @FindBy( xpath="//*[@id='classificationModalECLASSBody']//*[@id=\"level2Category\"]")
    public WebElement Level2Eclass;

    @FindBy( xpath="//*[@id='classificationModalUNSPSC']//*[@id=\"level3Category\"]" )
    public WebElement Level3;

    @FindBy( xpath="//*[@id='classificationModalECLASSBody']//*[@id=\"level3Category\"]" )
    public WebElement Level3Eclass;

    @FindBy( xpath="//*[@id='classificationModalUNSPSC']//*[@id=\"level4Category\"]" )
    public WebElement Level4;

    @FindBy( xpath="//*[@id='classificationModalECLASSBody']//*[@id=\"level4Category\"]" )
    public WebElement Level4Eclass;

    @FindBy( id="unspsc_number_feedback" )
    public WebElement ValidationMessage;

    @FindBy( name="cancelButton" )
    public WebElement CancelButton;

    @FindBy( id="saveChanges" )
    public WebElement SaveButton;

    @FindBy(name="product.itemAttributes[7].values")
    public WebElement UnitPrice1Participant;

    @FindBy(name="product.itemAttributes[8].values")
    public WebElement UnitPrice_2_10_Participants;

    @FindBy(name="product.itemAttributes[9].values")
    public WebElement UnitPrice_11_20_Participants;

    @FindBy(name="product.itemAttributes[5].values")
    public WebElement MaxGroupSize;

    @FindBy(name="product.itemAttributes[6].values")
    public WebElement LeadTimeDropDown;

    @FindBy(name="product.shoppingBasketSupplierItemID" )
    public WebElement ShoppingBasketSupItemID;

    @FindBy(id="selectContractButton")
    public WebElement SelectButton;

    @FindBy(name="product.itemAttributes[3].values")
    public WebElement ClaimantEngagement;

    @FindBy(name="product.itemAttributes[4].values")
    public WebElement MinNumClaimants;

    @FindBy(name="//select[@name='product.itemAttributes[3].values']/option[@value='Group / Course / Workshop']")
    public WebElement GroupCourseWorkshop;

    @FindBy(name="//select[@name='product.itemAttributes[4].values']/option[@value='1-10']")
    public WebElement OneToTen;

    @FindBy(xpath="//button[@class='btn btn-primary pull-right use-this-contract']")
    public WebElement Use;

    @FindBy(xpath ="//button[@data-target='div.modal[name=Locations]']")
    public WebElement Edit;

    @FindBy(xpath ="//span[text()='London & Home Counties']//preceding-sibling::input")
    public WebElement LondonAndHome;

    @FindBy(name="product.shoppingBasketDescription" )
    public WebElement ShoppingBasketDesc;

    @FindBy(name="product.shoppingBasketLanguage" )
    public WebElement ShoppingBasketLang;

    @FindBy(name="product.shoppingBasketQuantity" )
    public WebElement ShoppingBasketQuantity;

    @FindBy(name="product.shoppingBasketUnitPrice" )
    public WebElement ShoppingBasketUnitPrice;

    @FindBy(name="product.shoppingBasketCurrencyCode" )
    public WebElement ShoppingBasketCurCode;

    @FindBy(name="product.shoppingBasketUnitOfMeasure" )
    public WebElement ShoppingBasketUOM;

    @FindBy(name="product.shoppingBasketLineTrigger" )
    public WebElement LineTrigger;

    @FindBy(name="product.shoppingBasketSubSupplierDuns" )
    public WebElement ShoppingBasketDUNS;

    @FindBy(name="product.shoppingBasketShippingName" )
    public WebElement ShoppingBasketShippingName;

    @FindBy(name="product.shoppingBasketShippingPrice")
    public WebElement ShoppingBasketShippingPrice;

    @FindBy(name="product.punchoutSetupResponseRedirect" )
    public WebElement SetupResponseRedirect;

    @FindBy(name="product.punchoutSetupResponseSuccess" )
    public WebElement SetupResponseSuccess;

    @FindBy(name="product.punchoutSetupRequest" )
    public WebElement SetupRequestField;

    @FindBy(id="product.punchoutSetupURL" )
    public WebElement SetupUrl;

    @FindBy(css="[id='product.externalPunchOutType'] option")
    public WebElement PunchoutType;

    @FindBy(id="cancelModalButton")
    public WebElement ModalCancelPreview;

    @FindBy(name="backLink")
    public WebElement BackToItems;

//    @FindBy(id="titleCreateItem")
//    public WebElement PageTitle;

    @FindBy(id="previewButton_0" )
    public WebElement PreviewButtonTop;

    @FindBy(id="cancelButton_0" )
    public WebElement CancelButtonTop;

    @FindBy(id="saveButton_0" )
    public WebElement SaveButtonTop;

    // Details fields
    @FindBy( id="itemTypeLabel" )
    public WebElement ItemTypeLabel;

    @FindBy(id="product.productType" )
    public WebElement ItemType;

    @FindBy(xpath="//select[@id='product.productType']/option[@value='STANDARD']" )           // needs improvement
    public WebElement ItemTypeStandard;

    @FindBy(xpath="//select[@id='product.productType']/option[@value='DELIVERY']" )           // needs improvement
    public WebElement ItemTypeDelivery;

    @FindBy(xpath="//select[@id='product.productType']/option[@value='PUNCHOUT']" )           // needs improvement
    public WebElement ItemTypePunchout;

    @FindBy(xpath="//select[@id='product.productType']/option[@value='SUPPLIER_CONTRACT']" )           // needs improvement
    public WebElement ItemTypeContract;

    @FindBy(id="deliveryTypeLabel" )
    public WebElement DeliveryTypeLabel;

    @FindBy(id="product.deliveryType" )
    public WebElement DeliveryType;

    @FindBy(xpath="//select[@id='product.deliveryType']/option[@value='ITEM']" )           // needs improvement
    public WebElement DeliveryTypeItem;

    @FindBy(xpath="//select[@id='product.deliveryType']/option[@value='BASKET']" )           // needs improvement
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

    @FindBy( id="div_supplierItemID_Label" )
    public WebElement SupplierItemIDLabel;

    @FindBy( id="product.sku" )
    public WebElement SupplierItemID;

    @FindBy( id="itemTemplateLabel" )
    public WebElement ItemTemplateLabel;

    @FindBy( name="procserveaction_addTemplate" )
    public WebElement AddItemTemplateButton;

    // Language Specific
    @FindBy( id="itemAttributesLanguageTitle" )
    public WebElement LanguageSpecificTitle;

    @FindBy( id="translation-en-tab-top" )
    public WebElement EnglishLanguageTab;

    @FindBy( id="language-dropdown-tab-top" )
    public WebElement AddLanguageTab;

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

    @FindBy( xpath="//select[@name='product.categoryAttributes[ENV_FRIENDLY]']/option[1]" )          // needs improvement
    public WebElement EnvFriendlyOption1;

    @FindBy( xpath="//select[@name='product.categoryAttributes[ENV_FRIENDLY]']/option[2]" )          // needs improvement
    public WebElement EnvFriendlyOption2;

    @FindBy( id="categoryAttributeName_2-en" )
    public WebElement HazardousLabel;

    @FindBy( name="product.categoryAttributes[HAZARDOUS_ITEM]" )
    public WebElement Hazardous;

    @FindBy( xpath="//select[@name='product.categoryAttributes[HAZARDOUS_ITEM]']/option[1]" )          // needs improvement
    public WebElement HazardousOption1;

    @FindBy( xpath="//select[@name='product.categoryAttributes[HAZARDOUS_ITEM]']/option[2]" )          // needs improvement
    public WebElement HazardousOption2;

    @FindBy( xpath="//select[@name='product.categoryAttributes[HAZARDOUS_ITEM]']/option[3]" )          // needs improvement
    public WebElement HazardousOption3;

    @FindBy( id="categoryAttributeName_6-en" )
    public WebElement LegalServiceLabel;

    @FindBy( name="product.categoryAttributes[LEGAL_SERVICE]" )
    public WebElement LegalService;

    @FindBy( id="categoryAttributeName_5-en" )
    public WebElement LegalSeniorityLabel;

    @FindBy( name="product.categoryAttributes[LEGAL_SENIORITY]" )
    public WebElement LegalSeniority;

    @FindBy( id="categoryAttributeName_3-en" )
    public WebElement ManufacturerNameLabel;

    @FindBy( name="product.draftProductDetails[\\'en\\'].categoryAttributeValues[MAN_NAME]" )
    public WebElement ManufacturerName;

    @FindBy( id="categoryAttributeName_4-en" )
    public WebElement ManufacturerItemIDLabel;

    @FindBy( name="product.draftProductDetails[\\'en\\'].categoryAttributeValues[MAN_PART_ID]" )
    public WebElement ManufacturerItemID;

    @FindBy( id="categoryAttributeName_0-en" )
    public WebElement LeadTimeLabel;

    @FindBy( name="product.draftProductDetails[\\'en\\'].categoryAttributeValues[DELIVERY_TIME]" )
    public WebElement LeadTime;

    @FindBy( id="categoryAttributeName_8-en" )
    public WebElement GTINLabel;

    @FindBy( name="product.draftProductDetails[\\'en\\'].categoryAttributeValues[GTIN]" )
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

    @FindBy( id="noClassificationProvided" )
    public WebElement NoClassificationProvided;

    @FindBy( id="classificationProvidedType" )
    public WebElement ProvidedType;

    @FindBy( id="classificationProvidedVersion" )
    public WebElement ProvidedVersion;

    @FindBy( id="classificationProvidedName" )
    public WebElement ProvidedName;

    @FindBy( id="classificationStandardLabel" )
    public WebElement StandardLabel;

    @FindBy( id="noClassificationStandard" )
    public WebElement NoClassificationStandard;

    @FindBy( id="classificationStandardType" )
    public WebElement StandardType;

    @FindBy( id="classificationStandardVersion" )
    public WebElement StandardVersion;

    @FindBy( id="classificationStandardName" )
    public WebElement StandardName;

    @FindBy( xpath="//*[@id='UNSPSCclassificationControl']//*[@title='Manage']" )
    public WebElement ClassificationButton;

    @FindBy( xpath="//span[@id='ECLASSclassificationControl']//*[@name=\"procserveaction_addCategories\"]" )
    public WebElement ClassificationButtonEclass;

    // Linked Media
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

    @FindBy( xpath="//td[starts-with(@id,'linkMediaName_')]" )
    public List<WebElement> FirstLinkedMediaFileNames;


    @FindBy( xpath="//img[starts-with(@name,'main_image_')]" )
    private List<WebElement> ItemImages;

    @FindBy( id="linkMediaTitle_0" )
    public WebElement FirstLinkedMediaFileTitle;

    @FindBy( id="linkMediaName_0" )
    public WebElement FirstLinkedMediaFileName;

    @FindBy( id="linkMediaName_1" )
    public WebElement SecondLinkedMediaFileName;

    @FindBy( id="linkMediaName_2" )
    public WebElement ThirdLinkedMediaFileName;

    @FindBy( id="linkMediaName_3" )
    public WebElement FourthLinkedMediaFileName;

    @FindBy( id="linkMediaName_4" )
    public WebElement FifthLinkedMediaFileName;

    @FindBy( name="minusLinkedMediaButton_0" )
    public WebElement FirstLinkedMediaRemoveButton;

    @FindBy( xpath="//a[contains(@href,'LINKED')]" )
    public WebElement AddLinkedMediaButton;

    @FindBy( id="mediaModalLabel" )
    public WebElement PDFPageTitle;

    // External Links section fields
    @FindBy( id="externalLinksLabel" )
    public WebElement ExternalLinksTitle;

    @FindBy( id="externalLinksLabelLabel" )
    public WebElement ExternalLinksLabelLabel;

    @FindBy( id="externalLinksUrlLabel" )
    public WebElement ExternalLinksAddressLabel;

    @FindBy(xpath="//legend[normalize-space(text())=\"External Links\"]//..//span[@class=\"glyphicon glyphicon-plus\"]")
    public WebElement ExternalLinkAddButton;

    @FindBy( name="product.externalLinks.label" )
    private List<WebElement> ExternalLinkLabels;

    @FindBy( id="product.externalLinks.url" )
    private List<WebElement> ExternalLinkAddresses;

    @FindBy( xpath="//a[starts-with(@name, 'externalLinkRemoveButton_')]")
    private List<WebElement> ExternalLinkRemoveButtons;

    // Page footer area fields
    @FindBy( id="previewButton_1" )
    public WebElement PreviewButtonBottom;

    @FindBy( id="cancelButton_1" )
    public WebElement CancelButtonBottom;

    @FindBy( id="saveButton_1" )
    public WebElement SaveButtonBottom;

    // Images area fields
//    @FindBy( name="addImages")
    @FindBy(xpath = "//a[normalize-space(text())='Select Image from Media Directory']")
    public WebElement SelectImageFromMediaButton;

    @FindBy( xpath="//div[@id='image_0']/div/form/div" )
    public WebElement Image0Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[1]/a" )
    public WebElement Image0RemoveButton;

    @FindBy( xpath="//div[@id='image-dropzone']/div[1]/div/img" )
    public WebElement Image0Image;

    @FindBy( xpath="//div[@id='image_1']/div/form/div" )
    public WebElement Image1Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[2]/a" )
    public WebElement Image1RemoveButton;

    @FindBy( xpath="//div[@id='image-dropzone']/div[2]/div/img" )
    public WebElement Image1Image;

    @FindBy( xpath="//div[@id='image_2']/div/form/div" )
    public WebElement Image2Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[3]/div/img" )
    public WebElement Image2Image;

    @FindBy( xpath="//div[@id='image_3']/div/form/div" )
    public WebElement Image3Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[4]/div/img" )
    public WebElement Image3Image;

    @FindBy( xpath="//div[@id='image_4']/div/form/div" )
    public WebElement Image4Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[5]/div/img" )
    public WebElement Image4Image;

    @FindBy( xpath="//div[@id='image_5']/div/form/div" )
    public WebElement Image5Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[6]/div/img" )
    public WebElement Image5Image;

    @FindBy( xpath="//div[@id='image_6']/div/form/div" )
    public WebElement Image6Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[7]/div/img" )
    public WebElement Image6Image;

    @FindBy( xpath="//div[@id='image_7']/div/form/div" )
    public WebElement Image7Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[8]/div/img" )
    public WebElement Image7Image;

    @FindBy( xpath="//div[@id='image_8']/div/form/div" )
    public WebElement Image8Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[9]/div/img" )
    public WebElement Image8Image;

    @FindBy( xpath="//div[@id='image_9']/div/form/div" )
    public WebElement Image9Dropzone;

    @FindBy( xpath="//div[@id='image-dropzone']/div[10]/div/img" )
    public WebElement Image9Image;

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
    private List<WebElement> ModalCarouselItems;

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

    @FindBy( id="pdf_icon_10" )
    public WebElement ModalFirstLinkedMediaIcon;

    @FindBy( name="linked_media_10" )
    public WebElement ModalFirstLinkedMedia;

    @FindBy( xpath="//a[starts-with(@name,'linked_media_')]")
    public List<WebElement> ModalFirstLinkedMediaFiles;

    @FindBy( id="large_title" )
    public WebElement ModalExtLinksTitle;

    @FindBy( id="large_warning" )
    public WebElement ModalExtLinksWarning;

    @FindBy( name="large_externalLink_0" )
    public WebElement ModalFirstExtLink;

    @FindBy(xpath = "//a[contains(text(),'eCl@ss')]")
    public WebElement eclassLink;

    //    @FindBy( name="closeModalButton" )
    @FindBy( xpath="//div[@id='itemPreviewModal']//div[@class='modal-footer']/a" )
    public WebElement ModalClosePreview;

    @FindBy( xpath="//div[@id='div_supplierItemID']//p" )
    public WebElement SupplierElemIDField;

    @FindBy( xpath="//div[@id='control_group_draftProductDetails[en].name']//p" )
    public WebElement NameField;

    @FindBy( xpath="//textarea[@name=\"product.draftProductDetails['en'].description\"]//..//p" )
    public WebElement DescriptionField;

    @FindBy( xpath="//div[@id='div_comparisonScale']//p" )
    public WebElement ComparisonScaleField;

    @FindBy( xpath="//img[starts-with(@name,'main_image_')]")
    public List<WebElement> Images;

    @FindBy(xpath = "//*[@id='control_group_draftProductDetails[en].description']/div/div/p")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id='punchoutAttVariables']//tbody//input[@id='punchoutAttVariablesDesc']")
    public List<WebElement> substitutions;

    public CreateItemPage()
    {
        PageFactory.initElements(driver,this) ;
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/addProduct/index";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Create Item";
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
                // temporary code
                case "ModalClosePreview":
                    List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@id='itemPreviewModal']//div[@class='modal-footer']/a"));

                    LOGGER.debug( "@id='itemPreviewModal//@class='modal-footer/a' size: " + String.valueOf( listOfElements.size()));
                    LOGGER.debug( "@id='itemPreviewModal//@class='modal-footer/a' get(0).isDisplayed: " + String.valueOf( listOfElements.get(0).isDisplayed()));
                    LOGGER.debug( "@id='itemPreviewModal//@class='modal-footer/a' get(0).isEnabled: " + String.valueOf( listOfElements.get(0).isEnabled()));
                case "ModalCancelPreview":
                    waitUntilDisplayed(ModalCancelPreview);
                    break;
                    default: waitUntilDisplayed(getWebElementNamed(elementName));
            }
            return true;
        }
        catch (Exception exception) {    // happens when element not found in DOM or not in the expected state
            return false;
        }
    }

    public CreateItemPage searchItemTemplate(String template) throws  Exception{

        if (template.contains("TemplateName")){
            template = props.get("TemplateName");
        }
        waitUntilDisplayed(directoryInputSearch);
        directoryInputSearch.sendKeys(template);
        directoryButtonSearch.click();
        pauseFor(2000);
        WebElement itemTemplate = driver.findElement(By.xpath(String.format("//div//strong[text()='%s']",template)));
        getTextOfWebElement(itemTemplate);
        Assert.assertEquals("Item Template was not found",template,getTextOfWebElement(itemTemplate));
        return new CreateItemPage();
    }

    public CreateItemPage deleteUNPSCClassification(){

        waitUntillElementIsClickableAndClick(deleteUNPSC);
        return new CreateItemPage();
    }

    public CreateItemPage addTemplate(){
        clickAddBtn("//div[@data-template-name='CatfishItemTemplate']//span");
//        clickByXpath("//button[@title='Done']");
//        pauseFor(5000);
        return new CreateItemPage();
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

    // Returns the displayed text or value of the element
    public String getElementValue(String elementName) throws Exception
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
            case "UNSPSCCode":return getAttributeValueOfWebElement(getWebElementNamed(elementName),"value");
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
            case "Maximum group size":setValueOfWebElement(MaxGroupSize,value);
            break;
            case "Unit price for 1 participant":
                setValueOfWebElement(UnitPrice1Participant,value);
                break;
            case "ATT_SHARED_SECRET":
                setValueOfWebElement(substitutions.get(0),value);break;
            case "ATT_SUPPLIER_ID":
                setValueOfWebElement(substitutions.get(1),value);break;
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

    public void selectClaimantEngagement(String dropdownOption) throws Exception
    {


        clickWebElement(ClaimantEngagement);
        switch( dropdownOption )
        {
            case "Group / Course / Workshop":
                selectDropdownOptionByText(ClaimantEngagement,dropdownOption);;
            break;
            default: throw new RuntimeException("Couldn't find a matching Delivery type dropdown option");
        }

    }

    public void addClassificationTypeEclass(){
        waitUntillElementIsClickableAndClick(addClassificationBtnECLASS);
        waitUntillElementIsClickableAndClick(eclassLink);
    }

    public void addClassificationType(){
        waitUntillElementIsClickableAndClick(addClassificationBtnUNPSC);
//        waitUntillElementIsClickableAndClick(eclassLink);
    }

    public void selectMinNumClaimants(String dropdownOption) throws Exception
    {

        switch (dropdownOption)
        {
            case "1-10":
                selectDropdownOptionByText(MinNumClaimants,dropdownOption);
                break;
        }
    }

    public void selectLeadTime(String dropdownOption) throws Exception
    {

        switch (dropdownOption)
        {
            case "Up to 14 days":
                selectDropdownOptionByText(LeadTimeDropDown,dropdownOption);
                break;
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
        switch( dropdownOption.toLowerCase())
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
        waitUntilDisplayed( SaveButtonTop );
        scrollToElement( SaveButtonTop );  // click sometimes doesn't work if the element is scrolled out of sight
        waitUntillElementIsClickableAndClick(SaveButtonTop);
//        SaveButtonTop.click();
        pauseFor(2000);
        return new EditItemPage();
    }

    public CreateItemPage clickSelect() throws Exception
    {
        waitUntilDisplayed(SelectButton);
        SelectButton.click();
        return new CreateItemPage();
    }

    public CreateItemPage clickSave() throws Exception
    {
        waitUntilDisplayed( SaveButtonBottom );
        scrollToElement( SaveButtonBottom );  // click sometimes doesn't work if the element is scrolled out of sight
        SaveButtonBottom.click();
        return new CreateItemPage();
    }

    public CreateItemPage clickSaveToVerify() throws Exception
    {
        waitUntilDisplayed( SaveButtonTop );
        scrollToElement( SaveButtonTop );  // click sometimes doesn't work if the element is scrolled out of sight
        SaveButtonTop.click();
        return new CreateItemPage();
    }


    public CreateItemPage clickSelectImageButton() throws Exception
    {
        waitUntilDisplayed( SelectImageFromMediaButton );
        scrollToElement( SelectImageFromMediaButton );  // click sometimes doesn't work if the element is scrolled out of sight
        SelectImageFromMediaButton.click();
        return new CreateItemPage();
    }

    public CreateItemPage clickClassificationButton() throws Exception
    {
        waitUntilDisplayed( ClassificationButton );
        scrollToElement( ClassificationButton );  // click sometimes doesn't work if the element is scrolled out of sight
//        ClassificationButton.click();
        waitUntillElementIsClickableAndClick(ClassificationButton);
        return new CreateItemPage();
    }

    public CreateItemPage clickClassificationButtonEclass() throws Exception
    {
        waitUntilDisplayed( ClassificationButtonEclass );
        scrollToElement( ClassificationButtonEclass );  // click sometimes doesn't work if the element is scrolled out of sight
//        ClassificationButton.click();
        waitUntillElementIsClickableAndClick(ClassificationButtonEclass);
        return new CreateItemPage();
    }

    public CreateItemPage clickAddLinkedMediaButton() throws Exception
    {
        waitUntilDisplayed( AddLinkedMediaButton );
        scrollToElement( AddLinkedMediaButton );  // click sometimes doesn't work if the element is scrolled out of sight
        AddLinkedMediaButton.click();
        return new CreateItemPage();
    }

    // Clicks the button.  (Use only when not moving to another page.)
    public CreateItemPage clickButton( String buttonName ) throws Exception
    {
        clickWebElement(getWebElementNamed( buttonName ));
        // Proceed with caution
        waitUntilAnyAJAXIsCompleted();
        waitUntilPageDocumentIsCompleted();
        return new CreateItemPage();
    }

    // Use this to click a button or link that causes the same page be re-loaded
    public CreateItemPage clickPageReloadingElement( String elementName ) throws Exception
    {
        WebElement element;
        switch( elementName )
        {
            // buttons:
            case "Preview": element = PreviewButtonTop; break;
            case "Search": element = SearchButton; break;
            case "Custom Attribute Add": element = CustomAttributeAddButton; break;
            case "First Custom Attribute Remove": element = FirstCustomAttributeRemoveButton; break;
            case "Second Custom Attribute Remove": element = SecondCustomAttributeRemoveButton; break;
            case "First Remove Linked Media": element = FirstLinkedMediaRemoveButton; break;
            case "External Link Add": element = ExternalLinkAddButton; break;
            case "First External Link Remove": element = ExternalLinkRemoveButtons.get(0); break;
            case "Second External Link Remove": element = ExternalLinkRemoveButtons.get(1); break;
            case "ModalClosePreviewIcon": element = ModalClosePreviewIcon;
                LOGGER.debug( "getTagName[" + element.getTagName() + "]\n" );
                LOGGER.debug( "id[" + element.getAttribute("id") + "]\n" );
                LOGGER.debug( "class[" + element.getAttribute("class") + "]\n" );
                LOGGER.debug( "getText[" + element.getText() + "]\n" );
                LOGGER.debug( "isDisplayed[" + element.isDisplayed() + "]\n" );
                LOGGER.debug( "isEnabled[" + element.isEnabled() + "]\n" );
                break;
            case "ModalClosePreview": element = ModalClosePreview; break;
            case "ModalCancelPreview": element = ModalCancelPreview;
            break;
            case "CancelModalWindow": element = CancelModalWindow;
            break;

            default: throw new RuntimeException("No case statement matching: " + elementName);
        }
        clickWebElement( element );
        return new CreateItemPage();
    }

    public CreateItemPage verifyFields(String fieldValue) throws Exception{
        String fieldValidation="";

        switch(fieldValue){

            case "Supplier item ID":
                fieldValidation = getTextOfWebElement(SupplierElemIDField);
                break;
            case "Name":
                fieldValidation = getTextOfWebElement(NameField);
                break;
            case "Description":
                fieldValidation = getTextOfWebElement(DescriptionField);
                break;
            case "Comparison Scale":
                fieldValidation = getTextOfWebElement(ComparisonScaleField);
                break;
        }

        assertEquals("The validation message could not be verified","Enter value",fieldValidation);
        LOGGER.debug(fieldValue+" was found to be mandatory field");
        return new CreateItemPage();
    }

    public CreateItemPage addItemTemplate() throws Exception{
        clickAddBtn("//button[contains(@href,'itemTemplate')]//span");
        return new CreateItemPage();
    }

    public CreateItemPage verifyClassification(String classificationType, String value, String service) throws Exception{
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
        return new CreateItemPage();
    }

    public void verifyImage( Integer imageIndex ) throws Exception
    {

        Images.get(imageIndex).isDisplayed();
        LOGGER.debug("Image verified"+imageIndex);
        // This page uses AJAX to refresh
        waitUntilAnyAJAXIsCompleted();
    }

    public CreateItemPage clickArrow(String direction){
        switch (direction){
            case "Forward":
                clickByXpath("//i[@class=\"fa fa-chevron-right fa-2x\"]");
                break;
        }
        return new CreateItemPage();
    }

    public CreateItemPage checkElement(String element,String listName) throws Exception{
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
        return new CreateItemPage();
      }

      public CreateItemPage selectContract(String value){
        WebElement elem= null;
        pauseFor(2000);
        switch (value){
            case "Contract for catfish":
                value = props.get("Cname");
                elem = driver.findElement(By.xpath(String.format("//div[@class='col-sm-9 contract-name'][text()='%s']//..//..//..//button",value)));
                break;
            case "4.1: Literacy / numeracy / ESOL":
                elem = driver.findElement(By.xpath(String.format("//option[@value='%s']",value)));
                break;
            case "People aged 18-24":
                elem = driver.findElement(By.xpath(String.format("//option[@value='%s']",value)));
                break;
            case "Catfish contract":
                elem = driver.findElement(By.xpath("//div[@class='col-sm-9 contract-name'][text()='Contract for catfish']//..//..//..//button"));
                break;
        }
        elem.click();
        LOGGER.debug("Clicked on " +value);
        return new CreateItemPage();
      }

      public CreateItemPage clickCheckBox(String checkbox) throws Exception{
//        pauseFor(5000);
          waitUntillElementIsClickableAndClick(LondonAndHome);
//        LondonAndHome.click();
        assertTrue("The check box was not checked",LondonAndHome.isSelected());
        return new CreateItemPage();
    }


    public void verifyErrorMessage()
    {
        assertEquals(errorMessage.getText(),"Use plain text only");
    }

    public CreateItemPage selectLevelDropdownOptionByText( String levelDropdownName, String dropdownOptionText ) throws Exception
    {
        selectDropdownOptionByText( getWebElementNamed( levelDropdownName ), dropdownOptionText );
        waitUntilAnyAJAXIsCompleted();
        return new CreateItemPage();
    }

    public void clickThumbnail( Integer thumbnailIndex ) throws Exception
    {
        pauseFor(3000);
//        waitUntilDisplayed(Thumbnails.get(thumbnailIndex));
        waitUntillElementIsClickableAndClick( Thumbnails.get(thumbnailIndex) );
        // This page uses AJAX to refresh
        waitUntilNoModalPopup();
        waitUntilAnyAJAXIsCompleted();

    }
    public void delete_elem(String elem) throws Exception {
        pauseFor(5000);
        int i = substitutions.size();
        while(i>1) {
            substitutions.get(i-2).click();
            i = i - 1;
        }
    }

    public CreateItemPage savePunchOutItem(){
        waitUntillElementIsClickableAndClick(SaveButtonTop);
        return new CreateItemPage();
    }
}
