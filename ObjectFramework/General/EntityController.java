package ObjectFramework.General;

import ObjectFramework.Commands.AttackCommand;
import ObjectFramework.Entity.GameEntity;

public class EntityController {

    private static EntityController instance;

    public static EntityController instance() {

        if (instance == null)
            instance = new EntityController(); //TODO make this a real constructor!!!!!!

        return instance;
    }

    private EntityModel model;
    private TerrainController terrain;

    private EntityController(){}

    private EntityController(EntityModel model, TerrainController terrain) {

        this.model = model;
        this.terrain = terrain;
    }

    public void move(int x, int y, GameEntity requester) {

        if (!terrainClippable(x, y))
            return;

        if (!entityClippable(x, y))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY()));

        this.model.moveEntity(x, y, requester);
    }

    public void moveUp(GameEntity requester) {

        if (!terrainClippable(requester.getX(), requester.getY() + 1))
            return;

        else if (!entityClippable(requester.getX(), requester.getY() + 1))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY() + 1));

        else
            this.model.moveEntity(requester.getX(), requester.getY() + 1, requester);
    }

    public void moveDown(GameEntity requester) {

        if (!terrainClippable(requester.getX(), requester.getY() - 1))
            return;

        else if (!entityClippable(requester.getX(), requester.getY() - 1))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY() - 1));

        else
            this.model.moveEntity(requester.getX(), requester.getY() - 1, requester);
    }

    public void moveRight(GameEntity requester) {

        if (!terrainClippable(requester.getX() + 1, requester.getY()))
            return;

        else if (!entityClippable(requester.getX() + 1, requester.getY()))
            entityInteraction(requester, model.getEntity(requester.getX() + 1, requester.getY()));

        else
            this.model.moveEntity(requester.getX() + 1, requester.getY(), requester);
    }

    public void moveLeft(GameEntity requester) {

        if (!terrainClippable(requester.getX() - 1, requester.getY()))
            return;

        else if (!entityClippable(requester.getX() - 1, requester.getY()))
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
        //TODO
    }

    public void attackArea(int x, int y, GameEntity aggressor, AttackCommand attack) {
        //TODO
    }

    private boolean terrainClippable(int x, int y) {
        return terrain.checkPath(x, y);
    }

    private boolean entityClippable(int x, int y) {

        GameEntity entity = this.model.getEntity(x, y);

        if (entity == null)
            return false;

        return entity.clippable();
    }
}
