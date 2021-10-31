package com.basware.bttf.pages.contracts;

import com.basware.bttf.pages.product_manager.ProductManagerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EditContractPage extends ContractsPage {

    @FindBy(id = "contractName")
    private WebElement contractName;

    @FindBy(id = "contractReference")
    private WebElement contractReference;

    @FindBy(id = "euReference" )
    private WebElement euReference;

    @FindBy (id = "contractOwner")
    private WebElement contractOwner;

    @FindBy(id="startDate")
    private WebElement startDate;

    @FindBy(id= "expiryDate")
    private WebElement expiryDate;

    @FindBy(id= "description")
    private WebElement description;

    @FindBy(id= "contractScope")
    private WebElement contractScope;

    @FindBy(id= "itemManagementType")
    private WebElement itemManagementType;

    @FindBy(id= "supplierManagementType")
    private WebElement supplierManagementType;

    @FindBy(name = "addSupplier")
    private WebElement addSupplierButton;

    @FindBy(xpath = "//*[@id='contract']/div[9]/div/div/button[2]")
    private WebElement saveButton;

    @FindBy(linkText = "Cancel")
    private WebElement cancelButton;

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/contracts/editContract/edit";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Contracts: Create Contracts Add";
    }


    public void enterContractDetails(String field,String value) {
        switch (field.toLowerCase()) {
            case "contract name":
                value = value+getSessionID();
                contractName.sendKeys(value);
                props.set("Cname",value);
                break;
            case "contract reference":
                contractReference.sendKeys(value+getSessionID());
                break;
            case "contract owner":
                contractOwner.sendKeys(value);
                break;
            case "start date":
                String startdateAfterDaysAdded = addDaysTocurrentDate(Integer.parseInt(value));
                startDate.sendKeys(startdateAfterDaysAdded);
                break;
            case "expiry date":
                String expiryDateAfterDaysAdded = addDaysTocurrentDate(Integer.parseInt(value));
                expiryDate.sendKeys(expiryDateAfterDaysAdded);
                break;
            case "description":
                 description.sendKeys(value);
                break;
            case "enter contract scope":
                contractScope.sendKeys(value);
                break;
        }
    }
    public void selectContractDetails(String dropdown, String value) throws Exception {
        switch (dropdown.toLowerCase()) {
            case "item management":
                selectDropdownOptionByText(itemManagementType,value);
                break;
            case "supplier management":
                selectDropdownOptionByText(supplierManagementType,value);
                break;
        }
    }

    public ContractsPage clickOnButton(String button, String action)
    {
        ContractsPage page = null;
        switch(button.toLowerCase()){
            case "add suppliers":
                addSupplierButton.click();
                page = new ContractsSuppliersPage();
                break;
            case "save":
                saveButton.click();
                page = new MyContractPage();
                break;
            case "cancel":
                cancelButton.click();
                page = new MyContractPage();
                break;
        }
        return page;
    }

    protected String addDaysTocurrentDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        return sdf.format(c.getTime());
    }
}
