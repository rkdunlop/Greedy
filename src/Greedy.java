import java.util.Scanner;

/**
 * Defines how the game greedy is played
 * Created by rdunlop on 5/30/2017.
 */
public class Greedy {

    public static void main(String[] args) {
        int score = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Greedy Greedy Greedy");
        System.out.println("Acceptable options are ");

        Player p1 = new Player();


        label:
        while (score < 10000) {
            System.out.println("Your hand: " + p1.getHand());
            System.out.println("Picked   : " + p1.getHand().showPicked());
            System.out.println("Enter your choice: ");
            String roll = sc.nextLine();
            roll.toLowerCase();
            switch (roll) {
                case "roll":
                    p1.score();
                    p1.getHand().roll();
                    System.out.println("Running Score: " + p1.getHandScore());
                    break;
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    System.out.println(Integer.parseInt(roll));
                    p1.getHand().getHand()[Integer.parseInt(roll) - 1].setPicked();
                    break;
                case "stop":
                    System.out.println("Stop");
                    p1.score();
                    p1.setScore();
                    break label;
                default:
                    System.out.println("Enter a valid choice! (Stop, Roll, 1-6");
                    break;
            }

        }
    }

}
