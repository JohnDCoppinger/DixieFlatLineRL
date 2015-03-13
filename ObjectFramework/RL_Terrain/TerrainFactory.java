package ObjectFramework.RL_Terrain;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class TerrainFactory {

    public TerrainFactory() {}

    public GameEntity createTerrain(String terrain) {

        GameEntity newTerrain = null;

        if (terrain.equals("corridor")) {
            newTerrain = new GameEntity((new CorridorRenderComponent()));
            newTerrain.setClippable(true);
        }

        if (terrain.equals("dirt")) {
            newTerrain = new GameEntity((new DirtRenderComponent()));
            newTerrain.setClippable(true);
        }

        if (terrain.equals("door")) {
            newTerrain = new GameEntity((new DoorRenderComponent()));
            newTerrain.setClippable(true);
        }

        if (terrain.equals("downstairs")) {
            newTerrain = new GameEntity((new DownStairsRenderComponent()));
            newTerrain.setClippable(true);
        }

        if (terrain.equals("floor")) {
            newTerrain = new GameEntity((new FloorRenderComponent()));
            newTerrain.setClippable(true);
        }

        if (terrain.equals("stonewall")) {
            newTerrain = new GameEntity((new StoneWallRenderComponent()));
        }

        if (terrain.equals("townwall")) {
            newTerrain = new GameEntity((new TownWallRenderComponent()));
        }

        if (terrain.equals("upstairs")) {
            newTerrain = new GameEntity((new UpStairsRenderComponent()));
            newTerrain.setClippable(true);
        }

        if (terrain.equals("vertwall")) {
            newTerrain = new GameEntity((new VertWallRenderComponent()));
        }

        if (terrain.equals("wall")) {
            newTerrain = new GameEntity((new WallRenderComponent()));
        }

        if (terrain.equals("unused")) {
            newTerrain = new GameEntity((new UnusedRenderComponent()));
        }
        return newTerrain;
    }
}
