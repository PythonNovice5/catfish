package com.basware.bttf.pages.documents;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.LoggedInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public abstract class DocumentsPage extends LoggedInPage
{
    @FindBy(xpath="//button[contains(.,'Search')]|//input[@value='Search']")
    public WebElement searchButton;

    // TABS
    @FindBy(linkText="My Notifications")
    public WebElement myNotificationsTab;

    @FindBy(linkText="My Transactions")
    public WebElement myTransactionsTab;

    @FindBy(linkText="Document Tracker")
    public WebElement documentTrackerTab;

    private Map<String,WebElement> possibleDocumentTabItems = null;

    public void validateDocumentTabItems( User user ) throws Exception
    {
        LOGGER.debug( "validateDocumentTabItems() - Validating user menu items" );

        possibleDocumentTabItems = new HashMap<String,WebElement>(){{
            put( "MY_NOTIFICATIONS" , myNotificationsTab );
            put( "MY_TRANSACTIONS"  , myTransactionsTab );
            put( "DOCUMENT_TRACKER" , documentTrackerTab );
        }};

        validateItems( possibleDocumentTabItems , user.getAllowedDocTabs() );
    }

    public DocumentsPage clickDocumentTabs( String pageName ) throws Exception
    {
        switch( pageName )
        {
            case "My Notifications" : return clickMyNotificationsTab();
            case "My Transactions" : return clickMyTransactionsTab();
            case "Document Tracker" : return clickDocumentTrackerTab();
        }

        return null;
    }

    public DocumentsPage clickSearchButton()
    {
        waitUntillElementIsClickableAndClick(searchButton);
        return this;
    }

//    public DocumentsPage clickButton(String btn){
//
//        return this;
//    }

    public DocumentsPage clickMyNotificationsTab()
    {
        myNotificationsTab.click();
        return new MyNotificationsPage();
    }

    public DocumentsPage clickMyTransactionsTab()
    {
        myTransactionsTab.click();
        return new MyTransactionsPage();
    }

    public DocumentsPage clickDocumentTrackerTab()
    {
        waitUntillElementIsClickableAndClick(documentTrackerTab);
//        documentTrackerTab.click();
        pauseFor(6000);
        return new DocumentTracker();
    }

}
