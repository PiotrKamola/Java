package com.Monopoly.Tile;

import com.Monopoly.player.Player;
import com.Monopoly.player.PlayerService;

public class Jail {
    private final PlayerService playerService;

    public Jail(PlayerService playerService){
        this.playerService = playerService;
    }

    public void tryToGetOut(Player player){
        if(player.getCardsGettingOutOfJail()!=0){
            boolean wannaGoOut = false;
            if(wannaGoOut = true) {
                player.setCardsGettingOutOfJail(player.getCardsGettingOutOfJail() - 1);
                playerService.getOutOfJail(player,false);
            }
        }

        int firstNumber = 0;
        int secondNumber = 0;
        firstNumber = (int) ((Math.random() * (6)) + 1);
        secondNumber = (int) ((Math.random() * (6)) + 1);

        if(firstNumber == secondNumber){
            playerService.getOutOfJail(player,false);
        }else{
            player.setTimeInJail(player.getTimeInJail() - 1);
            if(player.getTimeInJail() == 0){
                playerService.getOutOfJail(player,true);
            }
        }
    }
}
