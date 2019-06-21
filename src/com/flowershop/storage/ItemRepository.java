package com.flowershop.storage;

import com.flowershop.businesslogic.Item;

import java.util.ArrayList;

public class ItemRepository {
    private static ItemRepository instance;
    private ArrayList<Item> Items  =  new ArrayList<>();
    private ItemRepository(){}
    public static ItemRepository getInstance()
    {
        if(instance == null)
            instance = new ItemRepository();
        return instance;
    }

    public void addProduct(Item item)
    {
        Items.add(item);
    }
    public void decreaseQuantityItem(Item item)
    {
        item.setItemQuantity(item.getItemQuantity()-1);
    }
    public void increaseQuantityItem(Item item)
    {
        item.setItemQuantity(item.getItemQuantity()+1);
    }
    public ArrayList<Item> getItems()
    {
        return Items;
    }
}