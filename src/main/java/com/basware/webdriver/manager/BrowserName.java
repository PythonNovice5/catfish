package com.basware.webdriver.manager;

public enum BrowserName
{
    GOOGLECHROME( "webdriver.chrome.driver" ),
    IE( "webdriver.ie.driver" ),
    FIREFOX( "webdriver.firefox.bin" ),
    EDGE("webdriver.edge.driver");

    BrowserName(String propertyName )
    {
        this.propertyName = propertyName;
    }

    private String propertyName;

    public String getPropertyName()
    {
        return this.propertyName;
    }
}
