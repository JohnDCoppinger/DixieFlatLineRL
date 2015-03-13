package ObjectFramework.General;

import ObjectFramework.Entity.GameEntity;

import java.util.Observable;

/**
 * Created by Gallanoth on 2/26/2015.
 */
public class EntityMap {

    private GameEntity[][] map;
    private int rows;
    private int cols;

    private EntityMap() {}

    private EntityMap(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.map = new GameEntity[rows + 1][cols + 1];
    }

    public GameEntity getEntity(int row, int col) {

        if (row > this.rows || col > this.cols) {
            throw new IndexOutOfBoundsException();
        }

        return map[row][col];
    }

    /**
     * This method swaps out a current entity out for a newly specified one. Returns null if the space was empty.
     * ABSOLUTELY needs to change the beneath, x, and y out of the previous game entity
     * @param row
     * @param col
     * @param newEntity
     */
    public GameEntity swapEntity(int row, int col, GameEntity newEntity) {

        if (row > this.rows || col > this.cols) {
            throw new IndexOutOfBoundsException();
        }

        GameEntity old = map[row][col];
        map[row][col] = newEntity;

        if (old != null && newEntity != null) {

            GameEntity temp;
            int xtemp, ytemp, leveltemp;

            temp = newEntity.getBeneath();
            xtemp = newEntity.getX();
            ytemp = newEntity.getY();
            leveltemp = newEntity.getLevel();

            newEntity.setBeneath(old.getBeneath());
            newEntity.setX(old.getX());
            newEntity.setY(old.getY());
            newEntity.setLevel(old.getLevel());

            old.setBeneath(temp);
            old.setX(xtemp);
            old.setY(ytemp);
            old.setLevel(leveltemp);
        }

        return old;
    }

    /**
     * Should move the GameEntity passed in to the specified location. It removes the Entity from it's old position,
     * restores the entity beneath it into the array. If the new location has another entity, stores that entity beneath
     * "mover", assigns the entity to the new position, then sets the internals of the Game Entity to reflect its position
     *
     * @param row
     * @param col
     * @param mover
     */
    public void moveEntity(int row, int col, GameEntity mover) {

        if (row > this.rows || col > this.cols) {

            throw new IndexOutOfBoundsException();
        }

        if (mover == null) {

            throw new NullPointerException();
        }

        if (mover.getBeneath() != null) {

            map[mover.getX()][mover.getY()] = mover.getBeneath();
        }

        else {

            map[mover.getX()][mover.getY()] = null;
        }

        if (map[row][col] != null) {

            mover.setBeneath(map[row][col]);
        }

        map[row][col] = mover;
        mover.setX(row);
        mover.setY(col);

    }

    public static EntityMap createMap(char map[][]) {

        //TODO Map Interpreter
        // creates the map from the array of characters from the geneation algorithm

        return null;
    }

    public int rows() {

        return this.rows;
    }

    public int cols() {

        return this.cols;
    }

    /**
     * This method returns a sub-region of the current map, usually the "dirty" parts. The function takes in
     * the bounding variables, creates an array of the same size as requested (allows for blank cushioning space)
     * it then sets the bounds to be what they need to be to copy over the subsection of the entity map into the
     * appropriate spaces. Should always return a 2d array of game entities, though it is certainly possible to
     * give back an array of size 0;
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return
     */
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
