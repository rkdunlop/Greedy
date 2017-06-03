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

    public void selectDiceToScore() {
        dice.clear();
        for (Die d : h.getHand()
                ) {
            if ((d.isPicked() != null) && d.isPicked() && !d.isLocked()) {
                dice.add(d);

            }
        }
    }
    public int score() {
        System.out.println("I'm scoring");
        int check = 0;
        Collections.sort(dice);
        System.out.println(dice.toString());
        while (dice.size() > 0) {
            System.out.println("The Case is : " + check);
            label:
            switch (check){
                case 0:
                    System.out.println("Checking straight");
                    if(dice.size() != 6) {
                        check = 1;
                        break;
                    }
                    for (int i = 0; i < dice.size() - 1; i++) {
                        int val = dice.get(i).getValue();
                        int val2 = dice.get(i + 1).getValue();
                        if (val2 != val + 1) {


                            check = 1;
                            break label;
                        }
                    }
                    handScore += 1500;
                    dice.clear();

                    break;
                case 1:
                    System.out.println("Checking 3 pairs");
                    if(dice.size() != 6) {
                        check = 2;
                        break;
                    }
                    if(dice.get(0).getValue() == dice.get(1).getValue()
                            &&dice.get(2).getValue() == dice.get(3).getValue()
                            && dice.get(4).getValue() == dice.get(5).getValue()){
                        handScore += 500;
                        dice.clear();

                    }
                    check  = 2;
                    break;
                case 2:
                    System.out.println("3x6's");
                    int count = 0;
                    for(int i = 0; i < dice.size();i++) {
                        if(dice.get(i).getValue() == 6) {
                            count++;
                        }
                    }

                    if(count == 3) {
                        handScore += 600;

                            count = 0;
                            for(int i = 0; i < dice.size();i++) {
                                if(dice.get(i).getValue() == 6) {
                                    dice.remove(i);
                                    count++;
                                }
                                if(count == 3) {
                                    check = 3;
                                    break;
                                }
                            }
                    }
                    check = 3;
                    break;
                case 3:
                    System.out.println("Scoring a 1 or 5");
                    for (int i = 0; i < dice.size(); i++) {
                        int val = dice.get(i).getValue();
                        if (val == 1) {
                            handScore += 100;
                            dice.remove(i);
                        } else if (val == 5) {
                            handScore += 50;
                            dice.remove(i);
                        } else {
                            dice.remove(i);
                        }

                    }

                    break;
            }
            System.out.println("Break!");
            //check for straight


        }
        return handScore;
    }


}
