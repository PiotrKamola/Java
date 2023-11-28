package com.Monopoly.player;

import com.Monopoly.Tile.Tile;
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
    private ArrayList<Tile> ownPlaces = new ArrayList<>();
    private boolean isInJail = false;
    private int timeInJail = 0;
    private int cardsGettingOutOfJail = 0;
    private int standTile = 0;
    private boolean isPlaying = true;

    public Player(String name){
        this.name = name;
    }



}


