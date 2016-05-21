package com.ecomlogix.ecom.service.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomlogix.ecom.domain.Category;
import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.repository.ICategoryRepository;
import com.ecomlogix.ecom.repository.IItemRepository;
import com.ecomlogix.ecom.service.IItemService;

@Service
@Transactional
public class ItemService implements IItemService {

   @Autowired
   private IItemRepository     itemRepository;

   @Autowired
   private ICategoryRepository categoryRepository;

   @Override
   public Item getItem(Long id) {
      return itemRepository.get(id);
   }

   @Override
   public Category getCategory(Long id) {
      return categoryRepository.get(id);
   }

}
