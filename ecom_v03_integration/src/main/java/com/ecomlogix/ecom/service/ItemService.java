package com.ecomlogix.ecom.service;

import java.util.List;

import com.ecomlogix.ecom.domain.Category;
import com.ecomlogix.ecom.domain.Item;

public interface ItemService {

   public Item getItem(Long id);

   public Category getCategory(Long id);

   public List<Item> findAllItems();
}
