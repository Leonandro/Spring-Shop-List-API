package com.project.api.service;

import com.project.api.exception.DifferentRealItemException;
import com.project.api.exception.NoEntityFoundException;
import com.project.api.model.DTO.ItemDTO;
import com.project.api.model.DTO.RealItemDTO;
import com.project.api.model.Item;
import com.project.api.model.ItemsList;
import com.project.api.model.RealItem;
import com.project.api.repository.ItemRepository;
import com.project.api.repository.ItemsListRepository;
import com.project.api.repository.RealItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealItemService {

    @Autowired
    RealItemRepository repository;

    @Autowired
    ItemsListRepository itemsListRepository;

    @Autowired
    ItemRepository itemRepository;

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

    /**
     * insert a real item on the database
     * @param realItemDTO the
     */
    public void insertItem (RealItemDTO realItemDTO) {
        RealItem realItem = new RealItem();
        realItem.setActive(true);
        realItem.setName(realItemDTO.getName());
        realItem.setPrice(realItemDTO.getPrice());
        realItem.setPerishable(realItemDTO.getPerishable());

        Optional<ItemsList> itemsList = itemsListRepository.findById(realItemDTO.getListId());
        Optional<Item> baseItem = itemRepository.findById(realItemDTO.getItemId());

        if (!itemsList.isPresent()) { throw new NoEntityFoundException("The List with id={" + realItemDTO.getListId() +"} was not found"); }
        if (!baseItem.isPresent()) { throw new NoEntityFoundException("The Base Item with id={" + realItemDTO.getItemId() +"} was not found"); }
        //if (!baseItem.get().isCompatibleWith(realItemDTO)) { throw  new DifferentRealItemException("The Real Item has several differences with the base item"); }

        realItem.setList(itemsList.get());
        realItem.setItem(baseItem.get());

        repository.save(realItem);
    }

    public void updateItem (RealItemDTO realItemDTOtemDTO) {
        Optional<RealItem> item = repository.findById(realItemDTOtemDTO.getId());
        if (!item.isPresent()) { throw  new NoEntityFoundException("The item with id={" + realItemDTOtemDTO.getId() + "} was not found"); }
        item.get().setName(realItemDTOtemDTO.getName());
        item.get().setPrice(realItemDTOtemDTO.getPrice());
        item.get().setPerishable(realItemDTOtemDTO.getPerishable());
        //TODO allow the update of the list and the item that the real list is related
        repository.save(item.get());
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
