package ObjectFramework.Commands;

import ObjectFramework.RL_Actors.Player.PlayerActionManager;

/**
 * Created by Gallanoth on 3/15/2015.
 */
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
