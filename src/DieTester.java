/**
 * Created by kyle on 6/1/2017.
 */
public class DieTester {

    public static void main(String[] args) {
        Die d1 = new Die();
        Die d2 = new Die();
        d1.roll();
        d2.roll();

        System.out.println(d1.getValue());
        System.out.println(d2.getValue());
        System.out.println(d1.compareTo(d2));
    }
}
