package com.app.farmers.Farmer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.app.farmers.Farmer.Models.Farmer;
import com.app.farmers.Farmer.Models.FarmerLogs;
import com.app.farmers.Farmer.Repositories.FarmerLogRepo;
import com.app.farmers.Farmer.Services.FarmerService;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    //A variable for the farmer service class
    @Autowired
    FarmerService farmerService;
    @Autowired
    // A variable for the farmer repository class
    FarmerLogRepo farmerLogRepo;


    //Method for the new farmer registration
    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody Farmer farmer) //Takes in the farmer's json data
    {
        Farmer exists = farmerService.findByUserName(farmer.getUserName());
        if(exists==null) // Searches for the entity using username, to check if it is already present in the database
        {
            //Entity absent (no dublicates present)
            Farmer f = farmerService.addFarmer(farmer); // Farmer service is being called and the new entity is saved to the db
            if(f!=null)
            {
                //In case no error occurs in line 40 => addFarmer Method the entity is returned with an HTTP 200 :  success response
                return ResponseEntity.ok(0);
            }
            //Sending an http error response
            return new ResponseEntity<>(1,HttpStatus.EXPECTATION_FAILED);
        }
        //If Error encountered
            //Creating a log of the error encountered : ie dublicate user creation request
            FarmerLogs logs = new FarmerLogs(FarmerLogs.errorTypes[1], "data conflict: username exists", exists.getFarmerId(), exists.getUserName());
            int count = logs.getErrorCount();
            count++;
            logs.setErrorCount(count++);
            farmerLogRepo.save(logs);
            System.out.println("Log: "+logs.getTimeStamp());

        //Entity Absent
        return new ResponseEntity<>(1,HttpStatus.BAD_REQUEST);
       
    }

    @GetMapping("/login")
    public ResponseEntity<Integer> login(@RequestParam("username")String username, @RequestParam("password")String password)
    {
        //Looking for the farmer entity with the given username
        Farmer farmer=farmerService.findByUserName(username);
        FarmerLogs logs;
        if(farmer!=null) // If the entity is present
        {
            //Matching the password stored in the db and the password provided by the user
            if(farmer.getPassword().equals(password))
            {
                //If the passwords match, sending http 200 response => success
                return ResponseEntity.ok(0);
            }
            else
            {
                //In case the passwords do not match
                // Creating log of the error generated , ie wrong password provided
                logs = new FarmerLogs(FarmerLogs.errorTypes[0], "conflict: password does not match", farmer.getFarmerId(), farmer.getUserName());
                int count = logs.getErrorCount();
                count++;
                logs.setErrorCount(count);
                farmerLogRepo.save(logs);
                System.out.println(logs.getTimeStamp());

                //Returning http failure response NOT FOUND
                return new ResponseEntity<>(1,HttpStatus.NOT_FOUND);
            }
        }
        else
        {
            //Returning http not found status
            logs = new FarmerLogs(FarmerLogs.errorTypes[0], "conflict: user not found", 0, username);
            int count = logs.getErrorCount();
            count++;
            logs.setErrorCount(count);
            farmerLogRepo.save(logs);
            System.out.println(logs.getTimeStamp());
            return new ResponseEntity<Integer>(-1,HttpStatus.NOT_FOUND);
        }
    }
}
