package ObjectFramework.RL_Items;

public abstract class Item {

    private int weight;
    private int itemID;
    private String itemName;

    private static int nextID = 1;

    public abstract String description();

    private static int assignID() {

        //TODO
        return nextID++;
    }
}
