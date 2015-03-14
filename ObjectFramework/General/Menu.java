package ObjectFramework.General;

import java.util.Iterator;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public interface Menu {

    public void select(MenuItem item);
    public MenuItem getSelected();
    public Iterator getIterator();
    public String getHeader();
}
