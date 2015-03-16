package ObjectFramework.General.Menu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public class InventoryMenu implements Menu{

    private int selected;
    private ArrayList<MenuItem> items;
    private String header;

    private InventoryMenu() {
        items = new ArrayList<MenuItem>();
    }

    public InventoryMenu(String header) {
        this();
        this.header = header;
        this.selected = 0;
    }

    public void select(MenuItem item) {
        selected = items.indexOf(item);
    }

    public void select(int selected) {
        this.selected = selected;
    }

    public MenuItem getSelected() {

        return items.get(selected);
    }

    public Iterator getIterator() {
        return new Iterator<MenuItem>() {

            private int currentIndex = 0;

            public boolean hasNext() {
                return items.get(currentIndex) != null;
            }

            public MenuItem next() {return items.get(currentIndex++);}

            public void remove() {}
        };
    }

    public void emphasize(int itemIndex) {
        items.get(itemIndex).setEmphasis(true);
    }

    public void unemphasize(int itemIndex) {
        items.get(itemIndex).setEmphasis(false);
    }

    public String getHeader() {
        return this.header;
    }

    public void addMenuItem(MenuItem item) {
        this.items.add(item);
    }

}
