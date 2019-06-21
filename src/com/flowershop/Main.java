package com.flowershop;

import com.flowershop.businesslogic.Order;
import com.flowershop.gui.UserMenu;
import com.flowershop.storage.Repository;
import com.flowershop.user.Admin;
import com.flowershop.user.Courier;

import java.util.ArrayList;

public class Main {

    public  static void main(String[] args) {

        Repository.orderrep.addOrder(new Order(1, new ArrayList<>(), "доставить по адресу 123"));
        Repository.orderrep.addOrder(new Order(2, new ArrayList<>(), "заберут сами"));
        Repository.adrep.addAdmin(new Admin("admin", "admin", 1, "admin"));
        Repository.manrep.addCourier(new Courier("1", "1", 1, "1"));
        Repository.manrep.addCourier(new Courier("2", "2", 2, "2"));
        new UserMenu().setVisible(true);
    }

}