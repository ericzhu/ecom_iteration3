package com.ecomlogix.ecom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ComponentScan(basePackages = { "com.ecomlogix.ecom.service", "com.ecomlogix.ecom.repository" }, excludeFilters = { @ComponentScan.Filter(Controller.class),
   @ComponentScan.Filter(ControllerAdvice.class) }, useDefaultFilters = true)
@Import(value = { DataConfiguration.class })
@ImportResource(locations = { "classpath:META-INF/spring-beans.xml" })
public class RootContextConfiguration {

}
