package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveLeftCommand extends MoveCommand {

    private MoveLeftCommand() {}

    public MoveLeftCommand(GameEntity entity) {

        super(0, 0, entity);
    }

    public void execute() {

        EntityController.instance().moveLeft(entity);
    }
}
