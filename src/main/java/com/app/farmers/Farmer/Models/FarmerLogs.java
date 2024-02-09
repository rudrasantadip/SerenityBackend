package com.app.farmers.Farmer.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "farmer-logs")
public class FarmerLogs 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flogId;

    private String errorType;
    private String errorMessage;
    private int errorCount=0;
    private String timeStamp;
    private long farmerId;
    private String farmerUsername;

    @Transient
    public static String [] errorTypes={"bad_credentials","dublicate_credentials"};

    

    public FarmerLogs() {
    }

    public FarmerLogs(String errorType, String errorMessage, long farmerId) {

        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.farmerId = farmerId;
        this.timeStamp=getCurrentTimeStamp();
    }

    

    public FarmerLogs(String errorType, String errorMessage, String farmerUsername) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.farmerUsername = farmerUsername;
        this.timeStamp=getCurrentTimeStamp();
    }

    
    public FarmerLogs(String errorType, String errorMessage, long farmerId,String farmerUsername) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.farmerId=farmerId;
        this.farmerUsername = farmerUsername;
        this.timeStamp=getCurrentTimeStamp();
    }

    public long getFlogId() {
        return flogId;
    }

    public void setFlogId(long flogId) {
        this.flogId = flogId;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getUserId() {
        return farmerId;
    }

    public void setUserId(long farmerId) {
        this.farmerId = farmerId;
    }

    public String[] getErrorTypes() {
        return errorTypes;
    }



    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(long farmerId) {
        this.farmerId = farmerId;
    }

    

    public String getFarmerUsername() {
        return farmerUsername;
    }

    public void setFarmerUsername(String farmerUsername) {
        this.farmerUsername = farmerUsername;
    }

    //Function to get the Current Timestamp
    private String getCurrentTimeStamp()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);
        return formattedDateTime;
    }
    
}
