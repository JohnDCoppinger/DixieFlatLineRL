package ObjectFramework.General;

import ObjectFramework.RL_Map.*;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class EntityMapGenerator {

    private static EntityMapGenerator instance;

    public static EntityMapGenerator instance() {
        if (instance == null)
            instance = new EntityMapGenerator();

        return instance;
    }

    private EntityController entities;
    private MapGenerator map;
    private ActorMapGenerator actorMap;
    private int x;
    private int y;
    private int numObjects;
    private int numOfActors;

    private EntityMapGenerator() {

        this.entities = EntityController.instance();
    }

    public void setMapValues(int x, int y, int numObjects, int numOfActors)
    {
        this.x = x;
        this.y = y;
        this.numObjects = numObjects;
        this.numOfActors = numOfActors;
    }

    public EntityMap generateMap(String mapType)
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
            actorMap = new CaveActorMapGenerator(map.getMap(),numOfActors);
        else if(mapType.equalsIgnoreCase("Town"))
            actorMap = new TownActorMapGenerator(map.getMap(), numOfActors);
        else
            actorMap = new DungeonActorMapGenerator(map.getMap(),numOfActors);

        actorMapTemp = actorMap.createEntityMap();

        for(int x = 0; x < actorMapTemp.length; x ++)
            for(int y = 0; y < actorMapTemp[0].length; y++)
            {
                if(actorMapTemp[x][y] == 'M')
                {
                    ;//gameMap.moveEntity(x,y,new MonsterEntity());
                }
                if(actorMapTemp[x][y] == 'T')
                {
                    ;//gameMap.moveEntity(x,y,new TrapEntity());
                }

                if(actorMapTemp[x][y] == 'C')
                {
                    ;//gameMap.moveEntity(x,y,new ChestEntity);
                }
                if(actorMapTemp[x][y] == '@')
                {
                    ;//gameMap.moveEntity(x,y,new PartyEntity());
                }
            }

        return  gameMap;
    }
}
