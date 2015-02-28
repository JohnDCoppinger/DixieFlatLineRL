package ObjectFramework.RL_Actors;
import ObjectFramework.General.GameEntity;
/**
 * Created by Gallanoth on 1/29/2015.
 */
public class Actor extends GameEntity {

    InventoryManager inventory;
    ActorClass actorClass;
    ActorController controller;

    public String name;

    public Actor(){}

    public char render() {

        return 0;
    }

}
