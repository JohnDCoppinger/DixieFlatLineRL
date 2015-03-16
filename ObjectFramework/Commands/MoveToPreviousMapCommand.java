package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/16/2015.
 */
public class MoveToPreviousMapCommand implements Command {

    private GameEntity entity;

    private MoveToPreviousMapCommand() {}

    public MoveToPreviousMapCommand(GameEntity entity) {
        this.entity = entity;
    }

    public void execute() {

        EntityController.instance().changeMap(entity.getLevel() - 1);
        //TODO logic to place entity
    }
}
