package ObjectFramework.Entity;
import ObjectFramework.RL_Items.Item;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public interface InventoryComponent {

    public void addToInventory(Item item);

    public void removeFromInventory(Item item);

    public void trade(ArrayList<Item> tradeInventory);

    public Iterator<Item> iterator();


}
