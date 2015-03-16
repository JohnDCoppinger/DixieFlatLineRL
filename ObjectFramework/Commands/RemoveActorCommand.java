package ObjectFramework.Commands;

import ObjectFramework.General.EntityController;
import ObjectFramework.RL_Actors.Actor;

public class RemoveActorCommand implements Command{

    private Actor actor;

    public RemoveActorCommand(Actor actor) {
        this.actor = actor;
    }

    public void execute() {
        EntityController.instance().unregisterActor(actor);
    }
}
