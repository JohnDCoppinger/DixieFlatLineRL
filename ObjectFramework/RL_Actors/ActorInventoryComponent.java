package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.InventoryComponent;
import ObjectFramework.RL_Items.Item;

//TODO

public class ActorInventoryComponent implements InventoryComponent {

    public Item[] showItems() {
        return null;
    }

    public Item giveItem(int itemIndex) {
        return null;
    }

    public void addItem(Item newItem) {}

    public void deleteItem(int itemIndex) {}

    public int inventorySize() {
        return 0;
    }
}
