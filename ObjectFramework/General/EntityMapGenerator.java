package ObjectFramework.General;

import ObjectFramework.RL_Map.CaveGenerator;
import ObjectFramework.RL_Map.DungeonGenerator;
import ObjectFramework.RL_Map.MapGenerator;
import ObjectFramework.RL_Map.TownGenerator;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class EntityMapGenerator {

    private EntityController entities;
    private TerrainController terrain;
    private MapGenerator map;
    private int x;
    private int y;
    private int numObjects;

    private EntityMapGenerator() {

        this.entities = EntityController.instance();
        this.terrain = TerrainController.instance();
    }

    public EntityMapGenerator(EntityController entities, TerrainController terrain) {

        this.entities = entities;
        this.terrain = terrain;
    }

    public void setMapValues(int x, int y, int numObjects)
    {
        this.x = x;
        this.y = y;
        this.numObjects = numObjects;
    }

    public void generateMap(String mapType)
    {
        if(mapType.equalsIgnoreCase("Cave"))
            map = new CaveGenerator();
        else if(mapType.equalsIgnoreCase("Town"))
            map = new TownGenerator();
        else
            map = new DungeonGenerator();

        map.createMap(x,y,numObjects);
    }
}
