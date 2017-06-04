import org.junit.Test;

import java.lang.reflect.Field;

import java.util.ArrayList;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by rkdun on 6/3/2017.
 */
public class PlayerTest {
    @Test
    public void scoreStraight() throws Exception {


        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(1));
        d.add(new Die(2));
        d.add(new Die(3));
        d.add(new Die(4));
        d.add(new Die(5));
        d.add(new Die(6));


        int result = player.score();

        assertThat(result,equalTo(1500));

    }
    @Test
    public void scoreThreePair() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(1));
        d.add(new Die(1));
        d.add(new Die(2));
        d.add(new Die(2));
        d.add(new Die(3));
        d.add(new Die(3));


        int result = player.score();

        assertThat(result,equalTo(500));
    }



    @Test
    public void threeSixs() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));

        int result = player.score();

        assertThat(result,equalTo(600));
    }

    @Test
    public void fourSixs() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));

        int result = player.score();

        assertThat(result,equalTo(1200));
    }

    @Test
    public void fiveSixs() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));

        int result = player.score();

        assertThat(result,equalTo(2400));
    }

    @Test
    public void sixSixs() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));
        d.add(new Die(6));

        int result = player.score();

        assertThat(result,equalTo(4800));
    }

    //************fives************************//
    @Test
    public void threeFives() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));

        int result = player.score();

        assertThat(result,equalTo(500));
    }

    @Test
    public void fourFives() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));

        int result = player.score();

        assertThat(result,equalTo(1000));
    }

    @Test
    public void fiveFives() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));

        int result = player.score();

        assertThat(result,equalTo(2000));
    }

    @Test
    public void sixFives() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));
        d.add(new Die(5));

        int result = player.score();

        assertThat(result,equalTo(4000));
    }


    @Test
    public void scoreOneAndFive() throws Exception {
        Player player = new Player();
        Field f = player.getClass().getDeclaredField("dice");
        f.setAccessible(true);
        ArrayList<Die> d = (ArrayList<Die>) f.get(player);
        d.add(new Die(1));
        d.add(new Die(5));

        int result = player.score();

        assertThat(result,equalTo(150));
    }

}