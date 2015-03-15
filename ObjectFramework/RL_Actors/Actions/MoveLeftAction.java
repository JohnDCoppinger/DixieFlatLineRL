package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MoveDownCommand;
import ObjectFramework.General.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class MoveLeftAction extends MoveAction {

    private int cost;

    public MoveLeftAction() {
        this.cost = 1;
    }

    public void perform(GameEntity affected) {
        new MoveDownCommand(affected).execute();
    }

    public int actionCost() {
        return this.cost;
    }
}
