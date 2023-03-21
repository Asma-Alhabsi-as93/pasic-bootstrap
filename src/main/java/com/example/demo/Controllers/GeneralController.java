package com.example.demo.Controllers;

import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value="g")
public class GeneralController {
        @Autowired
        SlackClient slackClient;

        @GetMapping(value = "test")
        public String test(){
            return "${spring.profiles.active}";
        }

        @GetMapping(value = "slackMessage")
        public void message(@RequestParam String text){
            slackClient.sendMessage(text);
        }


    }

