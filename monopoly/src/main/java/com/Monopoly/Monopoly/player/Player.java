package com.Monopoly.Monopoly.player;

import com.Monopoly.Monopoly.game.Board;
import com.Monopoly.Monopoly.game.Dice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String name;
    private int money = 1500;
    private ArrayList<Tile> ownPlaces;
    private boolean isInJail = false;
    private int timeInJail = 0;
    private int cardsGettingOutOfJail = 0;
    private int standTile = 0;
    public Player(String name){
        this.name = name;
    }

    Board board = new Board();
    public void goToJail(){
        this.setStandTile(10);
        this.isInJail = true;
        this.timeInJail = 3;
    }

    public void getOutOfJail(boolean isPaid){
        if(isPaid){
            this.money = money-50;
        }
        this.isInJail = false;
        this.timeInJail = 0;
    }

    public void movePlayer(int numberOfTiles){
        this.standTile = this.standTile + numberOfTiles;
        if(this.standTile > 39){
            this.passStart();
            this.standTile = this.standTile - this.standTile /10*10;
        }
        board.standOnTile(this.standTile, this);
    }

    public void payMoney(int toPaid){
        this.setMoney(this.getMoney() - toPaid);
    }

    public void payPlayer(Player whoPaid, Player toWho, int howMuch){
        whoPaid.setMoney(whoPaid.getMoney() - howMuch);
        toWho.setMoney(toWho.getMoney() + howMuch);
    }

    public void passStart(){
        this.money = this.money + 200;
    }
}


