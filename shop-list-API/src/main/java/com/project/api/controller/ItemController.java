package com.project.api.controller;

import com.project.api.model.DTO.ItemDTO;
import com.project.api.model.Item;
import com.project.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping
    public List<Item> finalAllItems() {
        return service.getAllItems();
    }

    @GetMapping(path = "/{id}")
    public Item findItemById(@PathVariable("id") long id) {
        return service.getItemByID(id).get();
    }

    @PostMapping
    public void postItem(@RequestBody ItemDTO itemDTO) {
        service.insertItem(itemDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteItemById(@PathVariable("id")long id){
        service.deleteItem(id);
    }
}
