package com.basware.bttf.util;

import com.basware.bttf.domain.Environment;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

public class TestProperties
{
    private static final Logger LOGGER = Logger.getLogger( TestProperties.class );

    Environment env = Environment.getInstance();

    public static final String PROPS_FILE_KEY = "test.properties." + System.getProperty("test.env");

    protected static Properties props = null;

    private TestProperties(){}

    public static TestProperties getInstance()
    {
        if( props == null )
        {
            props = new Properties();
        }

        return new TestProperties();
    }

    public String get(String key)
    {
        if( env.isPageTrace() ){ LOGGER.trace( "Getting Key: '" + key + "' -> '" + props.getProperty( key) + "'" ); }
        return props.getProperty( key);
    }

    public void set(String key, String value)
    {
        if( env.isPageTrace() ){ LOGGER.trace( "Key: '" + key + "' => Value: '" + value + "'" ); }
        props.setProperty( key, value);
    }

  }
