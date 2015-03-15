package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class RemoveEntityCommand implements Command {

    GameEntity entity;

    private RemoveEntityCommand() {}

    public RemoveEntityCommand(GameEntity removeEntity) {
        this.entity = removeEntity;
    }

    public void execute() {

        if (this.entity != null)
            EntityController.instance().swapEntity(this.entity.getX(), this.entity.getY(), null);
    }
}
