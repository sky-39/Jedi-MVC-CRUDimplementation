package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public Item getItemById(int id){
        return itemRepository.findById(id).get();
    }

    public void saveOrUpdate(Item item){
        itemRepository.save(item);
    }

    public void delete(int id){
        itemRepository.deleteById(id);
    }

    public void update(Item item, int id){
        itemRepository.save(item);
    }
}
