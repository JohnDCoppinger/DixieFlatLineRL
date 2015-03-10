package ObjectFramework.Entity;

import java.util.Observer;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public abstract class ReactionComponent {

    private boolean clippable;

    public ReactionComponent() {}

    public abstract void react(GameEntity triggerer); //should be used to set the state?

    public abstract void defaultAction(GameEntity triggerer);

    public boolean clippable() {

        return this.clippable;
    }

    public void setClippable(boolean clippable) {

        this.clippable = clippable;
    }
}
