package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.*;
import ObjectFramework.General.MapView;
import ObjectFramework.RL_Actors.Actor;

public class CombatState implements PlayerState {

    private MoveCommand lastMove;

    public CombatState() {
        this.lastMove = null;
    }

    public Command getAction(Actor client) {

            net.slashie.libjcsi.CharKey key = MapView.instance().inKey();

            if (key.toString().equalsIgnoreCase("w") || key.toString().equalsIgnoreCase("")) {
                return (lastMove = new MoveUpCommand(client));
            }

            if (key.toString().equalsIgnoreCase("a")) {
                return (lastMove = new MoveLeftCommand(client));
            }

            if (key.toString().equalsIgnoreCase("s")) {
                return (lastMove = new MoveDownCommand(client));
            }

            if (key.toString().equalsIgnoreCase("d")) {
                return (lastMove = new MoveRightCommand(client));
            }

            if (key.toString().equalsIgnoreCase("e")) {
                return new OpenInventoryMenuCommand(client);
            }

            if (key.toString().equalsIgnoreCase("SPACE")) {
                return new PickUpItemCommand(client);
            }

            return new NullCommand();
    }
}
