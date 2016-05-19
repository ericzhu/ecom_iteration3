package com.ecomlogix.ecom.repository.jpa;

import java.util.List;

import com.ecomlogix.ecom.domain.Item;

public interface ItemRepository {
   
   public List<Item> findAll();

   public void save(Item item);
}
