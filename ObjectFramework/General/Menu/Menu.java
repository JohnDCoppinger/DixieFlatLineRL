package ObjectFramework.General.Menu;

import java.util.Iterator;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public interface Menu {

    public void select(int itemNo);
    public int getSelected();
    public int getSelectedKey();
    public MenuItem getSelectedItem();
    public Iterator getIterator();
    public String getHeader();
    public void remove(int itemNo);
}
