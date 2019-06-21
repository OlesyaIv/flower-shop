package com.flowershop.businesslogic;
import java.util.ArrayList;

public class Order
{

    private int id;
    private float Cost;
    private ArrayList<Item> ItemList = new ArrayList<Item>();
    private Order_Status Status;
    private String Dostavka;

    public Order (int id, ArrayList<Item> list, String dostavka)
    {
        this.id=id;
        this.ItemList = list;
        this.Cost = Cost_calc();
        this.Dostavka = dostavka;
        this.Status = Order_Status.Obrabotka;
    }
    public float Cost_calc()
    {
        float cost=0;
        for (int i = 0; i < this.ItemList.size(); i++)
            cost+= this.ItemList.get(i).getItemPrice();
        return cost;
    }
    public float getOrderCost()
    {
        return Cost;
    }
    public int getOrderId()
    {
        return id;
    }
    public ArrayList<Item> getOrderList()
    {
        return ItemList;
    }
    public void setStatus(Order_Status status)
    {
        Status = status;
    }
}