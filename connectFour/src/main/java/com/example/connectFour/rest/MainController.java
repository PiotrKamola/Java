package com.example.connectFour.rest;

import com.example.connectFour.game.Game;
import com.example.connectFour.game.MoveHelp;
import com.example.connectFour.game.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        int[] columnsTable = fillTable(game.getColumns());
        model.addAttribute("columns", columnsTable);
        return "main";
    }

    @PostMapping("")
    public String move(Model model, @ModelAttribute MoveHelp moveHelp) {

        model.addAttribute("table", gameService.getTable());
        model.addAttribute("moveHelp", moveHelp);
        int[] columnsTable = fillTable(game.getColumns());
        model.addAttribute("columns", columnsTable);

        if(gameService.makeMove(moveHelp.getColumn() - 1) != 0) {
            return returnWinner(model, gameService.checkWinner());
        }
        return "main";
    }

    public String returnWinner(Model model, @ModelAttribute int winner){
        model.addAttribute("winner", winner);
        return "winner";
    }

    @GetMapping("/clear")
    public String clearGame(Model model) {
        gameService.clearTable();
        model.addAttribute("table", gameService.getTable());
        int[] columnsTable = fillTable(game.getColumns());
        model.addAttribute("columns", columnsTable);
        return "main";
    }

    int[] fillTable(int columns){
        int[] helpArray = new int[columns];
        for(int i=0; i<columns; i++){
            helpArray[i] = i+1;
        }
        return helpArray;
    }

}
