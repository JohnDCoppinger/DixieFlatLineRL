package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;
import ObjectFramework.RL_Items.SimpleItemReaction;
import ObjectFramework.RenderComponents.Item.CorpseRenderComponent;

/**
 * Created by Gallanoth on 3/10/2015.
 */
public class KillCommand implements Command {

    private GameEntity entity;

    private KillCommand() {}

    public KillCommand(GameEntity entity) {

        this.entity = entity;
    }

    public void execute() {

        if (entity == null)
            return;

        GameEntity item = null;

        if (entity.getInventory() != null) {

            item = new GameEntity(new CorpseRenderComponent());
            item.setInventory(entity.getInventory());
            item.setReaction(new SimpleItemReaction(item));
        }

        EntityController.instance().swapEntity(entity.getX(), entity.getY(), item);
    }
}
