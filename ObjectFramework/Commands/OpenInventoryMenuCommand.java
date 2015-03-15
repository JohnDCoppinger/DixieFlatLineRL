package ObjectFramework.Commands;

import ObjectFramework.RL_Actors.Actor;

/**
 * Created by Gallanoth on 3/15/2015.
 */
public class OpenInventoryMenuCommand implements Command {

    private Actor actor;

    private OpenInventoryMenuCommand() {}

    public OpenInventoryMenuCommand(Actor actor) {
        this.actor = actor;
    }

    public void execute() {
        //TODO
    }
}
