package ObjectFramework.Commands;

import ObjectFramework.RL_Actors.Player.PlayerActionManager;

/**
 * Created by Gallanoth on 3/15/2015.
 */
public class ToggleEquipCommand implements Command {

    private PlayerActionManager manager;

    private ToggleEquipCommand() {}

    public ToggleEquipCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {
        //TODO
    }
}
