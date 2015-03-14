package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveRightCommand extends MoveCommand{

    private MoveRightCommand() {}

    public MoveRightCommand(GameEntity entity) {

        super(0, 0, entity);
    }

    public void execute() {

        if (entity != null)
            EntityController.instance().move(entity.getX() + 1, entity.getY(), entity);
    }
}
