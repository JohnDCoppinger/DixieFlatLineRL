package ObjectFramework.RL_Actors;
import ObjectFramework.Entity.GameEntity;
import ObjectFramework.Entity.InventoryManager;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public class Actor {

    InventoryManager inventory;
    ActorClass actorClass;
    ActorController controller;

    public String name;

    public Actor(){}

    public char render() {

        return 0;
    }

}
