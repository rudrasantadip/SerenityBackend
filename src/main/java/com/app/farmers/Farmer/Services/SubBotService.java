package com.app.farmers.Farmer.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farmers.Farmer.Models.Bots.SubstituteBot;
import com.app.farmers.Farmer.Repositories.SubBotRepo;

@Service
public class SubBotService 
{
    @Autowired
    private SubBotRepo subBotRepo;

    public SubstituteBot addSubBot(SubstituteBot substituteBot)
    {
        if(substituteBot!=null)
        {
            return subBotRepo.save(substituteBot);
        }
        return null;
    }

    public List<SubstituteBot> getAllSubBots()
    {
        List<SubstituteBot> substituteBots = subBotRepo.findAll();
        if(substituteBots!=null)
        {
            return substituteBots;
        }
        return null;
    }

    public SubstituteBot getBotbyId(long id)
    {
        try
        {
            SubstituteBot substituteBot = subBotRepo.findById(id).get();
            return substituteBot;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public SubstituteBot getBotByName(String botName)
    {
        try
        {
            SubstituteBot subbot = subBotRepo.findByBotName(botName).get(0);
            return subbot;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public SubstituteBot deleteBot(SubstituteBot sBot)
    {
        if(sBot!=null)
        {
            subBotRepo.deleteById(sBot.getSubBotId());
            return sBot;
        }
        return null;
    }

    public SubstituteBot run(long id)
    {
        try
        {
            SubstituteBot substituteBot = subBotRepo.findById(id).get();
            substituteBot.setRunStatus(true);
            return subBotRepo.save(substituteBot);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public SubstituteBot stop(long id)
    {
        try
        {
            SubstituteBot substituteBot = subBotRepo.findById(id).get();
            substituteBot.setRunStatus(false);
            return subBotRepo.save(substituteBot);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
