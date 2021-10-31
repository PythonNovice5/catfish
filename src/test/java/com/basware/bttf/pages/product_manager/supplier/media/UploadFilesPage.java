package com.basware.bttf.pages.product_manager.supplier.media;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.content_upload.ContentUploadPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.basware.bttf.pages.product_manager.supplier.content_upload.ContentUploadPage;

import javax.swing.text.AbstractDocument;
import java.io.File;

public class UploadFilesPage extends ProductManagerPage
{
    protected static Logger LOGGER = Logger.getLogger( UploadFilesPage.class.getName() );

    public UploadFilesPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/media/upload";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Upload Media";
    }

    @FindBy( xpath="//input[@name='files[]']" )
    public WebElement AddFiles;

    public UploadFilesPage addFiles(String fileName) throws  Exception{
        File file = new File(getFilePath() + "/.." + "/" + fileName);
        LOGGER.debug("Path to be used 2  ----" + file.getCanonicalPath());
        AddFiles.sendKeys(file.getCanonicalPath());
        return new UploadFilesPage();
    }

    public UploadFilesPage checkFileStatus(String fileName,String statusVal){
        WebElement checkStatus;
        pauseFor(3000);
        checkStatus = driver.findElement(By.xpath(String.format(("//td[normalize-space(text())='%s']//..//..//span[text()='%s']"),fileName,statusVal)));
        Assert.assertNotNull("Could not find the expected file status",checkStatus);
        LOGGER.debug("The Status of file Upload is found to be COMPLETED ..");
        return new UploadFilesPage();
    }
}
