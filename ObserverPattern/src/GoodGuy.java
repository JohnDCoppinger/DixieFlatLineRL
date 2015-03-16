/**
 * Created by Gallanoth on 1/14/2015.
 */
public class GoodGuy {

    private String name;
    private int count;

    public GoodGuy(String name, int count) {

        this.name = name;
        this.count = count;
    }

    public String report() {

        return count + " " + name;
    }
}
