package ObjectFramework.General.Entity;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Items.Item;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public interface InventoryComponent {

    public Item[] showItems();
    public Item giveItem(int itemIndex);
    public Item referenceItem(int itemIndex);
    public void addItem(Item newItem);
    public void deleteItem(int itemIndex);
    public int inventorySize();
    public Menu getItemMenu();
}
