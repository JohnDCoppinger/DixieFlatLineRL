package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.MenuCommands.CloseInventoryCommand;
import ObjectFramework.Commands.MenuCommands.DropSelectedItemCommand;
import ObjectFramework.Commands.MenuCommands.MenuScrollDownCommand;
import ObjectFramework.Commands.MenuCommands.MenuScrollUpCommand;
import ObjectFramework.Commands.ToggleEquipCommand;
import ObjectFramework.General.MapView;
import ObjectFramework.RL_Actors.Actor;

public class MenuState implements PlayerState {

    public MenuState() {}

    public int performCommand(Actor actor) {

        net.slashie.libjcsi.CharKey key = MapView.instance().inKey();

        if (key == null)
            return 0;

        if (key.toString().equalsIgnoreCase("w") || key.isUpArrow()) {
            new MenuScrollUpCommand((PlayerActionManager) actor.getManager()).execute();
        }

        if (key.toString().equalsIgnoreCase("s") || key.isDownArrow()) {
            new MenuScrollDownCommand((PlayerActionManager) actor.getManager()).execute();
        }

        if (key.toString().equalsIgnoreCase(" ")) {
            new DropSelectedItemCommand((PlayerActionManager) actor.getManager()).execute();
        }

        if (key.toString().equalsIgnoreCase("e")) {
            new CloseInventoryCommand((PlayerActionManager) actor.getManager()).execute();
        }

        if (key.toString().equalsIgnoreCase("g")) {
            new ToggleEquipCommand((PlayerActionManager) actor.getManager()).execute();
        }

        return 0;
    }


}
