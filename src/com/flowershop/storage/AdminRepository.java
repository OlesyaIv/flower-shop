package com.flowershop.storage;

import com.flowershop.user.Admin;

import java.util.ArrayList;


public class AdminRepository {
    private static AdminRepository instance;
    private ArrayList<Admin> admins =  new ArrayList<>();
    private AdminRepository(){}
    public static AdminRepository getInstance()
    {
        if(instance == null)
            instance = new AdminRepository();
        return instance;
    }

    public void addAdmin(Admin admin)
    {
        admins.add(admin);
    }
    public ArrayList<Admin> getAdmins()
    {
        return admins;
    }
    public Admin FindAdminstratorById(int id)
    {
        return admins.get(id-1);
    }
    public Admin FindAdminstratorForLogin(String name, String pass)
    {
        for (int i = 1; i <=admins.size(); i++)
        {   Admin admin= FindAdminstratorById(i);
            if ((admin.getFirstName().equals(name)) && (admin.getPass().equals(pass)))
            {
                return admin;
            }
            i++;
        }
        return null;
    }


}