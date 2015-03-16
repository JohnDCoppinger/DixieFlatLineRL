package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.InventoryComponent;
import ObjectFramework.General.Menu.InventoryMenu;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.General.Menu.MenuItem;
import ObjectFramework.RL_Items.Item;

import java.util.ArrayList;

//TODO

public class ActorInventoryComponent implements InventoryComponent {

    private ArrayList<Item> items;
    private String inventoryName;

    public ActorInventoryComponent() {
        this.items = new ArrayList<Item>();
        this.inventoryName = "Actor Inventory";
    }

    public ActorInventoryComponent(String menuName) {
        this();
        this.inventoryName = menuName + "'s inventory";
    }

    public Menu showItems() {

        InventoryMenu menu = new InventoryMenu(inventoryName);
        int i = 0;

        for(Item item : items) {
            menu.addMenuItem(new MenuItem(item.description(), i++));
        }

        return menu;
    }

    public Item giveItem(int itemIndex) {

        Item temp = items.get(itemIndex);
        items.remove(temp);

        return temp;
    }

    public Item referenceItem(int itemIndex) {
        return items.get(itemIndex);
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

    public void setInventoryName(String name) {
        this.inventoryName = name + "'s inventory";
    }

}
