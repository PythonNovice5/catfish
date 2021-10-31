package com.basware.bttf.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Environment
{
    private static final Logger LOGGER = Logger.getLogger( Environment.class );

    private String bttfBaseUrl;
    private String pcmBaseUrl;
    private String heilerBaseUrl;
    private String punchouttoolUrl;
    private String amazonBaseUrl;

    private boolean pageTrace = false;

    private long pollSleep;
    private long pollRetries;

    private Map<String,User> users = new HashMap<String,User>();

    private static Environment instance;

    private Environment(){}

    public static Environment getInstance()
    {
        if( instance == null )
        {
            ObjectMapper mapper = new ObjectMapper();
            String basePath = "environments/" + System.getProperty( "test.env" );
            LOGGER.debug("BASE Path:  " +basePath);

            /* =======================
             * ENV CONFIG
             * ======================= */
            URL fileURL = Environment.class.getClassLoader().getResource( basePath + "/env.json" );

            try
            {
                instance = mapper.readValue( new File( fileURL.toURI() ), Environment.class );
            }
            catch( IOException | URISyntaxException e )
            {
                throw new RuntimeException( "Could not initialise environment configuration" , e );
            }

            LOGGER.debug( "ENV CONFIG: " + instance.toString() );

            /* =======================
             * USER CONFIG
             * ======================= */
            URL dirURL = Environment.class.getClassLoader().getResource( basePath + "/users/" );

            try( DirectoryStream<Path> stream = Files.newDirectoryStream( Paths.get( dirURL.toURI() ) , "*.json" ) )
            {
                for( Path entry : stream )
                {
                    File file = entry.toFile();
                    User user = mapper.readValue( file , User.class );
                    String userAlias = ( file.getName().split( "\\." ) )[0];
                    user.setUserAlias( userAlias );
                    instance.users.put( userAlias , user );
                }
            }
            catch ( URISyntaxException | IOException | DirectoryIteratorException e )
            {
                throw new RuntimeException( "Could not initialise user configuration" , e );
            }

            LOGGER.debug( "USERS: " + instance.users );
        }

        return instance;
    }

    public String getBttfBaseUrl()
    {
        return bttfBaseUrl;
    }

    public void setBttfBaseUrl( String bttfBaseUrl )
    {
        this.bttfBaseUrl = bttfBaseUrl;
    }

    public String getPcmBaseUrl()
    {
        return pcmBaseUrl;
    }

    public void setPcmBaseUrl( String pcmBaseUrl )
    {
        this.pcmBaseUrl = pcmBaseUrl;
    }

    public String getHeilerBaseUrl()
    {
        return heilerBaseUrl;
    }

    public void setHeilerBaseUrl( String heilerBaseUrl )
    {
        this.heilerBaseUrl = heilerBaseUrl;
    }

    public void setPunchouttoolUrl(String punchouttoolUrl){
        this.punchouttoolUrl = punchouttoolUrl;
    }

    public String getPunchOutToolUrl(){
        return punchouttoolUrl;
    }

    public void setAmazonBaseUrl(String amazonBaseUrl){
        this.amazonBaseUrl = amazonBaseUrl;
    }
    public String getAmazonBaseUrl(){
        return amazonBaseUrl;
    }

    public boolean isPageTrace()
    {
        return pageTrace;
    }

    public void setPageTrace( boolean pageTrace )
    {
        this.pageTrace = pageTrace;
    }

    public long getPollSleep()
    {
        return pollSleep;
    }

    public void setPollSleep( long pollSleep )
    {
        this.pollSleep = pollSleep;
    }

    public long getPollRetries()
    {
        return pollRetries;
    }

    public void setPollRetries( long pollRetries )
    {
        this.pollRetries = pollRetries;
    }

    public User getUser( String userAlias )
    {
        if( ! users.containsKey( userAlias ) )
        {
            throw new RuntimeException( "Invalid user: " + userAlias );
        }

        return users.get( userAlias );
    }

    @Override
    public String toString()
    {
        return "Environment{" +
                "bttfBaseUrl='" + bttfBaseUrl + '\'' +
                ", pcmBaseUrl='" + pcmBaseUrl + '\'' +
                ", heilerBaseUrl='" + heilerBaseUrl + '\'' +
                ", pageTrace=" + pageTrace +
                ", pollSleep=" + pollSleep +
                ", pollRetries=" + pollRetries +
                ", users=" + users +
                '}';
    }
}
