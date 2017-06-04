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
    private List<Die> dice = new ArrayList<>();


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

        int check = 0;
        Collections.sort(dice);


        int count6 = 0;
        int count5 = 0;


        while (dice.size() > 0) {
            //System.out.println("The Case is : " + check);
            //System.out.println(dice.toString());
            label:
            switch (check) {
                case 0:
                    System.out.println("Checking straight");
                    if (dice.size() != 6) {
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
                    //System.out.println("6's");

                    for (Die d : dice) {
                        if (d.getValue() == 6) {
                            count6++;
                        }
                    }

                    if (count6 == 6) {
                        handScore += 4800;
                        cleanup(6);
                    } else if (count6 == 5) {
                        handScore += 2400;
                        cleanup(6);
                    } else if (count6 == 4) {
                        handScore += 1200;
                        cleanup(6);
                    } else if (count6 == 3) {
                        handScore += 600;
                        cleanup(6);
                    }
                    check = 2;
                    break;
                case 2:
                    //System.out.println("5's");

                    for (Die d : dice) {
                        if (d.getValue() == 5) {
                            count5++;
                        }
                    }

                    if (count5 == 6) {
                        handScore += 4000;
                        cleanup(5);
                        break;
                    } else if (count5 == 5) {
                        handScore += 2000;
                        cleanup(5);
                        break;
                    } else if (count5 == 4) {
                        handScore += 1000;
                        cleanup(5);
                        break;
                    } else if (count5 == 3) {
                        handScore += 500;
                        cleanup(5);
                        System.out.println("Hand score should be 500 - actual " + handScore);
                        break;


                    }
                    check =3;
                    break;



                case 3:
                    //System.out.println("4's");
                    int count = 0;
                    for (Die d : dice) {
                        if (d.getValue() == 4) {
                            count++;
                        }
                    }

                    if (count == 6) {
                        handScore += 3200;
                        cleanup(4);
                    } else if (count == 5) {
                        handScore += 1600;
                        cleanup(4);
                    } else if (count == 4) {
                        handScore += 800;
                        cleanup(4);
                    } else if (count == 3) {
                        handScore += 400;
                        cleanup(4);
                    }
                    check = 4;
                    break;
                case 4:
                    //System.out.println("3's");
                    count = 0;
                    for (Die d : dice) {
                        if (d.getValue() == 3) {
                            count++;
                        }
                    }

                    if (count == 6) {
                        handScore += 2400;
                        cleanup(3);
                    } else if (count == 5) {
                        handScore += 1200;
                        cleanup(3);
                    } else if (count == 4) {
                        handScore += 600;
                        cleanup(3);
                    } else if (count == 3) {
                        handScore += 300;
                        cleanup(3);
                    }
                    check = 5;
                    break;
                case 5:
                    //System.out.println("2's");
                    count = 0;
                    for (Die d : dice) {
                        if (d.getValue() == 2) {
                            count++;
                        }
                    }

                    if (count == 6) {
                        handScore += 1600;
                        cleanup(2);
                    } else if (count == 5) {
                        handScore += 800;
                        cleanup(2);
                    } else if (count == 4) {
                        handScore += 400;
                        cleanup(2);
                    } else if (count == 3) {
                        handScore += 200;
                        cleanup(2);
                    }
                    check = 6;
                    break;
                case 6:
                    //System.out.println("1's");
                    count = 0;
                    for (Die d : dice) {
                        if (d.getValue() == 1) {
                            count++;
                        }
                    }

                    if (count == 6) {
                        handScore += 8000;
                        cleanup(1);
                    } else if (count == 5) {
                        handScore += 4000;
                        cleanup(1);
                    } else if (count == 4) {
                        handScore += 2000;
                        cleanup(1);
                    } else if (count == 3) {
                        handScore += 1000;
                        cleanup(1);
                    }
                    check = 7;
                    break;
                case 7:
                    //System.out.println("Checking 3 pairs");
                    if (dice.size() != 6) {
                        check = 8;
                        break;
                    }
                    if (dice.get(0).getValue() == dice.get(1).getValue()
                            && dice.get(2).getValue() == dice.get(3).getValue()
                            && dice.get(4).getValue() == dice.get(5).getValue()) {
                        handScore += 500;
                        dice.clear();

                    }
                    check = 8;
                    break;
                case 8:
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
            //System.out.println("Break!");
            //check for straight


        }
        return handScore;
    }

    public void cleanup(int elementToRemove) {
        //System.out.println(dice.size());
        for (int i = dice.size()-1; i >= 0; i--) {
            //System.out.println("i: " + i);
            if (dice.get(i).getValue() == elementToRemove) {
                //System.out.println("Removing: " + i);
                dice.remove(i);

            }
        }
        //.out.println(dice.size());
    }
}
