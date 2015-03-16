package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

/**
 * Created by Gallanoth on 3/15/2015.
 */
public class CloseInventoryCommand implements Command {

    private PlayerActionManager manager;

    private CloseInventoryCommand() {}

    public CloseInventoryCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {
        //TODO
    }
}
