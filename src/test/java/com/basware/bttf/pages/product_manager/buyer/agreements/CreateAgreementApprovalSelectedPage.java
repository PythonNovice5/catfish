package com.basware.bttf.pages.product_manager.buyer.agreements;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class CreateAgreementApprovalSelectedPage extends CreateAgreementPage
{
    protected static Logger LOGGER = Logger.getLogger( CreateAgreementApprovalSelectedPage.class.getName() );

    public CreateAgreementApprovalSelectedPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/addAgreement/renderApproval";
    }
}
