package ObjectFramework.RL_Items;

import ObjectFramework.General.Entity.InventoryComponent;
import ObjectFramework.General.Menu.Menu;

import java.util.ArrayList;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class SimpleItemInventory implements InventoryComponent {

    private ArrayList<Item> items;

    private SimpleItemInventory() {
        this.items = new ArrayList<Item>();
    }

    public SimpleItemInventory(Item item) {
        this();
        this.items.add(item);
    }

    public Item[] showItems() {
        return (Item[]) items.toArray();
    }

    public Item giveItem(int itemIndex) {

        Item temp = items.get(itemIndex);
        items.remove(itemIndex);

        return temp;
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public void deleteItem(int itemIndex) {
        items.remove(itemIndex);
    }

    public int inventorySize() {
        return items.size();
    }

    public Menu getItemMenu(){return null;}
}
