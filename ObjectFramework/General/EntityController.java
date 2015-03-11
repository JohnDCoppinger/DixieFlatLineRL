package ObjectFramework.General;

import ObjectFramework.Commands.AttackCommand;
import ObjectFramework.Commands.Command;
import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class EntityController {

    private EntityModel model;
    private MapController terrain;

    private EntityController(){}

    public EntityController(EntityModel model, MapController terrain) {

        this.model = model;
        this.terrain = terrain;
    }

    public void move(int x, int y, GameEntity requester) {

        if (!terrainPathable(x, y))
            return;

        if (!entityPathable(x, y))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY()));

        this.model.moveEntity(x, y, requester);
    }

    public void moveUp(GameEntity requester) {

        if (!terrainPathable(requester.getX(), requester.getY() + 1))
            return;

        else if (!entityPathable(requester.getX(), requester.getY() + 1))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY() + 1));

        else
            this.model.moveEntity(requester.getX(), requester.getY() + 1, requester);
    }

    public void moveDown(GameEntity requester) {

        if (!terrainPathable(requester.getX(), requester.getY() - 1))
            return;

        else if (!entityPathable(requester.getX(), requester.getY() - 1))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY() - 1));

        else
            this.model.moveEntity(requester.getX(), requester.getY() - 1, requester);
    }

    public void moveRight(GameEntity requester) {

        if (!terrainPathable(requester.getX() + 1, requester.getY()))
            return;

        else if (!entityPathable(requester.getX() + 1, requester.getY()))
            entityInteraction(requester, model.getEntity(requester.getX() + 1, requester.getY()));

        else
            this.model.moveEntity(requester.getX() + 1, requester.getY(), requester);
    }

    public void moveLeft(GameEntity requester) {

        if (!terrainPathable(requester.getX() - 1, requester.getY()))
            return;

        else if (!entityPathable(requester.getX() - 1, requester.getY()))
            entityInteraction(requester, model.getEntity(requester.getX() - 1, requester.getY()));

        else
            this.model.moveEntity(requester.getX() - 1, requester.getY(), requester);
    }

    public void kill(GameEntity corpse) {

        if (corpse == null)
            return;

        GameEntity item = null;

        if (corpse.getInventory() != null) {

            item = new GameEntity();
            item.setInventory(corpse.getInventory());
        }

        this.model.swapEntity(corpse.getX(), corpse.getY(), item);
    }

    public void entityInteraction(GameEntity initiator, GameEntity defender) {

    }

    public void attackArea(GameEntity aggressor, int x, int y, AttackArea area, AttackCommand attack) {
        //TODO
    }

    private boolean terrainPathable(int x, int y) {

        return terrain.checkPath(x, y);
    }

    private boolean entityPathable(int x, int y) {

        GameEntity entity = this.model.getEntity(x, y);

        if (entity == null)
            return false;

        return entity.getReaction().clippable();
    }
}
