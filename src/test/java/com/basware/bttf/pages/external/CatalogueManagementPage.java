package com.basware.bttf.pages.external;

public class CatalogueManagementPage extends ExternalPage
{
    @Override
    public String getExpectedUrl()
    {
        return env.getPcmBaseUrl();
    }

    @Override
    public String getExpectedTitle()
    {
        return "Catalogue Manager";
    }
}
