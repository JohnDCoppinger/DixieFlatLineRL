package ObjectFramework.General;

import ObjectFramework.RL_Map.CaveGenerator;
import ObjectFramework.RL_Map.DungeonGenerator;
import ObjectFramework.RL_Map.TownGenerator;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class EntityMapGenerator {

    private EntityController entities;
    private TerrainController terrain;
    private DungeonGenerator dungeons;
    private TownGenerator towns;
    private CaveGenerator caves;

    private EntityMapGenerator() {

        this.entities = EntityController.instance();
        this.terrain = TerrainController.instance();


    }

    public EntityMapGenerator(EntityController entities, TerrainController terrain) {

        this.entities = entities;
        this.terrain = terrain;
    }

    public void generateMap(String mapType) {

    }
}
