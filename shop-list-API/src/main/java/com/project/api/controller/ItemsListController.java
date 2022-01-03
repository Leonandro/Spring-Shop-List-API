package com.project.api.controller;

import com.project.api.model.DTO.ItemsListDTO;
import com.project.api.model.ItemsList;
import com.project.api.service.ItemsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ItemsListController {
    @Autowired
    ItemsListService service;

    @GetMapping
    public List<ItemsList> finalAllItems() {
        return service.getAllLists();
    }

    @GetMapping(path = "/{id}")
    public ItemsList findItemById(@PathVariable("id") long id) {
        return service.getListByID(id).get();
    }

    @PostMapping
    public void postItem(@RequestBody ItemsListDTO listDTO) {
        service.insertItem(listDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteItemById(@PathVariable("id")long id){
        service.deleteList(id);
    }


}
