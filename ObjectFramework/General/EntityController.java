package ObjectFramework.General;

import ObjectFramework.Commands.AttackCommand;
import ObjectFramework.Commands.Command;
import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class EntityController {

    private EntityModel model;

    private EntityController(){}

    public EntityController(EntityModel model) {

        this.model = model;
    }

    public void requestMove(GameEntity requester, int x, int y) {

    }

    public void moveUp(GameEntity requester) {

    }

    public void moveDown(GameEntity requester) {

    }

    public void moveLeft(GameEntity requester) {

    }

    public void moveRight(GameEntity requester) {

    }

    public void entityInteraction(GameEntity initiator, GameEntity defender, Command action) {

    }

    public void attackArea(GameEntity aggressor, int x, int y, AttackArea area, AttackCommand attack) {

    }
}
