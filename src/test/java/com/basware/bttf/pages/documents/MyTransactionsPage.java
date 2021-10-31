package com.basware.bttf.pages.documents;

import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyTransactionsPage extends DocumentsPage
{
    // SHOW ME
    @FindBys( { @FindBy( partialLinkText="My Transactions") , @FindBy( xpath="//body/div[5]/div[1]/div[1]/ul/li[2]/a") } )
    public WebElement myTransactionsFilter;

    // THAT WERE
    @FindBy(partialLinkText="Received")
    public WebElement thatWereReceivedFilter;

    @FindBy(partialLinkText="Sent")
    public WebElement thatWereSentFilter;

    @FindBy(partialLinkText="Archived")
    public WebElement thatWereArchivedFilter;

    @FindBys( { @FindBy( partialLinkText="All of the above") , @FindBy( xpath="//body/div[5]/div[1]/div[1]/ul[2]/li[5]/a") } )
    public WebElement thatWereAllOfTheAboveFilter;

    // THAT I
    @FindBy(partialLinkText="Have flagged")
    public WebElement thatIHaveFlagged ;

    @FindBy(partialLinkText="Have read")
    public WebElement thatIHaveRead;

    @FindBy(partialLinkText="Have not read")
    public WebElement thatIHaveNotRead;

    @FindBy(partialLinkText="Need to approve")
    public WebElement thatINeedToApprove;

    @FindBys( { @FindBy( partialLinkText="All of the above") , @FindBy( xpath="//body/div[5]/div[1]/div[1]/ul[3]/li[6]/a") } )
    public WebElement thatIAllOfTheAboveFilter;

    // DOCUMENT TYPE
    @FindBy(partialLinkText="Any")
    public WebElement documentTypeAny;

    @FindBy(partialLinkText="Requests for Quote")
    public WebElement documentTypeRFQs;

    @FindBy(partialLinkText="Quotes")
    public WebElement documentTypeQuotes;

    @FindBy(partialLinkText="Requisitions")
    public WebElement documentTypeRequisitions;

    @FindBy(partialLinkText="Purchase Orders")
    public WebElement documentTypePurchaseOrders;

    @FindBy(partialLinkText="Invoices")
    public WebElement documentTypeInvoices;

    @FindBy(partialLinkText="Credit Notes")
    public WebElement documentTypeCreditNotes;

    // SORT BY
    @FindBy(linkText="Date")
    public WebElement sortByDate;

    @FindBy(linkText="Document Type")
    public WebElement sortByDocumentType;

    @FindBy(linkText="Ref")
    public WebElement sortByRef;

    // SELECT
    @FindBy(linkText="All")
    public WebElement selectAll;

    @FindBy(linkText="None")
    public WebElement selectNone;

    // MARK AS
    @FindBy(id="flaggedButton")
    public WebElement markAsFlaggedButton;

    @FindBy(id="unFlaggedButton")
    public WebElement markAsUnFlaggedButton;

    @FindBy(id="readButton")
    public WebElement markAsReadButton;

    @FindBy(id="unReadButton")
    public WebElement markAsUnReadButton;

    @FindBy(id="archivedButton")
    public WebElement markAsArchivedButton;

    // PAGE SIZE
    @FindBy(linkText="25")
    public WebElement pageSize25;

    @FindBy(linkText="50")
    public WebElement pageSize50;

    @FindBy(linkText="100")
    public WebElement pageSize100;

    @FindBy(tagName="tbody")
    public WebElement documentsList;

    // DOCUMENT VIEW
    @FindBy(linkText="Back to your results")
    public WebElement backToYourResults;

    @FindBy(xpath="//div[@class='document-container'][1]/div[1]/button" )
    public WebElement expandCollapseButton;

    @FindBy(partialLinkText="Download as cXML")
    public WebElement downloadAsCXML;

    @FindBy(partialLinkText="Download as PDF")
    public WebElement downloadAsPDF;

    private String queryStringSnippet;

    public MyTransactionsPage()
    {
        PageFactory.initElements( driver , this );
    }

    public MyTransactionsPage( String queryStringSnippet )
    {
        PageFactory.initElements( driver , this );

        this.queryStringSnippet = queryStringSnippet;
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/documents/my-transactions";
    }

    @Override
    public String getExpectedTitle()
    {
        return "My Transactions";
    }

    public String getQueryStringSnippet()
    {
        return queryStringSnippet;
    }


    /***********************
     *** FILTERS ***********
     ***********************/
    public LoggedInPage clickOnMyTransactionsFilter( String pageName )
    {
        switch( pageName )
        {
            case "My Transactions" : return clickMyTransactionsFilter();

            case "That Were / Received" : return clickThatWereReceivedFilter();
            case "That Were / Sent" : return clickThatWereSentFilter();
            case "That Were / Archived" : return clickThatWereArchivedFilter();
            case "That Were / All of the above" : return clickThatWereAllOfTheAboveFilter();

            case "That I / Have flagged" : return clickThatIHaveFlagged();
            case "That I / Have read" : return clickThatIHaveRead();
            case "That I / Have not read" : return clickThatIHaveNotRead();
            case "That I / Need to approve" : return clickThatINeedToApprove();
            case "That I / All of the above" : return clickThatIAllOfTheAboveFilter();

            case "Document Type / Any" : return clickDocumentTypeAny();
            case "Document Type / Requests for Quote" : return clickDocumentTypeRFQs();
            case "Document Type / Quotes" : return clickDocumentTypeQuotes();
            case "Document Type / Requisitions" : return clickDocumentTypeRequisitions();
            case "Document Type / Purchase Orders" : return clickDocumentTypePurchaseOrders();
            case "Document Type / Invoices" : return clickDocumentTypeInvoices();
            case "Document Type / Credit Notes" : return clickDocumentTypeCreditNotes();
        }

        return null;
    }

    public MyTransactionsPage clickMyTransactionsFilter()
    {
        myTransactionsFilter.click();
        return new MyTransactionsPage( "direction=received&status=none&documentType=any" );
    }

    public MyTransactionsPage clickThatWereReceivedFilter()
    {
        thatWereReceivedFilter.click();
        return new MyTransactionsPage( "direction=received&status=none&documentType=any" );
    }

    public MyTransactionsPage clickThatWereSentFilter()
    {
        thatWereSentFilter.click();
        return new MyTransactionsPage( "direction=sent&status=none&documentType=any" );
    }

    public MyTransactionsPage clickThatWereArchivedFilter()
    {
        thatWereArchivedFilter.click();
        return new MyTransactionsPage( "direction=archived&status=none&documentType=any" );
    }

    public MyTransactionsPage clickThatWereAllOfTheAboveFilter()
    {
        thatWereAllOfTheAboveFilter.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=any" );
    }

    public MyTransactionsPage clickThatIHaveFlagged()
    {
        thatIHaveFlagged.click();
        return new MyTransactionsPage( "direction=all&status=flagged&documentType=any" );
    }

    public MyTransactionsPage clickThatIHaveRead()
    {
        thatIHaveRead.click();
        return new MyTransactionsPage( "direction=all&status=read&documentType=any" );
    }

    public LoggedInPage clickThatIHaveNotRead()
    {
        thatIHaveNotRead.click();
        return new MyTransactionsPage( "direction=all&status=unread&documentType=any" );
    }

    public MyTransactionsPage clickThatINeedToApprove()
    {
        thatINeedToApprove.click();
        return new MyTransactionsPage( "direction=all&status=approve&documentType=any" );
    }

    public MyTransactionsPage clickThatIAllOfTheAboveFilter()
    {
        thatIAllOfTheAboveFilter.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=any" );
    }

    public MyTransactionsPage clickDocumentTypeAny()
    {
        documentTypeAny.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=any" );
    }

    public MyTransactionsPage clickDocumentTypeRFQs()
    {
        documentTypeRFQs.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=rfq" );
    }

    public MyTransactionsPage clickDocumentTypeQuotes()
    {
        documentTypeQuotes.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=quote" );
    }

    public MyTransactionsPage clickDocumentTypeRequisitions()
    {
        documentTypeRequisitions.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=requisition" );
    }

    public MyTransactionsPage clickDocumentTypePurchaseOrders()
    {
        documentTypePurchaseOrders.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=purchase_order" );
    }

    public MyTransactionsPage clickDocumentTypeInvoices()
    {
        documentTypeInvoices.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=invoice" );
    }

    public MyTransactionsPage clickDocumentTypeCreditNotes()
    {
        documentTypeCreditNotes.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=credit_note" );
    }

    /***********************
     *** SORT BY ***********
     ***********************/
    public LoggedInPage clickSortBy( String sortType )
    {
        switch( sortType )
        {
            case "Date" : return clickSortByDate();
            case "Document Type" : return clickSortByDocumentType();
            case "Ref" : return clickSortByRef();
        }

        return null;
    }

    public MyTransactionsPage clickSortByDate()
    {
        sortByDate.click();
        return new MyTransactionsPage( "orderBy=created" );
    }

    public MyTransactionsPage clickSortByDocumentType()
    {
        sortByDocumentType.click();
        return new MyTransactionsPage( "orderBy=documentType" );
    }

    public MyTransactionsPage clickSortByRef()
    {
        sortByRef.click();
        return new MyTransactionsPage( "orderBy=documentNumber" );
    }

    /***********************
     *** SELECT ************
     ***********************/
    public MyTransactionsPage clickSelect( String selectType )
    {
        switch( selectType )
        {
            case "All" : return clickSelectAll();
            case "None" : return clickSelectNone();
        }

        return null;
    }

    public MyTransactionsPage clickSelectAll()
    {
        selectAll.click();
        return new MyTransactionsPage( "select=all" );
    }

    public MyTransactionsPage clickSelectNone()
    {
        selectNone.click();
        return new MyTransactionsPage( "select=none" );
    }

    /***********************
     *** MARK AS ***********
     ***********************/
    public MyTransactionsPage clickMarkAs( String selectType )
    {
        switch( selectType )
        {
            case "Flagged" :    markAsFlaggedButton.click(); return this;
            case "Un-flagged" : markAsUnFlaggedButton.click(); return this;
            case "Read" :       markAsReadButton.click(); return this;
            case "Unread" :     markAsUnReadButton.click(); return this;
            case "Archived" :   markAsArchivedButton.click(); return this;
        }

        return null;
    }

    /***********************
     *** PAGE SIZE *********
     ***********************/
    public MyTransactionsPage pageSize( String pageSize )
    {
        switch( pageSize )
        {
            case "25" : return clickPageSize25();
            case "50" : return clickPageSize50();
            case "100" : return clickPageSize100();
        }

        return null;
    }

    public MyTransactionsPage clickPageSize25()
    {
        pageSize25.click();
        return new MyTransactionsPage( "pageSize=25" );
    }

    public MyTransactionsPage clickPageSize50()
    {
        pageSize50.click();
        return new MyTransactionsPage( "pageSize=50" );
    }

    public MyTransactionsPage clickPageSize100()
    {
        pageSize100.click();
        return new MyTransactionsPage( "pageSize=100" );
    }

    public MyTransactionsPage clickOnFirstDocument()
    {
        List<WebElement> documents = documentsList.findElements( By.tagName( "tr" ) );

        if( documents.size() == 0 )
        {
            return this;
        }

        WebElement document = documents.get( 0 );

        List<WebElement> fields = document.findElements( By.tagName( "td" ) );
        WebElement docLinkField = fields.get( 2 );
        WebElement docLink = docLinkField.findElement( By.tagName( "a" ) );
        docLink.click();
        return new MyTransactionsPage( "/documents/my-transactions/view/" );
    }

    /***********************
     *** VIEW  *************
     ***********************/
    public MyTransactionsPage expandCollapseDocumentView()
    {
        expandCollapseButton.click();
        return this;
    }

    public MyTransactionsPage clickOnBackToYourResults()
    {
        backToYourResults.click();
        return this;
    }

    public MyTransactionsPage downloadDocumentAs( String downloadType )
    {
        switch( downloadType )
        {
            case "CXML" : downloadAsCXML.click(); return this;
            case "PDF" :  downloadAsPDF.click(); return this;
        }

        return null;
    }
}
