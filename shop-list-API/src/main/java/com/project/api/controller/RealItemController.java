package com.project.api.controller;

import com.project.api.model.DTO.ItemDTO;
import com.project.api.model.RealItem;
import com.project.api.service.RealItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/real/item")
public class RealItemController {
    @Autowired
    RealItemService service;

    @GetMapping
    public List<RealItem> finalAllItems() {
        return service.getAllItems();
    }

    @GetMapping(path = "/{id}")
    public RealItem findItemById(@PathVariable("id") long id) {
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
