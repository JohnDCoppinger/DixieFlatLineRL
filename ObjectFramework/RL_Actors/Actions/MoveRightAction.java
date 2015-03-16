package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MovementCommands.MoveRightCommand;
import ObjectFramework.General.Entity.GameEntity;

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
