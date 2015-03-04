package com.easygoapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Kir Kolesnikov on 02.03.2015.
 */
@Configuration
@Import({
        PersistenceConfig.class
})
//@ComponentScan({RootConfig.ROOT_PACKAGE + RootConfig.SERVICE_PACKAGE })
@ComponentScan("com.easygoapp.service")
public class RootConfig {
    public static final String ROOT_PACKAGE = "com.easygoapp";
    public static final String SERVICE_PACKAGE = ".service";
    public static final String DOMAIN_PACKAGE = ".domain";
    public static final String CONTROLLERS_PACKAGE = ".controllers";
    public static final String REPOSITORY_PACKAGE = ".repository";
}
