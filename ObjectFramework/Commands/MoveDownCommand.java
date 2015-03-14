package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveDownCommand extends MoveCommand {

    private MoveDownCommand() {}

    public MoveDownCommand(GameEntity entity) {

        super(0, 0, entity);
    }

    public void execute() {

        if (entity != null)
            EntityController.instance().move(entity.getX(), entity.getY() - 1, entity);
    }
}
