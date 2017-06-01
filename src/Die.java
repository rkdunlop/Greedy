/*
  Created by rdunlop on 5/30/2017.
 */
import java.util.*;
public class Die {

    private int value = 0;
    private Boolean isPicked = null;
    private static final Random random = new Random();
    public Die() {
    }

    public void roll() {
        value = random.nextInt(6)+1;
    }

    public Boolean isPicked() {
        return isPicked;
    }

    public void setPicked() {
        isPicked = (isPicked == null) || !isPicked;
    }


    public int getValue() {
        return value;
    }

    public void bust() {
        value = 0;
    }
    
    public String toString() {
        return "" + value;
    }



}
