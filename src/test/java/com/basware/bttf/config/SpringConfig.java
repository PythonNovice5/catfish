package com.basware.bttf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = {
        "com.basware" ,
        "com.basware.bttf" ,
        "cucumber.api.spring"
    }
)
public class SpringConfig
{
}
