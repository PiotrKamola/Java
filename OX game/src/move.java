import java.util.Scanner;
import javax.swing.JOptionPane;
public class move {
    static int whoMove = 999;
    static void choose() {
        String strTab = makeString();
        String who;
        while(true){
            try {
                if(whoMove==999){
                    who = "X";
                }else{
                    who = "O";
                }

                int choosed = Integer.parseInt(JOptionPane.showInputDialog(null, strTab, "Its "+who+" turn.", JOptionPane.INFORMATION_MESSAGE));
                if (isHere(choosed)) {
                    doMove(choosed);
                    break;
                }
                JOptionPane.showMessageDialog(null, "Wrong number, choose again.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Wrong number, choose again.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    static boolean isHere(int choosed){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(table.tab[i][j] == choosed && choosed != 999 && choosed != -999){
                    return true;
                }
            }
        }
        return false;
    }

    static String makeString(){
        String strTab = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (table.tab[i][j] != 999 && table.tab[i][j] != -999) {
                    strTab += table.tab[i][j];
                    strTab += "     ";
                    if (table.tab[i][j] < 10 && table.tab[i][j] > 0) {
                        strTab += "  ";
                    }
                }else{
                    if(table.tab[i][j]==999){
                        strTab += "X       ";
                    }else{
                        strTab += "O       ";
                    }
                }
            }
            strTab += "\n";
        }
        return strTab;
    }
    static void doMove(int choosed) {
        String strTab = "";

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(table.tab[i][j] == choosed) {
                    try{
                        table.tab[i][j] = whoMove;
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if(table.tab[i - 1][j - 1] != 999 && table.tab[i - 1][j - 1] != -999) {
                            table.tab[i - 1][j - 1] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if(table.tab[i][j - 1] != 999 && table.tab[i][j - 1] != -999) {
                            table.tab[i][j - 1] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if(table.tab[i - 1][j] != 999 && table.tab[i - 1][j] != -999) {
                            table.tab[i - 1][j] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if(table.tab[i + 1][j + 1] != 999 && table.tab[i + 1][j + 1] != -999) {
                            table.tab[i + 1][j + 1] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if( table.tab[i + 1][j] != 999 &&  table.tab[i + 1][j] != -999) {
                            table.tab[i + 1][j] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if( table.tab[i][j + 1] != 999 &&  table.tab[i][j + 1] != -999) {
                            table.tab[i][j + 1] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if( table.tab[i + 1][j - 1] != 999 &&  table.tab[i + 1][j - 1] != -999) {
                            table.tab[i + 1][j - 1] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    try{
                        if( table.tab[i - 1][j + 1] != 999 &&  table.tab[i - 1][j + 1] != -999) {
                            table.tab[i - 1][j + 1] = whoMove;
                        }
                    }catch(Exception e){
                        System.out.print("");
                    }

                    whoMove = whoMove * -1;
                }
            }
        }
    }

    static int isWin(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if( table.tab[i][j] != 999 && table.tab[i][j] != -999){
                    return 1;
                }
            }
        }
        return whoMove;
    }
}



