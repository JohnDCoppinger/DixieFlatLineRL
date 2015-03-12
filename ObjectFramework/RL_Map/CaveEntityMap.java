/**
 * Created by bcoll_000 on 3/11/2015.
 */
public class CaveEntityMap extends EntityMap
{
    private char[][] _map;
    private int _numObjects;
    private char STAIRSUP = '>';
    private char STAIRDOWN = '<';
    private char MONSTER = 'M';
    private char CHEST = 'C';
    private char TRAPS = 'T';
    private char UNUSED = ' ';
    private char DIRT = '.';


    public CaveEntityMap(char[][] map, int numObjects)
    {
        _map = map;
        _numObjects = numObjects;
    }

    @Override
    char[][] createEntityMap()
    {
        int xStairsUp = 0;
        int yStairsUp = 0;

        char[][] ret = new char[_map.length][_map[0].length];

        for(int x = 0; x < _map.length; x ++)
            for(int y = 0; y < _map[0].length; y++)
            {
                if(_map[x][y] == STAIRSUP)
                {
                    xStairsUp = x;
                    yStairsUp = y;
                    ret[x][y] = STAIRSUP;
                }
                else if(_map[x][y] == STAIRDOWN)
                    ret[x][y] = STAIRDOWN;
                else
                    ret[x][y] = UNUSED;
            }
        int objects = _numObjects;

        if(objects < 0)
            objects = 10;

        while(objects > 0)
        {
            int x = getRand(0,_map.length-1);
            int y = getRand(0, _map[0].length-1);

            if(_map[x][y] == DIRT)
            {
                PathFinder find = new AStarPathFinder(_map,x,y,xStairsUp,yStairsUp,_map.length,_map[0].length);
                if(find.hasPath())
                {
                    placeObject(x, y, ret);
                    objects--;
                }
            }
        }

        return ret;
    }

    private void placeObject(int x, int y, char[][] ret)
    {
        int object = getRand(0,10);

        if(object == 10)
            ret[x][y] = CHEST;
        else if(object > 7)
            ret[x][y] = TRAPS;
        else
            ret[x][y] = MONSTER;
    }
}
