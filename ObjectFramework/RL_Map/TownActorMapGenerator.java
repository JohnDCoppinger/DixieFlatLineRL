package ObjectFramework.RL_Map;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class TownActorMapGenerator extends ActorMapGenerator
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
    private char DOOR = 'D';
    private char HERO = '@';
    private char FLOOR = ',';


    public TownActorMapGenerator(char[][] map, int numObjects)
    {
        _map = map;
        _numObjects = numObjects;
    }

    @Override
    public char[][] createEntityMap()
    {
        boolean heroPlace = false;
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
                else if(_map[x][y] == DOOR)
                    ret[x][y] = DOOR;
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

        while(!heroPlace)
        {
            int x = getRand(0,_map.length-1);
            int y = getRand(0, _map[0].length-1);

            if(_map[x][y] == FLOOR)
            {
                PathFinder find = new AStarPathFinder(_map,x,y,xStairsUp,yStairsUp,_map.length,_map[0].length);

                if(find.hasPath())
                {
                    placeHero(x, y, ret);
                    heroPlace = true;
                }
            }
        }
        return ret;
    }

    private void placeHero(int x, int y, char[][] ret)
    {
        ret[x][y] = HERO;
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
