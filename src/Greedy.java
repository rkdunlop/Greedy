import java.util.Scanner;

/**
 * Created by rdunlop on 5/30/2017.
 */
public class Greedy {

    public static void main(String[] args) {
        int score = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Greedy Greedy Greedy");
        System.out.println("Acceptable options are ");

        Player p1 = new Player();


        while(score < 10000) {
            System.out.println("Your hand: " +p1.getHand());
            System.out.println("Picked   : " + p1.getHand().showPicked());
            System.out.println("Enter your choice: ");
            String roll = sc.nextLine();
            roll.toLowerCase();
            if(roll.equals("roll")) {
                p1.getHand().roll();

            } else if(roll.equals("1") ||roll.equals("2") ||roll.equals("3") ||roll.equals("4") ||roll.equals("5") ||roll.equals("6") ) {
                System.out.println(Integer.parseInt(roll));
                p1.getHand().getHand()[Integer.parseInt(roll)-1].setPicked();
            } else if(roll.equals("stop")){
                System.out.println("Stop");
                break;
            } else {
                System.out.println("Enter a valid choice! (Stop, Roll, 1-6");
            }

        }
    }

    public static boolean bust(Hand h) {
        Die[] d = h.getHand();

        int count = 0;
        for (Die aD : d) {
            if (aD.getValue() == 1 || aD.getValue() == 5) {
                count++;
            }
        }
        return count <= 0;
    }
}
