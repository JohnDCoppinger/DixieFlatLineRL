package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class MoveCommand implements Command {

    protected int x;
    protected int y;
    protected GameEntity entity;
    protected EntityController controller;

    protected MoveCommand() {}

    public MoveCommand(EntityController controller, int x, int y, GameEntity entity) {

        this.x = x;
        this.y = y;
        this.entity = entity;
        this.controller = controller;
    }

    //should this check if the move location is valid? Probably
    public void execute() {

        this.controller.move(x, y, entity);
    }
}
