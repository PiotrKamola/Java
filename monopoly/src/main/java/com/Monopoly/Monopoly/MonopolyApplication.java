package com.Monopoly.Monopoly;

import com.Monopoly.Monopoly.game.Board;
import com.Monopoly.Monopoly.player.Tile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonopolyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonopolyApplication.class, args);
		for(Tile t : Board.loadBoard()){
			try {
				System.out.println(t.getTax().get(1));
			}catch (Exception e){
				System.out.println("x");
			}
		}
	}

}
