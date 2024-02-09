package com.app.farmers.Farmer.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmer_table")
public class Farmer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long farmerId;
    private String userName;
    private String password;

    public Farmer()
    {

    }

    public Farmer(String userName, String password) {
     
        this.userName = userName;
        this.password = password;
    }


    public long getFarmerId() {
        return farmerId;
    }
    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
