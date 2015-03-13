import ObjectFramework.General.EntityController;
import ObjectFramework.General.EntityMapGenerator;
import ObjectFramework.General.EntityModel;
import ObjectFramework.General.TerrainController;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class DixieFlatlineRoguelike {

    public static void main(String[] args) {

        initialize();
    }

    public static void initialize() {
        EntityModel model = new EntityModel();

        EntityMapGenerator generator = new EntityMapGenerator(EntityController.instance(), TerrainController.instance());

        generator.setMapValues(50,60,100,10);// x, y, numOfObjects, numOfActors
        model.addMap(generator.generateMap("town"));
        model.addMap(generator.generateMap("cave"));

    }
}
