package com.flowershop.user;

import com.flowershop.businesslogic.Order;
import com.flowershop.businesslogic.Order_Status;
import com.flowershop.user.User;


public class Courier extends User {

    public Courier(String FirstName, String SurName, int id, String pass)
    {
        super(FirstName,SurName,id,pass);
    }
    public String getFirstName()
    {
        return FirstName;
    }
    public String getSurName()
    {
        return SurName;
    }
    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }
    public void setSurName(String SurName)
    {
        this.SurName = SurName;
    }
    public int getID ()
    {
        return id;
    }

    public  void setID (int id)
    {
        this.id=id;
    }
    public  String getPass ()
    {
        return password;
    }

    public  void setPass (String pass)
    {
        this.password=pass;
    }

    public void upd_order (Order order) {
        order.setStatus(Order_Status.DeliveredInProcess);
    }

    public void confirm_order (Order order) {
        order.setStatus(Order_Status.Delivered);
    }
}