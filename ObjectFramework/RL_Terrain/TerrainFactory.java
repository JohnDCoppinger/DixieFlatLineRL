package ObjectFramework.RL_Terrain;

import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class TerrainFactory {

    public TerrainFactory() {}

    public GameEntity createTerrain(String terrain) {

        GameEntity newTerrain = new GameEntity();

        if (terrain.equals("corridor")) {
            newTerrain.setRender(new CorridorRenderComponent());
            newTerrain.setClippable(true);
        }

        if (terrain.equals("door")) {
            newTerrain.setRender(new DoorRenderComponent());
            newTerrain.setClippable(true);
        }

        if (terrain.equals("downstairs")) {
            newTerrain.setRender(new DownStairsRenderComponent());
            newTerrain.setClippable(true);
        }

        if (terrain.equals("floor")) {
            newTerrain.setRender(new FloorRenderComponent());
            newTerrain.setClippable(true);
        }

        if (terrain.equals("stonewall")) {
            newTerrain.setRender(new StoneWallRenderComponent());
        }

        if (terrain.equals("townwall")) {
            newTerrain.setRender(new TownWallRenderComponent());
        }

        if (terrain.equals("upstairs")) {
            newTerrain.setRender(new UpStairsRenderComponent());
            newTerrain.setClippable(true);
        }

        if (terrain.equals("vertwall")) {
            newTerrain.setRender(new VertWallRenderComponent());
        }

        if (terrain.equals("wall")) {
            newTerrain.setRender(new WallRenderComponent());
        }

        if (terrain.equals("unused")) {
            newTerrain.setRender(new UnusedRenderComponent());
        }
        return newTerrain;
    }
}
