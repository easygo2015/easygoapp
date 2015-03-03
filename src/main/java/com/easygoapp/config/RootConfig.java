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
@ComponentScan({ "com.easygoapp.service" })
public class RootConfig {

}
