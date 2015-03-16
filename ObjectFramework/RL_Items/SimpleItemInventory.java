package ObjectFramework.RL_Items;

import ObjectFramework.General.Entity.InventoryComponent;
import ObjectFramework.General.Menu.InventoryMenu;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.General.Menu.MenuItem;

import java.util.ArrayList;

public class SimpleItemInventory implements InventoryComponent {

    private ArrayList<Item> items;

    private SimpleItemInventory() {
        this.items = new ArrayList<Item>();
    }

    public SimpleItemInventory(Item item) {
        this();
        this.items.add(item);
    }

    public Menu showItems() {

        InventoryMenu menu = new InventoryMenu("Items on Ground");
        int i = 0;

        for (Item item : items) {
            menu.addMenuItem(new MenuItem(item.description(), i++));
        }

        return menu;
    }

    public Item giveItem(int itemIndex) {

        Item temp = items.get(itemIndex);
        items.remove(itemIndex);

        return temp;
    }

    public Item referenceItem(int itemIndex) {

        if (itemIndex < items.size())
            return items.get(itemIndex);

        return null;
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
}
