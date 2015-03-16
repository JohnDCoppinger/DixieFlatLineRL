package ObjectFramework.Commands;

import ObjectFramework.RL_Actors.Actor;

/**
 * Created by Gallanoth on 3/15/2015.
 */
public class PickUpItemCommand implements Command {

    private Actor actor;

    private PickUpItemCommand() {}

    public PickUpItemCommand(Actor actor) {
        this.actor = actor;
    }

    public void execute() {
        //TODO
    }
}
