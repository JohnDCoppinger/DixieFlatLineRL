package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/10/2015.
 */
public class KillCommand implements Command {

    private GameEntity entity;

    private KillCommand() {}

    public KillCommand(GameEntity entity) {

        this.entity = entity;
    }

    public void execute() {

        EntityController.instance().kill(entity);
    }
}
