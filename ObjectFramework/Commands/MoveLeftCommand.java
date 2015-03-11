package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveLeftCommand extends MoveCommand {

    private MoveLeftCommand() {}

    public MoveLeftCommand(EntityController controller, GameEntity entity) {

        super(controller, 0, 0, entity);
    }

    public void execute() {

        this.controller.moveLeft(entity);
    }
}
