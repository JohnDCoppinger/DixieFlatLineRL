package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

/**
 * Created by Gallanoth on 3/15/2015.
 */
public class MenuScrollUpCommand implements Command {

    PlayerActionManager manager;

    private MenuScrollUpCommand() {}

    public MenuScrollUpCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {
        //TODO
    }
}
