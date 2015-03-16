package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

public class CloseInventoryCommand implements Command {

    private PlayerActionManager manager;

    private CloseInventoryCommand() {}

    public CloseInventoryCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {

        manager.setCurrentMenu(null);
        manager.displayMenu();
    }
}
