package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.Command;
import ObjectFramework.Commands.NullCommand;
import ObjectFramework.RL_Actors.Actor;

public class SetupState implements PlayerState {

    public Command getAction(Actor client) {
        return new NullCommand();
    }
}
