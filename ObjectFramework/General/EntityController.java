package ObjectFramework.General;

import ObjectFramework.Commands.AttackCommand;
import ObjectFramework.Entity.GameEntity;
import ObjectFramework.RL_Actors.ActionManager;
import ObjectFramework.RL_Actors.Actor;
import ObjectFramework.RL_Items.SimpleItemReaction;
import ObjectFramework.RenderComponents.Item.CorpseRenderComponent;

import java.util.ArrayList;
import java.util.Observer;

public class EntityController {

    private static EntityController instance;

    public static EntityController instance() {

        if (instance == null)
            instance = new EntityController();

        return instance;
    }

    private EntityModel model;
    private ArrayList<ActionManager> actors;

    private EntityController(){
        this.actors = new ArrayList<ActionManager>();
    }

    public void move(int x, int y, GameEntity requester) {

        if (!entityClippable(x, y))
            entityInteraction(requester, model.getEntity(requester.getX(), requester.getY()));

        this.model.moveEntity(x, y, requester);
    }

    public void kill(GameEntity corpse) {

        if (corpse == null)
            return;

        GameEntity item = null;

        if (corpse.getInventory() != null) {

            item = new GameEntity(new CorpseRenderComponent());
            item.setInventory(corpse.getInventory());
            item.setReaction(new SimpleItemReaction(item));
        }

        this.model.swapEntity(corpse.getX(), corpse.getY(), item);
    }

    public void swapEntity(int x, int y, GameEntity entity) {

        this.model.swapEntity(x, y, entity);
    }

    public void entityInteraction(GameEntity initiator, GameEntity defender) {

        if (initiator != null && initiator.getReaction() != null)
            initiator.getReaction().defaultAction(defender);

        if (defender != null && defender.getReaction() != null)
            defender.getReaction().react(initiator);
    }

    public void interactArea(int x, int y, GameEntity aggressor) {
        //TODO
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

    public int addMap(EntityMap newMap) {
        return this.model.addMap(newMap);
    }

    public void changeMap(int map) {
        this.model.changeMap(map);
    }

    public void registerActor(Actor actor) {
        actors.add(actor.getManager());
    }

    public void unregisterActor(Actor actor) {
        ActionQueue.instance().remove(actor.getManager());
    }

    public void populateQueue() {

        ActionQueue queue = ActionQueue.instance();

        for (ActionManager manager : actors)
            queue.add(manager);
    }
}
