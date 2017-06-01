import java.util.Arrays;

/**
 * Created by rdunlop on 5/30/2017.
 */
public class Hand {

    private final Die[] hand = new Die[6];
    private int lockCount = 0;
    private boolean firstRoll =true;
    private int selectionMade = 0;

    public Hand() {
        for(int i = 0; i< hand.length; i++) hand[i] = new Die();
    }

    public void roll() {
        System.out.println("First Roll : " + firstRoll);
        for(Die d: hand) {
            if((d.isPicked() != null) && d.isPicked()) {
                selectionMade++;
                System.out.println(selectionMade);
            }
        }
        for(Die d: hand) {
            if((d.isPicked() != null) && d.isPicked() && !d.isLocked()) {
                d.setLocked();
                lockCount++;
                //System.out.println("Lock count: " + lockCount);
            }
        }
        if(lockCount == 6) {
            for(Die d: hand) {
                d.setLocked();
                d.setPicked();
            }
        }

        if(!firstRoll && (selectionMade > 0)) {
            for (Die d : hand) {

                if (!d.isLocked()) d.roll();
            }
            selectionMade = 0;
        }
        else if(firstRoll) {
            for(Die d: hand) {
                d.roll();

            }
            firstRoll = false;

        } else {
            System.out.println("You must select a die, to roll");
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
