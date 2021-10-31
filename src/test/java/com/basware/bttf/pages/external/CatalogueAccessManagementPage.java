package com.basware.bttf.pages.external;

public class CatalogueAccessManagementPage extends ExternalPage
{
    @Override
    public String getExpectedUrl()
    {
        return env.getHeilerBaseUrl();
    }

    @Override
    public String getExpectedTitle()
    {
        return "Catalogue Search";
    }
}
