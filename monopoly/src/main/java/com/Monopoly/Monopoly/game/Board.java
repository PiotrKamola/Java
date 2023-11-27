package com.Monopoly.Monopoly.game;

import com.Monopoly.Monopoly.Tile.Tile;
import com.Monopoly.Monopoly.Tile.TileService;
import com.Monopoly.Monopoly.player.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class Board {
    private final Bank bank;
    private final TileService tileService;
    public static List<Tile> board = new ArrayList<>();
    private static final String TILES_PATH = "src/main/resources/data/tiles.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Board(Bank bank, TileService tileService){
        this.bank = bank;
        this.tileService = tileService;
    }

    public static List<Tile> loadBoard() {
        try {
            board = Arrays.asList(objectMapper.readValue(Paths.get(TILES_PATH).toFile(), Tile[].class));
        } catch (IOException e) {
            e.printStackTrace();
            board = Collections.emptyList();
        }
        return board;
    }

    public void standOnTile(int number, Player player) {
        Tile tile = board.get(number);

        if (tile.isActive()) {
            String specialEvent = tile.getSpecialEvent();
            if (Objects.equals(specialEvent, "communityCard")) {
                System.out.println("Take Community Card");
                tileService.communityCard();
            } else if ("chanceCard".equals(specialEvent)) {
                System.out.println("Take Chance Card");
                tileService.chanceCard();
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
