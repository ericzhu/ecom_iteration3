package com.ecomlogix.ecom.service.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.repository.jpa.ItemRepository;
import com.ecomlogix.ecom.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

   @Autowired
   private ItemRepository itemRepository;

   @Override
   public void save(Item item) {
      itemRepository.save(item);
   }

   @Override
   public List<Item> findAll() {
      return itemRepository.findAll();
   }

}
