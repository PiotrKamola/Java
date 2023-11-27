package com.Monopoly.Monopoly.Tile;

import com.Monopoly.Monopoly.game.Bank;
import com.Monopoly.Monopoly.player.Player;
import com.Monopoly.Monopoly.player.PlayerService;
import org.springframework.stereotype.Controller;

@Controller
public class TileService {
    private final Bank bank;

    TileService(Bank bank){
        this.bank = bank;
    }
    public static void chanceCard(){
//        Cards.pullChanceCard();   TODO
    }

    public static void communityCard(){
//        Cards.pullCommunityCard();   TODO
    }


    public void payTax(int toPay, Player player){
        bank.payMoney(player, toPay);

    }

    public void buyProperty(Player player, Tile tile){
        if(player.getMoney() < tile.getPrice()){
            System.out.println("You cannot afford that.");
//            player = this.startAuction(); TODO
        }else{
            tile.setActive(true);
            tile.setOwner(player);
            bank.payMoney(player, tile.getPrice());
            try{
                player.getOwnPlaces().add(tile);
            }catch (Exception e){
                System.out.println("Something went wrong when adding new place.");
            }
        }
    }

    private Player startAuction(){
        return null; //TODO
    }
}
