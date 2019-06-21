package com.flowershop.storage;

import com.flowershop.user.Courier;

import java.util.ArrayList;


public class CourierRepository {
    private static CourierRepository instance;
    private ArrayList<Courier> couriers =  new ArrayList<>();
    private CourierRepository(){}
    public static CourierRepository getInstance()
    {
        if(instance == null)
            instance = new CourierRepository();
        return instance;
    }

    public void addCourier(Courier courier)
    {
        couriers.add(courier);
    }
    public ArrayList<Courier> getCouriers()
    {
        return couriers;
    }


}