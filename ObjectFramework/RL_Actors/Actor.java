package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.RL_Items.CurrentEquipment;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public class Actor extends GameEntity {

    private CurrentEquipment equipment;
    private ActionManager manager;
    private int initiative;
    private String name;

    private Actor(){}

    public Actor(String name, int initiative, ActionManager manager) {

        this.name = name;
        this.initiative = initiative;
        this.manager = manager;
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
