package com.basware.bttf.pages.product_manager.Loader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class LoaderUploadPage extends TwoStageLoaderDashboardPage {

   @FindBy(id = "mapping-select")
   public WebElement mappingDropDown;

   @FindBy(name="file-select-input")
   public WebElement chooseFile;

   @FindBy(id= "output-select")
   public WebElement outPutDropDown;

   @FindBy(id = "upload-file-button")
   public WebElement uploadButton;


   @FindBy(id = "language")
   public WebElement languageDropDown;

   @FindBy(id= "classification")
   public WebElement unspscDropdown;

   @FindBy(id= "currency")
   public WebElement currencyDropDown;

    public LoaderUploadPage()
    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/ui/products/loader/upload-file";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Content Loader: Upload File";
    }
    
    public void selectMapping(String mappingOption)
    {
        mappingDropDown.click();
        pauseFor(2000);
        driver.findElement(By.xpath("//*[@id='"+mappingOption+"']")).click();
    }

    public void enterFileToUpload(String fileType, String fileName) throws Exception {

        pauseFor(2000);
        if (fileType.contentEquals("modifiedxlsx"))
            chooseFile.sendKeys(getTestDataPath()+fileName);
        else
        chooseFile.sendKeys(getFilePath() + fileName);
    }

    public String getTestDataPath(){
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\generator\\test_data\\");
    }

    public String getFilePath() {
        return (new File("").getAbsolutePath() + "\\src\\test\\resources\\testdata\\temp\\");
    }


    //Angular is keep adding/removing spaces for drop down options, so this is the work around
    public int getDropDownIndex (String outputTypeOption)
    {
        int index = 0;
        switch (outputTypeOption) {
            case " Products and Price List ":
                index = 1;
                return index;
        }
      return index;
    }

    public void selectUploadOptions(String field, String value) {
        switch (field) {
            case "Output type":
                selectDropdownOption(outPutDropDown, value);
                break;
            case "Language":
                selectDropdownOption(languageDropDown, value);
                break;
            case "UNSPSC Version":
                selectDropdownOption(unspscDropdown,value);
                break;
            case "Currency":
                selectDropdownOption(currencyDropDown,value);
                break;
        }
    }

    public LoaderStatusPage clickOnUploadButton()
    {
        waitUntillElementIsClickableAndClick(uploadButton);
        pauseFor(15000);
        return new LoaderStatusPage();
    }
}
