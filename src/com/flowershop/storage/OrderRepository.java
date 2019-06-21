package com.flowershop.storage;

import com.flowershop.businesslogic.Order;

import java.util.ArrayList;


public class OrderRepository {
    private static OrderRepository instance;
    private ArrayList<Order> orders  =  new ArrayList<>();
    private OrderRepository(){}
    public static OrderRepository getInstance()
    {
        if(instance == null)
            instance = new OrderRepository();
        return instance;
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }
    public ArrayList<Order> getOrders()
    {
        return  orders;
    }
    public  int getLastOrderId()
    {
        return  orders.size();
    }
    public Order FindOrderById(int id)
    {
        return orders.get(id-1);
    }



}