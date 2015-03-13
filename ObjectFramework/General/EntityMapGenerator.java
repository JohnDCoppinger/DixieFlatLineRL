package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;
import ObjectFramework.RL_Actors.ActionManager;
import ObjectFramework.RL_Map.*;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class EntityMapGenerator {

    private EntityController entities;
    private TerrainController terrain;
    private MapGenerator map;
    private ActorMapGenerator actorMap;
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
        char[][] actorMapTemp;
        EntityMap gameMap;

        if(mapType.equalsIgnoreCase("Cave"))
            map = new CaveGenerator();
        else if(mapType.equalsIgnoreCase("Town"))
            map = new TownGenerator();
        else
            map = new DungeonGenerator();

        map.createMap(x,y,numObjects);

        gameMap = EntityMap.createMap(map.getMap());

        if(mapType.equalsIgnoreCase("Cave"))
            actorMap = new CaveActorMapGenerator(map.getMap(),numObjects);
        else if(mapType.equalsIgnoreCase("Town"))
            actorMap = new TownActorMapGenerator(map.getMap(), numObjects);
        else
            actorMap = new DungeonActorMapGenerator(map.getMap(),numObjects);

        actorMapTemp = actorMap.createEntityMap();


        ///////

    }
}
