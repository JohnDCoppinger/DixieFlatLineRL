package ObjectFramework.General.Menu;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public class MenuItem {

    private String itemName;
    private boolean emphasis;
    private int key;

    public boolean isEmphasized() {
        return emphasis;
    }

    public void setEmphasis(boolean emphasis) {
        this.emphasis = emphasis;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
