package com.ecomlogix.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomlogix.ecom.config.DataConfiguration;
import com.ecomlogix.ecom.domain.Category;
import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.service.IItemService;

public class TestApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);
      IItemService itemService = context.getBean(IItemService.class);

      Category category = itemService.getCategory(2L);
      System.out.println(category.getDescription());

      Item item = itemService.getItem(1L);
      System.out.println(item.getDescription());

      context.close();
   }
}
