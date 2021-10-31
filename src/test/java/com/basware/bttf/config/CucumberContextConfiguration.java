package com.basware.bttf.config;

import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes=SpringConfig.class)
public class CucumberContextConfiguration
{
    @Before
    public void xxx_setup_cucumber_spring_context()
    {
        // HACK!!!
        // Dummy method so cucumber will recognize this class as glue and use its context configuration.
    }

}
