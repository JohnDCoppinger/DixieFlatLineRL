package ObjectFramework.Entity;
import ObjectFramework.RL_Items.Item;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class InventoryComponent {

    ArrayList<Item> inventory;

    public InventoryComponent() {

        this.inventory = new ArrayList<Item>();
    }

    public void addToInventory(Item item) {

        this.inventory.add(item);
    }

    public void removeFromInventory(Item item) {

        this.inventory.remove(item);
    }

    public void trade(ArrayList<Item> tradeInventory) {

    }

    public Iterator<Item> iterator() {

        return inventory.iterator();
    }


}
