package ObjectFramework.RL_Actors;
import ObjectFramework.Entity.CombatComponent;
import ObjectFramework.Entity.GameEntity;
import ObjectFramework.Entity.InventoryComponent;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public class Actor extends GameEntity {

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

}
