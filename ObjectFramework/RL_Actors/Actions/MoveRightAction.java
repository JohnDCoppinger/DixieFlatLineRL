package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MoveRightCommand;
import ObjectFramework.General.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class MoveRightAction extends MoveAction{

    private int cost;

    public MoveRightAction() {
        this.cost = 1;
    }

    public void perform(GameEntity affected) {
        new MoveRightCommand(affected).execute();
    }

    public int actionCost() {
        return this.cost;
    }
}
