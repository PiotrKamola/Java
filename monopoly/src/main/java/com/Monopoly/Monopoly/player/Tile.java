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
    private String ownerName;

    public static void chanceCard(){
//        Cards.pullChanceCard();   TODO
    }

    public static void communityCard(){
//        Cards.pullCommunityCard();   TODO
    }

    public static void goToJail(Player player){
        player.goToJail();
    }

    public static void payTax(int toPay, Player player){
        player.payMoney(toPay);
    }
}
