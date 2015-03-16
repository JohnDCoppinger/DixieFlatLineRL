package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.General.MapView;
import ObjectFramework.General.Menu.Menu;
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

        Menu menu = actor.getInventory().getItemMenu();
        MapView.instance().menuUpdate(menu);
    }
}
