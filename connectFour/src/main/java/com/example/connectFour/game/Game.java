package com.example.connectFour.game;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Game {
    private int whoTurn = 1;
    private int winner = 0;
    private int rows=6;
    private int columns=7;
    private int[][] table = new int[rows][columns];

    public int getWhoTurn() {
        return whoTurn;
    }

    public void setWhoTurn(int whoTurn) {
        this.whoTurn = whoTurn;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
}
