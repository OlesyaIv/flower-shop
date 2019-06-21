package com.flowershop.user;

import com.flowershop.businesslogic.Item;
import com.flowershop.businesslogic.Order;
import com.flowershop.storage.OrderRepository;

import java.util.ArrayList;


public class Client extends User
{

    private String TeleNumber;
    private String Email;

    public Client (String FirstName, String SurName,int id, String TeleNumber, String Email, String pass)
    {
        super(FirstName,SurName,id,pass);
        this.TeleNumber = TeleNumber;
        this.Email = Email;
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
    public String getTNumber()
    {
        return TeleNumber;
    }
    public void setTNumber(String TNumber)
    {
        this.TeleNumber = TNumber;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String Email)
    {
        this.Email = Email;
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

    public Order CreateOrder (ArrayList<Item> list, String dostavka)
    {
        int id = OrderRepository.getInstance().getLastOrderId();
        return new Order(id, list, dostavka);
    }
}