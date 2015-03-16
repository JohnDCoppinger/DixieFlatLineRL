package ObjectFramework.RL_Actors;

public interface ActionManager extends Comparable<ActionManager>{

    public abstract void performActions();
    public int getInitiative();
}
