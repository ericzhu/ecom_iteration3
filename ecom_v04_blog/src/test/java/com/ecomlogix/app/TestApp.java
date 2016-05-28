package com.ecomlogix.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomlogix.ecom.config.RootContextConfiguration;
import com.ecomlogix.ecom.domain.Category;
import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.service.ItemService;

public class TestApp {

   public static final Logger LOGGER = LoggerFactory.getLogger(TestApp.class);

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.register(RootContextConfiguration.class);
      context.refresh();

      ItemService itemService = context.getBean(ItemService.class);

      Category category = itemService.getCategory(2L);
      LOGGER.info(category.getDescription());

      Item item = itemService.getItem(1L);
      LOGGER.info(item.getDescription());

      context.close();
   }
}
