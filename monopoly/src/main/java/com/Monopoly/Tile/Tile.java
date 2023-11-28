package com.Monopoly.Tile;

import com.Monopoly.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tile {
    private String placeName;
    private String color;
    private int price;
    private ArrayList<Integer> tax;
    private int upgradeLvl;
    private int upgradeCost;
    private int tileNumber;
    private boolean isActive;
    private String specialEvent;
    private Player owner;


}
