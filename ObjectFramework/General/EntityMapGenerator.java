package ObjectFramework.General;
import ObjectFramework.RL_Map.TownGenerator;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class EntityMapGenerator {

    private EntityController entities;
    private MapController terrain;
    private TownGenerator towns;
    private CaveGenerator caves;
    private DungeonGenerator dungeons;

    private EntityMapGenerator() {}

    public EntityMapGenerator(EntityController entity, MapController terrain) {


    }

    public void createNewMap(String type) {

        //Generates a new map and inserts them into the controllers
    }
}
