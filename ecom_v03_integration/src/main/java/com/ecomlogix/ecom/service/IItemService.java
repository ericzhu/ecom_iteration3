package com.ecomlogix.ecom.service;

import com.ecomlogix.ecom.domain.Category;
import com.ecomlogix.ecom.domain.Item;

public interface IItemService {
   
   public Item getItem(Long id);

   public Category getCategory(Long id);
}
