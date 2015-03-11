/**
 * Created by bcoll_000 on 2/28/2015.
 */
public class CaveGenerator extends MapGenerator
{
    private char UNUSED = ' ';
    private char WALL = '-';
    private char VERTWALL = '|';
    private char FLOOR = '.';
    private char STONEWALL = 'O';
    private char CORRIDOR = '#';
    private char DOOR = 'D';
    private char UPSTAIRS = '>';
    private char DOWNSTAIRS = '<';

    private int SMOOTHNESS = 5;
    private int WALLCHANCE = 35;
    private char[][] tempMap;

    private int _xsize;
    private int _ysize;
    private int _objects;

    @Override
    public void createMap(int xMap, int yMap, int objects)
    {
        if (objects < 1)
            _objects = 10;
        else
            _objects = objects;

        if (xMap < 3)
            _xsize = 3;
        else
            _xsize = xMap;

        if (yMap < 3)
            _ysize = 3;
        else
            _ysize = xMap;

        _Map = new char[_xsize][_ysize];


        randomFill();

        for(int i = 0; i < SMOOTHNESS; i ++)
        {
            _Map = placeWalls();
            makeBorder();

        }


    }

    private void addStairs()
    {

    }

    private void findStairPath()
    {

    }

    private void randomFill()
    {
        int mapPath;

        for (int y = 0; y < _ysize; y++)
            for (int x = 0; x < _xsize; x++) {
                //Randomly place a wall or a path to prevent unreachable caves
                mapPath = _xsize / 2;

                if (x == mapPath)
                    setCell(x, y, FLOOR);
                else {
                    if (getRand(0, 100) < WALLCHANCE)
                        setCell(x, y, STONEWALL);
                    else
                        setCell(x, y, FLOOR);
                }
            }
        makeBorder();
    }

    private void makeBorder()
    {
        for (int y = 0; y < _ysize; y++)
            for (int x = 0; x < _xsize; x++) {
                //ie, making the borders of unwalkable walls
                if (y == 0)
                    setCell(x, y, STONEWALL);
                else if (y == _ysize - 1)
                    setCell(x, y, STONEWALL);
                else if (x == 0)
                    setCell(x, y, STONEWALL);
                else if (x == _xsize - 1)
                    setCell(x, y, STONEWALL);
            }
    }

    private char[][] placeWalls()
    {
        char[][] newMap = new char[_xsize][_ysize];

        for (int x = 0; x < _xsize - 1; x++)
            for (int y = 0; y < _ysize - 1; y++)
            {
                int numWalls = GetAdjacentWalls(x,y,1,1);

                if (getCell(x, y) == STONEWALL)
                {
                    if (numWalls >= 5)
                        newMap[x][y] = STONEWALL;//setCell(x, y, STONEWALL);
                    else if (numWalls < 2)
                        newMap[x][y] = FLOOR;//setCell(x, y, FLOOR);
                    else
                        newMap[x][y] = getCell(x,y);
                }
                else
                {
                    if (numWalls >= 5)
                        newMap[x][y] = STONEWALL;//setCell(x, y, STONEWALL);
                    else
                        newMap[x][y] = FLOOR;
                }
            }
        return newMap;
    }

    public int GetAdjacentWalls(int x,int y,int scopeX,int scopeY)
    {
        int startX = x - scopeX;
        int startY = y - scopeY;
        int endX = x + scopeX;
        int endY = y + scopeY;

        int wallCounter = 0;

        for(int iY = startY; iY <= endY; iY++) {
            for(int iX = startX; iX <= endX; iX++)
                if (!(iX == x && iY == y))
                    if (IsWall(iX, iY))
                        wallCounter += 1;
        }
        return wallCounter;
    }

    boolean IsWall(int x, int y)
    {
        // Consider out-of-bound a wall
        if( IsOutOfBounds(x,y) )
        {
            return true;
        }

        if( getCell(x,y) == STONEWALL	 )
        {
            return true;
        }

        if( getCell(x,y)== FLOOR )
        {
            return false;
        }
        return false;
    }

    boolean IsOutOfBounds(int x, int y)
    {
        if( x < 0 || y < 0 )
        {
            return true;
        }
        else if( x >_xsize - 1 || y >_ysize - 1 )
        {
            return true;
        }
        return false;
    }



    @Override
    public String showMap()
    {
        String ret = "";
        for(int x = 0; x < _xsize; x++)
        {
            ret += "\n";
            for(int y = 0; y < _ysize; y++)
                ret += _Map[x][y] + " ";

        }
        return ret;
    }
    @Override
    public void setCell(int x, int y, char cellType)
    {
        _Map[x][y] = cellType;
    }

    @Override
    public char getCell(int x, int y)
    {
        return _Map[x][y];
    }

    @Override
    public char[][] getMap()
    {
        return _Map;
    }

}
