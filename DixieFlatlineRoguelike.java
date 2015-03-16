import ObjectFramework.General.EntityMapGenerator;
import ObjectFramework.General.EntityModel;
import ObjectFramework.General.MapView;

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
        MapView swingCSI = MapView.instance();
        EntityMapGenerator generator = EntityMapGenerator.instance();

        generator.setMapValues(MAPXSIZE, MAPYSIZE, NUMOFOBJECTS, NUMOFACTORS);
        model.addMap(generator.generateMap("town"));
        model.addMap(generator.generateMap("cave"));
        model.changeMap(0);

        swingCSI.printMapToScreen(model.getRegion(0, 0, 79, 24));
    }
}
