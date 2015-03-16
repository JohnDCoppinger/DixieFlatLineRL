package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MovementCommands.MoveUpCommand;
import ObjectFramework.General.Entity.GameEntity;

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
