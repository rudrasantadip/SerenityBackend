package com.app.farmers.Farmer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.farmers.Farmer.Models.Bots.PrimeBot;
import com.app.farmers.Farmer.Services.PrimeBotService;

@RestController
@RequestMapping("/prime")
public class PrimeBotController
{
    @Autowired
    private PrimeBotService pservice;

    
    
    @PostMapping("/createbot")
    public String createBot(@RequestBody PrimeBot bot)
    {
        PrimeBot pbot = pservice.createBot(bot);
        if(pbot!=null)
        {
            return pbot.getBotId()+" => "+pbot.getBotName()+" is up but dormant";
        }
        else
        {
            return null;
        }
    }

    @GetMapping("/run/{botName}")
    public ResponseEntity<String> runBot(@PathVariable("botName")String botName)
    {
        PrimeBot bot = pservice.run(botName);
        if(bot!=null)
        {
            return ResponseEntity.ok(bot.getBotName()+" is up and running.");
        }
        else
        {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/stop/{botName}")
    public ResponseEntity<String> stopBot(@PathVariable("botName")String botName)
    {
        PrimeBot bot = pservice.stop(botName);
        if(bot!=null)
        {
            return ResponseEntity.ok(bot.getBotName()+" is stopped.");
        }
        else
        {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/send-message/{botName}")
    public ResponseEntity<Object> sendMessage(@RequestParam("message") String message, @PathVariable("botName")String botName)
    {
        Object response = pservice.respond(message, botName);
        return ResponseEntity.ok(response);
    }
}
