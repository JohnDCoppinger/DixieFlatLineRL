import java.util.Random;
import java.util.*;

/**
 * Created by bcoll_000 on 2/19/2015.
 */
abstract class MapGenerator
{
    public int _xsize;
    public int _ysize;
    private long oldseed = 0;

    public int _objects;

    final public int CHANCEROOM = 75;

    protected char[][] _Map;

    public abstract void createMap(int x, int y, int objects);
    public abstract String showMap();

    public abstract void setCell(int x, int y, char cellType);
    public abstract char getCell(int x, int y);
    public abstract char[][] getMap();

    public int getRand(int min, int max)
    {
        Date now = new Date();
        long seed = now.getTime() + oldseed;
        oldseed = seed;

        Random gen = new Random(seed);
        int n = max - min + 1;
        int i = gen.nextInt(n);
        if (i < 0) i = -i;

        //System.out.println("seed: " + seed + "\tnum:  " + (min + i));
        return min + i;
    }


}
