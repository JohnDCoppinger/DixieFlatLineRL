package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

import java.util.ArrayList;

/**
 * Created by Gallanoth on 2/19/2015.
 */
public class EntityModel {

    private static EntityModel model = null;

    private ArrayList<EntityMap> entityMap;
    private EntityMap currentMap;
    private EntityMap previousMap;

    private EntityModel() {

        this.entityMap = new ArrayList<EntityMap>();
    }

    public static EntityModel getInstance() {

        if (model == null)
            model = new EntityModel();

        return model;
    }

    public void addMap(EntityMap newMap) {

        if (newMap == null)
            throw new NullPointerException();

        this.entityMap.add(newMap);
    }

    public EntityMap changeMap(int mapNumber) {

        if (entityMap.size() < mapNumber)
            throw new IndexOutOfBoundsException();

        this.currentMap = entityMap.get(mapNumber);
        return currentMap;
    }

    public EntityMap changeMap(EntityMap map) {

        int mapNo;

        if (map == null)
            throw new NullPointerException();

        if ((mapNo = entityMap.indexOf(map)) == -1)
            throw new MapDoesNotExistException();


        this.currentMap = map;

        return this.currentMap;
    }

    public EntityMap changeToPrevMap() {

        EntityMap temp = currentMap;
        currentMap = previousMap;
        previousMap = temp;

        return currentMap;
    }

    public GameEntity getEntity(int x, int y) {

        return this.currentMap.getEntity(x, y);
    }

    public GameEntity changeEntity(int x, int y, GameEntity newEntity) {

        GameEntity old = this.currentMap.getEntity(x, y);

        this.currentMap.changeEntity(x, y, newEntity);
        return old;
    }

    public GameEntity[][] getRegion(int startx, int starty, int endx, int endy) {

        return this.currentMap.getRegion(startx, starty, endx, endy);
    }


}
