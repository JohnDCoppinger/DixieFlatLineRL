package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

import java.util.Observable;

/**
 * Created by Gallanoth on 2/26/2015.
 */
public class EntityMap extends Observable{

    private GameEntity[][] map;
    private int rows;
    private int cols;

    private EntityMap() {}

    private EntityMap(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.map = new GameEntity[rows][cols];
    }

    public GameEntity getEntity(int row, int col) {

        if (row > this.rows || col > this.cols) {
            throw new IndexOutOfBoundsException();
        }

        return map[row][col];
    }

    public void changeEntity(int row, int col, GameEntity newEntity) {

        if (row > this.rows || col > this.cols) {
            throw new IndexOutOfBoundsException();
        }

        if (newEntity == null) {
            throw new NullPointerException();
        }

        map[row][col] = newEntity;
    }

    public static EntityMap createMap(char map[][]) {

        //TODO Map Interpreter
        // creates the map from the array of characters from the generation algorithm

        return null;
    }

    public int rows() {

        return this.rows;
    }

    public int cols() {

        return this.cols;
    }

    public GameEntity[][] getRegion(int startX, int startY, int endX, int endY) {

        GameEntity[][] subregion = null;

        int     lrbound = 0,
                urbound = 0,
                lcbound = 0,
                ucbound = 0;

        if (endX - startX > 0 && endY - startY > 0)
            subregion = new GameEntity[endY - startY][endX - startX];

        else
            throw new IndexOutOfBoundsException();


        if (startY < 0)
            lrbound = 0;

        if (endY < startY)
            urbound = startY;

        if (endY > this.rows)
            urbound = this.rows;

        if (startX < 0)
            lcbound = 0;

        if (endX < startX)
            ucbound = startX;

        if (endX > this.cols)
            ucbound = this.cols;

        for (int i = 0; i < endY - startY; i ++) {

            for(int j = 0; j < endX - startX; j++) {

                if (i > lrbound && j > lcbound && i < urbound && i < ucbound)
                    subregion[i][j] = map[i][j];

                else
                    subregion[i][j] = null;
            }
        }

        return subregion;
    }
}
