package com.app.farmers.Farmer.Models.Bots;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prime_bots")
public class PrimeBot 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long botId;
    private String botName;
    private String botType;
    private String botJob;
    private boolean runStatus;

    
    public PrimeBot()
    {

    }

    public PrimeBot(long botId, String botName, String botType,String botJob, boolean runStatus) {
        this.botId = botId;
        this.botName = botName;
        this.botType = botType;
        this.botJob=botJob;
        this.runStatus = runStatus;
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

    

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public String getBotJob() {
        return botJob;
    }

    public void setBotJob(String botJob) {
        this.botJob = botJob;
    }

    @Override
    public String toString() {
        return "{\nbotId:" + botId + ",\nbotName:" + botName + ",\nbotType:" + botType + ",\nbotJob:" + botJob
                + ",\nrunStatus:" + runStatus + "\n}";
    }

    
    
}
