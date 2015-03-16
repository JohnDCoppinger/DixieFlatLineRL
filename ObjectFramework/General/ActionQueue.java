package ObjectFramework.General;

import ObjectFramework.RL_Actors.ActionManager;

import java.util.PriorityQueue;

public class ActionQueue extends PriorityQueue<ActionManager>{

    private static ActionQueue instance;

    public static ActionQueue instance()  {

        if (instance == null)
            instance = new ActionQueue();

        return instance;
    }

    private ActionQueue() {
        super();
    }
}
