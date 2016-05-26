package com.ecomlogix.ecom.repository.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ecomlogix.ecom.config.DataConfiguration;
import com.ecomlogix.ecom.domain.jpa.DomainEntity;
import com.ecomlogix.ecom.repository.IGenericRepository;

public abstract class GenericBaseRepository<ID extends Serializable, E extends DomainEntity> implements IGenericRepository<ID, E> {

   @PersistenceContext(name = DataConfiguration.PERSISTENCE_UNIT_NAME)
   protected EntityManager entityManager;

   protected Class<ID>     idClass;

   protected Class<E>      entityClass;

   @SuppressWarnings({ "unchecked", "rawtypes" })
   public GenericBaseRepository() {
      Type genericSuperclass = this.getClass().getGenericSuperclass();
      while (!(genericSuperclass instanceof ParameterizedType)) {
         if (!(genericSuperclass instanceof Class))
            throw new IllegalStateException("Unable to determine type " + "arguments because generic superclass neither " + "parameterized type nor class.");
         if (genericSuperclass == GenericBaseRepository.class)
            throw new IllegalStateException("Unable to determine type " + "arguments because no parameterized generic superclass " + "found.");
         genericSuperclass = ((Class)genericSuperclass).getGenericSuperclass();
      }
      ParameterizedType type = (ParameterizedType)genericSuperclass;
      Type[] arguments = type.getActualTypeArguments();
      this.idClass = (Class<ID>)arguments[0];
      this.entityClass = (Class<E>)arguments[1];
   }

   @Override
   public Iterable<E> getAll() {

      CriteriaBuilder builder = entityManager.getCriteriaBuilder();
      CriteriaQuery<E> query = builder.createQuery(entityClass);
      Root<E> root = query.from(entityClass);
      query.select(root);
      return entityManager.createQuery(query).getResultList();
   }

   @Override
   public E get(ID id) {
      return entityManager.find(entityClass, id);
   }

   @Override
   public void add(E e) {

   }

   @Override
   public void delete(E e) {

   }

   @Override
   public void deleteById(ID id) {

   }

}
