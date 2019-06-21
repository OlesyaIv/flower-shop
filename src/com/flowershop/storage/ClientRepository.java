package com.flowershop.storage;

import com.flowershop.user.Client;

import java.util.ArrayList;


public class ClientRepository {
    private static ClientRepository instance;
    private ArrayList<Client> Clients  =  new ArrayList<>();
    private ClientRepository(){}
    public static ClientRepository getInstance()
    {
        if(instance == null)
            instance = new ClientRepository();
        return instance;
    }

    public void addClient(Client client)
    {
        Clients.add(client);
    }
    public ArrayList<Client> getClients()
    {
        return Clients;
    }

}