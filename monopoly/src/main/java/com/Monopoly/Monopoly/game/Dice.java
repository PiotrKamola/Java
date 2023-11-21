package com.Monopoly.Monopoly.game;

import com.Monopoly.Monopoly.player.Player;

public class Dice {
    public void throwDice(Player player){
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 0;
        int fourthNumber = 0;
        firstNumber = (int) ((Math.random() * (6)) + 1);
        System.out.println("First dice: "+firstNumber);
        secondNumber = (int) ((Math.random() * (6)) + 1);
        System.out.println("Second dice: "+secondNumber);

        System.out.println("Total: "+(firstNumber+secondNumber));
        player.movePlayer(firstNumber + secondNumber);


        if(firstNumber == secondNumber) {
            System.out.println("You got double, throwing again.");
            thirdNumber = (int) ((Math.random() * (6)) + 1);
            System.out.println("Third dice: "+thirdNumber);
            fourthNumber = (int) ((Math.random() * (6)) + 1);
            System.out.println("Fourth dice: "+fourthNumber);
            System.out.println("Total: "+(thirdNumber+fourthNumber));
            if (thirdNumber == fourthNumber) {
                System.out.println("Second times double, you are goind to jail.");
                player.goToJail();
            }else{
                player.movePlayer(thirdNumber + fourthNumber);
            }
        }
    }
}
