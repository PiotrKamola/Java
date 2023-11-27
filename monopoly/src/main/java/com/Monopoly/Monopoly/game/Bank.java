package com.Monopoly.Monopoly.game;

import com.Monopoly.Monopoly.player.Player;
import org.springframework.stereotype.Controller;

@Controller
public class Bank {
    public void playerPaysPlayer(Player whoPays, Player toWho, int howMuch){
        System.out.println(whoPays.getName() +" pays "+ howMuch + " " +toWho.getName());
        whoPays.setMoney(whoPays.getMoney() - howMuch);
        toWho.setMoney(toWho.getMoney() + howMuch);
    }

    public void payMoney(Player player, int toPaid){
        System.out.println(player.getName() +" pays "+ toPaid + " to the bank.");
        player.setMoney(player.getMoney() - toPaid);
    }
}
