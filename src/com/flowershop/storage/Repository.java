package com.flowershop.storage;

public class Repository {

    public static AdminRepository adrep = AdminRepository.getInstance();
    public static OrderRepository orderrep = OrderRepository.getInstance();
    public static CourierRepository manrep = CourierRepository.getInstance();
}