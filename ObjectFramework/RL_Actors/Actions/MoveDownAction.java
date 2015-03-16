package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MovementCommands.MoveDownCommand;
import ObjectFramework.General.Entity.GameEntity;

public class MoveDownAction extends MoveAction {

    private int cost;

    public MoveDownAction() {
        this.cost = 1;
    }

    public void perform(GameEntity affected) {
        new MoveDownCommand(affected).execute();
    }

    public int actionCost() {
        return this.cost;
    }
}
