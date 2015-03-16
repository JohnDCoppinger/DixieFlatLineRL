package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.General.MapView;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Actors.Actor;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

public class OpenInventoryMenuCommand implements Command {

    private Actor actor;

    private OpenInventoryMenuCommand() {}

    public OpenInventoryMenuCommand(Actor actor) {
        this.actor = actor;
    }

    public void execute() {

        Menu menu = actor.getInventory().getItemMenu();
        ((PlayerActionManager)actor.getManager()).setCurrentMenu(menu);
        MapView.instance().menuUpdate(menu);
    }
}
