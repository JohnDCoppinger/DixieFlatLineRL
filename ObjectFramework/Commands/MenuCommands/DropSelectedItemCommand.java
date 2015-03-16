package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

public class DropSelectedItemCommand implements Command {

    private PlayerActionManager manager;

    private DropSelectedItemCommand() {}

    public DropSelectedItemCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {
        //TODO
    }
}
