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
    public String showPicked() {
        String str = "[";

        for(int i = 0; i < (hand.length - 1); i++) {

            if(hand[i].isPicked() == null || hand[i].isPicked() == false){
                str += "-, ";
            } else {
                str += "*, ";
            }
        }
        if(hand[hand.length - 1].isPicked() == null || hand[hand.length - 1].isPicked() == false){
            str += "-]";
        } else {
            str += "*]";
        }

        return str;

    }
    public String toString() {
        return Arrays.toString(hand);
    }


}
