package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MovementCommands.MoveDownCommand;
import ObjectFramework.General.Entity.GameEntity;

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
