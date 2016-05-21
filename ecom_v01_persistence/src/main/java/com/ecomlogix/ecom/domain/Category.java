package com.ecomlogix.ecom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecomlogix.ecom.domain.jpa.DomainEntity;

@Entity
@Table(name = "CATEGORY")
public class Category extends DomainEntity {

   private static final long serialVersionUID = 1L;

   @Column(name = "name", length = 200)
   private String            name;

   @Column(name = "description", length = 2000)
   private String            description;

   @ManyToOne
   @JoinColumn(name = "parent_id")
   private Category          parent;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Category getParent() {
      return parent;
   }

   public void setParent(Category parent) {
      this.parent = parent;
   }
}
