package com.Monopoly.player;

import com.Monopoly.game.BoardService;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerService {
    private final BoardService boardService;

    public PlayerService(BoardService boardService) {
        this.boardService = boardService;
    }

    public void getOutOfJail(Player player, boolean isPaid) {
        if (isPaid) {
            player.setMoney(player.getMoney() - 50);
        }
        player.setInJail(false);
        player.setTimeInJail(0);
    }

    public void movePlayer(Player player, int numberOfTiles) {
        player.setStandTile(player.getStandTile() + numberOfTiles);
        if (player.getStandTile() > 39) {
            player.setMoney(player.getMoney() + 200);
            player.setStandTile(player.getStandTile() - player.getStandTile() / 10 * 10);
        }
        boardService.standOnTile(player.getStandTile(), player);
    }

    public void movePlayerToPlace(Player player, int whereToMove) {
        if (player.getStandTile() > whereToMove) {
            player.setMoney(player.getMoney() + 200);
        }
        player.setStandTile(whereToMove);
    }

    public void sendPlayerToJail(Player player) {
        boardService.goToJail(player);
    }

    public void rollDice(Player player) {
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 0;
        int fourthNumber = 0;
        firstNumber = (int) ((Math.random() * (6)) + 1);
        System.out.println("First dice: " + firstNumber);
        secondNumber = (int) ((Math.random() * (6)) + 1);
        System.out.println("Second dice: " + secondNumber);

        System.out.println("Total: " + (firstNumber + secondNumber));
        movePlayer(player, firstNumber + secondNumber);


        if (firstNumber == secondNumber) {
            System.out.println("You got double, throwing again.");
            thirdNumber = (int) ((Math.random() * (6)) + 1);
            System.out.println("Third dice: " + thirdNumber);
            fourthNumber = (int) ((Math.random() * (6)) + 1);
            System.out.println("Fourth dice: " + fourthNumber);
            System.out.println("Total: " + (thirdNumber + fourthNumber));
            if (thirdNumber == fourthNumber) {
                System.out.println("Second times double, you are goind to jail.");
                boardService.goToJail(player);
            } else {
                movePlayer(player, thirdNumber + fourthNumber);
            }
        }
    }
}
