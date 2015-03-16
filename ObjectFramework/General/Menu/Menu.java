package ObjectFramework.General.Menu;

import java.util.Iterator;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public interface Menu {

    public void select(int itemNo);
    public int getSelectedKey();
    public MenuItem getSelected();
    public Iterator getIterator();
    public String getHeader();
}
