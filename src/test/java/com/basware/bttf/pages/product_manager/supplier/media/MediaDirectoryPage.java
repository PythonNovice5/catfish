package com.basware.bttf.pages.product_manager.supplier.media;
import com.basware.bttf.pages.product_manager.ProductManagerDirectoryPage;
import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MediaDirectoryPage extends ProductManagerDirectoryPage<MediaDirectoryPage>
{
    protected static Logger LOGGER = Logger.getLogger( MediaDirectoryPage.class.getName() );

    public MediaDirectoryPage()
    {
        PageFactory.initElements( driver, this );
    }

    public String getExpectedUrl()
    {
        //return getBaseUrl() + "/products/media/index/manageMedia";
        return getBaseUrl() + "/products/media";
    }

    public String getExpectedTitle()
    {
        return "Product Manager: Media";
    }

    @Override
    protected void initSortByItems()
    {

    }

    @Override
    protected void initFilterItems()
    {

    }

    @FindBy(name="btn-upload-files")
    public WebElement UploadFilesBtn;

    public ProductManagerPage clickMediaDirectoryButtons(String btnValue) throws Exception{

        switch(btnValue){
            case "Upload files":
                btnValue = "UploadFilesBtn";
                getWebElementNamed(btnValue).click();
                return new UploadFilesPage();
        }
        return null;
    }


    public void searchImage(String Image)
    {
        searchBox.sendKeys(Image);
        searchBtn.click();
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("aws-media"));
    }
}
