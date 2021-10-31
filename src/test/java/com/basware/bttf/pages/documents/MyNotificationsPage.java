package com.basware.bttf.pages.documents;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.LoggedInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyNotificationsPage extends DocumentsPage
{
    protected static Logger LOGGER = Logger.getLogger( MyNotificationsPage.class.getName() );

    @FindBy(className="notification-list")
    public WebElement notificationList;

    // FILTER LINKS
    @FindBy(partialLinkText="Unread Credit Notes")
    public WebElement unreadCreditNotesLink;

    @FindBy(partialLinkText="Unpaid Invoices")
    public WebElement unpaidInvoicesLink;

    @FindBy(partialLinkText="Requisitions pending my approval")
    public WebElement requisitionsPendingMyApprovalLink;

    @FindBy(partialLinkText="Unread Quotes")
    public WebElement unreadQuotesLink;

    @FindBy(partialLinkText="Requisitions pending approval")
    public WebElement requisitionsPendingApprovalLink;

    @FindBy(partialLinkText="Purchase Orders without an invoice")
    public WebElement purchaseOrdersWithoutAnInvoiceLink;

    @FindBy(partialLinkText="Requests for Quote about to expire")
    public WebElement requestsForQuoteAboutToExpireLink;

    @FindBy(partialLinkText="Requests for Quotes that have expired")
    public WebElement requestsForQuotesThatHaveExpiredLink;

    private Map<String,WebElement> possibleDocumentFilterItems = null;

    public MyNotificationsPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/documents/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "My Notifications";
    }

    public LoggedInPage findAndClickOnFirstNotificationLinks()
    {
        try
        {
            List<WebElement> notifications = notificationList.findElements( By.tagName( "a" ) );

            if( notifications.size() == 0 )
            {
                LOGGER.warn( "No notifications found" );
                return this;
            }

            notifications.get( 0 ).click();

            return new MyTransactionsPage();
        }
        catch( NoSuchElementException nee )
        {
            nee.getMessage();
            LOGGER.warn( "No notifications found" );
        }

        return this;
    }

    public void validateDocumentFilterItems( User user ) throws Exception
    {
        LOGGER.debug( "validateDocumentFilterItems() - Validating user menu items" );

        possibleDocumentFilterItems = new HashMap<String,WebElement>(){{
            put( "UNREAD_CREDIT_NOTES" ,                   unreadCreditNotesLink );
            put( "UNPAID_INVOICES"  ,                      unpaidInvoicesLink );
            put( "REQUISITIONS_PENDING_MY_APPROVAL" ,      requisitionsPendingMyApprovalLink );
            put( "UNREAD_QUOTES" ,                         unreadQuotesLink );
            put( "REQUISITIONS_PENDING_APPROVAL" ,         requisitionsPendingApprovalLink );
            put( "PURCHASE_ORDERS_WITHOUT_AN_INVOICE" ,    purchaseOrdersWithoutAnInvoiceLink );
            put( "REQUESTS_FOR_QUOTE_ABOUT_TO_EXPIRE" ,    requestsForQuoteAboutToExpireLink );
            put( "REQUESTS_FOR_QUOTES_THAT_HAVE_EXPIRED" , requestsForQuotesThatHaveExpiredLink );
        }};

        validateItems( possibleDocumentFilterItems , user.getAllowedDocFilters() );
    }

    public LoggedInPage navigateToMyTransactionsViaFilter( String pageName )
    {
        switch( pageName )
        {
            case "Unread Credit Notes" : return navigateToUnreadCreditNotesFilter();
            case "Unpaid Invoices" : return navigateToUnpaidInvoicesFilter();
            case "Requisitions pending my approval" : return navigateToRequisitionsPendingMyApprovalFilter();
            case "Unread Quotes" : return navigateToUnreadQuotesFilter();
            case "Requisitions pending approval" : return navigateToRequisitionsPendingApprovalFilter();
            case "Purchase Orders without an invoice" : return navigateToPurchaseOrdersWithoutAnInvoiceFilter();
            case "Requests for Quote about to expire" : return navigateToRequestsForQuoteAboutToExpireFilter();
            case "Requests for Quotes that have expired" : return navigateToRequestsForQuotesThatHaveExpiredFilter();
        }

        return null;
    }

    private LoggedInPage navigateToUnreadCreditNotesFilter()
    {
        unreadCreditNotesLink.click();
        return new MyTransactionsPage( "direction=all&status=unread&documentType=credit_note" );
    }

    private LoggedInPage navigateToUnpaidInvoicesFilter()
    {
        unpaidInvoicesLink.click();
        return new MyTransactionsPage( "direction=all&status=unpaid&documentType=invoice" );
    }

    private LoggedInPage navigateToRequisitionsPendingMyApprovalFilter()
    {
        requisitionsPendingMyApprovalLink.click();
        return new MyTransactionsPage( "direction=received&status=approve&documentType=requisition" );
    }

    private LoggedInPage navigateToUnreadQuotesFilter()
    {
        unreadQuotesLink.click();
        return new MyTransactionsPage( "direction=all&status=unread&documentType=quote" );
    }

    private LoggedInPage navigateToRequisitionsPendingApprovalFilter()
    {
        requisitionsPendingApprovalLink.click();
        return new MyTransactionsPage( "direction=sent&status=approve&documentType=requisition" );
    }

    private LoggedInPage navigateToPurchaseOrdersWithoutAnInvoiceFilter()
    {
        purchaseOrdersWithoutAnInvoiceLink.click();
        return new MyTransactionsPage( "direction=all&status=none&documentType=purchase_order" );
    }

    private LoggedInPage navigateToRequestsForQuoteAboutToExpireFilter()
    {
        requestsForQuoteAboutToExpireLink.click();
        return new MyTransactionsPage( "direction=all&status=expiring&documentType=rfq" );
    }

    private LoggedInPage navigateToRequestsForQuotesThatHaveExpiredFilter()
    {
        requestsForQuotesThatHaveExpiredLink.click();
        return new MyTransactionsPage( "direction=all&status=expired&documentType=rfq" );
    }

}
