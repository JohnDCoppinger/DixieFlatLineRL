package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.MenuCommands.OpenInventoryMenuCommand;
import ObjectFramework.Commands.MovementCommands.MoveDownCommand;
import ObjectFramework.Commands.MovementCommands.MoveLeftCommand;
import ObjectFramework.Commands.MovementCommands.MoveRightCommand;
import ObjectFramework.Commands.MovementCommands.MoveUpCommand;
import ObjectFramework.Commands.PickUpItemCommand;
import ObjectFramework.General.MapView;
import ObjectFramework.RL_Actors.Actor;

public class CombatState implements PlayerState {

    //private MoveCommand lastMove;

    public CombatState() {
        //this.lastMove = null;
    }

    public int performCommand(Actor client) {

            net.slashie.libjcsi.CharKey key = MapView.instance().inKey();

            if (key == null)
                return 0;

            if (key.toString().equalsIgnoreCase("w") || key.isUpArrow()) {
                new MoveUpCommand(client).execute();
                return 1;
            }

            if (key.toString().equalsIgnoreCase("a") || key.isLeftArrow()) {
                new MoveLeftCommand(client).execute();
                return 1;
            }

            if (key.toString().equalsIgnoreCase("s") || key.isDownArrow()) {
                new MoveDownCommand(client).execute();
                return 1;
            }

            if (key.toString().equalsIgnoreCase("d") || key.isRightArrow()) {
                new MoveRightCommand(client).execute();
                return 1;
            }

            if (key.toString().equalsIgnoreCase("e")) {
                new OpenInventoryMenuCommand(client).execute();
                return 0;
            }

            if (key.toString().equalsIgnoreCase(" ")) {
                new PickUpItemCommand(client).execute();
                return 0;
            }

            return 0;
    }
}
