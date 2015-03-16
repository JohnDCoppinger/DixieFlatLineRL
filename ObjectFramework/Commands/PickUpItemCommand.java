package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.Entity.InventoryComponent;
import ObjectFramework.RL_Actors.Actor;

//This command is very fragile. Not a good one.
public class PickUpItemCommand implements Command {

    private Actor actor;

    private PickUpItemCommand() {}

    public PickUpItemCommand(Actor actor) {
        this.actor = actor;
    }

    public void execute() {

        GameEntity beneath = actor.getBeneath();
        InventoryComponent mahNewStuff = null;

        if (beneath == null)
            return;

        while (beneath.getCombat() != null)
            beneath = beneath.getBeneath();

        if ((mahNewStuff = beneath.getInventory()) == null)
            return;

        while (mahNewStuff.inventorySize() > 0) {
            actor.getInventory().addItem(mahNewStuff.giveItem(0));
        }

        new RemoveEntityCommand(beneath).execute();
    }
}
