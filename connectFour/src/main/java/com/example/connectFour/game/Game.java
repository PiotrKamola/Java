package com.example.connectFour.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int whoTurn;
    int rows=6;
    int columns=7;
    int[][] table = new int[rows][columns];

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

    public void makeMove(int column){
        boolean isFull = false;
        if(table[0][column] != whoTurn){
            table[0][column] = whoTurn;
        }else if(table[1][column] != whoTurn){
            table[1][column] = whoTurn;
        }else if(table[2][column] != whoTurn){
            table[2][column] = whoTurn;
        }else if(table[3][column] != whoTurn){
            table[3][column] = whoTurn;
        }else if(table[4][column] != whoTurn){
            table[4][column] = whoTurn;
        }else if(table[5][column] != whoTurn){
            table[5][column] = whoTurn;
        }else{
            isFull = true;
        }

        if(!isFull){
            checkWinner();
        }
    }

    public int checkWinner(){
        //horizontally
        for(int i = 0; i<rows; i++) {
            for (int j = 0; j < columns-3; j++) {
                if (table[i][j] == table[i][j+1] && table[i][j] == table[i][j+2] &&
                        table[i][j] == table[i][j+3]){
                    return table[i][j];
                }
            }
        }

        //vertically
        for(int j = 0; j < columns; j++) {
            for (int i = 0; i < rows-3; i++) {
                if (table[i][j] == table[i+1][j] && table[i][j] == table[i+2][j] &&
                        table[i][j] == table[i+3][j]){
                    return table[i][j];
                }
            }
        }

        //diagonally "\"
        for(int i = 0; i < columns-3; i++) {
            for (int j = 0; j < rows-3; j++) {
                if (table[i][j] == table[i+1][j+1] && table[i][j] == table[i+2][j+2] &&
                        table[i][j] == table[i+3][j+3]){
                    return table[i][j];
                }
            }
        }

        //diagonally "/"
        for(int i = rows; i > rows-3; i--) {
            for (int j = 0; j < columns-3; j++) {
                if (table[i][j] == table[i-1][j+1] && table[i][j] == table[i-2][j+2] &&
                        table[i][j] == table[i-3][j+3]){
                    return table[i][j];
                }
            }
        }

        return 0;
    }
}
