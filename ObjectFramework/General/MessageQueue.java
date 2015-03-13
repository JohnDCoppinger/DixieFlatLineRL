package ObjectFramework.General;

import java.util.LinkedList;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class MessageQueue extends LinkedList<String> {

    private static MessageQueue instance;

    public MessageQueue getInstance() {

        if (instance == null)
            instance = new MessageQueue();

        return instance;
    }

    public MessageQueue() {
        super();
    }
}
