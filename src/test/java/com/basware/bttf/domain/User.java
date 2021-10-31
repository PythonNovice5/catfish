package com.basware.bttf.domain;

import com.basware.bttf.pages.dashboard.DashboardPage;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User
{
    private String userAlias;
    private String username;
    private String password;
    private Boolean isBuyer;
    private Boolean isSupplier;

    private Set<String> allowedMainMenuItems  = new HashSet<String>();
    private Set<String> allowedSettings   = new HashSet<String>();
    private Set<String> allowedDocTabs    = new HashSet<String>();
    private Set<String> allowedDocFilters = new HashSet<String>();

    public User(){}

    private void setAllowedItems( String list , Set<String> allowedItems )
    {
        if( ! StringUtils.isBlank( list ) )
        {
            String[] itemsArray = ( list.length() != 0 ) ? list.split( "," ) : new String[]{};
            allowedItems.addAll( Arrays.asList( itemsArray ) );
        }
    }

    public DashboardPage getUserHomePage() throws Exception
    {
        return new DashboardPage();      // currently, always the dashboard welcome page
    }

    public String getUserAlias()
    {
        return userAlias;
    }

    public void setUserAlias( String userAlias )
    {
        this.userAlias = userAlias;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public Boolean getIsBuyer()
    {
        return isBuyer;
    }

    public void setIsBuyer( Boolean isBuyer )
    {
        this.isBuyer = isBuyer;
    }

    public Boolean getIsSupplier()
    {
        return isSupplier;
    }

    public void setIsSupplier( Boolean isSupplier )
    {
        this.isSupplier = isSupplier;
    }


    public Set<String> getAllowedMainMenuItems() { return allowedMainMenuItems; }

    public Set<String> getAllowedSettings()
    {
        return allowedSettings;
    }

    public Set<String> getAllowedDocTabs()
    {
        return allowedDocTabs;
    }

    public Set<String> getAllowedDocFilters()
    {
        return allowedDocFilters;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userAlias='" + userAlias + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBuyer=" + isBuyer +
                ", isSupplier=" + isSupplier +
                ", allowedMainMenuItems=" + allowedMainMenuItems +
                ", allowedSettings=" + allowedSettings +
                ", allowedDocTabs=" + allowedDocTabs +
                ", allowedDocFilters=" + allowedDocFilters +
                '}';
    }
}
