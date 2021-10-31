package com.basware.bttf.pages.product_manager.buyer.agreements;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by DuncanNash on 04/04/2017.
 */
public class CreateAgreementNewPage extends CreateAgreementPage
{
    protected static Logger LOGGER = Logger.getLogger( CreateAgreementNewPage.class.getName() );

    public CreateAgreementNewPage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return getBaseUrl() + "/products/addAgreement/addAgreement";
    }
}
