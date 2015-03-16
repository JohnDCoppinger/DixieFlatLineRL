package ObjectFramework.Commands.MovementCommands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

public class MoveUpCommand extends MoveCommand {

    private MoveUpCommand() {}

    public MoveUpCommand(GameEntity entity) {

        super(0, 0, entity);
    }

    public void execute() {

        if (entity != null)
            EntityController.instance().move(entity.getX(), entity.getY() + 1, entity);
    }
}
