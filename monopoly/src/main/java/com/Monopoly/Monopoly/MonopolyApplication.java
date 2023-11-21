package com.Monopoly.Monopoly;

import com.Monopoly.Monopoly.game.Board;
import com.Monopoly.Monopoly.game.Dice;
import com.Monopoly.Monopoly.player.Player;
import com.Monopoly.Monopoly.player.Tile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonopolyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonopolyApplication.class, args);
		Dice dice = new Dice();
		Board.loadBoard();
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		Player player3 = new Player("Player3");
		Player player4 = new Player("Player4");

//		System.out.println(player1.getStandTile());
		player1.setStandTile(0);
		player1.movePlayer(2);
		player1.movePlayer(2);
		player1.movePlayer(3);
		player1.movePlayer(10);
		player1.movePlayer(5);
		player1.movePlayer(8);
//		System.out.println(player1.getStandTile());
//		dice.throwDice(player1);
//		System.out.println(player1.getStandTile());
	}

}
