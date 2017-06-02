/**
 * Created by rdunlop on 5/31/2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private int playerScore = 0;
    private int handScore = 0;
    private Hand h = null;
    private List<Die> dice = new ArrayList<Die>();


    public Player() {
        h = new Hand();
    }

    public int getHandScore() {
        return handScore;
    }

    public Hand getHand() {
        return h;
    }

    public void setScore() {
        playerScore = handScore;
    }

    public void score() {
        dice.clear();
        for (Die d : h.getHand()
                ) {
            if ((d.isPicked() != null) && d.isPicked() && !d.isLocked()) {
                dice.add(d);

            }
        }
        Collections.sort(dice);
        System.out.println(dice.toString());
        while (dice.size()>0) {

            for(int i = 0; i < dice.size(); i++) {
                int val = dice.get(i).getValue();
                if(val == 1) {
                    handScore += 100;
                    dice.remove(i);
                } else if(val == 5) {
                    handScore += 50;
                    dice.remove(i);
                } else {
                    dice.remove(i);
                }

            }

        }
    }


}
