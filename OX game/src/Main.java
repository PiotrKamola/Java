import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        table.restartTab();
        while(true){
            if(move.isWin() == 1){
                move.choose();
            }else{
                if(move.isWin()==999){
                    System.out.println("The winner is O.");
                    JOptionPane.showMessageDialog(null, "The winner is O.", "Winner", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }else{
                    System.out.println("The winner is X.");
                    //JOptionPane.showMessageDialog(null, "The winner is X.");
                    JOptionPane.showMessageDialog(null, "The winner is X.", "Winner", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
    }
}