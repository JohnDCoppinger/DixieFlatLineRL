package ObjectFramework.General.Menu;

public class MenuItem {

    private String itemName;
    private boolean emphasis;
    private int key;

    private MenuItem() {};

    public MenuItem(String itemName, int key) {
        this.itemName = itemName;
        this.key = key;
    }

    public MenuItem(String itemName, int key, boolean emphasis) {
        this(itemName, key);
        this.emphasis = emphasis;
    }

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
