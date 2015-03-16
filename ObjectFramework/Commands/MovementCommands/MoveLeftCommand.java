package ObjectFramework.Commands.MovementCommands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

public class MoveLeftCommand extends MoveCommand {

    private MoveLeftCommand() {}

    public MoveLeftCommand(GameEntity entity) {

        super(0, 0, entity);
    }

    public void execute() {

        if (entity != null)
            EntityController.instance().move(entity.getX() - 1, entity.getY(), entity);
    }
}
