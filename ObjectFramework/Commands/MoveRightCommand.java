package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class MoveRightCommand extends MoveCommand{

    GameEntity entity;

    private MoveRightCommand(){}

    public MoveRightCommand(GameEntity entity) {

        this.entity = entity;
    }

    public void execute() {

        entity.setX(entity.getX() + 1);
    }
}
