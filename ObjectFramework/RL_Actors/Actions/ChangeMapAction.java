package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.MoveToNextMapCommand;
import ObjectFramework.Commands.MoveToPreviousMapCommand;
import ObjectFramework.General.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/16/2015.
 */
public class ChangeMapAction implements Action {

    private String direction;

    private ChangeMapAction() {}

    public ChangeMapAction(String direction) {
        this.direction = direction;
    }


    public int actionCost() {
        return 0;
    }

    public void perform(GameEntity entity) {

        if (direction.equalsIgnoreCase("up")) {
            new MoveToPreviousMapCommand(entity).execute();
        }

        else
            new MoveToNextMapCommand(entity).execute();
    }
}
