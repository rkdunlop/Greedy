import java.util.Scanner;

/**
 * Created by rdunlop on 5/30/2017.
 */
public class Greedy {

    public static void main(String[] args) {
        int score = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Greedy Greedy Greedy");
        System.out.println("Would you like to roll?");
        String roll = sc.nextLine();
        roll.toLowerCase();
        Player p1 = new Player();
        if(roll.equals("roll")) {
            p1.getHand().roll();
            System.out.println(p1.getHand());
        }

        while(score < 10000) {



        }
    }

    public static boolean bust(Hand h) {
        Die[] d = h.getHand();

        int count = 0;
        for(int i = 0; i < d.length; i++) {
          if(d[i].getValue() == 1 || d[i].getValue() == 5) {
              count ++;
          }
        }
        if(count > 0) {
            return false;
        }
        return true;
    }
}
