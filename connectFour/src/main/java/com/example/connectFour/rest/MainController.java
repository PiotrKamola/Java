package com.example.connectFour.rest;

import com.example.connectFour.game.Game;
import com.example.connectFour.game.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")
public class MainController {

    final GameService gameService;

    public MainController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("table", gameService.getTable());
        return "main";
    }

    @PostMapping("")
    public String move(Model model) {
        model.addAttribute("table", gameService.getTable());
        return "main";
    }
}
