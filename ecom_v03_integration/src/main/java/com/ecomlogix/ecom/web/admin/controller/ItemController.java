package com.ecomlogix.ecom.web.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomlogix.ecom.domain.Item;
import com.ecomlogix.ecom.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

   @Inject
   ItemService itemService;

   @RequestMapping(method = RequestMethod.GET)
   public String list() {
      List<Item> items = itemService.findAllItems();
      System.out.println(items.size());
      return "itemList";
   }

   @RequestMapping(value = "/{id}")
   public String getById(@PathVariable("id") Long id, Model model) {
      Item item = itemService.getItem(id);
      model.addAttribute("item", item);
      return "itemDetail";
   }
}
