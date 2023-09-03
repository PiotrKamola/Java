package com.example.connectFour.game;

import org.springframework.stereotype.Controller;

@Controller
public class GameService {

    private Game game = new Game();

    public int[][] getTable(){
        return game.getTable();
    }
}
