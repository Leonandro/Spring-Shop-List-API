package com.project.api.model.DTO;

public class RealItemDTO extends  ItemDTO{

    long listId;
    long itemId;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getListId() {
        return listId;
    }

    public  void setListId (long id) {
        this.listId = id;
    }


}
