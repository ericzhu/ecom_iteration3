package com.ecomlogix.ecom.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ecomlogix.ecom.domain.jpa.DomainEntity;

@Entity
@Table(name = "ITEM")
public class Item extends DomainEntity {

   private static final long serialVersionUID = 1L;

   @Column(name = "name", length = 200)
   private String            name;

   @Column(name = "description", length = 2000)
   private String            description;

   @Column(name = "price")
   private BigDecimal        price;

   @Column(name = "discounted_price")
   private BigDecimal        discountedPrice;

   @Column(name = "image")
   private String            image;

   @Column(name = "image_2")
   private String            image2;

   @Column(name = "thumbnail")
   private String            thumbnail;

   @Column(name = "display")
   private Boolean           display          = Boolean.TRUE;

   @ManyToMany
   @JoinTable(name = "item_category", joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") )
   private Set<Category>     categories       = new HashSet<>();

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

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public BigDecimal getDiscountedPrice() {
      return discountedPrice;
   }

   public void setDiscountedPrice(BigDecimal discountedPrice) {
      this.discountedPrice = discountedPrice;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public String getImage2() {
      return image2;
   }

   public void setImage2(String image2) {
      this.image2 = image2;
   }

   public String getThumbnail() {
      return thumbnail;
   }

   public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
   }

   public Boolean getDisplay() {
      return display;
   }

   public void setDisplay(Boolean display) {
      this.display = display;
   }

   public Set<Category> getCategories() {
      return categories;
   }

   public void setCategories(Set<Category> categories) {
      this.categories = categories;
   }

   @Override
   public String toString() {
      return "Item [id="
         + getId()
         + ", name="
         + name
         + ", description="
         + description
         + ", price="
         + price
         + ", discountedPrice="
         + discountedPrice
         + ", image="
         + image
         + ", image2="
         + image2
         + ", thumbnail="
         + thumbnail
         + ", display="
         + display
         + "]";
   }
}
