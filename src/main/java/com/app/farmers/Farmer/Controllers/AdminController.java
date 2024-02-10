package com.app.farmers.Farmer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.farmers.Farmer.Models.Admin;
import com.app.farmers.Farmer.Services.AdminService;

@RestController
@RequestMapping("/system")
@CrossOrigin("http://localhost:4200")
public class AdminController
{
    @Autowired
    AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody Admin admin)
    {
        Admin exists = adminService.getAdmin(admin.getUsername());
        if(exists==null)
        {
            adminService.createAdmin(admin);
            return ResponseEntity.ok(0); 
        }
        else
        {
            return new ResponseEntity<>(1, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Integer> login(@RequestParam("username") String userName, @RequestParam("password") String password)
    {
        Admin admin=adminService.getAdmin(userName);
        if(admin!=null)
        {
            if(admin.getPassword().equals(password))
            {
                return ResponseEntity.ok(0);
            }
            else
            {
                return ResponseEntity.badRequest().body(1);
            }
        }
        else
        {
            return new ResponseEntity<>(1,HttpStatus.BAD_REQUEST);
        }
    }
}
