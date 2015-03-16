package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.InventoryComponent;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Items.Item;

import java.util.ArrayList;

//TODO

public class ActorInventoryComponent implements InventoryComponent {

    private ArrayList<Item> items;

    public Item[] showItems() {
        return null;
    }

    public Item giveItem(int itemIndex) {
        return null;
    }

    public Item referenceItem(int itemIndex) {
        return null;
    }

    public void addItem(Item newItem) {}

    public void deleteItem(int itemIndex) {}

    public int inventorySize() {
        return 0;
    }

    public Menu getItemMenu() {

        return null;
    }
}
