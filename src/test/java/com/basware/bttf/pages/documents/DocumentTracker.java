package com.basware.bttf.pages.documents;

import cucumber.api.java.ca.Cal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DocumentTracker extends DocumentsPage
{
    public DocumentTracker()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/documents/documentTracker";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Document Tracker";
    }

    // SORT BY
    @FindBy(linkText="Date")
    public WebElement sortByDate;

    @FindBy(linkText="Document Type")
    public WebElement sortByDocumentType;

    @FindBy(linkText="Ref")
    public WebElement sortByRef;

    @FindBy(xpath="//table//td//a")
    public WebElement DocFirstRef;

    @FindBy(xpath="//table//tbody//td")
    public WebElement ItemName;

    @FindBy(xpath="//h3[contains(text(),'Purchase Order')]")
    public WebElement PON;

    @FindBy(xpath="//a[normalize-space(text())='Download as PDF']")
    public WebElement DAPDF;

    @FindBy(xpath="//select[@name='documentType']")
    public WebElement DocType;

    @FindBy(name="documentId")
    public WebElement DocRef;

    @FindBy(name="supplierName")
    public WebElement SupName;

//    @FindBy(name="supplierName")
//    public WebElement SupName;

    @FindBy(id="startDate")
    public WebElement DateFrom;

    @FindBy(id="endDate")
    public WebElement DateTo;

    public String TodayLastYear;
    public String CurrentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    @FindBy(xpath="//select[@id='eventType']")
    public WebElement Event;

    @FindBy(xpath="//select[@id='documentType']")
    public WebElement Type;

    @FindBy(xpath="//a[contains(text(),'Download as PDF')]")
    public WebElement DownloadAsPDF;

    @FindBy(xpath = "//a[starts-with(text(),'Purchase Order')]")
    public WebElement POL;

    @FindBy(xpath = "//td[text()='Invoice']")
    public WebElement Invoice;

    @FindBy(xpath = "//li[contains(text(),'Invoice')]")
    public WebElement DocHistoryInvoice;

    @FindBy(xpath = "//a[contains(text(),'Purchase Order')]")
    public WebElement DocHistoryPO;

    @FindBy(id="documentId")
    public WebElement DocumentRef;

    @FindBy(xpath = "//td[text()='Invoice']")
    public WebElement AnyDocReceived;

    public String getDate() throws Exception{
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-3);
        String date = ((cal.get(Calendar.DATE))
        +"-"
        + (cal.get(Calendar.MONTH)+1)
        +"-"
        + cal.get(Calendar.YEAR)
        );
        SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
        Date varDate1=date1.parse(date);
        date1 = new SimpleDateFormat("dd-MM-yyyy");
        String finalDate = date1.format(varDate1);
        return finalDate;
    }


    public String returnSelected(String value) throws Exception{
        Select sel = new Select(getWebElementNamed(value));
        return getTextOfWebElement(sel.getFirstSelectedOption());
    }

    public DocumentTracker clickSortBy(String element) {
        switch (element) {
            case "Date":
                waitUntillElementIsClickableAndClick(sortByDate);
//                sortByDate.click();
                break;
        }
        return new DocumentTracker();
    }

    public DocumentTracker clickFirstReference(){
        waitUntillElementIsClickableAndClick(DocFirstRef);
        return new DocumentTracker();
    }

    public DocumentTracker clickDownloadAsPDF(){
        waitUntillElementIsClickableAndClick(DownloadAsPDF);
//        DownloadAsPDF.click();
        return new DocumentTracker();
    }

//    public DocumentTracker
}
