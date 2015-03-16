package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;

public class HealCommand implements Command{

    private int heal;
    private GameEntity entity;

    private HealCommand() {}

    public HealCommand(GameEntity entity, int heal) {

    }

    public void execute() {

        if (this.entity.getCombat() != null)
            this.entity.getCombat().heal(heal);
    }
}
