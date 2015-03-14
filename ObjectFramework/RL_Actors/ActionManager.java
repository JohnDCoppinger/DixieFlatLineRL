package ObjectFramework.RL_Actors;

/**
 * Created by Gallanoth on 2/28/2015.
 */
public interface ActionManager extends Comparable<ActionManager>{

    public abstract void performActions();
    public int getInitiative();
}
