package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.*;
import ObjectFramework.General.MapView;
import ObjectFramework.RL_Actors.Actor;

public class MenuState implements PlayerState {

    public MenuState() {}

    public Command getAction(Actor actor) {

        net.slashie.libjcsi.CharKey key = MapView.instance().inKey();

        if (key == null)
            return new NullCommand();

        if (key.toString().equalsIgnoreCase("w") || key.isUpArrow()) {
            return new MenuScrollUpCommand((PlayerActionManager) actor.getManager());
        }

        if (key.toString().equalsIgnoreCase("s") || key.isDownArrow()) {
            return new MenuScrollDownCommand((PlayerActionManager) actor.getManager());
        }

        if (key.toString().equalsIgnoreCase(" ")) {
            return new DropSelectedItemCommand((PlayerActionManager) actor.getManager());
        }

        if (key.toString().equalsIgnoreCase("e")) {
            return new CloseInventoryCommand((PlayerActionManager) actor.getManager());
        }

        if (key.toString().equalsIgnoreCase("g")) {
            return new ToggleEquipCommand((PlayerActionManager) actor.getManager());
        }

        return new NullCommand();
    }


}
