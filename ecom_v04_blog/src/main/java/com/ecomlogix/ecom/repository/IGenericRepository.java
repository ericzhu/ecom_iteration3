package com.ecomlogix.ecom.repository;

import java.io.Serializable;
import java.util.List;

import com.ecomlogix.ecom.domain.jpa.DomainEntity;

public interface IGenericRepository<ID extends Serializable, E extends DomainEntity> {

   public List<E> getAll();

   public E get(ID id);

   public void add(E e);

   public void delete(E e);

   public void deleteById(ID id);
}
