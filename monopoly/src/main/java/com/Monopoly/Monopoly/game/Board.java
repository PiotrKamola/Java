package com.Monopoly.Monopoly.game;

import com.Monopoly.Monopoly.player.Tile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Board {
    public List<Tile> board = new ArrayList<>();
    private static final String TILES_PATH = "src/main/resources/data/tiles.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Tile> loadBoard() {
        try {
            return  Arrays.asList(objectMapper.readValue(Paths.get(TILES_PATH).toFile(), Tile[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
