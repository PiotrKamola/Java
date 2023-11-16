package com.Monopoly.Monopoly.game;

import com.Monopoly.Monopoly.player.Player;

public class Dice {
    public void throwDice(Player player){
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 0;
        int fourthNumber = 0;
        firstNumber = (int) ((Math.random() * (6)) + 1);
        secondNumber = (int) ((Math.random() * (6)) + 1);
//        move(firstNumber + secondNumber); TODO

        if(firstNumber == secondNumber) {
            thirdNumber = (int) ((Math.random() * (6)) + 1);
            fourthNumber = (int) ((Math.random() * (6)) + 1);
            if (thirdNumber == fourthNumber) {
                player.goToJail();
            }
//            move(thirdNumber + fourthNumber); TODO
        }
    }
}
