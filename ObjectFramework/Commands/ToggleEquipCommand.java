package ObjectFramework.Commands;

import ObjectFramework.RL_Actors.Player.PlayerActionManager;

public class ToggleEquipCommand implements Command {

    private PlayerActionManager manager;

    private ToggleEquipCommand() {}

    public ToggleEquipCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {

    }
}
