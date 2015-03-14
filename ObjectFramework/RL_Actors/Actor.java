package ObjectFramework.RL_Actors;
import ObjectFramework.Entity.CombatComponent;
import ObjectFramework.Entity.GameEntity;
import ObjectFramework.Entity.InventoryComponent;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public class Actor extends GameEntity {

    ActorController controller;
    private String name;

    public Actor(){}

    public char render() {

        return 0;
    }

}
