package com.Monopoly.Monopoly.player;

public class Jail {
    public static void tryToGetOut(Player player){

        if(player.getCardsGettingOutOfJail()!=0){
            boolean wannaGoOut = false;
            if(wannaGoOut = true) {
                player.setCardsGettingOutOfJail(player.getCardsGettingOutOfJail() - 1);
                player.getOutOfJail(false);
            }
        }

        int firstNumber = 0;
        int secondNumber = 0;
        firstNumber = (int) ((Math.random() * (6)) + 1);
        secondNumber = (int) ((Math.random() * (6)) + 1);

        if(firstNumber == secondNumber){
            player.getOutOfJail(false);
        }else{
            player.setTimeInJail(player.getTimeInJail() - 1);
            if(player.getTimeInJail() == 0){
                player.getOutOfJail(true);
            }
        }
    }
}
