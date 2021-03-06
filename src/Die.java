/*
  Defines a dies state, and function
  Created by rdunlop on 5/30/2017.
 */
import java.util.*;
public class Die implements Comparable<Die>{

    private int value = 0;
    private Boolean isPicked = null;
    private Boolean isLocked = false;
    private static final Random random = new Random();
    public Die() {
    }

    public Die(int value) {
        this.value = value;
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

    public void setLocked() {
        isLocked = ((isLocked == null) || !isLocked) && isPicked;
    }

    public Boolean isLocked() {
        return isLocked;
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




    @Override
    public int compareTo(Die o) {
        return Integer.compare(value,o.value );
    }
}
