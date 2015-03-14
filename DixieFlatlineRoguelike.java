import ObjectFramework.General.EntityController;
import ObjectFramework.General.EntityMapGenerator;
import ObjectFramework.General.EntityModel;
import ObjectFramework.General.TerrainController;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class DixieFlatlineRoguelike {

    private static int MAPXSIZE = 50;
    private static int MAPYSIZE = 60;
    private static int NUMOFOBJECTS = 60;
    private static int NUMOFACTORS = 10;

    public static void main(String[] args) {

        initialize();
    }

    public static void initialize() {
        EntityModel model = new EntityModel();

        EntityMapGenerator generator = EntityMapGenerator.instance();

        generator.setMapValues(MAPXSIZE,MAPYSIZE,NUMOFOBJECTS,NUMOFACTORS);
        model.addMap(generator.generateMap("town"));
        model.addMap(generator.generateMap("cave"));

    }
}
