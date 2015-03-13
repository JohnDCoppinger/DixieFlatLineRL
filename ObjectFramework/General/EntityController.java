package ObjectFramework.General;

import ObjectFramework.Commands.AttackCommand;
import ObjectFramework.Entity.GameEntity;

import java.util.Observer;

public class EntityController {

    private static EntityController instance;

    public static EntityController instance() {

        if (instance == null)
            instance = new EntityController();

        return instance;
    }

    private EntityModel model;

    private TerrainController terrain;

    private EntityController(){}

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

        if (initiator != null && initiator.getReaction() != null)
            initiator.getReaction().defaultAction(defender);

        if (defender != null && defender.getReaction() != null)
            defender.getReaction().react(initiator);
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

    public void registerModel(Observer observer) {
        this.model.register(observer);
    }

    public void registerModel(Observer observer, int startx, int starty, int endx, int endy) {
        this.model.register(observer);
    }

    public EntityModel getModel() {
        return model;
    }

    public void setModel(EntityModel model) {
        this.model = model;
    }

    public TerrainController getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainController terrain) {
        this.terrain = terrain;
    }

    public int addMap(EntityMap newMap) {
        return this.model.addMap(newMap);
    }

    public void changeMap(int map) {
        this.model.changeMap(map);
    }
}
