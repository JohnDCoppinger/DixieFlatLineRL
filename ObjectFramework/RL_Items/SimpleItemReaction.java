package ObjectFramework.RL_Items;

import ObjectFramework.Commands.RemoveEntityCommand;
import ObjectFramework.Entity.GameEntity;
import ObjectFramework.Entity.ReactionComponent;


/**
 * Created by Gallanoth on 3/13/2015.
 */
public class SimpleItemReaction implements ReactionComponent{

    private GameEntity owner;

    private SimpleItemReaction() {}

    public SimpleItemReaction(GameEntity owner) {
        this.owner = owner;
    }

    public void react(GameEntity triggerer) {

        if (this.owner != null) {
            if(this.owner.getInventory() != null) {
                if (this.owner.getInventory().inventorySize() == 0) {
                    new RemoveEntityCommand(this.owner).execute();
                }
            }
        }
    }

    public void defaultAction(GameEntity triggerer) {
        //No default action
    }
}
