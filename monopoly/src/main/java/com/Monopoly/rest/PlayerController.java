package com.Monopoly.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("player")
public class PlayerController {

    @GetMapping("createPlayers")
    public String createPlaters(){
        return "createPlayers";
    }
}
