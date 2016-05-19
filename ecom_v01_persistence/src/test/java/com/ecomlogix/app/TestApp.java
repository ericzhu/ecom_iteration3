package com.ecomlogix.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomlogix.ecom.config.DataConfiguration;

public class TestApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);      
      context.close();
   }
}
