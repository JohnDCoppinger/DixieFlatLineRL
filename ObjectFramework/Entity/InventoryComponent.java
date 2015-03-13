package ObjectFramework.Entity;
import ObjectFramework.RL_Items.Item;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public interface InventoryComponent {

    public Item[] showItems();
    public Item giveItem(int itemIndex);
    public void addItem(Item newItem);
    public void deleteItem();
    public int inventorySize();
}
