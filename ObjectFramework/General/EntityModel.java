package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Notes about this class for building:
 * Tracks dirty region of map
 * Is observable, can be observed by the View and other things if appropriate
 * The model is responsible for enforcing boundaries! Entity Map can throw errors, don't let it.
 * The errors are mostly to see if something is going horribly wrong somewhere.
 * Created by Gallanoth on 2/19/2015.
 */
public class EntityModel extends Observable {

        private static EntityModel model = null;

    private ArrayList<Observer> subscribers;
    private ArrayList<EntityMap> entityMap;
    private EntityMap currentMap;
    private EntityMap previousMap;

    private int lbDirtyX;
    private int lbDirtyY;
    private int ubDirtyX;
    private int ubDirtyY;

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
        this.clean();
        return currentMap;
    }

    public void changeMap(EntityMap map) {

        int mapNo;

        if (map == null)
            throw new NullPointerException();

        if ((mapNo = entityMap.indexOf(map)) == -1)
            throw new MapDoesNotExistException();


        this.currentMap = map;
        this.clean();
    }

    public void changeToPrevMap() {

        if (previousMap == null)
            return;

        EntityMap temp = currentMap;
        currentMap = previousMap;
        previousMap = temp;

        this.clean();
    }

    public GameEntity getEntity(int x, int y) {

        if (x > this.currentMap.rows() || y > this.currentMap.cols() || x < 0 || y < 0)
            return null;

        return this.currentMap.getEntity(x, y);
    }

    public GameEntity swapEntity(int x, int y, GameEntity newEntity) {

        if (x > this.currentMap.rows() || y > this.currentMap.cols() || x < 0 || y < 0)
            return null;

        this.setDirty(x, y);
        return this.currentMap.swapEntity(x, y, newEntity);
    }

    public void moveEntity(int x, int y, GameEntity moving) {

        if (x > this.currentMap.rows() || y > this.currentMap.cols() || x < 0 || y < 0 || moving == null)
            return;

        this.setDirty(x, y);
        this.currentMap.moveEntity(x, y, moving);

    }

    public GameEntity[][] getRegion(int startx, int starty, int endx, int endy) {

        return this.currentMap.getRegion(startx, starty, endx, endy);
    }

    //TODO
    private void updateSubscribers() {

        if (!this.hasChanged())
            return;

        for (Observer o : subscribers) {

            o.update(this, null);
        }
    }

    private void clean() {

        this.lbDirtyX = Integer.MAX_VALUE;
        this.lbDirtyY = Integer.MAX_VALUE;
        this.ubDirtyX = 0;
        this.ubDirtyY = 0;
    }

    private void setDirty(int x, int y) {

        if (x < lbDirtyX)
            lbDirtyX = x;

        if (x > ubDirtyX)
            ubDirtyX = x;

        if (y < lbDirtyY)
            lbDirtyY = y;

        if (y > ubDirtyY)
            ubDirtyY = y;
    }


}
