package com.Monopoly.Tile;

import com.Monopoly.Bank.Bank;
import com.Monopoly.player.Player;
import org.springframework.stereotype.Controller;

@Controller
public class TileService {
    private final Bank bank;

    TileService(Bank bank){
        this.bank = bank;
    }
    public void payTax(int toPay, Player player){
        bank.payMoneyToBank(player, toPay);
    }

    public void buyProperty(Player player, Tile tile){
        if(player.getMoney() < tile.getPrice()){
            System.out.println("You cannot afford that.");
//            player = this.startAuction(); TODO
        }else{
            tile.setActive(true);
            tile.setOwner(player);
            bank.payMoneyToBank(player, tile.getPrice());
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
