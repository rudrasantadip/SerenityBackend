package com.app.farmers.Farmer.Services;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farmers.Farmer.Models.Bots.PrimeBot;
import com.app.farmers.Farmer.Repositories.PrimeBotRepo;

@Service
public class PrimeBotService
{
    @Autowired
    private PrimeBotRepo primeBotRepo;
    private static String jobs[]={"init","status","create","remove","start","stop"};

    /* each command must be followed by a single space
     *  init <primebot-name>
     *  status <primebot-name>
     *  create <subbot-name>
     *  remove <subbot-name>
     *  start <primebot-name | subbot-name>
     *  stop <primebot-name | subbot-name>
     */

    public PrimeBot createBot(PrimeBot bot)
    {
        if(bot!=null)
        {
            return primeBotRepo.save(bot);
        }
        return null;
    }

    public List<PrimeBot> getallBots()
    {
        List<PrimeBot> primeBots = primeBotRepo.findAll();
        if(primeBots!=null)
        {
            return primeBots;
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
    
    public String respond(String query)
    {
        //Parse the message into space seperated words and store them in the array list
        List<String> parsedMessage = new ArrayList<>(Arrays.asList(query.split(" ")));

        if(parsedMessage.get(0).equals(jobs[0]))
        {
            try
            {
                /*
                 * call the service find the bot by the name; extract the name of the bot and store it in the string.
                 */

                String botName = primeBotRepo.findByBotName(parsedMessage.get(1).toUpperCase()).get(0).getBotName();
                return botName +" is initialized.";
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return "No such bot exists";
            }
        }
        else if(parsedMessage.get(0).equals(jobs[1]))
        {
            try
            {
                PrimeBot botName = primeBotRepo.findByBotName(parsedMessage.get(1).toUpperCase()).get(0);
                return botName.toString();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return "no such bot exists.";
            }
        }
        else if(parsedMessage.get(0).equals(jobs[2]))
        {
            return "creation has started";
        }
        else if(parsedMessage.get(0).equals(jobs[3]))
        {
            return "creation has started";
        }
        else if(parsedMessage.get(0).equals(jobs[4]))
        {
            try
            {
                /*
                 * call the service find the bot by the name; extract the name of the bot and store it in the string.
                 */

                String botName = primeBotRepo.findByBotName(parsedMessage.get(1).toUpperCase()).get(0).getBotName();
                String response = run(botName).getBotName();
                return response +" is up and running";
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return "No such bot exists";
            }
        }
        else if(parsedMessage.get(0).equals(jobs[5]))
        {
            try
            {
                /*
                 * call the service find the bot by the name; extract the name of the bot and store it in the string.
                 */

                String botName = primeBotRepo.findByBotName(parsedMessage.get(1).toUpperCase()).get(0).getBotName();
                String response = stop(botName).getBotName();
                return response +" is down now";
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return "No such bot exists";
            }
        }
        else
        {
            return null;
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
