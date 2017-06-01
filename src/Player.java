/**
 * Created by rdunlop on 5/31/2017.
 */
public class Player {
    private int playerScore = 0;
    private int handScore = 0;
    private Hand h = null;

    public Player(){
       h = new Hand();
    }

    public Hand getHand() {
        return h;
    }


}
