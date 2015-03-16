package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.General.MapView;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

public class MenuScrollUpCommand implements Command {

    PlayerActionManager manager;

    private MenuScrollUpCommand() {}

    public MenuScrollUpCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {

        Menu menu;

        if ((menu = manager.getCurrentMenu()) != null) {

            menu.select(menu.getSelected() + 1);
            manager.displayMenu();
        }
    }
}
