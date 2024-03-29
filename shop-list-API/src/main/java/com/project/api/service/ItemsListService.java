package com.project.api.service;

import com.project.api.exception.NoEntityFoundException;
import com.project.api.model.DTO.ItemDTO;
import com.project.api.model.DTO.ItemsListDTO;
import com.project.api.model.Item;
import com.project.api.model.ItemsList;
import com.project.api.repository.ItemsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsListService {

    @Autowired
    ItemsListRepository repository;

    /**
     * search all the actives lists of items
     *
     * @return all active lists
     */
    public List<ItemsList> getAllLists () {
        return repository.findAll();
    }

    /**
     * search for an active list by id
     * @param id the id of the list
     * @return the list
     */
    public Optional<ItemsList> getListByID (long id) {
        return repository.findById(id);
    }

    public void insertItemsList(ItemsListDTO listDTO) {
        ItemsList list = new ItemsList();
        list.setActive(true);
        list.setName(listDTO.getName());
        list.setTotalPrice(listDTO.getTotalPrice());
        repository.save(list);
    }

    public void updateList (ItemsListDTO listDTO) {
        Optional<ItemsList> list = repository.findById(listDTO.getId());
        if (!list.isPresent()) { throw  new NoEntityFoundException("The list with id={" + listDTO.getId() + "} was not found"); }
        list.get().setName(listDTO.getName());
        list.get().setTotalPrice(listDTO.getTotalPrice());
        // TODO allow the update of the items!!!
        //list.get().getItems(listDTO.getItems());
        repository.save(list.get());
    }

    /**
     * perform a logical deletion, setting the list to be inactive
     * @param id of the list
     */
    public void deleteList(long id) {
        Optional<ItemsList> list = repository.findById(id);
        list.get().setActive(false);
        repository.save(list.get());
    }
}
