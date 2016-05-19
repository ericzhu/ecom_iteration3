package com.ecomlogix.ecom.service;

import java.util.List;

import com.ecomlogix.ecom.domain.Item;

public interface ItemService {
   public void save(Item item);

   public List<Item> findAll();
}
