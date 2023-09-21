package com.example.connectFour.game;

import org.springframework.stereotype.Component;

@Component
public class GameService {
    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public int[][] getTable(){
        return game.getTable();
    }

    public int makeMove(int column){
        if(game.getWinner() != 0){
            return game.getWinner();
        }

        boolean isColumnFull = false;
        if(game.getTable()[5][column] == 0){
            game.getTable()[5][column] = game.getWhoTurn();
        }else if(game.getTable()[4][column] == 0){
            game.getTable()[4][column] = game.getWhoTurn();
        }else if(game.getTable()[3][column] == 0){
            game.getTable()[3][column] = game.getWhoTurn();
        }else if(game.getTable()[2][column] == 0){
            game.getTable()[2][column] = game.getWhoTurn();
        }else if(game.getTable()[1][column] == 0){
            game.getTable()[1][column] = game.getWhoTurn();
        }else if(game.getTable()[0][column] == 0){
            game.getTable()[0][column] = game.getWhoTurn();
        }else{
            isColumnFull = true;
        }

        if(!isColumnFull){
            game.setWhoTurn(game.getWhoTurn()*(-1));
        }

        game.setWinner(checkWinner());
        System.out.println(game.getWhoTurn());
        return game.getWinner();
    }

    public int checkWinner(){

        //vertically |
        for(int j = 0; j < game.getColumns(); j++) {
            for (int i = 0; i < game.getRows()-3; i++) {
                if (game.getTable()[i][j] == game.getTable()[i+1][j] &&
                        game.getTable()[i][j] == game.getTable()[i+2][j] &&
                        game.getTable()[i][j] == game.getTable()[i+3][j] &&
                        game.getTable()[i][j] != 0){
                    return game.getTable()[i][j];
                }
            }
        }

        //horizontally -
        for(int i = 0; i<game.getRows(); i++) {
            for (int j = 0; j < game.getColumns()-3; j++) {
                if (game.getTable()[i][j] == game.getTable()[i][j+1] &&
                        game.getTable()[i][j] == game.getTable()[i][j+2] &&
                        game.getTable()[i][j] == game.getTable()[i][j+3] &&
                        game.getTable()[i][j] != 0){
                    return game.getTable()[i][j];
                }
            }
        }

        //diagonally "\"
        for(int i = 0; i < game.getColumns()-4; i++) {
            for (int j = 0; j < game.getRows()-4; j++) {
                if (game.getTable()[i][j] == game.getTable()[i+1][j+1] &&
                        game.getTable()[i][j] == game.getTable()[i+2][j+2] &&
                        game.getTable()[i][j] == game.getTable()[i+3][j+3] &&
                        game.getTable()[i][j] != 0){
                    return game.getTable()[i][j];
                }
            }
        }

        //diagonally "/"
        for(int i = game.getRows()-1; i > game.getRows()-3; i--) {
            for (int j = 0; j < game.getColumns()-3; j++) {
                if (game.getTable()[i][j] == game.getTable()[i-1][j+1] &&
                        game.getTable()[i][j] == game.getTable()[i-2][j+2] &&
                        game.getTable()[i][j] == game.getTable()[i-3][j+3] &&
                        game.getTable()[i][j] != 0){
                    return game.getTable()[i][j];
                }
            }
        }

        if(isTableFull()){
            return 3;
        }

        return 0;
    }

    public void clearTable(){
        int[][] clearTable = new int[game.getRows()][game.getColumns()];
        for(int i = 0; i<game.getRows(); i++) {
            for (int j = 0; j < game.getColumns(); j++) {
                    clearTable[i][j] = 0;
            }
        }
        game.setWinner(0);
        game.setTable(clearTable);
    }

    public void printGame(){
        for(int i = 0; i<game.getRows(); i++){
            for(int j=0; j<game.getColumns(); j++){
                System.out.print(getTable()[i][j]);
            }
            System.out.println("");
        }
        System.out.println("---");
    }

    public int getColumns(){
        return game.getColumns();
    }

    private boolean isTableFull(){
        for(int i = 0; i<game.getRows(); i++) {
            for (int j = 0; j < game.getColumns(); j++) {
                if(game.getTable()[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
