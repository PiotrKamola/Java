package com.Monopoly.game;

import com.Monopoly.Bank.Bank;
import com.Monopoly.Tile.Tile;
import com.Monopoly.Tile.TileService;
import com.Monopoly.player.Player;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class BoardService {
    private final Bank bank;
    private final TileService tileService;
    private final CardsService cardsService;
    private final GameService gameService;

    public BoardService(Bank bank, TileService tileService, CardsService cardsService, GameService gameService){
        this.bank = bank;
        this.tileService = tileService;
        this.cardsService = cardsService;
        this.gameService = gameService;
    }

    public void standOnTile(int number, Player player) {
        Tile tile = gameService.board.get(number);

        if (tile.isActive()) {
            String specialEvent = tile.getSpecialEvent();
            if (Objects.equals(specialEvent, "communityCard")) {
                System.out.println("Take Community Card");
                cardsService.takeCard("communityCard", player);
            } else if ("chanceCard".equals(specialEvent)) {
                System.out.println("Take Chance Card");
                cardsService.takeCard("chanceCard", player);
            } else if ("payTax".equals(specialEvent)) {
                System.out.println("Pay Tax");
                tileService.payTax(tile.getTax().get(0), player);
            } else if ("goToJail".equals(specialEvent)) {
                System.out.println("Go To Jail");
                goToJail(player);
            } else if (!Objects.equals(tile.getOwner().getName(), "")) {
                System.out.println("Pay to player");
                bank.playerPaysPlayer(player, tile.getOwner(), tile.getTax().get(tile.getUpgradeLvl()));
            }
        } else if (Objects.equals(tile.getOwner().getName(), "") && tile.getPrice() > 0) {
            tileService.buyProperty(player, tile);
        }
    }

    public void goToJail(Player player){
        player.setStandTile(10);
        player.setInJail(true);
        player.setTimeInJail(3);
    }

}
