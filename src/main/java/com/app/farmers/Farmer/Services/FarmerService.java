package com.app.farmers.Farmer.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farmers.Farmer.Models.Farmer;

import com.app.farmers.Farmer.Repositories.FarmerRepo;

@Service
public class FarmerService
{
    @Autowired
    FarmerRepo farmerRepo;
 

    public Farmer addFarmer(Farmer farmer)
    {
        try
        {
            return farmerRepo.save(farmer);
        }
        catch(Exception e)
        {
            System.out.println("Illegal data has been passed");
            return null;
        }
    }

    public String  removeFarmer(String userName)
    {
        try
        {
            Farmer tobeDeleted = farmerRepo.findByUserName(userName).get(0);
            farmerRepo.delete(tobeDeleted);
            return "deleted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    public String removeFarmers()
    {
        try
        {
            farmerRepo.deleteAll();
            return "Success";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

    public Farmer findByUserName(String userName)
    {
        try
        {
            Farmer farmer = farmerRepo.findByUserName(userName).get(0);
            return farmer;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    } 
}
