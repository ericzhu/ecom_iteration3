package com.ecomlogix.ecom.repository.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ecomlogix.ecom.config.DataConfiguration;
import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.repository.jpa.ItemRepository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

   @PersistenceContext(name = DataConfiguration.PERSISTENCE_UNIT_NAME)
   protected EntityManager entityManager;

   @Override
   public List<Item> findAll() {
      String jpql = "select i from Item i";
      return entityManager.createQuery(jpql, Item.class).getResultList();
   }

   @Override
   public void save(Item item) {
      entityManager.persist(item);
   }

}
