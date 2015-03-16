package ObjectFramework.Commands;

import ObjectFramework.RL_Actors.Player.PlayerActionManager;

public class ToggleEquipCommand implements Command {

    private PlayerActionManager manager;

    private ToggleEquipCommand() {}

    public ToggleEquipCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {

        if (manager.getCurrentMenu() != null) {
            int selected = manager.getCurrentMenu().getSelectedKey();
            manager.getClient().getCurrentEquipment().equip(manager.getClient().getInventory().referenceItem(selected));
        }
    }
}
