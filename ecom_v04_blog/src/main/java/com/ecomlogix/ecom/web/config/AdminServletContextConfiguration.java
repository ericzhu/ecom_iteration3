package com.ecomlogix.ecom.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ecomlogix.ecom.web.admin", useDefaultFilters = false, includeFilters = { @ComponentScan.Filter(Controller.class),
   @ComponentScan.Filter(ControllerAdvice.class) })
public class AdminServletContextConfiguration extends WebMvcConfigurerAdapter {
   private static final Integer STATIC_RESOURCE_CACHE_PERIOD = 36000;

   @Bean
   public InternalResourceViewResolver resourceResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setViewClass(JstlView.class);
      viewResolver.setPrefix("/WEB-INF/views/admin/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(STATIC_RESOURCE_CACHE_PERIOD);
   }
}
