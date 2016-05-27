package com.ecomlogix.ecom.service.spring;

import javax.inject.Inject;

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

   @Inject
   private IItemRepository     itemRepository;

   @Inject
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
