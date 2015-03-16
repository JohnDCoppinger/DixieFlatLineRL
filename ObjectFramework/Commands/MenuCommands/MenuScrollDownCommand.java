package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

/**
 * Created by Gallanoth on 3/15/2015.
 */
public class MenuScrollDownCommand implements Command {

    private PlayerActionManager manager;

    private MenuScrollDownCommand() {}

    public MenuScrollDownCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {

        Menu menu;

        if ((menu = manager.getCurrentMenu()) != null) {

            menu.select(menu.getSelected() - 1);
            manager.displayMenu();
        }
    }
}
