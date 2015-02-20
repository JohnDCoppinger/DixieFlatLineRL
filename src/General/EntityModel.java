package General;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class EntityModel {

    private Renderable[][][] entityMap;
    int currentLayer;

    private EntityModel(int height, int width, int layers) {

        this.entityMap = new Renderable[layers][height][width];
    }
}
