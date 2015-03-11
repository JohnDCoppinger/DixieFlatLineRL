package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveUpCommand extends MoveCommand {

    private MoveUpCommand() {}

    public MoveUpCommand(GameEntity entity) {

        super(0, 0, entity);
    }

    public void execute() {

        EntityController.instance().moveUp(entity);
    }
}
