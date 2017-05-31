import java.util.Arrays;

/**
 * Created by rdunlop on 5/30/2017.
 */
public class Hand {

    private Die[] hand = new Die[6];

    public Hand() {
        for(int i = 0; i< hand.length; i++) hand[i] = new Die();
    }

    public void roll() {

        for(int i = 0; i < hand.length; i++) {
            hand[i].roll();
        }
    }

    public Die[] getHand() {
        return hand;
    }

    public void bust() {
        for(int i = 0; i < hand.length; i++) {
            hand[i].bust();
        }
    }

    public String toString() {
        return Arrays.toString(hand);
    }


}
