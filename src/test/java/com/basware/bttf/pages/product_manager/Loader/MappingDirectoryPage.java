package com.basware.bttf.pages.product_manager.Loader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.basware.bttf.util.TestConstants.MAPPING_NAME;

public class MappingDirectoryPage extends TwoStageLoaderDashboardPage {

    @FindBy(name = "create-mapping-button")
    private WebElement createMappingButton;

    @FindBy(id="app-dialog-confirm")
    private WebElement confirmDeletion;

    public MappingDirectoryPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/ui/products/loader/mappings";
    }

    @Override
    public String getExpectedTitle() {
        return "Content Loader: Mapping Directory";
    }

    @FindBy(xpath = "//*[contains(@id,'delete-organization-mapping')]")
    public WebElement mappings;

    public MapperPage clickOnCreateMappingButton()
    {
        pauseFor(2000);
        if(driver.findElements(By.xpath("//*[contains(@id,'delete-organization-mapping')]")).size()!=0) {
            mappings.click();
            confirmDeletion.click();
        }
        clickWebElement(createMappingButton);
        return new MapperPage();
    }

    String newMappingName = props.get(MAPPING_NAME);

    public LoaderUploadPage clickOnUploadButton()
    {
        pauseFor(2000);
        WebElement uploadButton1 = driver.findElement(By.xpath("//*[@id=\"upload-organization-mapping-"+newMappingName+"\"]"));
        uploadButton1.click();
        return new LoaderUploadPage();
    }

    public void deleteCustomMapping()
    {
        pauseFor(2000);
        WebElement deleteCustomMapping = driver.findElement(By.xpath("//*[@id=\"delete-organization-mapping-"+newMappingName+"\"]"));
        waitUntilDisplayed(deleteCustomMapping);
        deleteCustomMapping.click();
        confirmDeletion.click();
    }


}
