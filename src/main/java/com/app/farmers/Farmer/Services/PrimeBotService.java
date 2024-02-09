package com.app.farmers.Farmer.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farmers.Farmer.Models.Bots.PrimeBot;
import com.app.farmers.Farmer.Repositories.PrimeBotRepo;

@Service
public class PrimeBotService
{
    @Autowired
    private PrimeBotRepo primeBotRepo;

    public PrimeBot createBot(PrimeBot bot)
    {
        if(bot!=null)
        {
            return primeBotRepo.save(bot);
        }
        return null;
    }

    public PrimeBot run(String botname)
    {
        try
        {
            PrimeBot bot = primeBotRepo.findByBotName(botname).get(0);
            bot.setRunStatus(true);
            return primeBotRepo.save(bot);
        }
        catch(Exception e)
        {
            return null;
        }
    } 

    public PrimeBot stop(String botname)
    {
        try
        {
            PrimeBot bot = primeBotRepo.findByBotName(botname).get(0);
            bot.setRunStatus(false);
            return primeBotRepo.save(bot);
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public Object respond(String query, String botName)
    {
        PrimeBot pbot = primeBotRepo.findByBotName(botName).get(0);
        String job = pbot.getBotJob();
        String message;
        if(query.equals("status"))
        {
            return (PrimeBot)status(pbot.getBotId());
        }
        else
        {
            message="hii,I "+ pbot.getBotName() +" am here to help. My job is "+job;
            return (String)message;
        }
    }

    public PrimeBot status(long botId)
    {
        PrimeBot bot = primeBotRepo.findById(botId).get();
        if(bot!=null)
        {
            return bot;
        }
        return null;
    }
}
