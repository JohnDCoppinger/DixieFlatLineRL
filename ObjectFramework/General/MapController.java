package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 2/26/2015.
 */
public class MapController {

    private static MapController instance;

    private EntityModel model;

    //TODO work on getting an actual model into the instance
    public static MapController instance() {

        if (instance == null)
            instance = new MapController();

        return instance;
    }

    private MapController(){}

    private MapController(EntityModel model) {

        this.model = model;
    }

    public boolean checkPath(int x, int y) {

        GameEntity terrainObject = this.model.getEntity(x, y);

        if (terrainObject == null)
            return false;

        return terrainObject.clippable();
    }
}
