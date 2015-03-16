package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

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
