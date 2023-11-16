package com.Monopoly.Monopoly.player;

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

    public void goToJail(){
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
}


