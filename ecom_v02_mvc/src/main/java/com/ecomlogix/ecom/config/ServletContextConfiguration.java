package com.ecomlogix.ecom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ecomlogix.ecom.web", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(Controller.class),
   @ComponentScan.Filter(ControllerAdvice.class) })
public class ServletContextConfiguration {

}
