package ObjectFramework.General;

import java.util.LinkedList;

public class MessageQueue extends LinkedList<String> {

    private static MessageQueue instance;

    public static MessageQueue getInstance() {

        if (instance == null)
            instance = new MessageQueue();

        return instance;
    }

    private MessageQueue() {
        super();
    }
}
