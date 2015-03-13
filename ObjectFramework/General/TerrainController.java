package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 2/26/2015.
 */
public class TerrainController {

    private static TerrainController instance;

    private EntityModel model;

    //TODO work on getting an actual model into the instance
    public static TerrainController instance() {

        if (instance == null)
            instance = new TerrainController();

        return instance;
    }

    private TerrainController(){}

    private TerrainController(EntityModel model) {

        this.model = model;
    }

    public boolean checkPath(int x, int y) {

        GameEntity terrainObject = this.model.getEntity(x, y);

        if (terrainObject == null)
            return false;

        return terrainObject.clippable();
    }

    public void addMap(EntityMap newMap) {
        this.model.addMap(newMap);
    }

    public void changeMap(int map) {
        this.model.changeMap(map);
    }
}
