package com.app.farmers.Farmer.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farmers.Farmer.Models.Admin;
import com.app.farmers.Farmer.Repositories.AdminRepo;

@Service
public class AdminService
{
    @Autowired
    AdminRepo adminRepo;

    public Admin createAdmin(Admin admin)
    {
       return adminRepo.save(admin);
    }

    public Admin getAdmin(String userName)
    {
        List<Admin> admins = adminRepo.findByUsername(userName);
        try
        {
            Admin admin = admins.get(0);
            return admin;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
