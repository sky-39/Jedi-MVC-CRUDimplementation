package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    private List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/item/{id}")
    private Item getItem(@PathVariable("id") int id){
        return itemService.getItemById(id);
    }

    @DeleteMapping("item/{id}")
    private void deleteItem(@PathVariable("id") int id){
        itemService.delete(id);
    }

    @PostMapping("/item")
    private int saveItem(@RequestBody Item item){
        itemService.saveOrUpdate(item);
        return item.getId();
    }

    @PutMapping("/item")
    private Item update(@RequestBody Item item){
        itemService.saveOrUpdate(item);
        return item;
    }
}
