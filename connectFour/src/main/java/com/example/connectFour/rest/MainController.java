package com.example.connectFour.rest;

import com.example.connectFour.game.Game;
import com.example.connectFour.game.MoveHelp;
import com.example.connectFour.game.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class MainController {

    final GameService gameService;
    final Game game;

    public MainController(GameService gameService, Game game) {
        this.gameService = gameService;
        this.game = game;
    }

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("table", gameService.getTable());
        model.addAttribute("moveHelp", new MoveHelp());
        return "main";
    }

    @PostMapping("")
    public String move(Model model, @ModelAttribute MoveHelp moveHelp) {

        model.addAttribute("table", gameService.getTable());
        model.addAttribute("moveHelp", moveHelp);

        if(gameService.makeMove(moveHelp.getColumn() - 1) != 0) {
            return "winner";
        }
        return "main";
    }
}
