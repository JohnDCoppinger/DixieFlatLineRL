package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class HealCommand implements Command{

    private int heal;
    private GameEntity entity;

    private HealCommand() {}

    public HealCommand(GameEntity entity, int heal) {

    }

    public void execute() {

        if (this.entity.getCombat() != null)
            this.entity.getCombat().increaseHP(heal);
        else
            ;//TODO add message queue thing here
    }
}
