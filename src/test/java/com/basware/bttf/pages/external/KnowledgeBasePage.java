package com.basware.bttf.pages.external;

import org.openqa.selenium.support.PageFactory;

public class KnowledgeBasePage extends ExternalPage
{
    public KnowledgeBasePage()
    {
        PageFactory.initElements( driver , this );
    }

    @Override
    public String getExpectedUrl()
    {
        return "http://info.basware.co.uk/buyers/";
    }

    @Override
    public String getExpectedTitle()
    {
        return "Basware Info » Buyers Knowledge Centre";
    }
}
