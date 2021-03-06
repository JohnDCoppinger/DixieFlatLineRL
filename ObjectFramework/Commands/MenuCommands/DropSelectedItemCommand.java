package ObjectFramework.Commands.MenuCommands;

import ObjectFramework.Commands.Command;
import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;
import ObjectFramework.RL_Items.Item;
import ObjectFramework.RL_Items.SimpleItemInventory;
import ObjectFramework.RenderComponents.Item.CorpseRenderComponent;

public class DropSelectedItemCommand implements Command {

    private PlayerActionManager manager;

    private DropSelectedItemCommand() {}

    public DropSelectedItemCommand(PlayerActionManager manager) {
        this.manager = manager;
    }

    public void execute() {

        GameEntity beneath;

        if (manager.getCurrentMenu() != null) {

            int itemNo = manager.getCurrentMenu().getSelectedKey();
            manager.getCurrentMenu().remove(itemNo);
            Item item = manager.getClient().getInventory().giveItem(itemNo);

            for(beneath = manager.getClient().getBeneath(); beneath.getCombat() != null; beneath = beneath.getBeneath());

            if (beneath.getInventory() == null) {

                GameEntity newEntity = new GameEntity(new CorpseRenderComponent());
                newEntity.setInventory(new SimpleItemInventory(item));
                newEntity.setBeneath(manager.getClient().getBeneath());
                manager.getClient().setBeneath(newEntity);
            }

            else {
                beneath.getInventory().addItem(item);
            }
        }
    }
}
