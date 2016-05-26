package com.ecomlogix.ecom.repository.jpa;

import org.springframework.stereotype.Repository;

import com.ecomlogix.ecom.domain.Category;
import com.ecomlogix.ecom.repository.ICategoryRepository;

@Repository
public class CategoryRepository extends GenericBaseRepository<Long, Category> implements ICategoryRepository{

}
