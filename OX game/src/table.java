public class table {
    static int[][] tab = new int[9][9];
    static void restartTab() {
        int pom = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tab[i][j] = pom;
                pom++;
            }
        }
    }

    static void printTab(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                if(table.tab[i][j] == 999) {
                    System.out.print("\t X");
                }else if(table.tab[i][j] == -999){
                    System.out.print("\t O");
                }else{
                    System.out.print("\t" + table.tab[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
