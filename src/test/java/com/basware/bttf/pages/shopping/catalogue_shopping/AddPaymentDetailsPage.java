package com.basware.bttf.pages.shopping.catalogue_shopping;

import com.basware.bttf.pages.shopping.ShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentDetailsPage extends ShoppingPage {

    @FindBy( id = "cardNumber"  )
    private WebElement cardNumberInput;

    @FindBy( name = "_action_updateEPaymentCard")
    private WebElement saveButton;

    @Override
    public String getExpectedUrl() {
        return getBaseUrl() + "/shopping/invoice";
    }

    @Override
    public String getExpectedTitle() {
        return "Add payment details";
    }

    public AddPaymentDetailsPage()
    {
        PageFactory.initElements(driver,this);
    }

    public InvoiceDetailsPage enterCardDetails(String cardDetails)
    {
        cardNumberInput.sendKeys(cardDetails);
        saveButton.click();
        return new InvoiceDetailsPage();
    }
}
