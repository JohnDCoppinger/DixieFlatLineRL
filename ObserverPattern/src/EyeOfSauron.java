/**
 * Created by Gallanoth on 1/14/2015.
 */
import java.util.ArrayList;
import java.util.Observable;

public class EyeOfSauron extends Observable {

    public void setEnemies(ArrayList<GoodGuy> enemies) {

        System.out.println("Sauron gives a new report:");
        this.setChanged();
        this.notifyObservers(enemies);
        
        System.out.println();
    }
}
