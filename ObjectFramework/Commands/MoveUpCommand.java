package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveUpCommand extends MoveCommand {

    private MoveUpCommand() {}

    public MoveUpCommand(EntityController controller, GameEntity entity) {

        super(controller, 0, 0, entity);
    }

    public void execute() {

        this.controller.moveUp(entity);
    }
}
