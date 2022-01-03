package com.project.api.service;

import com.project.api.model.DTO.ItemDTO;
import com.project.api.model.DTO.RealItemDTO;
import com.project.api.model.Item;
import com.project.api.model.RealItem;
import com.project.api.repository.ItemRepository;
import com.project.api.repository.RealItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealItemService {

    @Autowired
    RealItemRepository repository;

    /**
     * search all the active items
     *
     * @return all active items
     */
    public List<RealItem> getAllItems () {
        return repository.findAll();
    }

    /**
     * search for an active item by id
     * @param id the id of the item
     * @return the item
     */
    public Optional<RealItem> getItemByID (long id) {
        return repository.findById(id);
    }

    public void insertItem (ItemDTO itemDTO) {
        RealItem item = new RealItem();
        item.setActive(true);
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setPerishable(itemDTO.getPerishable());
        repository.save(item);
    }

    public void updateItem (ItemDTO itemDTO) {

    }

    /**
     * perform a logical deletion, setting the item to be inactive
     * @param id of the item
     */
    public void deleteItem(long id) {
        Optional<RealItem> item = repository.findById(id);
        item.get().setActive(false);
        repository.save(item.get());
    }

}
