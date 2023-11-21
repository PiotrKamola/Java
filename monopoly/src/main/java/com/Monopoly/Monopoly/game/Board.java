package com.Monopoly.Monopoly.game;

import com.Monopoly.Monopoly.player.Player;
import com.Monopoly.Monopoly.player.Tile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Board {
    public static List<Tile> board = new ArrayList<>();
    private static final String TILES_PATH = "src/main/resources/data/tiles.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void loadBoard() {
        try {
            board = Arrays.asList(objectMapper.readValue(Paths.get(TILES_PATH).toFile(), Tile[].class));
        } catch (IOException e) {
            e.printStackTrace();
            board = Collections.emptyList();
        }
    }


    public void standOnTile(int number, Player player){
        Tile tile = board.get(number);
        if(tile.isActive()){
            if(!Objects.equals(tile.getSpecialEvent(), "")){
                String specialEvent = tile.getSpecialEvent();
                if(Objects.equals(specialEvent, "communityCard")){
                    System.out.println("Take Community Card");
                    Tile.communityCard();
                }else if("chanceCard".equals(specialEvent)){
                    System.out.println("Take Chance Card");
                    Tile.chanceCard();
                }else if("payTax".equals(specialEvent)){
                    System.out.println("Pay Tax");
                    Tile.payTax(tile.getTax().get(0), player);
                }else if("goToJail".equals(specialEvent)){
                    System.out.println("Go To Jail");
                    Tile.goToJail(player);
                }
            }

            if(tile.isActive() && !Objects.equals(tile.getOwnerName(), "")){
                player.payPlayer(player, player, tile.getTax().get(tile.getUpgradeLvl()));
            }
        }
    }
}
