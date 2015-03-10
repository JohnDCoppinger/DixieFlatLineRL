package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class MoveCommand extends Command {

    private int x;
    private int y;
    private GameEntity entity;

    protected MoveCommand() {}

    public MoveCommand(GameEntity entity, int x, int y) {

        this.x = x;
        this.y = y;
        this.entity = entity;
    }

    //should this check if the move location is valid? Probably
    public void execute() {

        this.entity.setX(x);
        this.entity.setY(y);
    }
}
