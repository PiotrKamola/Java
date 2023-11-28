package com.Monopoly.game;

import com.Monopoly.Tile.Tile;
import com.Monopoly.player.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<Player> playerList = new ArrayList<>();
    public List<Tile> board = new ArrayList<>();
    public List<CommunityCards> communityCards = new ArrayList<>();
    public List<ChanceCards> chanceCards = new ArrayList<>();

    private final String TILES_PATH = "src/main/resources/data/tiles.json";
    private final String COMMUNITY_CARDS_PATH = "src/main/resources/data/Community.json";
    private final String CHANCES_CARDS_PATH = "src/main/resources/data/Chances.json";

    public List<Tile> loadBoard() {
        try {
            board = Arrays.asList(objectMapper.readValue(Paths.get(TILES_PATH).toFile(), Tile[].class));
        } catch (IOException e) {
            e.printStackTrace();
            board = Collections.emptyList();
        }
        return board;
    }

    public List<CommunityCards> loadCommunityCards() {
        try {
            communityCards = Arrays.asList(objectMapper.readValue(Paths.get(COMMUNITY_CARDS_PATH).toFile(), CommunityCards[].class));
        } catch (IOException e) {
            e.printStackTrace();
            communityCards = Collections.emptyList();
        }
        Collections.shuffle(communityCards);
        return communityCards;
    }

    public List<ChanceCards> loadChanceCards() {
        try {
            chanceCards = Arrays.asList(objectMapper.readValue(Paths.get(CHANCES_CARDS_PATH).toFile(), ChanceCards[].class));
        } catch (IOException e) {
            e.printStackTrace();
            chanceCards = Collections.emptyList();
        }
        Collections.shuffle(chanceCards);
        return chanceCards;
    }
}
