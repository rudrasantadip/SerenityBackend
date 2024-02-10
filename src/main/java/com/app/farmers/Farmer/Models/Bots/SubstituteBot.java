package com.app.farmers.Farmer.Models.Bots;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="substitute-bot-table")
public class SubstituteBot 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subBotId;
    private String botJob;
    private String botName= SubstituteBot.generateCombination();
    private String botType;
    private boolean runStatus;


    public SubstituteBot() 
    {
        
    }


    public SubstituteBot(String botJob, String botType) {
        this.botJob = botJob;
        this.botType = botType;
        this.runStatus = true;
    }


    public long getSubBotId() {
        return subBotId;
    }


    public void setSubBotId(long subBotId) {
        this.subBotId = subBotId;
    }


    public String getBotJob() {
        return botJob;
    }


    public void setBotJob(String botJob) {
        this.botJob = botJob;
    }


    public String getBotName() {
        return botName;
    }


    public void setBotName(String botName) {
        this.botName = botName;
    }


    public String getBotType() {
        return botType;
    }


    public void setBotType(String botType) {
        this.botType = botType;
    }


    public boolean isRunStatus() {
        return runStatus;
    }


    public void setRunStatus(boolean runStatus) {
        this.runStatus = runStatus;
    }

    public static String generateCombination() {
        // Define characters to be used for generating combinations
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder combination = new StringBuilder();

        // Random object to generate random indices
        Random random = new Random();

        // Generate the combination of length 12
        for (int i = 0; i < 12; i++) {
            // Generate a random index within the range of characters string
            int randomIndex = random.nextInt(characters.length());
            // Append the character at the random index to the combination
            combination.append(characters.charAt(randomIndex));
        }

        return combination.toString();
    }
    

    
}
