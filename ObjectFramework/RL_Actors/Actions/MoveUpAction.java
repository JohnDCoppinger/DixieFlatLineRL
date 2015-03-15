package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MoveUpCommand;
import ObjectFramework.General.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class MoveUpAction extends MoveAction {

    private int cost;

    public MoveUpAction() {
        this.cost = 1;
    }

    public void perform(GameEntity affected) {
        new MoveUpCommand(affected).execute();
    }

    public int actionCost() {
        return this.cost;
    }
}
