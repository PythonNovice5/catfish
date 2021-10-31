package com.basware.bttf.pages.shopping.freetextrequisitions;

import com.basware.bttf.pages.shopping.ShoppingPage;
import com.basware.bttf.pages.shopping.catalogue_shopping.InvoiceDetailsPage;
import com.basware.bttf.util.generator.BMECatGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FTREditPage extends ShoppingPage
{
    @FindBy(id="description")
    private WebElement ftrReference;
    @FindBy(id= "targetDeliveryDate")
    private WebElement targetDeliveryDate;
    @FindBy(id="specialInstructions")
    private WebElement specialInstructions;
    @FindBy(name = "procserveaction_addLine")
    private WebElement addLineItem;
    @FindBy(name="procserveaction_addSupplier")
    private WebElement selectSupplier;
    @FindBy(name="procserveaction_publishFtr")
    private  WebElement submitFTR;

    public FTREditPage()
    {
        PageFactory.initElements(driver,this);
    }
    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl()+"/shopping/ftrEdit/edit";
    }

    @Override
    public String getExpectedTitle()
    {
        return "FTR: Edit";
    }

    public void enterReference(String value)
    {
        ftrReference.sendKeys(value);
    }

    public void enterDeliverDate(String value)
    {
        targetDeliveryDate.clear();
        String actualTargetDate = addDaysTocurrentDate(Integer.parseInt(value));
        targetDeliveryDate.sendKeys(actualTargetDate);
    }

    public void specialInstructions(String value)
    {
        specialInstructions.sendKeys(value);
    }

    public LineItemPage addLineItem()
    {
        addLineItem.click();
        return new LineItemPage();
    }

    public FTRSuppliersPage selectSupplier()
    {
        selectSupplier.click();
        return new FTRSuppliersPage();
    }

    public InvoiceDetailsPage submitFTR()
    {
        pauseFor(3000);
        submitFTR.click();
        return new InvoiceDetailsPage();
    }
}
