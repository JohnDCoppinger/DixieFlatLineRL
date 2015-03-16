package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/16/2015.
 */
public class MoveToNextMapCommand implements Command {

    GameEntity entity;

    private MoveToNextMapCommand() {}

    public MoveToNextMapCommand(GameEntity entity) {
        this.entity = entity;
    }

    public void execute() {

        EntityController.instance().changeMap(entity.getLevel() + 1);
        //TODO place entity on map
    }
}
