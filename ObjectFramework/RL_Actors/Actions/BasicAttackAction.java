package ObjectFramework.RL_Actors.Actions;

import ObjectFramework.Commands.AttackCommand;
import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.RandomNumber;

public class BasicAttackAction implements Action{

    private int cost;
    private int basePower;

    private BasicAttackAction() {
        this.cost = 3;
    }

    public BasicAttackAction(int basePower) {
        this();
        this.basePower = basePower;
    }

    public void perform(GameEntity affected) {
        new AttackCommand(affected, basePower + (int)((basePower/10)* RandomNumber.instance().generate())).execute();
    }

    public int actionCost() {
        return this.cost;
    }
}
