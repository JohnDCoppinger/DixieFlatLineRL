package ObjectFramework.Commands;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.EntityController;
import ObjectFramework.RenderComponents.Item.CorpseRenderComponent;

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
        }

        EntityController.instance().swapEntity(entity.getX(), entity.getY(), item);
    }
}
