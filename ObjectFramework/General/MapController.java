package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 2/26/2015.
 */
public class MapController {

    private EntityModel model;

    private MapController(){}

    public MapController(EntityModel model) {

        this.model = model;
    }

    public boolean checkPath(int x, int y) {

        GameEntity terrainObject = this.model.getEntity(x, y);

        if (terrainObject == null)
            return false;

        return terrainObject.getReaction().clippable();
    }
}
