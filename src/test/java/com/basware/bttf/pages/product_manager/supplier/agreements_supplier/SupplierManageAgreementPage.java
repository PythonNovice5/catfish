package com.basware.bttf.pages.product_manager.supplier.agreements_supplier;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import com.basware.bttf.pages.product_manager.supplier.price_lists.AttachPricelistToAgreementPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierManageAgreementPage extends ProductManagerPage {

    @FindBy(linkText = "Add")
    private WebElement addPriceListButton;

    @FindBy(linkText = "Publish")
    private WebElement publishAgreementToBuyer;

    @FindBy(linkText =  "View")
    private  WebElement viewAgreementHistory;

    @FindBy ( linkText = "Back to Agreement Directory")
    public WebElement backToAgreementDirectory;


    {
        PageFactory.initElements(driver,this);
    }

    @Override
    public String getExpectedUrl() {
        return getBaseUrl()+"/products/publishAgreement/index";
    }

    @Override
    public String getExpectedTitle() {
        return "Product Manager: Agreement Details";
    }

    public ProductManagerPage clickButtonInSupplierAgreementPage(String button)
    {
        ProductManagerPage page = null;
        switch (button) {
            case "add":
                addPriceListButton.click();
                page = new AttachPricelistToAgreementPage();
                break;
            case "publish":
                publishAgreementToBuyer.click();
                page =  new PublishAgreementsPage();
                break;
            case "view":
                viewAgreementHistory.click();
        }
        return page;
    }

    public PublishAgreementsPage clickLinkBackToAgreementDirectory()
    {
        backToAgreementDirectory.click();
        return new PublishAgreementsPage();
    }

}
