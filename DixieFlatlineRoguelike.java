import ObjectFramework.General.*;
import ObjectFramework.RL_Actors.ActionManager;
import ObjectFramework.RL_Actors.Actor;
import ObjectFramework.RL_Actors.Player.PlayerActionManager;

/**
 * Created by Gallanoth on 3/12/2015.
 */
public class DixieFlatlineRoguelike {

    private static int MAPXSIZE = 50;
    private static int MAPYSIZE = 60;
    private static int NUMOFOBJECTS = 60;
    private static int NUMOFACTORS = 10;

    public static void main(String[] args) {

        ActionQueue queue = ActionQueue.instance();

        initialize();

        while(true) {

            while(!queue.isEmpty())
                queue.poll().performActions();

            EntityController.instance().populateQueue();
        }
    }

    public static void initialize() {

        EntityModel model = new EntityModel();

        EntityMapGenerator generator = EntityMapGenerator.instance();
        generator.setMapValues(MAPXSIZE, MAPYSIZE, NUMOFOBJECTS, NUMOFACTORS);

        model.addMap(generator.generateMap("town"));
        //town add actors
        model.addMap(generator.generateMap("cave"));
        //cave add actors
        model.addMap(generator.generateMap("Dungeon"));
        //dungeon add actors
        model.changeMap(0);

        PlayerActionManager player = createPlayer();

        EntityController.instance().setModel(model);

        MapView swingCSI = MapView.instance();
        EntityController.instance().registerModel(swingCSI);
        swingCSI.printMapToScreen(model.getRegion(0, 0, 79, 24));
    }

    public static PlayerActionManager createPlayer() {

        //TODO logic for creating custom player characters

        PlayerActionManager manager = new PlayerActionManager();
        Actor playerActor = new Actor("Demo", 10, manager);
        EntityController.instance().registerActor(playerActor);

        manager.setClient(playerActor);

        return manager;
    }
}
