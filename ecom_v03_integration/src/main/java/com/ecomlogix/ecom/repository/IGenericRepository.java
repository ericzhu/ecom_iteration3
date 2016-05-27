package com.ecomlogix.ecom.repository;

import java.io.Serializable;

import com.ecomlogix.ecom.domain.jpa.DomainEntity;

public interface IGenericRepository<ID extends Serializable, E extends DomainEntity> {

   public Iterable<E> getAll();

   public E get(ID id);

   public void add(E e);

   public void delete(E e);

   public void deleteById(ID id);
}
