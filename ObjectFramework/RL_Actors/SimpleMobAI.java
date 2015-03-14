package ObjectFramework.RL_Actors;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public class SimpleMobAI implements ActionManager {

    private Actor client;

    private SimpleMobAI() {}

    public SimpleMobAI(Actor client) {
        this.client = client;
    }

    public void performActions() {
        //TODO

        /**
         * The intelligence of the mob is encapsualted here, so it should probably ask for a region around itself, or
         * for the whole map, and then path to the player and try to attack them. ActionManagers use
         */
    }

    public int getInitiative() {
        return client.getInitiative();
    }

    public int compareTo(ActionManager actor) {
        return client.getInitiative() - actor.getInitiative();
    }
}
