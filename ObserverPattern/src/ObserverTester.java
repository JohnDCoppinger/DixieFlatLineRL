/**
 * Created by Gallanoth on 1/14/2015.
 */
import java.util.ArrayList;

public class ObserverTester {

    public static void main(String[] args) {

        ArrayList<GoodGuy> enemies = new ArrayList<GoodGuy>();

        EyeOfSauron eye = new EyeOfSauron();

        BadGuy saruman = new BadGuy(eye, "Saruman");
        BadGuy angmar = new BadGuy(eye, "The Witch King of Angmar");

        enemies.add(new GoodGuy("hobbit", 1));
        enemies.add(new GoodGuy("elf", 1));
        enemies.add(new GoodGuy("men", 3));
        eye.setEnemies(enemies);
        enemies.clear();

        saruman.defeated();

        enemies.add(new GoodGuy("hobbits", 3));
        enemies.add(new GoodGuy("elves", 2));
        enemies.add(new GoodGuy("dwarves", 5));
        enemies.add(new GoodGuy("men", 300));
        eye.setEnemies(enemies);
        enemies.clear();
    }
}
