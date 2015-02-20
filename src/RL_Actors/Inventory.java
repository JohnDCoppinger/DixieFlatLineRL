package RL_Actors;
import RL_Items.Item;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class Inventory{

    ArrayList<Item> inventory;

    public Inventory() {

        this.inventory = new ArrayList<Item>();
    }

    public void addInventory(Item item) {

        this.inventory.add(item);
    }

    public Iterator<Item> iterator() {

        return inventory.iterator();
    }


}
