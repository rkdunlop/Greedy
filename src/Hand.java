import java.util.Arrays;

/**
 * Created by rdunlop on 5/30/2017.
 */
public class Hand {

    private final Die[] hand = new Die[6];

    public Hand() {
        for(int i = 0; i< hand.length; i++) hand[i] = new Die();
    }

    public void roll() {

        for (Die aHand : hand) {
            aHand.roll();
        }
    }

    public Die[] getHand() {
        return hand;
    }

    public void bust() {
        for (Die aHand : hand) {
            aHand.bust();
        }
    }
    public String showPicked() {
        StringBuilder str = new StringBuilder("[");

        for(int i = 0; i < (hand.length - 1); i++) {

            if(hand[i].isPicked() == null || !hand[i].isPicked()){
                str.append("-, ");
            } else {
                str.append("*, ");
            }
        }
        if(hand[hand.length - 1].isPicked() == null || !hand[hand.length - 1].isPicked()){
            str.append("-]");
        } else {
            str.append("*]");
        }

        return str.toString();

    }
    public String toString() {
        return Arrays.toString(hand);
    }


}
