package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.Command;
import ObjectFramework.Commands.NullCommand;
import ObjectFramework.RL_Actors.Actor;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public class SetupState implements PlayerState {

    public Command getAction(Actor client) {
        return new NullCommand();
    }
}
