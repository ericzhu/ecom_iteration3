package com.ecomlogix.ecom.repository.jpa;

import org.springframework.stereotype.Repository;

import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.repository.IItemRepository;

@Repository
public class ItemRepository extends GenericBaseRepository<Long, Item> implements IItemRepository {
   
}
