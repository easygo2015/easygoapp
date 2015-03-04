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
@ComponentScan({"com.easygoapp.service" })
public class RootConfig {
    public static final String ROOT_PACKAGE = "com.easygoapp";
    public static final String SERVICE_PACKAGE = "com.easygoapp.service";
    public static final String DOMAIN_PACKAGE = "com.easygoapp.domain";
    public static final String CONTROLLERS_PACKAGE = "com.easygoapp.controllers";
    public static final String REPOSITORY_PACKAGE = ROOT_PACKAGE + ".repository";
}
