package com.basware.bttf.pages;

import com.basware.bttf.domain.User;
import com.basware.bttf.pages.external.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public abstract class InternalPage extends AbstractPage
{
    // FOOTER ITEMS
    @FindBys( { @FindBy( className="poweredBy" ) , @FindBy(linkText="Basware") } )
    public WebElement footerBaswareLink;

    @FindBy(linkText="Acceptable Use Policy")
    public WebElement footerAcceptableUsePolicy;

    @FindBy(linkText="Accessibility information")
    public WebElement footerAccessibilityInformation;

    @FindBy(linkText="Privacy Notice")
    public WebElement footerPrivacyNotice;

    @FindBy(linkText="Cookie Notice")
    public WebElement footerCookieNotice;

    public void validateFooterItems( User user ) throws Exception
    {
        LOGGER.debug( "Validating footer items:" );

        List<WebElement> footerElements = new ArrayList<WebElement>() {{
            add( footerBaswareLink );
            add( footerAcceptableUsePolicy );
            add( footerAccessibilityInformation );
            add( footerPrivacyNotice );
            add( footerCookieNotice );
        }};

        for( WebElement footerElement : footerElements )
        {
            LOGGER.debug( "* item: " + footerElement.getText() );
            footerElement.isDisplayed();
        }
        LOGGER.debug( "All expected footer elements are displayed" + "\n");
    }

    public InternalPage navigateToInternalPageInline( String pageName )
    {
        InternalPage internalPage = null;

        switch( pageName )
        {
            case "Accessibility information":  internalPage = navigateToFooterAccessibilityInformation(); break;
        }

        return internalPage;
    }

    public ExternalPage navigateToExternalPageInline( String pageName )
    {
        ExternalPage externalPage = null;

        switch( pageName )
        {
            // Footer links
            case "Acceptable Use Policy":  externalPage = navigateToFooterAcceptableUsePolicy(); break;
            case "Privacy Notice":  externalPage = navigateToFooterPrivacyNotice(); break;
            case "Cookie Notice":  externalPage = navigateToFooterCookieNotice(); break;
        }

        return externalPage;
    }

    public ExternalPage navigateToFooterBaswareLink()
    {
        footerBaswareLink.click();
        return new BaswareLinkPage();
    }

    public ExternalPage navigateToFooterAcceptableUsePolicy()
    {
        waitUntillElementIsClickableAndClick(footerAcceptableUsePolicy);
        AcceptableUsePolicyPage acceptableUsePolicyPage = new AcceptableUsePolicyPage();
        this.switchToNewWindow(acceptableUsePolicyPage);
        return acceptableUsePolicyPage;
    }

    public InternalPage navigateToFooterAccessibilityInformation()
    {
        waitUntillElementIsClickableAndClick(footerAccessibilityInformation);
        return new AccessibilityInformationPage();
    }

    public ExternalPage navigateToFooterPrivacyNotice()
    {

        waitUntillElementIsClickableAndClick(footerPrivacyNotice);
        PrivacyNoticePage privacyNoticePage = new PrivacyNoticePage();
        this.switchToNewWindow(privacyNoticePage);
        return privacyNoticePage;
    }

    public ExternalPage navigateToFooterCookieNotice()
    {
        waitUntillElementIsClickableAndClick(footerCookieNotice);
        CookieNoticePage cookieNoticePage = new CookieNoticePage();
        this.switchToNewWindow(cookieNoticePage);
        return cookieNoticePage;
    }

}
