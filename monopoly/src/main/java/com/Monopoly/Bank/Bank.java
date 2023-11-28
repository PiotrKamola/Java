package com.Monopoly.Bank;

import com.Monopoly.player.Player;
import org.springframework.stereotype.Controller;

@Controller
public class Bank {
    public void playerPaysPlayer(Player whoPays, Player toWho, int howMuch){
        System.out.println(whoPays.getName() +" pays "+ howMuch + " " +toWho.getName());
        whoPays.setMoney(whoPays.getMoney() - howMuch);
        toWho.setMoney(toWho.getMoney() + howMuch);
    }

    public void payMoneyToBank(Player player, int toPaid){
        System.out.println(player.getName() +" pays "+ toPaid + " to the bank.");
        player.setMoney(player.getMoney() - toPaid);
    }

    public void bankPays(Player player, int toGet){
        System.out.println("Bank pays "+ toGet + " to player " + player.getName() +".");
        player.setMoney(player.getMoney() + toGet);
    }
}
