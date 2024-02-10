package com.app.farmers.Farmer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.farmers.Farmer.Models.Bots.SubstituteBot;
import com.app.farmers.Farmer.Services.SubBotService;

@RestController
@RequestMapping("sub")
@CrossOrigin("http://localhost:4200")
public class SubBotController
{
    @Autowired
    private SubBotService subBotService;

    @PostMapping("/create-bot")
    public SubstituteBot createBot(@RequestBody SubstituteBot bot)
    {
        SubstituteBot sBot=subBotService.addSubBot(bot);
        if(sBot!=null)
        {
            return sBot;
        }
        return null;
    }
    
    @GetMapping("/delete-bot")
    public SubstituteBot deleteBot(@RequestBody SubstituteBot substituteBot)
    {
        SubstituteBot success =subBotService.deleteBot(substituteBot);
        if(success!=null)
        {
            return success;
        }
        return null;
    }

    @GetMapping("/get-all-sub-bots")
    public List<SubstituteBot> allSubBots()
    {

        List<SubstituteBot> substituteBots = subBotService.getAllSubBots();
        if(substituteBots!=null)
        {
            return substituteBots;
        }
        return null;
    }

    @GetMapping("/run")
    public SubstituteBot runBot(@RequestParam("botId") long id)
    {
        SubstituteBot sBot = subBotService.run(id);
        if(sBot!=null)
        {
            return sBot;
        }
        return null;
    }

    @GetMapping("/stop")
    public SubstituteBot stopBot(@RequestParam("botId") long id)
    {
        SubstituteBot sBot = subBotService.run(id);
        if(sBot!=null)
        {
            return sBot;
        }
        return null;
    }


}
