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
    public List<ItemsList> finalAllLists() {
        return service.getAllLists();
    }

    @GetMapping(path = "/{id}")
    public ItemsList findListById(@PathVariable("id") long id) {
        return service.getListByID(id).get();
    }

    @PostMapping
    public void postList(@RequestBody ItemsListDTO listDTO) {
        service.insertItemsList(listDTO);
    }

    @PutMapping
    public void  putList(@RequestBody ItemsListDTO listDTO) { service.updateList(listDTO); }

    @DeleteMapping(path = "/{id}")
    public void deleteListById(@PathVariable("id")long id){
        service.deleteList(id);
    }


}
