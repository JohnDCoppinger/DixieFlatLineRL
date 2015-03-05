package ObjectFramework.Entity;

import java.util.Observer;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public abstract class ReactionManager {

    private boolean clippable;

    public ReactionManager() {}

    public abstract void interact();

    public boolean clippable() {

        return this.clippable;
    }

    public void setClippable(boolean clippable) {

        this.clippable = clippable;
    }
}
