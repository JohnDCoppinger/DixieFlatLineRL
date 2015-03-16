package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.RL_Items.CurrentEquipment;
import ObjectFramework.RenderComponents.Actor.ActorRenderComponentSimple;

public class Actor extends GameEntity {

    private CurrentEquipment equipment;
    private ActionManager manager;
    private int initiative;
    private String name;

    private Actor(){

        this.equipment = new CurrentEquipment();
        this.combat = new SimpleActorCombat(this, 50, 4, 0.15);
        this.inventory = new ActorInventoryComponent();
        this.reaction = new SimpleActorClass();
        this.render = new ActorRenderComponentSimple();
    }

    public Actor(String name, int initiative, ActionManager manager) {

        this();
        this.name = name;
        this.initiative = initiative;
        this.manager = manager;
        ((ActorInventoryComponent)this.inventory).setInventoryName(name);
    }

    public ActionManager getManager() {
        return this.manager;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public ActorClass getActorClass() {
        return (ActorClass) this.getReaction();
    }

    public CurrentEquipment getCurrentEquipment() {
        return this.equipment;
    }
}
