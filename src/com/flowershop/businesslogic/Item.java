package com.flowershop.businesslogic;

public class Item {

    private String ItemName;
    private int id;
    private float price;
    private String category;
    private int quantity;

    public Item (String Name,String category, int id, float price,int quantity)
    {
        this.ItemName = Name;
        this.id = id;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getItemName()
    {
        return ItemName;
    }
    public void setItemName(String ItemName)
    {
        this.ItemName = ItemName;
    }
    public int getItemID()
    {
        return id;
    }
    public void setItemID(int id)
    {
        this.id = id;
    }
    public float getItemPrice()
    {
        return price;
    }
    public void setItemPrice(float price)
    {
        this.price = price;
    }
    public int getItemQuantity()
    {
        return quantity;
    }
    public void setItemQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

}