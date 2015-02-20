package ObjectFramework.General;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class MapModel {

    private Renderable[][][] terrainMap;
    int currentLayer;

    private MapModel(int height, int width, int layers) {

        this.terrainMap = new Renderable[layers][height][width];
    }
}
