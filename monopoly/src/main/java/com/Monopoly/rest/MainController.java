package com.Monopoly.rest;

import com.Monopoly.player.Player;
import com.Monopoly.player.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {
    final PlayerService playerService;
    final Player player;

    public MainController(PlayerService playerService, Player player) {
        this.playerService = playerService;
        this.player = player;
    }

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute(player);
        return "main";
    }
}
