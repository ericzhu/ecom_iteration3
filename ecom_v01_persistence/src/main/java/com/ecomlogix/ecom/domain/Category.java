package com.ecomlogix.ecom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long       id;

   @Column(name = "name", length = 200)
   private String     name;

   @Column(name = "description", length = 2000)
   private String     description;

   @ManyToOne
   @JoinColumn(name="department_id")
   private Department department;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

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

   public Department getDepartment() {
      return department;
   }

   public void setDepartment(Department department) {
      this.department = department;
   }
}
