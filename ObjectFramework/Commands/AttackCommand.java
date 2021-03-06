package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;

public class AttackCommand implements Command {

    private GameEntity entity;
    private int damage;

    private AttackCommand() {}

    public AttackCommand(GameEntity entity, int damage) {

        this.entity = entity;
        this.damage = damage;
    }

    public void execute() {

        if (entity.getCombat() != null)
            entity.getCombat().takeDamage(damage);
    }
}
