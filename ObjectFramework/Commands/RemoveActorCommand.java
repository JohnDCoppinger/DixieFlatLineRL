package ObjectFramework.Commands;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.General.EntityController;
import ObjectFramework.RL_Actors.Actor;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public class RemoveActorCommand implements Command{

    private Actor actor;

    public RemoveActorCommand(Actor actor) {
        this.actor = actor;
    }

    public void execute() {
        EntityController.instance().unregisterActor(actor);
    }
}
