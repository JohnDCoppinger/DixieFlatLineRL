package ObjectFramework.General;

import ObjectFramework.Commands.Command;

import java.util.LinkedList;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class CommandQueue extends LinkedList<Command> {

    private static CommandQueue instance;

    public static CommandQueue getInstance() {

        if (instance == null)
            instance = new CommandQueue();

        return instance;
    }

    private CommandQueue() {
        super();
    }
}
