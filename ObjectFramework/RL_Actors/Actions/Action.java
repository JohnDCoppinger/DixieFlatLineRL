package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public interface Action {

    public void perform(GameEntity affected);
    public int actionCost();
}
