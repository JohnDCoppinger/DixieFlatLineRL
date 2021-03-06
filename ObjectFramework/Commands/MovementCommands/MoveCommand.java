package ObjectFramework.Commands.MovementCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

public class MoveCommand implements Command {

    protected int x;
    protected int y;
    protected GameEntity entity;

    protected MoveCommand() {}

    public MoveCommand(int x, int y, GameEntity entity) {

        this.x = x;
        this.y = y;
        this.entity = entity;
    }

    //should this check if the move location is valid? Probably
    public void execute() {

        EntityController.instance().move(x, y, entity);
    }
}
