package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.General.Entity.GameEntity;

/**
 * Be Careful! Actions are not commands, they are strategy patter for Actor default actions/reactions!!
 */
public interface Action {

    public void perform(GameEntity affected);
    public int actionCost();
}
