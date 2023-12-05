package com.Monopoly.game;

import com.Monopoly.Bank.Bank;
import com.Monopoly.player.Player;
import com.Monopoly.player.PlayerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardsService {
    private final PlayerService playerService;
    private final GameService gameService;
    private final Bank bank;

    public CardsService(PlayerService playerService, Bank bank, GameService gameService) {
        this.playerService = playerService;
        this.bank = bank;
        this.gameService = gameService;
    }

    public void takeCard(String cardType, Player player) {
        if (cardType.equals("communityCard")) {
            this.takeCommunityCard(player);
        } else if (cardType.equals("chanceCard")) {
            takeChanceCard(player);
        }
    }

    private void takeCommunityCard(Player player) {
        CommunityCards cardTaken = gameService.communityCards.get(0);
        switch (cardTaken.getAction()) {
            case "moveTo":
                playerService.movePlayerToPlace(player, cardTaken.getMoneyValue());
                break;
            case "getMoney":
                bank.bankPays(player, cardTaken.getMoneyValue());
                break;
            case "payMoney":
                bank.payMoneyToBank(player, cardTaken.getMoneyValue());
                break;
            case "getOutOfJailCard":
                player.setCardsGettingOutOfJail(player.getCardsGettingOutOfJail() + 1);
                break;
            case "goToJail":
                playerService.sendPlayerToJail(player);
                break;
            case "getMoneyFromAll":
                for(Player p : gameService.playerList){
                    if(!p.equals(player)){
                        bank.playerPaysPlayer(p, player, cardTaken.getMoneyValue());
                    }
                }
                break;
            default:
                System.out.println("Something is wrong.");
                break;
        }
        for(int i=0; i<16; i++){
            Collections.swap(gameService.communityCards, i, i+1);
        }

    }

    private void takeChanceCard(Player player) {
        ChanceCards cardTaken = gameService.chanceCards.get(0);
        switch (cardTaken.getAction()) {
            case "moveTo":
                playerService.movePlayerToPlace(player, cardTaken.getValue());
                break;
            case "getMoney":
                bank.bankPays(player, cardTaken.getValue());
                break;
            case "payMoney":
                bank.payMoneyToBank(player, cardTaken.getValue());
                break;
            case "getOutOfJailCard":
                player.setCardsGettingOutOfJail(player.getCardsGettingOutOfJail() + 1);
                break;
            case "goToJail":
                playerService.sendPlayerToJail(player);
                break;
            case "payEachPlayer":
                for(Player p : gameService.playerList){
                    if(!p.equals(player)){
                        bank.playerPaysPlayer(player, p, cardTaken.getValue());
                    }
                }
                break;
            case "moveToNearRailroad":
                if(player.getStandTile()>35){
                    playerService.movePlayerToPlace(player, 5);
                }else {
                    for (int i = player.getStandTile(); i < 39; i++) {
                        if (gameService.board.get(i).getColor().equals("Railroad")) {
                            playerService.movePlayerToPlace(player, i);
                        }
                    }
                }
                break;
            case "moveToNearUtility":
                if(player.getStandTile()>28){
                    playerService.movePlayerToPlace(player, 12);
                }else {
                    for (int i = player.getStandTile(); i < 39; i++) {
                        if (gameService.board.get(i).getColor().equals("Utility")) {
                            playerService.movePlayerToPlace(player, i);
                        }
                    }
                }
                break;
            case "moveSpaces":
                if(player.getStandTile()>4){
                    playerService.movePlayer(player, -3);
                }else{
                    playerService.movePlayerToPlace(player, 40 - 3 - player.getStandTile());
                }
                break;
            default:
                System.out.println("Something is wrong.");
                break;
        }
        for(int i=0; i<16; i++){
            Collections.swap(gameService.chanceCards, i, i+1);
        }
    }
}
